(ns zpmock1.routes
  (:require
    [compojure.core :refer [routes GET POST context]]
    [compojure.route :refer [not-found resources]]
    [zpmock1.core-components :as components]
    [zpmock1.landing :as land]
    [zpmock1.DPpage :as dp]))

(defn all-routes
  []
  (routes
    (GET "/" req (land/home))
    (GET "/home" req (land/home))
    (GET "/quiz" req (dp/do-quiz))


    (resources "public/")
    (not-found "Page not found.")))

