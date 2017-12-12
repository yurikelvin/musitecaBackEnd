package musiteca.musiteca.controller;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import musiteca.musiteca.model.Usuario;
import musiteca.musiteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.Date;

@RestController
public class LoginController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value="/autenticar", consumes= MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.POST)
    public LoginResponse autenticar(@RequestBody Usuario usuario) throws ServletException {

        if(usuario.getNome() == null || usuario.getSenha() == null) {
            throw new ServletException("Nome e senha precisam ser obrigatórios.");
        }

        Usuario usuAutenticado = usuarioService.getByName(usuario.getNome());

        if(usuAutenticado == null || !usuario.getSenha().equals(usuAutenticado.getSenha())) {
            throw new ServletException("Usuário ou senha inválido.");
        }
        Integer HORAS = 3600 * 1000;
        String token = Jwts.builder()
                .setSubject(usuario.getNome())
                .signWith(SignatureAlgorithm.HS512,"banana")
                .setExpiration(new Date(System.currentTimeMillis() + 3 * HORAS))
                .compact();

        return new LoginResponse(token);
    }

    private class LoginResponse {
        String token;

        public LoginResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

    }
}
