(ns website1.routes
  (:require
    [compojure.core :refer [routes GET POST context]]
    [compojure.route :refer [not-found resources]]
    [website1.mock :as mock]
    [website1.articles :as articles]))

(defn all-routes
  ([]
   (routes
     (GET "/" req (mock/home))
     (GET "/home" req (mock/home))
     (GET "/explanation" req (mock/explanation))

     (GET "/hello/:id" [id] (str "HellooUoo " id))

     (GET "/:id" [id] (articles/open id))

     (resources "public/")
     (not-found "Page not found."))))


