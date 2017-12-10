(ns todo-clj.db
  (:require [clojure.java.jdbc :as jdbc]))

(def db-spec
  "postgresql://ha2ne2@localhost:5432/todo_clj_dev")

(defn migrate []
  (jdbc/db-do-commands
   db-spec
   (jdbc/create-table-ddl :todo [:id :serial] [:title :varchar])))
