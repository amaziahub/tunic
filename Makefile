.PHONY: all

build:
	./gradlew build

test:
	./gradlew test

run:
	./gradlew run

report:
	open /Users/amaziagur/code/tunic/build/reports/tests/test/index.html