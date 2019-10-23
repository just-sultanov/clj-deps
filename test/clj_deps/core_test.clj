(ns clj-deps.core-test
  (:require
    [clojure.test :refer [deftest is testing]]
    [clj-deps.core :as sut]))

(deftest test-add-lib
  (testing "should be added java library from git by ssh"
    (let [added? (sut/add-lib 'org.apache.commons/commons-lang3 {:git/url "git@github.com:apache/commons-lang.git"
                                                                 :sha     "c21484b730221bc87ca26553155350292aa30f0d"})]
      (is (true? added?))))

  (testing "should be added clojure library from git by https"
    (let [added? (sut/add-lib 'cljdoc {:git/url "https://github.com/cljdoc/cljdoc.git"
                                       :sha     "4b3fe041ee3e35c937f2877f40209b4a62036bef"})]
      (is (true? added?))))

  (testing "should be added java library from maven"
    (let [added? (sut/add-lib 'com.google.code.gson/gson {:mvn/version "2.8.5"})]
      (is (true? added?))))

  (testing "should be added clojure library from maven"
    (let [added? (sut/add-lib 'lambdaisland/kaocha {:mvn/version "0.0-554"})]
      (is (true? added?)))))
