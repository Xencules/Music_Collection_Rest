# Music Collection Rest

This repository is a kind of backend-service for a music store.
It allows the users to save their album catalogue into a MySQL database with CRUD features.
Also the users are roled so that a basic user can only fetch data from the database and not create, update or delete it.

## Features by branches:
### Main:
    -   Spring Boot Rest CRUD with Global exception handling
        -   Endpoints:
            - GET ALL: http://localhost:8080/api/albums
            - GET SINGLE: http://localhost:8080/api/albums/{albumId}
            - POST (ADD ALMBUM): http://localhost:8080/api/albums
            - PUT (UPDATE): http://localhost:8080/api/albums
            - DELETE: http://localhost:8080/api/albums/{albumId}
### Sprint-Boot-REST-Security-with-JPA:
    -   Spring Boot REST CRUD with Spring Data and JPA
        -   Endpoints:
            - GET ALL: http://localhost:8080/music-api/albums
            - GET SINGLE: http://localhost:8080/music-api/albums/{albumId}
            - POST (ADD ALMBUM): http://localhost:8080/music-api/albums
            - PUT (UPDATE): http://localhost:8080/music-api/albums({id}
            - DELETE: http://localhost:8080/music-api/albums/{albumId}
### Sprint-Boot-REST-Security-with-JPA-BCrypt:
    -   Same as above, but using bcrypted credentials for passwords in the database.
        -   Endpoints:
            - GET ALL: http://localhost:8080/music-api/albums
            - GET SINGLE: http://localhost:8080/music-api/albums/{albumId}
            - POST (ADD ALMBUM): http://localhost:8080/music-api/albums
            - PUT (UPDATE): http://localhost:8080/music-api/albums({id}
            - DELETE: http://localhost:8080/music-api/albums/{albumId}


## User information
The users are split into three different roles: Employee, Manager, Admin.
There are three user stored in to the database.

pekka - EMPLOYEE

sami -  MANAGER

jorma - ADMIN

Password for users can be found in the included sql-script files.


## CRUD actions and roles:
Read all: EMPLOYEE, MANAGER, ADMIN

Read single: EMPLOYEE, MANAGER, ADMIN

Create: MANAGER, ADMIN

Update: MANAGER, ADMIN

Delete: ADMIN
