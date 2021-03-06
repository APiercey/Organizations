(ns web.core
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]))

(defn respond-hello [_request]
  {:status 200 :body "Hello, world!"})

(def routes
  (route/expand-routes
   #{["/greet" :get respond-hello :route-name :greet]}))

(defn create-server []
  (http/create-server
   {::http/routes routes
    ::http/type   :jetty
    ::http/port   3000}))

(defn start []
  (http/start (create-server)))
