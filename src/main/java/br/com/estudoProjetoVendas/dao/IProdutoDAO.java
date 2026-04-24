package main.java.br.com.estudoProjetoVendas.dao;

import main.java.br.com.estudoProjetoVendas.domain.Produto;

public interface IProdutoDAO {

    void salvar(Produto produto);
    Produto buscarPorId(Long id);
    Produto editar(Long id, Produto produto);
    void remover(Long id);
}
