Descripción general del proyecto.

#Primer ejemplo

El primer ejemplo se encuentra en el paquete com.example.testauto, en el cual solo existe una clase Junit de Java en el 
cual esta implementado 5 pruebas automatizadas de inicio de sesión para la misma página de pruebas con diferente data 
escrita directamente en el código.

Al ejecutar la clase se realizarán las pruebas utilizando el navegador Google Chrome, al terminar todas las ejecuciones 
se mostrará el resultado en un reporte de tipo html al principio del proyecto con el nombre "ExtentReportResults", el 
reporte que será emitido es el siguiente:


![image](https://user-images.githubusercontent.com/58036212/208970054-80932caa-b322-4fb2-9b14-959227ea222a.png)


#Segundo ejemplo

Este segundo ejemplo se encuentra en el paquete com.project.pom, en el que el resultado sera exactamente el mismo que 
el del ejercicio anterior, pero en este se encuentran 5 clases que serviran como una estructura general para realizar
un tipo de prueba de inicio de sesion con data ingresada desde un archivo excel.

Para ejecutar los casos de prueba se debe ejecutar el archivo "SwagLabsTest.java" el cual ejecutara todo para emitir 
el correspondiente reporte que es igual al anterior.


#Tercer ejemplo

Este tercer ejemplo se encuentra en el paquete com.examplet.testng, en el que se realizara el mismo inicio de sesion con 5 usuarios distintos, tomados de un excel, utilizando testng. Al ejecutar las pruebas se realizara desde un archivo que es testng.xml donde esta el suite de las ejecuciones de las clases. 

El reporte se generara en la carpeta test-output con el nombre emailable-report.html y se vera de la siguiente forma:


![image](https://user-images.githubusercontent.com/58036212/209401918-2eb2be0b-4ad0-49fb-936c-7f2b7c08bb48.png)


