(ns day06
  (:require [clojure.string :as str]
            [lib :refer :all]))

(defn start?
  [n xs]
  (= n (count (set xs))))

(defn indicies
  [pred coll]
  (keep-indexed #(when (pred %2) %1) coll))

(defn part-a
  [input]
  (let [quads (partition 4 1 input)
        starts (indicies (partial start? 4) quads)]
    (+ 4 (first starts))))

(comment
  (let [input (read-input "day06")]
    (part-a input)))

(defn part-b
  [input]
  (let [quads (partition 14 1 input)
        starts (indicies (partial start? 14) quads)]
    (+ 14 (first starts))))

(comment
  (let [input (read-input "day06")]
    (part-b input)))

