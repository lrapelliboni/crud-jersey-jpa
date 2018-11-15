package br.com.desafiocrud.domain.dto;

import br.com.desafiocrud.domain.User;

import java.io.Serializable;

public class UserGetResponseDTO implements Serializable {
    private Long id;
    private String name;
    private String login;
    private String pass;

    public UserGetResponseDTO(User user) {
        if (user != null) {
            setId(user.getId());
            setName(user.getName());
            setLogin(user.getLogin());
            setPass(user.getPass());
        }
    }

    public UserGetResponseDTO build() {
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
