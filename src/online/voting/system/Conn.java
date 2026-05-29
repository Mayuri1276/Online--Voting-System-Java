/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.voting.system;




import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            c = DriverManager.getConnection(
                    "jdbc:mysql:///voting_system",
                    "root",
                    "1234");

            s = c.createStatement();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}