# Java and Spring Learning Application

In this repository I'll keep a application I used to re-learn Java and Spring, using Alura.
>Note that this project is focused on the REST API, so there's no Frontend, no graphic interface.
>>To circumvent the need for a full frontend-backend application to test the requisitions, this project will have a dedicated folder to Postman. That way, all requisitions can be propely tested. 
>
>Lastly, any comments on the application are study-direct. So whenever I feel like studying it again I can more easily understand certain aspects that are more complex and complicated
>>Due to this, the comments are in my mother tongue, Portuguese. So I can more easily and rapidly comprehend it

## Objectives

* Developing a REST API
* CRUD (Create, Read, Update, Delete)
* Validations
* Pagination and Sorting

## Technologies

* Spring Boot 3.2.1
* Java 17
* Lombok
* MySQL
* Flyway (Migration)
* JPA / Hibernate
* Maven
* Postman

## The Project Itself

This project will be about a ficticious medical clinic by the name of VollMed. They're on the need for a application to control the register of new medics, pacients and appointment schedules. Nothing that deep, but suficient enough to keep things under control.

### Side notes

* Don't forget to change the application.properties to fit your database user and password, otherwise, the application won't run! I made a placeholder there for you to change the values of the password and username to properly access your database.
>Remember that this application is running with the MySQL driver. To change to another one, simply go to the pom.xml and put the corresponding dependency in the <dependecies\> parameter. By doing that, you'll also need to change the application.properties so the values for the corresponding database match and don't forget the password and username to grant access

* To do the pagination and sorting, add to the postman requisition (or any requisition) the following params:

1. "/medicos?size=20" to make 20 values per page
2. "/medico?size=20&page=1" to make 20 values per page on the page 1
3. "/medicos?page=1" to go to the first page with the default 10 values per page
4. "/medicos?sort=crm" to sort by crom or other variable of your choice
5. "/medicos?sort=nome&size=10&page=1" to go to the first page, sort by the crm and with 20 values per page

> I added a @PageableDefault in the GET requisition to make 10 values per page and sort by nome. That way it fits best the application backlog. Still, if you add the cited params in the requisition, it will modify it anyways

