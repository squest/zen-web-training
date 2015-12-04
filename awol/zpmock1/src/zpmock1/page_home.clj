(ns zpmock1.page-home
  (:require
    [hiccup.core :as hc]
    [hiccup.page :as hp]
    [zpmock1.component :as comp]
    [zpmock1.comp-header :as header]))

(def header-menu
  (list (header/games "current sub-menu")
        (header/friends "sub-menu")
        (header/progress "sub-menu")
        (header/username "current sub-menu")))

(def header
  (header/container-light
    header/ZP-short
    (header/navigation-plain header-menu header/notif)))

(def student-menu
  (list [:li {:class "current"} [:a {:data-href "#section-home", :href "#"} [:div "Home"]]]
        [:li [:a {:data-href "#section-home", :href "#"} [:div "Social"
                                                          [:li [:a {:data-href "#section-home", :href "#"} [:div "Social"]]]]]]
        [:li [:a {:data-href "#section-features", :href "#"} [:div "Learnings"]]]
        [:li [:a {:data-href "#section-pricing", :href "#"} [:div "My Class"]]]
        [:li [:a {:data-href "#section-pricing", :href "#"} [:div "My Progress"]]]))


(defn student
  ([] (hp/html5

        [:html {:lang "en-US", :dir "ltr"}
         [:head
          (comp/font 2)
          comp/links
          comp/style
          comp/javascript]

         [:body {:class "stretched side-panel-left"}

          [:div {:class "clearfix", :id "wrapper"}
           [:title "Profile | Zenius Prestasi"]

           header

           comp/page-title]


          [:section {:id "content"}
           [:div {:class "content-wrap", :style "padding-top: 10px; padding-bottom: 5px;"}]]

          comp/footer]

         "<!Footer Scripts>"
         [:script {:src "../js/functions.js", :type "text/javascript"}]])))
