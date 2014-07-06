(ns cljeuler.ninety-nine)

(defn one
  "Find the last element of a list"
  [ls]
  (let [l (seq ls)]
    (if (empty? (rest l))
      (first l)
      (one (rest l)))))

(defn two
  "Return the second to last element of a list"
  [ls]
  (let [l (seq ls)]
    (if (= (count l) 2)
      (first l)
      (two (rest l)))))

(defn three
  "Find the Kth element of a list, the first element is 1"
  [ls k]
  (let [l (seq ls)]
    (loop [l l k k c 1]
      (if (= k c)
        (first l)
        (recur (rest l) k (inc c))))))

(defn four
  "Find the number of elements in a list"
  [ls]
  (let [l (seq ls)]
    (loop [l l c 0]
      (if (empty? l)
        c
        (recur (rest l) (inc c))))))

(defn alt-four
  "Alternative answer to 4 using plain recursion"
  [ls]
  (let [l (seq ls)]
    (if (empty? l)
      0
      (if (empty? (rest l))
        1
        (+ 1 (four (rest l)))))))

(defn five
  "Reverse a list"
  [ls]
  (let [l (seq ls)]
    (loop [[h & t :as all] l fin '()]
      (if all
        (recur t (cons h fin))
        fin))))

(defn alt-five
  "Alternative form for five"
  [ls]
  (let [l (seq ls)]
    (defn iter-five [l fin]
      (if (empty? l)
        fin
        (iter-five (rest l) (cons (first l) fin))))
    (iter-five l '())))

(defn six
  "Find out whether a list is a palindrome"
  [ls]
  (let [l (seq ls)]
    (= l (five l))))
