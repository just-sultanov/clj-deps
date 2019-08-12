clean:
		mvn clean


repl:
		clj -A:repl


test: clean
		mvn test


pom:
		clj -Spom


bump:
		./bin/build/bump


build:
		mvn clean package


deploy:
		mvn clean deploy


.PHONY: clean repl test pom bump build deploy
