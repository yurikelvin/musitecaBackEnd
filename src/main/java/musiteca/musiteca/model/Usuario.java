package musiteca.musiteca.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Entity
public class Usuario {

    @Id
    @Column
    private String nome;
    @Column
    private String senha;
    @OneToMany(cascade= CascadeType.ALL)
    private Set<Artista> artistas;

    public Usuario() {
        this.artistas = new HashSet<Artista>();
    }

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

    public Set<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(Set<Artista> artistas) {
        this.artistas = artistas;
    }

}
