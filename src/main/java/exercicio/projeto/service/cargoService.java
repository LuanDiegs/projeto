package exercicio.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import exercicio.projeto.model.Cargo;
import exercicio.projeto.repository.CargoRepository;

@Service
public class CargoService {
    private CargoRepository _cargoRepositorio;

    public CargoService(CargoRepository cargoRepositorio){
        this._cargoRepositorio = cargoRepositorio;
    }

    public List<Cargo> listarTodos(){
        return  _cargoRepositorio.findAll();
    }

    public Optional<Cargo> getPorId(long id){
        return  _cargoRepositorio.findById(id);
    }

    public void inserir(Cargo cargo){
        _cargoRepositorio.save(cargo);
    }

    public void atualiza(Cargo cargo){
        _cargoRepositorio.save(cargo);
    }

    public void excluir(Cargo cargo){
        _cargoRepositorio.delete(cargo);
    }
}
