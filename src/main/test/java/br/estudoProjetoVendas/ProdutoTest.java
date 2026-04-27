package main.test.java.br.estudoProjetoVendas;


import br.com.estudoProjetoVendas.dao.IProdutoDAO;
import br.com.estudoProjetoVendas.dao.ProdutoDAO;
import br.com.estudoProjetoVendas.domain.Produto;
import br.com.estudoProjetoVendas.service.IProdutoService;
import br.com.estudoProjetoVendas.service.ProdutoService;
import org.junit.Assert;
import org.junit.Test;



public class ProdutoTest {

    IProdutoService produtoService;

    public ProdutoTest(){
        IProdutoDAO dao = new ProdutoDAO();
        this.produtoService = new ProdutoService(dao);
    }

    @Test
    public void cadastrarProduto() throws Exception {
        Produto produto = new Produto("Camisa preta M","30.00",
                "Roupas");

        produtoService.salvar(produto);

        Produto produtoBuscado = produtoService.buscarPorId(produto.getId());

        Assert.assertEquals(produto,produtoBuscado);

    }
    @Test
    public void editarProduto() throws Exception {
        Produto produto = new Produto("Camisa preta M","30.00",
                "Roupas");

        produtoService.salvar(produto);
        Produto ProdutoSalvo = produtoService.buscarPorId(produto.getId());
        Assert.assertEquals(produto,ProdutoSalvo);

        produto.setDescricao("Camisa branca G");
        produto.setPreco("25.00");

        Produto produtoEditado = produtoService.editar(produto.getId(),produto);

        Produto produtoBuscado = produtoService.buscarPorId(produto.getId());
        Assert.assertNotEquals("Camisa preta M", produtoBuscado.getDescricao());
        Assert.assertEquals(produtoEditado,produtoBuscado);
    }


    @Test
    public void removerProduto() throws Exception {
        Produto produto = new Produto("Camisa preta M","30.00",
                "Roupas");

        produtoService.salvar(produto);
        Produto produtoSalvo = produtoService.buscarPorId(produto.getId());
        Assert.assertEquals(produto,produtoSalvo);

        produtoService.remover(produto.getId());
        Produto produtoBuscado = produtoService.buscarPorId(produto.getId());
        Assert.assertNull(produtoBuscado);
    }
}
