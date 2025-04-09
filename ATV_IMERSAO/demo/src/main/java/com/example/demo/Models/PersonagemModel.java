package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Personagem")
public class PersonagemModel {

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItemMagicoModel> itens = new ArrayList<>();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nick;

    @Enumerated(EnumType.STRING)
    private Classes classe;

    private int level;
    private int forca;
    private int defesa;


    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Classes getClasse() {
        return classe;
    }

    public void setClasse(Classes classe) {
        this.classe = classe;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public List<ItemMagicoModel> getItens() { return itens; }

    public void setItens(List<ItemMagicoModel> itens) { this.itens = itens; }

    public int getForcaTotal() {
        int somaItens = itens.stream().mapToInt(ItemMagicoModel::getForca).sum();
        return this.forca + somaItens;
    }

    public int getDefesaTotal() {
        int somaItens = itens.stream().mapToInt(ItemMagicoModel::getDefesa).sum();
        return this.defesa + somaItens;
    }
}
