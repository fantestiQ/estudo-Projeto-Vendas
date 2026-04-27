package br.com.estudoProjetoVendas.service;


import br.com.estudoProjetoVendas.domain.Produto;

import java.util.List;

public interface IProdutoService {
    
    void salvar(Produto produto) throws Exception;

    Produto buscarPorId(Long id) throws Exception;

    Produto editar(Long id, Produto produto) throws Exception;

    void remover(Long id) throws Exception;

    List<Produto> listarTodos();
}
