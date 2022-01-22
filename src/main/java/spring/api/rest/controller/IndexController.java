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
@RequestMapping(value = "/api/v1")
public class IndexController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping(value = "/usuario/{id}", produces = "application/json")
    public ResponseEntity<Usuario> init(@PathVariable(value = "id") Long id) throws Exception {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
        return ResponseEntity.ok(usuario);
    }

    @GetMapping(value = "/usuarios", produces = "application/json")
    public ResponseEntity<List<Usuario>> listaUsuarios(){
        List<Usuario> usuarios = repository.findAll();
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Usuario> criar(@RequestBody Usuario request){

        Usuario usuario = repository.save(request);

        return new ResponseEntity(usuario, HttpStatus.CREATED);
    }

}
