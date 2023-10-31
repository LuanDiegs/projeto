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
    private CargoService cv;

    public CargoController(CargoService cs){
        cv = cs;
    } 

    @GetMapping(value="/")
    public ModelAndView index(){

        ModelAndView mv = new ModelAndView("index");

        return mv;
    }

    @GetMapping(value="/cargo/listar")
    public ModelAndView listagem(){
        List<Cargo> c = cv.listarTodos();

        ModelAndView mv = new ModelAndView("cargo/listar");
        mv.addObject("Cargos", c);

        return mv;
    }

    @GetMapping(value="/cargo/novo")
    public ModelAndView novoCargo(){
        ModelAndView mv = new ModelAndView("cargo/editForm");
        Cargo cli = new Cargo();
        mv.addObject("cargo", cli);

        return mv;
    }

    @PostMapping(value="/cargo/novo")
    public String salvarCargo(Cargo cargo){
        cv.inserir(cargo);
        
        return "redirect:/cargo/listar";
    }

    @GetMapping(value="/cargo/editar/{id}")
    public ModelAndView editarCargo(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("cargo/editForm");
        Cargo cli = cv.getPorId(id).get();
        mv.addObject("cargo", cli);

        return mv;
    }

    @PostMapping(value="cargo/editar")
    public String atualizarCargo(Cargo cargo){
        cv.atualiza(cargo);
        
        return "redirect:/cargo/listar";
    }

    @GetMapping(value="/cargo/deletar/{id}")
    public String deletarCargo(@PathVariable("id") long id){
        Cargo cargo = cv.getPorId(id).get();
        cv.excluir(cargo);
        
        return "redirect:/cargo/listar";
    }
    
}
