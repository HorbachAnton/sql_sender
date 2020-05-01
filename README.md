# Sql_sender
A web application that provides an interface for executing SQL queries to a database.

# Used technologies
The following frameworks and libraries were used in the project: Spring Core, Spring MVC, Spring Security, Hibernate, Flyway, JUnit, Mockito, Hamcrest, Apache Commons Lang and Apache Commons BeanUtils.

# Used servers
The project was deployed to Apache Tomcat 8.5.

# Used DB
MySQL

# Notes
The script for creating the database is in the config folder(sql_sender.sql).

# How can you run a project?
1) install maven;
2) clone or download app;
3) change the password in the hibernate.properties file to your password for the MySQL database. The hibernate.properties file is located in the properties folder (sql_sender/src/main/resources/properties/hibernate.properties);
4) open command line in app folder;
5) enter command "mvn jetty:run";
6) open browser and enter in the address bar "http://localhost:8080/sql_sender/".
