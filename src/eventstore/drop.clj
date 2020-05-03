(ns eventstore.drop
  (:require [qbits.alia :as alia])
  (:require [eventstore.sessions :as sessions]))

(defn drop-keyspace
  "Drops the organization keyspace"
  [session]
  (println "Drop keyspace")
  (alia/execute session "DROP KEYSPACE organizations;"))

(defn -main
  "Drop the eventstore"
  []
  (let [session (sessions/open-session)] 
    (drop-keyspace session)
    (sessions/close-session session)))
