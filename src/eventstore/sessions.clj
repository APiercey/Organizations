(ns eventstore.sessions
  (:require [qbits.alia :as alia]))

(defn create-session
  []
  (println "Creating session")
  (let [cluster (alia/cluster {:contact-points ["localhost"] 
                               :credentials {:user "cassandra" :password "cassandra"}})] 
    (alia/connect cluster)))
