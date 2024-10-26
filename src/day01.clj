(ns day01
  (:require [clojure.string :as str]
            [lib :refer :all]))

(defn parse
  [input]
  (let [inputs (str/split input #"\n\n")]
    (map parse-longs inputs)))

(defn part-a
  [input]
  (->> (parse input) (map sum) (apply max)))

(defn part-b
  [input]
  (->> (parse input) (map sum) (sort >) (take 3) sum))

(comment
  (let [input (read-input "day01")]
    [(part-a input) (part-b input)]))
