# HTTP API server with basic CRUD operations for Customer entity

#### Technologies: 
Spring Boot, Lombok, JpaRepository, H2, REST

#### Project description: 
The project reflects the work of basic methods: GET, POST, PUT, DELETE on the example of the model Customer. 

To test the work I recommend using `Postman`.

__POST__: `http://localhost:8080/api/customers` - create a new customer.

Body -> raw -> Text (JSON):
```json
{
    "email" : "ivanov@i.ua",
     "fullName" : "Ivan Ivanov",
     "phone" : "+380977777777"
}
```

__GET__: `http://localhost:8080/api/customers` - return all customers.

__GET__: `http://localhost:8080/api/customers/<id>` - return the client found by id.

__PUT__: `http://localhost:8080/api/customers/<id>` - update the existing customer by id.
```json
{
     "id" : 1,
     "fullName" : "Petro Petrov",
     "phone" : "+380911911911"
}
```

__DELETE__: `http://localhost:8080/api/customers/<id>` - notice the customer as deleted.


#### Автор.
[Kostiantyn Vorobiov](https://github.com/KostiantynVorobiov)
