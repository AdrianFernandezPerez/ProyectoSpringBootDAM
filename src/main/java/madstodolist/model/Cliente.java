package madstodolist.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;
    private String nombre;
    private Integer telefono;
    private String email;
    private String direccion;
    private String localidad;
    private int codigoPostal;
    private String provincia;
    private String pais;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    List<Vehiculo> vehiculos;

    public Cliente() {
    }

    public Cliente(String nombre, Integer telefono, String email, String direccion, String localidad, int codigoPostal, String provincia, String pais) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.pais = pais;
        vehiculos = new ArrayList<Vehiculo>();

    }

    public Long getIdCliente() {
        return _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
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


    public void addVehiculos(Vehiculo vehiculo) {
        if (!getVehiculos().contains(vehiculo)) {
            getVehiculos().add(vehiculo);
            vehiculo.setCliente(this);
        }
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }



    @Override
    public String toString() {

        return "Nombre: "+ getNombre() + "---" +  "Telefono: " + getTelefono() + "\n";
    }
}
