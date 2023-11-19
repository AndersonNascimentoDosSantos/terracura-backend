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
//    @JsonBackReference("place_plants")
    private List<PlantModel> plantModel;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "tbl_place_user",
            joinColumns = { @JoinColumn(name = "place_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
//    @JsonManagedReference("place_user")
    private List<UserModel> userModel;

    private String PlaceName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PlantModel> getPlantModel() {
        return plantModel;
    }

    public void setPlantModel(List<PlantModel> plantModel) {
        this.plantModel = plantModel;
    }

    public List<UserModel> getUserModel() {
        return userModel;
    }

    public void setUserModel(List<UserModel> userModel) {
        this.userModel = userModel;
    }

    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String placeName) {
        PlaceName = placeName;
    }
}
