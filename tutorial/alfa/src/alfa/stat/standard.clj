(ns alfa.stat.standard)

(defn mean
  [xs]
  (/ (reduce + xs) (count xs)))


