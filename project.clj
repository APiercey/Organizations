(defproject organizations "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [cc.qbits/alia-all "4.3.3"]
                 [cc.qbits/hayt "4.1.0"]
                 [io.pedestal/pedestal.service "0.5.7"]
                 [io.pedestal/pedestal.route   "0.5.7"]
                 [io.pedestal/pedestal.jetty   "0.5.7"]
                 [com.taoensso/nippy "2.14.0"]]
  :main ^:skip-aot organizations.core
  :aliases {"eventstore.create", ["run" "-m" "eventstore.create"]
            "eventstore.drop",   ["run" "-m" "eventstore.drop"]
            "eventstore.seed",   ["run" "-m" "eventstore.seed"]}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
