package br.com.estudoProjetoVendas.dao;

import br.com.estudoProjetoVendas.SingletonMap;
import br.com.estudoProjetoVendas.dao.IProdutoDAO;
import br.com.estudoProjetoVendas.domain.Produto;


import java.util.List;
import java.util.Map;

public class ProdutoDAO implements IProdutoDAO {

    @Override
    public void salvar(Produto produto) {
        SingletonMap.put(Produto.class,produto.getId(),produto);
    }

    @Override
    public Produto buscarPorId(Long id) {
        return SingletonMap.get(Produto.class,id);
    }

    @Override
    public Produto editar(Long id, Produto produto) {
        return SingletonMap.editar(Produto.class,produto.getId(),produto);
    }

    @Override
    public void remover(Long id) {
        SingletonMap.remove(Produto.class,id);
    }

    @Override
    public List<Produto> listarTodos() {
        return List.of();
    }
}
