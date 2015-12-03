(ns zpmock1.home
  (:require
    [hiccup.core :as hc]
    [hiccup.page :as hp]
    [zpmock1.core-components :as components]))

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
          (components/font 2)
          components/links
          components/style
          components/javascript]

         [:body {:class "stretched side-panel-left"}

          [:div {:class "clearfix", :id "wrapper"}
           [:title "Scored DP | Zenius Prestasi"]



           components/page-title]



          [:section {:id "content"}
           [:div {:class "content-wrap", :style "padding-top: 10px; padding-bottom: 5px;"}                    ;[:div {:class "container clear-bottommargin clearfix"} [:div {:class "row clearfix"}]]

            ]]]

         "<!-- Footer Scripts\n\t============================================= -->" "\n\t"
         [:script {:src "../js/functions.js", :type "text/javascript"}]])))
