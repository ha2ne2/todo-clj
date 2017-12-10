(ns todo-clj.util.response
  (:require [ring.util.response :as res]))

(def response #'res/response)
(alter-meta! #'response #(merge % (meta #'res/response)))

(def redirect #'res/redirect)
(alter-meta! #'redirect #(merge % (meta #'res/redirect)))

(defn html [res]
  (res/content-type res "text/html; charset=utf-8"))

;; (defn add1 [x] (+ 1 x))
;; (defn add2 [x] (+ 2 x))

;; (def a add1)
;; (def b #'a)
;; (def c #'b)
;; (c 0) ;=>1
;; (def a add2)
;; (c 0) ;=>2

;; (def a add1)
;; (def b a)
;; (def c b)
;; (c 0) ;=>1
;; (def a add2)
;; (c 0) ;=>1

