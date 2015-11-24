(ns zpmock1.routes
  (:require
    [compojure.core :refer [routes GET POST context]]
    [compojure.route :refer [not-found resources]]
    [zpmock1.mock :as mock]))

(defn all-routes
  []
  (routes
    (GET "/home" req (mock/home))
    (GET "/try" [id] (mock/try))

    (resources "public/")
    (not-found "Page not found.")))

