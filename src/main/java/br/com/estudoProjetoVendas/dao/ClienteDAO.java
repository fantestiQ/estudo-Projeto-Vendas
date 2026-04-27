package br.com.estudoProjetoVendas.dao;


import br.com.estudoProjetoVendas.ConnectionFactory;
import br.com.estudoProjetoVendas.SingletonMap;
import br.com.estudoProjetoVendas.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClienteDAO implements IClienteDAO {

    @Override
    public void salvar(Cliente cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            stm = connection.prepareStatement(sql);
            adicionarParametrosInsert(stm, cliente);
            stm.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            cloneConnection(connection,stm,null);
        }
    }

    @Override
    public Cliente buscarClientePorCPF(Long cpf) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultSet = null;
        Cliente cliente = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = getClientePorCpf();
            stm = connection.prepareStatement(sql);
            resultSet = stm.executeQuery();

            if (resultSet.next()){
                String nome = resultSet.getString("nome");
                Long cpfBuscado = resultSet.getLong("cpf");
                Long tel = resultSet.getLong("tel");
                String end = resultSet.getString("endereco");
                Integer num = resultSet.getInt("numero");
                String cidade = resultSet.getString("cidade");
                String estado = resultSet.getString("estado");
                cliente = new Cliente(nome,cpfBuscado,tel,end,num,cidade,estado);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            cloneConnection(connection,stm,resultSet);
        }
        return cliente;
    }

    @Override
    public void remover(Long cpf) {
        SingletonMap.remove(Cliente.class,cpf);
    }

    @Override
    public Cliente editar(Long cpf, Cliente cliente) {
        return SingletonMap.editar(Cliente.class,cpf,cliente);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return List.of();
    }

    private String getSqlInsert(){
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO tb_clientes (nome,cpf,tel,endereco,numero,cidade,estado) ");
        sb.append("VALUES (?,?,?,?,?,?,?)");

        return sb.toString();
    }
    private void adicionarParametrosInsert(PreparedStatement stm, Cliente cliente) throws SQLException {
        stm.setString(1, cliente.getNome());
        stm.setLong(2, cliente.getCpf());
        stm.setLong(3, cliente.getTel());
        stm.setString(4, cliente.getEnd());
        stm.setInt(5, cliente.getNum());
        stm.setString(6, cliente.getCidade());
        stm.setString(7, cliente.getEstado());

    }

    private String getClientePorCpf(){
        StringBuilder stb = new StringBuilder();
        stb.append("SELECT * FROM tb_clientes c WHERE c.cpf = ?");
        return stb.toString();
    }
    private void adicionarParametrosGetPorCpf(PreparedStatement stm, Cliente cliente) throws SQLException {
        stm.setLong(1, cliente.getCpf());
    }

    private void cloneConnection(Connection connection, PreparedStatement stm, ResultSet rt) throws SQLException {
        if (connection != null && !connection.isClosed()){
            connection.close();
        }
        if (stm != null && !stm.isClosed()){
            stm.close();
        }
        if (rt != null && !rt.isClosed()){
            rt.close();
        }
    }
}
