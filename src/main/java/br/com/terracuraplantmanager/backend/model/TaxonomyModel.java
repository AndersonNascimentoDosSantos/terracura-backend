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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Taxonomy getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(Taxonomy taxonomy) {
        this.taxonomy = taxonomy;
    }

    public PlantModel getPlantModel() {
        return plantModel;
    }

    public void setPlantModel(PlantModel plantModel) {
        this.plantModel = plantModel;
    }
    @Override
    public String toString() {
        return "Taxonomy{" +
                "classe='" + this.taxonomy.getClasse() + '\'' +
                ", family='" + this.taxonomy.getFamily() + '\'' +
                ", genus='" + this.taxonomy.getGenus() + '\'' +
                ", kingdom='" + this.taxonomy.getKingdom() + '\'' +
                ", orderCol='" + this.taxonomy.getOrder() + '\'' +
                ", phylum='" + this.taxonomy.getPhylum() + '\'' +
                ", species='" + this.taxonomy.getSpecies() + '\'' +
                ", id=" + id +
                '}';
    }
}