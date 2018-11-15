package br.com.desafiocrud.domain.dto;

import br.com.desafiocrud.domain.User;

import java.io.Serializable;

public class UserUpdateResponseDTO implements Serializable {
    private Boolean status;
    private String msg;
    private String name;
    private String login;
    private String pass;

    public UserUpdateResponseDTO(User user) {
        if (user != null) {
            setStatus(true);
            setMsg("Usuário atualizado com sucesso.");
            setName(user.getName());
            setLogin(user.getLogin());
            setPass(user.getPass());
        } else {
            setMsg("Não foi possível atualizar o usuário.");
        }
    }

    public UserUpdateResponseDTO build() {
        return this;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
