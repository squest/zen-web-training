(ns beleje.core
  (:require
    [beleje.scratchpad :as scratch]
    [clojure.string :as cs]
    [clojure.edn :as edn]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn open-edn
  [fname]
  (slurp (str "resources/" fname ".csv")))

(def my-data (cs/split-lines (open-edn "20152016sessions")))

(defn take-all-sessions
  [x]
  (->> x
       (map #(cs/split % #"\""))
       (filter #(= 2 (count %)))
       (map #(scratch/take-comma-from-num (second %)))))

(defn take-all-sessions2
  [x]
  (->> (scratch/take-pair x)
       (map #(scratch/take-comma-from-num (second %)))))