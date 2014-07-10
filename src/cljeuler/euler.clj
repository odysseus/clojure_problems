(ns cljeuler.euler
  (:require [clojure.string :as s]
            [clojure.java.io :as io]))

;; MultiPurpose Helper Methods

(defn sieve [s]
  (cons (first s)
        (lazy-seq (sieve (filter #(not= 0 (mod % (first s)))
                                 (rest s))))))

(defn square
  "Squares a number"
  [x]
  (* x x))

(defn is-prime?
  "Testing for primalty, 99.9% accurate"
  [n]
  (.isProbablePrime (BigInteger/valueOf n) 10))

(defn int-root
  "Finds the square root of x to the closes integer value +1,
  useful for finding factors of a number"
  [x]
  (+ (int (Math/sqrt x)) 1))

(defn threeven?
  "Tests if a number is evenly divisble by three"
  [n]
  (= (mod n 3) 0))

(defn prime
  "Tests the primality of a number, with 100% accuracy.
  Using filter and anonymous functions rather than list comprehensions"
  [n]
  (if (or (= n 2) (= n 3) (= n 5) (= n 7))
    true
    (if (or (even? n) (threeven? n))
      false
      (empty? (filter #(= (mod n %) 0) (range 3 (int-root n) 2))))))

(defn prime?
  "Tests the primality of a number, with 100% accuracy,
  this version uses a list comprehension and skips multiples of 2 and 3"
  [n]
  (if (or (= n 2) (= n 3) (= n 5) (= n 7))
    true
    (if (or (even? n) (threeven? n))
      false
      (empty? (for [x (range 5 (int-root n) 6)
                    :when (or (= (mod n x) 0) (= (mod n (+ x 2)) 0))] x)))))

(defn palindrome?
  "Determines if the number n is a palindrome"
  [n]
  (let [strn (.toString n)]
    (= (s/reverse strn) strn)))

(defn all-factors
  "Returns a list of all factors, prime and non-prime, of n"
  [n]
  (filter #(= (mod n %) 0) (range 1 (/ n 2))))

(defn prime-factors
  "Returns a list of all prime factors of n"
  [n]
  (filter #(and (= (mod n %) 0) (prime? %)) (range 1 (+ (int-root n) 1))))

(def fib-seq
  "Generates an infinite sequence of fibonacci numbers"
  ((fn rfib [a b]
     (lazy-seq (cons a (rfib b (+ a b)))))
   0 1))

;; The Problems

(defn eu1 []
  (reduce + (filter (fn [x] (or (= (mod x 3) 0) (= (mod x 5) 0))) (range 1 1000))))

(defn eu2 []
  (reduce + (filter (fn [x] (and (even? x) (< x 4000000))) (take 35 fib-seq))))

(defn eu3 []
  (last (prime-factors 600851475143)))

(defn eu4 []
  (apply max (for [x (range 100 999) y (range 100 999)
                   :when (palindrome? (* x y))]
               (* x y))))

(defn eu5 []
  (defn divisible-by-range [n r]
    (empty? (filter #(not= (mod n %) 0) (range 1 r))))
  (first (filter #(divisible-by-range % 20) (iterate #(+ 20 %) 20))))

(defn eu6 []
  (- (square (reduce + (range 1 101))) (reduce + (map square (range 1 101)))))

(defn eu7 []
  (apply max (take 10001 (filter prime? (iterate inc 2)))))

(defn eu8 []
  (let [ctoi #(Character/getNumericValue %)
        cltoil #(map ctoi %)
        prodl #(reduce * (cltoil %))]
    (def data (filter #(Character/isDigit %) (slurp (io/resource "eu8.txt"))))
    (apply max (map prodl (partition 13 1 data)))))

(defn py-trips
  "Finds a set of pythagorean triplets given m and n"
  [m n]
  (defn find-trips [m n]
    (list (- (square m) (square n)) (* 2 m n) (+ (square m) (square n))))
  (if (> n m)
    (find-trips n m)
    (find-trips m n)))

(defn eu9
  "Find the product of a, b, and c where a, b, and c are the only pythagorean
  triplets whose sum is equal to 1,000"
  []
  )

(defn combinations
  "Find all combinations of K distinct items from a set of N elements."
  [sq k]
  (if (zero? k)
    '(())
    (if (empty? sq)
      nil
      (let
        [[head & tail] sq
         with-head (combinations tail (dec k))
         without-head (combinations tail k)]
        (concat (map #(conj % head) with-head) without-head)))))


