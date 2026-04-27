import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws Exception {
        String url  = "jdbc:mysql://localhost:3307/estudos_db";
        String user = "aluno";
        String pass = "aluno123";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Conectado! " + conn.getCatalog());
        }
    }
}