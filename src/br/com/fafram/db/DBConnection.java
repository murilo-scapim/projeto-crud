package br.com.fafram.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String DATABASE_URL = "jdbc:postgresql:faculdade";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";
    private static Connection conn;

    public static Connection createConnection() {
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DATABASE_URL,
                    USER, PASSWORD);
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conn;
    }

    public static void main(String[] args) {
        try {
            Connection conn = createConnection();
            if (conn != null) {
                System.out.println("Conexão realizada com sucesso!");
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
