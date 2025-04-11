package com.example.demo.Controllers;

import com.example.demo.Models.PersonagemModel;
import com.example.demo.Services.PersonagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personagens")
@Tag(name = "Personagens", description = "Operações relacionadas aos personagens") // Tag geral do controller
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @Operation( summary = "Cria um novo personagem" )
    @PostMapping
    public ResponseEntity<PersonagemModel> criar(@RequestBody PersonagemModel personagem) {
        PersonagemModel novo = personagemService.criarPersonagem(personagem);
        return ResponseEntity.ok(novo);
    }

    @Operation( summary = "Lista todos os personagens" )
    @GetMapping
    public ResponseEntity<List<PersonagemModel>> listarTodos() {
        return ResponseEntity.ok(personagemService.listarTodos());
    }

    @Operation( summary = "Busca personagem por ID" )
    @GetMapping("/{id}")
    public ResponseEntity<PersonagemModel> buscarPorId(
            @Parameter(description = "ID do personagem") @PathVariable Long id) {
        return ResponseEntity.ok(personagemService.buscarPorId(id));
    }

    @Operation( summary = "Atualiza o nick do personagem" )
    @PutMapping("/{id}/nick")
    public ResponseEntity<PersonagemModel> atualizarNick(
            @Parameter(description = "ID do personagem") @PathVariable Long id,
            @RequestBody Map<String, String> json) {
        String nick = json.get("nick");
        return ResponseEntity.ok(personagemService.atualizarNick(id, nick));
    }

    @Operation( summary = "Remove um personagem" )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(
            @Parameter(description = "ID do personagem") @PathVariable Long id) {
        personagemService.removerPersonagem(id);
        return ResponseEntity.noContent().build();
    }

    @Operation( summary = "Exibe o status do personagem" )
    @GetMapping("/{id}/status")
    public ResponseEntity<String> status(
            @Parameter(description = "ID do personagem") @PathVariable Long id) {
        PersonagemModel p = personagemService.buscarPorId(id);
        int forca = p.getForcaTotal();
        int defesa = p.getDefesaTotal();
        return ResponseEntity.ok("Força Total: " + forca + " | Defesa Total: " + defesa);
    }
}

