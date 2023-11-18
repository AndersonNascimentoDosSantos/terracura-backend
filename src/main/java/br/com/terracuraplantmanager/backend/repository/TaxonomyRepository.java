package br.com.terracuraplantmanager.backend.repository;

import br.com.terracuraplantmanager.backend.model.TaxonomyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxonomyRepository extends JpaRepository<TaxonomyModel, Long> {

}

