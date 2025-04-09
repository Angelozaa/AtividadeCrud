package com.example.demo.Controllers;

import com.example.demo.Models.PersonagemModel;
import com.example.demo.Services.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @PostMapping
    public ResponseEntity<PersonagemModel> criar(@RequestBody PersonagemModel personagem) {
        PersonagemModel novo = personagemService.criarPersonagem(personagem);
        return ResponseEntity.ok(novo);
    }

    @GetMapping
    public ResponseEntity<List<PersonagemModel>> listarTodos() {
        return ResponseEntity.ok(personagemService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemModel> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(personagemService.buscarPorId(id));
    }

    @PutMapping("/{id}/nick")
    public ResponseEntity<PersonagemModel> atualizarNick(
            @PathVariable Long id,
            @RequestBody Map<String, String> json) {
        String nick = json.get("nick");
        return ResponseEntity.ok(personagemService.atualizarNick(id, nick));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        personagemService.removerPersonagem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<String> status(@PathVariable Long id) {
        PersonagemModel p = personagemService.buscarPorId(id);
        int forca = p.getForcaTotal();
        int defesa = p.getDefesaTotal();
        return ResponseEntity.ok("Força Total: " + forca + " | Defesa Total: " + defesa);
    }
}
