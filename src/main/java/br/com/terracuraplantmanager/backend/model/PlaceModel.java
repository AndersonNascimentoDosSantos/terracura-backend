package br.com.terracuraplantmanager.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_places")
public class PlaceModel {
    @Id
    @SequenceGenerator(name = "place", sequenceName = "seq_places", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "place")
    private Long id;

    @ManyToMany(mappedBy = "placeModel")
    @JsonBackReference("place_plants")
    private List<PlantModel> plantModel;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "tbl_place_user",
            joinColumns = { @JoinColumn(name = "place_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    @JsonManagedReference("place_plants")
    private List<UserModel> userModel;

    private String PlaceName;

}
