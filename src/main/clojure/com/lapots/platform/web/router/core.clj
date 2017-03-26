(ns com.lapots.platform.web.router.core
    (:require [compojure.core :refer [defroutes GET ANY]]
              [liberator.core :refer [defresource resource]]
              [ring.util.response :as resp]))

(defresource rest-handler
             :handle-ok "rest response"
             :etag "fixed-etag"
             :available-media-types ["text/html"])

(defn wrapped-file-response [request]
    (println "Attempt to read index.html")
    (resp/resource-response "index.html" {:root "resources"}))

(defroutes routes
           (GET "/" request rest-handler)
           (GET "/home" request wrapped-file-response))
