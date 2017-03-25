(ns com.lapots.platform.web.core
    (:use ring.adapter.jetty)
    (:require [ring.util.response :as response]))

; that is default handler of requests
(defn handler [request]
    (response/response
        (str "<html><body> your IP is: "
             (:remote-addr request)
             "</body></html>")))

(run-jetty handler {:port 8080 })
