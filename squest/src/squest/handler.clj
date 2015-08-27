(ns squest.handler
  (:require
    [compojure.core :refer :all]
    [compojure.route :as route]
    [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
    [noir.response :as resp]
    [noir.session :as sess]
    [selmer.parser :refer [render-file]]))

(defn homepage
  []
  (render-file "template/index.html"
               {:hello "Jon!"}))

(defroutes
  app-routes
  (GET "/" []
       (do (println "Normal service has been resumed")
           (homepage)))
  (route/not-found "Nothing to see here dude"))

(def app
  (wrap-defaults app-routes site-defaults))
