# JavaPotters-Homework3

## Proyecto de CRM con ampliación de funcionalidades

### Proyecto realizado por:
* Laura Zambrano 
* Sofia de la Fuente
* Ana Bermejo
* Rocio Arellano 

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Bienvenida/o a un nuevo proyecto de Java del grupo JavaPotters. 
En este proyecto realizamos un simulador de un CRM para una empresa ficticia, y, en esta semana añadimos algunas funcionalidades y búsquedas de registros. 

------------------------------------------------------------------------------------------------------------------------------

### ¿Cómo usarlo?

Al compilar nuestro programa podrás acceder a un CRM interno ficticio que pretende simular las diferentes opciones que podría realizar un asistente comercial dentro de la empresa. 
De esta forma por consola se nos pregunta qué funcionalidad queremos ejecutar, a elegir entre: 
-Registrar un lead 
-Convertir el lead en oportunidad
-Que nos muestre la lista de leads y oportunidades
-Cerrar las oportunidades ganadas o perdidas de negocio
-Consultar los clientes potenciales que hay por representante de ventas
-Consultar las oportunidades que hay por representante de ventas
-Consultar las oportunidades abiertas, ganadas o perdidas que hay por representante de ventas
-Consultar las oportunidades que hay por productos
-Consultar las oportunidades abiertas, ganadas o perdidas que hay por productos
-Consultar las oportunidades que hay por pais
-Consultar las oportunidades abiertas, ganadas o perdidas que hay por pais
-Consultar las oportunidades que hay por ciudad
-Consultar las oportunidades abiertas, ganadas o perdidas que hay por ciudad
-Consultar las oportunidades que hay por industria
-Consultar las oportunidades abiertas, ganadas o perdidas que hay por industria
-Calcular la media, el máximo y mínimo de los empleados 
-Calcular la media, el máximo y mínimo de las cantidades
-Calcular la media, el máximo y mínimo de las oportunidades por cuenta


En nuestra consola te mostraremos las opciones a elegir, así como te iremos guiando en el camino si cometes algún error. 

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### ¿Qué lógica hemos usado?

En cada repositorio encontrarás todos los métodos que hemos usado en nuestra lógica;

-Para leads: `findBySalesRep`
-Para oportunidades: `findBySalesRepAssociate`,`findByProductEnum`, `findByCountry`, `findByCity`, `findByIndustryEnum`, `findByProductEnumAndStatus`, `findQuantityAverage`,`findQuantityMax`, `findQuantityMin` 
-Para accounts: `findByCountry`, `findByCountryAndStatus`, `findByCityAndStatus`, `findByIndustryAndStatus`, `findEmployeeAverage`, `findEmployeeMax`, `findEmployeeMin`, `findAverageOppsByAccount`, `findMaxOppsByAccount`, `findMinOppsByAccount`
-Para salesRep: `findByStatusCloseWon`, `findByStatusCloseLost`, ` findByStatusOpen`


En los modelos: `Account`, `Contact`, `Lead`, `Opportunity` y `SalesRep` hemos introducido los atributos, método constructor, getters, setters, método equals, método hashCode y método toString de cada clase. 

En el modelo `Utils` hemos incluido los métodos:`getInputData`, `validInput`, `signingUp`, `isAKeyWord`, `showLead`, `showOpportunities`, `showObjectList`, con los cuales realizamos visualización de información por consola y recepción de datos. 
En el modelo `Constants` tenemos las cadenas constantes como keywords y las opciones que podemos realizar. 

En el modelo `MainMenu` hemos introducido toda la lógica que debe imprimirse por consola para interactuar con el usuario para no sobrecargar la clase `JavaPottersHomework3Application` (Main) . 
Desde la clase `Main` llamaremos a los métodos incluidos en el `MainMenu`.

Como novedad de este proyecto, hemos trabajado con mySQL donde hemos creado tablas que se han asociado a nuestro proyecto de java. El DDL de mySQL lo hemos añadido también a java a un documento que hemos llamado `DDL.SQL` que encontrarás dentro de resources. 

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### Excepciones y tests:

Hemos incluido en este proyecto de java la parte de test y excepciones. 
En los repositorios `AccountRepositoryTest`, `LeadReposotory`, `ContactRepository`, `OpportunityRepository`, `SalesRepRepository` hemos incluido los métodos correspondientes a cada modelo. 
Hemos realizado el 100% de test de todos los repositorios. 
Para lanzar excepciones hemos usado `try...catch` y las excepciones `ArrayIndexOutOfBoundsException` `InputMismatchException` .

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### Datos adicionales que nos gustaría que conocieras: 

•	El proyecto ha sido realizado por partes iguales por las 4 miembros del grupo, debido a que nuestra dinámica de trabajo ha consistido en realizar reuniones virtuales durante todo el proyecto. No nos hemos dividido el trabajo, sino que lo hemos ido haciendo de forma simultánea en conjunto. Íbamos turnándonos para escribir el código pero el resto del equipo participaba de la escritura del mismo a la vez.
•	Al inicio del proyecto realizamos dos diagramas; uno de clases y otro de casos de uso, tal como hemos visto en clase esta semana, que, adjuntamos a continuación y también encontrarás en nuestro repositorio: 

### DIAGRAMA CASOS DE USO:

<p align="center">
    <img src =https://github.com/JavaPotters/JavaPotters-Homework3/blob/main/Diagram_uses.png width="450">
</p>

### DIAGRAMA CLASES:

<p align="center">
    <img src = https://github.com/JavaPotters/JavaPotters-Homework3/blob/main/Diagram_classes.png width="450">
</p>

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Por último nos gustaría agradecerte tu tiempo por probar e interesarte en nuestro proyecto; esperamos haber estado a la altura de lo que se nos pedía.
Si tienes alguna sugerencia o comentario sobre nuestro proyecto, estaremos encantadas de recibir el feedback. 
