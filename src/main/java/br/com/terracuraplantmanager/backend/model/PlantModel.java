package br.com.terracuraplantmanager.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_plants")
public class PlantModel {
    @Id
    @SequenceGenerator(name = "plant", sequenceName = "seq_plants", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plant")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference("user_plants")
    private UserModel userModel;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
