/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author bcamacho
 */
public class ClienteDAO implements CRUD{
    Conexion cn = new Conexion();
    Connection con ;
    PreparedStatement ps;
    ResultSet rs;
    Cliente _Cliente = new Cliente();
    
    @Override
    public List listar() {
       ArrayList<Cliente>list = new ArrayList<>();
       String sql = "select * from cliente";
        try {
            con=cn.getConection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Cliente _cliente = new Cliente();
              _cliente.setId(rs.getInt("id"));
              _cliente.setNombre(rs.getString("nombre"));
              _cliente.setResidencia(rs.getString("Residencia"));
              _cliente.setTelefono(rs.getString("Telefono"));
              _cliente.setCedula(rs.getString("Cedula"));
              _cliente.setEdad(rs.getString("Edad"));
              _cliente.setLugarTrabajo(rs.getString("Lugar_trabajo"));
              list.add(_cliente);
            }
        } catch (SQLException e) {
            System.err.print("Error List"+ e);
        }
        return list;
    }

    @Override
    public Object getData(int id) {        
        String sql = "select * from cliente where id = ?";
        try {
            con=cn.getConection();
            ps=con.prepareStatement(sql);
            ps.setInt (1, id);
            rs=ps.executeQuery();
            while (rs.next()) {
                 id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String residencia=rs.getString("Residencia");
                String telefono=rs.getString("Telefono");
                String cedula = rs.getString("Cedula");
                String edad=rs.getString("Edad");
                String lugarTrabajo=rs.getString("Lugar_trabajo");
                _Cliente =  new Cliente(id, nombre,residencia, telefono, cedula, edad, lugarTrabajo);                
            }
            
        } catch (SQLException e) {
            System.err.print("Error List"+ e);
            return null;
        }
        return _Cliente;
    }

    @Override
    public boolean add(Object _clienteObj) {
        Cliente _cliente = (Cliente)_clienteObj;
        String sql = "INSERT into cliente (nombre, residencia, telefono,cedula,edad,lugar_trabajo)values(?,?,?,?,?,?)";
        try {
            con = cn.getConection();            
            ps= con.prepareStatement(sql);
            ps.setString(1, _cliente.getNombre());
            ps.setString(2, _cliente.getResidencia());
            ps.setString(3, _cliente.getTelefono());
            ps.setString(4, _cliente.getCedula());
            ps.setString(5, _cliente.getEdad());
            ps.setString(6, _cliente.getLugarTrabajo());
            ps.executeUpdate(); 
           return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean edit(Object _clienteObj) {
        Cliente _cliente = (Cliente)_clienteObj;
        String sql = "Update cliente "
                + " set nombre= ?, residencia= ?, telefono= ?,cedula= ?,edad= ?,lugar_trabajo= ?"
                + " where id= ?";
        try {
            con = cn.getConection();
            ps= con.prepareStatement(sql);
            ps.setString(1, _cliente.getNombre());
            ps.setString(2, _cliente.getResidencia());
            ps.setString(3, _cliente.getTelefono());
            ps.setString(4, _cliente.getCedula());
            ps.setString(5, _cliente.getEdad());
            ps.setString(6, _cliente.getLugarTrabajo());
            ps.setInt(7, _cliente.getId());
            
            ps.executeUpdate(); 
           return true;
        } catch (SQLException e) {
            return false;
        }
        
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete cliente where id = ?";
        try {
            con = cn.getConection();
            
            ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate(); 
           return true;
        } catch (SQLException e) {
            return false;
        }
    }

   
   
    
}
