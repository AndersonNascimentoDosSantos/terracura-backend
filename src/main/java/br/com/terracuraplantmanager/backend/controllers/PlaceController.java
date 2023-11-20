package br.com.terracuraplantmanager.backend.controllers;


import br.com.terracuraplantmanager.backend.model.PlaceModel;
import br.com.terracuraplantmanager.backend.model.request.PlaceRequest;
import br.com.terracuraplantmanager.backend.service.PlaceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/place")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping
    public ResponseEntity<List<PlaceModel>> obterTodos() {
        List<PlaceModel> plants = placeService.findAll();
        ModelMapper mapper = new ModelMapper();
        List<PlaceModel> resposta = plants.stream().map(plant -> mapper
                        .map(plant, PlaceModel.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PlaceModel> adicionar(@RequestBody @Validated PlaceRequest placeReq) {
        ModelMapper mapper = new ModelMapper();
        PlaceModel place = mapper.map(placeReq, PlaceModel.class);
        PlaceModel placeModel = placeService.create(place);

        return new ResponseEntity<>(mapper.map(placeModel, PlaceModel.class), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PlaceModel>> obterPorId(@PathVariable Long id) {

        Optional<PlaceModel> dto = placeService.findById(id);
        return new ResponseEntity<>(Optional.of(new ModelMapper().map(dto.get(), PlaceModel.class)), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        placeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaceModel> atualizar(@RequestBody PlaceModel placeReq, @PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();
        PlaceModel placeModel = placeService.update(id, placeReq);
        return new ResponseEntity<>(
                mapper.map(placeModel, PlaceModel.class), HttpStatus.OK);
    }
}
