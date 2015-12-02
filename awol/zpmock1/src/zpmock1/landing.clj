(ns zpmock1.landing
  (:require
    [hiccup.core :as hc]
    [hiccup.page :as hp]
    [zpmock1.core-components :as components]))

(def header-menu
  (list [:li [:a {:data-href "#section-home", :href "#"} [:div "Sign Up"]]]
        [:li [:a {:data-href "#section-home", :href "#"} [:div "Log In"]]]))

(def section-CTArankprogress
  (list [:p {:style "max-width: 800px;", :class "lead divcenter bottommargin"} "Already have an account?"]
        [:h2 {:style "max-width: 700px; font-size: 50px;", :class "divcenter bottommargin font-body"}
         [:span {:data-speed "2000", :data-rotate "fadeIn", :data-separator "|", :class "text-rotater nocolor"}
          [:span {:class "t-rotate t700 font-body"} "See your Rank|or|see your Progress."]]]
        [:p {:style "font-size: 16px;", :class "bottommargin"}
         [:ul {:style "list-style-type:none"}
          [:li [:a {:data-offset "70", :data-speed "1250", :data-easing "easeInOutExpo", :data-scrollto "#section-contact", :class "button button-border button-light button-circle", :href "#"} "Here"]]]]))

(def what-we-do
  [:div {:class "section nomargin"}
   [:div {:class "container clearfix"}
    [:div {:style "max-width: 900px;", :class "divcenter center"}
     [:h2 {:class "nobottommargin t300 ls1"} "We create experience"]
     [:h2 {:class "nobottommargin t300 ls1"} "which makes you addicted to learn."]]]])

(def learning-recom
  [:div {:class "container topmargin-lg clearfix"}
   [:div {:class "owl-carousel topmargin image-carousel", :id "oc-clients"}
    [:div {:class "oc-item"} [:a {:href "#"} [:img {:alt "Clients", :src "../images/clients/1.png"}]]]
    [:div {:class "oc-item"} [:a {:href "#"} [:img {:alt "Clients", :src "../images/clients/2.png"}]]]
    [:div {:class "oc-item"} [:a {:href "#"} [:img {:alt "Clients", :src "../images/clients/3.png"}]]]
    [:div {:class "oc-item"} [:a {:href "#"} [:img {:alt "Clients", :src "../images/clients/4.png"}]]]
    [:div {:class "oc-item"} [:a {:href "#"} [:img {:alt "Clients", :src "../images/clients/5.png"}]]]
    [:div {:class "oc-item"} [:a {:href "#"} [:img {:alt "Clients", :src "../images/clients/6.png"}]]]
    [:div {:class "oc-item"} [:a {:href "#"} [:img {:alt "Clients", :src "../images/clients/7.png"}]]]
    [:div {:class "oc-item"} [:a {:href "#"} [:img {:alt "Clients", :src "../images/clients/8.png"}]]]
    [:div {:class "oc-item"} [:a {:href "#"} [:img {:alt "Clients", :src "../images/clients/9.png"}]]]
    [:div {:class "oc-item"} [:a {:href "#"} [:img {:alt "Clients", :src "../images/clients/10.png"}]]]]
   [:script {:type "text/javascript"} "\n\n\t\t\t\t\t\t\tjQuery(document).ready(function($) {\n\n\t\t\t\t\t\t\t\tvar ocClients = $(\"#oc-clients\");\n\n\t\t\t\t\t\t\t\tocClients.owlCarousel({\n\t\t\t\t\t\t\t\t\tmargin: 80,\n\t\t\t\t\t\t\t\t\tloop: true,\n\t\t\t\t\t\t\t\t\tnav: false,\n\t\t\t\t\t\t\t\t\tautoplay: true,\n\t\t\t\t\t\t\t\t\tdots: false,\n\t\t\t\t\t\t\t\t\tautoplayHoverPause: true,\n\t\t\t\t\t\t\t\t\tresponsive:{\n\t\t\t\t\t\t\t\t\t\t0:{ items:2 },\n\t\t\t\t\t\t\t\t\t\t480:{ items:3 },\n\t\t\t\t\t\t\t\t\t\t768:{ items:4 },\n\t\t\t\t\t\t\t\t\t\t992:{ items:5 },\n\t\t\t\t\t\t\t\t\t\t1200:{ items:6 }\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t});\n\n\t\t\t\t\t\t\t});\n\n\t\t\t\t\t\t"]])

