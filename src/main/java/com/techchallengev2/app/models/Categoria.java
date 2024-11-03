package com.techchallengev2.app.models;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Table
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Long id;

    private String nome;

    public Categoria() {}

    public Categoria(String nome) {
        this.nome = nome;
    }
}