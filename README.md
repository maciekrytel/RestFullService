# **Backend Developer Assignment** 

RESTful API webservice responsible for managing and storing in database simple notes 

## **What is required for running the project**

- H2 Database
- IntelliJ IDEA or your other favorite IDE with Apache Maven support
- Postman(recommended) 

## **Steps how to build and run the project**

First clone repository using Git. Then install all dependencies, build and run project using your IDE

## **Steps how to run scripts that will setup database for the project**

What you have to do, is just to install H2 Database. Then access database with running h2 desktop app or use this url: 

`http://localhost:8080/h2`

## **Example usages**

First of All, I recommend to use Postman to execute curl commands.

#### **API Endpoints:**
##### GET all Notes
`http://localhost:8080/api/model/all`

##### GET specified Note 
`http://localhost:8080/api/model/{id}`

##### POST Note 
`http://localhost:8080/api/model`

##### PUT Note 
`http://localhost:8080/api/model/{id}` with the following parameters
`{ "title": "Modified title", "content": "modified content" }`

##### DELETE Note 
`http://localhost:8080/api/model/{id}`

##### GET all versioned Notes 
`http://localhost:8080/api/model/backup/all`

##### GET all versions of particular note
`http://localhost:8080/api/model/backup/{id}`


 
 
