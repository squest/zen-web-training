(ns zpmock1.core-components)

(def links
  (list [:meta {:content "text/html; charset=utf-8", :http-equiv "content-type"}]
        [:meta {:content "SemiColonWeb", :name "author"}]))

(def style
  (list [:link {:type "text/css", :rel "stylesheet", :href "http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700|Roboto:300,400,500,700"}]
        [:link {:type "text/css", :href "../css/bootstrap.css", :rel "stylesheet"}]
        [:link {:type "text/css", :href "../style.css", :rel "stylesheet"}]

        [:link {:type "text/css", :href "../css/dark.css", :rel "stylesheet"}]
        [:link {:type "text/css", :href "../css/font-icons.css", :rel "stylesheet"}]
        [:link {:type "text/css", :href "css/et-line.css", :rel "stylesheet"}]
        [:link {:type "text/css", :href "../css/animate.css", :rel "stylesheet"}]
        [:link {:type "text/css", :href "../css/magnific-popup.css", :rel "stylesheet"}]
        [:link {:type "text/css", :href "css/fonts.css", :rel "stylesheet"}]
        [:link {:type "text/css", :href "../css/responsive.css", :rel "stylesheet"}]
        [:meta {:content "width=device-width, initial-scale=1", :name "viewport"}]

        "<!-- One Page Module Specific Stylesheet -->"
        [:link {:type "text/css", :href "onepage.css", :rel "stylesheet"}]

        "<!--[if lt IE 9]>
        <script src=\"http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js\"></script>
        <![endif]-->"))

(def javascript
  (list [:script {:src "../js/jquery.js", :type "text/javascript"}]
        [:script {:src "../js/plugins.js", :type "text/javascript"}]))


;=============================== HEADER LOGO ===============================

(defn logo-header
  ([smaller] [:div {:id "logo"}
              [:a {:data-dark-logo smaller, :class "standard-logo", :href "index.html"}
               [:img {:src smaller}]]])
  ([smaller bigger] [:div {:id "logo"}
                     [:a {:data-dark-logo smaller, :class "standard-logo", :href "index.html"}
                      [:img {:src smaller}]]
                     [:a {:data-dark-logo bigger, :class "retina-logo", :href "index.html"}
                      [:img {:src bigger}]]]))

(def ZP-logo (logo-header "images/ZPlogo.png" "images/ZPlogo@2x.png"))
(def fake-logo (logo-header "images/performance.png"))

;=============================== HEADER MENU ===============================

(def public-menu
  (list [:li [:a {:data-href "#section-home", :href "#"} [:div "Home"]]]
        [:li [:a {:data-href "#section-about", :href "#"} [:div "About"]]]
        [:li [:a {:data-href "#section-works", :href "#"} [:div "Works"]]]
        [:li [:a {:data-href "#section-services", :href "#"} [:div "Services"]]]
        [:li [:a {:data-href "#section-blog", :href "#"} [:div "Blog"]]]
        [:li [:a {:data-href "#section-contact", :href "#"} [:div "Contact"]]]))

(def do-DP-menu
  (list [:li {:class "current"} [:a {:data-href "#section-home", :href "#"} [:div "Home"]]]
        [:li [:a {:data-href "#section-features", :href "#"} [:div "Directory"]]]
        [:li [:a {:data-href "#section-pricing", :href "#"} [:div "Profile"]]]))

(def search-bar [:div {:id "top-search"}
                 [:a {:id "top-search-trigger", :href "#"}
                  [:i {:class "icon-search3"}]
                  [:i {:class "icon-line-cross"}]]
                 [:form {:method "get", :action "search.html"}
                  [:input {:type "text", :placeholder "Type & Hit Enter..", :class "form-control", :name "q"}]]])


(defn navigation-header [menu & components]
  [:nav {:id "primary-menu"}
   [:ul {:data-offset "65", :data-speed "1250", :data-easing "easeInOutExpo",
         :class "one-page-menu"}
    menu]
   components])


;=============================== HEADER CONTAINER ===============================

(defn container-header-light
  ([logo navigation]
   [:header {:id "header", :data-sticky-offset "0",
             :class "full-header static-sticky"}
    [:div {:id "header-wrap"} [:div {:class "container clearfix"}
                               [:div {:id "primary-menu-trigger"} [:i {:class "icon-reorder"}]]
                               logo
                               navigation]]])

  ([logo navigation transparent]
   [:header {:id "header", :data-sticky-offset "0", :data-sticky-class "not-dark",
             :class (str "full-header static-sticky" " " transparent)}
    [:div {:id "header-wrap"} [:div {:class "container clearfix"}
                               [:div {:id "primary-menu-trigger"} [:i {:class "icon-reorder"}]]
                               logo
                               navigation]]]))


;=============================== SIDE PANEL ===============================

(defn has-side-panel [& content]
  (list [:div {:class "body-overlay"}]
        [:div {:class " ", :id "side-panel"} ;class can be "dark"
         [:div {:class "side-panel-trigger", :id "side-panel-trigger-close"}
          [:a {:href "#"} [:i {:class "icon-line-cross"}]]]
         [:div {:class "side-panel-wrap"}
          content]]))


(defn open-sider [name icon & button-style]
  [:section {:id "content"}
   [:div {:class "container"}
    [:a {:class (str "button button-rounded side-panel-trigger button-reveal" " " (first button-style)), :href "#"}
     [:i {:class icon}]
     [:span name]]]])






