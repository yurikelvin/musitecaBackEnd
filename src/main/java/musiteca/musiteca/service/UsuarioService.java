package musiteca.musiteca.service;

import musiteca.musiteca.model.*;
import musiteca.musiteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService implements CrudService<Usuario>{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        Usuario usuarioAtualizado = null;
        if(usuarioRepository.exists(usuario.getNome())) {
            usuarioAtualizado = usuarioRepository.save(usuario);
        }
        return usuarioAtualizado;
    }

    @Override
    public Collection<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getByName(String name) {
        Usuario usuarioAchado = null;
        if(usuarioRepository.exists(name)) {
            usuarioAchado = usuarioRepository.getOne(name);
        }
        return usuarioAchado;
    }

    @Override
    public void removeByName(String name) {
        if(usuarioRepository.exists(name)) {
            usuarioRepository.delete(name);
        }
    }

    @Override
    public void removeAll() {
        if(usuarioRepository.count() > 0) {
            usuarioRepository.deleteAll();
        }
    }

    public Collection<Artista> getArtistas(String name) {
        Usuario usuarioProcurado = usuarioRepository.getOne(name);
        return usuarioProcurado.getArtistas();
    }

    public Collection<Artista> getFavoritos(String name) {
        Usuario usuarioProcurado = usuarioRepository.getOne(name);
        return usuarioProcurado.getFavoritos();
    }

    public Collection<Playlist> getPlaylists(String name) {
        Usuario usuarioProcurado = usuarioRepository.getOne(name);
        return usuarioProcurado.getPlaylists();
    }

    public Collection<Album> getAlbuns(String name) {
        Collection<Artista> artistasProcurados = this.getArtistas(name);

        Collection<Album> albuns = new HashSet<Album>();
        Iterator<Artista> iterator = artistasProcurados.iterator();
        while(iterator.hasNext()) {
            Artista artistaDaVez = iterator.next();
            Iterator<Album> albumIterator = artistaDaVez.getAlbuns().iterator();
            while(albumIterator.hasNext()) {
                Album next = albumIterator.next();
                albuns.add(next);
            }
        }

        return albuns;
    }

    public Collection<Musica> getMusicas(String name) {
        Collection<Album> albunsProcurados = this.getAlbuns(name);

        Collection<Musica> musicas = new HashSet<Musica>();
        Iterator<Album> albumIterator = albunsProcurados.iterator();
        while(albumIterator.hasNext()) {
            Album albumDaVez = albumIterator.next();
            Iterator<Musica> musicaIterator = albumDaVez.getMusicas().iterator();
            while(musicaIterator.hasNext()) {
                Musica next = musicaIterator.next();
                musicas.add(next);
            }

        }
        return musicas;
    }
}
