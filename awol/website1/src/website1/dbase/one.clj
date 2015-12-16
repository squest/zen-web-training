(ns website1.dbase.one
  (:require [clj-uuid :as uid]
            [couchbase-clj.client :as cc]))

(defn uuid []
  (str (uid/v1)))
