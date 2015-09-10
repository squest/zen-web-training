(ns day1.stat
  (:require
    [clojure.string :as cs]
    [clojure.edn :as edn]))

(defn ganti [a res prob]
  (cs/replace prob a res))

(defn gantilist
  ([a res prob] (gantilist a res prob []))
  ([a res prob ans]
   (if (empty? prob) ans
                     (recur a res (rest prob) (conj ans (ganti a res (first prob)))))))

(def soal
  (->> (slurp "resources/trafficraw.csv")
       (cs/split-lines)
       (drop 7)
       (gantilist #"\"" " ")
       (gantilist #"," "")))

(def answer
  (->> (butlast soal)))