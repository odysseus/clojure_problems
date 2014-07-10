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

(defn crackle-pop []
  (defn sub [ele n xs] (mapcat
                         #(concat (drop-last %) (list ele))
                         (partition n xs)))
  (let [xs (map str (range 1 31))]
    (take 25
          (sub "CracklePop" 15
               (sub "Pop" 5
                    (sub "Crackle" 3 xs))))))


(defn -main [& args]
  (def x (range 1 25))
  (def s "aaabbcdeeeeffffggghhhhiijjjjjjjjjjjjjjjjj")
  (def t (partition-by identity s))
  (def y (into [] (range 1 10)))
  (println (nn/prime-factors 600851475143))
  (println (nn/prime-factors-mult 315))
  (println (nn/improved-phi 10090))
  (println (nn/primes-in-range 1 100))
  (println (nn/goldbach 28)))
