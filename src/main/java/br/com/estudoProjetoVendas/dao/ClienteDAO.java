package main.java.br.com.estudoProjetoVendas.dao;

import main.java.br.com.estudoProjetoVendas.SingletonMap;
import main.java.br.com.estudoProjetoVendas.domain.Cliente;


public class ClienteDAO implements IClienteDAO {


    @Override
    public void salvar(Cliente cliente) {
        SingletonMap.put(Cliente.class,cliente.getCpf(),cliente);
    }

    @Override
    public Cliente buscarClientePorCPF(Long cpf) {
        return SingletonMap.get(Cliente.class,cpf);
    }

    @Override
    public void remover(Long cpf) {
        SingletonMap.remove(Cliente.class,cpf);
    }

    @Override
    public Cliente editar(Long cpf, Cliente cliente) {
        return SingletonMap.editar(Cliente.class,cpf,cliente);
    }
}
