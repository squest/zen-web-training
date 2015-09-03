(ns beleje.scratchpad
  (:require
    [clojure.string :as cs]
    [clojure.edn :as edn]))

(defn anjing
  [x]
  (+ x x))

(defn take-comma-from-num
  [n]
  (read-string (cs/join (cs/split n #","))))

(defn take-pair
  [xs]
  (->> xs
       (map #(cs/split % #"\""))
       (filter #(= 2 (count %)))))

(defn somfin
  []
  (->> (slurp "resources/20152016sessions.csv")
       (cs/split-lines)
       (drop 7)
       (mapv #(cs/split % #"\""))
       (mapv second)
       (mapv #(cs/replace % #"," ""))
       (mapv read-string)))