package madstodolist.controller;

import madstodolist.model.Vehiculo;

import java.util.List;

public class ClienteData {
    private String nombre;
    private int telefono;
    private String email;
    private String direccion;
    private String localidad;
    private int codigoPostal;
    private String provincia;
    private String pais;
    private Vehiculo vehiculo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "ClienteData{" +
                "nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", provincia='" + provincia + '\'' +
                ", pais='" + pais + '\'' +
                ", vehiculo=" + vehiculo +
                '}';
    }
}
