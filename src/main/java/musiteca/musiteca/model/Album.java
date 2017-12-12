package musiteca.musiteca.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Album {

    @Id
    private String nome;
    @Column
    private String imagem;
    @Column
    private String ano;
    @Column
    private String artistaNome;
    @OneToMany(cascade= CascadeType.ALL)
    private Set<Musica> musicas;

    public Album() {
        this.musicas = new HashSet<Musica>();
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getArtistaNome() {
        return artistaNome;
    }

    public void setArtistaNome(String artistaNome) {
        this.artistaNome = artistaNome;
    }

    public Set<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(Set<Musica> musicas) {
        this.musicas = musicas;
    }


}
