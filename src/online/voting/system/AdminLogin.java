
package online.voting.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLogin extends JFrame implements ActionListener {

    JTextField tf1;

    JPasswordField pf1;

    JButton login;

    AdminLogin() {

        setTitle("Admin Login");

        setLayout(null);
         getContentPane().setBackground(new Color(230,240,255));

        // Heading
        JLabel heading = new JLabel("ADMIN LOGIN");

        heading.setFont(new Font("Arial", Font.BOLD, 26));

        heading.setBounds(120, 30, 250, 40);

        add(heading);

        // Admin ID
        JLabel l1 = new JLabel("Admin ID");

        l1.setFont(new Font("Arial", Font.BOLD, 18));

        l1.setBounds(50, 110, 120, 30);

        add(l1);

        tf1 = new JTextField();

        tf1.setBounds(180, 110, 180, 30);

        add(tf1);

        // Password
        JLabel l2 = new JLabel("Password");

        l2.setFont(new Font("Arial", Font.BOLD, 18));

        l2.setBounds(50, 180, 120, 30);

        add(l2);

        pf1 = new JPasswordField();

        pf1.setBounds(180, 180, 180, 30);

        add(pf1);

        // LOGIN Button
        login = new JButton("LOGIN");

        login.setBounds(150, 280, 140, 40);

        login.setBackground(Color.BLACK);

        login.setForeground(Color.WHITE);

        login.setFont(new Font("Arial", Font.BOLD, 16));

        login.addActionListener(this);

        add(login);

        
        setSize(450, 420);

        setLocationRelativeTo(null);

        setResizable(false);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String adminid = tf1.getText();

        String password = String.valueOf(pf1.getPassword());

        // Empty Field Validation
        if(adminid.equals("") || password.equals(""))
        {
            JOptionPane.showMessageDialog(null,
                    "All fields are required");
        }

        // Admin Login Validation
        else if(adminid.equals("admin") &&
                password.equals("admin123"))
        {

            JOptionPane.showMessageDialog(null,
                    "Admin Login Successful");

            setVisible(false);

            new AdminDashboard();
        }

        // Wrong Credentials Validation
        else {

            JOptionPane.showMessageDialog(null,
                    "Invalid Admin Username or Password");
        }
    }

    public static void main(String args[]){

        new AdminLogin();
    }
}