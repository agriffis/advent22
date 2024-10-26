(ns day02-test
  (:require [clojure.test :refer :all]
            day02
            [lib :refer :all]))

(deftest day02-test
  (let [input (read-example "day02")]
    (is (= (day02/part-a input) 15))
    (is (= (day02/part-b input) 12))))
