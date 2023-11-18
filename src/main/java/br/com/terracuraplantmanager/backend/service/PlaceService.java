package br.com.terracuraplantmanager.backend.service;

import br.com.terracuraplantmanager.backend.model.PlaceModel;
import br.com.terracuraplantmanager.backend.model.exception.ResourceNotFoundException;
import br.com.terracuraplantmanager.backend.repository.PlaceRepository;
import br.com.terracuraplantmanager.backend.repository.PlantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    /**
     * Retorna lista de Usuarios
     *
     * @return lista de Usuarios
     */
    public List<PlaceModel> findAll() {

        List<PlaceModel> places = placeRepository.findAll();

        return places.stream()
                .map(place -> new ModelMapper()
                        .map(place, PlaceModel.class))
                .collect(Collectors.toList());
    }

    /**
     * Metodo que retorna um Usuario pelo id
     *
     * @param id do Usuario a ser localizado
     * @return retorna um Usuario caso encotrado
     */
    public Optional<PlaceModel> findById(Long id) {
        // obtemos optional de Usuario por id
        Optional<PlaceModel> place = placeRepository.findById(id);

        // se nao encontrar lança, Exception
        if (place.isEmpty()) {
            throw new ResourceNotFoundException("place com o id: " + id + " não encontrado");
        }
        // convertendo o meu optional de place em place e devolvendo um optional
        // de place
        return Optional.of(new ModelMapper().map(place.get(), PlaceModel.class));

    }

    /**
     * metodo para adicionar Usuario na lista
     *
     * @param place PlaceModel a ser adicionado no banco
     * @return retorna o Usuario inserido na lista
     */
    public PlaceModel create(PlaceModel place) {
        // remover o id para consegui fazer o cadastro
        place.setId(null);
        // place.setSenha(place.getSenha());
        // cria um objeto de mapeamento
        ModelMapper mapper = new ModelMapper();
        // converter o nosso place em um place
        // place place = mapper.map(place, place.class);
        // salvar po place no banco
        place = placeRepository.save(place);
        place.setId(place.getId());
        // retornar um place atualizado

        return place;
    }

    /**
     * remove item baseado no id informado se existir
     *
     * @param id do objeto a ser removido
     */
    public void deleteById(Long id) {
        Optional<PlaceModel> place = placeRepository.findById(id);
        // se nao existir lança exception
        if (place.isEmpty()) {
            throw new ResourceNotFoundException(
                    "Nao foi possivel deletar o Usuario com o id: " + id + "- Usuario não existe");
        }

        placeRepository.deleteById(id);
    }

    /**
     * metodo pra atualizar Usuario na lista
     *
     * @param place PlaceModel  a ser atualizado
     * @return
     */
    public PlaceModel update(Long id, PlaceModel place) {
        // passar o id para o place
        Optional<PlaceModel> usuario = this.findById(id);

        place.setId(id);
        // criar objeto de mapeamento
        ModelMapper mapper = new ModelMapper();
        // converter o place em place
        // place place = mapper.map(place, PlaceModel.class);
        // atualizar o place no banco de dados
        placeRepository.save(place);
        // retornar place atualizado
        return place;
    }
}
