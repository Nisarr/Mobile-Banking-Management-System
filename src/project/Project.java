package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Font.ITALIC;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Project extends JFrame {
    private Container c;
    private ImageIcon background, icon;
    private JTextField tf, an;
    private JPasswordField pf;
    private JLabel userLabel, passLabel, accLabel;
    private JButton loginButton, clearButton, registerButton, forgotButton;
    private Cursor cursor;
    private Font f;
    private String PIN;
    
    Project()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1060, 601);
        this.setLocationRelativeTo(null);
        this.setTitle("Nisar's Bank Limited");
        
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        
        c = this.getContentPane();
        c.setLayout(null);
        
        f = new Font("Algerian", Font.BOLD, 22);
        
        cursor = new Cursor(Cursor.HAND_CURSOR);
        
        ImageIcon user = new ImageIcon(getClass().getResource("user.png"));
        userLabel = new JLabel(user);
        userLabel.setBounds(650, 150, 40, 40);
        c.add(userLabel);
        tf = new JTextField("Username");
        tf.setFont(f);
        tf.setBounds(700, 150, 300, 40);
        c.add(tf);
        
        ImageIcon accno = new ImageIcon(getClass().getResource("pass.png"));
        accLabel = new JLabel(accno);
        accLabel.setBounds(650, 200, 40, 40);
        c.add(accLabel);
        an = new JTextField("Account No.");
        an.setFont(f);
        an.setBounds(700, 200, 300, 40);
        c.add(an);
        
        ImageIcon pass = new ImageIcon(getClass().getResource("PIN.png"));
        passLabel = new JLabel(pass);
        passLabel.setBounds(650, 250, 40, 40);
        c.add(passLabel);
        pf = new JPasswordField("Password");
        pf.setFont(f);
        pf.setBounds(700, 250, 300, 40);
        c.add(pf);
        
        ImageIcon login = new ImageIcon(getClass().getResource("login.png"));
        loginButton = new JButton(login);
        loginButton.setBounds(700, 310, 140, 45);
        loginButton.setCursor(cursor);
        loginButton.setOpaque(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);
        c.add(loginButton);
        loginButton.addActionListener(e -> {
            String Name = tf.getText();
            String AccNo = an.getText();
            PIN = new String(pf.getPassword());
            if (AccNo.equals(AccNo) && PIN.equals(PIN)) {
                setVisible (false);
                dispose();
                UI ui = new UI(PIN);
                ui.setVisible (true);
                ImageIcon blnce = new ImageIcon(getClass().getResource("Blnce.png"));
                JOptionPane.showMessageDialog(null, "Your Starting Balance is 10000 tk","Starting Balance", JOptionPane.INFORMATION_MESSAGE,blnce);
            } else {
                JOptionPane.showMessageDialog(null, "Your password or username is invalid!", "Credintial Error!", JOptionPane.ERROR_MESSAGE, null);
            }
        });

        clearButton = new JButton("Clear");
        clearButton.setBounds(850, 310, 150, 45);
        Font f1 = new Font("Bauhaus 93", ITALIC, 22);
        clearButton.setFont(f1);
        clearButton.setBackground(Color.BLUE);
        clearButton.setCursor(cursor);
        c.add(clearButton);
        clearButton.addActionListener(e -> {
            tf.setText("");
            an.setText("");
            pf.setText("");
        });

        ImageIcon register = new ImageIcon(getClass().getResource("register.png"));
        registerButton = new JButton(register);
        registerButton.setBounds(500, 400, 200, 200);
        registerButton.setCursor(cursor);
        registerButton.setOpaque(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setBorderPainted(false);
        c.add(registerButton);
        registerButton.addActionListener(e -> {
            ImageIcon navailable = new ImageIcon(getClass().getResource("navailable.png"));
            JOptionPane.showMessageDialog(null, "This feature will be available very soon!\nPlease Contact with your Bank in Emergency...", "Account Registration",JOptionPane.INFORMATION_MESSAGE, navailable);
        });
        
        forgotButton = new JButton("Forgot Account Details?");
        forgotButton.setBounds(680, 360, 200, 20);
        forgotButton.setForeground(Color.RED);
        forgotButton.setCursor(cursor);
        forgotButton.setOpaque(false);
        forgotButton.setContentAreaFilled(false);
        forgotButton.setBorderPainted(false);
        c.add(forgotButton);
        forgotButton.addActionListener(e -> {
            ImageIcon navailable = new ImageIcon(getClass().getResource("navailable.png"));
            JOptionPane.showMessageDialog(null, "This feature will be available very soon!\nPlease Contact with your Bank in Emergency...", "Account Registration",JOptionPane.INFORMATION_MESSAGE, navailable);
        });

        ImageIcon img = new ImageIcon(getClass().getResource("bg.jpg"));
        Image scaledImage = img.getImage().getScaledInstance(1060, 601, Image.SCALE_SMOOTH);
        background = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1060, 601);
        c.add(backgroundLabel);
    }

    public static void main(String[] args) {
        Project BMS = new Project ();
        BMS.setVisible (true);
    }
}
