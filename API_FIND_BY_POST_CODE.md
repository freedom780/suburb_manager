# Find By Post Code API

Returns all suburbs matching a specified post code.

* **URL**

  /suburbs/search/findByPostCode?postCode=:postCode

* **Method:**

  `GET`

*  **URL Params**

   **Required:**
   `postCode=[integer]` 
   
* **Data Params**

  None

*  **Security**

  None 
  
* **Success Response:**
  * **Code:** 200
  
    **Content:** 
```json
{
    "_embedded": {
        "suburbs": [
            {
                "name": "Ringwood",
                "state": "VIC",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/suburbs/1"
                    },
                    "suburb": {
                        "href": "http://localhost:8080/suburbs/1"
                    },
                    "postCode": {
                        "href": "http://localhost:8080/suburbs/1/postCode"
                    }
                }
            },
            {
                "name": "Ringwood North",
                "state": "VIC",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/suburbs/2"
                    },
                    "suburb": {
                        "href": "http://localhost:8080/suburbs/2"
                    },
                    "postCode": {
                        "href": "http://localhost:8080/suburbs/2/postCode"
                    }
                }
            },
            {
                "name": "Warrandyte South",
                "state": "VIC",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/suburbs/3"
                    },
                    "suburb": {
                        "href": "http://localhost:8080/suburbs/3"
                    },
                    "postCode": {
                        "href": "http://localhost:8080/suburbs/3/postCode"
                    }
                }
            },
            {
                "name": "Warranwood",
                "state": "VIC",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/suburbs/4"
                    },
                    "suburb": {
                        "href": "http://localhost:8080/suburbs/4"
                    },
                    "postCode": {
                        "href": "http://localhost:8080/suburbs/4/postCode"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/suburbs/search/findByPostCode?postCode=3134"
        }
    }
} 
``` 
* **Error Response:**

  * **Code:** 400 BAD REQUEST
  
    **Content:**

```json
{
    "httpStatus": "400 - BAD_REQUEST",
    "errorCode": "fee3de82-65a2-4740-9cf6-8150b26fafe5",
    "errorMessage": "Incorrect parameter type. Please contact an administrator and quote 'fee3de82-65a2-4740-9cf6-8150b26fafe5'"
}
```

* **Sample Call:**
  ```
    /suburbs/search/findByPostCode?postCode=3134
  ```