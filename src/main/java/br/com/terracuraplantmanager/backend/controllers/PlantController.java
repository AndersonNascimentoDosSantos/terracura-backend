package br.com.terracuraplantmanager.backend.controllers;

import br.com.terracuraplantmanager.backend.model.PlantModel;
import br.com.terracuraplantmanager.backend.service.PlantService;
import br.com.terracuraplantmanager.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/plant")
public class PlantController {
    @Autowired
    private PlantService plantService;

    @GetMapping
    public ResponseEntity<List<PlantModel>> obterTodos() {
        List<PlantModel> plants = plantService.findAll();
        ModelMapper mapper = new ModelMapper();
        List<PlantModel> resposta = plants.stream().map(plant -> mapper
                        .map(plant, PlantModel.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PlantModel> adicionar(@RequestBody PlantModel plantReq) {
        ModelMapper mapper = new ModelMapper();

        PlantModel plant = mapper.map(plantReq, PlantModel.class);

        plant = plantService.create(plant);

        return new ResponseEntity<>(mapper.map(plant, PlantModel.class), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PlantModel>> obterPorId(@PathVariable Long id) {

        Optional<PlantModel> dto = plantService.findById(id);
        return new ResponseEntity<>(Optional.of(new ModelMapper().map(dto.get(), PlantModel.class)), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        plantService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlantModel> atualizar(@RequestBody PlantModel plantReq, @PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();
        PlantModel plant = mapper.map(plantReq, PlantModel.class);
        plant = plantService.update(id, plantReq);
        return new ResponseEntity<>(
                mapper.map(plant, PlantModel.class), HttpStatus.OK);
    }
}
