package spring.api.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.api.rest.DTO.RequestUsuario;
import spring.api.rest.model.Usuario;
import spring.api.rest.repository.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Usuario> init(@PathVariable(value = "id") Long id) throws Exception {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
        return ResponseEntity.ok(usuario);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Usuario>> listaUsuarios(){
        List<Usuario> usuarios = repository.findAll();
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Usuario> criar(@RequestBody Usuario request){

        RequestUsuario usuario = new RequestUsuario();
        usuario.setLogin("oseais@pdcase.com.br");
        usuario.setNome("Oeias");
        usuario.setSenha("123456");

        return  null;
    }

}
