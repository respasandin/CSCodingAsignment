import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

import java.util.stream.Stream;

public class Main {
    public static Connection conn = null;
    //Get the file from the path specified in command line
    public static void main(String[] args) throws ParseException, SQLException {
        //Local variables
        FileInputStream inputStream;
        ArrayList<String> json = new ArrayList<String>();

        //Check if path to file is given in the command line, if not print error message
        if (args.length == 0) {
            System.err.println("Invalid command line, path to log file required");
            System.exit(1);
            //If given, read the file
        } else {
            //Delete [] from List
            String file = Arrays.toString(args).replace("]", "");
            file = file.replace("[", "");
            System.out.println("Reading file...");
            //Read file
            try (Stream<String> stream = Files.lines(Paths.get(file), StandardCharsets.UTF_8)) {
                stream.forEach(s -> json.add(s));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Try to connect to database
            Connect.getConnection();
            //If not exist create table
            createTable.createTable();
            //If is data inside delete all
            clearDB.clearDB();
            //Parse the JSON and calculate the duration and alert
            parsedJSON.parsedJSON(json);

            conn.close();
            System.out.println("Database closed");
            System.out.println("Exit");
            System.exit(1);
        }
    }
}



