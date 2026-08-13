package com.catbook.catbookbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Gato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Este é o ID automático do banco de dados MySQL

    private String catId; // ID original que vem da API do gatinho
    private String urlImagem; // O link da foto do gato
    private String nome; // Um nome que vai poder dar pro gatito

    // Construtor vazio (obrigatório para o Spring funcionar)
    public Gato() {
    }

    // Getters e Setters, pra Permitir que o Java acesse e modifique os dados

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}