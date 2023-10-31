package exercicio.projeto.controller;

import java.rmi.server.UID;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import exercicio.projeto.model.cargo;
import exercicio.projeto.service.cargoService;

@Controller
public class cargoController {
    private cargoService cv;

    public cargoController(cargoService cs){
        cv = cs;
    } 

    @GetMapping(value="/")
    public ModelAndView listagem(){
        List<cargo> c = cv.listarTodos();

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("Cargos", c);

        return mv;
    }

    @GetMapping(value="/novo")
    public ModelAndView novoCargo(){
        ModelAndView mv = new ModelAndView("cadastroCargo");
        cargo cli = new cargo();
        mv.addObject("cargo", cli);

        return mv;
    }

    @PostMapping(value="/novo")
    public String salvarCargo(cargo cargo){
        cv.inserir(cargo);
        
        return "redirect:/";
    }

    @GetMapping(value="/editar/{id}")
    public ModelAndView editarCargo(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("cadastroCargo");
        cargo cli = cv.getPorId(id).get();
        mv.addObject("cargo", cli);

        return mv;
    }

    @PostMapping(value="/editar/{id}")
    public String atualizarCargo(cargo cargo){
        cv.atualiza(cargo);
        
        return "redirect:/";
    }
}
