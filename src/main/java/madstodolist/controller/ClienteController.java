package madstodolist.controller;

import madstodolist.authentication.ManagerUserSession;
import madstodolist.controller.exception.ClienteNotFoundException;
import madstodolist.model.Cliente;
import madstodolist.model.Vehiculo;
import madstodolist.service.ClienteService;
import madstodolist.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    VehiculoService vehiculoService;

    @Autowired
    ManagerUserSession managerUserSession;

    //Si estamos iniciados sesión nos muestra el formulario de creación de clientes, si no, redirecciona al login
    @GetMapping("/cliente/nuevo")
    public String nuevoClienteForm(@ModelAttribute ClienteData clienteData, Model model, HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return "redirect:/login";
        } else {
            List<Vehiculo> vehiculos = vehiculoService.allVehiculos();
            model.addAttribute("vehiculos", vehiculos);
            return "formNuevoCliente";
        }

    }

    //Crea un cliente con los datos introducidos y muestra la lista de clientes
    @PostMapping("/cliente/nuevo")
    public String nuevoCliente(@ModelAttribute ClienteData clienteData,
                                   Model model, RedirectAttributes flash) {
        clienteService.nuevoCliente(clienteData.getNombre(), clienteData.getTelefono(),
                clienteData.getEmail(), clienteData.getDireccion(), clienteData.getLocalidad(),
                clienteData.getCodigoPostal(), clienteData.getProvincia(), clienteData.getPais(), clienteData.getVehiculo());
        flash.addFlashAttribute("mensaje", "Cliente creado correctamente");
        return "redirect:/cliente/lista";
    }


    //Si estamos iniciados sesión nos muestra la lista de clientes, si no, redirecciona al login
    @GetMapping("/cliente/lista")
    public String listadoClientes(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return "redirect:/login";
        } else {
            List<Cliente> clientes = clienteService.allClientes();
            model.addAttribute("clientes", clientes);
            return "listaClientes";
        }

    }

    //Metodo para añadir mas vehiculos a un cliente
    @GetMapping("/cliente/{id}/addVehicle")
    public String addVehicle(@PathVariable(value="id") Long idCliente, @ModelAttribute ClienteData clienteData, Model model) {
        Cliente cliente = clienteService.findById(idCliente);
        List<Vehiculo> vehiculos = vehiculoService.allVehiculos();
        List<Vehiculo> vehiculosCliente = (List<Vehiculo>) cliente.getVehiculos();
        //Bucle para solo mostrar los vehiculos que no tiene asignado el cliente
        for (int i=0; i<vehiculos.size();i++){
            for(int j=0; j<vehiculosCliente.size();j++){
                if (vehiculos.get(i).equals(vehiculosCliente.get(j))){
                    vehiculos.remove(vehiculosCliente.get(j));
                }
            }
        }
        model.addAttribute("cliente", cliente);
        clienteData.setNombre(cliente.getNombre());
        clienteData.setTelefono(cliente.getTelefono());
        clienteData.setEmail(cliente.getEmail());
        clienteData.setDireccion(cliente.getDireccion());
        clienteData.setLocalidad(cliente.getLocalidad());
        clienteData.setCodigoPostal(cliente.getCodigoPostal());
        clienteData.setProvincia(cliente.getProvincia());
        clienteData.setPais(cliente.getPais());
        model.addAttribute("vehiculos", vehiculos);
        return "addVehicle";
    }

    //Despues de añadir el vehiculo al cliente vuelve a la lista de clientes
    @PostMapping("/cliente/{id}/addVehicle")
    public String addVehicle(@PathVariable(value="id") Long idCliente,
                                   @ModelAttribute ClienteData clienteData,
                                   Model model, RedirectAttributes flash) {
        Cliente cliente = clienteService.findById(idCliente);
        clienteService.addVehicle(idCliente, clienteData.getVehiculo());
        flash.addFlashAttribute("mensaje", "Vehiculo añadido correctamente");
        return "redirect:/cliente/lista";
    }

    //Metodo para editar un cliente
    @GetMapping("/cliente/{id}/editar")
    public String formEditaCliente(@PathVariable(value="id") Long idCliente, @ModelAttribute ClienteData clienteData,
                                       Model model) {

        Cliente cliente = clienteService.findById(idCliente);
        // idVehiculo = cliente.getVehiculo();
        if (cliente == null) {
            throw new ClienteNotFoundException();
        }

        model.addAttribute("cliente", cliente);
        clienteData.setNombre(cliente.getNombre());
        clienteData.setTelefono(cliente.getTelefono());
        clienteData.setEmail(cliente.getEmail());
        clienteData.setDireccion(cliente.getDireccion());
        clienteData.setLocalidad(cliente.getLocalidad());
        clienteData.setCodigoPostal(cliente.getCodigoPostal());
        clienteData.setProvincia(cliente.getProvincia());
        clienteData.setPais(cliente.getPais());

        return "formEditarCliente";
    }

    //Despues de editar el cliente y guardalo, redirecciona a la lista de clientes
    @PostMapping("/cliente/{id}/editar")
    public String grabaClienteModificado(@PathVariable(value="id") Long idCliente, @ModelAttribute Vehiculo vehiculos, @ModelAttribute ClienteData clienteData,
                                       Model model, RedirectAttributes flash) {
        Cliente cliente = clienteService.findById(idCliente);
        //System.out.println("Valor: " +clienteData.getVehiculos());
        if (cliente == null) {
            throw new ClienteNotFoundException();
        }
        clienteService.modificaCliente(idCliente, clienteData.getNombre(), clienteData.getTelefono(), clienteData.getEmail(), clienteData.getDireccion(),
                clienteData.getLocalidad(), clienteData.getCodigoPostal(), clienteData.getProvincia(), clienteData.getPais());
        flash.addFlashAttribute("mensaje", "Cliente modificado correctamente");
        return "redirect:/cliente/lista";
    }

    //Metodo para eliminar un cliente
    @DeleteMapping("/cliente/{id}")
    @ResponseBody
    public String borrarCliente(@PathVariable(value="id") Long idCliente, RedirectAttributes flash) {
        Cliente cliente = clienteService.findById(idCliente);
        if (cliente == null) {
            throw new ClienteNotFoundException();
        }

        clienteService.borraCliente(idCliente);
        return "redirect:/cliente/lista";
    }



}
