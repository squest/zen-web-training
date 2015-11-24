(ns zpmock1.routes
  (:require
    [compojure.core :refer [routes GET POST context]]
    [compojure.route :refer [not-found resources]]
    [zpmock1.core-components :as components]
    [zpmock1.landing :as land]

    [zpmock1.original :as ori]))

(defn all-routes
  []
  (routes
    (GET "/home" req (land/home))
    (GET "/try" [id] (ori/try))


    (resources "public/")
    (not-found "Page not found.")))

