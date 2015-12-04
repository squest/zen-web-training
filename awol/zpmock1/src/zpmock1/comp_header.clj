(ns zpmock1.comp-header
  (:require
    [hiccup.core :as hc]
    [hiccup.page :as hp]
    [zpmock1.component :as comp]))

;=============================== HEADER LOGO ===============================
(defn logo-header
  ([smaller] [:div {:id "logo", :class "nobottomborder"}
              [:a {:data-dark-logo smaller, :class "standard-logo", :href "landing.html"}
               [:img {:src smaller}]]])
  ([smaller bigger] [:div {:id "logo", :class "nobottomborder"}
                     [:a {:data-dark-logo smaller, :class "standard-logo", :href "landing.html"}
                      [:img {:src smaller}]]
                     [:a {:data-dark-logo bigger, :class "retina-logo", :href "landing.html"}
                      [:img {:src bigger}]]]))

(def ZP-logo (logo-header "images/ZPlogo.png" "images/ZPlogo@2x.png"))
(def ZP-short (logo-header "images/ZPshort.png"))
(def fake-logo (logo-header "images/performance.png"))
(def logo
  [:div {:id "logo"}
   [:a {:data-dark-logo "images/logo-dark.png", :class "standard-logo", :href "index.html"}
    [:img {:alt "Canvas Logo", :src "images/logo.png"}]]
   [:a {:data-dark-logo "images/logo-dark@2x.png", :class "retina-logo", :href "index.html"}
    [:img {:alt "Canvas Logo", :src "images/logo@2x.png"}]]])


;=============================== HEADER MENU COMPONENTS===============================
(defn games [status]
  [:li {:class status} [:a {:href "#", :class "sf-with-ul"} [:div "Games"]]
   [:ul {:style "display: none;"}
    [:li {:class "sub-menu"} [:a {:href "#", :class "sf-with-ul"} [:div [:i {:class "icon-stack"}] "Duel"]]]
    [:li {:class "sub-menu"} [:a {:href "widgets.html", :class "sf-with-ul"} [:div [:i {:class "icon-gift"}] "Quizzes"]]]
    [:li [:a {:href "#"} [:div [:i {:class "icon-adjust"}] "References"]]
     [:ul {:style "display: none;"}
      [:li [:a {:href "widgets.html"} [:div "Video References"]]]
      [:li [:a {:href "widgets.html"} [:div "Articles"]]]
      [:li [:a {:href "widgets.html"} [:div "Learning Tracks"]]]]]]])

(defn friends [status]
  [:li {:class status} [:a {:href "#", :class "sf-with-ul"} [:div "Friends"]]
   [:ul {:style "display: none;"}
    [:li {:class "sub-menu"} [:a {:href "#", :class "sf-with-ul"} [:div [:i {:class "icon-stack"}] "Social / Timeline"]]]
    [:li {:class "sub-menu"} [:a {:href "widgets.html", :class "sf-with-ul"} [:div [:i {:class "icon-gift"}] "Friends List"]]
     [:ul {:style "display: none;"}
      [:li [:a {:href "widgets.html"} [:div "Profile"]]]
      [:li [:a {:href "widgets.html"} [:div "Challenge"]]]
      [:li [:a {:href "widgets.html"} [:div "Compare"]]]]]]])

(defn learning [status]
  [:li {:class status} [:a {:href "#", :class "sf-with-ul"} [:div "Learnings"]]
   [:ul {:style "display: none;"}
    [:li [:a {:href "widgets.html"} [:div "Video References"]]]
    [:li [:a {:href "widgets.html"} [:div "Articles"]]]
    [:li [:a {:href "widgets.html"} [:div "Learning Tracks"]]]]])

