package musiteca.musiteca.model;

import musiteca.musiteca.model.enums.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Usuario {

    @Id
    @Column
    private String login;
    @Column
    private String nome;
    @Column
    private String senha;
    @Column
    @Enumerated
    private Role role;

    @OneToMany(cascade= CascadeType.ALL)
    private Set<Artista> artistas;
    @OneToMany(cascade= CascadeType.ALL)
    private Set<Playlist> playlists;
    @OneToMany
    private Set<Artista> favoritos;

    public Usuario() {
        this.artistas = new HashSet<Artista>();
        this.playlists = new HashSet<Playlist>();
        this.favoritos = new HashSet<Artista>();
        this.role = Role.USER;
    }

    public String getNome() {
        return nome;
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

    public String getLogin() {
        return login;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }

    public Set<Artista> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Set<Artista> favoritos) {
        this.favoritos = favoritos;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(String role) {
        Role permission = null;
        switch(role) {
            case "USER":
                permission = Role.USER;
                break;
            case "ADMIN":
                permission = Role.ADMIN;
        }
        this.role = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(login, usuario.login);
    }

    @Override
    public int hashCode() {

        return Objects.hash(login);
    }
}
