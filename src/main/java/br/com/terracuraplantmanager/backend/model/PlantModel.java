package br.com.terracuraplantmanager.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_plants")
public class PlantModel {
    @Id
    @SequenceGenerator(name = "plant", sequenceName = "seq_plants", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plant")
    private Long id;

    @ManyToMany()
    @JoinTable(
            name = "tbl_plant_users",
            joinColumns = { @JoinColumn(name = "plant_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    @JsonManagedReference("user_plants")
    private List<UserModel> userModel;


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "tbl_plant_places",
            joinColumns = { @JoinColumn(name = "plant_id") },
            inverseJoinColumns = { @JoinColumn(name = "place_id") }
    )
    @JsonManagedReference("place_plants")
    private List<PlaceModel> placeModel;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "taxonomy_id", nullable = true)
    private TaxonomyModel taxonomyModel;
    private String PlantName;
    private String plantDescription;
    private String plant_access_token;
}
