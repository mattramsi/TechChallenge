package com.techchallengev2.app.services;

import com.techchallengev2.app.models.Categoria;
import com.techchallengev2.app.models.Produto;
import com.techchallengev2.app.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto editarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void removerProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> buscarPorCategoria(Long id) {
        return produtoRepository.findByCategoriaId(id);
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }
}
