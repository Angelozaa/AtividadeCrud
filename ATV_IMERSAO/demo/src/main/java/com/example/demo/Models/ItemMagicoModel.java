package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "ItemMagico")
public class ItemMagicoModel {

    @ManyToOne
    @JoinColumn(name = "personagem_id")
    @JsonBackReference
    private PersonagemModel personagem;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoItens tipo;

    private int forca;
    private int defesa;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoItens getTipo() { return tipo; }

    public void setTipo(TipoItens tipo) {
        this.tipo = tipo;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public PersonagemModel getPersonagem() { return personagem; }

    public void setPersonagem(PersonagemModel personagem) { this.personagem = personagem; }
}
