(ns day2.stat
  (:require
    [clojure.string :as cs]
    [clojure.edn :as edn]))

(defn ubah [a] (Integer/parseInt a))

(defn ganti [a res prob]
  (cs/replace prob a res))

(defn gantilist
  ([a res prob] (gantilist a res prob []))
  ([a res prob ans]
   (if (empty? prob) ans
                     (recur a res (rest prob) (conj ans (ganti a res (first prob)))))))

(defn takenum [x]
  (->> x
       (gantilist #"\"" "")
       (gantilist #"/" "")
       (gantilist #" " "")
       (butlast)))

(defn datanum
  ([x] (datanum (rest x) (ubah (first x)) []))
  ([x ans] (datanum (rest x) (ubah (first x)) ans))
  ([x mul ans] (cond (empty? x) (conj ans mul)
                     (= (first x) "") (datanum (rest x) (conj ans mul))
                     :else (recur (rest x)
                                  (+ (* 10 mul) (ubah (first x)))
                                  ans))))

(def totalsess
  (->> (slurp "resources/totalsess.csv")
       (cs/split-lines)
       (drop 7)
       (gantilist #"\"" " ")
       (gantilist #"," "")
       (butlast)
       (mapv takenum)
       (mapv datanum)))


(def pagev
  (->> (slurp "resources/pagev.csv")
       (cs/split-lines)
       (drop 7)
       (gantilist #"\"" " ")
       (gantilist #"," "")
       (butlast)
       (mapv takenum)
       (mapv datanum)))

(def user
  (->> (slurp "resources/user.csv")
       (cs/split-lines)
       (drop 7)
       (gantilist #"\"" " ")
       (gantilist #"," "")
       (butlast)
       (mapv takenum)
       (mapv datanum)))

(def vidplay
  (->> (slurp "resources/vidplay.csv")
       (cs/split-lines)
       (drop 11)
       (gantilist #"\"" " ")
       (gantilist #"," "")
       (butlast)
       (mapv takenum)
       (mapv datanum)))

(def rawavgdur
  (->> (slurp "resources/avgduration.csv")
       (cs/split-lines)
       (drop 7)
       (gantilist #"," " ")
       (butlast)
       (gantilist #":" " ")
       (mapv takenum)
       (mapv datanum)))
(defn tosec [x]
  (->> (map * [1 1 1 3600 60 1] x)
       (drop 3)
       (reduce +)))
(def avgdur
  (->> (mapv #(take 3 %) rawavgdur)
       (mapv #(apply vector %))
       (#(mapv conj % (mapv tosec rawavgdur)))))


(defn cek [x] (cond (every? #(= % 4) (mapv count x)) (str " = 4")
                    (every? #(= % 6) (mapv count x)) (str " = 6")
                    :else "there's error"))

(defn permonth
  ([x] "Input should be dataname, month, year.")
  ([x y] "Input should be dataname, month, year.")
  ([x m y] (->> (filter #(= (% 2) y) x)
                (filter #(= (% 0) m))
                (apply mapv +)
                (last)
                (vector m y))))

(defn totperyear
  ([x] "Input should be dataname, year.")
  ([x y z] "Input should be dataname, year.")
  ([x y] (->> (filter #(= (% 2) y) x)
              (apply mapv +)
              (last)
              (vector y))))

(defn monthdata [x]
  (cond (= (first x) 1) [:1 (last x)]
        (= (first x) 2) [:2 (last x)]
        (= (first x) 3) [:3 (last x)]
        (= (first x) 4) [:4 (last x)]
        (= (first x) 5) [:5 (last x)]
        (= (first x) 6) [:6 (last x)]
        (= (first x) 7) [:7 (last x)]
        (= (first x) 8) [:8 (last x)]
        (= (first x) 9) [:9 (last x)]
        (= (first x) 10) [:10 (last x)]
        (= (first x) 11) [:11 (last x)]
        (= (first x) 12) [:12 (last x)]
        :else [:error (last x)]))

(defn makeperyear [x]
  (->> {:2012 (->> (map #(permonth x % 12) (range 7 13))
                   (map monthdata)
                   (flatten)
                   (apply hash-map))
        :2013 (->> (map #(permonth x % 13) (range 1 13))
                   (map monthdata)
                   (flatten)
                   (apply hash-map))
        :2014 (->> (map #(permonth x % 14) (range 1 13))
                   (map monthdata)
                   (flatten)
                   (apply hash-map))
        :2015 (->> (map #(permonth x % 15) (range 1 7))
                   (map monthdata)
                   (flatten)
                   (apply hash-map))}))

(spit "resources/answerday2/session.edn" (makeperyear totalsess))
(spit "resources/answerday2/pageview.edn" (makeperyear pagev))
(spit "resources/answerday2/user.edn" (makeperyear user))
(spit "resources/answerday2/videoplay.edn" (makeperyear vidplay))
(spit "resources/answerday2/avgduration.edn" (makeperyear avgdur))

(spit "resources/answerday2/day2.edn"
      {:session (makeperyear totalsess),
       :pageview (makeperyear pagev),
       :user (makeperyear user),
       :videoplay (makeperyear vidplay),
       :avgduration (makeperyear avgdur)})

(defn answer [x] (edn/read-string (slurp x)))
(def day2 (answer "resources/answerday2/day2.edn"))