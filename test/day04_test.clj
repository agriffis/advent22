(ns day04-test
  (:require [clojure.test :refer :all]
            day04
            [lib :refer :all]))

(deftest day04-test
  (let [input (read-example "day04")]
    (is (= (day04/part-a input) 2))
    (is (= (day04/part-b input) 4))
    ))