(def our-features
  [:body
   [:div {:class "common-height clearfix"}
    [:div {:style "background: url('../images/services/main-bg.jpg') center center no-repeat; background-size: cover;", :class "col-md-4 hidden-xs"}]
    [:div {:class "col-md-8"}
     [:div {:class "max-height"}
      [:div {:class "row common-height grid-border clearfix"}
       [:div {:class "col-md-4 col-sm-6 col-padding"}
        [:div {:class "feature-box fbox-center fbox-dark fbox-plain fbox-small nobottomborder"}
         [:div {:class "fbox-icon"}
          [:a {:href "#"}
           [:i {:class "icon-et-mobile"}]]]
         [:h3 "Responsive Framework"]]]
       [:div {:class "col-md-4 col-sm-6 col-padding"}
        [:div {:class "feature-box fbox-center fbox-dark fbox-plain fbox-small nobottomborder"}
         [:div {:class "fbox-icon"}
          [:a {:href "#"}
           [:i {:class "icon-et-presentation"}]]]
         [:h3 "Beautifully Presented"]]]
       [:div {:class "col-md-4 col-sm-6 col-padding"}
        [:div {:class "feature-box fbox-center fbox-dark fbox-plain fbox-small nobottomborder"}
         [:div {:class "fbox-icon"}
          [:a {:href "#"}
           [:i {:class "icon-et-puzzle"}]]]
         [:h3 "Extensively Extendable"]]]
       [:div {:class "col-md-4 col-sm-6 col-padding"}
        [:div {:class "feature-box fbox-center fbox-dark fbox-plain fbox-small nobottomborder"}
         [:div {:class "fbox-icon"}
          [:a {:href "#"}
           [:i {:class "icon-et-gears"}]]]
         [:h3 "Powerfully Customizable"]]]
       [:div {:class "col-md-4 col-sm-6 col-padding"}
        [:div {:class "feature-box fbox-center fbox-dark fbox-plain fbox-small nobottomborder"}
         [:div {:class "fbox-icon"}
          [:a {:href "#"}
           [:i {:class "icon-et-genius"}]]]
         [:h3 "Geniusly Transformable"]]]
       [:div {:class "col-md-4 col-sm-6 col-padding"}
        [:div {:class "feature-box fbox-center fbox-dark fbox-plain fbox-small nobottomborder"}
         [:div {:class "fbox-icon"}
          [:a {:href "#"}
           [:i {:class "icon-et-hotairballoon"}]]]
         [:h3 "Industrial Support"]]]]]]]])

