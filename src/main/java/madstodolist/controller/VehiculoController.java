package madstodolist.controller;

import madstodolist.authentication.ManagerUserSession;
import madstodolist.controller.exception.VehiculoNotFoundException;
import madstodolist.model.Vehiculo;
import madstodolist.service.ClienteService;
import madstodolist.service.UsuarioService;
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
public class VehiculoController {
    @Autowired
    VehiculoService vehiculoService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ManagerUserSession managerUserSession;

    //Si estamos iniciados sesión nos muestra el formulario de creación de vehiculos, si no, redirecciona al login
    @GetMapping("/vehiculo/nuevo")
    public String nuevoVehiculoForm(@ModelAttribute VehiculoData vehiculoData, Model model, HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return "redirect:/login";
        } else {

            return "formNuevoVehiculo";
        }
    }

    //Crea un vehiculo con los datos introducidos y muestra la lista de vehiculos
    @PostMapping("/vehiculo/nuevo")
    public String nuevoVehiculo(@ModelAttribute VehiculoData vehiculoData,
                               Model model, RedirectAttributes flash) {

        vehiculoService.nuevoVehiculo(vehiculoData.getMarca(), vehiculoData.getModelo(), vehiculoData.getCc()
                ,vehiculoData.getMatricula(), vehiculoData.getTipoVehiculo(), vehiculoData.getCarroceria());
        flash.addFlashAttribute("mensaje", "Vehiculo creado correctamente");
        return "redirect:/vehiculo/lista";
    }

    //Si estamos iniciados sesión nos muestra la lista de vehiculos, si no, redirecciona al login
    @GetMapping("/vehiculo/lista")
    public String listadoVehiculos(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return "redirect:/login";
        } else {
            List<Vehiculo> vehiculos = vehiculoService.allVehiculos();
            model.addAttribute("vehiculos", vehiculos);
            return "listaVehiculos";
        }

    }

    //Metodo para editar un vehiculo
    @GetMapping("/vehiculo/{id}/editar")
    public String formEditaVehiculo(@PathVariable(value="id") Long idVehiculo, @ModelAttribute VehiculoData vehiculoData,
                                   Model model) {

        Vehiculo vehiculo = vehiculoService.findById(idVehiculo);
        if (vehiculo == null) {
            throw new VehiculoNotFoundException();
        }
        model.addAttribute("vehiculo", vehiculo);
        vehiculoData.setMarca(vehiculo.getMarca());
        vehiculoData.setModelo(vehiculo.getModelo());
        vehiculoData.setCc(vehiculo.getCc());
        vehiculoData.setMatricula(vehiculo.getMatricula());
        vehiculoData.setTipoVehiculo(vehiculo.getTipoVehiculo());
        vehiculoData.setCarroceria(vehiculo.getCarroceria());
        vehiculoData.setCliente(vehiculo.getCliente());

        return "formEditarVehiculo";
    }

    //Despues de editar el vehiculo y guardalo, redirecciona a la lista de vehiculos
    @PostMapping("/vehiculo/{id}/editar")
    public String grabaVehiculoModificado(@PathVariable(value="id") Long idVehiculo, @ModelAttribute VehiculoData vehiculoData,
                                         Model model, RedirectAttributes flash) {
        Vehiculo vehiculo = vehiculoService.findById(idVehiculo);
        if (vehiculo == null) {
            throw new VehiculoNotFoundException();
        }

        vehiculoService.modificaVehiculo(idVehiculo, vehiculoData.getMarca(), vehiculoData.getModelo(), vehiculoData.getCc()
                ,vehiculoData.getMatricula(), vehiculoData.getTipoVehiculo(), vehiculoData.getCarroceria());
        flash.addFlashAttribute("mensaje", "Vehiculo modificado correctamente");
        return "redirect:/vehiculo/lista";
    }

    //Metodo para eliminar un vehiculo
    @DeleteMapping("/vehiculo/{id}")
    @ResponseBody
    public String borrarVehiculo(@PathVariable(value="id") Long idVehiculo, RedirectAttributes flash) {
        Vehiculo vehiculo = vehiculoService.findById(idVehiculo);
        if (vehiculo == null) {
            throw new VehiculoNotFoundException();
        }

        vehiculoService.borraVehiculo(idVehiculo);
        return "redirect:/vehiculo/lista";
    }


}
