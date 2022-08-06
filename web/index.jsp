<%-- 
    Document   : index.jsp
    Created on : 3 jul. 2022, 18:05:13
    Author     : bcamacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="views/estilos.css" rel="stylesheet" type="text/css"/> 
        <title>Hotel Omega</title>
    </head>
    <body>       
        <div>
            <a href="ClienteServlet?accion=listCliente">Lista de clientes</a>            
        </div>
        <div>
            <a href="HabitacionServlet?accion=listHabitacion">Lista de habitaciones</a>            
        </div>
    </body>
</html>