(def our-programme
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

(def blog
  [:div {:class "page-section", :id "section-blog"}
   [:h2 {:class "center uppercase t300 ls3 font-body"} "From zeniusBlog"]
   [:div {:class "section nobottommargin"}
    [:div {:class "container clearfix"} [:div {:class "row topmargin clearfix"}
                                         [:div {:class "ipost col-sm-6 bottommargin clearfix"}
                                          [:div {:class "row"}
                                           [:div {:class "col-md-6"}
                                            [:div {:class "entry-image nobottommargin"}
                                             [:a {:href "#"}
                                              [:img {:alt "Paris", :src "images/blog/1.jpg"}]]]]
                                           [:div {:style "margin-top: 20px;", :class "col-md-6"}
                                            [:span {:style "font-style: normal;", :class "before-heading"} "Press &amp; Media"]
                                            [:div {:class "entry-title"}
                                             [:h3 {:style "font-size: 22px;", :class "t400"}
                                              [:a {:href "#"} "Global Meetup Program is Launching!"]]]
                                            [:div {:class "entry-content"}
                                             [:a {:class "more-link", :href "#"} "Read more "
                                              [:i {:class "icon-angle-right"}]]]]]]
                                         [:div {:class "ipost col-sm-6 bottommargin clearfix"}
                                          [:div {:class "row"}
                                           [:div {:class "col-md-6"}
                                            [:div {:class "entry-image nobottommargin"}
                                             [:a {:href "#"}
                                              [:img {:alt "Paris", :src "images/blog/2.jpg"}]]]]
                                           [:div {:style "margin-top: 20px;", :class "col-md-6"}
                                            [:span {:style "font-style: normal;", :class "before-heading"} "Inside Scoops"]
                                            [:div {:class "entry-title"}
                                             [:h3 {:style "font-size: 22px;", :class "t400"}
                                              [:a {:href "#"} "The New YouTube Economy unfolds itself"]]]
                                            [:div {:class "entry-content"}
                                             [:a {:class "more-link", :href "#"} "Read more "
                                              [:i {:class "icon-angle-right"}]]]]]]
                                         [:div {:class "ipost col-sm-6 bottommargin clearfix"}
                                          [:div {:class "row"}
                                           [:div {:class "col-md-6"}
                                            [:div {:class "entry-image nobottommargin"}
                                             [:a {:href "#"}
                                              [:img {:alt "Paris", :src "images/blog/3.jpg"}]]]]
                                           [:div {:style "margin-top: 20px;", :class "col-md-6"}
                                            [:span {:style "font-style: normal;", :class "before-heading"} "Video Blog"]
                                            [:div {:class "entry-title"}
                                             [:h3 {:style "font-size: 22px;", :class "t400"}
                                              [:a {:href "#"} "Kicking Off Design Party in Style"]]]
                                            [:div {:class "entry-content"}
                                             [:a {:class "more-link", :href "#"} "Read more "
                                              [:i {:class "icon-angle-right"}]]]]]]
                                         [:div {:class "ipost col-sm-6 bottommargin clearfix"}
                                          [:div {:class "row"}
                                           [:div {:class "col-md-6"}
                                            [:div {:class "entry-image nobottommargin"}
                                             [:a {:href "#"}
                                              [:img {:alt "Paris", :src "images/blog/4.jpg"}]]]]
                                           [:div {:style "margin-top: 20px;", :class "col-md-6"}
                                            [:span {:style "font-style: normal;", :class "before-heading"} "Inspiration"]
                                            [:div {:class "entry-title"}
                                             [:h3 {:style "font-size: 22px;", :class "t400"}
                                              [:a {:href "#"} "Top Ten Signs You&#39;re a Designer"]]]
                                            [:div {:class "entry-content"}
                                             [:a {:class "more-link", :href "#"} "Read more "
                                              [:i {:class "icon-angle-right"}]]]]]]]]]])


(defn land
  ([] (hp/html5
        [:html {:lang "en-US", :dir "ltr"}
         [:head
          components/links
          components/style
          components/javascript]

         [:body {:class "stretched"}
          [:title "Zenius Prestasi | Tempat latihan soal, for those who can take the challenge."]

          [:div {:class "clearfix", :id "wrapper"}
           (components/container-header-light
             components/ZP-logo
             (components/navigation-header header-menu) "transparent-header dark")

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

             [:div {:class "center page-section", :id "section-about" :style "background:#F5E000"}
              section-CTArankprogress]

             what-we-do
             learning-recom

             [:div {:class "center page-section", :id "section-about"}
              our-features]

             [:div {:class "center page-section", :id "section-about"}
              our-programme]

             [:div {:class "center page-section", :id "section-about"}
              blog]]]]

          "<!-- Footer Scripts\n\t============================================= -->"
          [:script {:src "../js/functions.js", :type "text/javascript"}]]])))