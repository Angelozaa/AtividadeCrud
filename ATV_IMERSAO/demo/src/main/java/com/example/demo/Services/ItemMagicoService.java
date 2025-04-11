package com.example.demo.Services;

import com.example.demo.Models.ItemMagicoModel;
import com.example.demo.Models.PersonagemModel;
import com.example.demo.Repositorys.ItemMagicoRepository;
import com.example.demo.Repositorys.PersonagemRepository;
import com.example.demo.Models.TipoItens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemMagicoService {

    @Autowired
    private ItemMagicoRepository itemMagicoRepository;

    @Autowired
    private PersonagemRepository personagemRepository;

    public ItemMagicoModel criarItem(ItemMagicoModel item, Long personagemId) {
        validarItem(item);

        PersonagemModel personagem = personagemRepository.findById(personagemId)
                .orElseThrow(() -> new IllegalArgumentException("Personagem com ID " + personagemId + " não encontrado."));

        if (item.getTipo() == TipoItens.AMULETO) {
            boolean jaTemAmuleto = personagem.getItens().stream()
                    .anyMatch(i -> i.getTipo() == TipoItens.AMULETO);
            if (jaTemAmuleto) {
                throw new IllegalArgumentException("Personagem já possui um amuleto.");
            }
        }

        item.setPersonagem(personagem);
        return itemMagicoRepository.save(item);
    }

    public List<ItemMagicoModel> listarTodos() {
        return itemMagicoRepository.findAll();
    }

    public ItemMagicoModel buscarPorId(Long id) {
        return itemMagicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado com ID: " + id));
    }

    public List<ItemMagicoModel> listarPorPersonagem(Long personagemId) {
        PersonagemModel personagem = personagemRepository.findById(personagemId)
                .orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado."));
        return personagem.getItens();
    }

    public ItemMagicoModel buscarAmuleto(Long personagemId) {
        return listarPorPersonagem(personagemId).stream()
                .filter(item -> item.getTipo() == TipoItens.AMULETO)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Personagem não possui amuleto."));
    }

    public void removerItem(Long id) {
        if (!itemMagicoRepository.existsById(id)) {
            throw new IllegalArgumentException("Item não encontrado.");
        }
        itemMagicoRepository.deleteById(id);
    }

    private void validarItem(ItemMagicoModel item) {
        if (item.getForca() == 0 && item.getDefesa() == 0) {
            throw new IllegalArgumentException("Item precisa ter pelo menos força ou defesa.");
        }

        if (item.getForca() > 10 || item.getDefesa() > 10) {
            throw new IllegalArgumentException("Força e Defesa devem ser no máximo 10.");
        }

        if (item.getTipo() == TipoItens.ARMA && item.getDefesa() != 0) {
            throw new IllegalArgumentException("Armas devem ter defesa igual a 0.");
        }

        if (item.getTipo() == TipoItens.ARMADURA && item.getForca() != 0) {
            throw new IllegalArgumentException("Armaduras devem ter força igual a 0.");
        }
    }
}
