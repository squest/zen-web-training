(ns website1.account
  (:require
    [hiccup.core :as hc]
    [hiccup.page :as hp]
    [clojure.string :as cs]
    [clojure.edn :as edn]))

(def links
  (list [:link {:href "/css/foundationmock.css", :type "text/css", :rel "stylesheet"}
         [:link {:href "/css/stylemock.css", :type "text/css", :rel "stylesheet"}]]
        [:link {:type "text/css", :rel "stylesheet", :href "https://fonts.googleapis.com/css?family=Poiret+One"}]
        [:link {:type "text/css", :rel "stylesheet", :href "https://fonts.googleapis.com/css?family=Montserrat:400"}]))

(defn mainpage
  ([] (hp/html5 [:head links]
                [:body
                 [:div {:class "row"}
                  [:div {:class "large-12 columns headlines"}
                   "THE GREATEST WEB ON EARTH"]]


                 [:div {:class "footer2"}
                  [:div {:class "row"}
                   [:div {:class "large-12 columns"} " "
                    [:h6 "Copyright stuffs."] " "]]]]))

  )

[:li [:a {:class "tombol", :href (str "/" (first num))} (first data)]]
[:div {:class "row"} " "
 [:a {:class "tombol tiny", :href "#"} "Explanation"] " "]