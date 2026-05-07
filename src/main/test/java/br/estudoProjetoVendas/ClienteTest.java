package main.test.java.br.estudoProjetoVendas;


import br.com.estudoProjetoVendas.dao.ClienteDAO;
import br.com.estudoProjetoVendas.dao.IClienteDAO;
import br.com.estudoProjetoVendas.domain.Cliente;
import br.com.estudoProjetoVendas.service.ClienteService;
import br.com.estudoProjetoVendas.service.IClienteService;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ClienteTest {

    IClienteService clienteService;
    Cliente cliente = null;
    Cliente cliente2 = null;
    Cliente cliente3 = null;
    Cliente cliente4 = null;


   public ClienteTest(){
       IClienteDAO clienteDao = new ClienteDAO();
        this.clienteService = new ClienteService(clienteDao);
    }

    @Test
    public void devePesquisarCliente() throws Exception {
        Cliente clienteBuscado = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertEquals(cliente,clienteBuscado);
        Assert.assertNotNull(clienteBuscado);

    }
    @Test
    public void deveSalvarClienteEBuscar() throws Exception {
        Cliente clienteBuscado = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertEquals(cliente,clienteBuscado);
    }
    @Test
    public void deveEditarCliente() throws Exception {
        Cliente clienteAtualizado = new Cliente(
                "Isac dos Santos",
                cliente.getCpf().toString(),
                "11977777222",
                cliente.getEnd(),
                "2345",
                "São Paulo",
                cliente.getEstado());

        Cliente clienteEditado = clienteService.editar(cliente.getCpf(),clienteAtualizado);

        Cliente clienteBuscado = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertNotEquals("João Silva", clienteBuscado.getNome());
        Assert.assertEquals(clienteEditado,clienteBuscado);
        Assert.assertEquals("Isac dos Santos", clienteBuscado.getNome());

    }


    @Test
    public void deveRemoverCliente() throws Exception {
        Cliente clienteSalvo = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertEquals(cliente,clienteSalvo);

        clienteService.remover(cliente.getCpf());
        Cliente clienteBuscado = clienteService.buscarClientePorCPF(cliente.getCpf());
        Assert.assertNull(clienteBuscado);
    }

    @Test
    public void deveListarTodosTest() throws Exception {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente4);
        clientes.add(cliente3);
        clientes.add(cliente2);

        clientes.forEach(c ->{
            try {
                clienteService.salvar(c);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        clientes.add(cliente);

        List<Cliente> listaBuscada = clienteService.buscarTodos();

        Assert.assertEquals(clientes.size(), listaBuscada.size());

        Assert.assertTrue(listaBuscada.containsAll(clientes));
    }

    @Before
    public void init() throws Exception {
        cliente = new Cliente("João Silva",
                "12345678901",
                "11999998888",
                "Rua das Flores",
                "123",
                "São Paulo",
                "SP"  );
         cliente2 = new Cliente("Joseph Joestar",
                "1777678888",
                "11999343488",
                "Rua Morioh",
                "7070",
                "Morioh",
                "JP"  );;
        cliente3 = new Cliente("Isac Santos",
                "1747678441",
                "11996733488",
                "Grajaú",
                "789",
                "São Paulo",
                "SP"  );
        cliente4 = new Cliente("Akamaru Santos",
                "1747555441",
                "1199333388",
                "Grajaú",
                "789",
                "São Paulo",
                "SP"  );

        clienteService.salvar(cliente);
    }

    @After
    public void end() throws Exception {

        List<Cliente> listaBuscada = clienteService.buscarTodos();

        listaBuscada.forEach(cBuscado -> {
            try {
                clienteService.remover(cBuscado.getCpf());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
