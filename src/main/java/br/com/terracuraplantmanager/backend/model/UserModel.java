package br.com.terracuraplantmanager.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

@Entity
@Table(name = "tbl_users")
public class UserModel {
    public static UserModel autenticar(String email, String password, EntityManager em) throws Exception {
        try {
            UserModel usuario = em.createNamedQuery("UserModel.findByEmail", UserModel.class)
                    .setParameter("email", email)
                    .getSingleResult();
            if (usuario.verifypassword(password)) {
                return usuario; // authentication successful
            } else {
                throw new Exception("Invalid password for user " + email);
            }
        } catch (NoResultException e) {
            throw new Exception("User " + email + " not found");
        }
    }
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

    private String email;
    private String password;
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
    public boolean verifypassword(String senha) {
        return BCrypt.checkpw(senha, this.password);
    }

}
