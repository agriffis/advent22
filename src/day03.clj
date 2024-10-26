(ns day03
  (:require [clojure.set :as set]
            [clojure.string :as str]
            [lib :refer :all]))

(defn priority
  [c]
  (let [p (int c)]
    (if (>= p 97) (- p 96) (- p 38))))

(defn dup
  [a b]
  (first (set/intersection (set a) (set b))))

(defn part-a
  [input]
  (let [rucksacks (str/split (str/trim input) #"\n")
        compartments (map #(partition (/ (count %) 2) %) rucksacks)
        dups (map (partial apply dup) compartments)
        priorities (map priority dups)]
    (sum priorities)))

(comment
  (part-a (read-input "day03")))

(defn badge
  [group]
  (->> (map set group)
       (reduce set/intersection)
       first))

(defn part-b
  [input]
  (let [rucksacks (str/split (str/trim input) #"\n")
        groups (partition 3 rucksacks)
        badges (map badge groups)
        priorities (map priority badges)]
    (sum priorities)))

(comment
  (part-b (read-input "day03")))
