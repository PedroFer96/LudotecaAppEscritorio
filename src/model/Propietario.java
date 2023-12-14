/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author pedro
 */
public class Propietario {
    
    
    
    
    private int id;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String dni;
    private String correo;
    private String user;
    private String password;
    private String phone;
    private Integer tipo;

    public Propietario() {
    }

    public Propietario(int id, String nombre, String apellidos, String dni, String phone, Integer tipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.phone = phone;
        this.tipo = tipo;
    }

    public Propietario(int id, String nombre, String apellidos, String fechaNacimiento, String dni, String correo, String phone) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento= fechaNacimiento;
        this.dni = dni;
        this.correo = correo;
        this.phone = phone;
    }

    public Propietario(int id, String nombre, String apellidos, String fechaNacimiento,String dni, String correo, String user, String password, String phone) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento= fechaNacimiento;
        this.dni = dni;
        this.correo = correo;
        this.user = user;
        this.password = password;
        this.phone = phone;
    }
    
    public Propietario(int id, String nombre, String apellidos,String fechaNacimiento, String dni, String correo, String phone, String user, String password, Integer tipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento= fechaNacimiento;
        this.dni = dni;
        this.correo = correo;
        this.phone = phone;
        this.user = user;
        this.password = password;
        this.tipo = tipo;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Propietario{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", correo=" + correo + ", user=" + user + ", password=" + password + ", phone=" + phone + ", tipo=" + tipo + '}';
    }
 
    
    
}
