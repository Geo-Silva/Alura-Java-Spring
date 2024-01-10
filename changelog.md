* Version 0.1 from 01.01.2024
1. Created Github repository
2. Edited Readme.md to explain about the project
3. Created Spring Application via SpringInitializr
    1. Primaly used Dependencies
    2. Spring Boot DevTools
    3. Lombok
    4. Sring Web
    5. Flyway Migration
    6. MySQL Driver
4. Created initial structure and a HelloWorld Controller     

<hr></hr>

* Version 0.2 from 02.01.2024
1. Created pacient and medic controllers and records for DTO
2. Added Spring JPA and Validation dependencies in the pom.xml
    1. The configuration in the application.properties was also made to connect with the database
3. Created a record for the adress in both medic and pacient, that way more information can be squeezed in, making it more viewable
4. A ENUM was created to make the specialty of the medic, that way the medic record will be more consistent and clean.

<hr></hr>

* Version 0.3 from 06.01.2024
1. Created Medic and Pacient class
2. Created first flyway migration for the medic class
3. Created a Repository Interface for the medic and pacient class
4. Adress now have it's own class, to be embedded in the medic and pacient classes
5. New migration to add the telephone number column in the medic table
    1. It accepts only 11 digits, corresponding to the brazilian common telephone number (XX) XXXXX-XXXX
    > That is also validated in the DTOs
6. Added validations in the medic and pacient DTO records

<hr></hr>

* Version 0.9 from 10.01.2024
1. Created pagination and sorting methods for both medic and pacient class
2. Created a DTO for the GET requisition for both medic and pacient class, that way both return only the values present in the DTO, making tha application safer and cleaner