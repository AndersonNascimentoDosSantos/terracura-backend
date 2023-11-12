package br.com.terracuraplantmanager.backend.repository;

import br.com.terracuraplantmanager.backend.model.PlantModel;
import br.com.terracuraplantmanager.backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<PlantModel, Long> {

}

