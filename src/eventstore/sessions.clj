(ns eventstore.sessions
  (:require [qbits.alia :as alia]))

(defn connect-cluster
  []
  (alia/cluster {:contact-points ["localhost"] 
                 :credentials {:user "cassandra" :password "cassandra"}}))

(defn open-session
  []
  (println "Creating session")
  (alia/connect (connect-cluster)))

(defn disconnect-cluster
  [cluster]
  (alia/shutdown cluster))

(defn with-session
  [f]
  (let [cluster (connect-cluster)
        session (alia/connect cluster)]
    (f session)))

(defn -main
  "test"
  [& _args]
  (disconnect-cluster (connect-cluster)))
