(ns todo-clj.db.todo
  (:require [clojure.java.jdbc :as jdbc]
            [todo-clj.db :as db]))

(defn find-first-todo [id]
  (first (jdbc/query db/db-spec ["select * from todo where id = ?" id])))

(defn save-todo [title]
  (jdbc/insert! db/db-spec :todo {:title title :finished false}))

(defn find-finished []
  (jdbc/query db/db-spec "select * from todo where finished = true"))

(defn find-unfinished []
  (jdbc/query db/db-spec "select * from todo where finished = false"))

(defn update-todo [id title]
  (jdbc/update! db/db-spec :todo {:title title} ["id = ?" id]))

(defn delete-todo [id]
  (jdbc/delete! db/db-spec :todo ["id = ?" id]))

(defn finish-todo [id]
  (jdbc/update! db/db-spec :todo {:finished true} ["id = ?" id]))

(defn unfinish-todo [id]
  (jdbc/update! db/db-spec :todo {:finished false} ["id = ?" id]))






