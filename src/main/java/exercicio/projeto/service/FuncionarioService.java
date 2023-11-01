package exercicio.projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import exercicio.projeto.model.Funcionario;
import exercicio.projeto.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    private FuncionarioRepository _funcionarioRepositorio;

    public FuncionarioService(FuncionarioRepository funcinarioRepositorio){
        this._funcionarioRepositorio = funcinarioRepositorio;
    }

    public List<Funcionario> listarTodos(){
        return  _funcionarioRepositorio.findAll();
    }

    public Funcionario getPorId(long id){
        return  _funcionarioRepositorio.findById(id).get();
    }

    public void inserir(Funcionario funcionario){
        _funcionarioRepositorio.save(funcionario);
    }

    public void atualiza(Funcionario cargo){
        _funcionarioRepositorio.save(cargo);
    }

    public void excluir(Funcionario funcionario){
        _funcionarioRepositorio.delete(funcionario);
    }
}
