(ns zpmock1.core-components
  (:require
    [hiccup.core :as hc]
    [hiccup.page :as hp]))

(def links
  (list [:meta {:content "text/html; charset=utf-8", :http-equiv "content-type"}]
        [:meta {:content "SemiColonWeb", :name "author"}]))

(defn font [x]
  (cond (= x 1) [:link {:type "text/css", :rel "stylesheet", :href "http://fonts.googleapis.com/css?family=Lato:300,400,400italic,600,700|Raleway:300,400,500,600,700|Crete+Round:400italic"}]
        (= x 2) [:link {:type "text/css", :rel "stylesheet", :href "http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700|Roboto:300,400,500,700"}]))

(def style
  (list [:link {:type "text/css", :href "../css/bootstrap.css", :rel "stylesheet"}]
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

;=============================== HEADER MENU ===============================

(def generic-menu
  (list [:li {:class "active"} [:a {:data-href "#section-home", :href "#"} [:div "Game"]]]
        [:li [:a {:data-href "#section-home", :href "#"} [:div "Friends"]]]
        [:li [:a {:data-href "#section-home", :href "#"} [:div "Progress"]]
         [:ul
          [:li [:a {:data-href "#section-home", :href "#"} [:div "Rank"]]]
          [:li [:a {:data-href "#section-home", :href "#"} [:div "Chart"]]]
          [:li [:a {:data-href "#section-home", :href "#"} [:div "History"]]]]]
        [:li [:a {:data-href "#section-home", :href "#"} [:div "Profile"]]]
        [:li [:a {:data-href "#section-home", :href "#"} [:div "Notofication"]]]))



(def search-bar [:div {:id "top-search"}
                 [:a {:id "top-search-trigger", :href "#"}
                  [:i {:class "icon-search3"}]
                  [:i {:class "icon-line-cross"}]]
                 [:form {:method "get", :action "search.html"}
                  [:input {:type "text", :placeholder "Type & Hit Enter..", :class "form-control", :name "q"}]]])

(def notif [:a {:href "landing.html"} [:img {:src "images/icons/Bell.png"}]] )


(defn navigation-header [menu & components]
  [:nav {:id "primary-menu", :class "style-3"}
   [:ul {:data-offset "65", :data-speed "1250", :data-easing "easeInOutExpo",
         :class "one-page-menu"}
    menu]
   components])



;=============================== HEADER CONTAINER ===============================

(defn container-header-light
  ([logo navigation]
   [:header {:id "header",
             :class "full-header static-sticky"}
    [:div {:id "header-wrap"} [:div {:class "container clearfix"}
                               [:div {:id "primary-menu-trigger"} [:i {:class "icon-reorder"}]]
                               logo
                               navigation]]])

  ([logo navigation transparent]
   [:header {:id "header", :data-sticky-offset "0", :data-sticky-class "not-dark",
             :class (str "full-header" " " transparent)}
    [:div {:id "header-wrap"} [:div {:class "container clearfix"}
                               [:div {:id "primary-menu-trigger"} [:i {:class "icon-reorder"}]]
                               logo
                               navigation]]]))


;=============================== MODAL ===============================
(def modal-in-page
  [:style ".header-login-trigger"
   "float: right              ;
   width: 20px                ;
   height: 20px               ;
   line-height: 20px          ;
   font-size: 20px            ;
   text-align: center         ;
   margin: 40px 0 40px 10px   ;
   color: #222                ;
   -webkit-transition: margin .4s ease        ;
   -o-transition: margin .4s ease             ;
   transition: margin .4s ease                ;}
   .header-login-trigger:hover {color: #666 ;}
   #header.sticky-header.header-login-trigger{margin: 20px 0 20px 10px ;}"])

(def modal-login                                          ;in :body
  [:div {:class "content-wrap"}
   [:div {:id "modal-login-form", :class "modal1 mfp-hide"}
    [:div {:style "background-color: #FFF; max-width: 400px;", :class "block divcenter col-padding"}
     [:h4 {:class "uppercase ls1"} "Login to your Account"]
     [:form {:style "max-width: 300px;", :class "nobottommargin clearfix", :action "#"}
      [:div {:class "col_full"}
       [:label {:class "capitalize t600"} "Username or Email:"]
       [:input {:type "email", :class "sm-form-control", :name "template-op-form-email", :id "template-op-form-email"}]]
      [:div {:class "col_full"}
       [:label {:class "capitalize t600"} "Password:"]
       [:input {:type "password", :class "sm-form-control", :name "template-op-form-password", :id "template-op-form-password"}]]
      [:div {:class "col_full nobottommargin"}
       [:div {:class "row"}
        [:div {:class "col-xs-6"}
         [:button {:value "submit", :class "button button-rounded button-small button-dark nomargin", :type "submit"} "Login"]]
        [:div {:class "col-xs-6"}
         [:p {:class "nobottommargin tright"}
          [:small {:class "t300"}
           [:em [:a {:href "#"} "Forgot Password?"]]]]]]]]]]])


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
  [:section {:id "page-title", :style "padding-top: 20px; padding-bottom: 0px;"}
   [:div {:class "container clearfix"}
    [:h3 {:style "margin-bottom: 5px;"} "Title of the Problem"]
    [:p {:style "margin-bottom: 20px;"} "Sub-bab atau materi dari soal"]
    [:ol {:class "breadcrumb", :style "margin-bottom: 5px;"}
     [:li [:a {:class "side-panel-trigger button-reveal" , :href "#"} "Rekomendasi Belajar"]]
     [:li [:a {:href "#"} "Browse Soal"]]]]])


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

(defn tabs [content]
  [:div {:id "tab-4", :class "tabs tabs-alt tabs-tb  clearfix ui-tabs ui-widget ui-widget-content ui-corner-all"}
   [:ul {:class "tab-nav clearfix ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all", :role "tablist"}
    [:li {:class "ui-state-default ui-corner-top", :role "tab", :tabindex "-1", :aria-controls "tabs-15", :aria-labelledby "ui-id-31", :aria-selected "false"}
     [:a {:href "#tabs-15", :class "ui-tabs-anchor", :role "presentation", :tabindex "-1", :id "ui-id-31"} "Soal 1"]]
    [:li {:class "ui-state-default ui-corner-top", :role "tab", :tabindex "-1", :aria-controls "tabs-15", :aria-labelledby "ui-id-31", :aria-selected "false"}
     [:a {:href "#tabs-15", :class "ui-tabs-anchor", :role "presentation", :tabindex "-1", :id "ui-id-31"} "Soal 2"]]
    [:li {:class "ui-state-default ui-corner-top", :role "tab", :tabindex "-1", :aria-controls "tabs-15", :aria-labelledby "ui-id-31", :aria-selected "false"}
     [:a {:href "#tabs-15", :class "ui-tabs-anchor", :role "presentation", :tabindex "-1", :id "ui-id-31"} "Soal 3"]]]

   [:div {:class "tab-container"}
    [:div {:id "tabs-15", :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom", :aria-labelledby "ui-id-31", :role "tabpanel", :style "display: none;", :aria-expanded "false", :aria-hidden "true"}
     content]
    [:div {:id "tabs-15", :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom", :aria-labelledby "ui-id-31", :role "tabpanel", :style "display: none;", :aria-expanded "false", :aria-hidden "true"}
     content]
    [:div {:id "tabs-15", :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom", :aria-labelledby "ui-id-31", :role "tabpanel", :style "display: none;", :aria-expanded "false", :aria-hidden "true"}
     content]]]
  ;(#(vector [:a {:href (str "#tabs-" %), :class "ui-tabs-anchor", :role "presentation", :tabindex "-1", :id (str "ui-id-" %)}] (str "Soal " %)) (inc 0))
  )

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



;=============================== FOOTER ===============================


(def footer
  [:footer {:class "dark", :id "footer"}
   [:div {:class "container"}
    [:div {:class "footer-widgets-wrap clearfix"}
     [:div {:class "col_two_third"}
      [:div {:class "col_one_third"}
       [:div {:class "widget clearfix"}
        [:img {:class "footer-logo", :src "images/footer-widget-logo.png"}]
        [:p "We believe in "
         [:strong "Simple"] ", "
         [:strong "Creative"] " &amp; "
         [:strong "Flexible"] " Design Standards."]
        [:div {:style "background: url('images/world-map.png') no-repeat center center; background-size: 100%;"}
         [:address
          [:strong "Headquarters:"]
          [:br] "795 Folsom Ave, Suite 600"
          [:br] "San Francisco, CA 94107"
          [:br]]
         [:abbr {:title "Phone Number"}
          [:strong "Phone:"]] " (91) 8547 632521"
         [:br]
         [:abbr {:title "Fax"}
          [:strong "Fax:"]] " (91) 11 4752 1433"
         [:br]
         [:abbr {:title "Email Address"}
          [:strong "Email:"]] " info@canvas.com"]]]
      [:div {:class "col_one_third"}
       [:div {:class "widget widget_links clearfix"}
        [:h4 "Blogroll"]
        [:ul
         [:li
          [:a {:href "http://codex.wordpress.org/"} "Documentation"]]
         [:li
          [:a {:href "http://wordpress.org/support/forum/requests-and-feedback"} "Feedback"]]
         [:li
          [:a {:href "http://wordpress.org/extend/plugins/"} "Plugins"]]
         [:li
          [:a {:href "http://wordpress.org/support/"} "Support Forums"]]
         [:li
          [:a {:href "http://wordpress.org/extend/themes/"} "Themes"]]
         [:li
          [:a {:href "http://wordpress.org/news/"} "WordPress Blog"]]
         [:li
          [:a {:href "http://planet.wordpress.org/"} "WordPress Planet"]]]]]
      [:div {:class "col_one_third col_last"}
       [:div {:class "widget clearfix"}
        [:h4 "Recent Posts"]
        [:div {:id "post-list-footer"}
         [:div {:class "spost clearfix"}
          [:div {:class "entry-c"}
           [:div {:class "entry-title"}
            [:h4
             [:a {:href "#"} "Lorem ipsum dolor sit amet, consectetur"]]]
           [:ul {:class "entry-meta"}
            [:li "10th July 2014"]]]]
         [:div {:class "spost clearfix"}
          [:div {:class "entry-c"}
           [:div {:class "entry-title"}
            [:h4
             [:a {:href "#"} "Elit Assumenda vel amet dolorum quasi"]]]
           [:ul {:class "entry-meta"}
            [:li "10th July 2014"]]]]
         [:div {:class "spost clearfix"}
          [:div {:class "entry-c"}
           [:div {:class "entry-title"}
            [:h4
             [:a {:href "#"} "Debitis nihil placeat, illum est nisi"]]]
           [:ul {:class "entry-meta"}
            [:li "10th July 2014"]]]]]]]]
     [:div {:class "col_one_third col_last"}
      [:div {:style "margin-bottom: -20px;", :class "widget clearfix"}
       [:div {:class "row"}
        [:div {:class "col-md-6 bottommargin-sm"}
         [:div {:class "counter counter-small"}
          [:span {:data-comma "true", :data-speed "3000", :data-refresh-interval "80", :data-to "15065421", :data-from "50"}]]
         [:h5 {:class "nobottommargin"} "Total Downloads"]]
        [:div {:class "col-md-6 bottommargin-sm"}
         [:div {:class "counter counter-small"}
          [:span {:data-comma "true", :data-speed "2000", :data-refresh-interval "50", :data-to "18465", :data-from "100"}]]
         [:h5 {:class "nobottommargin"} "Clients"]]]]
      [:div {:class "widget subscribe-widget clearfix"}
       [:h5
        [:strong "Subscribe"] " to Our Newsletter to get Important News, Amazing Offers &amp; Inside Scoops:"]
       [:div {:data-notify-type "success", :id "widget-subscribe-form-result"}]
       [:form {:class "nobottommargin", :method "post", :role "form", :action "include/subscribe.php", :id "widget-subscribe-form"}
        [:div {:class "input-group divcenter"}
         [:span {:class "input-group-addon"}
          [:i {:class "icon-email2"}]]
         [:input {:type "email", :placeholder "Enter your Email", :class "form-control required email", :name "widget-subscribe-form-email", :id "widget-subscribe-form-email"}]
         [:span {:class "input-group-btn"}
          [:button {:type "submit", :class "btn btn-success"} "Subscribe"]]]]
       [:script {:type "text/javascript"} "$(\"#widget-subscribe-form\").validate({submitHandler: function(form) {$(form).find('.input-group-addon').find('.icon-email2').removeClass('icon-email2').addClass('icon-line-loader icon-spin');\n\t\t\t\t\t\t\t\t\t\t$(form).ajaxSubmit({\n\t\t\t\t\t\t\t\t\t\t\ttarget: '#widget-subscribe-form-result',\n\t\t\t\t\t\t\t\t\t\t\tsuccess: function() {\n\t\t\t\t\t\t\t\t\t\t\t\t$(form).find('.input-group-addon').find('.icon-line-loader').removeClass('icon-line-loader icon-spin').addClass('icon-email2');\n\t\t\t\t\t\t\t\t\t\t\t\t$('#widget-subscribe-form').find('.form-control').val('');\n\t\t\t\t\t\t\t\t\t\t\t\t$('#widget-subscribe-form-result').attr('data-notify-msg', $('#widget-subscribe-form-result').html()).html('');SEMICOLON.widget.notifications($('#widget-subscribe-form-result'));}});}});"]]
      [:div {:style "margin-bottom: -20px;", :class "widget clearfix"}
       [:div {:class "row"}
        [:div {:class "col-md-6 clearfix bottommargin-sm"}
         [:a {:style "margin-right: 10px;", :class "social-icon si-dark si-colored si-facebook nobottommargin", :href "#"}
          [:i {:class "icon-facebook"}]
          [:i {:class "icon-facebook"}]]
         [:a {:href "#"}
          [:small {:style "display: block; margin-top: 3px;"}
           [:strong "Like us"]
           [:br] "on Facebook"]]]
        [:div {:class "col-md-6 clearfix"}
         [:a {:style "margin-right: 10px;", :class "social-icon si-dark si-colored si-rss nobottommargin", :href "#"}
          [:i {:class "icon-rss"}]
          [:i {:class "icon-rss"}]]
         [:a {:href "#"}
          [:small {:style "display: block; margin-top: 3px;"}
           [:strong "Subscribe"]
           [:br] "to RSS Feeds"]]]]]]]]
   [:div {:id "copyrights"}
    [:div {:class "container clearfix"}
     [:div {:class "col_half"} "Copyrights © 2014 All Rights Reserved by Canvas Inc."
      [:br]
      [:div {:class "copyright-links"}
       [:a {:href "#"} "Terms of Use"] " / "
       [:a {:href "#"} "Privacy Policy"]]]
     [:div {:class "col_half col_last tright"}
      [:div {:class "fright clearfix"}
       [:a {:class "social-icon si-small si-borderless si-facebook", :href "#"}
        [:i {:class "icon-facebook"}]
        [:i {:class "icon-facebook"}]]
       [:a {:class "social-icon si-small si-borderless si-twitter", :href "#"}
        [:i {:class "icon-twitter"}]
        [:i {:class "icon-twitter"}]]
       [:a {:class "social-icon si-small si-borderless si-gplus", :href "#"}
        [:i {:class "icon-gplus"}]
        [:i {:class "icon-gplus"}]]
       [:a {:class "social-icon si-small si-borderless si-pinterest", :href "#"}
        [:i {:class "icon-pinterest"}]
        [:i {:class "icon-pinterest"}]]
       [:a {:class "social-icon si-small si-borderless si-vimeo", :href "#"}
        [:i {:class "icon-vimeo"}]
        [:i {:class "icon-vimeo"}]]
       [:a {:class "social-icon si-small si-borderless si-github", :href "#"}
        [:i {:class "icon-github"}]
        [:i {:class "icon-github"}]]
       [:a {:class "social-icon si-small si-borderless si-yahoo", :href "#"}
        [:i {:class "icon-yahoo"}]
        [:i {:class "icon-yahoo"}]]
       [:a {:class "social-icon si-small si-borderless si-linkedin", :href "#"}
        [:i {:class "icon-linkedin"}]
        [:i {:class "icon-linkedin"}]]]
      [:div {:class "clear"}]
      [:i {:class "icon-envelope2"}] " info@canvas.com "
      [:span {:class "middot"} "·"]
      [:i {:class "icon-headphones"}] " +91-11-6541-6369 "
      [:span {:class "middot"} "·"]
      [:i {:class "icon-skype2"}]]]]])





