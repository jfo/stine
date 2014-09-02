(ns stine.core
  (:require 
  [overtone.live :as ot]))

(ot/definst sin-wave  [freq 0 attack 0 sustain 0 release 0 vol 0.6]
  (* (ot/env-gen (ot/lin attack sustain release) 1 1 0 1 ot/FREE)
     (ot/sin-osc freq)
     vol))

(defn tuning-note [x]
  (sin-wave x 0 0.1 2 0.1))

(defn saw-tooth-note [freq]
  (loop [note freq]
    (tuning-note note)
    (if (< freq 20000)
      (recur (* note 1.36))
      (println "whut"))))

(saw-tooth-note 5.5)

(ot/stop)
(tuning-note 440)
(tuning-note 880)
(tuning-note 1600)
(tuning-note 600)


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
