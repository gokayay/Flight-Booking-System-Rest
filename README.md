# Flight Booking System

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

This is flight booking system project that used following technologies

  - Java 8
  - Spring Boot
  - JPA Hibernate
  - Maven
  - PostgreSQL

### Directory Structure of Spring Boot Project
```bash
├── AutomationsystemApplication.java
├── config
│   └── RestConfig.java
├── constant
│   └── ConstantStrings.java
├── controller
│   ├── AirportController.java
│   ├── CompanyController.java
│   ├── FlightController.java
│   ├── RouteController.java
│   └── TicketController.java
├── exception
│   └── ObjectNotFoundException.java
├── model
│   ├── Airport.java
│   ├── Company.java
│   ├── Flight.java
│   ├── Route.java
│   └── Ticket.java
├── repository
│   ├── AirportRepository.java
│   ├── CompanyRepository.java
│   ├── FlightRepository.java
│   ├── RouteRepository.java
│   └── TicketRepository.java
└── service
    ├── AirportService.java
    ├── CompanyService.java
    ├── FlightService.java
    ├── RouteService.java
    ├── TicketOperationService.java
    ├── TicketService.java
    └── impl
        ├── AirportServiceImpl.java
        ├── CompanyServiceImpl.java
        ├── FlightServiceImpl.java
        ├── RouteServiceImpl.java
        ├── TicketOperationServiceImpl.java
        └── TicketServiceImpl.java
```

### System Architecture 

  - This is a rest service project so uses with requests.
  - We have get, post, put and delete requests in this project.

### Using the System    
--------

##### Airports and Companies

  - You can create, delete, update and get airports and companies with requests like this:
```sh
    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Airport>> findAllAirports() {
        return new ResponseEntity<>(airportService.getAllAirports(), HttpStatus.OK);
    }
```
  - You can search airports or companies by name with searching request like this:
```sh
    @GetMapping("/airport-search")
    @ResponseBody
    public ResponseEntity<List<Airport>> findAirportsBySearch(@RequestParam(value = "airport_name") String airport) {
        return new ResponseEntity<>(airportService.getAirportBySearch(airport), HttpStatus.OK);
    }
```

##### Routes, Flights and Tickets

  - You can create, delete, update and get all these tables with requests like this:
```sh
    @PostMapping(value = "")
    public ResponseEntity<String> create(@RequestBody Route route) {
        routeService.createRoute(route);
        return new ResponseEntity<>("created", HttpStatus.OK);
    }
```

  - You can search all these tables by id (ticket number, flight number) with searching request like this:
```sh
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> findOneAirport(@PathVariable Long id) {

        return new ResponseEntity(ticketService.getOneTicket(id), HttpStatus.OK);
    }
```

##### Ticket Purchase and Cancelling

  - You can purchase ticket dynamically looking to flight quota and sold tickets.
  - Every tickets have a validity and if you cancel your ticket, validity changes in your ticket flight table changes and sold number decreases.
  - You can see the ticket purchasing and cancelling system details in TicketOperationServiceImpl.java


### Requests    
--------

##### GET localhost:8080/company
```bash
[
    {
        "id": 1,
        "companyName": "Turkish Airlines",
        "companyComment": "lorem ipsum dolor sit amet"
    },
    {
        "id": 2,
        "companyName": "Pegasus Airlines",
        "companyComment": "lorem ipsum dolor sit amet"
    },
    {
        "id": 3,
        "companyName": "Wizzair",
        "companyComment": "lorem ipsum dolor sit amet"
    },
    {
        "id": 4,
        "companyName": "Delta Airlines",
        "companyComment": "lorem ipsum dolor sit amet"
    },
    {
        "id": 5,
        "companyName": "Lufthansa",
        "companyComment": "lorem ipsum dolor sit amet"
    },
    {
        "id": 6,
        "companyName": "American Airlines Group",
        "companyComment": "lorem ipsum dolor sit amet"
    },
    {
        "id": 7,
        "companyName": "Ryanair",
        "companyComment": "lorem ipsum dolor sit amet"
    },
    {
        "id": 8,
        "companyName": "IAG",
        "companyComment": "lorem ipsum dolor sit amet"
    }
]
```

