


package online.voting.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton b1, b2, b3;
    String voterid;

    Dashboard(String voterid) {

        this.voterid = voterid;

        setTitle("Dashboard");

        setLayout(null);

        JLabel l1 = new JLabel("ONLINE VOTING SYSTEM");
        l1.setFont(new Font("Raleway", Font.BOLD, 24));
        l1.setBounds(70, 40, 350, 40);
        add(l1);

        b1 = new JButton("VOTE NOW");
        b1.setBounds(120, 120, 180, 40);
        
         b1.setBackground(Color.BLACK);

        b1.setForeground(Color.WHITE);

        b1.addActionListener(this);
        add(b1);
        

        b2 = new JButton("CHECK RESULT");
        b2.setBounds(120, 190, 180, 40);
        b2.setBackground(Color.BLACK);

        b2.setForeground(Color.WHITE);

        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("LOGOUT");
        b3.setBounds(120, 260, 180, 40);
        b3.setBackground(Color.BLACK);

        b3.setForeground(Color.WHITE);

        b3.addActionListener(this);
        add(b3);

     getContentPane().setBackground(new Color(230,240,255));

        setSize(450, 400);
        setLocation(400, 180);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            //JOptionPane.showMessageDialog(null, "Vote Page Coming Soon");
          setVisible(false);
          new Vote(voterid);
            
        } else if (ae.getSource() == b2) {

            //JOptionPane.showMessageDialog(null, "Result Page Coming Soon");
          new Result();
            
        } else if (ae.getSource() == b3) {

            setVisible(false);

            new Login();
        }
    }
}
