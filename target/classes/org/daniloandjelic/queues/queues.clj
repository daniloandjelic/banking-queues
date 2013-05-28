(ns org.daniloandjelic.queues.queues
  (:gen-class))
 
(defn exclaim []
      "This is Banking queues management application!")

(defn divider
  [x y]
  "function devides two numbers"
  (float (/ x y))
  (println "provided input is not valid - not number")
  )

(defn is-system-stabile
  "function returns true if system is stable, else false"
  [utilization-cefficient]
  (if (< utilization-cefficient 1)
    (true)
    (false)
    )
  )

(defn factorial
  [x]
  "function factorial calculation"
  (loop [multiplier x f 1]
    (if (= multiplier 1)
      f
      (recur (dec multiplier) (* f multiplier))
      )
    )
  )

(defn factorial
  [x]
  "function factorial calculation"
  (loop [multiplier x f 1]
    (if (= multiplier 1)
      f
      (recur (dec multiplier) (* f multiplier))
      )
    )
  )

(defn factorial-for-big-numbers [n]
  (reduce * (range 1 (inc n))))


(defn -main [& args] (println (exclaim)))