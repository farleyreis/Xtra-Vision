
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author farley_reis
 */
public class DBASE {


    // -----------------------------------------------------------
    // upload driver JDBC
    //
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // -----------------------------------------------------------
    public Connection obtemConexao() throws SQLException {
        return DriverManager
                    .getConnection("jdbc:mysql://apontejaj.com:3306/Matheus_2019378?useSSL=false", "Matheus_2019378", "2019378");
    }
}