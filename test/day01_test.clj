(ns day01-test
  (:require [clojure.test :refer :all]
            day01
            [lib :refer :all]))

(deftest day01-test
  (let [input (read-example "day01")]
    (is (= (day01/part-a input) 24000))
    (is (= (day01/part-b input) 45000))))
