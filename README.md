# <center>Rest Zoo

This is a Spring Boot project with a REST API and Liquibase integrations, for CRUD related operations regarding the population of Giant Anteaters of a Zoo.


## <center>Data information

* The `date` format is "yyyy-MM-ddThh-mm-ss" as per established in ISO 8061. The program crash if the format isn't fulfilled


* The `length` should be in centimeters, and a rational number between `30` and `220`


* The `weight` should be in grams, and a rational number between `1600` and `50000`


* The `age` should be in years, and a positive `rational` number smaller than `31`


## <center> How to use it?


* The service root is on `localhost:8080/animals`


* To get all the animals use a `GET` request in the root: `localhost:8080/animals`


* To get a single animal, use a `GET` request on either the link `localhost:8080/animals/{name}` or `localhost:8080/animals/{id}` replacing the `{name}` with the animal's name and the `{id}` with the animal's id


* To register a new animal, use a `POST` request on the link `localhost:8080/animals` with a `json` body following this format:
  ```
  {
    "name": "unique string of <120 characters",
    "sex": "M for Masculine, F for Feminine",
    "weight": "String number between 1600 and 50000",
    "age": positive rational number smaller than 31,
    "length": "String number between 30 and 220",
    "arrivalDate": "a date in the format yyyy-MM-ddThh-mm-ss in the past"
  }```