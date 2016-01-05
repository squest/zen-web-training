(ns zpmock1.page-home
  (:require
    [hiccup.core :as hc]
    [hiccup.page :as hp]
    [zpmock1.component :as comp]
    [zpmock1.comp-header :as header]))

(def header-menu
  (list (header/games "sub-menu")
        (header/friends "sub-menu")
        (header/learning "sub-menu")
        (header/progress "sub-menu")
        (header/kelas "sub-menu")
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

           header]

          [:section {:id "content"}
           [:div {:class "content-wrap", :style "padding-top: 10px; padding-bottom: 5px; margin-top: 25px;"}


            [:div {:id "row"}
             [:div {:class "container clearfix"}
              [:div {:class "col-md-2 nobottommargin left", :style "padding-top: 4px;"}
               comp/social2]

              [:div {:class "col-md-8 nobottommargin", :style "padding-top: 4px;"}
               comp/progress]

              [:div {:class "col-md-2 fright col_last nobottommargin"}
               [:a {:class "button button-rounded button-3d button-mini button-light button-white",
                    :style "margin-top: 0px; font-size: 9px; height: 20px; line-height: 18px;", :href "#"}

                [:span "RECOMMENDED LEARNING"]]]]]]]

          comp/footer]

         "<!Footer Scripts>"
         [:script {:src "../js/functions.js", :type "text/javascript"}]])))