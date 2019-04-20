[![Clojars Project](https://img.shields.io/clojars/v/clj-deps.svg)](https://clojars.org/clj-deps)
[![GitHub License](https://img.shields.io/badge/license-EPL-green.svg)](https://github.com/just-sultanov/clj-deps/blob/master/LICENSE)

# clj-deps

Part of [org.clojure/tools.deps.alpha](https://github.com/clojure/tools.deps.alpha) library (`add-lib` branch)


#### Quick Start Guide

Add the following project dependency:

```clojure
;; project.clj or build.boot
[clj-deps "0.1.0-alpha"]

;; deps.edn
{:deps {clj-deps {:mvn/version "0.1.0-alpha"}}}
```

#### Usage

```clojure
(ns example
  (:require [clj-deps.core :as deps]))

;; load library from git
(deps/add-lib 'commons-lang {:git/url "https://github.com/apache/commons-lang.git"
                             :sha     "c21484b730221bc87ca26553155350292aa30f0d"})
;; => true                             
          
          
;; load library from maven                   
(deps/add-lib 'org.clojure/core.memoize {:mvn/version "0.7.1"})                             
;; => true

```

#### Development
    $ make repl
    $ make test


#### Deployment
    $ make build
    $ make deploy


#### License

Copyright © 2019 Ilshat Sultanov

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
