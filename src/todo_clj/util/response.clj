(ns todo-clj.util.response
  (:require [potemkin :as p]
            [ring.util.http-response :as res]))

(defmacro import-ns [ns-sym]
  (do
    `(p/import-vars
      [~ns-sym
       ~@(map first (ns-publics ns-sym))])))

(import-ns ring.util.http-response)

(defn html [res]
  (res/content-type res "text/html; charset=utf-8"))


;; (def response #'res/response)
;; (alter-meta! #'response #(merge % (meta #'res/response)))

;; (def redirect #'res/redirect)
;; (alter-meta! #'redirect #(merge % (meta #'res/redirect)))

;; (defn html [res]
;;   (res/content-type res "text/html; charset=utf-8"))

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

