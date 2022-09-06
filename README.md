# Java-Case-ABN
Tech Assignment for ABN Personal Banking

### Starting up the application
Run `AbnTechAssignmentApp`. This can be done via any IDE or by running `mvn clean spring-boot:run`.\
On start-up the database is pre-loaded with 3 recipes. Please use the [findAll](http://localhost:8080/swagger-ui/index.html#/recipe-controller/findAll) endpoint to see them.

### API Docs
The OpenAPI definitions are in JSON format by default. and can be found under [api-docs](http://localhost:8080/api-docs). \
If you'd like to interact with the API using Swagger UI, go to [swagger-ui](http://localhost:8080/swagger-docs).

### Searching
There are multiple ways to search for new exciting recipes.
1. Using the findAll endpoint for an overview of ALL recipes.
2. Using the findByName endpoint for an overview of all recipes containing the given name (does not need to be matching exactly)
3. Using the search endpoint for an overview of all recipes based on multiple filters (you can leave out specific filters if you do not care about them).

### Dependencies used
- Spring Boot (data jpa & web)
- Open API
- Lombok
- H2 (database)
