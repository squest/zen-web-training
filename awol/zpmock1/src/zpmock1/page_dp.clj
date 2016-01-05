(ns zpmock1.page-dp
  (:require
    [hiccup.core :as hc]
    [hiccup.page :as hp]
    [zpmock1.component :as comp]
    [zpmock1.comp-header :as header]))

(def header-menu
  (list (header/games "current sub-menu")
        (header/friends "sub-menu")
        (header/learning "sub-menu")
        (header/progress "sub-menu")
        (header/kelas "sub-menu")
        (header/username "sub-menu")))

(def header
  (header/container-light
    header/logo4
    (header/navigation-plain header-menu header/notif)))

(def directory
  [:div {:class "widget widget_links clearfix", :id "shortcodes"}
   [:h4 "Problems Directory"]
   [:nav {:class "nav-tree nobottommargin"}
    [:ul
     [:li [:a {:href "#"} [:i {:class "icon-bolt2"}] "Math"]
      [:ul [:li [:a {:href "#"} "Algebra"]]
       [:li [:a {:href "#"} "Matrix"]]]]
     [:li [:a {:href "#"} [:i {:class "icon-briefcase"}] "Physics"]
      [:ul [:li [:a {:href "#"} "Grid"]
            [:ul [:li [:a {:href "#"} "3 Columns"]]
             [:li [:a {:href "#"} "4 Columns"]]]]
       [:li [:a {:href "#"} "Masonry"]]
       [:li [:a {:href "#"} "Loading Styles"]]]]
     [:li [:a {:href "#"} [:i {:class "icon-file-text"}] "English"]
      [:ul
       [:li [:a {:href "#"} "Company"]]
       [:li [:a {:href "#"} "Team"]]
       [:li [:a {:href "#"} "Services"]]
       [:li [:a {:href "#"} "FAQs"]]]] ]]])

(def rec-learning
  [:h4 {:class "highlight-me uppercase"} "Recommended Learning"
   [:div {:class "fluid-width-video-wrapper", :style "padding-top: 34%;"}
    [:iframe {:frameborder "0",  :src "images/Zenvid.png", :id "fitvid264630"}]]])

(def rec-learn
  [:div {:class "widget widget_links clearfix", :id "shortcodes"}
   [:h4 {:class "highlight-me"} "Related to Current Problem"
    [:div {:class "fluid-width-video-wrapper", :style "padding-top: 56.25%;"}
     [:iframe {:frameborder "0", :src "http://www.youtube.com/embed/SZEflIVnhH8", :id "fitvid264630"}]]]])

(def prob-title
  [:div {:class "container clearfix"}
   [:h3 {:style "margin-bottom: 5px;"} "Title of the Problem"]
   [:p {:style "margin-bottom: 20px;"} "Sub-bab atau materi dari soal"]])

(def prob-image
  [:div {:class "entry-image"}
   [:a {:href "#"}
    [:img {:alt "Image", :src "images/Banana.jpg"}]]])

