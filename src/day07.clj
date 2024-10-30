(ns day07
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [lib :refer :all]))

(defn root-path
  []
  (-> (io/file "/") (.toPath)))

(defn parse
  [input]
  (->> (split-lines input)
       (map split-words)
       (reduce (fn [[fs cwd] [one two three]]
                 (cond (and (= one "$") (= two "cd")) [fs (.resolve cwd three)]
                       (re-find #"^\d" one)
                         (let [k (-> (.resolve cwd two) (.normalize) str)
                               v (Long/parseLong one)]
                           [(assoc fs k v) cwd])
                       :else [fs cwd]))
         [{} (root-path)])
       first))

(def input (read-example "day07"))

(defn ->parents
  [s]
  (let [p (-> (io/file s) (.toPath))
        paths (take-while some? (iterate #(.getParent %) p))]
    (map str (rest paths))))

(defn dir-sizes
  [fs]
  (->> fs
       (mapcat (fn [[filename size]]
                 (map #(vector % size) (->parents filename))))
       (reduce (fn [ds [dirname size]] (update ds dirname #(+ size (or % 0))))
         {})))

(defn part-a
  [input]
  (let [fs (parse input)
        ds (dir-sizes fs)]
    (->> ds
         (keep (fn [[_ v]] (when (<= v 100000) v)))
         (apply +))))

(comment
  (let [input (read-input "day07")]
    (part-a input)))

(defn part-b
  [input]
  (let [fs (parse input)
        ds (dir-sizes fs)
        total-space 70000000
        free-space (- total-space (get ds "/"))
        needed-space (- 30000000 free-space)]
    (->> ds
         (keep (fn [[_ v]] (when (>= v needed-space) v)))
         (apply min))))

(comment
  (let [input (read-input "day07")]
    (part-b input)))
