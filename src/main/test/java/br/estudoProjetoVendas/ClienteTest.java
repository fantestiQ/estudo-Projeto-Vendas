package main.test.java.br.estudoProjetoVendas;


import br.com.estudoProjetoVendas.dao.ClienteDAO;
import br.com.estudoProjetoVendas.dao.IClienteDAO;
import br.com.estudoProjetoVendas.domain.Cliente;
import br.com.estudoProjetoVendas.service.ClienteService;
import br.com.estudoProjetoVendas.service.IClienteService;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ClienteTest {

    IClienteService clienteService;

    Cliente cliente = new Cliente("João Silva",
            "12345678901",
            "11999998888",
            "Rua das Flores",
            "123",
            "São Paulo",
            "SP"  );
    Cliente cliente2 = new Cliente("Joseph Joestar",
            "1777678888",
            "11999343488",
            "Rua Morioh",
            "7070",
            "Morioh",
            "JP"  );;
    Cliente cliente3 = new Cliente("Isac Santos",
            "1747678441",
            "11996733488",
            "Grajaú",
            "789",
            "São Paulo",
            "SP"  );

   public ClienteTest(){
       IClienteDAO clienteDao = new ClienteDAO();
        this.clienteService = new ClienteService(clienteDao);
    }

    @Test
    public void pesquisarCliente() throws Exception {
        clienteService.salvar(cliente);
        Cliente clienteBuscado = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertEquals(cliente,clienteBuscado);
        Assert.assertNotNull(clienteBuscado);

        clienteService.remover(cliente.getCpf());
        clienteBuscado = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertNull(clienteBuscado);
    }
    @Test
    public void salvarCliente() throws Exception {
        clienteService.salvar(cliente);
        Cliente clienteBuscado = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertEquals(cliente,clienteBuscado);

        clienteService.remover(cliente.getCpf());
        clienteBuscado = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertNull(clienteBuscado);
    }
    @Test
    public void editarCliente() throws Exception {
        clienteService.salvar(cliente);
        Cliente clienteSalvo = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertEquals(cliente,clienteSalvo);

        cliente.setNome("Isac dos Santos");
        cliente.setTel(11977777222L);

        Cliente clienteEditado = clienteService.editar(cliente.getCpf(),cliente);

        Cliente clienteBuscado = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertNotEquals("João Silva", clienteBuscado.getNome());
        Assert.assertEquals(clienteEditado,clienteBuscado);

        clienteService.remover(cliente.getCpf());
        clienteBuscado = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertNull(clienteBuscado);
    }


    @Test
    public void removerCliente() throws Exception {

        clienteService.salvar(cliente);
        Cliente clienteSalvo = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertEquals(cliente,clienteSalvo);

        clienteService.remover(cliente.getCpf());
        Cliente clienteBuscado = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertNull(clienteBuscado);
    }
    @Test
    public void listarTodosTest() throws Exception {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);
        clientes.add(cliente2);
        clientes.add(cliente3);

        for (Cliente cliente : clientes){
            clienteService.salvar(cliente);
        }

        List<Cliente> listaBuscada = clienteService.buscarTodos();

        Assert.assertEquals(clientes.size(), listaBuscada.size());

        int i = clientes.size() - 1;
        for (Cliente cliente : listaBuscada){
            Assert.assertEquals(cliente , clientes.get(i));
            i--;
        }

        for (Cliente cliente : listaBuscada){
            clienteService.remover(cliente.getCpf());
        }

        listaBuscada = clienteService.buscarTodos();

        Assert.assertEquals(0,listaBuscada.size());

    }
}
