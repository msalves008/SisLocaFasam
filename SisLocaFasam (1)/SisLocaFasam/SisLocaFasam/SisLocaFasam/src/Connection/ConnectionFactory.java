package Connection;

/**
 *
 * @author Matheus
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionFactory {
        // passando os diretorios do banco de dados
    private static final String URL = "jdbc:mysql://dyotech.com.br:3306/dyotec69_SistemaLocadora";
    private static final String USER = "dyotec69_fasam";
    private static final String PASS = "fasam@123";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //passando os diretorios do banco local
 // passando os diretorios do banco de dados
    /*private static final String URL = "jdbc:mysql://dyotech.com.br:3306/dyotec69_SistemaLocadora";
    private static final String USER = "dyotec69_fasam";
    private static final String PASS = "fasam@123";
    private static final String DRIVER = "com.mysql.jdbc.Driver";*/

    public static Connection getConnection() {
        // Conectando com o Banco de dados
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexão com o Banco de Dados: " + e);
        }
    }

    public static void closeConnection(Connection con) {
        //parando(fechando) conexão com o banco de dados 
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados: " + e);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados: " + e);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados: " + e);
        }
    }
}
