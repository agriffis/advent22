(ns lib
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn read-example
  [name]
  (slurp (io/resource (str "examples/" name))))

(defn read-input
  [name]
  (slurp (io/resource (str "inputs/" name))))

(defn parse-longs
  [s]
  (->> (str/split (str/trim s) #"\s+") (map Long/parseLong)))

(defn sum
  [xs]
  (reduce + xs))
