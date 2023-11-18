package br.com.terracuraplantmanager.backend.service;

import br.com.terracuraplantmanager.backend.model.PlantModel;
import br.com.terracuraplantmanager.backend.model.UserModel;
import br.com.terracuraplantmanager.backend.model.exception.ResourceNotFoundException;
import br.com.terracuraplantmanager.backend.repository.PlantRepository;
import br.com.terracuraplantmanager.backend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PlantService {
    @Autowired
    private PlantRepository plantRepository;

    /**
     * Retorna lista de Usuarios
     *
     * @return lista de Usuarios
     */
    public List<PlantModel> findAll() {

        List<PlantModel> plants = plantRepository.findAll();

        return plants.stream()
                .map(plant -> new ModelMapper()
                        .map(plant, PlantModel.class))
                .collect(Collectors.toList());
    }

    /**
     * Metodo que retorna um Usuario pelo id
     *
     * @param id do Usuario a ser localizado
     * @return retorna um Usuario caso encotrado
     */
    public Optional<PlantModel> findById(Long id) {
        // obtemos optional de Usuario por id
        Optional<PlantModel> plant = plantRepository.findById(id);

        // se nao encontrar lança, Exception
        if (plant.isEmpty()) {
            throw new ResourceNotFoundException("plant com o id: " + id + " não encontrado");
        }
        // convertendo o meu optional de plant em plant e devolvendo um optional
        // de plant
        return Optional.of(new ModelMapper().map(plant.get(), PlantModel.class));

    }

    /**
     * metodo para adicionar Usuario na lista
     *
     * @param plant PlantModel a ser adicionado no banco
     * @return retorna o Usuario inserido na lista
     */
    public PlantModel create(PlantModel plant) {
        // remover o id para consegui fazer o cadastro
        plant.setId(null);
        // plant.setSenha(plant.getSenha());
        // cria um objeto de mapeamento
        ModelMapper mapper = new ModelMapper();
        // converter o nosso plant em um plant
        // plant plant = mapper.map(plant, plant.class);
        // salvar po plant no banco
        plant = plantRepository.save(plant);
        plant.setId(plant.getId());
        // retornar um plant atualizado

        return plant;
    }

    /**
     * remove item baseado no id informado se existir
     *
     * @param id do objeto a ser removido
     */
    public void deleteById(Long id) {
        Optional<PlantModel> plant = plantRepository.findById(id);
        // se nao existir lança exception
        if (plant.isEmpty()) {
            throw new ResourceNotFoundException(
                    "Nao foi possivel deletar o Usuario com o id: " + id + "- Usuario não existe");
        }

        plantRepository.deleteById(id);
    }

    /**
     * metodo pra atualizar Usuario na lista
     *
     * @param plant PlantModel  a ser atualizado
     * @return
     */
    public PlantModel update(Long id, PlantModel plant) {
        // passar o id para o plant
        Optional<PlantModel> usuario = this.findById(id);

        plant.setId(id);
        // criar objeto de mapeamento
        ModelMapper mapper = new ModelMapper();
        // converter o plant em plant
        // plant plant = mapper.map(plant, PlantModel.class);
        // atualizar o plant no banco de dados
        plantRepository.save(plant);
        // retornar plant atualizado
        return plant;
    }
}
