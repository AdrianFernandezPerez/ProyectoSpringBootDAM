# Aplicación Taller con SpringBoot
Proyecto Java con SpringBoot de la asignatura Acceso a Datos del curso DAM

# SUPUESTO
El proyecto consiste en una aplicación java conectada con una base de datos rds de aws que se encargará de gestionar un taller de reparación de vehículos.

# DIAGRAMA DE CLASES Y CFM

->Crow'sFoot<-

![ModeloSQL](https://user-images.githubusercontent.com/78510935/173894586-3cd8a6b1-be9b-4563-9282-247bc6309b97.PNG)

# MANUAL DE USUARIO
->Inicio<- Comienza con un login si tiene una cuenta o un formulario de registro

![1LogIn](https://user-images.githubusercontent.com/78510935/173895265-7538a890-5875-4fc1-b4fd-a7da4cd02f56.PNG)
![2Registrar](https://user-images.githubusercontent.com/78510935/173895277-928d5b3f-02a2-4f66-8ae7-4aa4a184fa24.PNG)

->Datos del usuario iniciado<- Cada vez que se inicia la sesión aparecen los datos de la cuenta conectada

![3DatosUsuario](https://user-images.githubusercontent.com/78510935/173895968-38ad97ca-8665-4c21-84eb-d0bd4020beaf.PNG)

->Menú Clientes<- Aquí se mostrarán los clientes de la bd y sus vehiculos, tambien se añadiran, modificaran y podrán eliminarse.

![4MenuClientes](https://user-images.githubusercontent.com/78510935/173896040-2f2ae452-c487-44e3-8a7d-75dfe43b44b4.PNG)

->Añadir un cliente<- Tendrá que seleccionarse un vehiculo existente para añadir al cliente

![5NuevoCliente](https://user-images.githubusercontent.com/78510935/173896196-20b32e0e-1468-4094-a696-c67097949c67.PNG)

->Modificar datos del cliente<-

![6ModificarCliente](https://user-images.githubusercontent.com/78510935/173896348-127ea123-24c0-4295-a572-51eb787e2ef5.PNG)

->Añadir más vehiculos al cliente<-

![7AñadirVehiculo](https://user-images.githubusercontent.com/78510935/173896423-4db689cb-c630-495f-bfe4-dfa4bf0162a2.PNG)

->Menú Vehiculos<- Aquí se mostrarán los vehiculos de la bd y su propietario, tambien se añadiran, modificaran y podrán eliminarse.

![8MenuVehiculos](https://user-images.githubusercontent.com/78510935/173896566-0f4a332b-2dab-4b3e-8799-86a565dc8221.PNG)

->Añadir vehiculo<-

![9NuevoVehiculo](https://user-images.githubusercontent.com/78510935/173896587-8008bf21-415f-4f6b-a3c5-db87b12e6102.PNG)

->Modificar vehiculo<- Nos muestra también su propietario pero no es modificable

![10ModificarVehiculo](https://user-images.githubusercontent.com/78510935/173896627-8302fd10-ccb9-42a2-8ba9-2cdf5d881753.PNG)

# MANUAL TÉCNICO

->Carpeta del proyecto<-

![1CarpetaProyecto](https://user-images.githubusercontent.com/78510935/173898175-42c50983-ab82-46a5-9eaa-1922d8457ac3.PNG)

->Base de datos en RDS<- La bd rds se llama taller y está publicada en aws

![2BdRDS](https://user-images.githubusercontent.com/78510935/173898375-e6fa240a-e785-404e-8cb9-90e66d2c644b.PNG)

->Datos de la bd<-

![3DatosBD](https://user-images.githubusercontent.com/78510935/173898788-c29253a3-2b60-48f5-add0-02855182b76e.PNG)

->Archivo de conexión a la bd<-

![4ConexionBD](https://user-images.githubusercontent.com/78510935/173899273-7bc0a964-42b5-4c1b-bcb3-3eec405ff0b8.PNG)

->Aquí comienza la ejecución de la aplicación<-

![5AquiComienza](https://user-images.githubusercontent.com/78510935/173899330-d5093cf5-44ef-4ed1-9a79-a851377d2ef3.PNG)

->Si queremos acceder a la aplicación<- Nos redirecciona al login

![6](https://user-images.githubusercontent.com/78510935/173899524-f6f91d71-1146-4f9d-acd1-659c25c6f072.PNG)

->Una vez creada la cuenta o iniciado<- Nos manda al formulario de datos del user

![7](https://user-images.githubusercontent.com/78510935/173899670-e69085f5-26f5-4f9e-8eb1-b3afe3edbcf5.PNG)


->Listar clientes<- Comprobará que exista una session si no nos redirecciona al login

![8](https://user-images.githubusercontent.com/78510935/173899881-a082df13-d6b6-4795-9710-d1ee682d7976.PNG)


# PROPUESTAS DE MEJORA
Implementación del menú mecanicos y reparaciones, para poder añadirlos a las reparaciones y sus respectivos vehiculos etc.
Menú para ver los datos del usuario iniciado y no solo en el inicio del login.
Control de excepciones y errores y mostrarle bien lo que sucede al usuario en todo momento.
También hay que añadir el codigo de la entidad tractor, moto y posibles añadidos.

# CONCLUSIONES
En conclusión, la aplicación está destinada a todo aquel taller que quiera tener un control y acceso a todo lo que sucede en su entorno de trabajo, tanto las reparaciones actuales, las finalizadas y el control de lo que hacen sus trabajadores en todo momento.
Esta aplicación es sencilla de manejar y intuitiva para todos los perfiles de trabajadores.
En un futuro lleno de nuevas implementaciones y mejoras, esta aplicación estará apta para usarse en culquier nivel de empresa de mecanica automotriz y lo relacionado.
