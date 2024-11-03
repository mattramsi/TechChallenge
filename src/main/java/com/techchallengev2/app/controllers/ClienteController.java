package com.techchallengev2.app.controllers;

import com.techchallengev2.app.dto.CpfRequest;
import com.techchallengev2.app.models.Cliente;
import com.techchallengev2.app.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.cadastrarCliente(cliente));
    }

    @PostMapping("/buscarPorCpf")
    public ResponseEntity<Cliente> buscarPorCpf(@RequestBody CpfRequest cpfRequest) {
        return clienteService.buscarPorCpf(cpfRequest.getCpf())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}