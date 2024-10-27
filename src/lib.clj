(ns lib
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn read-example
  [name]
  (slurp (io/resource (str "examples/" name))))

(defn read-input
  [name]
  (slurp (io/resource (str "inputs/" name))))

(defn split-paragraphs
  [s]
  (str/split (str/trim s) #"\n\n+"))

(defn split-lines
  [s]
  (str/split-lines (str/trim s)))

(defn parse-longs
  [s]
  (->> (re-seq #"\d+" s) (map Long/parseLong)))

(defn sum
  [xs]
  (reduce + xs))
