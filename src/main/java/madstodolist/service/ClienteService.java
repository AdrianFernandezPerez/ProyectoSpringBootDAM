package madstodolist.service;

import madstodolist.model.Cliente;
import madstodolist.model.ClienteRepository;
import madstodolist.model.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /*
    * Crea el objeto cliente y lo guarda en la base de datos
     */
    @Transactional
    public Cliente nuevoCliente(String nombre, int telefono, String email, String direccion, String localidad, int codigoPostal, String provincia, String pais, Vehiculo vehiculo) {
        Cliente cliente = new Cliente(nombre, telefono, email, direccion, localidad, codigoPostal, provincia, pais);
        cliente.addVehiculos(vehiculo);
        System.out.println(cliente.toString());
        clienteRepository.save(cliente);
        return cliente;
    }

    @Transactional(readOnly = true)
    public List<Cliente> allClientes() {
        List<Cliente> clientes = new ArrayList<>();
        clienteRepository.findAll().forEach(clientes::add);
        return clientes;
    }

    @Transactional(readOnly = true)
    public Cliente findById(Long clienteId) {
        return clienteRepository.findById(clienteId).orElse(null);
    }

    @Transactional
    public Cliente modificaCliente(Long idCliente, String nuevoNombre, int nuevoTelefono, String nuevoEmail, String nuevaDireccion, String nuevaLocalidad, int nuevoCodigoPostal, String nuevaProvincia, String nuevoPais) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        if (cliente == null) {
            throw new ClienteServiceException("No existe cliente con id " + idCliente);
        }
        cliente.setNombre(nuevoNombre);
        cliente.setTelefono(nuevoTelefono);
        cliente.setEmail(nuevoEmail);
        cliente.setDireccion(nuevaDireccion);
        cliente.setLocalidad(nuevaLocalidad);
        cliente.setCodigoPostal(nuevoCodigoPostal);
        cliente.setProvincia(nuevaProvincia);
        cliente.setPais(nuevoPais);
        clienteRepository.save(cliente);
        return cliente;
    }

    @Transactional
    public void borraCliente(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        if (cliente == null) {
            throw new ClienteServiceException("No existe cliente con id " + idCliente);
        }
        clienteRepository.delete(cliente);
    }

    public void addVehicle(Long idCliente, Vehiculo vehiculo) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        if (cliente == null) {
            throw new ClienteServiceException("No existe cliente con id " + idCliente);
        }
        cliente.addVehiculos(vehiculo);
        clienteRepository.save(cliente);
    }
}
