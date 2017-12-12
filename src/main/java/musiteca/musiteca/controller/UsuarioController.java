package musiteca.musiteca.controller;

import musiteca.musiteca.model.Usuario;
import musiteca.musiteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/usuario")
public class UsuarioController implements CrudController<Usuario>{

    @Autowired
    private UsuarioService usuarioService;

    @Override
    @RequestMapping(method= RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.cadastrar(usuario), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Usuario> get(String id, Usuario usuario) {
        return null;
    }

    @Override
    public ResponseEntity<Usuario> modificar(Usuario usuario) {
        return null;
    }

    @Override
    @RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Usuario>> getAll() {
        return new ResponseEntity<>(usuarioService.buscaUsuarios(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deletar(String t) {
        return null;
    }
}
