.DEFAULT_GOAL := build-run

run-dist:
	./build/install/app/bin/app -h

build:
	./gradlew build

install:
	./gradlew clean install

run:
	./gradlew run --args="-h"

test:
	./gradlew test

lint:
	./gradlew checkstyleMain checkstyleTest

report:
	./gradlew jacocoTestReport

build-run:
	build run

.PHONY: build