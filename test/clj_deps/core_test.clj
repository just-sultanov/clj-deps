(ns clj-deps.core-test
  (:require
    [clojure.test :refer [deftest is testing]]
    [clj-deps.core :as sut]))

(deftest test-add-lib
  (testing "should be added clojure library from git by https"
    (is (sut/add-lib 'clj-fsm {:git/url "https://github.com/just-sultanov/clj-fsm.git"
                               :sha     "396f95a1f28a1fae7672bdf4793e9168abaf2990"})))

  (testing "should be added clojure library from maven"
    (is (true? (sut/add-lib 'clj-fsm {:mvn/version "0.2.2"})))))
