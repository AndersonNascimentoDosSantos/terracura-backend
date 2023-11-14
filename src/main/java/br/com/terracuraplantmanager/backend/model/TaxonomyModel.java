package br.com.terracuraplantmanager.backend.model;

import br.com.terracuraplantmanager.backend.Represantations.Taxonomy;
import jakarta.persistence.*;

@Entity
@Table(name = "taxonomies")
public class TaxonomyModel {

    @Id
    @SequenceGenerator(name = "taxonomy", sequenceName = "seq_taxonomies", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taxonomy")
    private Long id;

    @Embedded
    private Taxonomy taxonomy;
}