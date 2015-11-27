(ns zpmock1.core
  (:require
    [org.httpkit.server :as http]
    [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
    [noir.cookies :as cookies]
    [zpmock1.routes :refer [all-routes]]))

(defonce server (atom nil))

(defn start
  ([] (start 3000))
  ([port]
   (println "Showtime!")
   (->> (-> (all-routes)
            (cookies/wrap-noir-cookies*)
            (wrap-defaults (update-in site-defaults
                                      [:security :anti-forgery]
                                      #(not %)))
            (http/run-server {:port port}))
        (reset! server))))

(defn stop
  []
  (@server)
  (reset! server nil))

(defn reset
  []
  (stop)
  (Thread/sleep 200)
  (start))