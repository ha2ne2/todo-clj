;; src/todo_clj/main.clj
(ns todo-clj.main
  (:require [todo-clj.core :as core])
  (:gen-class))

(defn -main [& {:as args}]
  (println "HERE")
  (core/start-server))

;;(-main)
