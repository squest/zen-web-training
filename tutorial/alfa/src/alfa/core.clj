(ns alfa.core
  (:require
    [alfa.kokoro :as koko :refer [sqaure]]
    [alfa.stat.standard :as stat]
    [clojure.string :as cs]
    [clojure.set :as cset]
    [clojure.edn :as edn]))

;; clojure.core -> standard library
;;

(defn open-edn
  [fname]
  (->> (slurp (str "resources/data/" fname ".edn"))
       (edn/read-string)))

(defn hash-this
  [x]
  (map sqaure (range 1 x)))

(defn cari-mean
  [xs]
  (stat/mean xs))




