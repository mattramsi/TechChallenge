package com.techchallengev2.app.services;

import com.techchallengev2.app.models.Pedido;
import com.techchallengev2.app.repositories.PedidoRepository;
import com.techchallengev2.app.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final StatusRepository statusRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, StatusRepository statusRepository) {
        this.pedidoRepository = pedidoRepository;
        this.statusRepository = statusRepository;
    }

    public Pedido checkout(Pedido pedido) {
        validateStatus(pedido.getStatusId()); // Validate status before saving
        // Logic to send pedido to the queue (Fake checkout)
        return pedidoRepository.save(pedido);
    }

    private void validateStatus(Long statusId) {
        if (statusId == null || !statusRepository.existsById(statusId)) {
            throw new IllegalArgumentException("O status ID fornecido não existe.");
        }
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}
