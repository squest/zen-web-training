(defproject website1 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :resource-paths ["resources"]
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [lib-noir "0.9.9"]
                 [http-kit "2.1.19"]
                 [ring/ring-defaults "0.1.5"]
                 ;[chesire "5.5.0"]
                 [danlentz/clj-uuid "0.1.6"]
                 [couchbase-clj "0.2.0"]])