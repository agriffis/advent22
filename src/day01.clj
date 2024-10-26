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

(comment
  (part-a (read-input "day01")))

(defn part-b
  [input]
  (->> (parse input) (map sum) (sort >) (take 3) sum))

(comment
  (part-b (read-input "day01")))
