package com.techchallengev2.app.models;

import com.techchallengev2.app.repositories.StatusRepository;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_id")
    private Long clienteId;

    @ManyToMany
    @JoinTable(
            name = "pedidos_produtos",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    private Double total;

    @Column(name = "status_id")
    private Long statusId = 1L;

    @Column(name = "tempo_inicio", updatable = false)
    private LocalDateTime tempoInicio;

    @Column(name = "tempo_fim")
    private LocalDateTime tempoFim;

    @PrePersist
    private void prePersist() {
        this.tempoInicio = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        if (this.statusId != null && this.statusId == 4) {
            this.tempoFim = LocalDateTime.now();
        }
    }
}
