package musiteca.musiteca.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Playlist {

    @Id
    @Column(unique = true)
    private String nome;
    @Column
    private String imagem;
    @Column
    private String descricao;
    @Column
    private String data;
    @ManyToMany(cascade = CascadeType.REFRESH)
    private Set<Musica> musicas;

    public Playlist() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Set<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(Set<Musica> musicas) {
        this.musicas = musicas;
    }
}
