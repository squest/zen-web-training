(ns baelish.routes
  (:require
    [compojure.core :refer [defroutes routes GET POST]]
    [compojure.route :as route]
    [baelish.pages :as page]
    ))

(def all-routes
  (routes
    (GET "/" [request]
         (page/home))
    (GET "/cute" [request]
         "CUTIEEEEEE")))
