(ns day01
  (:require [clojure.string :as str]
            [lib :refer :all]))

(def input (slurp "inputs/day01"))

(defn parse
  [raw]
  (let [raws (str/split raw #"\n\n")]
    (map parse-longs raws)))

(defn part-a
  [raw]
  (->> (parse raw) (map sum) (apply max)))

(defn part-b
  [raw]
  (->> (parse raw) (map sum) (sort >) (take 3) sum))

(part-a input)

(part-b input)
