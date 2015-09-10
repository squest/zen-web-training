(ns baelish.core
  (:require
    [org.httpkit.server :as http]
    [clojure.string :as cs]
    [baelish.routes :refer [all-routes]]
    [ring.middleware.defaults :as defaults]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(def app
  (-> all-routes
      (defaults/wrap-defaults defaults/site-defaults)))

(defonce server (atom nil))

(defn start
  []
  (reset! server (http/run-server app {:port 3000})))

(defn stop
  []
  (@server)
  (reset! server nil))

(defn reset
  []
  (stop)
  (start))

(defn -main
  [& args]
  (start))
