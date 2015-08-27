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
  (slurp (str "resources/" fname)))
