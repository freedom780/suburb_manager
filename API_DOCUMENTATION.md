# API Documentation

**Get Suburbs**
----
Returns paginated JSON data about all suburbs.

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

