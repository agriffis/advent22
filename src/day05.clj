(ns day05
  (:require [clojure.string :as str]
            [lib :refer :all]
            [uncomplicate.neanderthal.core :as m]
            [uncomplicate.neanderthal.native :refer [native-long]]))

(defn ord
  [c]
  (if (= c \.) 0 (int c)))

(defn parse-stacks
  [input]
  (let [s (first (split-paragraphs input))
        ;; Make s into dense grid of letters and dots.
        s (-> s
              (str/replace #"(?m)(^   |    )" ".")
              (str/replace #"[^A-Z.\n]" ""))
        ;; Convert s to nested vector of ints.
        m (mapv #(mapv ord %) (split-lines s))
        ;; and then to matrix
        w (count (first m))
        h (count m)
        a (m/ge native-long w h m)]
    (mapv #(->> (drop-while zero? %)
                reverse
                (mapv char))
      (m/rows a))))

(defn parse-moves
  [input]
  (let [s (second (split-paragraphs input))
        moves (->> (parse-longs s)
                   (partition 3))]
    moves))

(defn executor
  [one-at-a-time]
  (fn [stacks [n from to]]
    (let [from-stack (get stacks (dec from))
          from-count (count from-stack)
          [from-stack items] (split-at (- from-count n) from-stack)
          from-stack (vec from-stack)
          items (if one-at-a-time (reverse items) items)
          to-stack (get stacks (dec to))
          to-stack (apply conj to-stack items)]
      (-> stacks
          (assoc (dec from) from-stack)
          (assoc (dec to) to-stack)))))

(defn part-a
  [input]
  (let [stacks (parse-stacks input)
        moves (parse-moves input)
        exec (executor true)
        result (reduce exec stacks moves)]
    (apply str (map last result))))

(comment
  (let [input (read-input "day05")]
    (part-a input)))

(defn part-b
  [input]
  (let [stacks (parse-stacks input)
        moves (parse-moves input)
        exec (executor false)
        result (reduce exec stacks moves)]
    (apply str (map last result))))

(comment
  (let [input (read-input "day05")]
    (part-b input)))
