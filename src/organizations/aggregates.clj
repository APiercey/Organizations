(ns organizations.aggregates
  (:use [organizations.events])
  (:import [organizations.events OrganizationCreated]))

(defrecord Organization
  [snug name uuid])

(defmulti transition
  (fn [orgs event]
    (class event)))

(defmethod transition OrganizationCreated
  [orgs event]
  (-> orgs
      (assoc (:uuid event) (-> {}
                               (assoc :uuid (:uuid event))
                               (assoc :slug (:slug event))
                               (assoc :name (:name event))))))

(defn build-organization
  [events]
    (assoc (reduce transition (hash-map) events) :version (count events)))
