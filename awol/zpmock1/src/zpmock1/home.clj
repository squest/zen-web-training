(ns zpmock1.home
  (:require
    [hiccup.core :as hc]
    [hiccup.page :as hp]
    [zpmock1.core-components :as components]))

(def student-menu
  (list [:li {:class "current"} [:a {:data-href "#section-home", :href "#"} [:div "Home"]]]
        [:li [:a {:data-href "#section-home", :href "#"} [:div "Social"
                                                          [:li [:a {:data-href "#section-home", :href "#"} [:div "Social"]]]]]]
        [:li [:a {:data-href "#section-features", :href "#"} [:div "Learnings"]]]
        [:li [:a {:data-href "#section-pricing", :href "#"} [:div "My Class"]]]
        [:li [:a {:data-href "#section-pricing", :href "#"} [:div "My Progress"]]]))


[
 [:html
  [:head]
  [:body
   [:li
    [:a {:href "index.html"}
     [:div "Home"]]
    [:ul "\n\t\t\t\t\t\t\t\t\t"
     [:li
      [:a {:href "index-corporate.html"}
       [:div "Home - Corporate"]] "\n\t\t\t\t\t\t\t\t\t\t"
      [:ul "\n\t\t\t\t\t\t\t\t\t\t\t"
       [:li
        [:a {:href "index-corporate.html"}
         [:div "Corporate - Layout 1"]]] "\n\t\t\t\t\t\t\t\t\t\t\t"
       [:li
        [:a {:href "index-corporate-2.html"}
         [:div "Corporate - Layout 2"]]] "\n\t\t\t\t\t\t\t\t\t\t\t"
       [:li
        [:a {:href "index-corporate-3.html"}
         [:div "Corporate - Layout 3"]]] "\n\t\t\t\t\t\t\t\t\t\t\t"
       [:li
        [:a {:href "index-corporate-4.html"}
         [:div "Corporate - Layout 4"]]] "\n\t\t\t\t\t\t\t\t\t\t"] "\n\t\t\t\t\t\t\t\t\t"] "\n\t\t\t\t\t\t\t\t\t"
     [:li
      [:a {:href "index-portfolio.html"}
       [:div "Home - Portfolio"]] "\n\t\t\t\t\t\t\t\t\t\t"
      [:ul "\n\t\t\t\t\t\t\t\t\t\t\t"
       [:li
        [:a {:href "index-portfolio.html"}
         [:div "Portfolio - Layout 1"]]] "\n\t\t\t\t\t\t\t\t\t\t\t"
       [:li
        [:a {:href "index-portfolio-2.html"}
         [:div "Portfolio - Layout 2"]]] "\n\t\t\t\t\t\t\t\t\t\t\t"
       [:li
        [:a {:href "index-portfolio-3.html"}
         [:div "Portfolio - Masonry"]]] "\n\t\t\t\t\t\t\t\t\t\t\t"
       [:li
        [:a {:href "index-portfolio-4.html"}
         [:div "Portfolio - AJAX"]]] "\n\t\t\t\t\t\t\t\t\t\t"] "\n\t\t\t\t\t\t\t\t\t"] "\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t"
     [:li
      [:a {:href "index-wedding.html"}
       [:div "Home - Wedding"]]] "\n\t\t\t\t\t\t\t\t\t"
     [:li
      [:a {:href "index-restaurant.html"}
       [:div "Home - Restaurant"]]] "\n\t\t\t\t\t\t\t\t\t"
     [:li
      [:a {:href "index-events.html"}
       [:div "Home - Events"]]] "\n\t\t\t\t\t\t\t\t\t"
     [:li
      [:a {:href "index-parallax.html"}
       [:div "Home - Parallax"]]] "\n\t\t\t\t\t\t\t\t\t"
     [:li
      [:a {:href "index-app-showcase.html"}
       [:div "Home - App Showcase"]]] "\n\t\t\t\t\t\t\t\t"] "\n\t\t\t\t\t\t\t"]]]]


(defn student
  ([] (hp/html5
        [:html {:lang "en-US", :dir "ltr"}
         [:head
          components/links
          components/style
          components/javascript]

         [:body {:class "stretched side-panel-left"}

          [:div {:class "clearfix", :id "wrapper"}
           [:title "Profile Students | Zenius Prestasi"]

           (components/container-header-light
             components/ZP-short
             (components/navigation-header student-menu components/notif))]

          ]

         "<!-- Footer Scripts\n\t============================================= -->" "\n\t"
         [:script {:src "../js/functions.js", :type "text/javascript"}]])))
