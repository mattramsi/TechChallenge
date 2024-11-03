package com.techchallengev2.app;

import com.techchallengev2.app.models.Cliente;
import com.techchallengev2.app.repositories.ClienteRepository;
import com.techchallengev2.app.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCadastrarCliente() {
        Cliente cliente = new Cliente();
        cliente.setCpf("12345678900");
        cliente.setNome("João");
        cliente.setEmail("joao@example.com");

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = clienteService.cadastrarCliente(cliente);

        assertNotNull(result);
        assertEquals("12345678900", result.getCpf());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void testBuscarPorCpf() {
        String cpf = "12345678900";
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setNome("João");

        when(clienteRepository.findByCpf(cpf)).thenReturn(Optional.of(cliente));

        Optional<Cliente> result = clienteService.buscarPorCpf(cpf);

        assertTrue(result.isPresent());
        assertEquals("João", result.get().getNome());
        verify(clienteRepository, times(1)).findByCpf(cpf);
    }
}

