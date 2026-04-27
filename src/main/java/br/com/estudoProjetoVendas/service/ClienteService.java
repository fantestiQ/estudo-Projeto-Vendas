package br.com.estudoProjetoVendas.service;


import br.com.estudoProjetoVendas.dao.IClienteDAO;
import br.com.estudoProjetoVendas.domain.Cliente;

import java.util.List;


public class ClienteService implements IClienteService  {

    private IClienteDAO clienteDao;

    public ClienteService(IClienteDAO dao){
        this.clienteDao = dao;
    }

    @Override
    public void salvar(Cliente cliente) throws Exception {
        clienteDao.salvar(cliente);
    }

    @Override
    public Cliente buscarClientePorCPF(Long cpf) throws Exception {
        return clienteDao.buscarClientePorCPF(cpf);
    }

    @Override
    public void remover(Long cpf) throws Exception {
        clienteDao.remover(cpf);
    }

    @Override
    public Cliente editar(Long cpf, Cliente cliente) throws Exception {
        return clienteDao.editar(cpf, cliente);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return List.of();
    }
}
