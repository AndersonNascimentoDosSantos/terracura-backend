package br.com.terracuraplantmanager.backend.controllers;

import br.com.terracuraplantmanager.backend.model.TaxonomyModel;
import br.com.terracuraplantmanager.backend.service.PlantService;
import br.com.terracuraplantmanager.backend.service.TaxonomyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/taxonomy")
public class TaxonomyController {
    @Autowired
    private TaxonomyService taxonomyService;

    @GetMapping
    public ResponseEntity<List<TaxonomyModel>> obterTodos() {
        List<TaxonomyModel> plants = taxonomyService.findAll();
        ModelMapper mapper = new ModelMapper();
        List<TaxonomyModel> resposta = plants.stream().map(plant -> mapper
                        .map(plant, TaxonomyModel.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

//    ResponseEntity<TaxonomyModel>
    @PostMapping
    public String adicionar(@ModelAttribute TaxonomyModel plantReq, Model model) {
        ModelMapper mapper = new ModelMapper();
        TaxonomyModel plant;

        plant = taxonomyService.create(plantReq);
//        model.addAttribute("createdTaxonomy", plant);
return plantReq.toString();
//        return new ResponseEntity<>( plantReq, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TaxonomyModel>> obterPorId(@PathVariable Long id) {

        Optional<TaxonomyModel> dto = taxonomyService.findById(id);
        return new ResponseEntity<>(Optional.of(new ModelMapper().map(dto.get(), TaxonomyModel.class)), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        taxonomyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaxonomyModel> atualizar(@RequestBody TaxonomyModel plantReq, @PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();
        TaxonomyModel plant = mapper.map(plantReq, TaxonomyModel.class);
        plant = taxonomyService.update(id, plantReq);
        return new ResponseEntity<>(
                mapper.map(plant, TaxonomyModel.class), HttpStatus.OK);
    }
}
