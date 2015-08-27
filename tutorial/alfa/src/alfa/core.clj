(ns alfa.core
  (:require
    [alfa.kokoro :as koko :refer [sqaure]]
    [alfa.stat.standard :as stat]
    [clojure.string :as cs]
    [clojure.set :as cset]
    [clojure.edn :as edn]
    [couchbase-clj.client :as cb]))

(defonce cbdb (cb/create-client
               {:bucket "znetroyalty"
                :uris   ["http://127.0.0.1:8091/pools"]}))

;; clojure.core -> standard library

(defn cbquery
  [cdb design view]
  (->> {:include-docs true}
       (cb/query cdb design view)
       (mapv cb/view-doc-json)))

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




