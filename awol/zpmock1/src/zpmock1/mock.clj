(ns zpmock1.mock
  (:require
    [hiccup.core :as hc]
    [hiccup.page :as hp]))

(def links
  (list [:link {:href "/css/foundationmock.css", :type "text/css", :rel "stylesheet"}
         [:link {:href "/css/stylemock.css", :type "text/css", :rel "stylesheet"}]]
        [:link {:type "text/css", :rel "stylesheet", :href "https://fonts.googleapis.com/css?family=Poiret+One"}]
        [:link {:type "text/css", :rel "stylesheet", :href "https://fonts.googleapis.com/css?family=Montserrat:400"}]))

(def footer
  [:div {:class "footer2"}
   [:div {:class "row"}
    [:div {:class "large-12 columns"} " "
     [:h6 "Copyright stuffs."] " "]]])

(defn home
  ([] (hp/html5 [:head links]
                [:body
                 [:div {:class "row"}
                  [:div {:class "large-12 columns headlines"}
                   "THE GREATEST WEB ON EARTH"]]

                 [:div {:class "row"}
                  [:div {:class "large-12 columns"}

                   [:form {:action "/signin" :method "post"}

                    [:div {:class "row"}
                     [:div {:class "large-12 columns" :style "padding-bottom: 2rem;"}
                      [:label "Username"
                       [:input {:type "text", :name "user", :placeholder "Type your username here"}]]]]

                    [:div {:class "row"}
                     [:div {:class "large-12 columns" :style "padding-bottom: 2rem;"}
                      [:label "Password"
                       [:input {:type "text", :name "password", :placeholder "Type your password here"}]]]]

                    [:div {:class "row"}
                     [:input {:type "submit", :class "tombol tiny right", :value "Sign In"}]]]]]

                 [:div {:class "row"}
                  [:div {:class "large-12 columns central"} " "
                   [:a {:class "tombol large", :href "/signup"}, "Sign Up"] " "]]

                 footer])))