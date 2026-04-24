package main.java.br.com.estudoProjetoVendas.dao;

import main.java.br.com.estudoProjetoVendas.domain.Cliente;

public interface IClienteDAO {
    void salvar(Cliente cliente);

    Cliente buscarClientePorCPF(Long cpf);

    void remover(Long cpf);

    Cliente editar(Long cpf, Cliente cliente);
}
