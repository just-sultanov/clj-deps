clean:
		mvn clean


repl:
		clojure -A:repl


test:
		mvn test


pom:
		clojure -Spom


bump:
		./script/bump


build:
		mvn package


deploy:
		mvn deploy


.PHONY: clean repl test pom bump build deploy
