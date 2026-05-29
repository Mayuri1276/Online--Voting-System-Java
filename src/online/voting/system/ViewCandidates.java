package online.voting.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ViewCandidates extends JFrame {

    ViewCandidates() {

        setTitle("View Candidates");

        setLayout(null);
        getContentPane().setBackground(new Color(230,240,255));

        JLabel heading = new JLabel("CANDIDATE LIST");

        heading.setFont(new Font("Raleway", Font.BOLD, 24));

        heading.setBounds(120, 20, 300, 40);

        add(heading);

        try{

            Conn c = new Conn();

            String q = "select * from candidates";

            ResultSet rs = c.s.executeQuery(q);

            int y = 100;

            while(rs.next()){

                String name = rs.getString("candidatename");

                String party = rs.getString("partyname");

                String votes = rs.getString("totalvotes");

                JLabel l = new JLabel(name + " | " + party + " | Votes : " + votes);

                l.setFont(new Font("Arial", Font.BOLD, 16));

                l.setBounds(30, y, 400, 30);

                add(l);

                y += 40;
            }

        }catch(Exception e){

            System.out.println(e);
        }

        

        setSize(500, 450);

        setLocation(420, 180);

        setVisible(true);
    }

    public static void main(String[] args){

        new ViewCandidates();
    }
}
