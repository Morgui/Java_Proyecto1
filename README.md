## Proyecto Java Avanzado con API REST Spring - Jersey

0. Instalar extensión Spring Tools 4

1. Crear proyecto Spring Starter Project con las dependencias:
	* Jersey
	* Spring Boot Dev Tools
	
2. Estructura de paquetes creada: config, models, rest, services

3. Creada clase de configuración jersey: JerseyConfig

4. Clases paquete models: 
	* Clase abstracta Car
	* Clases hijas (Combustion, Electrico, Hibrido)
	* Clases para asociaciones dentro del paquete: Components
	* Interface Arranque dentro del paquete Components que define el encendido y apagado de los components del coche
	
5. Clases controlador:
	* CarController 
	* Una clase controlador por cada tipo de coche y en la cuales se definen métodos CRUD:
	- CombustionController
	- ElectricoController
	- HibridoController
	
6. Patrones de diseño usados: Factory y Fachada

7. Interfaces services:
	* Una interfaz por cada tipo de Car (ICombustionService, IElectricoServices, IHibridoService), definiendo los métodos CRUD:
		* findOne
		* findAll
		* create / update (combinados en un mismo método save)
		* deleteOne
		* deleteAll
		* filtros (Color, Doors, Name,..)
		
8. Implementación de interfaces servicio:
	* Crear una clase implementación por cada interfaz servicio
	* Emular base de datos utilizando una estructura de datos en Java (HashMap)
	
9. Colección de peticiones POSTMAN con las que probar los controladores importada en el proyecto con el nombre de Proyecto1.postman_collection.json

## Parte 1 del Proyecto de JUnit y Git: testing sobre el proyecto del módulo 1 
10. Testing unitario con JUnit 5 - proceso (`Java Avanzado actualizado para proyecto 2`)
	* Se crea dentro de src/test/java un package com.example.project1.services
	* Se crea una clase de test por cada clase a testear (CarFactory, CarFacade y los respectivos servicios de los tipos de coche) para alcanzar la mayor cobertura
	y todas sus pruebas posibles, validando el correcto funcionamiento de cada uno de sus respectivos métodos

## Actualización del proyecto con la realización del proyecto 3 MAVEN
	* Integración en el pom de dependencies, build y reporting necesarios
	* Ejecución de los comandos mvn clean install y mvn site
	* Generación de site y su correspondiente index.html
	* Corrección de bugs visualizados con Spotbugs
	* Visualización cobertura tras las correcciones realizadas
	* Realización de Reporte, el cual se adjunta al zip junto este proyecto
	