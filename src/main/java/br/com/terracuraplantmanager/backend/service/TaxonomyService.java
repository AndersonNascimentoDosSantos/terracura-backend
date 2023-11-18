package br.com.terracuraplantmanager.backend.service;

import br.com.terracuraplantmanager.backend.model.TaxonomyModel;
import br.com.terracuraplantmanager.backend.model.exception.ResourceNotFoundException;
import br.com.terracuraplantmanager.backend.repository.TaxonomyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TaxonomyService {
    @Autowired
    private TaxonomyRepository taxonomyRepository;

    /**
     * Retorna lista de Usuarios
     *
     * @return lista de Usuarios
     */
    public List<TaxonomyModel> findAll() {

        List<TaxonomyModel> taxonomys = taxonomyRepository.findAll();

        return taxonomys.stream()
                .map(taxonomy -> new ModelMapper()
                        .map(taxonomy, TaxonomyModel.class))
                .collect(Collectors.toList());
    }

    /**
     * Metodo que retorna um Usuario pelo id
     *
     * @param id do Usuario a ser localizado
     * @return retorna um Usuario caso encotrado
     */
    public Optional<TaxonomyModel> findById(Long id) {
        // obtemos optional de Usuario por id
        Optional<TaxonomyModel> taxonomy = taxonomyRepository.findById(id);

        // se nao encontrar lança, Exception
        if (taxonomy.isEmpty()) {
            throw new ResourceNotFoundException("taxonomy com o id: " + id + " não encontrado");
        }
        // convertendo o meu optional de taxonomy em taxonomy e devolvendo um optional
        // de taxonomy
        return Optional.of(new ModelMapper().map(taxonomy.get(), TaxonomyModel.class));

    }

    /**
     * metodo para adicionar Usuario na lista
     *
     * @param taxonomy TaxonomyModel a ser adicionado no banco
     * @return retorna o Usuario inserido na lista
     */
    public TaxonomyModel create(TaxonomyModel taxonomy) {
        // remover o id para consegui fazer o cadastro
        taxonomy.setId(null);
        // taxonomy.setSenha(taxonomy.getSenha());
        // cria um objeto de mapeamento
        ModelMapper mapper = new ModelMapper();
        // converter o nosso taxonomy em um taxonomy
        // taxonomy taxonomy = mapper.map(taxonomy, taxonomy.class);
        // salvar po taxonomy no banco
        taxonomy = taxonomyRepository.save(taxonomy);
        taxonomy.setId(taxonomy.getId());
        // retornar um taxonomy atualizado

        return taxonomy;
    }

    /**
     * remove item baseado no id informado se existir
     *
     * @param id do objeto a ser removido
     */
    public void deleteById(Long id) {
        Optional<TaxonomyModel> taxonomy = taxonomyRepository.findById(id);
        // se nao existir lança exception
        if (taxonomy.isEmpty()) {
            throw new ResourceNotFoundException(
                    "Nao foi possivel deletar o Usuario com o id: " + id + "- Usuario não existe");
        }

        taxonomyRepository.deleteById(id);
    }

    /**
     * metodo pra atualizar Usuario na lista
     *
     * @param taxonomy TaxonomyModel  a ser atualizado
     * @return
     */
    public TaxonomyModel update(Long id, TaxonomyModel taxonomy) {
        // passar o id para o taxonomy
        Optional<TaxonomyModel> usuario = this.findById(id);

        taxonomy.setId(id);
        // criar objeto de mapeamento
        ModelMapper mapper = new ModelMapper();
        // converter o taxonomy em taxonomy
        // taxonomy taxonomy = mapper.map(taxonomy, TaxonomyModel.class);
        // atualizar o taxonomy no banco de dados
        taxonomyRepository.save(taxonomy);
        // retornar taxonomy atualizado
        return taxonomy;
    }
}
