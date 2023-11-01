package exercicio.projeto.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import exercicio.projeto.model.Cargo;
import exercicio.projeto.service.CargoService;

@Controller
public class CargoController {
    private CargoService _cargoService;

    public CargoController(CargoService cargoService){
        _cargoService = cargoService;
    } 

    @GetMapping(value="/")
    public ModelAndView index(){

        ModelAndView cargoModelView = new ModelAndView("index");

        return cargoModelView;
    }

    @GetMapping(value="/cargo/listar")
    public ModelAndView listagem(){
        List<Cargo> cargos = _cargoService.listarTodos();

        ModelAndView cargoModelView = new ModelAndView("cargo/listar");
        cargoModelView.addObject("Cargos", cargos);

        return cargoModelView;
    }

    @GetMapping(value="/cargo/novo")
    public ModelAndView novoCargoMovelView(){
        ModelAndView cargoModelView = new ModelAndView("cargo/editForm");
        Cargo cargo = new Cargo();
        cargoModelView.addObject("Cargo", cargo);

        return cargoModelView;
    }

    @PostMapping(value="/cargo/novo")
    public String salvarCargo(Cargo cargo){
        _cargoService.inserir(cargo);
        
        return "redirect:/cargo/listar";
    }

    @GetMapping(value="/cargo/editar/{id}")
    public ModelAndView editarCargoModelView(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("cargo/editForm");
        Cargo cargo = _cargoService.getPorId(id).get();

        mv.addObject("Cargo", cargo);

        return mv;
    }

    @PostMapping(value="cargo/editar")
    public String atualizarCargo(Cargo cargo){
        _cargoService.atualiza(cargo);
        
        return "redirect:/cargo/listar";
    }

    @GetMapping(value="/cargo/deletar/{id}")
    public String deletarCargo(@PathVariable("id") long id){
        Cargo cargo = _cargoService.getPorId(id).get();
        _cargoService.excluir(cargo);
        
        return "redirect:/cargo/listar";
    }
    
}
