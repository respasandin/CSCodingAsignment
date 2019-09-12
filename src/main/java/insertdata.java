import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertdata {
    public static void insertdatabase(Object id, Object state, int duration, String type, String host, String alert) throws SQLException {

        PreparedStatement pstmt = Main.conn.prepareStatement("INSERT INTO DATA(ID,STATE,DURATION,TYPE, HOST,ALERT) VALUES (?, ?, ?, ?, ?, ?)");
        pstmt.setString(1, id.toString());
        pstmt.setString(2, state.toString());
        pstmt.setInt(3, duration);
        pstmt.setString(4, type);
        pstmt.setString(5,host);
        pstmt.setString(6,alert );

        pstmt.executeUpdate();
    }
}
