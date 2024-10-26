(ns lib
  (:require [clojure.string :as str]))

(defn parse-longs
  [s]
  (->> (str/split (str/trim s) #"\s+") (map Long/parseLong)))

(defn sum
  [xs]
  (reduce + xs))
