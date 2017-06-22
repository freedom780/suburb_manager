# Developer Notes

## Build Technology
Gradle is used as a build automation system. Refer to [build.gradle](build.gradle) for more details on how the application is built.  

## Configuration Management
The application-dev.yml configuration file is used for development purpose only and is located outside of the main build folder structure to prevent it from being packaged into the build. 

In order to [build and deploy the application](CI_CD.md) using Bamboo infrastructure a separate version of the configuration file needs to be maintained (ideally in a separate repository) for security reasons.  

## Database Schema and Data Management
Database schema and initial data are located in the [src/main/db](src/main/db) folder.   

## Project Structure

| Package | Description |
| ------ | ------ |
| [api.error](src/main/java/au/com/aupost/suburbmanager/api/error) | Global error & Exception handling |
| api.security(src/main/java/au/com/aupost/suburbmanager/api/error) | Security machinery |


## Tests

### Full End-To-End Integration Tests

A full end-to-end integration test stack for the whole OAuth Authorisation Code flow has been introduced. 
 

### Unit Tests


