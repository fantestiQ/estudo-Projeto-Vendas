package main.test.java.br.com.estudoProjetoVendas;

import main.java.br.com.estudoProjetoVendas.dao.ClienteDAO;
import main.java.br.com.estudoProjetoVendas.dao.IClienteDAO;
import main.java.br.com.estudoProjetoVendas.service.ClienteService;
import main.java.br.com.estudoProjetoVendas.service.IClienteService;
import main.java.br.com.estudoProjetoVendas.domain.Cliente;
import main.test.java.br.com.estudoProjetoVendas.dao.ClienteDAOMock;
import org.junit.Assert;
import org.junit.Test;


public class ClienteTest {

    IClienteService clienteService;

   public ClienteTest(){
       IClienteDAO clienteDao = new ClienteDAO();
        this.clienteService = new ClienteService(clienteDao);
    }

    @Test
    public void pesquisarCliente(){
        Cliente cliente = new Cliente("João Silva",
                "12345678901",
                "11999998888",
                "Rua das Flores",
                "123",
                "São Paulo",
                "SP"  );

        clienteService.salvar(cliente);

        Cliente clienteBuscado = clienteService.buscarClientePorCPF(cliente.getCpf());

        Assert.assertNotNull(clienteBuscado);
    }
    @Test
    public void salvarCliente() {
        Cliente cliente = new Cliente("João Silva",
                "12345678901",
                "11999998888",
                "Rua das Flores",
                "123",
                "São Paulo",
                "SP");

        clienteService.salvar(cliente);
        Cliente clienteBuscado = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertEquals(cliente,clienteBuscado);
    }
    @Test
    public void editarCliente() {
        Cliente cliente = new Cliente("João Silva",
                "12345678901",
                "11999998888",
                "Rua das Flores",
                "123",
                "São Paulo",
                "SP");

        clienteService.salvar(cliente);
        Cliente clienteSalvo = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertEquals(cliente,clienteSalvo);

        cliente.setNome("Isac dos Santos");
        cliente.setTel(11977777222L);

        Cliente clienteEditado = clienteService.editar(cliente.getCpf(),cliente);

        Cliente clienteBuscado = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertNotEquals("João Silva", clienteBuscado.getNome());
        Assert.assertEquals(clienteEditado,clienteBuscado);
    }


    @Test
    public void removerCliente() {
        Cliente cliente = new Cliente("João Silva",
                "12345678901",
                "11999998888",
                "Rua das Flores",
                "123",
                "São Paulo",
                "SP");

        clienteService.salvar(cliente);
        Cliente clienteSalvo = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertEquals(cliente,clienteSalvo);

        clienteService.remover(cliente.getCpf());
        Cliente clienteBuscado = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertNull(clienteBuscado);
    }
}
