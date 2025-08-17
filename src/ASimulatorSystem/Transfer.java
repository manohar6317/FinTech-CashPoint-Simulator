package ASimulatorSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Transfer extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2;
    String cardno;

    Transfer(String cardno) {
        this.cardno = cardno;

        setLayout(null);

        JLabel l1 = new JLabel("Enter Receiver Card Number:");
        l1.setFont(new Font("Raleway", Font.BOLD, 14));
        l1.setBounds(120, 80, 250, 25);
        add(l1);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.PLAIN, 14));
        t1.setBounds(120, 110, 250, 25);
        add(t1);

        JLabel l2 = new JLabel("Enter Amount:");
        l2.setFont(new Font("Raleway", Font.BOLD, 14));
        l2.setBounds(120, 160, 200, 25);
        add(l2);

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.PLAIN, 14));
        t2.setBounds(120, 190, 250, 25);
        add(t2);

        b1 = new JButton("Transfer");
        b1.setBounds(120, 250, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(250, 250, 120, 30);
        b2.addActionListener(this);
        add(b2);

        setSize(500, 400);
        setLocation(500, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String receiver = t1.getText();
            String amountStr = t2.getText();

            if (ae.getSource() == b1) {
                if (receiver.equals("") || amountStr.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields");
                    return;
                }

                double amount = Double.parseDouble(amountStr);

                Conn c = new Conn();

                // Check sender balance
                ResultSet rs1 = c.s.executeQuery("SELECT balance FROM users WHERE card_no='" + cardno + "'");
                double senderBalance = 0;
                if (rs1.next()) {
                    senderBalance = rs1.getDouble("balance");
                }

                if (senderBalance < amount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                    return;
                }

                // Check receiver exists
                ResultSet rs2 = c.s.executeQuery("SELECT balance FROM users WHERE card_no='" + receiver + "'");
                if (!rs2.next()) {
                    JOptionPane.showMessageDialog(null, "Receiver Card Number not found!");
                    return;
                }
                double receiverBalance = rs2.getDouble("balance");

                // Update balances
                double newSenderBalance = senderBalance - amount;
                double newReceiverBalance = receiverBalance + amount;

                c.s.executeUpdate("UPDATE users SET balance=" + newSenderBalance + " WHERE card_no='" + cardno + "'");
                c.s.executeUpdate("UPDATE users SET balance=" + newReceiverBalance + " WHERE card_no='" + receiver + "'");

                // Insert into Transactions
                Date date = new Date();
                c.s.executeUpdate("INSERT INTO transactions(card_no, date, type, amount) VALUES('" + cardno + "', '" + date + "', 'Transfer-Out', '" + amount + "')");
                c.s.executeUpdate("INSERT INTO transactions(card_no, date, type, amount) VALUES('" + receiver + "', '" + date + "', 'Transfer-In', '" + amount + "')");

                JOptionPane.showMessageDialog(null, "₹" + amount + " Transferred Successfully!");
                setVisible(false);
                new Transactions(cardno).setVisible(true);

            } else if (ae.getSource() == b2) {
                setVisible(false);
                new Transactions(cardno).setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Transfer("").setVisible(true);
    }
}
