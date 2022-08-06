<%-- 
    Document   : editHabitacion
    Created on : 26 jul. 2022, 13:59:51
    Author     : Ana Gatjens Campos
--%>

<%@page import="Model.Habitacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="views/estilosHabitacion.css" rel="stylesheet" type="text/css"/> 
        <title>Editar Habitacion</title>
    </head>
    <body>
        <% Habitacion _habitacion = (Habitacion) request.getAttribute("_habitacion"); %>
        <h1>MODIFICACIÓN DE HABITACIONES</h1>
         <form action="HabitacionServlet">             
            <table>               
                <tr>
                    <td>Nombre de Habitacion:</td>
                    <td>
                        <input type="hidden" name="id" value="<%=_habitacion.getId()%>"/>                        
                        <input type="text" name="habNombre" value="<%=_habitacion.getHabNombre()%>"/>
                 </td>                    
                </tr>
                <tr>
                    <td>Numero de Habitacion:</td>
                    <td>
                        <input type="text" name="habNumero" value="<%=_habitacion.getHabNumero()%>"/>
                    </td>                    
                </tr>
                <tr>
                    <td>Cantidad de Huespedes:</td>
                    <td><input type="text" name="cantHuesped" value="<%=_habitacion.getCantHuesped()%>"/>
                        
                    </td>                    
                </tr>
                <tr>
                    <td>Cantidad de Baños:</td>
                    <td><input type="text" name="cantBanos" value="<%=_habitacion.getCantBanos()%>"/></td>                    
                </tr>
                <tr>
                    <td>Cantidad de Camas:</td>
                    <td><input type="text" name="cantCamas" value="<%=_habitacion.getCantCamas()%>"/></td>                    
                </tr>
                <tr>
                    <td>Cantidad de Cuartos:</td>
                    <td><input type="text" name="cantCuartos" value="<%=_habitacion.getCantCuartos()%>"/></td>                    
                </tr>
                <tr>
                    <td>Descripcion:</td>
                    <td><input type="text" name="descripcion" value="<%=_habitacion.getDescripcion()%>"/></td>                    
                </tr>
                <tr>
                    <td>Aire Acondicionado:</td>
                    <td><input type="text" name="aireAcondicionado" value="<%=_habitacion.isAireAcondicionado()%>"/></td>                    
                </tr>
                <tr>
                    <td>Numero de Piso:</td>
                    <td><input type="text" name="numPiso" value="<%=_habitacion.getNumPiso()%>"/></td>                    
                </tr>
                <tr>
                    <td>Precio:</td>
                    <td><input type="text" name="precio" value="<%=_habitacion.getPrecio()%>"/></td>                    
                </tr>
                
            </table>
                
                <h2>
                    ¿Desea guardar cambios?:<br>
                    <label class="radio"><input type="radio" name="accion" value="updateHabitacion" required> Si<span class="check"></span>
            </label><br>
                        <label class="radio"><input type="radio" name="accion" value="listHabitacion"> No<span class="check"></span>
            </label><br>
             </h2>
               <p><input type="submit" value="Enviar datos"></p>
            
        </form>
    </body>
</html>
