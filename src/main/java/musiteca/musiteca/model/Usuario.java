package musiteca.musiteca.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Usuario {

    @Id
    private String nome;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
