package br.com.terracuraplantmanager.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_users")
public class UserModel {
    @Id
    @SequenceGenerator(name = "user", sequenceName = "seq_users", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user")
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
