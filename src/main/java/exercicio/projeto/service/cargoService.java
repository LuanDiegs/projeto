package exercicio.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import exercicio.projeto.model.cargo;
import exercicio.projeto.repository.cargoRepository;

@Service
public class cargoService {
    private cargoRepository repositorio;

    public cargoService(cargoRepository repositorio){
        this.repositorio = repositorio;
    }

    public List<cargo> listarTodos(){
        return  repositorio.findAll();
    }

    public Optional<cargo> getPorId(long id){
        return  repositorio.findById(id);
    }

    public void inserir(cargo cliente){
        repositorio.save(cliente);
    }
    public void atualiza(cargo cliente){
        repositorio.save(cliente);
    }

    public void excluir(cargo cliente){
        repositorio.delete(cliente);
    }
}
