repl:
		clj -A:repl


test:
		clj -A:test


build:
		clj -A:build


pom:
		clj -Spom


deploy:
		mvn deploy


.PHONY: repl test build pom deploy
