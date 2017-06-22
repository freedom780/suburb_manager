# API Documentation

**Find By Post Code**
----
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


**Get Suburbs**
----
Returns paginated JSON data set for all suburbs.

* **URL**

  /suburbs

* **Method:**

  `GET`

*  **URL Params**

  None 
   
* **Data Params**

  None

* **Success Response:**
  * **Code:** 200
   **Content:** 
```json
  {
  "_embedded" : {
    "postcodes" : [ {
      "code" : 3134,
      "category" : "DELIVERY",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/1"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/1"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/1/suburbs"
        }
      }
    }, {
      "code" : 3000,
      "category" : "DELIVERY",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/2"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/2"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/2/suburbs"
        }
      }
    }, {
      "code" : 3001,
      "category" : "DELIVERY",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/3"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/3"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/3/suburbs"
        }
      }
    }, {
      "code" : 3004,
      "category" : "DELIVERY",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/4"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/4"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/4/suburbs"
        }
      }
    }]
  },
  "_links" : {
    "first" : {
      "href" : "http://localhost:8080/postcodes?page=0&size=20"
    },
    "self" : {
      "href" : "http://localhost:8080/postcodes{?page,size,sort}",
      "templated" : true
    },
    "next" : {
      "href" : "http://localhost:8080/postcodes?page=1&size=20"
    },
    "last" : {
      "href" : "http://localhost:8080/postcodes?page=1&size=20"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/postcodes"
    },
    "search" : {
      "href" : "http://localhost:8080/postcodes/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 33,
    "totalPages" : 2,
    "number" : 0
  }
}
``` 
* **Error Response:**

None

* **Sample Call:**
  ```
    /suburbs
  ```


**Get Suburb**
----
Returns information about a suburb in JSON format.

* **URL**

  /suburbs/:id

* **Method:**

  `GET`

*  **URL Params**

  **Required:**
  `id=[integer]`
   
   
* **Data Params**

  None

* **Success Response:**
  * **Code:** 200
   **Content:** 
```json
{
  "name" : "Ringwood",
  "state" : "VIC",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/suburbs/1"
    },
    "suburb" : {
      "href" : "http://localhost:8080/suburbs/1"
    },
    "postCode" : {
      "href" : "http://localhost:8080/suburbs/1/postCode"
    }
  }
}  
``` 
* **Error Response:**
  * **Code:** 404 NOT FOUND 
    

* **Sample Call:**
  ```
    /suburbs
  ```






**Add Suburb**
----
Adds a suburb.

* **URL**

  /suburbs

* **Method:**

  `POST`

*  **URL Params**

  None 
   
* **Data Params**

  None

* **Success Response:**
  * **Code:** 200
   **Content:** 
```json
  {
  "_embedded" : {
    "postcodes" : [ {
      "code" : 3134,
      "category" : "DELIVERY",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/1"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/1"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/1/suburbs"
        }
      }
    }, {
      "code" : 3000,
      "category" : "DELIVERY",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/2"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/2"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/2/suburbs"
        }
      }
    }, {
      "code" : 3001,
      "category" : "DELIVERY",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/3"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/3"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/3/suburbs"
        }
      }
    }, {
      "code" : 3004,
      "category" : "DELIVERY",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/4"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/4"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/4/suburbs"
        }
      }
    }]
  },
  "_links" : {
    "first" : {
      "href" : "http://localhost:8080/postcodes?page=0&size=20"
    },
    "self" : {
      "href" : "http://localhost:8080/postcodes{?page,size,sort}",
      "templated" : true
    },
    "next" : {
      "href" : "http://localhost:8080/postcodes?page=1&size=20"
    },
    "last" : {
      "href" : "http://localhost:8080/postcodes?page=1&size=20"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/postcodes"
    },
    "search" : {
      "href" : "http://localhost:8080/postcodes/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 33,
    "totalPages" : 2,
    "number" : 0
  }
}
``` 
* **Error Response:**

None

* **Sample Call:**
  ```
    /suburbs/1
  ```

