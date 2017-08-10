#!/bin/sh

docker-compose down \
	&& mvn -DskipTests=true clean install -P skip-integration-tests \
	&& docker-compose build && docker-compose up

