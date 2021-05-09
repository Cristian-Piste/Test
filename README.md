# Pokemon API Test

* Clonar el repositorio a traves de una terminal con el siguiente comando
```
git clone https://github.com/Cristian-Piste/Test.git
```

* Abrir en un IDE (IntelliJ, Eclipse, NetBeans, etc) la carpeta como un proyecto Maven

* Ejecutar el archivo TestApplication

* En el navegador colocar la URL http://localhost:8080/help y acceder al enlace de <ins style="color:blue">Documentación e información de la API</ins>


* Se mostraran la lista de *Endpoints* a los que se puede acceder y se podra interactuar desde esa misma interfaz

# Modo de uso

* Se accede al *Endpoint* **/H2/D** ubicado en el controlador **PokemonH2Controller** y se presiona el boton de <ins style="color:blue">Try it out</ins>.
  Este *Endpoint* soporta un metodo POST lo que significa que se creara un nuevo elemento, los parametros que necesita son **nickname** y **species** los cuales proporcionaremos en sus respectivos campos.
  ![](https://i.imgur.com/DshcAu7.png)

* Una vez con los campos llenados se presionara el boton de <ins style="color:blue">Execute</ins> el cual nos dara como resultado un codigo de estado HTTP y un curpo de respuesta
  ![](https://i.imgur.com/HXzD6mI.png)

* Podremos consultar la informacion alamacenada del ejemplo anterior si accedemos al *Enpoint* **/H"/E/{nickname}** con metodo GET
  ![](https://i.imgur.com/sUajWKi.png)

# ENDPOINTS Y SUS PARAMETROS
> <span style="color:blue">GET</span> /help

Regresa una pantalla de información


> <span style="color:blue">GET</span> /api/A

Regresa una lista con los pokemons de la generación 1 a la 6


> <span style="color:blue">GET</span> /api/B?from=a&to=b

Regresa una lista de pokemons en el rango de **a** y **b** los cuales deben ser numeros enteros. **from** y **to** son los parametros que recibe la URL


> <span style="color:blue">GET</span> /api/C/{filter}

Regresa un pokemon que cumpla con la variable de ruta **filter**, puede ser un nombre de pokemon o su id


> <span style="color:green">POST</span> /H2/D

Crea un nuevo pokemon en base de datos, necesita los parametros **nickname** y **species**, el primero debe de ser unico y en caso de repetirse se generara un codigo HTTP 500 ya que la accion no se podra llevar a cabo, por otro lado si se almacena el nuevo pokemon en base de datos se generara un codigo HTTP 201.


> <span style="color:blue">GET</span> /H2/E/{nickname}

Regresara el pokemon que haya sido almacenado en base de datos buscandolo por su **nickname** (apodo)


> <span style="color:blue">GET</span> /H2/F/{species}

Regresa una lista con los pokemons almacenados en base de datos que coincidan con la variable de ruta **species**


> <span style="color:blue">GET</span> /h2-console

Permite acceder a la consola de la base de datos


> <span style="color:blue">GET</span> /swagger-ui.html

Accede a la información y documentación de la aplicación.
* Endpoints
* Controladores
* Modelos
* Metodos HTTP
* Posibles codigos de estado HTTP
* Posibles valores de respuesta esperados

**NOTA:** Toda la informacion se regresa en formato JSON
