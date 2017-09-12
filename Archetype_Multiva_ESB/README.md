![Maven](https://maven.apache.org/images/maven-logo-black-on-white.png)

# MAVEN CUSTOM ARCHETYPE  	

Ejemplo de como crear un arquetipo propio


## PASOS PARA CONSTRUIR LA RUTA

* Creas un proyecto maven desde eclipse
* Ya que tenemos el proyecto creamos dentro de la carpeta src/main/resources la siguiente estructura de archivos:

``` 
src
    `-- main
        `-- resources
            |-- META-INF
            |   `-- archetype.xml
            `-- archetype-resources
                |-- pom.xml
                `-- src
                    |-- main
                    |   `-- java
                    |       `-- App.java
                    `-- test
                        `-- java
                            `-- AppTest.java

``` 

* Dentro del archivo archetype.xml colocas lo siguiente:

``` 
<?xml version="1.0" encoding="UTF-8"?>
<archetype>
  <id>Multiva_ESB_Archetype</id>
  <sources>
    <source>src/main/java/App.java</source>
    <source>src/main/java/Ejemplo.java</source>
    <source>src/main/java/Ejemplo2.java</source>
  </sources>
  <testSources>
    <source>src/test/java/AppTest.java</source>
  </testSources>
  <resources>
  	<resource>src/main/resources/application.properties</resource>
  </resources>
</archetype>
``` 
* Ya que tienes armado la estructura del proyecto compilar el proyecto en el que metimos la estructura del proyecto:  
	
	``` 
	Archetype_Multiva_ESB> $ mvn clean install
	``` 
* Ingresamos a la carpeta donde queremos el proyecto
* Ejecutas el siguiente comando: 

``` 
$ mvn archetype:generate -DarchetypeGroupId=com.multiva.esb -DarchetypeArtifactId=Archetype_Multiva_ESB -DarchetypeVersion=1.0.0 -DgroupId=com.ejemplo.arquetipo -DartifactId=nuevoArquetipo -DversionId=1.0.0
``` 
## Referencias 

* [Guia para crear Arquetipos Maven](https://maven.apache.org/guides/mini/guide-creating-archetypes.html)

## Version

Use un controlador de versiones que es: [Github](https://github.com). La URL para descargar el ṕroyecto es la siguente: [DjSystemBPM/Java](https://github.com/DjSystemBPM/Java). 

## Autores

* **Alfredo Cuevas** - *trabajo inicial*        
        
