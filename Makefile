PROJECT_NAME := springboot-com-postgres-1.0-SNAPSHOT
JAR = $(wildcard ./target/$(PROJECT_NAME).jar)

package:
	mvn clean package

env-up:
	docker-compose up

run-local: package
	java -jar $(JAR)