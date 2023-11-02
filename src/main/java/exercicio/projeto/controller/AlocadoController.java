package exercicio.projeto.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import exercicio.projeto.model.Alocado;
import exercicio.projeto.model.Cargo;
import exercicio.projeto.model.Funcionario;
import exercicio.projeto.service.AlocadoService;
import exercicio.projeto.service.CargoService;
import exercicio.projeto.service.FuncionarioService;

@Controller
public class AlocadoController {
    private AlocadoService _alocadoService;
    private FuncionarioService _funcionarioService;
    private CargoService _cargoService;

    public AlocadoController(
        AlocadoService alocadoService,
        FuncionarioService funcionarioService,
        CargoService cargoService)
    {
        _alocadoService = alocadoService;
        _funcionarioService = funcionarioService;
        _cargoService = cargoService;
    } 

    @GetMapping(value="/alocado/listar")
    public ModelAndView listagem(){
        List<Alocado> alocados = _alocadoService.listarTodos();

        ModelAndView alocadoModelView = new ModelAndView("alocado/listar");
        alocadoModelView.addObject("Alocados", alocados);

        return alocadoModelView;
    }

    @GetMapping(value="/alocado/novo")
    public ModelAndView novoAlocadoModelView(){
        ModelAndView alocadoModelView = new ModelAndView("alocado/editForm");

        Alocado alocado = new Alocado();
        List<Funcionario> funcionarios = _funcionarioService.listarTodos();
        List<Cargo> cargos = _cargoService.listarTodos();

        alocadoModelView.addObject("Alocado", alocado);
        alocadoModelView.addObject("Cargos", cargos);
        alocadoModelView.addObject("Funcionarios", funcionarios);

        return alocadoModelView;
    }

    @PostMapping(value="/alocado/novo")
    public String salvarAlocado(Alocado alocado){
        _alocadoService.inserir(alocado);
        
        return "redirect:/alocado/listar";
    }

    @GetMapping(value="/alocado/editar/{id}")
    public ModelAndView editarAlocadoModelView(@PathVariable("id") long id){
        ModelAndView alocadoModelView = new ModelAndView("alocado/editForm");
        Alocado alocado = _alocadoService.getPorId(id);
        List<Funcionario> funcionarios = _funcionarioService.listarTodos();
        List<Cargo> cargos = _cargoService.listarTodos();

        alocadoModelView.addObject("Alocado", alocado);
        alocadoModelView.addObject("Cargos", cargos);
        alocadoModelView.addObject("Funcionarios", funcionarios);        

        return alocadoModelView;
    }

    @PostMapping(value="alocado/editar")
    public String atualizaAlocado(Alocado alocado){
        _alocadoService.atualiza(alocado);
        
        return "redirect:/alocado/listar";
    }

    @GetMapping(value="/alocado/deletar/{id}")
    public String deletarAlocado(@PathVariable("id") long id){
        Alocado alocado = _alocadoService.getPorId(id);
        _alocadoService.excluir(alocado);
        
        return "redirect:/alocado/listar";
    }
    
}
