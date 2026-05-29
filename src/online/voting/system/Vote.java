

package online.voting.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Vote extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3;

    JButton vote;

    String voterid;

    Vote(String voterid) {

        this.voterid = voterid;

        setTitle("Vote");

        setLayout(null);
        getContentPane().setBackground(new Color(230,240,255));

       
        JLabel l1 = new JLabel("CAST YOUR VOTE");

        l1.setFont(new Font("Arial", Font.BOLD, 26));

        l1.setBounds(100, 30, 300, 30);

        add(l1);

        // Candidates
        r1 = new JRadioButton("Rahul - ABC Party");

        r1.setBounds(80, 110, 250, 30);

        r1.setBackground(Color.WHITE);

        add(r1);

        r2 = new JRadioButton("Priya - XYZ Party");

        r2.setBounds(80, 170, 250, 30);

        r2.setBackground(Color.WHITE);

        add(r2);

        r3 = new JRadioButton("Aman - PQR Party");

        r3.setBounds(80, 230, 250, 30);

        r3.setBackground(Color.WHITE);

        add(r3);

        // Button Group
        ButtonGroup bg = new ButtonGroup();

        bg.add(r1);

        bg.add(r2);

        bg.add(r3);

        // Vote Button
        vote = new JButton("VOTE");

        vote.setBounds(140, 320, 120, 40);

        vote.setBackground(Color.BLACK);

        vote.setForeground(Color.WHITE);

        vote.addActionListener(this);

        add(vote);
        
        setSize(450, 450);

        setLocationRelativeTo(null);

        setResizable(false);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String candidate = "";

        // Candidate Selection
        if (r1.isSelected()) {

            candidate = "Rahul";
        }

        else if (r2.isSelected()) {

            candidate = "Priya";
        }

        else if (r3.isSelected()) {

            candidate = "Aman";
        }

        // Validation if no candidate selected
        if(candidate.equals(""))
        {
            JOptionPane.showMessageDialog(null,
                    "Please select a candidate");
        }

        else
        {
            try {

                Conn c = new Conn();

                // Check Already Voted
                String checkQuery = "select * from voters where voterid='"
                        + voterid +
                        "' and votestatus='Voted'";

                ResultSet rs = c.s.executeQuery(checkQuery);

                // Already Voted Validation
                if (rs.next()) {

                    JOptionPane.showMessageDialog(null,
                            "You have already voted");
                }

                else {

                    // Insert Vote
                    String insertVote = "insert into votes values('"
                            + voterid + "','"
                            + candidate + "','Party')";

                    c.s.executeUpdate(insertVote);

                    // Update Voter Status
                    String updateStatus = "update voters set votestatus='Voted' where voterid='"
                            + voterid + "'";

                    c.s.executeUpdate(updateStatus);

                    // Increase Total Votes
                    String updateVotes = "update candidates set totalvotes = totalvotes + 1 where candidatename='"
                            + candidate + "'";

                    c.s.executeUpdate(updateVotes);

                    JOptionPane.showMessageDialog(null,
                            "Vote Cast Successfully");

                    setVisible(false);

                    new Dashboard(voterid);
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public static void main(String[] args) {

        new Vote("");
    }
}