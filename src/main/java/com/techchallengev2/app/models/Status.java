package com.techchallengev2.app.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Status() {}

    public Status(String nome) {
        this.nome = nome;
    }
}
