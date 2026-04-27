package br.com.estudoProjetoVendas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {


    private static Connection connection;

    public ConnectionFactory (Connection connection){}

    public static Connection getConnection(){
        if (connection == null){
            return connection = initConnection();
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
