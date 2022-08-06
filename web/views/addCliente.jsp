<%-- 
    Document   : add
    Created on : 3 jul. 2022, 18:07:00
    Author     : bcamacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="views/estilos.css" rel="stylesheet" type="text/css"/> 
        <title>Agregar Cliente</title>
    </head>
    <body>
        <h1>Ingresar nuevo cliente</h1>
         <form action="ClienteServlet" method="POST">
             
            <table>  
                <tr>
                    <td>Cédula:</td>
                    <td><input type="text" name="cedula"/>Buscar</td>                    
                </tr>
                <tr>
                    <td>Nombre Completo:</td>
                    <td>
                        <input type="text" name="nombre" value="<%%>"/>
                 </td>                    
                </tr>
                <tr>
                    <td>Lugar de residencia:</td>
                    <td>
                        <input type="text" name="residencia"/>
                    </td>                    
                </tr>
                <tr>
                    <td>Número de teléfono:</td>
                    <td><input type="text" name="telefono"/>
                        
                    </td>                    
                </tr>
                <tr>
                    <td>Edad:</td>
                    <td><input type="text" name="edad"/></td>                    
                </tr>
                <tr>
                    <td>Lugar de trabajo:</td>
                    <td><input type="text" name="lugarTrabajo"/></td>                    
                </tr>
                <tr>
                    <td colspan="2">                      
                          <input type="hidden" name="accion" value="addCliente"/>
                         <button type="submit">Incluir cliente</button>
                    
                </tr>
            </table>
            
        </form>
    </body>
</html>
