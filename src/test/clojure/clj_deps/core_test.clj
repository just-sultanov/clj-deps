(ns clj-deps.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [clj-deps.core :as sut]))

(deftest test-add-lib
  (testing "adding java library from git by https"
    (sut/add-lib 'commons-lang {:git/url "https://github.com/apache/commons-lang.git"
                                :sha     "c21484b730221bc87ca26553155350292aa30f0d"})
    (is (= (mapv str (org.apache.commons.lang3.StringUtils/split "a.b.c" \.))
           ["a" "b" "c"]))))
