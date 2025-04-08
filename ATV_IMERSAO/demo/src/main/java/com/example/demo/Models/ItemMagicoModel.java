package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ItemMagico")
public class ItemMagicoModel {
    @Id
    private int id;
    public String nome;
    public String tipo; //ARMA(0 defedsa) ARMADURA(0 dano) e AMULETO(apenas um por personagem)
    public int forca;//max 10
    //nao podem existir itens com forca e defesa 0
    public int defesa;//max 10


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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
}
