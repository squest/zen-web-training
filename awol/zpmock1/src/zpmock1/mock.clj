(ns zpmock1.landing
  (:require
    [hiccup.core :as hc]
    [hiccup.page :as hp]
    [zpmock1.core-components :as components]))

(def section-CTArank
  (list [:h2 {:style "max-width: 700px; font-size: 40px;", :class "divcenter bottommargin font-body"} "A digital web studio creating stunning &amp; engaging online experiences"]
        [:p {:style "max-width: 800px;", :class "lead divcenter bottommargin"} "Ford Foundation reduce child mortality fight against oppression refugee disruption pursue these aspirations effect. Free-speech Nelson Mandela change liberal; challenges of our times sustainability institutions."]
        [:p {:style "font-size: 16px;", :class "bottommargin"}
         [:a {:class "more-link", :data-offset "70", :data-speed "1250", :data-easing "easeInOutExpo", :data-scrollto "#section-services", :href "#"} "Learn more "
          [:i {:class "icon-angle-right"}]]]))

(def section-founders
  [:div {:style "max-width: 1000px;", :class "row topmargin-lg divcenter"}

   [:div {:class "col-sm-4 bottommargin"}
    [:div {:class "team"} [:div {:class "team-image"} [:img {:alt "John Doe", :src "images/team/1.jpg"}]
                           [:div {:class "team-overlay"} [:div {:class "team-social-icons"}
                                                          [:a {:title "Facebook", :class "social-icon si-borderless si-small si-facebook", :href "#"}
                                                           [:i {:class "icon-facebook"}] [:i {:class "icon-facebook"}]]
                                                          [:a {:title "Twitter", :class "social-icon si-borderless si-small si-twitter", :href "#"}
                                                           [:i {:class "icon-twitter"}] [:i {:class "icon-twitter"}]]
                                                          [:a {:title "Github", :class "social-icon si-borderless si-small si-github", :href "#"}
                                                           [:i {:class "icon-github"}] [:i {:class "icon-github"}]]]]]
     [:div {:class "team-desc team-desc-bg"} [:div {:class "team-title"}
                                              [:h4 "John Doe"] [:span "CEO"]]]]]

   [:div {:class "col-sm-4 bottommargin"}
    [:div {:class "team"} [:div {:class "team-image"} [:img {:alt "Josh Clark", :src "images/team/2.jpg"}]
                           [:div {:class "team-overlay"} [:div {:class "team-social-icons"}
                                                          [:a {:title "Twitter", :class "social-icon si-borderless si-small si-twitter", :href "#"}
                                                           [:i {:class "icon-twitter"}] [:i {:class "icon-twitter"}]]
                                                          [:a {:title "LinkedIn", :class "social-icon si-borderless si-small si-linkedin", :href "#"}
                                                           [:i {:class "icon-linkedin"}] [:i {:class "icon-linkedin"}]]
                                                          [:a {:title "Flickr", :class "social-icon si-borderless si-small si-flickr", :href "#"}
                                                           [:i {:class "icon-flickr"}] [:i {:class "icon-flickr"}]]]]]
     [:div {:class "team-desc team-desc-bg"} [:div {:class "team-title"}
                                              [:h4 "Mary Jane"] [:span "Co-Founder"]]]]]

   [:div {:class "col-sm-4 bottommargin"}
    [:div {:class "team"} [:div {:class "team-image"} [:img {:alt "Mary Jane", :src "images/team/3.jpg"}]
                           [:div {:class "team-overlay"} [:div {:class "team-social-icons"}
                                                          [:a {:title "Twitter", :class "social-icon si-borderless si-small si-twitter", :href "#"}
                                                           [:i {:class "icon-twitter"}] [:i {:class "icon-twitter"}]]
                                                          [:a {:title "Vimeo", :class "social-icon si-borderless si-small si-vimeo", :href "#"}
                                                           [:i {:class "icon-vimeo"}] [:i {:class "icon-vimeo"}]]
                                                          [:a {:title "Instagram", :class "social-icon si-borderless si-small si-instagram", :href "#"}
                                                           [:i {:class "icon-instagram"}] [:i {:class "icon-instagram"}]]]]]
     [:div {:class "team-desc team-desc-bg"} [:div {:class "team-title"}
                                              [:h4 "Josh Clark"] [:span "Sales"]]]]]])

(defn home
  ([] (hp/html5
        [:html {:lang "en-US", :dir "ltr"}
         [:head
          components/links
          components/style]

         [:body {:class "stretched"}
          [:div {:class "clearfix", :id "wrapper"}
           components/header-light-public

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
              [:div {:style "background: rgba(0,0,0,0.8);", :class "video-overlay"}]]]]

           [:section {:id "content"}
            [:div {:class "content-wrap nopadding"}
             [:div {:class "center page-section", :id "section-about"}
              [:div {:class "container clearfix"}
               section-CTArank
               [:div {:class "clear"}]
               section-founders]]]]]

          "<!-- Footer Scripts\n\t============================================= -->"
          [:script {:src "../js/functions.js", :type "text/javascript"}]]])))