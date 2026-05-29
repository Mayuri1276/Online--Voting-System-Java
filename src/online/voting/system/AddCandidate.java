package online.voting.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddCandidate extends JFrame implements ActionListener {

    JTextField tf1, tf2;

    JButton add;

    AddCandidate() {

        setTitle("Add Candidate");

        setLayout(null);
         getContentPane().setBackground(new Color(230,240,255));

        // Heading
        JLabel heading = new JLabel("ADD CANDIDATE");

        heading.setFont(new Font("Arial", Font.BOLD, 26));

        heading.setBounds(150, 30, 300, 40);

        add(heading);

        // Candidate Name
        JLabel l1 = new JLabel("Candidate Name");

        l1.setFont(new Font("Arial", Font.BOLD, 18));

        l1.setBounds(50, 110, 170, 30);

        add(l1);

        tf1 = new JTextField();

        tf1.setBounds(220, 110, 180, 30);

        add(tf1);

        // Party Name
        JLabel l2 = new JLabel("Party Name");

        l2.setFont(new Font("Arial", Font.BOLD, 18));

        l2.setBounds(50, 180, 170, 30);

        add(l2);

        tf2 = new JTextField();

        tf2.setBounds(220, 180, 180, 30);

        add(tf2);

        // ADD Button
        add = new JButton("ADD");

        add.setBounds(170, 270, 140, 40);

        add.setBackground(Color.BLACK);

        add.setForeground(Color.WHITE);

        add.setFont(new Font("Arial", Font.BOLD, 16));

        add.addActionListener(this);

        add(add);

        // Background
        //getContentPane().setBackground(Color.WHITE);

        // Frame Settings
        setSize(500, 420);

        setLocationRelativeTo(null);

        setResizable(false);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String name = tf1.getText();

        String party = tf2.getText();

        // Empty Field Validation
        if(name.equals("") || party.equals(""))
        {
            JOptionPane.showMessageDialog(null,
                    "All fields are required");
        }

        else
        {
            try {

                Conn c = new Conn();

                // Duplicate Candidate Validation
                String checkQuery = "select * from candidates where candidatename='"
                        + name + "'";

                ResultSet rs = c.s.executeQuery(checkQuery);

                if(rs.next())
                {
                    JOptionPane.showMessageDialog(null,
                            "Candidate already exists");
                }

                else
                {
                    // Insert Candidate
                    String q = "insert into candidates(candidatename,partyname,totalvotes) values('"
                            + name + "','"
                            + party + "',0)";

                    c.s.executeUpdate(q);

                    JOptionPane.showMessageDialog(null,
                            "Candidate Added Successfully");

                    setVisible(false);
                }

            } catch(Exception e){

                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public static void main(String[] args){

        new AddCandidate();
    }
}