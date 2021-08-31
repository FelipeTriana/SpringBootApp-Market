# Mapping the database tables into entities :elephant: :arrow_right: :leaves:

In the code you can see how i have mapped the tables in database, this is the entity–relationship model:

![img](https://i.imgur.com/gGcrC45.png)

The entity "Product" is commented with the specifications of the notations and their explanation. 

# Composite primary key

Additionally, for the primary keys composed of foreign keys from another table, an individual entity had to be created that serves to embed this primary key, this entity in our 
project is called **ComprasProductoPK** and is embedded in the entity **ComprasProducto** whit the annotation ***@EmbeddedId***
