package musiteca.musiteca.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Artista {

    @Id
    @Column
    private String nome;
    @Column
    private String imagem;
    @Column
    private String ultimaOuvida;
    @Column
    private boolean favorito;
    @Column
    private boolean selecionado;
    @OneToMany(cascade= CascadeType.ALL)
    private Set<Album> albuns;

    public Artista() {
        this.albuns = new HashSet<Album>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getUltimaOuvida() {
        return ultimaOuvida;
    }

    public void setUltimaOuvida(String ultimaOuvida) {
        this.ultimaOuvida = ultimaOuvida;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public Set<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(Set<Album> albuns) {
        this.albuns = albuns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return Objects.equals(nome, artista.nome);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nome);
    }
}
