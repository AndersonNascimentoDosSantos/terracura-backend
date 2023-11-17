package br.com.terracuraplantmanager.backend.controllers;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

import br.com.terracuraplantmanager.backend.model.UserModel;
import br.com.terracuraplantmanager.backend.service.UserService;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserModel>> obterTodos() {
        List<UserModel> usuarios = userService.findAll();
        ModelMapper mapper = new ModelMapper();
        List<UserModel> resposta = usuarios.stream().map(usuario -> mapper
                        .map(usuario, UserModel.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserModel> adicionar(@RequestBody UserModel usuarioReq) {
        ModelMapper mapper = new ModelMapper();

        UserModel usuario = mapper.map(usuarioReq, UserModel.class);

        usuario = userService.create(usuario);

        return new ResponseEntity<>(mapper.map(usuario, UserModel.class), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserModel>> obterPorId(@PathVariable Long id) {

        Optional<UserModel> dto = userService.findById(id);
        return new ResponseEntity<>(Optional.of(new ModelMapper().map(dto.get(), UserModel.class)), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> atualizar(@RequestBody UserModel usuarioReq, @PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();
        UserModel usuario = mapper.map(usuarioReq, UserModel.class);
        usuario = userService.update(id, usuarioReq);
        return new ResponseEntity<>(
                mapper.map(usuario, UserModel.class), HttpStatus.OK);
    }
}
