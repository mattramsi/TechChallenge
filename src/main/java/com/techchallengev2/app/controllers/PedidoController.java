package com.techchallengev2.app.controllers;

import com.techchallengev2.app.exceptions.ResourceNotFoundException;
import com.techchallengev2.app.dto.PedidoDTO;
import com.techchallengev2.app.models.Pedido;
import com.techchallengev2.app.models.Produto;
import com.techchallengev2.app.services.PedidoService;
import com.techchallengev2.app.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    private final ProdutoService produtoService;

    @Autowired
    public PedidoController(PedidoService pedidoService, ProdutoService produtoService) {
        this.pedidoService = pedidoService;
        this.produtoService = produtoService;
    }
    @PostMapping("/checkout")
    public ResponseEntity<Pedido> checkout(@RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setClienteId(pedidoDTO.getClienteId());
        pedido.setTotal(pedidoDTO.getTotal());

        List<Produto> produtos = pedidoDTO.getProdutos().stream()
                .map(dto -> {
                    Optional<Produto> optionalProduto = produtoService.buscarPorId(dto.getProdutoId());

                    Produto produto = optionalProduto.orElseThrow(() ->
                            new ResourceNotFoundException("Produto não encontrado: " + dto.getProdutoId())
                    );

                    return produto;
                })
                .collect(Collectors.toList());

        pedido.setProdutos(produtos);
        return ResponseEntity.ok(pedidoService.checkout(pedido));
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }
}