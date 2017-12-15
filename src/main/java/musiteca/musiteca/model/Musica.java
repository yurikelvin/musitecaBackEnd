package musiteca.musiteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Musica {

    @Id
    @GeneratedValue
    private String id;

    @Column
    private String usuario;
    @Column
    private String albumNome;
    @Column
    private String nomeArtist;
    @Column
    private String nome;
    @Column
    private String duracao;
    @Column
    private String ano;

    public String getAlbumNome() {
        return albumNome;
    }

    public void setAlbumNome(String albumNome) {
        this.albumNome = albumNome;
    }

    public String getNomeArtist() {
        return nomeArtist;
    }

    public void setNomeArtist(String nomeArtist) {
        this.nomeArtist = nomeArtist;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musica musica = (Musica) o;
        return Objects.equals(albumNome, musica.albumNome);
    }

    @Override
    public int hashCode() {

        return Objects.hash(albumNome);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
