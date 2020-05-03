(ns organizations.events
  (:require [qbits.alia :as alia])
  (:require [eventstore.sessions :as sessions])
  (:require [taoensso.nippy :as nippy]))

(defrecord OrganizationCreated
  [slug name uuid])


(defrecord Event
  [type data uuid])

(defn build-event
  [event]
  (map->Event {:data (:data event) 
               :type (:type event) 
               :uuid (:uuid event)}))

(defn fetch-events-from-event-store
  "Fetches events from the event store"
  []
  (let [session (sessions/open-session)]
    (alia/execute session "USE organizations;")
    (alia/execute session "SELECT * FROM events;")))

(defn get-events
  []
  (let [events (fetch-events-from-event-store)]
    (println (map build-event events))))

(defn testing
  []
  (let [data (nippy/freeze {:a 'a'})]
    (println data)
    (println (nippy/thaw data))))

; (defmulti parse-event-data
;   (fn [event] (class (:type event))))

; (defmethod parse-event-data OrganizationCreated
;   [event]
;   (->OrganizationCreated (:data event)))

; (defn parse-events
;   [sequenced-events]
;   (map parse-event-data sequenced-events))

