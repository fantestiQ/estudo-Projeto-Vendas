package main.java.br.com.estudoProjetoVendas.dao;

import main.java.br.com.estudoProjetoVendas.SingletonMap;
import main.java.br.com.estudoProjetoVendas.domain.Produto;

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
}
