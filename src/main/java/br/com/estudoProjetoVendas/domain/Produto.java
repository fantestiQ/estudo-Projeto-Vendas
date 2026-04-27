package br.com.estudoProjetoVendas.domain;

import java.math.BigDecimal;

public class Produto {
    private String descricao;
    private BigDecimal preco;
    private String categoria;
    private Long id;

    public Produto(String descricao, String preco, String categoria) {
        this.descricao = descricao;
        this.preco = new BigDecimal(preco);
        this.categoria = categoria;
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = new BigDecimal(preco);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
