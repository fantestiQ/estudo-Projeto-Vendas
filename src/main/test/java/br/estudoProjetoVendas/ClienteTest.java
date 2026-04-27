package main.test.java.br.estudoProjetoVendas;


import br.com.estudoProjetoVendas.dao.ClienteDAO;
import br.com.estudoProjetoVendas.dao.IClienteDAO;
import br.com.estudoProjetoVendas.domain.Cliente;
import br.com.estudoProjetoVendas.service.ClienteService;
import br.com.estudoProjetoVendas.service.IClienteService;

import org.junit.Assert;
import org.junit.Test;


public class ClienteTest {

    IClienteService clienteService;

   public ClienteTest(){
       IClienteDAO clienteDao = new ClienteDAO();
        this.clienteService = new ClienteService(clienteDao);
    }

    @Test
    public void pesquisarCliente() throws Exception {
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
    public void salvarCliente() throws Exception {
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
    public void editarCliente() throws Exception {
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
    public void removerCliente() throws Exception {
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
