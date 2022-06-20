package madstodolist.service;

import madstodolist.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoService {

    private VehiculoRepository vehiculoRepository;

    @Autowired
    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Transactional
    public Vehiculo nuevoVehiculo(String marca, String modelo, int cc, String matricula, TipoVehiculo tipoVehiculo, String carroceria) {
        Vehiculo vehiculo = new Vehiculo(marca, modelo, cc, matricula, tipoVehiculo, carroceria);
        vehiculoRepository.save(vehiculo);
        return vehiculo;
    }

    @Transactional(readOnly = true)
    public List<Vehiculo> allVehiculos() {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculoRepository.findAll().forEach(vehiculos::add);
        return vehiculos;
    }

    @Transactional(readOnly = true)
    public Vehiculo findById(Long vehiculoId) {
        return vehiculoRepository.findById(vehiculoId).orElse(null);
    }

    @Transactional
    public Vehiculo modificaVehiculo(Long idvehiculo, String marca, String modelo, int cc, String matricula, TipoVehiculo tipoVehiculo, String carroceria) {
        Vehiculo vehiculo = vehiculoRepository.findById(idvehiculo).orElse(null);
        if (vehiculo == null) {
            throw new VehiculoServiceException("No existe el vehiculo con id " + idvehiculo);
        }
        vehiculo.setMarca(marca);
        vehiculo.setModelo(modelo);
        vehiculo.setCc(cc);
        vehiculo.setMatricula(matricula);
        vehiculo.setTipoVehiculo(tipoVehiculo);
        vehiculo.setCarroceria(carroceria);

        vehiculoRepository.save(vehiculo);
        return vehiculo;
    }

    @Transactional
    public void borraVehiculo(Long idVehiculo) {
        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo).orElse(null);
        if (vehiculo == null) {
            throw new VehiculoServiceException("No existe el vehiculo con id " + idVehiculo);
        }
        vehiculoRepository.delete(vehiculo);
    }
}
