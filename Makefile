clean:
		mvn clean


repl:
		clj -A:repl


test: clean
		mvn test


pom:
		clj -Spom


bump:
		./script/build/bump


build: test
		mvn package


deploy: build
		mvn deploy


.PHONY: clean repl test pom bump build deploy
