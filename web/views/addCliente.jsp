<%-- 
    Document   : add
    Created on : 3 jul. 2022, 18:07:00
    Author     : bcamacho
--%>

<%@page import="Config.utilitarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String _nombre=(String)request.getAttribute("nombre"); 
    String _cedula=(String)request.getAttribute("cedula");
    String _escribirNombre = "false";
    
if(utilitarios.nlv(_nombre).equals("No se encontraron datos"))
   _escribirNombre= "";  
    else
    _escribirNombre="readonly";
%>
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
                    <td><input type="text" name="cedula" value="<%=utilitarios.nlv(_cedula)%>"/>
                    <button type="submit">Consulta Persona</button>
                    </td>
                </tr>
                <tr>
                    <td>Nombre Completo:</td>
                    <td>
                        <input type="text" name="nombre" <%=_escribirNombre%> value="<%=utilitarios.nlv(_nombre)%>"/>
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
                          <input type="hidden" name="accion" value="ConsultaPersona"/>
                          <a href="ClienteServlet?accion=addCliente">Guardar Cliente</a>
                         
                    
                </tr>
            </table>
            
        </form>
    </body>
</html>
