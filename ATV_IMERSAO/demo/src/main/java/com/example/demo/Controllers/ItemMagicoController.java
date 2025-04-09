package com.example.demo.Controllers;

import com.example.demo.Models.ItemMagicoModel;
import com.example.demo.Services.ItemMagicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemMagicoController {

    @Autowired
    private ItemMagicoService itemMagicoService;

    @PostMapping("/personagem/{personagemId}")
    public ResponseEntity<ItemMagicoModel> criarItem(
            @PathVariable Long personagemId,
            @RequestBody ItemMagicoModel item) {

        ItemMagicoModel novo = itemMagicoService.criarItem(item, personagemId);
        return ResponseEntity.ok(novo);
    }

    @GetMapping
    public ResponseEntity<List<ItemMagicoModel>> listarTodos() {
        return ResponseEntity.ok(itemMagicoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemMagicoModel> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(itemMagicoService.buscarPorId(id));
    }

    @GetMapping("/personagem/{personagemId}")
    public ResponseEntity<List<ItemMagicoModel>> listarPorPersonagem(@PathVariable Long personagemId) {
        return ResponseEntity.ok(itemMagicoService.listarPorPersonagem(personagemId));
    }

    @GetMapping("/personagem/{personagemId}/amuleto")
    public ResponseEntity<ItemMagicoModel> buscarAmuleto(@PathVariable Long personagemId) {
        return ResponseEntity.ok(itemMagicoService.buscarAmuleto(personagemId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        itemMagicoService.removerItem(id);
        return ResponseEntity.noContent().build();
    }
}
