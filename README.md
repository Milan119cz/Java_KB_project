**This program is built using Spring boot with the following properties:**  
Maven project  
Spring Boot version 3.0.4   
Java version 17  
packaging type: Jar  

Inspiration  
-----------
When creating this app, I used the skeleton of the program from user Francesco Ciulla.
[link](https://dev.to/francescoxx/java-crud-rest-api-using-spring-boot-hibernate-postgres-docker-and-docker-compose-5cln?fbclid=IwAR3o4UYXPdBAC-9EFVjzFQRO0I9zjBIi4LA8gfR5ECBfe-rExYWFF5VzMuE)  

Prerequisites  
-----------
This Rest API application is used to store the user in the database, then verify the email and update the database.
The used database is Postgres, in which two tables are automatically created. One for storing users and the other for storing authentication codes.  
I use the Docker platform to start and run the application. To automatically create containers in Docker, I use Docker Compose, which generates them from the docker-compose.yml file, in which its parameters are set.  
The application contains the class User and HashCode, which serve as the skeleton for the generated database. There are also two classes UserRepository and HashCodeRepository which are used for working with the database. The Controller class is used for adding the user and the authentication code to the database, and possibly removing it. The following UserValidation class is for verifying the correct syntax of the entered email address and phone number. Class EmailValdation is verifying email address. The last class EmailService is for sending verification emails.  

How to build
-----------
To start the application, enter ```mvn clean package -DskipTests``` in the command line, which will generate the necessary Jar file from the code.
Next, we start Docker and enter the ```docker compose up --build``` command to create all containers.

How to run and test
-----------
To verify the functionality, we open a window in some API platform (Postman) and enter the address: `localhost:8080/api/users`, switch to the POST method and enter Body, raw and JSON format.
then put in the body:  

```json
{  
    "name":"Peter",  
    "secondname":"Parker",  
    "email":"Peter.Parker@gmail.com",  
    "phone":"+917 198 156 478"  
}  
```
and we send it.  
You should receive a verification email at `http://localhost:1080/api/emails`. In it we see the addressee, subject and sent text. After clicking on the link, another window will open in Postman and we can send a command for verification.  
We can check everything in the database application (DBeaver) and make sure it works correctly.  

Experience
-----------
During programming, I learned to work with Docker, Postman, DBeaver tools. I also learned how to use the Rest controller annotation, creating a container in Docker and the basics of regex patterns. We learned how to run an application in Docker and send and receive requests from the web.  
HashCode should realistically have a stronger password, it should be text containing letters and characters.