##### GET localhost:8080/airport
```bash
[
    {
        "id": 1,
        "airportName": "İstanbul Airport",
        "city": "İstanbul",
        "country": "Turkey"
    },
    {
        "id": 2,
        "airportName": "Esenboga Airport",
        "city": "Ankara",
        "country": "Turkey"
    },
    {
        "id": 3,
        "airportName": "Hartsfield–Jackson Atlanta International Airport",
        "city": "Atlanta",
        "country": "United States"
    },
    {
        "id": 4,
        "airportName": "Beijing Capital International Airport",
        "city": "Beijing",
        "country": "China"
    },
    {
        "id": 5,
        "airportName": "Tokyo Haneda Airport",
        "city": "Tokyo",
        "country": "Japan"
    },
    {
        "id": 6,
        "airportName": "Dubai International Airport",
        "city": "Dubai",
        "country": "United Arab Emirates"
    },
    {
        "id": 7,
        "airportName": "London Heathrow Airport",
        "city": "London",
        "country": "United Kingdom"
    }
]
```
##### GET localhost:8080/route
```bash
[
    {
        "id": 1,
        "departure_airport": {
            "id": 1,
            "airportName": "İstanbul Airport",
            "city": "İstanbul",
            "country": "Turkey"
        },
        "destination_airport": {
            "id": 2,
            "airportName": "Esenboga Airport",
            "city": "Ankara",
            "country": "Turkey"
        }
    },
    {
        "id": 2,
        "departure_airport": {
            "id": 1,
            "airportName": "İstanbul Airport",
            "city": "İstanbul",
            "country": "Turkey"
        },
        "destination_airport": {
            "id": 3,
            "airportName": "Hartsfield–Jackson Atlanta International Airport",
            "city": "Atlanta",
            "country": "United States"
        }
    },
    {
        "id": 3,
        "departure_airport": {
            "id": 1,
            "airportName": "İstanbul Airport",
            "city": "İstanbul",
            "country": "Turkey"
        },
        "destination_airport": {
            "id": 4,
            "airportName": "Beijing Capital International Airport",
            "city": "Beijing",
            "country": "China"
        }
    },
    {
        "id": 4,
        "departure_airport": {
            "id": 1,
            "airportName": "İstanbul Airport",
            "city": "İstanbul",
            "country": "Turkey"
        },
        "destination_airport": {
            "id": 5,
            "airportName": "Tokyo Haneda Airport",
            "city": "Tokyo",
            "country": "Japan"
        }
    },
    {
        "id": 5,
        "departure_airport": {
            "id": 1,
            "airportName": "İstanbul Airport",
            "city": "İstanbul",
            "country": "Turkey"
        },
        "destination_airport": {
            "id": 6,
            "airportName": "Dubai International Airport",
            "city": "Dubai",
            "country": "United Arab Emirates"
        }
    },
    {
        "id": 6,
        "departure_airport": {
            "id": 1,
            "airportName": "İstanbul Airport",
            "city": "İstanbul",
            "country": "Turkey"
        },
        "destination_airport": {
            "id": 7,
            "airportName": "London Heathrow Airport",
            "city": "London",
            "country": "United Kingdom"
        }
    },
    {
        "id": 7,
        "departure_airport": {
            "id": 1,
            "airportName": "İstanbul Airport",
            "city": "İstanbul",
            "country": "Turkey"
        },
        "destination_airport": {
            "id": 8,
            "airportName": "Paris-Charles de Gaulle Airport",
            "city": "Paris",
            "country": "France"
        }
    },
    {
        "id": 8,
        "departure_airport": {
            "id": 1,
            "airportName": "İstanbul Airport",
            "city": "İstanbul",
            "country": "Turkey"
        },
        "destination_airport": {
            "id": 9,
            "airportName": "Amsterdam Airport Schiphol",
            "city": "Amsterdam",
            "country": "Netherlands"
        }
    },
    {
        "id": 9,
        "departure_airport": {
            "id": 2,
            "airportName": "Esenboga Airport",
            "city": "Ankara",
            "country": "Turkey"
        },
        "destination_airport": {
            "id": 1,
            "airportName": "İstanbul Airport",
            "city": "İstanbul",
            "country": "Turkey"
        }
    },
    {
        "id": 10,
        "departure_airport": {
            "id": 2,
            "airportName": "Esenboga Airport",
            "city": "Ankara",
            "country": "Turkey"
        },
        "destination_airport": {
            "id": 3,
            "airportName": "Hartsfield–Jackson Atlanta International Airport",
            "city": "Atlanta",
            "country": "United States"
        }
    }
]
```

