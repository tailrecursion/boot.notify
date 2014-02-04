(ns tailrecursion.boot.task.notify
  (:require [tailrecursion.boot.core :refer [set-env! deftask]]
            [clojure.java.shell      :refer [sh]])
  (:import  java.io.File))

(defn play! [file]
  (-> (.getResourceAsStream (clojure.lang.RT/baseLoader) file)
      java.io.BufferedInputStream.
      javazoom.jl.player.Player.
      .play))

(defn warn! [n]
  (let [msg (str n "warning" (if (> n 1) "s"))]
    (cond
     (.exists (File. "/usr/bin/espeak"))
     (sh "espeak" "-v+f2" msg)
     (.exists (File. "/usr/bin/say"))
     (sh "say" "-v" "Vicki" msg)
     :else (play! "tailrecursion/boot/task/notify/warning.mp3"))))

(defmacro cljs-warnings
  [warnings & body]
  (try (require 'cljs.analyzer)
       `(cljs.analyzer/with-warning-handlers
          (conj cljs.analyzer/*cljs-warning-handlers*
                (fn [& _#] (swap! ~warnings inc)))
          ~@body)
       (catch Throwable _ `(do ~@body))))

(deftask hear
  "Plays an error sound if an exception is thrown downstream.
  Rethrows the exception. Otherwise, plays a success sound.  If
  ClojureScript is on the classpath, tries using espeak or say to
  announce the warning count.  If neither executable is found, plays a
  generic warning sound."
  [& {:keys [success failure]
      :or   {success "tailrecursion/boot/task/notify/success.mp3"
             failure "tailrecursion/boot/task/notify/failure.mp3"}}]
  (fn [continue]
    (fn [event]
      (try
        (let [warnings (atom 0)
              ret (cljs-warnings warnings (continue event))]
          (if (zero? @warnings)
            (play! success)
            (warn! @warnings))
          ret)
        (catch Throwable t
          (play! failure)
          (throw t))))))
