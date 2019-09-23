[![Clojars Project](https://img.shields.io/clojars/v/clj-deps.svg)](https://clojars.org/clj-deps)
[![CircleCI Status](https://circleci.com/gh/just-sultanov/clj-deps.svg?style=shield)](https://circleci.com/gh/just-sultanov/clj-deps)
[![GitHub License](https://img.shields.io/badge/license-EPL-green.svg)](https://github.com/just-sultanov/clj-deps/blob/master/LICENSE)

# clj-deps

Part of [org.clojure/tools.deps.alpha](https://github.com/clojure/tools.deps.alpha) library (from `add-lib` branch)


#### Quick Start Guide

Add the following project dependency:

```clojure
;; project.clj or build.boot
[clj-deps "0.3.33"]

;; deps.edn
{:deps {clj-deps {:mvn/version "0.3.33"}}}
```



#### Usage

```clojure
(ns example
  (:require [clj-deps.core :as deps]))

;; load library from git by https
(deps/add-lib 'org.apache.commons/commons-lang3 {:git/url "https://github.com/apache/commons-lang.git"
                                                 :sha     "c21484b730221bc87ca26553155350292aa30f0d"})
;; => true

;; load library from git by ssh
(deps/add-lib 'org.apache.commons/commons-lang3 {:git/url "git@github.com:apache/commons-lang.git"
                                                 :sha     "c21484b730221bc87ca26553155350292aa30f0d"})
;; => true

;; load library from maven
(deps/add-lib 'org.clojure/core.memoize {:mvn/version "0.7.1"})  
;; => true

;; load library from your own repository
(deps/add-lib 'group-id/artifact-id {:mvn/version "1.2.3"}
                                    {:mvn/repos {"repo-name" {:url "https://repo.org"}}})
;; => true

;; load library from local root
(deps/add-lib 'group-id/artifact-id {:local/root "/path/to/file.jar"})                             
;; => true
```



#### Development
    $ make repl
    $ make test



#### Deployment
    $ make bump
    $ make build
    $ make deploy



#### Changelog

##### v0.3.33
- tools.deps.alpha library updated to [0.7.549][changelog]

##### v0.3.31
- tools.deps.alpha library updated to [0.7.541][changelog]



#### License

Copyright © 2019 Ilshat Sultanov

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.



[changelog]: https://github.com/clojure/tools.deps.alpha/blob/master/CHANGELOG.md
