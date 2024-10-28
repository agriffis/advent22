(ns day05-test
  (:require [clojure.test :refer :all]
            day05
            [lib :refer :all]))

(deftest day05-test
  (let [input (read-example "day05")]
    (is (= (day05/part-a input) "CMZ"))
    (is (= (day05/part-b input) "MCD"))
    ))
