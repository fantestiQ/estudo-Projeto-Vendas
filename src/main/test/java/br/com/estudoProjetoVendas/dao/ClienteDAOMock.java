package main.test.java.br.com.estudoProjetoVendas.dao;

import main.java.br.com.estudoProjetoVendas.dao.IClienteDAO;
import main.java.br.com.estudoProjetoVendas.domain.Cliente;

public class ClienteDAOMock implements IClienteDAO {
    @Override
    public void salvar(Cliente cliente) {

    }

    @Override
    public Cliente buscarClientePorCPF(Long cpf) {
        return new Cliente("João Silva",
                "12345678901",
                "11999998888",
                "Rua das Flores",
                "123",
                "São Paulo",
                "SP");
    }

    @Override
    public void remover(Long cpf) {

    }

    @Override
    public Cliente editar(Long cpf, Cliente cliente) {
        return null;
    }
}
