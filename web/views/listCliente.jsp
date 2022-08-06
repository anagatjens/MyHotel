<%@page import="java.util.List"%>
<%@page import="Model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>               
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="views/estilos.css" rel="stylesheet" type="text/css"/> 
        <title>Listar Clientes</title>
    </head>
    <body>       
        <% List<Cliente> _listClientes = (List<Cliente>) request.getAttribute("listaClientes"); %>
        <h1>Lista de clientes</h1>
        <div> <a href="ClienteServlet?accion=addClientePage">Nuevo cliente</a></div>
        <table id="customers">
            <tr>
                <th>#</th>
                <th>Cédula</th>
                <th>Nombre</th>
                <th>Edad</th>
                <th>Dirección</th>
                 <th>Lugar de trabajo</th>
                 <th>Telefono</th>
                 <th></th>
                 <th></th> <th></th>
            </tr>
            <%            
            for(Cliente _cliente :_listClientes){                 
            %>
            <tr>
                <td><%=_cliente.getId()%></td>
                <td><%=_cliente.getCedula()%></td>
                <td><%=_cliente.getNombre()%></td>
                <td><%=_cliente.getEdad()%></td>
                <td><%=_cliente.getResidencia()%></td>
                <td><%=_cliente.getLugarTrabajo()%></td>
                <td><%=_cliente.getTelefono()%></td>                
                <td>                   
                </td>
                <td>
                    <a href="ClienteServlet?accion=editClientePage&id=<%=_cliente.getId()%>">Editar Cliente</a>
                </td>
                <td>
                   <a href="ClienteServlet?accion=deleteCliente&id=<%=_cliente.getId()%>">Borrar</a>
                </td>
            </tr>
               <%}%> 
        </table>
        </form>
    </body>

