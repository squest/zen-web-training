(defproject baelish "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :resource-paths ["resources"]

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [lib-noir "0.9.9"]
                 [ring "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [http-kit "2.1.18"]
                 [selmer "0.9.1"]])
