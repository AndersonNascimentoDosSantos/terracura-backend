package br.com.terracuraplantmanager.backend.service;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

import br.com.terracuraplantmanager.backend.model.UserModel;
import br.com.terracuraplantmanager.backend.model.exception.ResourceNotFoundException;
import br.com.terracuraplantmanager.backend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Retorna lista de Usuarios
     *
     * @return lista de Usuarios
     */
    public List<UserModel> findAll() {

        List<UserModel> Usuarios = userRepository.findAll();

        return Usuarios.stream()
                .map(Usuario -> new ModelMapper()
                        .map(Usuario, UserModel.class))
                .collect(Collectors.toList());
    }

    /**
     * Metodo que retorna um Usuario pelo id
     *
     * @param id do Usuario a ser localizado
     * @return retorna um Usuario caso encotrado
     */
    public Optional<UserModel> findById(Long id) {
        // obtemos optional de Usuario por id
        Optional<UserModel> Usuario = userRepository.findById(id);

        // se nao encontrar lança, Exception
        if (Usuario.isEmpty()) {
            throw new ResourceNotFoundException("Usuario com o id: " + id + " não encontrado");
        }
        // convertendo o meu optional de Usuario em Usuario e devolvendo um optional
        // de Usuario
        return Optional.of(new ModelMapper().map(Usuario.get(), UserModel.class));

    }

    /**
     * metodo para adicionar Usuario na lista
     *
     * @param user UserModel a ser adicionado no banco
     * @return retorna o Usuario inserido na lista
     */
    public UserModel create(UserModel user) {
        // remover o id para consegui fazer o cadastro
        user.setId(null);
        // user.setSenha(user.getSenha());
        // cria um objeto de mapeamento
        ModelMapper mapper = new ModelMapper();
        // converter o nosso user em um user
        // user user = mapper.map(user, user.class);
        // salvar po user no banco
        user = userRepository.save(user);
        user.setId(user.getId());
        // retornar um user atualizado

        return user;
    }

    /**
     * remove item baseado no id informado se existir
     *
     * @param id do objeto a ser removido
     */
    public void deleteById(Long id) {
        Optional<UserModel> Usuario = userRepository.findById(id);
        // se nao existir lança exception
        if (Usuario.isEmpty()) {
            throw new ResourceNotFoundException(
                    "Nao foi possivel deletar o Usuario com o id: " + id + "- Usuario não existe");
        }

        userRepository.deleteById(id);
    }

    /**
     * metodo pra atualizar Usuario na lista
     *
     * @param user UserModel  a ser atualizado
     * @return
     */
    public UserModel update(Long id, UserModel user) {
        // passar o id para o user
        Optional<UserModel> usuario = this.findById(id);

        user.setId(id);
        // criar objeto de mapeamento
        ModelMapper mapper = new ModelMapper();
        // converter o user em user
        // user user = mapper.map(user, UserModel.class);
        // atualizar o user no banco de dados
        userRepository.save(user);
        // retornar user atualizado
        return user;
    }
}