(defn progress [status]
  [:li {:class status} [:a {:href "#", :class "sf-with-ul"} [:div "Progress"]]
   [:ul {:style "display: none;"}
    [:li [:a {:href "#", :class "sf-with-ul"} [:div [:i {:class "icon-stack"}] "Rank"]]]
    [:li [:a {:href "#", :class "sf-with-ul"} [:div [:i {:class "icon-umbrella"}] "Progress Tracking / Chart"]]]
    [:li [:a {:href "#"} [:div [:i {:class "icon-adjust"}] "Spot strengths and weaknesses"]]]
    [:li [:a {:href "#"} [:div [:i {:class "icon-adjust"}] "History"]]]]])

(defn kelas [status]
  [:li {:class status} [:a {:href "#", :class "sf-with-ul"} [:div "Kelas"]]
   [:ul {:style "display: none;"}
    [:li [:a {:href "#", :class "sf-with-ul"} [:div [:i {:class "icon-stack"}] "Tugas"]]]
    [:li [:a {:href "#"} [:div [:i {:class "icon-adjust"}] "Latihan Soal"]]]
    [:li [:a {:href "#", :class "sf-with-ul"} [:div [:i {:class "icon-umbrella"}] "Join Kelas"]]]
    [:li [:a {:href "#", :class "sf-with-ul"} [:div [:i {:class "icon-umbrella"}] "Data Kelas"]]]]])

(defn username [status]
  [:li {:class status} [:a {:href "#", :class "sf-with-ul"} [:div [:i {:class "fa fa-caret-down"}] "username"]]
   [:ul {:style "display: none;"}
    [:li [:a {:href "#", :class "sf-with-ul"} [:div [:i {:class "fa fa-home"}] "My Profile"]]]
    [:li [:a {:href "#", :class "sf-with-ul"} [:div [:i {:class " "}] "Setting"]]]
    [:li [:a {:href "#", :class "sf-with-ul"} [:div [:i {:class " "}] "Log Out"]]]]])

(def cart-bar [:div {:id "top-cart"}
               [:a {:id "top-cart-trigger", :href "#"}
                [:i {:class "icon-shopping-cart"}]
                [:span "5"]]
               [:div {:class "top-cart-content"} [:div {:class "top-cart-title"}
                                                  [:h4 "Shopping Cart"]]
                [:div {:class "top-cart-items"} [:div {:class "top-cart-item clearfix"} [:div {:class "top-cart-item-image"}
                                                                                         [:a {:href "#"} [:img {:alt "Blue Round-Neck Tshirt", :src "images/shop/small/1.jpg"}]]]
                                                 [:div {:class "top-cart-item-desc"}
                                                  [:a {:href "#"} "Blue Round-Neck Tshirt"]
                                                  [:span {:class "top-cart-item-price"} "$19.99"]
                                                  [:span {:class "top-cart-item-quantity"} "x 2"]]]
                 [:div {:class "top-cart-item clearfix"} [:div {:class "top-cart-item-image"}
                                                          [:a {:href "#"} [:img {:alt "Light Blue Denim Dress", :src "images/shop/small/6.jpg"}]]]
                  [:div {:class "top-cart-item-desc"}
                   [:a {:href "#"} "Light Blue Denim Dress"]
                   [:span {:class "top-cart-item-price"} "$24.99"]
                   [:span {:class "top-cart-item-quantity"} "x 3"]]]]
                [:div {:class "top-cart-action clearfix"}
                 [:span {:class "fleft top-checkout-price"} "$114.95"]
                 [:button {:class "button button-3d button-small nomargin fright"} "View Cart"]]]])

(def search-bar [:div {:id "top-search"}
                 [:a {:id "top-search-trigger", :href "#"}
                  [:i {:class "icon-search3"}]
                  [:i {:class "icon-line-cross"}]]
                 [:form {:method "get", :action "search.html"}
                  [:input {:type "text", :placeholder "Type & Hit Enter..", :class "form-control", :name "q"}]]])

