package com.techchallengev2.app.repositories;

import com.techchallengev2.app.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}