(ns website1.routes
  (:require
    [compojure.core :refer [routes GET POST context]]
    [compojure.route :refer [not-found resources]]
    [website1.mock :as mock]))

(defn all-routes
  []
  (routes
    (GET "/" req (mock/home))
    (resources "public/")
    (not-found "Page not found.")))