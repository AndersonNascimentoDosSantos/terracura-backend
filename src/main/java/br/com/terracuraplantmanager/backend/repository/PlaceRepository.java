package br.com.terracuraplantmanager.backend.repository;

import br.com.terracuraplantmanager.backend.model.PlaceModel;
import br.com.terracuraplantmanager.backend.model.PlantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceModel, Long> {

}

