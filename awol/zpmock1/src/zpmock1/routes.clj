(ns zpmock1.routes
  (:require
    [compojure.core :refer [routes GET POST context]]
    [compojure.route :refer [not-found resources]]

    [zpmock1.page-landing :as groundzero]
    [zpmock1.page-dp :as quiz]
    [zpmock1.page-home :as main]))

(defn all-routes
  []
  (routes
    (GET "/" req (groundzero/land))
    (GET "/home" req (groundzero/land))
    (GET "/quiz" req (quiz/do-quiz))
    (GET "/scored" req (quiz/scored-DP))
    (GET "/scored2" req (quiz/scored-DP2))

    (GET "/student" req (main/student))


    (resources "public/")
    (not-found "Page not found.")))

