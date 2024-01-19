package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UI extends JFrame {
    private JLabel a;
    private Cursor cursor;
    private Font f;
    private Container c;
    private ImageIcon background, icon;
    private JButton blnceB, withdrawB, depositB, exitB;
    private double Blnce = 10000;
    
    UI (String PIN){
        Project project = new Project();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100, 629);
        this.setLocationRelativeTo(null);
        this.setTitle("Nisar's Bank Limited");
        
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        
        c = this.getContentPane();
        c.setLayout(null);
        
        f = new Font("Algerian", Font.BOLD, 14);
        
        cursor = new Cursor(Cursor.HAND_CURSOR);
        
        ImageIcon blnce = new ImageIcon(getClass().getResource("balance.png"));
        blnceB = new JButton("<html><center>Balance<br/>Check</html>",blnce);
        blnceB.setVerticalTextPosition(JButton.BOTTOM);
        blnceB.setHorizontalTextPosition(JButton.CENTER);
        blnceB.setFont(f);
        blnceB.setForeground(Color.RED);
        blnceB.setBounds(600, 50, 150, 200);
        blnceB.setCursor(cursor);
        blnceB.setOpaque(false);
        blnceB.setContentAreaFilled(false);
        blnceB.setBorderPainted(false);
        c.add(blnceB);
        blnceB.addActionListener(e -> {
            if (PINVerify(PIN)){
                ImageIcon blncee = new ImageIcon(getClass().getResource("Blnce.png"));
                JOptionPane.showMessageDialog(null, "Your Account Balance is: "+Blnce+" tk", "Starting Balance", JOptionPane.INFORMATION_MESSAGE,blncee);
            }
            else {
                ImageIcon lock = new ImageIcon(getClass().getResource("lock.png"));
                JOptionPane.showMessageDialog(null, "Your Account Has Been Locked!","Account Compromised!",JOptionPane.ERROR_MESSAGE, lock);
                System.exit(0);
            }
        });
        
        ImageIcon withdraw = new ImageIcon(getClass().getResource("withdraw.png"));
        withdrawB = new JButton("Withdraw",withdraw);
        withdrawB.setVerticalTextPosition(JButton.BOTTOM);
        withdrawB.setHorizontalTextPosition(JButton.CENTER);
        withdrawB.setFont(f);
        withdrawB.setForeground(Color.RED);
        withdrawB.setBounds(850, 50, 150, 200);
        withdrawB.setCursor(cursor);
        withdrawB.setOpaque(false);
        withdrawB.setContentAreaFilled(false);
        withdrawB.setBorderPainted(false);
        c.add(withdrawB);
        withdrawB.addActionListener(e -> {
            if (PINVerify(PIN)){
                ImageIcon wdraw = new ImageIcon(getClass().getResource("wdraw.png"));
                String x = (String) JOptionPane.showInputDialog(null, "Enter Withdrawal amount: ", "Withdraw", JOptionPane.QUESTION_MESSAGE, wdraw, null, null);
                double w = Double.parseDouble(x);
                if (w > Blnce){
                    ImageIcon err = new ImageIcon(getClass().getResource("err.png"));
                    JOptionPane.showMessageDialog(null, "Insufficient Funds!", "Fund Error!",JOptionPane.ERROR_MESSAGE, err);
                }
                else {
                    Blnce = Blnce - w;
                    ImageIcon dn = new ImageIcon(getClass().getResource("done.png"));
                    JOptionPane.showMessageDialog(null, "Withdraw Successful! New Balance: "+Blnce+" tk", "Operation Done", JOptionPane.INFORMATION_MESSAGE, dn);
                }
            }
            else {
                ImageIcon lock = new ImageIcon(getClass().getResource("lock.png"));
                JOptionPane.showMessageDialog(null, "Your Account Has Been Locked!","Account Compromised!",JOptionPane.ERROR_MESSAGE, lock);
                System.exit(0);
            }
        });
        
        ImageIcon deposit = new ImageIcon(getClass().getResource("deposit.png"));
        depositB = new JButton("Deposit",deposit);
        depositB.setVerticalTextPosition(JButton.BOTTOM);
        depositB.setHorizontalTextPosition(JButton.CENTER);
        depositB.setFont(f);
        depositB.setForeground(Color.RED);
        depositB.setBounds(600, 300, 200, 200);
        depositB.setCursor(cursor);
        depositB.setOpaque(false);
        depositB.setContentAreaFilled(false);
        depositB.setBorderPainted(false);
        c.add(depositB);
        depositB.addActionListener(e -> {
            if (PINVerify(PIN)){
                ImageIcon depo = new ImageIcon(getClass().getResource("depo.png"));
                String x = (String) JOptionPane.showInputDialog(null, "Enter Deposit amount: ", "Deposit", JOptionPane.QUESTION_MESSAGE, depo, null, null);
                double d = Double.parseDouble(x);
                if (d < 0){
                    ImageIcon err = new ImageIcon(getClass().getResource("err.png"));
                    JOptionPane.showMessageDialog(null, "Invalid Deposit amount!", "Amount Error!",JOptionPane.ERROR_MESSAGE, err);
                }
                else {
                    Blnce = Blnce + d;
                    ImageIcon dn = new ImageIcon(getClass().getResource("done.png"));
                    JOptionPane.showMessageDialog(null, "Deposit Successful! New Balance: "+Blnce+" tk", "Operation Done", JOptionPane.INFORMATION_MESSAGE, dn);
                }
            }
            else {
                ImageIcon lock = new ImageIcon(getClass().getResource("lock.png"));
                JOptionPane.showMessageDialog(null, "Your Account Has Been Locked!","Account Compromised!",JOptionPane.ERROR_MESSAGE, lock);
                System.exit(0);
            }
        });
        
        ImageIcon exit = new ImageIcon(getClass().getResource("exit.png"));
        exitB = new JButton(exit);
        exitB.setBounds(870, 320, 150, 150);
        exitB.setCursor(cursor);
        exitB.setOpaque(false);
        exitB.setContentAreaFilled(false);
        exitB.setBorderPainted(false);
        c.add(exitB);
        exitB.addActionListener(e -> {
            int optn = JOptionPane.showOptionDialog(null,"Are you sure?","Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,   null,  new Object[]{"Exit", "Cancel"},  "Exit");
            if (optn == JOptionPane.YES_OPTION) 
                System.exit(0);
        });
        
        ImageIcon img = new ImageIcon(getClass().getResource("UI.jpg"));
        Image scaledImage = img.getImage().getScaledInstance(1100, 629, Image.SCALE_SMOOTH);
        background = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1100, 629);
        c.add(backgroundLabel);
    }
    
    boolean PINVerify (String PIN){
        for (int i=1; i<=3; i++){
            ImageIcon pin = new ImageIcon(getClass().getResource("cpin.png"));
            ImageIcon wpin = new ImageIcon(getClass().getResource("ppin.png"));
            String x = (String) JOptionPane.showInputDialog(null,"Enter PIN: ", "PIN Verification", JOptionPane.QUESTION_MESSAGE, pin, null, null);
            if (x.equals(PIN)){
                return true;
            }
            else
                JOptionPane.showMessageDialog(null, "Wrong PIN!", "Verification Error!", JOptionPane.ERROR_MESSAGE, wpin);
        }
        return false;
    }
}
