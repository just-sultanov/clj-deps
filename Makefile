repl:
		clojure -A:repl


test:
		clojure -A:test


build:
		clojure -A:build


pom:
		clojure -Spom


deploy:
		mvn deploy


.PHONY: repl test build pom deploy
