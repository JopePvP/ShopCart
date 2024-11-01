import java.sql.Connection;
import db.DB;

public class Main {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();
        System.out.print("Conectado");
        DB.closeConnection();

    }
    }