import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    private static final String URL = "jdbc:mysql://localhost:3306/estoque";
    private static final String USER = "root";     // seu usuário MySQL
    private static final String PASS = "senha";    // sua senha MySQL

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
