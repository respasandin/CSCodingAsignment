import java.sql.SQLException;
import java.sql.Statement;

public class clearDB {
    public static void clearDB() throws SQLException {
        String sqlCreate = "DELETE FROM DATA";

        Statement stmt = Main.conn.createStatement();
        stmt.execute(sqlCreate);

        System.out.println("Empty database");
    }
}
