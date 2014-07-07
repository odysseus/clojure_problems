(ns cljeuler.core
  (:require [clojure.string :as s]
            [clojure.java.io :as io]
            [cljeuler.ninety-nine :as nn]
            [cljeuler.euler :as eu])
  (:gen-class))

(defn fizzbuzz []
  (loop [n 1]
    (if (> n 25)
      nil
      (do (cond (and (= (mod n 3) 0) (= (mod n 5) 0)) (println "FizzBuzz")
                (= (mod n 3) 0) (println "Fizz")
                (= (mod n 5) 0) (println "Buzz")
                :else (println n))
          (recur (inc n))))))

(defn -main [& args]
  (def x (range 1 25))
  (println (nn/one x))
  (println (nn/two x))
  (println (nn/three x 3))
  (println (nn/four x))
  (println (nn/five x))
  (println (nn/six '(1 2 3 3 2 1)))
  (println (nn/seven '((1 2) 3 (1 2 (3)) 4 (5 4))))
  (def s "aaabbcdeeeeffffggghhhhiijjjjjjjjjjjjjjjjj")
  (println (nn/eight s))
  (println (nn/nine s))
  (println (nn/ten s))
  (println (nn/eleven s))
  (println (nn/twelve (nn/eleven s)))
  (def y (into [] (range 1 10)))
  (println (nn/fourteen y))
  (println (nn/fifteen y 3))
  (println (nn/sixteen x 3))
  (println (nn/seventeen x 10))
  (println (nn/eighteen x 0 10))
  (println (nn/nineteen x 4))
  (println (nn/twenty x 4))
  (println (nn/twenty-one x 7 0))
  (println (nn/twenty-two 5 9))
  (println (nn/twenty-three x 3))
  (println (nn/twenty-four 1 20 5))
  (println (nn/twenty-five "abcdefg")))
