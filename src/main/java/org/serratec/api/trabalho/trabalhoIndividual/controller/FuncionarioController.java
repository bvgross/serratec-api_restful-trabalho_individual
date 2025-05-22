package org.serratec.api.trabalho.trabalhoIndividual.controller;

import jakarta.validation.Valid;
import org.serratec.api.trabalho.trabalhoIndividual.domain.Funcionario;
import org.serratec.api.trabalho.trabalhoIndividual.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> listar() {
        return ResponseEntity.ok(funcionarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> listarFuncionario(@PathVariable Long id) {
        Funcionario f = funcionarioService.listarUm(id);
        if (f != null) {
            return ResponseEntity.ok(f);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Funcionario> inserir(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(funcionario.getId())
            .toUri();
        return ResponseEntity.created(uri).body(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> editarFuncionario(@PathVariable Long id,@Valid @RequestBody Funcionario funcionario) {
        Funcionario f = funcionarioService.editar(id, funcionario);
        if (f != null) {
            return ResponseEntity.ok(f);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        boolean deletado = funcionarioService.deletar(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
