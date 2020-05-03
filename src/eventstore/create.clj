(ns eventstore.create
  (:require [qbits.alia :as alia])
  (:require [eventstore.sessions :as sessions]))

(defn create-and-use-keyspace
  "Setups up the keyspace and replication strategy"
  [session]
  (println "Create keyspace")
  (alia/execute session "CREATE KEYSPACE organizations
                        WITH replication = {'class': 'SimpleStrategy',
                        'replication_factor' : 3};")
  (alia/execute session "USE organizations;"))

(defn create-table
  "Creates the event table"
  [session]
  (println "Create table")
  (alia/execute session "CREATE TABLE events (
                        data varchar, 
                        type varchar,
                        executed_at timestamp,
                        uuid uuid,
                        PRIMARY KEY (uuid));"))

(defn run
  [session]
  (create-table session))

(defn -main
  "Setup the eventstore"
  []
  (sessions/with-session run))
