package br.com.desafiocrud.domain.dto;

import br.com.desafiocrud.domain.User;

import java.io.Serializable;

public class UserDeleteResponseDTO implements Serializable {
    private Boolean status;
    private String msg;

    public UserDeleteResponseDTO(User user) {
        if (user != null) {
            setStatus(true);
            setMsg("Usuário " + user.getName() + " deletado com sucesso.");
        } else {
            setMsg("Não foi possível deletar o usuário.");
        }
    }
    public UserDeleteResponseDTO build() {
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
}
