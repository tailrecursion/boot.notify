#!/usr/bin/env boot

#tailrecursion.boot.core/version "2.3.1"

(set-env!
 :project      'tailrecursion/boot.notify
 :version      "2.0.1"
 :dependencies '[[tailrecursion/boot.core "2.3.1"]
                 [tailrecursion/boot.task "2.1.3"]
                 [javazoom/jlayer "1.0.1"]]
 :src-paths    #{"src"})

(require
 '[tailrecursion.boot.task  :refer :all])
