package exercicio.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import exercicio.projeto.model.Cargo;
import exercicio.projeto.repository.CargoRepository;

@Service
public class CargoService {
    private CargoRepository repositorio;

    public CargoService(CargoRepository repositorio){
        this.repositorio = repositorio;
    }

    public List<Cargo> listarTodos(){
        return  repositorio.findAll();
    }

    public Optional<Cargo> getPorId(long id){
        return  repositorio.findById(id);
    }

    public void inserir(Cargo cargo){
        repositorio.save(cargo);
    }

    public void atualiza(Cargo cargo){
        repositorio.save(cargo);
    }

    public void excluir(Cargo cargo){
        repositorio.delete(cargo);
    }
}
