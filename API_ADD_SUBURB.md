# Add Suburb API

Adds a suburb.

* **URL**

  /suburbs


* **Method:**

  `POST`


*  **URL Params**

   None 
   

* **Data Params**

```json
   {
     "name": "Warranwood",
     "state": "VIC",
     "postCode": "/postcodes/1"
   }
```
  
  **Required:**

  `name=[string]`
  
  `state=[string]`
  
  `postCode=[reference to post code HATEOAS resource]`
  


*  **Security**
   - Authorization Server Endpoint for retrieving authorization code and exchanging for {JWT_ACCESS_TOKEN}: /oauth/authorize
   - Authorization header: "Authorization", "Bearer {JWT_ACCESS_TOKEN}"   



* **Success Response:**
  * **Code:** 200
  
    **Content:** 
    
```json
  {
    "name": "Warranwood",
    "state": "VIC",
    "_links": {
        "self": {
            "href": "http://localhost:8080/suburbs/38"
        },
        "suburb": {
            "href": "http://localhost:8080/suburbs/38"
        },
        "postCode": {
            "href": "http://localhost:8080/suburbs/38/postCode"
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
    "timestamp": 1498176214518,
    "status": 401,
    "error": "Unauthorized",
    "message": "Full authentication is required to access this resource",
    "path": "/suburbs"
}   
```



* **Sample Call:**
    
    ```
    POST /suburbs
    ```
   
```json
    {
 		"name": "Warranwood",
  		"state": "VIC",
  		"postCode": "/postcodes/1"
    }
```