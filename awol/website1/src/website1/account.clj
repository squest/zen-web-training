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

(def footer
  [:div {:class "footer2"}
   [:div {:class "row"}
    [:div {:class "large-12 columns"} " "
     [:h6 "Copyright stuffs."] " "]]])

(defn mainpage
  ([] (hp/html5 [:head links]
                [:body
                 [:div {:class "row"}
                  [:div {:class "large-12 columns headlines"}
                   "THE GREATEST WEB ON EARTH"]]

                 [:div {:class "row"}
                  [:div {:class "large-12 columns"}

                   [:form {:action "/signup" :method "post"}

                    [:div {:class "row"}
                     [:div {:class "large-12 columns" :style "padding-bottom: 2rem;"}
                      [:label "Username"
                       [:input {:type "text", :name "user", :placeholder "Type your username here"}]]]]

                    [:div {:class "row"}
                     [:div {:class "large-12 columns" :style "padding-bottom: 2rem;"}
                      [:label "Password"
                       [:input {:type "text", :name "password", :placeholder "Type your password here"}]]]]

                    [:div {:class "row"}
                     [:input {:type "submit", :class "tombol right"}]]]]]

                 [:div {:class "row"}
                  [:div {:class "large-12 columns central"} " "
                   [:a {:class "tombol large", :href "/signup"}, "Sign Up"] " "]]

                 footer])))


(defn new-account
  [{:keys [user password]}]
  (->> {:user     (str user),
        :password (str password)}
       (conj (->> (slurp (str "resources/public/accounts.edn"))
                  (edn/read-string)))
       (spit "resources/public/accounts.edn")))


(defn signup []
  (hp/html5 [:head links]
            [:body
             [:div {:class "row"}
              [:div {:class "large-12 columns headlines"}
               "SIGN UP PAGE"]]

             [:form {:action "/signup" :method "post"}

              [:div {:class "row"}
               [:div {:class "large-12 columns" :style "padding-bottom: 2rem;"}
                [:label "Username"
                 [:input {:type "text", :name "user", :placeholder "Type your username here"}]]]]

              [:div {:class "row"}
               [:div {:class "large-12 columns" :style "padding-bottom: 2rem;"}
                [:label "Password"
                 [:input {:type "text", :name "password", :placeholder "Type your password here"}]]]]

              [:div {:class "row"}
               [:input {:type "submit", :class "tombol right"}]]]

             footer]))

(defn signin [user password]
  (hp/html5 [:head links]
            [:body
             [:div {:class "row"}
              [:div {:class "large-12 columns headlines"}
               "SIGN IN HERE"]]

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
               [:input {:type "submit", :class "tombol right"}]]]

             footer]))


