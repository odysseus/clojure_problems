(ns cljeuler.core
  (:require [clojure.string :as s]
            [clojure.java.io :as io]
            [cljeuler.ninety-nine :as nn]
            [cljeuler.euler :as eu])
  (:gen-class))

(defn -main [& args]
  (def x (range 1 25))
  (println (nn/one x))
  (println (nn/two x))
  (println (nn/three x 3))
  (println (nn/four x))
  (println (nn/five x))
  (println (nn/six '(1 2 3 3 2 1))))
