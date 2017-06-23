# Developer Notes

## Build Technology
Gradle is used as a build automation system. Refer to [build.gradle](build.gradle) for more details on how the application is built.  

## Full End-To-End Integration Tests

### How It Works

Integration tests use a [reusable OAuth access token retrieval artefact](src/test/java/au/com/aupost/suburbmanager/api/services/oauth/OAuthAccessTokenRetriever.java) for emulating OAuth 2.0 Authorisation Code flow phases as described in the [Architecture](ARCHITECTURE.md) document:

- emulate redirect to user authorization page
- emulate user accepting authorization prompt
- exchange authorisation code for access token

The artefact is used to retrieve the JWT access token which is used in every single REST API integration test for secure access to protected resources.  

 
### Scenarios
A full end-to-end REST integration test stack for the whole OAuth Authorisation Code Flow is available covering the following scenarios:

- Search by post code 
- Search by suburb name
- Secured access to adding suburb and post code combinations as described in [API Documentation](API_DOCUMENTATION.md) including:
  - happy day scenarios
  - errors 

## Structure of automated integration and unit tests 

Each integration and unit test has 3 main blocks:

- setup fixture
- exercise SUT (System Under Test)
- verify

## In-Memory Database for Integration Tests
The in-memory HSQLDB DBMS is used for integration tests 

## Configuration Management
The application-dev.yml configuration file is used for development purpose only and is located outside of the main build folder structure to prevent it from being packaged into the build. 

In order to [build and deploy the application](CI_CD.md) using Bamboo infrastructure a separate version of the configuration file needs to be maintained (ideally in a separate repository) for security reasons.  

## Database Schema and Data Management
Database schema and initial data are located in the [src/main/db](src/main/db) folder.   

## Project Structure

### Source Code Structure
| Package | Description |
| ------ | ------ |
| [api/error](src/main/java/au/com/aupost/suburbmanager/api/error) | Global error & Exception handling |
| [api/security](src/main/java/au/com/aupost/suburbmanager/api/security) | Security layer|
| [api/services](src/main/java/au/com/aupost/suburbmanager/api/services) | Spring Data Rest repositories |
| [api/validator](src/main/java/au/com/aupost/suburbmanager/api/validator) | Adapter for non-trivial custom validators |
| [model](src/main/java/au/com/aupost/suburbmanager/model) | Domain Model layer | 

### Test Code Structure
| Package | Description |
| ------ | ------ |
| [api/error](src/test/java/au/com/aupost/suburbmanager/api/error) | Global error & Exception handling unit tests |
| [api/services](src/test/java/au/com/aupost/suburbmanager/api/services) | Services integration tests (including both REST integration and DB integration tests)|
| [model](src/test/java/au/com/aupost/suburbmanager/model) | Domain model tests|


## OAuth 2.0 Authorization and Resource Servers combined  
This API application contains both Authorization Server and Resource Server. 