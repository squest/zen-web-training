(ns zpmock1.routes
  (:require
    [compojure.core :refer [routes GET POST context]]
    [compojure.route :refer [not-found resources]]
    [zpmock1.core-components :as components]
    [zpmock1.landing :as land]
    [zpmock1.DPpage :as dp]
    [zpmock1.home :as home]))

(defn all-routes
  []
  (routes
    (GET "/" req (land/land))
    (GET "/home" req (land/land))
    (GET "/quiz" req (dp/do-quiz))
    (GET "/scored" req (dp/scored-DP))
    (GET "/scored2" req (dp/scored-DP2))

    (GET "/student" req (home/student))


    (resources "public/")
    (not-found "Page not found.")))

