<%-- 
    Document   : listHabitacion
    Created on : 26 jul. 2022, 14:11:42
    Author     : Ana Gatjens Campos
--%>

<%@page import="Model.Habitacion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="views/estilosHabitacion.css" rel="stylesheet" type="text/css"/> 
        <title>Listar Habitacion</title>
    </head>
    <body>
         <% List<Habitacion> _listHabitacion = (List<Habitacion>) request.getAttribute("listaHabitacion"); %>
        <h1>Lista de Habitaciones</h1>
        <div> <a href="HabitacionServlet?accion=addHabitacionPage">Nueva habitacion</a></div>
        <table id="habitacion">
            <tr>
                <th>#</th>
                <th>Nombre de Habitacion</th>
                <th>Numero de Habitacion</th>
                <th>Cantidad de Huespedes</th>
                <th>Cantidad de Baños</th>
                 <th>Cantidad de Camas</th>
                 <th>Cantidad de Cuartos</th>
                 <th>Descripcion</th>
                 <th>Aire Acondicionado</th>
                 <th>Numero de Piso</th>
                 <th>Precio</th>
                 <th></th>
                 <th></th> <th></th>
            </tr>
            <%            
            for(Habitacion _habitacion :_listHabitacion){                 
            %>
            <tr>
                <td><%=_habitacion.getId()%></td>
                <td><%=_habitacion.getHabNombre()%></td>
                <td><%=_habitacion.getHabNumero()%></td>
                <td><%=_habitacion.getCantHuesped()%></td>
                <td><%=_habitacion.getCantBanos()%></td>
                <td><%=_habitacion.getCantCamas()%></td>
                <td><%=_habitacion.getCantCuartos()%></td>
                <td><%=_habitacion.getDescripcion()%></td>  
                <td><%=_habitacion.isAireAcondicionado()%></td>  
                <td><%=_habitacion.getNumPiso()%></td>  
                <td><%=_habitacion.getPrecio()%></td>  
                <td>                   
                </td>
                <td>
                    <a href="HabitacionServlet?accion=editHabitacionPage&id=<%=_habitacion.getId()%>">Editar Habitacion</a>
                </td>
                <td>
                   <a href="HabitacionServlet?accion=deleteHabitacion&id=<%=_habitacion.getId()%>">Borrar</a>
                </td>
            </tr>
               <%}%> 
        </table>
        </form>
    </body>
</html>
