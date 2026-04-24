package main.java.br.com.estudoProjetoVendas.service;

import main.java.br.com.estudoProjetoVendas.dao.IProdutoDAO;
import main.java.br.com.estudoProjetoVendas.domain.Produto;

public class ProdutoService implements IProdutoService{

    IProdutoDAO produtoDAO;

    public ProdutoService(IProdutoDAO produtoDAO){
        this.produtoDAO = produtoDAO;
    }

    @Override
    public void salvar(Produto produto) {
        produtoDAO.salvar(produto);
    }

    @Override
    public Produto buscarPorId(Long id) {
        return produtoDAO.buscarPorId(id);
    }

    @Override
    public Produto editar(Long id, Produto produto) {
        return produtoDAO.editar(id,produto);
    }

    @Override
    public void remover(Long id) {
        produtoDAO.remover(id);
    }
}
