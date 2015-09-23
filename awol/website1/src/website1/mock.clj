(ns website1.mock
  (:require
  [hiccup.core :as hc]
  [hiccup.page :as hp]))

(def links
  (list   [:link {:href "css/foundationmock.css", :type "text/css", :rel "stylesheet"}
          [:link {:href "css/stylemock.css", :type "text/css", :rel "stylesheet"}]]
          [:link {:type "text/css", :rel "stylesheet", :href "https://fonts.googleapis.com/css?family=Poiret+One"}]
          [:link {:type "text/css", :rel "stylesheet", :href "https://fonts.googleapis.com/css?family=Montserrat:400"}]))

(defn home []
  (hp/html5 [:head links]

    [:body
     [:div {:class "header"}
      [:div {:class "row"}
       [:div {:class "large-2 columns"}
        [:h1 "<!--img src=\"http://placehold.it/100x40&text=Logo\" class=\"img-responsive left\"-->"
         [:img {:style "margin-top: 3px;", :class "img-responsive right", :src "image/ZP.png"}]]]
       [:div {:class "large-9 columns"}
        [:a {:class "tombol right", :href "#"} "Login"]]
       [:div {:class "large-1 columns"}
        [:a {:class "tombol white right", :href "#"} "Take a tour"]]]]
     [:div {:class "row"}
      [:div {:class "large-12 columns"}
       [:div {:style "padding-right: 0px;", :class "panel black"}
        [:div {:class "headlines"} "Berani jawab soal disini?"]
        [:img {:class "img-responsive center-block", :src "image/MAIN.jpg"}]]
       [:div {:class "central"}
        [:a {:class "tombol large", :href "#"} "Bikin account sekarang!"]]]]
     [:div {:class "panel"}
      [:div {:class "row"}
       [:div {:class "large-4 columns"}
        [:div {:class "central"}
         [:img {:class "img-responsive center-block", :src "icons/pencil.png"}]
         [:h5 {:class "bold"} "Simulate"]
         [:div {:class "p desc"} "\n                  Simulasi ujian kamu maupun test masuk sekolah / perguruan tinggi."]]]
       [:div {:class "large-4 columns"}
        [:div {:class "central"}
         [:img {:class "img-responsive center-block", :src "icons/mapping.png"}]
         [:h5 {:class "bold"} "Integrate"]
         [:div {:class "p desc"} "\n                  Permudah kebutuhan guru dan murid dalam proses belajar mengajar sehari-hari."]]]
       [:div {:class "large-4 columns"}
        [:div {:class "central"}
         [:img {:class "img-responsive center-block", :src "icons/wand.png"}]
         [:h5 {:class "bold"} "Challenge yourself"]
         [:div {:class "p desc"} "\n                  Routinely upgrade your level / maintain your high rank position, and get free Zenius.net voucher for a year."]]]]
      [:div {:class "row"}
       [:div {:class "large-4 columns"}
        [:div {:class "central"} " "
         [:a {:class "tombol info", :href "#"} "SIMULATE"] " "]]
       [:div {:class "large-4 columns"}
        [:div {:class "central"} " "
         [:a {:class "tombol info", :href "#"} "TELL YOUR SCHOOL ABOUT IT"] " "]]
       [:div {:class "large-4 columns"}
        [:div {:class "central"} " "
         [:a {:class "tombol info", :href "#"} "TAKE THE CHALLENGE"] " "]]]]
     [:div {:class "header grey"}
      [:div {:class "row central"}
       [:div {:class "large-2 columns"} " "
        [:h6 {:class "deschead"} "DO THIS HERE"] " "]
       [:div {:class "large-2 columns"} " "
        [:h6 {:class "deschead"} "DO THIS HERE"] " "]
       [:div {:class "large-2 columns"} " "
        [:h6 {:class "deschead"} "DO THIS HERE"] " "]
       [:div {:class "large-2 columns"} " "
        [:h6 {:class "deschead"} "DO THIS HERE"] " "]
       [:div {:class "large-2 columns"} " "
        [:h6 {:class "deschead"} "DO THIS HERE"] " "]
       [:div {:class "large-2 columns"} " "
        [:h6 {:class "deschead"} "DO THIS HERE"] " "]]
      [:div {:class "row central"}
       [:div {:class "large-2 columns"} " "
        [:img {:class "img-responsive center-block", :src "icons/Tea Cup@2x.png"}] " "]
       [:div {:class "large-2 columns"} " "
        [:img {:class "img-responsive center-block", :src "icons/Bow Tie@2x.png"}] " "]
       [:div {:class "large-2 columns"} " "
        [:img {:class "img-responsive center-block", :src "icons/Desk@2x.png"}] " "]
       [:div {:class "large-2 columns"} " "
        [:img {:class "img-responsive center-block", :src "icons/Grid 10@2x.png"}] " "]
       [:div {:class "large-2 columns"} " "
        [:img {:class "img-responsive center-block", :src "icons/Stack 1@2x.png"}] " "]
       [:div {:class "large-2 columns"} " "
        [:img {:class "img-responsive center-block", :src "icons/Medicine Bottle@2x.png"}] " "]]
      [:div {:class "row central"}
       [:div {:class "large-2 columns p desc2"} "Liat progress lo. "]
       [:div {:class "large-2 columns p desc2"} "Liat rank lo diantara temen-temen lo. "]
       [:div {:class "large-2 columns p desc2"} "Menangin fasilitas belajar online selama setahun. "]
       [:div {:class "large-2 columns p desc2"} "Brag to your friends about your latest achievement. "]
       [:div {:class "large-2 columns p desc2"} "Cek perkembangan anak2 belajar. "]
       [:div {:class "large-2 columns p desc2"} "Cek tugas apa yang udah dibikin. Catetan apakah guru udah anak2 udah bikin tugas apa belum. "]]
      [:div {:class "row central"}
       [:div {:class "large-2 columns"} " "
        [:a {:class "tombol tiny", :href "#"} "Explanation"] " "]
       [:div {:class "large-2 columns"} " "
        [:a {:class "tombol tiny", :href "#"} "Explanation"] " "]
       [:div {:class "large-2 columns"} " "
        [:a {:class "tombol tiny", :href "#"} "Explanation"] " "]
       [:div {:class "large-2 columns"} " "
        [:a {:class "tombol tiny", :href "#"} "Explanation"] " "]
       [:div {:class "large-2 columns"} " "
        [:a {:class "tombol tiny", :href "#"} "Explanation"] " "]
       [:div {:class "large-2 columns"} " "
        [:a {:class "tombol tiny", :href "#"} "Explanation"] " "]]]
     [:div {:class "row"}
      [:div {:class "large-8 columns"}
       [:ul {:class "inline-list"}
        [:div {:class "headlines yellow"} " DP or Deliberate Practice "]
        [:div {:class "headlines black"} "Apaan sih DP tuh? Nih... baca di ZenBLOG "
         [:a {:class "bold", :href "#"} "&quot;Link dari artikelnya Wisnu or Sabda ttg DP&quot;"]]]
       [:ul {:class "inline-list"}
        [:h1 {:class "headlines yellow"} " Another Cool Mindblowing Content "]
        [:h3 {:class "headlines black"} "Tentang cara belajar di zenBLOG (punya Wisnu or Glenn) "
         [:a {:class "bold", :href "#"} "&quot;another link&quot;"]]]]
      [:div {:style "margin-left: 0px; padding-left: 10px; border-left: 2px solid rgb(165, 167, 89);", :class "large-4 columns"}
       [:h4 {:class "headlines yellow2"} " Testimonials "]
       [:div {:style "margin-bottom: 15px", :class "row"}
        [:div {:class "small-9 columns"}
         [:h1 {:class "commentname bold"} "IBU UJANG"]
         [:h1 {:class "commentname bold"} "Guru Berprestasi, 50 tahun"]
         [:h1 {:class "commentname bold"}]
         [:div {:class "comment commentbar"} "Ngga nyangka Saya bakal jadi kayak gini saat nemenin anak-anak belajar. Sekarang saya bisa nemenin sambil bikin makanan terus tanpa perlu ngajar mereka."]]
        [:div {:class "small-3 columns"} " "
         [:img {:class "img-responsive center-block", :src "image/person1.jpg"}] " "]]
       [:div {:style "margin-bottom: 15px", :class "row"}
        [:div {:class "small-9 columns"}
         [:h1 {:class "commentname bold"} "ZENI MOMOS"]
         [:h1 {:class "commentname bold"} "Pelajar, 12 tahun"]
         [:div {:class "comment commentbar"} "Jaman dulu saya pusing mulu mikirin pelajaran, sejak suka ngerjain soal-soal disini jadinya malah berasa refreshing pas belajar."]]
        [:div {:class "small-3 columns"} " "
         [:img {:class "img-responsive center-block", :src "image/person2.jpg"}] " "]]]]
     [:div {:class "footer"}
      [:div {:class "row"}
       [:div {:class "large-6 columns"} " "
        [:p "ALL The INFO"] " "]
       [:div {:class "large-6 columns"}]]]
     [:div {:class "footer2"}
      [:div {:class "row"}
       [:div {:class "large-12 columns"} " "
        [:h6 "Copyright stuffs."] " "]]]]))

