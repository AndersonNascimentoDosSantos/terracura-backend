package br.com.terracuraplantmanager.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_users")
public class UserModel {
    @Id
    @SequenceGenerator(name = "user", sequenceName = "seq_users", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user")
    private Long id;
    @ManyToMany(mappedBy = "userModel")
    @JsonBackReference("user_plants")
    private List<PlantModel> plantModel;
    @ManyToMany(mappedBy = "userModel")
    @JsonBackReference("place_plants")
    private List<PlaceModel> placeModel;


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

    public List<PlaceModel> getPlaceModel() {
        return placeModel;
    }

    public void setPlaceModel(List<PlaceModel> placeModel) {
        this.placeModel = placeModel;
    }
}
