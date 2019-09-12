import java.sql.SQLException;
import java.sql.Statement;

public class createTable {
    public static void createTable() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS DATA"
                + "  (id           VARCHAR(25),"
                + "   state            VARCHAR(25),"
                + "   duration          VARCHAR(25),"
                + "   type           VARCHAR(25),"
                + "   host           VARCHAR(25),"
                + "   alert     VARCHAR(25))";

        Statement stmt = Main.conn.createStatement();
        stmt.execute(sqlCreate);
    }
}
