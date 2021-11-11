# Patron Data Mapper 

Recordar que nuestro proyecto esta contruido bajo un enfoque de dominio, asi que la solucion debe ser construida en terminos del dominio, el patron Data Mapper nos ayuda a hacer esto.
Data Mapper convierte o traduce dos objetos que pueden hacer una misma labor. 

En el ejemplo tenemos dos clases: PRODUCTO y PRODUCT, cada uno de sus atributos recibe una traduccion directa hacia la otra clase. 
OJO: No necesariamente se tienen que traducir todos los atributos, solo lo haremos con los que necesitemos, un ejemplo es el atributo codigoBarras que no esta siendo mappeado a PRODUCT.

![img](https://i.imgur.com/wJV5t2u.png)


## ¿Por qué es una buena practica usar este patron? 

  - *No exponemos directamente la base de datos a la API*: Ningun agente externo podra ver de que forma estan diseñadas nuestras tablas de la base de datos.
  - *Desacoplamos nuestra API de una base de datos puntual*: Si en el futuro queremos integrar una nueva base de datos con otros nombres pero para el mismo proyecto no tenemos que cambiar todo el codigo para hablar en terminos de la nueva base de datos, solamente creamos otro traductor que sirva para traducir la nueva tabla al dominio.
  - *Evitamos tener campos inncesarios en la API*: Existen atributos que no nos interesa llevar hasta la API porque solo tienen sentido dentro de la base de datos o la capa de la persistencia.
  - *Evitamos mezclar idiomas en nuestra aplicacion*: Aveces nos vemos obligados a trabajar asi porque nuestras tablas estan correlacionadas o ya estan escritas en español, este patron nos da la oportunidad de traducir esa informacion y que el dominio este escrito en un unico idioma.



