# TO-DO App
Spring boot & Angular

You can manage your Todo List with this app.

* Add Todo List
* Add Task for Todos List
* Delete Task & Todo List


### Requirement to Build & Deploy

* Firstly you need to install Java 8.
```
$ sudo apt-get install openjdk-8-jre
```
* Dependency Managment Maven (also you can build & test this API with Maven Tool)
```
$ sudo apt-get install maven
```
* PostgreSQL Server to store records
```
$ sudo apt-get install postgresql postgresql-contrib
```

### How to Build 
Firstly you need to change some properties in project to configure your own environmet.
in that file, *src/main/java/resources/application.properties*  you must set your database environmet,
```
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=<your_username>
spring.datasource.password=<your_password>

server.port=<your_available_port>

```

After that, You need to be in project root directory, to build app

```
mvn clean install

```
Then this command will generate a .jar file in to <project_path>/target 

App is ready to Deploy

```
java -jar <app_name>.jar

```
You can reach the API

* http://<your_ip_addres>:<port>/
  
After that,
You need to install **[TODO-App GUI](https://github.com/busrauman/Todo-app)** 
Please Follow that project README.md file

  
