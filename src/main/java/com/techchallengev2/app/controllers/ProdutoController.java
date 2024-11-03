package com.techchallengev2.app.controllers;

import com.techchallengev2.app.dto.ProdutoDTO;
import com.techchallengev2.app.models.Produto;
import com.techchallengev2.app.models.Categoria;
import com.techchallengev2.app.services.CategoriaService;
import com.techchallengev2.app.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;

    @Autowired
    public ProdutoController(ProdutoService produtoService, CategoriaService categoriaService) {
        this.produtoService = produtoService;
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.criarProduto(produto));
    }

    @PostMapping("/buscar")
    public ResponseEntity<Produto> buscarProdutoPorId(@RequestBody Map<String, Long> requestBody) {
        Long id = requestBody.get("id");
        Optional<Produto> produto = produtoService.buscarPorId(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/categoria")
    public ResponseEntity<List<ProdutoDTO>> buscarPorCategoria(@RequestBody Map<String, Long> requestBody) {
        Long categoriaId = requestBody.get("id");
        List<Produto> produtos = produtoService.buscarPorCategoria(categoriaId);

        // Converter Produto para ProdutoDTO
        List<ProdutoDTO> produtoDTOs = produtos.stream()
                .map(produto -> {
                    Categoria categoria = categoriaService.buscarPorId(produto.getCategoriaId()).orElse(null);
                    return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getPreco(), categoria);
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(produtoDTOs);
    }

    @PutMapping("/editar")
    public ResponseEntity<Produto> editarProduto(@RequestBody Produto produtoAtualizado) {
        Long id = produtoAtualizado.getId();
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Produto> produtoExistente = produtoService.buscarPorId(id);
        if (produtoExistente.isPresent()) {
            Produto produtoSalvo = produtoService.editarProduto(produtoAtualizado);
            return ResponseEntity.ok(produtoSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/remover")
    public ResponseEntity<Void> removerProduto(@RequestBody Map<String, Long> requestBody) {
        Long id = requestBody.get("id");
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        if (produtoService.buscarPorId(id).isPresent()) {
            produtoService.removerProduto(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}