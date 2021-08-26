# What is JPA?

JPA is a especification of java for an ORM framework. It means that it's a series of rules that Java defines for any framework that want interact with de java database.


## JPA Annotations

JPA uses annotations to connect classes to databases tables and thus avoid doing it natively with SQL.

Annotation | Description
:---: | :---:
***@Entity**** | Indicates a java class that is represent a table of our database.
***@Table*** | It receives the name of the table to which the class is mapping.
***@column*** | It is put to the attributes of the class, it is not mandatory, it is indicated only when the name of the column is different from the name of the attribute of the table.
***@id*** & ***@EmbededID*** | The primary key of our table represented in the class. @id is used when it is a single primary key and @EmbededID when it is a composite primary key.
***@GeneratedValue*** | It allows generate values automatically for the primary keys in our classes.
***@OneToMany*** and ***@MatyToOne*** | To represent relations.

# What is Spring Data?
Spring Data is NOT an implementation of JPA, but rather it is a project that uses JPA to offer extra functionalities in the management of tasks from JAVA to databases.
Spring Data internally has several subprojects, among them: Spring Data JPA and Spring Data JDBC, to connect us to relational databases (SQL). Spring Data MongoDB and Spring Data Cassandra, are projects to connect to non-relational databases.

The main task of Spring Data is to optimize repetitive tasks.
Spring data provides us with repositories without code, they allow us to do all kinds of operations in BD (CRUD) without using a line of code.
It also provides us with transparent audits, therefore, it has an auditing engine that allows us to know when a record was inserted, when it was deleted, when it was updated in the DB, etc.

#Implementation in the project
We look for the repositories in MAVEN: ***Spring Boot Starter Data JPA***(Added with **implementation**) and ***PostgreSQL JDBC Driver***(Added with **runtimeOnly**, because only needed at runtime), the group and the name are copied in the dependencies of the build.gradle file of our project, leaving it as follows.

```java
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'

	runtimeOnly 'org.postgresql:postgresql'

	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```
After, in the application-dev.properties we added the database information for connection(We've been using a docker image of postgres):

```
#Database
spring.datasource.url=jdbc:postgresql://localhost:5432/platzimarket
spring.datasource.username=postgres
spring.datasource.password=root
```

