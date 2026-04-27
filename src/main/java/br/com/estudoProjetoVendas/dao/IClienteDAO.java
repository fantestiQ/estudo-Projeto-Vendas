package br.com.estudoProjetoVendas.dao;


import br.com.estudoProjetoVendas.domain.Cliente;

import java.util.List;

public interface IClienteDAO {
    void salvar(Cliente cliente) throws Exception;

    Cliente buscarClientePorCPF(Long cpf) throws Exception;

    void remover(Long cpf) throws Exception;

    Cliente editar(Long cpf, Cliente cliente) throws Exception;

    List<Cliente> buscarTodos() throws Exception;

}
