package online.voting.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame implements ActionListener {

    JButton b1, b2, b3,b4,b5;

    AdminDashboard() {

        setTitle("Admin Dashboard");

        setLayout(null);
         getContentPane().setBackground(new Color(230,240,255));

        JLabel heading = new JLabel("ADMIN PANEL");

        heading.setFont(new Font("Raleway", Font.BOLD, 26));

        heading.setBounds(100, 30, 300, 40);

        add(heading);

        // ADD CANDIDATE BUTTON
        b1 = new JButton("ADD CANDIDATE");

        b1.setBounds(100, 100, 200, 40);
        b1.setBackground(Color.BLACK);

        b1.setForeground(Color.WHITE);


        b1.addActionListener(this);

        add(b1);

        // RESET VOTES BUTTON
        b2 = new JButton("RESET VOTES");

        b2.setBounds(100, 170, 200, 40);
        b2.setBackground(Color.BLACK);

        b2.setForeground(Color.WHITE);


        b2.addActionListener(this);

        add(b2);

        // VIEW RESULT BUTTON
        b3 = new JButton("VIEW RESULT");

        b3.setBounds(100, 240, 200, 40);
        b3.setBackground(Color.BLACK);

        b3.setForeground(Color.WHITE);


        b3.addActionListener(this);

        add(b3);
        b4 = new JButton("VIEW CANDIDATES");

        b4.setBounds(100, 310, 200, 40);
        b4.setBackground(Color.BLACK);

        b4.setForeground(Color.WHITE);


        b4.addActionListener(this);

        add(b4);
        
        b5 = new JButton("REMOVE CANDIDATE");

        b5.setBounds(100, 380, 200, 40);
        b5.setBackground(Color.BLACK);

        b5.setForeground(Color.WHITE);


b5.addActionListener(this);

add(b5);

        
        setSize(420, 550);

        setLocation(450, 200);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        // ADD CANDIDATE
        if(ae.getSource() == b1){

            new AddCandidate();

        }

        // RESET VOTES
        else if(ae.getSource() == b2){

            try{

                Conn c = new Conn();

                String q1 = "update voters set votestatus='Not Voted'";

                c.s.executeUpdate(q1);

                String q2 = "update candidates set totalvotes=0";

                c.s.executeUpdate(q2);

                JOptionPane.showMessageDialog(null, "All Votes Reset Successfully");

            }catch(Exception e){

                System.out.println(e);
            }
        }

        // VIEW RESULT
        else if(ae.getSource() == b3){

            new Result();
        }
        else if (ae.getSource()==b4){
            new ViewCandidates();
        }
        else if (ae.getSource()==b5){
            new RemoveCandidate();
        }
    }

    public static void main(String[] args){

        new AdminDashboard();
    }
}
