
package online.voting.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RemoveCandidate extends JFrame implements ActionListener {

    JTextField tf1;

    JButton remove;

    RemoveCandidate() {

        setTitle("Remove Candidate");

        setLayout(null);
         getContentPane().setBackground(new Color(230,240,255));

        JLabel heading = new JLabel("REMOVE CANDIDATE");

        heading.setFont(new Font("Raleway", Font.BOLD, 22));

        heading.setBounds(100, 30, 300, 40);

        add(heading);

        JLabel l1 = new JLabel("Candidate Name");
        l1.setFont(new Font("Raleway", Font.BOLD, 18));

        l1.setBounds(40, 120, 170, 30);

        add(l1);

        tf1 = new JTextField();

        tf1.setBounds(200, 120, 180, 30);

        add(tf1);

        remove = new JButton("REMOVE");

        remove.setBounds(140, 220, 120, 35);

        remove.addActionListener(this);

        add(remove);

        setSize(450, 350);

        setLocation(450, 180);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String name = tf1.getText();

        try{

            Conn c = new Conn();

            String q = "delete from candidates where candidatename='"+name+"'";

            c.s.executeUpdate(q);

            JOptionPane.showMessageDialog(null, "Candidate Removed Successfully");

            setVisible(false);

        }catch(Exception e){

            System.out.println(e);
        }
    }

    public static void main(String[] args){

        new RemoveCandidate();
    }
}