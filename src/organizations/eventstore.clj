(ns organizations.eventstore
  (:require [mongor.core :as mg]))

(def conn (mg/connect))

(def db (mg/get-db conn "eventstore"))

(def insert
  []
  (mg/insert db "eventstore" {:some "event"}))
