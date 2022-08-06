<%-- 
    Document   : edit
    Created on : 3 jul. 2022, 18:07:07
    Author     : bcamacho
--%>

<%@page import="Model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="views/estilos.css" rel="stylesheet" type="text/css"/> 
        <title>JSP Page</title>
    </head>
    <body>
         <% Cliente _cliente = (Cliente) request.getAttribute("_Cliente"); %>
        <h1>MODIFICACIÓN DE CLIENTES</h1>
         <form action="ClienteServlet">             
            <table>               
                <tr>
                    <td>Nombre Completo:</td>
                    <td>
                        <input type="hidden" name="id" value="<%=_cliente.getId()%>"/>                        
                        <input type="text" name="nombre" value="<%=_cliente.getNombre()%>"/>
                 </td>                    
                </tr>
                <tr>
                    <td>Lugar de residencia:</td>
                    <td>
                        <input type="text" name="residencia" value="<%=_cliente.getResidencia()%>"/>
                    </td>                    
                </tr>
                <tr>
                    <td>Número de teléfono:</td>
                    <td><input type="text" name="telefono" value="<%=_cliente.getTelefono()%>"/>
                        
                    </td>                    
                </tr>
                <tr>
                    <td>Cédula:</td>
                    <td><input type="text" name="cedula" value="<%=_cliente.getCedula()%>"/></td>                    
                </tr>
                <tr>
                    <td>Edad:</td>
                    <td><input type="text" name="edad" value="<%=_cliente.getEdad()%>"/></td>                    
                </tr>
                <tr>
                    <td>Lugar de trabajo:</td>
                    <td><input type="text" name="lugarTrabajo" value="<%=_cliente.getLugarTrabajo()%>"/></td>                    
                </tr>
                <tr>
                    <td colspan="2">
                         <input type="hidden" name="accion" value="updateCliente"/>
                         <button type="submit">Actualizar Datos</button>
                </tr>
            </table>
            
        </form>
    </body>
</html>
