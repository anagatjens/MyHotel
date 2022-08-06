<%-- 
    Document   : addHabitacion
    Created on : 26 jul. 2022, 11:46:42
    Author     : Ana Gatjens Campos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="views/estilosHabitacion.css" rel="stylesheet" type="text/css"/>
        <title>Agregar Habitacion</title>
    </head>
    <body>
        <h1>Ingresar nueva habitacion</h1>
         <form action="HabitacionServlet" method="POST">
             
            <table>               
                <tr>
                    <td>Nombre de Habitacion:</td>
                    <td>
                        <input type="text" name="habNombre"/>
                 </td>                    
                </tr>
                <tr>
                    <td>Numero de Habitacion:</td>
                    <td>
                        <input type="text" name="habNumero"/>
                    </td>                    
                </tr>
                <tr>
                    <td>Cantidad de Huespedes:</td>
                    <td><input type="text" name="cantHuesped"/>
                        
                    </td>                    
                </tr>
                <tr>
                    <td>Cantidad de Baños:</td>
                    <td><input type="text" name="cantBanos"/></td>                    
                </tr>
                <tr>
                    <td>Cantidad de Camas:</td>
                    <td><input type="text" name="cantCamas"/></td>                    
                </tr>
                <tr>
                    <td>Cantidad de Cuartos:</td>
                    <td><input type="text" name="cantCuartos"/></td>                    
                </tr>
                <tr>
                    <td>Descripcion:</td>
                    <td><input type="text" name="descripcion"/></td>                    
                </tr>
                <tr>
                    <td>Aire Acondicionado:</td>
                    <td><input type="text" name="aireAcondicionado"/></td>                    
                </tr>
                <tr>
                    <td>Numero de Piso:</td>
                    <td><input type="text" name="numPiso"/></td>                    
                </tr>
                <tr>
                    <td>Precio:</td>
                    <td><input type="text" name="precio"/></td>                    
                </tr>
                
            </table>
              <h2>
                    ¿Desea guardar cambios?:<br>
                    <label class="radio"><input type="radio" name="accion" value="addhabitacion" required> Si<span class="check"></span>
            </label><br>
                        <label class="radio"><input type="radio" name="accion" value="listHabitacion"> No<span class="check"></span>
            </label><br>
             </h2>
               <p><input type="submit" value="Enviar datos"></p>
        </form>
    </body>
</html>
