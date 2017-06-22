# Find By Suburb Name API

Returns all post codes matching a specified suburb name.

* **URL**

  /postcodes/search/findBySuburbName?name=:name

* **Method:**

  `GET`

*  **URL Params**

   **Required:**
   `name=[string]` 
   
* **Data Params**

  None

*  **Security**

  None 
  
* **Success Response:**
  * **Code:** 200
  
    **Content:** 
```json
{
  "_embedded" : {
    "postcodes" : [ {
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
    }, {
      "code" : 8001,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/5"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/5"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/5/suburbs"
        }
      }
    }, {
      "code" : 8045,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/6"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/6"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/6/suburbs"
        }
      }
    }, {
      "code" : 8051,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/7"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/7"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/7/suburbs"
        }
      }
    }, {
      "code" : 8060,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/8"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/8"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/8/suburbs"
        }
      }
    }, {
      "code" : 8061,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/9"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/9"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/9/suburbs"
        }
      }
    }, {
      "code" : 8066,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/10"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/10"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/10/suburbs"
        }
      }
    }, {
      "code" : 8069,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/11"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/11"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/11/suburbs"
        }
      }
    }, {
      "code" : 8070,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/12"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/12"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/12/suburbs"
        }
      }
    }, {
      "code" : 8071,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/13"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/13"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/13/suburbs"
        }
      }
    }, {
      "code" : 8100,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/14"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/14"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/14/suburbs"
        }
      }
    }, {
      "code" : 8101,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/15"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/15"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/15/suburbs"
        }
      }
    }, {
      "code" : 8102,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/16"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/16"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/16/suburbs"
        }
      }
    }, {
      "code" : 8103,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/17"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/17"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/17/suburbs"
        }
      }
    }, {
      "code" : 8107,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/18"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/18"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/18/suburbs"
        }
      }
    }, {
      "code" : 8108,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/19"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/19"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/19/suburbs"
        }
      }
    }, {
      "code" : 8111,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/20"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/20"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/20/suburbs"
        }
      }
    }, {
      "code" : 8120,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/21"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/21"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/21/suburbs"
        }
      }
    }, {
      "code" : 8205,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/22"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/22"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/22/suburbs"
        }
      }
    }, {
      "code" : 8383,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/23"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/23"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/23/suburbs"
        }
      }
    }, {
      "code" : 8386,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/24"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/24"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/24/suburbs"
        }
      }
    }, {
      "code" : 8388,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/25"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/25"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/25/suburbs"
        }
      }
    }, {
      "code" : 8390,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/26"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/26"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/26/suburbs"
        }
      }
    }, {
      "code" : 8393,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/27"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/27"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/27/suburbs"
        }
      }
    }, {
      "code" : 8394,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/28"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/28"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/28/suburbs"
        }
      }
    }, {
      "code" : 8396,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/29"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/29"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/29/suburbs"
        }
      }
    }, {
      "code" : 8399,
      "category" : "PO_BOXES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/postcodes/30"
        },
        "postCode" : {
          "href" : "http://localhost:8080/postcodes/30"
        },
        "suburbs" : {
          "href" : "http://localhost:8080/postcodes/30/suburbs"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/postcodes/search/findBySuburbName?name=Melbourne"
    }
  }
}
``` 
* **Error Response:**
   None

* **Sample Call:**
  ```
  /postcodes/search/findBySuburbName?name=Melbourne
  ```