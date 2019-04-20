;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns clj-deps.libmap
  "Tools for introspecting and updating the runtime libmap.

  Original file:
  https://github.com/clojure/tools.deps.alpha/blob/add-lib/src/main/clojure/clojure/tools/deps/alpha/libmap.clj"

  (:require [clojure.edn :as edn]
            [clojure.java.io :as jio]
            [clojure.string :as str]
            [clojure.tools.deps.alpha.util.io :as uio])
  (:import (java.io File)))

(defn- read-libmap []
  (when-let [edn (System/getProperty "clojure.libmap")]
    (let [lm (edn/read-string edn)]
      (if (map? lm)
        lm
        (throw (ex-info "System property clojure.libmap should contain a map" lm))))))


(defn- read-libfile []
  (when-let [f (System/getProperty "clojure.libfile")]
    (or (uio/slurp-edn f) {})))


(defn- read-cp []
  (let [paths (str/split (System/getProperty "java.class.path") (re-pattern File/pathSeparator))
        home  (System/getProperty "user.home")
        repo  (.getCanonicalPath (jio/file home ".m2" "repository"))]
    (reduce
      (fn [lm path]
        (let [ab-path (.getCanonicalPath (jio/file path))]
          (if (str/starts-with? ab-path repo)
            (let [path-in-repo (subs ab-path (inc (count repo)))
                  [_jar version artifactId & groups] (reverse (str/split path-in-repo (re-pattern File/separator)))
                  groupId      (str/join "." (reverse groups))]
              (assoc lm (symbol groupId artifactId) {:mvn/version version :paths [path]}))
            (assoc lm (gensym "unknown") {:mvn/version "0.0.0" :paths [path]}))))
      {}
      paths)))


(defn load-lib-map
  "Load the libmap from either the clojure.libfile (a file path) or the
  clojure.libmap (edn string) system properties. These properties are
  exclusive and the behavior if both are provided is undefined. If neither
  is provided, introspect the classpath and build a lib map based on the
  standard local maven repo structure."
  []
  (or (read-libmap)
      (read-libfile)
      (read-cp)))


(def ^:private the-map
  "Runtime lib map, reflecting current loaded libs."
  (atom nil))


(defn lib-map
  "Return the runtime lib map, which may have been modified since start."
  []
  (or @the-map
      (reset! the-map (load-lib-map))))


(defn add-libs
  "Merge a lib map to the current runtime lib map"
  [libmap]
  (swap! the-map merge libmap))
