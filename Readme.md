# Welcome to Mechanic's Lab 

On this application you can create orders for your vehicle to be fixed.

### Running the application

Build the jar file

``./gradlew build jar``

An executable jar file will be created on the location "build\libs"

You can execute the Java Application with the following command

``java -jar mechaniclab-0.0.1-SNAPSHOT.jar``

The application and the in-memory database will be started  on port 8080 and it is ready to use

For simplicity, some data has been automatically loaded to the database.

Work stations
Vehicle types
Repair Types
Order Status
Repair Status

### Using the system

To learn how to use the system and try out the different endpoints you can use the 
Swagger documentation UI embedded on the system and hosted on the next URL:

``http://localhost:8080/swagger-ui.html``

To create a new order you can use the following "Try out" post endpoint 

``http://localhost:8080/swagger-ui.html#/order-detail-controller/saveUsingPOST``

You can use the following body for simplicity

``{
    "licensePlate": "A634221",
    "repairs": [
      {
        "name": "Replace old tires",
        "repairStatus": {
          "id": 1
        },
        "repairType": {
          "id": "2"
        }
      }
    ],
    "seatsNumber": 50,
    "vehicleCategory": {
      "id": "4"
    }
  }``
  
  Orders are placed on an Application Scoped Queue simulating a JMS Server 
  storing and retrieving orders using FIFO approach
  
  For getting next available order use the non-idempotent post method dedicated for this action
  
  ``http://localhost:8080/swagger-ui.html#/order-detail-controller/getNextAvailableOrderUsingPOST``
  
  This will retrieve the next order in queue and remove it. The order contains all repairs that needs to be done.
  These repairs can be completed using the next PUT endpoint client:
  
 `` http://localhost:8080/swagger-ui.html#/repair-controller/completeUsingPUT``  
 
 You can use this body as example value:
  
  ``{
          "id": 1,
          "name": "Replace old tires",
          "repairType": {
            "id": 2
          },
          "repairStatus": {
            "id": 1
          }
        }``
        
  After all repairs are completed, then the order is completed as well.
  
  ### Schedule
  
  An endpoint is also provided with the schedule of the work stations
  
  You can provide a "from" date and a "to" date as request parameters
  
  ``http://localhost:8080/api/workStations/schedule?from=2019-03-04&to=2019-03-09``
  
  This will return a calendar listing every day in range with their available work stations with the list of repair types 
  supported and opening and closing hours
  
  
  
