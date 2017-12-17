(ns todo-clj.util.validation
  (:require [bouncer.core :as b]
            [slingshot.slingshot :refer [try+ throw+]]))

(defn validate [& args]
  (let [[errors org+errors] (apply b/validate args)]
    (if (nil? errors)
      org+errors
      (throw+ {:type ::validation-error :errors errors}))))

(defmacro with-fallback [fallback & body]
  `(try+
     ~@body
     (catch [:type ::validation-error] {:keys [~'errors]}
       (~fallback ~'errors))))

;; (def a-validator {:foo bouncer.validators/required})

;; (with-fallback println
;;   (validate {:foo1 :baz} a-validator))

;; (b/validate {:foo1 :baz} a-validator)
;; [{:foo ("foo must be present")} {:foo1 :baz, :bouncer.core/errors {:foo ("foo must be present")}}]
