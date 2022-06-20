package madstodolist.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "vehiculos")
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;
    private String marca;
    private String modelo;
    private int cc;
    private String matricula;
    private TipoVehiculo tipoVehiculo;
    private String carroceria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    //private ArrayList<Integer> reparaciones;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int cc, String matricula, TipoVehiculo tipoVehiculo, String carroceria) {
        this.marca = marca;
        this.modelo = modelo;
        this.cc = cc;
        this.matricula = matricula;
        this.tipoVehiculo = tipoVehiculo;
        this.carroceria = carroceria;
    }

    public Long getIdVehiculo() {
        return _id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /*
    public ArrayList<Integer> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(ArrayList<Integer> reparaciones) {
        this.reparaciones = reparaciones;
    }
    */

    @Override
    public String toString() {
        return " "+getMarca() + " " + getModelo() + " " + getMatricula() + "\n";
    }
}
