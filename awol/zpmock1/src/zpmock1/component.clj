(ns zpmock1.component
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

        [:link {:href "https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css", :rel "stylesheet"}]
        [:link {:href "/octicons/octicons.css", :rel "stylesheet"}]

        "<!-- One Page Module Specific Stylesheet -->"
        [:link {:type "text/css", :href "onepage.css", :rel "stylesheet"}]

        "<!--[if lt IE 9]>
        <script src=\"http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js\"></script>
        <![endif]-->"))

(def javascript
  (list [:script {:src "../js/jquery.js", :type "text/javascript"}]
        [:script {:src "../js/plugins.js", :type "text/javascript"}]))


;=============================== SIDE PANEL ===============================

(defn has-side-panel [& content]
  (list [:div {:class "body-overlay"}]
        [:div {:class " " :id "side-panel"} ;class can be "dark"
         [:div {:class "side-panel-trigger" :id "side-panel-trigger-close"}
          [:a {:href "#"} [:i {:class "icon-line-cross"}]]]
         [:div {:class "side-panel-wrap"}
          content]]))


(defn open-sider [name icon & button-style]
  [:section {:id "content"}
   [:div {:class "container"}
    [:a {:class (str "button button-rounded side-panel-trigger button-reveal" " " (first button-style)) :href "#"}
     [:i {:class icon}]
     [:span name]]]])

;=============================== SUB MENU ===============================
(def sub-menu
  [:div {:id "page-menu" :class "sticky-page-menu"}
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
  [:section {:id "page-title" :style "padding-top: 20px; padding-bottom: 0px;"}
   [:div {:class "container clearfix"}
    [:h3 {:style "margin-bottom: 5px;"} "Title of the Problem"]
    [:p {:style "margin-bottom: 20px;"} "Sub-bab atau materi dari soal"]
    [:ol {:class "breadcrumb" :style "margin-bottom: 5px;"}
     [:li [:a {:class "side-panel-trigger button-reveal"  :href "#"} "Rekomendasi Belajar"]]
     [:li [:a {:href "#"} "Browse Soal"]]]]])


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

(defn has-modal [title & content]                                          ;in :body
  [:div {:style "animation-duration: 1.5s; opacity: 1;"}
   [:div.modal.fade.bs-submit-modal-lg
    {:aria-hidden     "true"
     :aria-labelledby "mySmallModalLabel"
     :role            "dialog"
     :tabindex        "-1"
     :style           "display: none;"}
    [:div.modal-dialog.modal-lg
     [:div.modal-body
      [:div.modal-content
       [:div.modal-header
        [:button.close
         {:aria-hidden  "true"
          :data-dismiss "modal"
          :type         "button"}
         "×"]
        [:h4#myModalLabel.modal-title title]]
       [:div.modal-body
        content]]]]]])

(def has-submit-done
  (has-modal "Are you sure with your answers?"
             [:p.nobottommargin {:style "margin-top: 20px;"} "Yes and I want to see my score"]
             [:button {:type "submit" :class "button button button-leaf button-circle center" :style "margin-bottom: 15px; margin-top: 0px;" :href "#"} "Submit"]

             [:p.nobottommargin {:style "margin-top: 30px;"} "Not really, let me learn a bit more"]
             [:button {:class "button button-rounded button-3d button-large button-reveal button-large button-light button-bright-yellow" :style "margin-top: 0px; margin-bottom: 50px;" :href "https://www.zenius.net/"}
              [:i {:class "icon-signal"}]
              [:span "RECOMMENDED LEARNING"]]))

(def incomplete-submit
  (has-modal "Incomplete answers"
             [:p.nobottommargin {:style "margin-top: 20px; margin-bottom: 50px;"} "You have to make sure all questions are answered in order to see your score"]))


;=============================== PARTS ===============================
(def social1
  [:div {:class "widget quick-contact-widget clearfix" :id "s-icons"}
   [:a {:title "Facebook" :class "social-icon si-colored si-facebook" :href "#"}
    [:i {:class "icon-facebook"}] [:i {:class "icon-facebook"}]]
   [:a {:title "Twitter" :class "social-icon si-colored si-twitter" :href "#"}
    [:i {:class "icon-twitter"}] [:i {:class "icon-twitter"}]]
   [:a {:title "Github" :class "social-icon si-colored si-github" :href "#"}
    [:i {:class "icon-github"}] [:i {:class "icon-github"}]]
   [:a {:title "Google Plus" :class "social-icon si-colored si-gplus" :href "#"}
    [:i {:class "icon-gplus"}] [:i {:class "icon-gplus"}]]
   [:a {:title "Instagram" :class "social-icon si-colored si-instagram" :href "#"}
    [:i {:class "icon-instagram"}] [:i {:class "icon-instagram"}]]])

(def social2
  [:div {:class "top-links" :style "font-size: 11px;"}
   [:ul
    [:li [:a {:href "#" :style "padding-right: 16px; padding-left: 16px;"} [:span {:class "ts-icon"}
                                                                            [:i {:class "icon-facebook"}]]]]
    [:li [:a {:href "#" :style "padding-right: 16px; padding-left: 16px;"} [:span {:class "ts-icon"}
                                                                            [:i {:class "icon-twitter"}]]]]
    [:li [:a {:href "#" :style "padding-right: 16px; padding-left: 16px;"} [:span {:class "ts-icon"}
                                                                            [:i {:class "icon-instagram2"}]]]]]])

(def progress
  [:div {:class "progress" :style "height: 18px;"}
   [:div {:style "width: 60%; font-size: 12px; line-height: 14px;" :aria-valuemax "100" :aria-valuemin "0" :aria-valuenow "60" :role "progressbar" :class "progress-bar"} "60%"]])


(defn submit
  ([]
   [:button {:type "submit" :class "button button button-leaf button-circle" :data-toggle "modal" :data-target ".bs-submit-modal-lg" :style "margin-bottom: 15px; margin-top: 0px;" :href "#"} "Submit answers"])

  ([status]
   [:button {:type "submit" :class "button button-3d button-yellow button-light button-circle" :data-toggle "modal" :data-target ".bs-submit-modal-lg" :style "margin-bottom: 15px; margin-top: 0px;" :href "#"} "Submit answers"]
   [:button {:type "submit" :class "button button-3d button-yellow button-light button-circle" :style "margin-bottom: 15px; margin-top: 0px;" :href "#"}
             [:i {:class "icon-ok-right"}] "Submit answers"]))

(defn pages [status]
  [:ul {:class "pager" :style "margin-top: 0px;"}
   [:li {:class "previous"} [:a {:href "#" :style "margin-top: 1px;"} "← Previous"]]
   [:li (submit)]
   [:li {:class "next"} [:a {:href "#" :style "margin-top: 5px;"} "Next →"]]
   incomplete-submit])




;=============================== TABS ===============================
(defn tabs [content]
  [:div {:id "tab-4" :class "tabs tabs-alt tabs-tb  clearfix ui-tabs ui-widget ui-widget-content ui-corner-all"}
   [:ul {:class "tab-nav clearfix ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" :role "tablist"}
    [:li {:class "ui-state-default ui-corner-top" :role "tab" :tabindex "-1" :aria-controls "tabs-15" :aria-labelledby "ui-id-31" :aria-selected "false"}
     [:a {:href "#tabs-15" :class "ui-tabs-anchor" :role "presentation" :tabindex "-1" :id "ui-id-31"} "Soal 1"]]
    [:li {:class "ui-state-default ui-corner-top" :role "tab" :tabindex "-1" :aria-controls "tabs-15" :aria-labelledby "ui-id-31" :aria-selected "false"}
     [:a {:href "#tabs-15" :class "ui-tabs-anchor" :role "presentation" :tabindex "-1" :id "ui-id-31"} "Soal 2"]]
    [:li {:class "ui-state-default ui-corner-top" :role "tab" :tabindex "-1" :aria-controls "tabs-15" :aria-labelledby "ui-id-31" :aria-selected "false"}
     [:a {:href "#tabs-15" :class "ui-tabs-anchor" :role "presentation" :tabindex "-1" :id "ui-id-31"} "Soal 3"]]]

   [:div {:class "tab-container"}
    [:div {:id "tabs-15" :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom" :aria-labelledby "ui-id-31" :role "tabpanel" :style "display: none;" :aria-expanded "false" :aria-hidden "true"}
     content]
    [:div {:id "tabs-15" :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom" :aria-labelledby "ui-id-31" :role "tabpanel" :style "display: none;" :aria-expanded "false" :aria-hidden "true"}
     content]
    [:div {:id "tabs-15" :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom" :aria-labelledby "ui-id-31" :role "tabpanel" :style "display: none;" :aria-expanded "false" :aria-hidden "true"}
     content]]]
  ;(#(vector [:a {:href (str "#tabs-" %) :class "ui-tabs-anchor" :role "presentation" :tabindex "-1" :id (str "ui-id-" %)}] (str "Soal " %)) (inc 0))
  )

(def tabnew [:div {:id "tab-8" :class "tabs tabs-alt tabs-tb clearfix ui-tabs ui-widget ui-widget-content ui-corner-all"} "\n\n\t\t\t\t\t\t\t"
             [:ul {:class "tab-nav clearfix ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" :role "tablist"} "\n\t\t\t\t\t\t\t\t"
              [:li {:class "ui-state-default ui-corner-top ui-tabs-active ui-state-active" :role "tab" :tabindex "0" :aria-controls "tabs-29" :aria-labelledby "ui-id-13" :aria-selected "true"}
               [:a {:href "#tabs-29" :class "ui-tabs-anchor" :role "presentation" :tabindex "-1" :id "ui-id-13"}
                [:i {:class "icon-home2 norightmargin"}]]] "\n\t\t\t\t\t\t\t\t"
              [:li {:class "ui-state-default ui-corner-top" :role "tab" :tabindex "-1" :aria-controls "tabs-30" :aria-labelledby "ui-id-14" :aria-selected "false"}
               [:a {:href "#tabs-30" :class "ui-tabs-anchor" :role "presentation" :tabindex "-1" :id "ui-id-14"} "Nunc tincidunt"]] "\n\t\t\t\t\t\t\t\t"
              [:li {:class "ui-state-default ui-corner-top" :role "tab" :tabindex "-1" :aria-controls "tabs-31" :aria-labelledby "ui-id-15" :aria-selected "false"}
               [:a {:href "#tabs-31" :class "ui-tabs-anchor" :role "presentation" :tabindex "-1" :id "ui-id-15"} "Proin dolor"]] "\n\t\t\t\t\t\t\t\t"
              [:li {:class "hidden-phone ui-state-default ui-corner-top" :role "tab" :tabindex "-1" :aria-controls "tabs-32" :aria-labelledby "ui-id-16" :aria-selected "false"}
               [:a {:href "#tabs-32" :class "ui-tabs-anchor", :role "presentation", :tabindex "-1", :id "ui-id-16"} "Aenean lacinia"]] "\n\t\t\t\t\t\t\t"] "\n\n\t\t\t\t\t\t\t"
             [:div {:class "tab-container"} "\n\n\t\t\t\t\t\t\t\t"
              [:div {:id "tabs-29", :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom", :aria-labelledby "ui-id-13", :role "tabpanel", :aria-expanded "true", :aria-hidden "false"} "\n\t\t\t\t\t\t\t\t\tProin elit arcu, rutrum commodo, vehicula tempus, commodo a, risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris. Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus. Aenean tempor ullamcorper leo. Vivamus sed magna quis ligula eleifend adipiscing. Duis orci. Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique tempus lectus.\n\t\t\t\t\t\t\t\t"] "\n\t\t\t\t\t\t\t\t"
              [:div {:id "tabs-30", :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom", :aria-labelledby "ui-id-14", :role "tabpanel", :style "display: none;", :aria-expanded "false", :aria-hidden "true"} "\n\t\t\t\t\t\t\t\t\tMorbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. Aenean aliquet fringilla sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut posuere viverra nulla. Aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris consectetur tortor et purus.\n\t\t\t\t\t\t\t\t"] "\n\t\t\t\t\t\t\t\t"
              [:div {:id "tabs-31", :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom", :aria-labelledby "ui-id-15", :role "tabpanel", :style "display: none;", :aria-expanded "false", :aria-hidden "true"} "\n\t\t\t\t\t\t\t\t\t"
               [:p "Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a, lacus."] "\n\t\t\t\t\t\t\t\t\tDuis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit. Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.\n\t\t\t\t\t\t\t\t"] "\n\t\t\t\t\t\t\t\t"
              [:div {:id "tabs-32", :class "tab-content clearfix ui-tabs-panel ui-widget-content ui-corner-bottom", :aria-labelledby "ui-id-16", :role "tabpanel", :style "display: none;", :aria-expanded "false", :aria-hidden "true"} "\n\t\t\t\t\t\t\t\t\tPraesent in eros vestibulum mi adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut posuere viverra nulla. Aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris consectetur tortor et purus.\n\t\t\t\t\t\t\t\t"] "\n\n\t\t\t\t\t\t\t"] "\n\n\t\t\t\t\t\t"])



;=============================== FOOTER ===============================
(def footer
  [:footer {:class "dark", :id "footer", :style "margin-top: 0px;"}
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