(defn explanation []
  (hp/html5 [:head links]

    [:body
     [:div {:class "header"}
      [:div {:class "row"}
       [:div {:class "large-2 columns"}
        [:h1 "<!--img src=\"http://placehold.it/100x40&text=Logo\" class=\"img-responsive left\"-->"
         [:img {:style "margin-top: 3px;", :class "img-responsive right", :src "image/ZP.png"}]]]
       [:div {:class "large-9 columns"}
        [:a {:class "tombol right", :href "#"} "Hi AWOL"]]
       [:div {:class "large-1 columns"}
        [:a {:class "tombol white right", :href "#"} "Take a tour"]]]]

     [:div {:class "panel"}
      [:div {:class "row"}
       [:h5 {:class "bold"} "Mau dong daftarin sekolah gue"]]]

     [:div {:class "large-4 columns"}
      [:div {:class "central"}
       [:img {:class "img-responsive center-block", :src "icons/pencil.png"}]
       [:h5 {:class "bold"} "Simulate"]
       [:div {:class "p desc"} "\n Simulasi ujian kamu maupun test masuk sekolah / perguruan tinggi."]]]


     [:div {:class "row"}
      [:div {:class "large-12 columns"}
       [:div {:style "padding-right: 0px;", :class "panel black"}
        [:div {:class "headlines"} "Berani jawab soal disini?"]
        [:img {:class "img-responsive center-block", :src "image/MAIN.jpg"}]]
       [:div {:class "central"}
        [:a {:class "tombol large", :href "#"} "Bikin account sekarang!"]]]]

     [:div {:class "footer"}
      [:div {:class "row"}
       [:div {:class "large-6 columns"} " "
        [:p "ALL The INFO"] " "]
       [:div {:class "large-6 columns"}]]]

     [:div {:class "footer2"}
      [:div {:class "row"}
       [:div {:class "large-12 columns"} " "
        [:h6 "Copyright stuffs."] " "]]]]))
