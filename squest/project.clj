(defproject squest "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [lib-noir "0.9.9"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [selmer "0.9.0"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler squest.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
