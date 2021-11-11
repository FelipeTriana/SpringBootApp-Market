# Patron Data Mapper 

Recordar que nuestro proyecto esta contruido bajo un enfoque de dominio, asi que la solucion debe ser construida en terminos del dominio, el patron Data Mapper nos ayuda a hacer esto.
Data Mapper convierte o traduce dos objetos que pueden hacer una misma labor. En el ejemplo tenemos dos clases: PRODUCTO y PRODUCT, cada uno de sus atributos recibe una traduccion directa hacia la otra clase, OJO: No necesariamente se tienen que traducir todos los atributos, solo lo haremos con los que necesitemos, un ejemplo es el atributo codigoBarras que no esta siendo mappeado a PRODUCT.

![img](https://i.imgur.com/wJV5t2u.png)
