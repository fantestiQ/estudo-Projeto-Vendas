package br.com.estudoProjetoVendas.service;


import br.com.estudoProjetoVendas.dao.IProdutoDAO;
import br.com.estudoProjetoVendas.domain.Produto;

import java.util.List;


public class ProdutoService implements IProdutoService {

    IProdutoDAO produtoDAO;

    public ProdutoService(IProdutoDAO produtoDAO){
        this.produtoDAO = produtoDAO;
    }

    @Override
    public void salvar(Produto produto) throws Exception {
        produtoDAO.salvar(produto);
    }

    @Override
    public Produto buscarPorId(Long id) throws Exception {
        return produtoDAO.buscarPorId(id);
    }

    @Override
    public Produto editar(Long id, Produto produto) throws Exception {
        return produtoDAO.editar(id,produto);
    }

    @Override
    public void remover(Long id) throws Exception {
        produtoDAO.remover(id);
    }

    @Override
    public List<Produto> listarTodos() {
        return List.of();
    }
}
