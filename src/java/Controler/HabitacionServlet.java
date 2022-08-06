/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Model.Habitacion;
import ModelDAO.HabitacionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ana Gatjens Campos
 */
@WebServlet(name = "HabitacionServlet", urlPatterns = {"/HabitacionServlet"})
public class HabitacionServlet extends HttpServlet {
    HabitacionDAO _habitacionDAO;
    String listarHabitacionPage="views/listHabitacion.jsp";
    String addHabitacionPage="views/addHabitacion.jsp";
    String editHabitacionPage="views/editHabitacion.jsp";
    
    public HabitacionServlet(){
        this._habitacionDAO = new HabitacionDAO();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HabitacionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HabitacionServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String acceso = "";
        String action= request.getParameter("accion"); 
        
        if(action.equalsIgnoreCase("listHabitacion")){        
            //acceso =listarHabitacion; 
            try {
                getListHabitacion(request,response);
            } catch (SQLException ex) {
                Logger.getLogger(HabitacionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(action.equalsIgnoreCase("addHabitacion")){           
            try {
                //acceso=addHabitacion;
                setNewHabitacion(request,response);
            } catch (SQLException ex) {
                Logger.getLogger(HabitacionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(action.equalsIgnoreCase("imprimir")){           
                 imprimir();
        }else if(action.equalsIgnoreCase("editHabitacion")){           
            try {
                //acceso=editHabitacion;
                showEditPage(request,response);
            } catch (SQLException ex) {
                Logger.getLogger(HabitacionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(action.equalsIgnoreCase("deleteHabitacion")){           
            try {                
                deleteHabitacion(request,response);
            } catch (SQLException ex) {
                Logger.getLogger(HabitacionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(action.equalsIgnoreCase("updateHabitacion")){           
            try {                
                UpdateHabitacion(request,response);                                
            } catch (SQLException ex) {
                Logger.getLogger(HabitacionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(action.equalsIgnoreCase("addHabitacionPage")){           
            RequestDispatcher vista= request.getRequestDispatcher(addHabitacionPage);
            vista.forward(request,response);
        }else if(action.equalsIgnoreCase("editHabitacionPage")){
            try {
                /*CARGAMOS DEL DAO EL HABITACION SEGUN EL ID*/
                loadHabitacion(request,response);
            } catch (SQLException ex) {
                Logger.getLogger(HabitacionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }          
            RequestDispatcher vista= request.getRequestDispatcher(editHabitacionPage);
            vista.forward(request,response);
        }
    }
    
    private void getListHabitacion(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
        try { 
            List<Habitacion> _listHabitacion = _habitacionDAO.listar();
            request.setAttribute("listaHabitacion",_listHabitacion);
            RequestDispatcher dispatcher = request.getRequestDispatcher(listarHabitacionPage);
            dispatcher.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(HabitacionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void setNewHabitacion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
       
        String habNombre =(String) request.getParameter("habNombre");
        String habNumero =(String) request.getParameter("habNumero");
        String cantHuesped =(String) request.getParameter("cantHuesped");
        String cantBanos =(String) request.getParameter("cantBanos");
        String cantCamas =(String) request.getParameter("cantCamas");
        String cantCuartos =(String) request.getParameter("cantCuartos");
        String descripcion =(String) request.getParameter("descripcion");
        String aireAcondicionado =(String)request.getParameter("aireAcondicionado");
        String numPiso =(String)request.getParameter("numPiso");
        String precio =(String)request.getParameter("precio");
        Habitacion _habitacion = new Habitacion(habNombre, habNumero, 
                Integer.parseInt(cantHuesped), Integer.parseInt(cantBanos), 
                Integer.parseInt(cantCamas), Integer.parseInt(cantCuartos), 
                descripcion, Boolean.parseBoolean(aireAcondicionado), 
                Integer.parseInt(numPiso), Double.parseDouble(precio));
        _habitacionDAO.add(_habitacion);
        getListHabitacion(request, response);
    }
    
    private void UpdateHabitacion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        String id =(String) request.getParameter("id");
        String habNombre =(String) request.getParameter("habNombre");
        String habNumero =(String) request.getParameter("habNumero");
        String cantHuesped =(String) request.getParameter("cantHuesped");
        String cantBanos =(String) request.getParameter("cantBanos");
        String cantCamas =(String) request.getParameter("cantCamas");
        String cantCuartos =(String) request.getParameter("cantCuartos");
        String descripcion =(String) request.getParameter("descripcion");
        String aireAcondicionado =(String) request.getParameter("aireAcondicionado");
        String numPiso =(String) request.getParameter("numPiso");
        String precio =(String) request.getParameter("precio");
        
        Habitacion _habitacion = new Habitacion(Integer.parseInt(id), habNombre, habNumero, 
                Integer.parseInt(cantHuesped), Integer.parseInt(cantBanos), 
                Integer.parseInt(cantCamas), Integer.parseInt(cantCuartos), 
                descripcion, Boolean.parseBoolean(aireAcondicionado), 
                Integer.parseInt(numPiso), Double.parseDouble(precio));
        _habitacionDAO.edit(_habitacion);
        getListHabitacion(request, response);
    
    }
    
    private void deleteHabitacion(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
       int id =Integer.parseInt(request.getParameter("id"));
       _habitacionDAO.delete(id);
      getListHabitacion(request, response);
    }
    
    private void showEditPage(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Habitacion _habitacion = (Habitacion)_habitacionDAO.getData(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher(editHabitacionPage);
            request.setAttribute("Habitacion",_habitacion);
            dispatcher.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(HabitacionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadHabitacion(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        Habitacion _Habitacion = (Habitacion)_habitacionDAO.getData(id);
        request.setAttribute("_habitacion",_Habitacion);
    }
    
   
    public void imprimir() {
        System.out.println("No se realizaron cambios.");
    }
    
    


    
}
