(ns day03-test
  (:require [clojure.test :refer :all]
            day03
            [lib :refer :all]))

(deftest day03-test
  (let [input (read-example "day03")]
    (is (= (day03/part-a input) 157))
    (is (= (day03/part-b input) 70))))
