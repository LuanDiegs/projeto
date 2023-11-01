package exercicio.projeto.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import exercicio.projeto.model.Funcionario;
import exercicio.projeto.service.FuncionarioService;

@Controller
public class FuncionarioController {
    private FuncionarioService _funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService){
        _funcionarioService = funcionarioService;
    } 

    @GetMapping(value="/funcionario/listar")
    public ModelAndView listagem(){
        List<Funcionario> funcionarios = _funcionarioService.listarTodos();

        ModelAndView funcionarioModelView = new ModelAndView("funcionario/listar");
        funcionarioModelView.addObject("Funcionarios", funcionarios);

        return funcionarioModelView;
    }

    @GetMapping(value="/funcionario/novo")
    public ModelAndView novoFuncionarioModelView(){
        ModelAndView funcionarioModelView = new ModelAndView("funcionario/editForm");
        Funcionario funcionario = new Funcionario();
        funcionarioModelView.addObject("Funcionario", funcionario);

        return funcionarioModelView;
    }

    @PostMapping(value="/funcionario/novo")
    public String salvarFuncionario(Funcionario funcionario){
        _funcionarioService.inserir(funcionario);
        
        return "redirect:/funcionario/listar";
    }

    @GetMapping(value="/funcionario/editar/{id}")
    public ModelAndView editarFuncionarioModelView(@PathVariable("id") long id){
        ModelAndView funcionarioModelView = new ModelAndView("funcionario/editForm");
        Funcionario funcionario = _funcionarioService.getPorId(id);
        
        funcionarioModelView.addObject("Funcionario", funcionario);

        return funcionarioModelView;
    }

    @PostMapping(value="funcionario/editar")
    public String atualizaFuncionario(Funcionario funcionario){
        _funcionarioService.atualiza(funcionario);
        
        return "redirect:/funcionario/listar";
    }

    @GetMapping(value="/funcionario/deletar/{id}")
    public String deletarFuncionario(@PathVariable("id") long id){
        Funcionario funcionario = _funcionarioService.getPorId(id);
        _funcionarioService.excluir(funcionario);
        
        return "redirect:/funcionario/listar";
    }
    
}
