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

;=============================== SUB MENU ===============================
(def sub-menu
  [:div {:id "page-menu", :class "sticky-page-menu"}
   [:div {:id "page-menu-wrap"}
    [:div {:class "container clearfix"}
     [:row {:class "col-md-8"}
      [:div {:class "menu-title"} [:span "Title of the Problem"]]]
     [:row
      [:nav
       [:ul [:li [:a {:href "#"} "Rekomendasi Belajar"]]
        [:li [:a {:href "#"} "Browse Soal"]]
        ]]]
     [:div {:id "page-submenu-trigger"}
      [:i {:class "icon-reorder"}]]]]])

(def page-title
  [:section {:id "page-title"}
   [:div {:class "container clearfix"}
    [:h1 "Title of the Problem"]
    [:span "Sub-bab atau materi dari soal"]
    [:ol {:class "breadcrumb"}
     [:li
      [:a {:href "#"} "Home"]]
     [:li
      [:a {:href "#"} "Pages"]]
     [:li {:class "active"} "Submenu"]]]])


;=============================== TABS ===============================
(defn side-tab [prob]
  [:div {:id "tab-4", :class "tabs tabs-alt tabs-tb clearfix ui-tabs ui-widget ui-widget-content ui-corner-all"}
   [:ul {:class "tab-nav clearfix ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all", :role "tablist"}
    [:li {:class "ui-state-default ui-corner-top ui-tabs-active ui-state-active", :role "tab", :tabindex "0", :aria-controls "tabs-13", :aria-labelledby "ui-id-29", :aria-selected "true"}
     [:a {:href "#tabs-13", :class "ui-tabs-anchor", :role "presentation", :tabindex "-1", :id "ui-id-29"}
      [:i {:class "icon-home2"}] " Start here"]]
    [:li {:class "ui-state-default ui-corner-top", :role "tab", :tabindex "-1", :aria-controls "tabs-14", :aria-labelledby "ui-id-30", :aria-selected "false"}
     [:a {:href "#tabs-14", :class "ui-tabs-anchor", :role "presentation", :tabindex "-1", :id "ui-id-30"} "Nunc tincidunt"]]
    [:li {:class "ui-state-default ui-corner-top", :role "tab", :tabindex "-1", :aria-controls "tabs-15", :aria-labelledby "ui-id-31", :aria-selected "false"}
     [:a {:href "#tabs-15", :class "ui-tabs-anchor", :role "presentation", :tabindex "-1", :id "ui-id-31"} "Proin dolor"]]
    [:li {:class "hidden-phone ui-state-default ui-corner-top", :role "tab", :tabindex "-1", :aria-controls "tabs-16", :aria-labelledby "ui-id-32", :aria-selected "false"}
     [:a {:href "#tabs-16", :class "ui-tabs-anchor", :role "presentation", :tabindex "-1", :id "ui-id-32"} "Aenean lacinia"]]]

   [:div {:class "tab-container"}
    [:div {:id "tabs-13", :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom", :aria-labelledby "ui-id-29", :role "tabpanel", :aria-expanded "true", :aria-hidden "false"} prob]
    [:div {:id "tabs-14", :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom", :aria-labelledby "ui-id-30", :role "tabpanel", :style "display: none;", :aria-expanded "false", :aria-hidden "true"} prob]
    [:div {:id "tabs-15", :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom", :aria-labelledby "ui-id-31", :role "tabpanel", :style "display: none;", :aria-expanded "false", :aria-hidden "true"} prob]
    [:div {:id "tabs-16", :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom", :aria-labelledby "ui-id-32", :role "tabpanel", :style "display: none;", :aria-expanded "false", :aria-hidden "true"} prob]]])

(defn sided [content]
  [:div {:id "tab-4", :class "tabs side-tabs clearfix ui-tabs ui-widget ui-widget-content ui-corner-all"}
   [:ul {:class "tab-nav clearfix ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all", :role "tablist"}
    [:li {:class "ui-state-default ui-corner-top", :role "tab", :tabindex "-1", :aria-controls "tabs-15", :aria-labelledby "ui-id-31", :aria-selected "false"}
     [:a {:href "#tabs-15", :class "ui-tabs-anchor", :role "presentation", :tabindex "-1", :id "ui-id-31"} "Proin dolor"]]]

   [:div {:class "tab-container"}
    [:div {:id "tabs-15", :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom", :aria-labelledby "ui-id-31", :role "tabpanel", :style "display: none;", :aria-expanded "false", :aria-hidden "true"}
     content]]]
  (#(vector [:a {:href (str "#tabs-" %), :class "ui-tabs-anchor",
                 :role "presentation", :tabindex "-1", :id (str "ui-id-" %)}] (str "Soal " %))
    (inc 0)))

(def tabnew [:div {:id "tab-8", :class "tabs tabs-alt tabs-tb clearfix ui-tabs ui-widget ui-widget-content ui-corner-all"} "\n\n\t\t\t\t\t\t\t"
             [:ul {:class "tab-nav clearfix ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all", :role "tablist"} "\n\t\t\t\t\t\t\t\t"
              [:li {:class "ui-state-default ui-corner-top ui-tabs-active ui-state-active", :role "tab", :tabindex "0", :aria-controls "tabs-29", :aria-labelledby "ui-id-13", :aria-selected "true"}
               [:a {:href "#tabs-29", :class "ui-tabs-anchor", :role "presentation", :tabindex "-1", :id "ui-id-13"}
                [:i {:class "icon-home2 norightmargin"}]]] "\n\t\t\t\t\t\t\t\t"
              [:li {:class "ui-state-default ui-corner-top", :role "tab", :tabindex "-1", :aria-controls "tabs-30", :aria-labelledby "ui-id-14", :aria-selected "false"}
               [:a {:href "#tabs-30", :class "ui-tabs-anchor", :role "presentation", :tabindex "-1", :id "ui-id-14"} "Nunc tincidunt"]] "\n\t\t\t\t\t\t\t\t"
              [:li {:class "ui-state-default ui-corner-top", :role "tab", :tabindex "-1", :aria-controls "tabs-31", :aria-labelledby "ui-id-15", :aria-selected "false"}
               [:a {:href "#tabs-31", :class "ui-tabs-anchor", :role "presentation", :tabindex "-1", :id "ui-id-15"} "Proin dolor"]] "\n\t\t\t\t\t\t\t\t"
              [:li {:class "hidden-phone ui-state-default ui-corner-top", :role "tab", :tabindex "-1", :aria-controls "tabs-32", :aria-labelledby "ui-id-16", :aria-selected "false"}
               [:a {:href "#tabs-32", :class "ui-tabs-anchor", :role "presentation", :tabindex "-1", :id "ui-id-16"} "Aenean lacinia"]] "\n\t\t\t\t\t\t\t"] "\n\n\t\t\t\t\t\t\t"
             [:div {:class "tab-container"} "\n\n\t\t\t\t\t\t\t\t"
              [:div {:id "tabs-29", :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom", :aria-labelledby "ui-id-13", :role "tabpanel", :aria-expanded "true", :aria-hidden "false"} "\n\t\t\t\t\t\t\t\t\tProin elit arcu, rutrum commodo, vehicula tempus, commodo a, risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris. Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus. Aenean tempor ullamcorper leo. Vivamus sed magna quis ligula eleifend adipiscing. Duis orci. Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique tempus lectus.\n\t\t\t\t\t\t\t\t"] "\n\t\t\t\t\t\t\t\t"
              [:div {:id "tabs-30", :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom", :aria-labelledby "ui-id-14", :role "tabpanel", :style "display: none;", :aria-expanded "false", :aria-hidden "true"} "\n\t\t\t\t\t\t\t\t\tMorbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. Aenean aliquet fringilla sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut posuere viverra nulla. Aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris consectetur tortor et purus.\n\t\t\t\t\t\t\t\t"] "\n\t\t\t\t\t\t\t\t"
              [:div {:id "tabs-31", :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom", :aria-labelledby "ui-id-15", :role "tabpanel", :style "display: none;", :aria-expanded "false", :aria-hidden "true"} "\n\t\t\t\t\t\t\t\t\t"
               [:p "Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a, lacus."] "\n\t\t\t\t\t\t\t\t\tDuis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit. Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.\n\t\t\t\t\t\t\t\t"] "\n\t\t\t\t\t\t\t\t"
              [:div {:id "tabs-32", :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom", :aria-labelledby "ui-id-16", :role "tabpanel", :style "display: none;", :aria-expanded "false", :aria-hidden "true"} "\n\t\t\t\t\t\t\t\t\tPraesent in eros vestibulum mi adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut posuere viverra nulla. Aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris consectetur tortor et purus.\n\t\t\t\t\t\t\t\t"] "\n\n\t\t\t\t\t\t\t"] "\n\n\t\t\t\t\t\t"])





