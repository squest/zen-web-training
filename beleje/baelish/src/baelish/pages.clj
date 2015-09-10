(ns baelish.pages
  (:require
    [selmer.parser :refer [render-file]]))

(defn home
  []
  (render-file "html/base.html" {}))
