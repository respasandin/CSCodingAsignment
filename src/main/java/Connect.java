import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {
    //Connects with database
    public static Connection getConnection() throws SQLException {

        Properties connectionProps = new Properties();
        connectionProps.put("user", "user");
        connectionProps.put("password", "");

        System.out.println("Connecting to database...");

        Main.conn = DriverManager.getConnection(
                "jdbc:hsqldb:file:C:\\Users\\Fina\\IntelliJIDEAProjects\\CodingAssignment\\Data\\database/",
                connectionProps);

        System.out.println("Connected to database");

        return Main.conn;
    }
}
