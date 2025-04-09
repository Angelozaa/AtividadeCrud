package com.example.demo.Services;

import com.example.demo.Models.PersonagemModel;
import com.example.demo.Repositorys.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public PersonagemModel criarPersonagem(PersonagemModel personagem) {
        int totalPontos = personagem.getForca() + personagem.getDefesa();
        if (totalPontos != 10) {
            throw new IllegalArgumentException("A soma de força e defesa deve ser exatamente 10.");
        }
        return personagemRepository.save(personagem);
    }

    public List<PersonagemModel> listarTodos() {
        return personagemRepository.findAll();
    }

    public PersonagemModel buscarPorId(Long id) {
        return personagemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado com ID: " + id));
    }

    public PersonagemModel atualizarNick(Long id, String novoNick) {
        PersonagemModel personagem = buscarPorId(id);
        personagem.setNick(novoNick);
        return personagemRepository.save(personagem);
    }

    public void removerPersonagem(Long id) {
        if (!personagemRepository.existsById(id)) {
            throw new IllegalArgumentException("Personagem com ID " + id + " não encontrado.");
        }
        personagemRepository.deleteById(id);
    }

    public int calcularForcaTotal(Long id) {
        PersonagemModel personagem = buscarPorId(id);
        return personagem.getForcaTotal();
    }

    public int calcularDefesaTotal(Long id) {
        PersonagemModel personagem = buscarPorId(id);
        return personagem.getDefesaTotal();
    }
}
