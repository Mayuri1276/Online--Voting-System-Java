
package online.voting.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Result extends JFrame {

    Result() {

        setTitle("Voting Result");

        setLayout(null);
        getContentPane().setBackground(new Color(230,240,255));

        JLabel heading = new JLabel("RESULT");
        heading.setFont(new Font("Raleway", Font.BOLD, 26));
        heading.setBounds(170, 20, 200, 40);
        add(heading);

        try {

            Conn c = new Conn();

            String q = "select * from candidates";
            
            String winner= "";
            int maxVotes =0;
            
            ResultSet rs = c.s.executeQuery(q);

            int y = 100;

            while(rs.next()) {

                String name = rs.getString("candidatename");

                String votes = rs.getString("totalvotes");
                int v= Integer.parseInt(votes);
                
                if(v>maxVotes){
                maxVotes=v;
                winner = name;
                }

                JLabel l = new JLabel(name + "  --->  " + votes + " Votes");

                l.setFont(new Font("Arial", Font.BOLD, 18));

                l.setBounds(80, y, 300, 30);

                add(l);

                y += 50;
            }
            JLabel win = new JLabel("Winner : " + winner);

win.setFont(new Font("Arial", Font.BOLD, 22));

win.setBounds(100, 300, 300, 40);

add(win);

        } catch(Exception e) {

            System.out.println(e);
        }


        setSize(450, 450);

        setLocation(400, 180);

        setVisible(true);
    }
}
    

