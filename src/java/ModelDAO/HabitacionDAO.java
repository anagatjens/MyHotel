/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Model.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ana Gatjens Campos
 */
public class HabitacionDAO implements CRUD {
    
    Conexion cn = new Conexion();
    Connection con ;
    PreparedStatement ps;
    ResultSet rs;
    Habitacion _Habitacion = new Habitacion();
    
    @Override
    public List listar(){
        ArrayList<Habitacion>list = new ArrayList<>();
        String sql = "select * from Habitacion";
        try{
            con=cn.getConection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Habitacion _habitacion = new Habitacion();
                _habitacion.setId(rs.getInt("id"));
                _habitacion.setHabNombre(rs.getString("habNombre"));
                _habitacion.setHabNumero(rs.getString("habNumero"));
                _habitacion.setCantHuesped(rs.getInt("cantHuesped"));
                _habitacion.setCantBanos(rs.getInt("cantBanos"));
                _habitacion.setCantCamas(rs.getInt("cantCamas"));
                _habitacion.setCantCuartos(rs.getInt("cantCuartos"));
                _habitacion.setDescripcion(rs.getString("descripcion"));
                _habitacion.setAireAcondicionado(rs.getBoolean("aireAcondicionado"));
                _habitacion.setNumPiso(rs.getInt("numPiso"));
                _habitacion.setPrecio(rs.getDouble("precio"));
                list.add(_habitacion);
            }
        }catch(SQLException e){
            System.err.print("Error List"+ e);
        }
        return list;
    }
    
    @Override
    public Object getData(int id){
        String sql = "select * from habitacion where id = ?";
        try{
            con=cn.getConection();
            ps=con.prepareStatement(sql);
            ps.setInt (1, id);
            rs=ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                String habNombre = rs.getString("habNombre");
                String habNumero = rs.getString("habNumero");
                int cantHuesped = rs.getInt("cantHuesped");
                int cantBanos = rs.getInt("cantBanos");
                int cantCamas = rs.getInt("cantCamas");
                int cantCuartos = rs.getInt("cantCuartos");
                String descripcion = rs.getString("descripcion");
                boolean aireAcondicionado = rs.getBoolean("aireAcondicionado");
                int numPiso = rs.getInt("numPiso");
                double precio = rs.getDouble("precio");
                _Habitacion = new Habitacion(id, habNombre, habNumero, cantHuesped, cantBanos, cantCamas, 
                        cantCuartos,descripcion, aireAcondicionado, numPiso, precio);
            }
        }catch(SQLException e){
            System.err.print("Error List"+ e);
        }
        return _Habitacion;
    }
    
    @Override
    public boolean add(Object _habitacionObj) {
        Habitacion _habitacion = (Habitacion)_habitacionObj;
        String sql = "INSERT into habitacion (habNombre, habNumero, cantHuesped, cantBanos,"
                + "cantCamas, cantCuartos, descripcion, aireAcondicionado, numPiso, precio)"
                + "values(?,?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConection();            
            ps= con.prepareStatement(sql);
            ps.setString(1, _habitacion.getHabNombre());
            ps.setString(2, _habitacion.getHabNumero());
            ps.setInt(3, _habitacion.getCantHuesped());
            ps.setInt(4, _habitacion.getCantBanos());
            ps.setInt(5, _habitacion.getCantCamas());
            ps.setInt(6, _habitacion.getCantCuartos());
            ps.setString(7, _habitacion.getDescripcion());
            ps.setBoolean(8, _habitacion.isAireAcondicionado());
            ps.setInt(9, _habitacion.getNumPiso());
            ps.setDouble(10, _habitacion.getPrecio());
            ps.executeUpdate(); 
           return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    @Override
    public boolean edit(Object _habitacionObj) {
        Habitacion _habitacion = (Habitacion)_habitacionObj;
        String sql = "Update habitacion"
                + " set habNombre= ?, habNumero= ?, cantHuesped= ?,"
                + "cantBanos= ?, cantCamas= ?, cantCuartos= ?, descripcion= ?,"
                + "aireAcondicionado= ?, numPiso= ?, precio= ? where id= ?";
        try {
            con = cn.getConection();
            ps= con.prepareStatement(sql);
            ps.setString(1, _habitacion.getHabNombre());
            ps.setString(2, _habitacion.getHabNumero());
            ps.setInt(3, _habitacion.getCantHuesped());
            ps.setInt(4, _habitacion.getCantBanos());
            ps.setInt(5, _habitacion.getCantCamas());
            ps.setInt(6, _habitacion.getCantCuartos());
            ps.setString(7, _habitacion.getDescripcion());
            ps.setBoolean(8, _habitacion.isAireAcondicionado());
            ps.setInt(9, _habitacion.getNumPiso());
            ps.setDouble(10, _habitacion.getPrecio());
            ps.setInt(11, _habitacion.getId());
            
            ps.executeUpdate(); 
           return true;
        } catch (SQLException e) {
            return false;
        } 
    }
    
     @Override
    public boolean delete(int id) {
        String sql = "delete habitacion where id = ?";
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
