package br.com.estudoProjetoVendas;

import com.sun.source.tree.TryTree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {


    private static Connection connection;

    public ConnectionFactory (Connection connection){}

    public static Connection getConnection(){
        try{
        if (connection == null || connection.isClosed()){
            return connection = initConnection();
        }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return connection;
    }

    private static Connection initConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/estudos_db",
                    "aluno",
                    "aluno123");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
