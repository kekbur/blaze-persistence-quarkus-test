## Run the App

`./mvnw quarkus:dev`

## Create a Person

`curl -H "Content-Type: application/json" -d '{"name":"Test"}' -X PUT "http://localhost:8080/persons/2c426b89-c102-45ad-8527-07cbbeb0a243"`

## Get a Randomly Generated Person

`curl "http://localhost:8080/persons"`

## Build a Native Docker Image

`docker build -f docker/Dockerfile.native -t blaze-persistence-quarkus-test .`
