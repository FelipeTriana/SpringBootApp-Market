# Patron Data Mapper 

Recordar que nuestro proyecto esta contruido bajo un enfoque de dominio, asi que la solucion debe ser construida en terminos del dominio, el patron Data Mapper nos ayuda a hacer esto.
Data Mapper convierte o traduce dos objetos que pueden hacer una misma labor. 

En el ejemplo tenemos dos clases: PRODUCTO y PRODUCT, cada uno de sus atributos recibe una traduccion directa hacia la otra clase. 
OJO: No necesariamente se tienen que traducir todos los atributos, solo lo haremos con los que necesitemos, un ejemplo es el atributo codigoBarras que no esta siendo mappeado a PRODUCT.

![img](https://i.imgur.com/wJV5t2u.png)


## ¿Por qué es una buena practica usar este patron? 

  - **No exponemos directamente la base de datos a la API**: Ningun agente externo podra ver de que forma estan diseñadas nuestras tablas de la base de datos.
  
  - **Desacoplamos nuestra API de una base de datos puntual**: Si en el futuro queremos integrar una nueva base de datos con otros nombres pero para el mismo proyecto no tenemos que cambiar todo el codigo para hablar en terminos de la nueva base de datos, solamente creamos otro traductor que sirva para traducir la nueva tabla al dominio.
  
  - **Evitamos tener campos inncesarios en la API**: Existen atributos que no nos interesa llevar hasta la API porque solo tienen sentido dentro de la base de datos o la capa de la persistencia.
  
  - **Evitamos mezclar idiomas en nuestra aplicacion**: Aveces nos vemos obligados a trabajar asi porque nuestras tablas estan correlacionadas o ya estan escritas en español, este patron nos da la oportunidad de traducir esa informacion y que el dominio este escrito en un unico idioma.


# MapStruct para implementar Data Mapper en el proyecto

Vamos al sitio oficial de MapStruct: https://mapstruct.org/ y nos dirigimos a Documentation, luego a Installation (https://mapstruct.org/documentation/installation/) y buscamos la opcion de instalacion(para Gradle en nuestro caso), copiamos las dos lineas que aparecen:

implementation 'org.mapstruct:mapstruct:1.4.2.Final'
 
annotationProcessor 'org.mapstruct:mapstruct-processor:1.4.2.Final'

y las agregamos en la seccion **dependencies** de nuestro build.gradle, luego refrescamos nuestros cambios de gradle.

Finalmente desde IntelliJ Idea instalamos el plugin MapStruct Support que nos ayudara a autocompletar las estructuras de mapstruct. Para instalarlo vamos a File -> Settings -> Plugins y una vez alli lo buscamos e instalamos.


# Implementacion de Data Mapper en el proyecto

 - **Primer paso**: Crear un paquete domain, donde tendremos todos los objetos del dominio, en este caso y para efectos explicativos creamos las clases Product y Category (No confundir con las ya creadas en el paquete persistence/entity llamadas Producto y Categoria), para su creacion nos guiamos de los atributos que queremos traducir de sus correspondientes entidades. 
Por ejemplo: De la entidad Producto NO nos interesa el atributo codigoBarras, entonces no lo incluiremos en la clase Product. En este caso lo que hacemos es traducir al ingles el nombre de los atributos de la entidad Producto y generar sus correspondientes getter and setter, algo importante a resaltar es que en Product como ya estamos hablando en terminos del dominio el atributo category es de tipo Category(La clase del dominio).

 - **Segundo paso**: Crear el paquete repository dentro de domain(domain/repository). En este caso usamos como ejemplo a los productos. Lo que hicimos fue crear un nuevo repositorio dentro de dicho paquete que se encargara de indicar a todos los repositorios como se deben de comportar cuando estemos hablando en terminos de productos. Este repositorio se llama ProductRepository y es una interfaz que contiene unicamente el nombre de los metodos que queremos que cualquier repositorio que vaya a trabajar con productos tenga que implementar.

 - **Tercer paso(Orientar nuestra API al dominio con MapStruct)**: Aqui debemos convertir los objetos de dominio en los entity y viceversa utilizando MapStruct. 
En este caso convertimos Categoria en Category y Producto en Product. Para mapear en nuestros objetos de dominio los entity lo que hicimos fue que dentro de un nuevo paquete(persitence/mappers) creamos las interfaces que se encargaran de mappear los datos, en este caso se llaman CategoryMapper y ProductMapper, estas interfaces mapean cada uno de los atributos EN AMBOS SENTIDOS. Por ejemplo: Categoria a Category y de Category a Categoria(El mismo mapeo se hace con Producto y Product y viceversa por medio de su interfaz ProductMapper), luego en la definicion del repositorio veremos que este mapeo bidireccional es necesario. 
Ojo: Tambien se especifican los atributos presentes en los entity que no seran mapeados al objeto del dominio.

 - **Cuarto paso(Orientar nuestro repositorio a terminos del dominio)**: En el repositorio ubicado en persistence/ProductoRepository hicimos algunas modificaciones:

     - Se implemento el repositorio ubicado en domain/repository/ProductRepository, recordar que antes se dijo que dicho repositorio del dominio seria el que indicaria a los demas repositorios de este contexto que metodos debe implementar.

     - Se hace @Override de todos los metodos en ProductRepository y con las herramientas de java funcional y de los mappers de MapStruct definidos previamente rediseñamos los metodos de interaccion con la base de datos para convertir por ejemplo una lista de productos a una lista de products, un Producto en un Product y asi sucesivamente.


Finalmente es importante resaltar que los objetos de dominio son muy importantes dentro de nuestra aplicacion pues son los encargados de llevar toda la logica de nuestro negocio.







