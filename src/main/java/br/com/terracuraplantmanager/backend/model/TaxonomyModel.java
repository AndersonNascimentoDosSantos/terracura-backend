package br.com.terracuraplantmanager.backend.model;

import br.com.terracuraplantmanager.backend.Represantations.Taxonomy;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_taxonomies")
public class TaxonomyModel {

    @Id
    @SequenceGenerator(name = "taxonomy", sequenceName = "seq_taxonomies", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taxonomy")
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "kingdom", column = @Column(name = "kingdom")),
            @AttributeOverride(name = "phylum", column = @Column(name = "phylum")),
            @AttributeOverride(name = "classe", column = @Column(name = "classe")),
            @AttributeOverride(name = "order", column = @Column(name = "order_col")),
            @AttributeOverride(name = "family", column = @Column(name = "family")),
            @AttributeOverride(name = "genus", column = @Column(name = "genus")),
            @AttributeOverride(name = "species", column = @Column(name = "species"))
    })
    private Taxonomy taxonomy;
    @OneToOne(mappedBy = "taxonomyModel")
    private PlantModel plantModel;

}