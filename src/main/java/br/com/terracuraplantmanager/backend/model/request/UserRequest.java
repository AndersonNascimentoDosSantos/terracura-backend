package br.com.terracuraplantmanager.backend.model.request;


import java.io.Serializable;
import java.util.List;

import br.com.terracuraplantmanager.backend.model.exception.ResourceNotFoundException;
import org.mindrot.jbcrypt.BCrypt;


import jakarta.persistence.EntityManager;

public class UserRequest {

    private String name;

    private String email;

    private String password;


    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setSenha(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean verificaSenha(String password) {
        return BCrypt.checkpw(password, this.password
        );
    }

    public static UserRequest autenticar(String email, String password,
                                         EntityManager em) throws Exception {
        try {
            UserRequest usuario = em.createNamedQuery("UserModel.findByEmail",
                            UserRequest.class)
                    .setParameter("email", email)
                    .getSingleResult();
            if (usuario.verificaSenha(password)) {
                return usuario; // authentication successful
            } else {
                throw new Exception("Invalid password for user " + email);
            }
        } catch (Exception e) {
            throw new ResourceNotFoundException("User " + email + " not found");
        }
    }

}

