(ns day04
  (:require [clojure.string :as str]
            [lib :refer :all]))

(defn contains
  [[[a-start a-end] [b-start b-end]]]
  (or (and (<= a-start b-start)
           (>= a-end b-end))
      (and (<= b-start a-start)
           (>= b-end a-end))))

(defn in-range
  [[start end] x]
  (and (>= x start) (<= x end)))

(defn overlaps
  [[[a-start a-end :as a] [b-start b-end :as b]]]
  (or (in-range b a-start)
      (in-range b a-end)
      (in-range a b-start)
      (in-range a b-end)))

(defn parse-pairs
  [input]
  (->> (parse-longs input) (partition 2) (partition 2)))

(defn part-a
  [input]
  (->> (parse-pairs input)
       (filter contains)
       count))

(comment
  (part-a (read-input "day04")))

(defn part-b
  [input]
  (->> (parse-pairs input)
       (filter overlaps)
       count))

(comment
  (part-b (read-input "day04")))
