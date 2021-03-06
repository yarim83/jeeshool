package pl.coderslab.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBUtil {

//    private static final String DB_URL = "jdbc:mysql://localhost:3306/szkola_programowania?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
//    private static final String DB_USER = "root";
//    private static final String DB_PASSWORD = "coderslab";
//
//    private DBUtil() {
//    } //tworzymy prywatny konstruktor ktory uniemozliwia utworzenie obiektu tej klasy. Kwestie bezpieczenastwa
//
//    public static Connection createConnection() throws SQLException {
//        return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
//    }


    ///

    private static DataSource dataSource;

    public static Connection createConnection() throws SQLException {
        return getInstance().getConnection();
    }

    private static DataSource getInstance() {
        if (dataSource == null) {
            try {
                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                dataSource = (DataSource) envContext.lookup("jdbc/school");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return dataSource;
    }

}
