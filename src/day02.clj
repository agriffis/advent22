(ns day02
  (:require [clojure.string :as str]
            [lib :refer :all]))

(defn parse
  [input]
  (let [squish (-> input str/trim (str/replace " " ""))]
    (->> (str/split squish #"\n") (map keyword))))

(def rock 1)
(def paper 2)
(def scissors 3)
(def lose 0)
(def draw 3)
(def win 6)

(defn part-a
  [input]
  (let [scores {:AX (+ rock draw)
                :AY (+ paper win)
                :AZ (+ scissors lose)
                :BX (+ rock lose)
                :BY (+ paper draw)
                :BZ (+ scissors win)
                :CX (+ rock win)
                :CY (+ paper lose)
                :CZ (+ scissors draw)}]
    (->> (parse input) (map scores) sum)))

(defn part-b
  [input]
  (let [scores {:AX (+ lose scissors)
                :AY (+ draw rock)
                :AZ (+ win paper)
                :BX (+ lose rock)
                :BY (+ draw paper)
                :BZ (+ win scissors)
                :CX (+ lose paper)
                :CY (+ draw scissors)
                :CZ (+ win rock)}]
    (->> (parse input) (map scores) sum)))

(comment
  (let [input (read-input "day02")]
    [(part-a input) (part-b input)]))
