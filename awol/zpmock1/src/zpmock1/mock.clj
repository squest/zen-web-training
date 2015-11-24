(ns zpmock1.mock
  (:require
    [hiccup.core :as hc]
    [hiccup.page :as hp]))

(def links
  (list [:meta {:content "text/html; charset=utf-8", :http-equiv "content-type"}]
        [:meta {:content "SemiColonWeb", :name "author"}]))



(def style
  (list [:link {:type "text/css", :rel "stylesheet", :href "http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700|Roboto:300,400,500,700"}] "\n\t"
        [:link {:type "text/css", :href "../css/bootstrap.css", :rel "stylesheet"}] "\n\t"
        [:link {:type "text/css", :href "../style.css", :rel "stylesheet"}]

        [:link {:type "text/css", :rel "stylesheet", :href "http://fonts.googleapiscom/css?family=Source+Sans+Pro:300,400,600,700|Roboto:300,400,500,700"}]
        [:link {:type "text/css", :href "../css/bootstrap.css", :rel "stylesheet"}]
        [:link {:type "text/css", :href "../style.css", :rel "stylesheet"}]

        "<!-- One Page Module Specific Stylesheet -->"
        [:link {:type "text/css", :href "onepage.css", :rel "stylesheet"}]
        "<!-- / -->"
        [:link {:type "text/css", :href "../css/dark.css", :rel "stylesheet"}]
        [:link {:type "text/css", :href "../css/font-icons.css", :rel "stylesheet"}]
        [:link {:type "text/css", :href "css/et-line.css", :rel "stylesheet"}]
        [:link {:type "text/css", :href "../css/animate.css", :rel "stylesheet"}]
        [:link {:type "text/css", :href "../css/magnific-popup.css", :rel "stylesheet"}]
        [:link {:type "text/css", :href "css/fonts.css", :rel "stylesheet"}]
        [:link {:type "text/css", :href "../css/responsive.css", :rel "stylesheet"}]
        [:meta {:content "width=device-width, initial-scale=1", :name "viewport"}]

        "<!--[if lt IE 9]>
        <script src=\"http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js\"></script>
        <![endif]-->"

        "<!-- External JavaScripts\n\t============================================= -->"
        [:script {:src "../js/jquery.js", :type "text/javascript"}]
        [:script {:src "../js/plugins.js", :type "text/javascript"}]))

(def footer
  [:div {:class "footer2"}
   [:div {:class "row"}
    [:div {:class "large-12 columns"} " "
     [:h6 "Copyright stuffs."] " "]]])

(def logo
  [:div {:id "logo"}
   [:a {:data-dark-logo "images/ZP.png", :class "standard-logo", :href "index.html"}
    [:img {:style "max-width: 20%", :class "img-responsive", :src "images/ZP.png"}]]])

(def navigation
  [:nav {:id "primary-menu"}
   [:ul {:data-offset "65", :data-speed "1250", :data-easing "easeInOutExpo", :class "one-page-menu"}
    [:li [:a {:data-href "#wrapper", :href "#"}
          [:div "Home"]]]
    [:li [:a {:data-href "#section-about", :href "#"}
          [:div "About"]]]
    [:li [:a {:data-href "#section-works", :href "#"}
          [:div "Works"]]]
    [:li [:a {:data-href "#section-services", :href "#"}
          [:div "Services"]]]
    [:li [:a {:data-href "#section-blog", :href "#"}
          [:div "Blog"]]]
    [:li [:a {:data-href "#section-contact", :href "#"}
          [:div "Contact"]]]]])

(def header1
  [:header {:data-sticky-offset "0", :data-sticky-class "not-dark", :class "full-header dark transparent-header static-sticky", :id "header"} "\n\n\t\t\t"
   [:div {:id "header-wrap"}
    [:div {:class "container clearfix"}
     logo
     [:div {:id "primary-menu-trigger"}
      [:i {:class "icon-reorder"}]]
     navigation]]])


(defn home
  ([] (hp/html5 [:html {:lang "en-US", :dir "ltr"}
                 [:head links
                  style]

                 [:body {:class "stretched device-md"}
                  [:div {:class "clearfix", :id "wrapper"}

                   header1]]])))

(defn try
  ([] (hp/html5 [:html navigation])))
