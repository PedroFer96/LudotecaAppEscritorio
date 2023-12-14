/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author pedro
 */
public class Actividades {
 
    private int id; 
    private String hora;
    private String fecha;
    private String nombreTipo;
    private int tipo;
    private String nombre;
    private String apellidos;
    private String sala;

    public Actividades() {
    }

    public Actividades(int id, String hora, String fecha, String nombreTipo, int tipo) {
        this.id = id;
        this.hora = hora;
        this.fecha = fecha;
        this.nombreTipo = nombreTipo;
        this.tipo = tipo;
    }

    
    
    public Actividades(int id, String hora, String fecha, String nombreTipo, int tipo, String nombre, String apellidos, String sala) {
        this.id = id;
        this.hora = hora;
        this.fecha = fecha;
        this.nombreTipo = nombreTipo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sala = sala;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Actividades{" + "id=" + id + ", hora=" + hora + ", fecha=" + fecha + ", nombreTipo=" + nombreTipo + ", tipo=" + tipo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sala=" + sala + '}';
    }

    
    
}
