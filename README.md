# Getting Started

## How to run using Maven
Run the next command
`./mvnw clean package && java -jar target/book-0.0.1-SNAPSHOT.jar`

## How to run using Docker
Run the next command
`./mvnw clean package && docker-compose up`

## How to test
To test you can import the collection `BookAPI.postman_collection.json` in postman, it has two requests, one to query the endpoint `/books/byCriteria` without criteria and the second to query the endpoint with a specific category.
