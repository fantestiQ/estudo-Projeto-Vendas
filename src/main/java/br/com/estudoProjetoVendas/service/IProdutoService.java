package main.java.br.com.estudoProjetoVendas.service;

import main.java.br.com.estudoProjetoVendas.domain.Produto;

public interface IProdutoService {
    
    void salvar(Produto produto);

    Produto buscarPorId(Long id);

    Produto editar(Long id, Produto produto);

    void remover(Long id);
}
