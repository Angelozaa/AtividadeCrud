package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Personagem")
public class PersonagemModel {

    @Id
    private int id;
    public String name;
    public String nick;
    public String classe; // somente (Guerreiro, Mago, Arqueiro, Ladino ou Bardo)
    public int level;
    //list itensMagicos;
    public int forca;
    // quando criar personagem ele tera 10 pontos para distribuir entre forca e defesa
    // os valores serao apresentados nas infos do personagem e ira somar a forca e defesa dos itens do personagem em exibição
    public int defesa;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
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
}
