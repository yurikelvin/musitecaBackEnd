package musiteca.musiteca.service;

import musiteca.musiteca.model.Usuario;
import musiteca.musiteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrar(Usuario usuario) {
        Usuario newUser = new Usuario();
        newUser.setNome("teste");
        usuarioRepository.save(newUser);
        System.out.println(usuarioRepository.findOne("teste").getNome());
       return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorNome(String nome) {
        return usuarioRepository.buscarPorNome(nome);
    }

    public Collection<Usuario> buscaUsuarios() {
        return usuarioRepository.findAll();
    }
}
