package online.voting.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Image;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, l3;

    JTextField tf1;

    JPasswordField pf1;

    JButton b1, b2;

    Login() {

        setTitle("Online Voting System");

        setLayout(null);

        getContentPane().setBackground(new Color(230,240,255));

        
        ImageIcon i1 = new ImageIcon("C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\OnlineVotingSystem\\src\\icon\\vote.png");

        Image i2 = i1.getImage().getScaledInstance(140, 100, Image.SCALE_DEFAULT);

        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);

        image.setBounds(350, 30, 90, 90);

        add(image);

       
        l1 = new JLabel("ONLINE VOTING SYSTEM");

        l1.setForeground(Color.BLACK);

        l1.setFont(new Font("Raleway", Font.BOLD, 24));

        l1.setBounds(50, 30, 400, 40);

        add(l1);

        // Voter ID
        l2 = new JLabel("Voter ID");

        l2.setFont(new Font("Raleway", Font.BOLD, 18));

        l2.setBounds(50, 140, 200, 30);

        add(l2);

        tf1 = new JTextField();

        tf1.setBounds(170, 140, 200, 30);

        add(tf1);

        // Password
        l3 = new JLabel("Password");

        l3.setFont(new Font("Raleway", Font.BOLD, 18));

        l3.setBounds(50, 200, 200, 30);

        add(l3);

        pf1 = new JPasswordField();

        pf1.setBounds(170, 200, 200, 30);

        add(pf1);

        // LOGIN Button
        b1 = new JButton("LOGIN");

        b1.setBounds(140, 290, 100, 35);

        b1.setBackground(Color.BLACK);

        b1.setForeground(Color.WHITE);

        b1.addActionListener(this);

        add(b1);

        
        b2 = new JButton("SIGNUP");

        b2.setBounds(260, 290, 100, 35);

        b2.setBackground(Color.BLACK);

        b2.setForeground(Color.WHITE);

        b2.addActionListener(this);

        add(b2);

        // Frame Settings
        setSize(500, 420);

        setLocationRelativeTo(null);

        setResizable(false);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        // LOGIN BUTTON
        if (ae.getSource() == b1) {

            String voterid = tf1.getText();

            String password = String.valueOf(pf1.getPassword());

            // Empty Field Validation
            if(voterid.equals("") || password.equals(""))
            {
                JOptionPane.showMessageDialog(null,
                        "All fields are required");
            }

            else
            {
                try {

                    Conn c = new Conn();

                    String query = "select * from voters where voterid='"
                            + voterid +
                            "' and password='"
                            + password + "'";

                    ResultSet rs = c.s.executeQuery(query);

                    // Login Successful
                    if (rs.next()) {

                        // Already Voted Validation
                        String status = rs.getString("votestatus");

                        if(status.equals("Voted"))
                        {
                            JOptionPane.showMessageDialog(null,
                                    "You have already voted");
                        }

                        else
                        {
                            JOptionPane.showMessageDialog(null,
                                    "Login Successful");

                            setVisible(false);

                            new Dashboard(voterid);
                        }
                    }

                    // Wrong Login Validation
                    else {

                        JOptionPane.showMessageDialog(null,
                                "Invalid Voter ID or Password");
                    }

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }

        // SIGNUP BUTTON
        else if (ae.getSource() == b2) {

            setVisible(false);

            new Signup();
        }
    }

    public static void main(String[] args) {

        new Login();
    }
}