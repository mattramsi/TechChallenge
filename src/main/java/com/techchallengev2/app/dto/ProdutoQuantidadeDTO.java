package com.techchallengev2.app.dto;
import lombok.Data;
@Data
public class ProdutoQuantidadeDTO {
    private Long produtoId;
    private Integer quantidade = 1;
    private Double valor;
}