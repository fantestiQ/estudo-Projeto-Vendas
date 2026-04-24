package main.java.br.com.estudoProjetoVendas.service;

import main.java.br.com.estudoProjetoVendas.dao.IClienteDAO;
import main.java.br.com.estudoProjetoVendas.domain.Cliente;

public class ClienteService implements IClienteService {

    private IClienteDAO clienteDao;

    public ClienteService(IClienteDAO dao){
        this.clienteDao = dao;
    }

    @Override
    public void salvar(Cliente cliente) {
        clienteDao.salvar(cliente);
    }

    @Override
    public Cliente buscarClientePorCPF(Long cpf) {
        return clienteDao.buscarClientePorCPF(cpf);
    }

    @Override
    public void remover(Long cpf) {
        clienteDao.remover(cpf);
    }

    @Override
    public Cliente editar(Long cpf, Cliente cliente) {
        return clienteDao.editar(cpf, cliente);
    }
}
