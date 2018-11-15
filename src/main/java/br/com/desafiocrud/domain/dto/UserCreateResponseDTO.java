package br.com.desafiocrud.domain.dto;


import br.com.desafiocrud.domain.User;

import java.io.Serializable;

public class UserCreateResponseDTO implements Serializable {
    private Boolean status;
    private String msg;
    private Long id;

    public UserCreateResponseDTO() {}

    public UserCreateResponseDTO (User user) {
        if (user.getId() != null) {
            setStatus(true);
            setMsg("Usuário cadastrado com sucesso.");
            setId(user.getId());
        } else {
            setMsg("Não foi possível cadastrar o usuário.");
        }
    }

    public UserCreateResponseDTO build() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
