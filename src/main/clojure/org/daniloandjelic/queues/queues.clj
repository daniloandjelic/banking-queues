(ns org.daniloandjelic.queues.queues
  (:gen-class))
 
(defn exclaim []
      "This is Banking queues management application!")

;number of servers - initialy there is 1 server - S
(def number-of-servers (ref 1))
;utilization factor - RO
(def util-factor (ref 0))
;average client no in queue - Lq
(def avrg-client-no (ref 0))
;average number of clients in system (queues + servings) - L
(def avrg-clients-in-system (ref 0))
;average time that client spends in queue - Wq
(def avrg-client-queue-wait-time (ref 0))
;average time that client spends in system - W
(def avrg-client-time-in-system (ref 0))

(defn divider
        [x y]
        "function devides two numbers"
        (if (and (number? x) (number? y))
          (float (/ x y))
          (println "provided input is not valid - not number")
          )
        )

(defn exp [x n]
  "exponential function"
     (reduce * (repeat n x)))



(defn factorial
  [x]
  "function factorial calculation"
  (loop [multiplier x f 1]
    (if (= multiplier 1)
      f
      (recur (dec multiplier) (* f multiplier)))))


(defn factorial-for-big-numbers [n]
  (reduce * (range 1 (inc n))))

;S/S/1/ queues formulas

(defn calculation-aggregate-function
  "abstract function that calculates value and ref-set it to a var"
  [var p1 p2]
  (dosync (ref-set var (divider p1 p2))))

(defn is-system-stabile
  "function returns true if system is stable, else false"
  [utilization-cefficient]
  (if (< utilization-cefficient 1)
    (true)
    (false)))

(defn utilization-factor-calculator
     [lambda mi]
     (calculation-aggregate-function util-factor lambda mi))

(defn  avrg-client-no-in-queue-calculation
           "Function returns average client wait in queue"
           [util-factor]
           (calculation-aggregate-function avrg-client-no (exp util-factor 2) (- 1 util-factor)))

(defn avrg-client-in-system-calculation
  "function calculates average client number in queuing system"
  [util-factor]
  (calculation-aggregate-function avrg-clients-in-system util-factor (- 1 util-factor)))


(defn avrg-client-queue-wait-time-calculator
  "function calculates average client queue wait time"
  [avrg-client-no lambda]
  (calculation-aggregate-function avrg-client-queue-wait-time avrg-client-no lambda))

(defn avrg-client-time-in-system-calculator
  "function calculates average client time spent in system"
  [lambda mi]
  (calculation-aggregate-function avrg-client-time-in-system 1 (- mi lambda)))


(defn -main [& args] (println (exclaim)))