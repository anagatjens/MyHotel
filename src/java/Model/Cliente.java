/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author bcamacho
 */

public class Cliente {
    private int id;
    private String nombre;
    private String residencia;
    private String telefono;
    private String cedula;
    private String edad;
    private String lugarTrabajo;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String residencia, String telefono, String cedula, String edad, String lugarTrabajo) {
        this.id= id;
        this.nombre = nombre;
        this.residencia = residencia;
        this.telefono = telefono;
        this.cedula = cedula;
        this.edad = edad;
        this.lugarTrabajo = lugarTrabajo;
    }
    public Cliente(String nombre, String residencia, String telefono, String cedula, String edad, String lugarTrabajo) {        
        this.nombre = nombre;
        this.residencia = residencia;
        this.telefono = telefono;
        this.cedula = cedula;
        this.edad = edad;
        this.lugarTrabajo = lugarTrabajo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }   
    
}