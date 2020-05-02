(ns eventstore.seed 
  (:require [qbits.alia :as alia])
  (:require [eventstore.sessions :as sessions]))

(defn seed-store
  [session]
  (println "Insert into events")
  (alia/execute session "INSERT INTO events (data, type, executed_at, uuid) VALUES('test', 'OrganizationCreated', 1, 0863fd01-938c-4779-9f5e-a31cd5b67391);")
  (alia/execute session "INSERT INTO events (data, type, executed_at, uuid) VALUES('test', 'OrganizationCreated', 2, 8dd4eef5-b7bc-4758-84f7-cb85b7d1ffc7);")
  (alia/execute session "INSERT INTO events (data, type, executed_at, uuid) VALUES('test', 'OrganizationCreated', 3, c473b0f3-4024-4f65-803d-0d2a1bf79a15);")
  (alia/execute session "INSERT INTO events (data, type, executed_at, uuid) VALUES('test', 'OrganizationCreated', 4, 06699eef-9622-4434-ba0f-632636515ed7);")
  (alia/execute session "INSERT INTO events (data, type, executed_at, uuid) VALUES('test', 'OrganizationCreated', 5, f819437a-93fb-440d-80cb-89615eaa7297);")
  (alia/execute session "INSERT INTO events (data, type, executed_at, uuid) VALUES('test', 'OrganizationCreated', 6, 44120c91-8e8c-4a26-a8d0-a491a78f673d);"))

(defn -main
  "Seeds the event store"
  []
  (let [session (sessions/create-session)]
    (alia/execute session "USE organizations;")
    (seed-store session)))


