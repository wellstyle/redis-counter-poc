#!/bin/bash
cd cloud
./mvnw spring-boot:run -pl eureka-server &

sleep 10

./mvnw spring-boot:run -pl zuul &

cd ../redis-counter
./mvnw spring-boot:run -Dserver.port=8090 &
./mvnw spring-boot:run -Dserver.port=8091 &
./mvnw spring-boot:run -Dserver.port=8092 &

