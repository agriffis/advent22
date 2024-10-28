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
  (str/split (str/trim-newline s) #"\n\n+"))

(defn split-lines
  [s]
  (str/split-lines s))

(defn split-words
  [s]
  (re-seq #"\S+" s))

(defn parse-longs
  [s]
  (->> (re-seq #"\d+" s) (map Long/parseLong)))

(defn sum
  [xs]
  (reduce + xs))
