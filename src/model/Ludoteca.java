/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author pedro
 */
public class Ludoteca {
    
    private int id;
    private String nombre;
    private String direccion;
    private double longitude;
    private double latitude;
    private String phone;
    private String fecha_creacion;
    private int id_propietario;

    public Ludoteca(int id, String nombre, String direccion, double longitude, double latitude, String phone, String fecha_creacion, int id_propietario) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.longitude = longitude;
        this.latitude = latitude;
        this.phone = phone;
        this.fecha_creacion = fecha_creacion;
        this.id_propietario = id_propietario;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    

    public int getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    @Override
    public String toString() {
        return "Ludoteca{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", longitude=" + longitude + ", latitude=" + latitude + ", phone=" + phone + ", fecha_creacion=" + fecha_creacion + ", id_propietario=" + id_propietario + '}';
    }

    
}
