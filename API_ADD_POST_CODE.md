# Add Post Code API

Adds a post code.

* **URL**

  /postcodes


* **Method:**

  `POST`


*  **URL Params**

   None 
   

* **Data Params**

```json
{
  "code": 2000,
  "category": "DELIVERY"
}
```
  
  **Required:**

  `code=[string]`
  
  `category=[string]`
  


*  **Security**
   - Authorization Server Endpoint for retrieving authorization code and exchanging for {JWT_ACCESS_TOKEN}: /oauth/authorize
   - Authorization header: "Authorization", "Bearer {JWT_ACCESS_TOKEN}"   
  


* **Success Response:**
  * **Code:** 200
  
    **Content:** 
    
```json
{
    "code": 2000,
    "category": "DELIVERY",
    "_links": {
        "self": {
            "href": "http://localhost:8080/postcodes/35"
        },
        "postCode": {
            "href": "http://localhost:8080/postcodes/35"
        },
        "suburbs": {
            "href": "http://localhost:8080/postcodes/35/suburbs"
        }
    }
}
```
 

* **Error Response 400:**
  
  * **Code:** 400 BAD REQUEST

    **Content**
```json    
{
    "httpStatus": "409 - CONFLICT",
    "errorCode": "2e482454-5148-4bf4-9ab7-84c7f65b318f",
    "errorMessage": "Data integrity violation error. Please contact an administrator and quote '2e482454-5148-4bf4-9ab7-84c7f65b318f'"
}
```



* **Error Response 401:**
  
  * **Code:** 401 UNAUTHORIZED

    **Content**
```json
{
    "timestamp": 1498176546726,
    "status": 401,
    "error": "Unauthorized",
    "message": "Full authentication is required to access this resource",
    "path": "/postcodes"
}
```



* **Sample Call:**
    
    ```
    POST /postcodes
    ```
   
```json
{
  "code": 2000,
  "category": "DELIVERY"
}
```