(def prob-question
  [:div {:class "entry-content"}
   [:p "This is where you ask the questions. And below are the options. For example, what is the colour of your nail?
   Not of the banana, but your nail."]])

(def prob-option
  [:ul {:class "nav nav-pills nav-stacked"}
   [:li [:a {:href "#"} "Red"]]
   [:li [:a {:href "#"} "Blue"]]
   [:li [:a {:href "#"} "Yellow"]]
   [:li {:class "active"} [:a {:href "#"} "Black"]]
   [:li [:a {:href "#"} "Colour? What colour?"]]])

(defn problem
  ([image question option] [:div {:class "widget clearfix", :id "text", :style "margin-top: 0px;"}
                            [:form {:class "col-md-12", :style "padding-left: 0px; padding-right: 0px;"}
                             [:div {:class "col-md-11"}
                              [:div {:class "col-md-5"} image]
                              [:div {:class "col-md-7"} question
                               [:div {:class "notopmargin nobottommargin", :role "form", :action "#"} option]]]

                             [:div {:class "col-md-1"} [:br comp/social1]]

                             [:span {:class "input-group-btn topmargin center"}
                              [:button {:type "submit", :class "button button-small button-dark button-rounded", :style "margin-bottom: 15px;", :href "#"}
                               [:i {:class "icon-ok-right"}] "Submit answer"]]
                             [:div {:class "center"}
                              [:p {:style "margin-bottom: 0px;"} "I'm not sure with my answer yet."]
                              [:a {:class "button button-rounded button-3d button-large button-reveal button-large button-light button-bright-yellow", :style "margin-top: 0px;", :href "#"}
                               [:i {:class "icon-signal"}]
                               [:span "RECOMMENDED LEARNING"]]]]]))

(defn problem2
  ([image question option] [:div {:class "widget clearfix", :id "text", :style "margin-top: 0px;"}
                            [:form {:class "col-md-12" :style "margin-bottom: 0px;"}
                             [:div {:class "content-wrap", :style "padding-top: 1px; padding-bottom: 0px;"}
                              [:div {:class "entry-image"}
                               [:div {:class "panel panel-default"}
                                [:div {:class "panel-body" :style "padding: 10px 2px;"}
                                 [:div {:class "col-md-5"} image]
                                 [:div {:class "col-md-7"} question
                                  [:div {:class "notopmargin nobottommargin", :role "form", :action "#"} option]]]]]]]
                            (comp/pages "complete")]))

(defn do-quiz
  ([] (hp/html5
        [:html {:lang "en-US", :dir "ltr"}
         [:head
          (comp/font 2)
          comp/links
          comp/style
          comp/javascript]

         [:body {:class "stretched side-panel-left"}

          [:div {:class "clearfix", :id "wrapper"}
           [:title "Latihan Soal | Zenius Prestasi"]

           header]

          (comp/has-side-panel rec-learning rec-learn directory)

          [:section {:id "content"}
           [:div {:class "content-wrap", :style "padding-top: 20px; padding-bottom: 20px;"} ;[:div {:class "container clear-bottommargin clearfix"} [:div {:class "row clearfix"}]]
            prob-title]

           [:section {:id "content"}
            [:div {:class "content-wrap", :style "padding-top: 10px; padding-bottom: 5px;"} ;[:div {:class "container clear-bottommargin clearfix"} [:div {:class "row clearfix"}]]
             (comp/tabs (problem prob-image prob-question prob-option))]]

           [:div {:class "col-md-2 bottommargin"}
            (comp/open-sider "Rekomendasi Belajar" "icon-signal" "button-yellow button-light button-mini")
            (comp/open-sider "Browse Soal" "" "button-leaf button-light button-mini")]

           [:div {:class "widget widget_links clearfix", :id "shortcodes"}
            [:h4 {:class "highlight-me"} "Problems Directory"]
            [:ul
             [:li [:a {:href "problems.html"}
                   [:div "Math"]]]
             [:li [:a {:href "#"}
                   [:div "Physics"]]]
             [:li [:a {:href "#"}
                   [:div "Biology"]]]
             [:li [:a {:href "#"}
                   [:div "English"]]]
             [:li [:a {:href "#"}
                   [:div "History"]]]]]]]

         "<!-- Footer Scripts\n\t============================================= -->" "\n\t"
         [:script {:src "../js/functions.js", :type "text/javascript"}]])))

(defn scored-DP
  ([] (hp/html5

        [:html {:lang "en-US", :dir "ltr"}
         [:head
          (comp/font 2)
          comp/links
          comp/style
          comp/javascript]

         [:body {:class "stretched side-panel-left"}

          [:div {:class "clearfix", :id "wrapper"}
           [:title "Scored DP 2 | Zenius Prestasi"]

           header]

          [:div comp/page-title]

          (comp/has-side-panel rec-learning rec-learn directory)

          [:section {:id "content"}
           [:div {:class "content-wrap", :style "padding-top: 10px; padding-bottom: 5px;"}

            (problem prob-image prob-question prob-option)]]

          comp/footer]

         "<!Footer Scripts>"
         [:script {:src "../js/functions.js", :type "text/javascript"}]])))

(defn scored-DP2
  ([] (hp/html5

        [:html {:lang "en-US", :dir "ltr"}
         [:head
          (comp/font 2)
          comp/links
          comp/style
          comp/javascript]

         [:body {:class "stretched side-panel-left"}

          [:div {:class "clearfix", :id "wrapper"}
           [:title "Scored DP | Zenius Prestasi"]

           header]

          (comp/has-side-panel rec-learning rec-learn directory)

          [:section {:id "content"}
           [:div {:class "content-wrap", :style "padding-top: 7px; padding-bottom: 8px; margin-top: 25px;"}


            [:div {:id "row"}
             [:div {:class "col-md-12"}
              [:div {:class "col-md-2 nobottommargin left" :style "padding-top: 3px; padding-left: 46px; padding-right: 0px;"}
               comp/social2]

              [:div {:class "col-md-8 nobottommargin" :style "padding-top: 5px; padding-left: 8px;"}
               comp/progress]

              [:div {:class "col-md-2 col_last nobottommargin" :style "padding-left: 0px;"}
               [:a {:class "side-panel-trigger button button-rounded button-3d button-mini button-light button-white",
                    :style "margin-top: 0px; font-size: 9px; height: 20px; line-height: 18px;", :href "#"}

                [:span "RECOMMENDED LEARNING"]]]]]]]

          [:section {:id "content"}
           [:div {:class "content-wrap", :style "padding-top: 2px; padding-bottom: 5px;"}

            [:div {:class "container clearfix"}
             (problem2 prob-image prob-question prob-option)]]]]


         "<!Footer Scripts>"
         [:script {:src "../js/functions.js", :type "text/javascript"}]])))