##### GET localhost:8080/flight
```bash
[
    {
        "id": 4,
        "route": {
            "id": 15,
            "departure_airport": {
                "id": 2,
                "airportName": "Esenboga Airport",
                "city": "Ankara",
                "country": "Turkey"
            },
            "destination_airport": {
                "id": 8,
                "airportName": "Paris-Charles de Gaulle Airport",
                "city": "Paris",
                "country": "France"
            }
        },
        "company": {
            "id": 4,
            "companyName": "Delta Airlines",
            "companyComment": "lorem ipsum dolor sit amet"
        },
        "date": "2020-04-10T02:58:17.513+0000",
        "quota": 100,
        "sold": 30,
        "first_price": 340.0
    },
    {
        "id": 3,
        "route": {
            "id": 9,
            "departure_airport": {
                "id": 2,
                "airportName": "Esenboga Airport",
                "city": "Ankara",
                "country": "Turkey"
            },
            "destination_airport": {
                "id": 1,
                "airportName": "İstanbul Airport",
                "city": "İstanbul",
                "country": "Turkey"
            }
        },
        "company": {
            "id": 1,
            "companyName": "Turkish Airlines",
            "companyComment": "lorem ipsum dolor sit amet"
        },
        "date": "2020-05-05T02:58:17.513+0000",
        "quota": 140,
        "sold": 71,
        "first_price": 260.0
    },
    {
        "id": 2,
        "route": {
            "id": 3,
            "departure_airport": {
                "id": 1,
                "airportName": "İstanbul Airport",
                "city": "İstanbul",
                "country": "Turkey"
            },
            "destination_airport": {
                "id": 4,
                "airportName": "Beijing Capital International Airport",
                "city": "Beijing",
                "country": "China"
            }
        },
        "company": {
            "id": 2,
            "companyName": "Pegasus Airlines",
            "companyComment": "lorem ipsum dolor sit amet"
        },
        "date": "2020-03-13T02:58:17.513+0000",
        "quota": 200,
        "sold": 59,
        "first_price": 150.0
    }
]
```

