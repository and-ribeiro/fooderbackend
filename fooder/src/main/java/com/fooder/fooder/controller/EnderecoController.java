package com.fooder.fooder.controller;

import com.fooder.fooder.model.Endereco;
import com.fooder.fooder.service.EnderecoService;
import com.fooder.fooder.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> salvar(@RequestBody Endereco endereco){
        return ResponseEntity.ok(enderecoService.salvarEndereco(endereco));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(enderecoService.buscarEnderecoPorId(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> buscarTodos(){
        return ResponseEntity.ok(enderecoService.buscarTodosOsEndereco());
    }

    @PutMapping
    public ResponseEntity<Endereco> atualizar(@RequestBody Endereco endereco){
        ResponseEntity<Endereco> response = null;
        if (endereco.getId() != null && enderecoService.buscarEnderecoPorId(endereco.getId()).isPresent()){
            response = ResponseEntity.ok(enderecoService.atualizarEndereco(endereco));
        }
        else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        if(enderecoService.buscarEnderecoPorId(id).isPresent()){
            enderecoService.excluirEndereco(id);
        }
        else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
