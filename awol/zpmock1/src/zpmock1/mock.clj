(ns zpmock1.landing
  (:require
    [hiccup.core :as hc]
    [hiccup.page :as hp]
    [zpmock1.core-components :as components]))

(defn home
  ([] (hp/html5
        [:html {:lang "en-US", :dir "ltr"}
         [:head
          components/links
          components/style]

         [:body {:class "stretched"}
          [:div {:class "clearfix", :id "wrapper"}
           components/header-light-1


           "<!-- Slider\n\t\t============================================= -->"
           [:section {:class "full-screen", :id "slider"}
            [:div {:data-stellar-background-ratio "0.3", :style "background-image: url('http://www.kidtection.co.uk/wp-content/uploads/2014/05/Kidtection-Laptop-2.jpg');", :class "full-screen section dark parallax nopadding nomargin noborder ohidden"}
             [:div {:class "container center"}
              [:div {:class "vertical-middle"}
               [:div {:class "emphasis-title"}
                [:h1 {:style "font-size: 48px;", :class "t600 ls4 uppercase bottommargin-sm"} "Berani "
                 [:span {:class "nocolor hidden-xs"}] "jawab soal "
                 [:span {:class "nocolor hidden-xs"}] "di sini?"]
                [:p {:class "lead"} "Tempat latihan soal, for those who can take the challenge."]]
               [:ul {:style "list-style-type:none"}
                [:li [:a {:data-offset "70", :data-speed "1250", :data-easing "easeInOutExpo", :data-scrollto "#section-contact", :class "button button-border button-light button-circle", :href "#"} "Yes!"]]
                [:li [:a {:data-offset "70", :data-speed "1250", :data-easing "easeInOutExpo", :data-scrollto "#section-contact", :class "button button-border button-light button-circle", :href "#"} "Belajar dulu"]]]]]
             [:div {:class "video-wrap"}
              [:div {:style "background: rgba(0,0,0,0.8);", :class "video-overlay"}]]]]]

          "<!-- Footer Scripts\n\t============================================= -->"
          [:script {:src "../js/functions.js", :type "text/javascript"}]]])))