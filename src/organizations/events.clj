(ns organizations.events
  (:require [qbits.alia :as alia])
  (:require [eventstore.sessions :as sessions]))

(defrecord OrganizationCreated
  [slug name uuid])

; (defmulti parse-event-data
;   (fn [event] (class (:type event))))

; (defmethod parse-event-data OrganizationCreated
;   [event]
;   (->OrganizationCreated (:data event)))

(defn fetch-events
  "Fetches events from the event store"
  []
  (let [session (sessions/create-session)
        data (alia/execute session "SELECT * FROM events;")
        _ (println "fetched data")]
    (alia/execute session "USE organizations;")))

; (defn parse-events
;   [sequenced-events]
;   (map parse-event-data sequenced-events))

