(ns org.daniloandjelic.queues.test.queues
  (:use org.daniloandjelic.queues.queues)
  (:use clojure.test))
 
(deftest
  test-queues-msg
  (is (= (exclaim)
         "This is Banking queues management application!")))