(ns organizations.core
  (:require [organizations.aggregates :as aggr])
  (:use [organizations.events])
  (:import [organizations.events OrganizationCreated])
  (:gen-class))

(defn -main
  "The core"
  [& _args]
  (let [history [(->OrganizationCreated "test" "hello!" "1")
                 (->OrganizationCreated "test" "hello!" "2")]
        aggregate (aggr/build-organization history)
        _ (println "Org")
        _ (println aggregate)]))
