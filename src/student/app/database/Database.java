/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sithu
 */
public class Database {
    
    private String ur1 = "jdbc:mysql://localhost:3306/studentapp";
    private String user = "root";
    private String password = "";
    private static Database db;
    private Connection conn;

    private Database() {
        try {
            connect();
        } catch (SQLException e) {
            System.out.println("Cannot connect to database");
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (db == null) {
            db = new Database();
        }
        return db;
    }

    public boolean connect() throws SQLException {
        conn = DriverManager.getConnection(ur1, user, password);

        return true;

    }

    public Connection getConnection() {
        return conn;
    }
}