(def notif [:div {:id "top-search"}
            [:a {:href "landing.html"}
             [:span {:class "fa fa-bell", :style  "vertical-align: middle;"}]]])

(def generic-menu
  (list (games "sub-menu")
        (friends "sub-menu")
        (learning "sub-menu")
        (progress "sub-menu")
        (username "sub-menu")))


(def example-menu
  (list [:li {:class "sub-menu"} [:a {:href "index.html", :class "sf-with-ul"} [:div "Home"]]
         [:ul {:style "display: none;"}
          [:li {:class "sub-menu"} [:a {:href "index-corporate.html", :class "sf-with-ul"} [:div "Home - Corporate"]]
           [:ul {:style "display: none;"}
            [:li [:a {:href "index-corporate.html"} [:div "Corporate - Layout 1"]]]
            [:li [:a {:href "index-corporate-2.html"} [:div "Corporate - Layout 2"]]]]]
          [:li {:class "sub-menu"} [:a {:href "index-portfolio.html", :class "sf-with-ul"} [:div "Home - Portfolio"]]
           [:ul {:style "display: none;"}
            [:li [:a {:href "index-portfolio.html"} [:div "Portfolio - Layout 1"]]]
            [:li [:a {:href "index-portfolio-2.html"} [:div "Portfolio - Layout 2"]]]
            [:li [:a {:href "index-portfolio-3.html"} [:div "Portfolio - Masonry"]]]]]
          [:li {:class "sub-menu"} [:a {:href "index-blog.html", :class "sf-with-ul"} [:div "Home - Blog"]]
           [:ul {:style "display: none;"}
            [:li [:a {:href "index-blog.html"} [:div "Blog - Layout 1"]]]
            [:li [:a {:href "index-blog-2.html"} [:div "Blog - Layout 2"]]]]]]]

        [:li {:class "current sub-menu"} [:a {:href "#", :class "sf-with-ul"} [:div "Features"]]
         [:ul {:style "display: none;"}
          [:li {:class "sub-menu"} [:a {:href "#", :class "sf-with-ul"} [:div [:i {:class "icon-stack"}] "Sliders"]]
           [:ul {:style "display: none;"}
            [:li {:class "sub-menu"} [:a {:href "slider-revolution.html", :class "sf-with-ul"} [:div "Revolution Slider"]]]
            [:li {:class "sub-menu"} [:a {:href "slider-canvas.html", :class "sf-with-ul"} [:div "Canvas Slider"]]
             [:ul {:style "display: none;"}
              [:li [:a {:href "slider-canvas.html"} [:div "Full Width"]]]
              [:li [:a {:href "slider-canvas-fade.html"} [:div "Fade Transition"]]]
              [:li [:a {:href "slider-canvas-autoplay.html"} [:div "Autoplay Feature"]]]]]
            [:li [:a {:href "slider-camera.html"} [:div "Camera Slider"]]]
            [:li [:a {:href "slider-elastic.html"} [:div "Elastic Slider"]]]
            [:li [:a {:href "slider-nivo.html"} [:div "Nivo Slider"]]]]]
          [:li {:class "sub-menu"} [:a {:href "widgets.html", :class "sf-with-ul"} [:div [:i {:class "icon-gift"}] "Widgets"]]
           [:ul {:style "display: none;"}
            [:li [:a {:href "widgets.html"} [:div "Links"]]]
            [:li [:a {:href "widgets.html"} [:div "Flickr Photostream"]]]
            [:li [:a {:href "widgets.html"} [:div "Dribbble Shots"]]]
            [:li [:a {:href "widgets.html"} [:div "Instagram Feed"]]]]]
          [:li {:class "sub-menu"} [:a {:href "#", :class "sf-with-ul"} [:div [:i {:class "icon-umbrella"}] "Headers"]]]
          [:li [:a {:href "#"} [:div [:i {:class "icon-adjust"}] "Dark Version"]]]]]

        [:li {:class "mega-menu sub-menu"} [:a {:href "#", :class "sf-with-ul"} [:div "Pages"]]
         [:div {:class "mega-menu-content style-2 col-4 clearfix", :style "display: none; width: 1109px;"}
          [:ul
           [:li {:class "mega-menu-title sub-menu"} [:a {:href "#", :class "sf-with-ul"} [:div "Introduction"]]
            [:ul {:style "display: none;"}
             [:li [:a {:href "about.html"} [:div "About Us"]]
              [:ul {:style "display: none;"}
               [:li {:class "sub-menu"} [:a {:href "index-corporate.html", :class "sf-with-ul"} [:div "Home - Corporate"]]
                [:ul {:style "display: none;"}
                 [:li [:a {:href "index-corporate.html"} [:div "Corporate - Layout 1"]]]
                 [:li [:a {:href "index-corporate-2.html"} [:div "Corporate - Layout 2"]]]]]
               [:li {:class "sub-menu"} [:a {:href "index-portfolio.html", :class "sf-with-ul"} [:div "Home - Portfolio"]]
                [:ul {:style "display: none;"}
                 [:li [:a {:href "index-portfolio.html"} [:div "Portfolio - Layout 1"]]]
                 [:li [:a {:href "index-portfolio-2.html"} [:div "Portfolio - Layout 2"]]]
                 [:li [:a {:href "index-portfolio-3.html"} [:div "Portfolio - Masonry"]]]]]
               [:li {:class "sub-menu"} [:a {:href "index-blog.html", :class "sf-with-ul"} [:div "Home - Blog"]]
                [:ul {:style "display: none;"}
                 [:li [:a {:href "index-blog.html"} [:div "Blog - Layout 1"]]]
                 [:li [:a {:href "index-blog-2.html"} [:div "Blog - Layout 2"]]]]]]]
             [:li [:a {:href "about-2.html"} [:div "About Us - Layout 2"]]]]]]
          [:ul
           [:li {:class "mega-menu-title sub-menu"} [:a {:href "#", :class "sf-with-ul"} [:div "Utility"]]
            [:ul {:style "display: none;"}
             [:li [:a {:href "services.html"} [:div "Services - Layout 1"]]]
             [:li [:a {:href "services-2.html"} [:div "Services - Layout 2"]]]]]]
          [:ul
           [:li {:class "mega-menu-title sub-menu"} [:a {:href "#", :class "sf-with-ul"} [:div "Miscellaneous"]]
            [:ul {:style "display: none;"}
             [:li [:a {:href "login-register.html"} [:div "Login/Register"]]]
             [:li [:a {:href "login-register-2.html"} [:div "Login/Register - Style 2"]]]]]]]]))



;=============================== HEADER MENU NAVIGATION ===============================
(defn navigation-modern [menu & components]
  [:nav {:class "style-3", :id "primary-menu"}
   [:ul {:data-offset "65", :data-speed "1250", :data-easing "easeInOutExpo",
         :class "one-page-menu"}
    menu]
   components])

(defn navigation-plain [menu & components]
  [:nav {:class "style-3", :id "primary-menu"}
   [:ul
    menu]
   components])


;=============================== HEADER CONTAINER ===============================
(defn container-light
  ([logo navigation]
   [:header {:class "full-header sticky-header", :id "header"}
    [:div {:id "header-wrap"} [:div {:class "container clearfix"}
                               [:div {:id "primary-menu-trigger"} [:i {:class "icon-reorder"}]]
                               logo
                               navigation]]])

  ([logo navigation transparent]                            ;the moving one
   [:header {:id "header", :data-sticky-offset "0", :data-sticky-class "not-dark",
             :class (str "full-header" " " transparent)}
    [:div {:id "header-wrap"} [:div {:class "container clearfix"}
                               [:div {:id "primary-menu-trigger"} [:i {:class "icon-reorder"}]]
                               logo
                               navigation]]]))


