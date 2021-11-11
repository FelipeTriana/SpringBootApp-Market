# Implementar la anotación @Service

El servicio de dominio actua como un intermediario entre el controlador de nuestra API y el repositorio.

Modificaciones:
Creamos una nueva clase en ***domain/service*** llamada **ProductService** y la decoramos con la anotacion **@Service**. Este servicio inyecta el **ProductRepository** que OJO: ¡NO es la implementacion!(Su implementacion sería **ProductoRepository**) es simplemente la interfaz. Por medio de la anotacion **@Autowired** Spring sabrá que debe internamente inicializar un nuevo **ProductoRepository** que es la clase que en realidad esta implementada. Podemos usar **@Autowired** porque a pesar de que **ProductRepository** no tiene ninguna anotacion, **ProductoRepository** que es su implementacion SI la tiene.

Notese que el servicio esta trabajando unicamente en terminos del dominio.


# Implementar la anotación @RestController

Creamos una nueva clase en el paquete ***web/controller*** llamada ProductController y la decoramos con la anotacion **@RestController** lo que le indicara a Spring que se tratara de un controlador de una API REST. Añadimos tambien la anotacion @RequestMapping("/products") que lleva como parametro el path en el que aceptara las peticiones que le hagamos.
Luego **inyectamos el servicio** con la notacion @Autowired y ya con esto podemos llamar a lo metodos que tenemos en nuestro servicio.
Para exponer los metodos de la API debemos asignarle a cada uno la anotacion segun corresponda(@GetMapping(), @PostMapping(), @DeleteMapping()) y como parametro a 
cada anotacion se le puede asignar una ruta donde sera expuesto el metodo.



