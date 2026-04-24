package main.java.br.com.estudoProjetoVendas.service;

import main.java.br.com.estudoProjetoVendas.domain.Cliente;

public interface IClienteService {
    void salvar(Cliente cliente);

    Cliente buscarClientePorCPF(Long cpf);

    void remover(Long cpf);

    Cliente editar(Long cpf, Cliente cliente);
}
