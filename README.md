# Configuracion de Spring 

En esta rama he estado trabajando con archivos de propiedades, esto es muy útil para configurar Spring, podemos agregar nuevos perfiles con configuraciones personalizadas. 
En este ejemplo agregamos dos nuevos perfiles: dev (para desarrollo) y pdn (para producción), en dev cambiamos el puerto de la aplicación, ahora es 8090. Importante: Todos los perfiles comparten la configuración que definimos en el archivo de propiedades generales llamado application.properties, en este caso cambiamos la ruta de contexto por: /platzi-market/api
