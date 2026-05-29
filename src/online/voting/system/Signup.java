package online.voting.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5;

    JTextField tf1, tf2;

    JPasswordField pf1, pf2;

    JButton b1;

    Signup() {

        setTitle("Voter Registration");

        setLayout(null);

        
        l1 = new JLabel("VOTER REGISTRATION");
        l1.setFont(new Font("Arial", Font.BOLD, 24));
        l1.setBounds(170, 30, 350, 20);
        add(l1);

        
        l2 = new JLabel("Voter ID");
        l2.setFont(new Font("Arial", Font.BOLD, 18));
        l2.setBounds(70, 100, 150, 30);
        add(l2);

        tf1 = new JTextField();
        tf1.setBounds(190, 100, 250, 32);
        add(tf1);

        
        l3 = new JLabel("Name");
        l3.setFont(new Font("Arial", Font.BOLD, 18));
        l3.setBounds(70, 160, 150, 30);
        add(l3);

        tf2 = new JTextField();
        tf2.setBounds(190, 160, 250, 32);
        add(tf2);

        
        l4 = new JLabel("Password");
        l4.setFont(new Font("Arial", Font.BOLD, 18));
        l4.setBounds(70, 220, 170, 30);
        add(l4);

        pf1 = new JPasswordField();
        pf1.setBounds(190, 220, 250, 32);
        add(pf1);

        
        l5 = new JLabel("Confirm Password");
        l5.setFont(new Font("Arial", Font.BOLD, 18));
        l5.setBounds(70, 280, 170, 30);
        add(l5);

        pf2 = new JPasswordField();
        pf2.setBounds(240, 280, 200, 30);
        add(pf2);

        
        b1 = new JButton("REGISTER");
        b1.setBounds(190,350, 150, 40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD, 16));
        b1.addActionListener(this);
        add(b1);

       
        getContentPane().setBackground( new Color(230,240,255
        ));

        
        setSize(550, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String voterid = tf1.getText();

        String name = tf2.getText();

        String password = String.valueOf(pf1.getPassword());

        String confirmpassword = String.valueOf(pf2.getPassword());

        
        if(voterid.equals("") || name.equals("") ||
                password.equals("") || confirmpassword.equals(""))
        {
            JOptionPane.showMessageDialog(null,
                    "All fields are required");
        }

        
        else if(!password.equals(confirmpassword))
        {
            JOptionPane.showMessageDialog(null,
                    "Passwords do not match");
        }

        else
        {
            try {

                Conn c = new Conn();

                String checkQuery = "select * from voters where voterid = '"
                        + voterid + "'";

                ResultSet rs = c.s.executeQuery(checkQuery);

                if(rs.next())
                {
                    JOptionPane.showMessageDialog(null,"Voter ID already exists");
                }

                else
                {
                    String query = "insert into voters values('"
                            + voterid + "','"
                            + name + "','"
                            + "NA','"
                            + "2000-01-01','"
                            + "Male','"
                            + "NA','"
                            + "test@gmail.com','"
                            + password + "','"
                            + "Not Voted')";

                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,
                            "Registration Successful");

                    setVisible(false);

                    new Login();
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public static void main(String[] args) {

        new Signup();
    }
}

