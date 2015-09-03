(ns beleje.core
  (:require
    [beleje.scratchpad :as scratch]
    [clojure.string :as cs]
    [clojure.edn :as edn]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


;;;;;; READING CSV
(def my-sessions "dailysessions20122015")
(def my-pageviews "pageviews20122015")
(def my-video-plays "videoplays20122015")
(def my-avg-duration "avgsessionduration20122015")

;;;;;; SUPPORTING FUNCTIONS
(defn open-edn
  [fname]
  (slurp (str "resources/" fname ".csv")))

(defn take-month-year
  [a-string]
  (let [month {"1" "01" "2" "02" "3" "03" "4" "04" "5" "05" "6" "06"
               "7" "07" "8" "08" "9" "09" "10" "10" "11" "11" "12" "12"}
        a (cs/replace (apply str (take 2 a-string)) #"/" "")
        b (cs/replace (last (cs/split a-string #"/")) #"," "")]
    (str b (month a))))

(defn numberize-string
  "change number-string into number"
  [a-string]
  (if (re-find #"," a-string)
    (read-string (cs/replace a-string #"," ""))
    (read-string a-string)))

(defn split-into-2
  "There are 2 types of number, with and without ('')"
  [x]
  (if (re-find #"\"" x)
    (cs/split x #"\"")
    (cs/split x #",")))

(defn convert-duration-to-seconds
  [a-string]
  (let [item (map biginteger (cs/split a-string #":"))]
    (+ (* 3600 (first item))
       (* 60 (second item))
       (last item))))

;;;;;; MAIN FUNCTIONS
(defn monthly-sessions-pageviews
  [filename]
  (->> (open-edn filename)
       (cs/split-lines)
       (drop 7)
       (butlast)
       (map split-into-2)
       (mapv #(hash-map (take-month-year (first %)) (numberize-string (second %))))
       (reduce #(merge-with + %1 %2))))

(defn monthly-video-views
  [filename]
  (->> (open-edn filename)
       (cs/split-lines)
       (drop 11)
       (butlast)
       (map split-into-2)
       (mapv #(hash-map (take-month-year (first %)) (numberize-string (second %))))
       (reduce #(merge-with + %1 %2))))

(defn daily-avg-session-duration
  [filename]
  (->> (open-edn filename)
       (cs/split-lines)
       (drop 7)
       (butlast)
       (map split-into-2)
       (mapv #(vector (first %) (convert-duration-to-seconds (second %))))
       ))

(defn monthly-total-duration
  [sessionfile avgdurationfile]
  (let [avg-session-dur (map second (daily-avg-session-duration avgdurationfile))
        time-dur (map first (daily-avg-session-duration avgdurationfile))]
    (->> (open-edn sessionfile)
         (cs/split-lines)
         (drop 7)
         (butlast)
         (map split-into-2)
         (map #(numberize-string (second %)))
         (#(map * %1 %2) avg-session-dur)
         (map #(vector %1 %2) time-dur)
         (map #(hash-map (take-month-year (first %)) (second %)))
         (reduce #(merge-with + %1 %2)))))

(defn creating-set-of-data
  [sessionfile pageviewfile videoplayfile avgdurationfile]
  (let [monthly-session (monthly-sessions-pageviews sessionfile)
        monthly-pageviews (monthly-sessions-pageviews pageviewfile)
        monthly-video-play (monthly-video-views videoplayfile)
        monthly-total-duration (monthly-total-duration sessionfile avgdurationfile)
        take-value (fn [a-year a-map] (a-map a-year))]
    (->> (sort (keys monthly-session))
         (mapv #(into (sorted-map) (hash-map :_month %
                                             :sessions (take-value % monthly-session)
                                             :pageviews (take-value % monthly-pageviews)
                                             :videoplays (take-value % monthly-video-play)
                                             :duration (take-value % monthly-total-duration))))
         )))

;;;;;; CREATING FILE
(def spit-file (spit "./resources/assignment2.edn" (creating-set-of-data my-sessions my-pageviews my-video-plays my-avg-duration)))