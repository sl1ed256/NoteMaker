# NoteMaker

Simple application Notes

## How to run

```shell
cd docker;
docker-compose up -d;
Execute script.sql for DB
mvn package
Run Application
```

The local version will be available at: http://localhost:8080/notes

## Technologies used

* Thymeleaf
* Spring Boot Web, Data, Validation
* Lombok
* Maven as a build tool
* PostgreSQL as a DBMS with Docker

## Tasks
* Create one simple note with only text.
* Editing a note in the native application window.
* Saving a note between application sessions, in any format.
* Create multiple notes in the app.
* Display a list of existing notes.
* Ability to edit any note from the list.
* Deleting notes
