/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Ana Gatjens Campos
 */
public class Habitacion {
    private int id;
    private String habNombre;
    private String habNumero;
    private int cantHuesped;
    private int cantBanos;
    private int cantCamas;
    private int cantCuartos;
    private String descripcion;
    private boolean aireAcondicionado;
    private int numPiso;
    private double precio;
    
    public Habitacion(){
    
    }

    public Habitacion(int id, String habNombre, String habNumero, int cantHuesped, int cantBanos, int cantCamas, int cantCuartos, String descripcion, boolean aireAcondicionado, int numPiso, double precio) {
        this.id = id;
        this.habNombre = habNombre;
        this.habNumero = habNumero;
        this.cantHuesped = cantHuesped;
        this.cantBanos = cantBanos;
        this.cantCamas = cantCamas;
        this.cantCuartos = cantCuartos;
        this.descripcion = descripcion;
        this.aireAcondicionado = aireAcondicionado;
        this.numPiso = numPiso;
        this.precio = precio;
    }

    public Habitacion(String habNombre, String habNumero, int cantHuesped, int cantBanos, int cantCamas, int cantCuartos, String descripcion, boolean aireAcondicionado, int numPiso, double precio) {
        this.habNombre = habNombre;
        this.habNumero = habNumero;
        this.cantHuesped = cantHuesped;
        this.cantBanos = cantBanos;
        this.cantCamas = cantCamas;
        this.cantCuartos = cantCuartos;
        this.descripcion = descripcion;
        this.aireAcondicionado = aireAcondicionado;
        this.numPiso = numPiso;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHabNombre() {
        return habNombre;
    }

    public void setHabNombre(String habNombre) {
        this.habNombre = habNombre;
    }

    public String getHabNumero() {
        return habNumero;
    }

    public void setHabNumero(String habNumero) {
        this.habNumero = habNumero;
    }

    public int getCantHuesped() {
        return cantHuesped;
    }

    public void setCantHuesped(int cantHuesped) {
        this.cantHuesped = cantHuesped;
    }

    public int getCantBanos() {
        return cantBanos;
    }

    public void setCantBanos(int cantBanos) {
        this.cantBanos = cantBanos;
    }

    public int getCantCamas() {
        return cantCamas;
    }

    public void setCantCamas(int cantCamas) {
        this.cantCamas = cantCamas;
    }

    public int getCantCuartos() {
        return cantCuartos;
    }

    public void setCantCuartos(int cantCuartos) {
        this.cantCuartos = cantCuartos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public int getNumPiso() {
        return numPiso;
    }

    public void setNumPiso(int numPiso) {
        this.numPiso = numPiso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
