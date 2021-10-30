# Implementation of Crud Repository Methods and Query Methods

Modifications in /src/main/java/com/platzi/market/persistence/crud/ProductoCrudRepository (New interface that extends of CrudRepository, also implements some query methods
that have been used later in /src/main/java/com/platzi/market/persistence/ProductoRepository)

# What is Crud Repository interface?

 - They save too much code and implementation time.
 - They are operations in the database where we will not have to write code.
 - Repositories of Spring Data:
     - CrudRepository (Operations of crud)
     - PagingAndSortingRepository (All operations of CrudRepository but also task of paging and sorting of our repository)
     - JPARepository (It allows us to do the same as the previous two but also specific task of JPA as flush)
  