##### GET localhost:8080/ticket
```bash
[
    {
        "id": 3,
        "flight": {
            "id": 2,
            "route": {
                "id": 3,
                "departure_airport": {
                    "id": 1,
                    "airportName": "İstanbul Airport",
                    "city": "İstanbul",
                    "country": "Turkey"
                },
                "destination_airport": {
                    "id": 4,
                    "airportName": "Beijing Capital International Airport",
                    "city": "Beijing",
                    "country": "China"
                }
            },
            "company": {
                "id": 2,
                "companyName": "Pegasus Airlines",
                "companyComment": "lorem ipsum dolor sit amet"
            },
            "date": "2020-03-13T02:58:17.513+0000",
            "quota": 200,
            "sold": 59,
            "first_price": 150.0
        },
        "person_name": "Gökay AY",
        "gender": "Male",
        "date": "2020-02-26T02:47:41.861+0000",
        "price": 120.0,
        "validity": true
    },
    {
        "id": 4,
        "flight": {
            "id": 3,
            "route": {
                "id": 9,
                "departure_airport": {
                    "id": 2,
                    "airportName": "Esenboga Airport",
                    "city": "Ankara",
                    "country": "Turkey"
                },
                "destination_airport": {
                    "id": 1,
                    "airportName": "İstanbul Airport",
                    "city": "İstanbul",
                    "country": "Turkey"
                }
            },
            "company": {
                "id": 1,
                "companyName": "Turkish Airlines",
                "companyComment": "lorem ipsum dolor sit amet"
            },
            "date": "2020-05-05T02:58:17.513+0000",
            "quota": 140,
            "sold": 71,
            "first_price": 260.0
        },
        "person_name": "Ayşe Balcı",
        "gender": "Female",
        "date": "2020-02-15T02:47:41.861+0000",
        "price": 110.0,
        "validity": true
    },
    {
        "id": 5,
        "flight": {
            "id": 4,
            "route": {
                "id": 15,
                "departure_airport": {
                    "id": 2,
                    "airportName": "Esenboga Airport",
                    "city": "Ankara",
                    "country": "Turkey"
                },
                "destination_airport": {
                    "id": 8,
                    "airportName": "Paris-Charles de Gaulle Airport",
                    "city": "Paris",
                    "country": "France"
                }
            },
            "company": {
                "id": 4,
                "companyName": "Delta Airlines",
                "companyComment": "lorem ipsum dolor sit amet"
            },
            "date": "2020-04-10T02:58:17.513+0000",
            "quota": 100,
            "sold": 30,
            "first_price": 340.0
        },
        "person_name": "Muhterem Yılmaz",
        "gender": "Female",
        "date": "2020-02-27T04:49:42.776+0000",
        "price": 200.0,
        "validity": false
    },
    {
        "id": 7,
        "flight": {
            "id": 4,
            "route": {
                "id": 15,
                "departure_airport": {
                    "id": 2,
                    "airportName": "Esenboga Airport",
                    "city": "Ankara",
                    "country": "Turkey"
                },
                "destination_airport": {
                    "id": 8,
                    "airportName": "Paris-Charles de Gaulle Airport",
                    "city": "Paris",
                    "country": "France"
                }
            },
            "company": {
                "id": 4,
                "companyName": "Delta Airlines",
                "companyComment": "lorem ipsum dolor sit amet"
            },
            "date": "2020-04-10T02:58:17.513+0000",
            "quota": 100,
            "sold": 30,
            "first_price": 340.0
        },
        "person_name": "Selim Yavuz",
        "gender": "Male",
        "date": null,
        "price": null,
        "validity": null
    },
    {
        "id": 6,
        "flight": {
            "id": 3,
            "route": {
                "id": 9,
                "departure_airport": {
                    "id": 2,
                    "airportName": "Esenboga Airport",
                    "city": "Ankara",
                    "country": "Turkey"
                },
                "destination_airport": {
                    "id": 1,
                    "airportName": "İstanbul Airport",
                    "city": "İstanbul",
                    "country": "Turkey"
                }
            },
            "company": {
                "id": 1,
                "companyName": "Turkish Airlines",
                "companyComment": "lorem ipsum dolor sit amet"
            },
            "date": "2020-05-05T02:58:17.513+0000",
            "quota": 140,
            "sold": 71,
            "first_price": 260.0
        },
        "person_name": "Hüseyin Bağcı",
        "gender": "Male",
        "date": "2020-02-21T04:49:42.776+0000",
        "price": 80.0,
        "validity": true
    },
    {
        "id": 8,
        "flight": {
            "id": 4,
            "route": {
                "id": 15,
                "departure_airport": {
                    "id": 2,
                    "airportName": "Esenboga Airport",
                    "city": "Ankara",
                    "country": "Turkey"
                },
                "destination_airport": {
                    "id": 8,
                    "airportName": "Paris-Charles de Gaulle Airport",
                    "city": "Paris",
                    "country": "France"
                }
            },
            "company": {
                "id": 4,
                "companyName": "Delta Airlines",
                "companyComment": "lorem ipsum dolor sit amet"
            },
            "date": "2020-04-10T02:58:17.513+0000",
            "quota": 100,
            "sold": 30,
            "first_price": 340.0
        },
        "person_name": "Abdüle Güzel",
        "gender": "Female",
        "date": "2020-02-27T05:33:27.590+0000",
        "price": 408.0,
        "validity": null
    }
]
```

### Database 
------
  - You can see the database schema below "/documents" folder.
    ![alt text](https://raw.githubusercontent.com/gokayay/Flight-Booking-System-Rest/master/documents/DatabaseDiagram.png)

### Code Binding 
------
  - You can also see how the things work in spring boot project below "/documents" folder.
  
![alt text](https://raw.githubusercontent.com/gokayay/Flight-Booking-System-Rest/master/documents/spring%20schema.png)

### More Info
------
- For more info, do not hesitate to contact me!