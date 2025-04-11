package com.example.demo.Controllers;

import com.example.demo.Models.ItemMagicoModel;
import com.example.demo.Services.ItemMagicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
@Tag(name = "Itens Mágicos", description = "Operações relacionadas a itens mágicos dos personagens")
public class ItemMagicoController {

    @Autowired
    private ItemMagicoService itemMagicoService;

    @Operation( summary = "Cria um novo item mágico" )
    @PostMapping("/personagem/{personagemId}")
    public ResponseEntity<ItemMagicoModel> criarItem(
            @Parameter(description = "ID do personagem que receberá o item") @PathVariable Long personagemId,
            @RequestBody ItemMagicoModel item) {

        ItemMagicoModel novo = itemMagicoService.criarItem(item, personagemId);
        return ResponseEntity.ok(novo);
    }

    @Operation( summary = "Lista todos os itens mágicos" )
    @GetMapping
    public ResponseEntity<List<ItemMagicoModel>> listarTodos() {
        return ResponseEntity.ok(itemMagicoService.listarTodos());
    }

    @Operation( summary = "Busca item mágico por ID" )
    @GetMapping("/{id}")
    public ResponseEntity<ItemMagicoModel> buscarPorId(
            @Parameter(description = "ID do item mágico") @PathVariable Long id) {
        return ResponseEntity.ok(itemMagicoService.buscarPorId(id));
    }

    @Operation( summary = "Lista os itens mágicos de um personagem" )
    @GetMapping("/personagem/{personagemId}")
    public ResponseEntity<List<ItemMagicoModel>> listarPorPersonagem(
            @Parameter(description = "ID do personagem") @PathVariable Long personagemId) {
        return ResponseEntity.ok(itemMagicoService.listarPorPersonagem(personagemId));
    }

    @Operation( summary = "Busca o amuleto do personagem" )
    @GetMapping("/personagem/{personagemId}/amuleto")
    public ResponseEntity<ItemMagicoModel> buscarAmuleto(
            @Parameter(description = "ID do personagem") @PathVariable Long personagemId) {
        return ResponseEntity.ok(itemMagicoService.buscarAmuleto(personagemId));
    }

    @Operation( summary = "Remove um item mágico" )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(
            @Parameter(description = "ID do item mágico a ser removido") @PathVariable Long id) {
        itemMagicoService.removerItem(id);
        return ResponseEntity.noContent().build();
    }
}

