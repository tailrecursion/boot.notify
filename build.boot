#!/usr/bin/env boot

#tailrecursion.boot.core/version "2.0.0"

(set-env!
 :project      'tailrecursion/boot.notify
 :version      "2.0.0"
 :dependencies '[[tailrecursion/boot.core "2.0.0"]
                 [tailrecursion/boot.task "2.0.0"]
                 [javazoom/jlayer "1.0.1"]]
 :src-paths    #{"src"})

(require
 '[tailrecursion.boot.task  :refer :all])
