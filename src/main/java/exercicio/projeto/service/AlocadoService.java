package exercicio.projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import exercicio.projeto.model.Alocado;
import exercicio.projeto.repository.AlocadoRepository;

@Service
public class AlocadoService {
    private AlocadoRepository _alocadoRepositorio;

    public AlocadoService(AlocadoRepository alocadoRepositorio){
        this._alocadoRepositorio = alocadoRepositorio;
    }

    public List<Alocado> listarTodos(){
        return  _alocadoRepositorio.findAll();
    }

    public Alocado getPorId(long id){
        return  _alocadoRepositorio.findById(id).get();
    }

    public void inserir(Alocado funcionario){
        _alocadoRepositorio.save(funcionario);
    }

    public void atualiza(Alocado cargo){
        _alocadoRepositorio.save(cargo);
    }

    public void excluir(Alocado funcionario){
        _alocadoRepositorio.delete(funcionario);
    }
}
