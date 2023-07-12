package QuizApplication.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JButton rules,back;
    JTextField nameTxt;

    public Login() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("QuizApplication/images/login1.jpg"));
        JLabel image = new JLabel(img1);
        image.setBounds(-70,-100,600,600);
        add(image);

        JLabel heading = new JLabel("Master Minds");
        heading.setBounds(800,40,300,45);
        heading.setFont(new Font("Times New Roman",Font.BOLD,45));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel name = new JLabel("Enter your name: ");
        name.setBounds(620,130,300,40);
        name.setFont(new Font("Hang-latter",Font.BOLD,30));
        name.setForeground(new Color(217, 73, 73));
        add(name);

        nameTxt = new JTextField();
        nameTxt.setBounds(900,130,300,35);
        nameTxt.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(21,59,206)));
        nameTxt.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        add(nameTxt);

        rules = new JButton("Rules");
        rules.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rules.setForeground(Color.BLACK);
        rules.setBackground(new Color(186, 173, 197));
        rules.setBounds(950,250,130,40);
        rules.addActionListener(this);
        add(rules);

        back = new JButton("Back");
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setForeground(Color.BLACK);
        back.setBackground(new Color(186, 173, 197));
        back.setBounds(750,250,130,40);
        back.addActionListener(this);
        add(back);



        setSize(1250,450);
        setLocation(150,200);
        setTitle("Quiz");
        setVisible(true);

    }

    public static void main(String[] args) {
        new Login();     // Anonymous object

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rules) {
            String name = nameTxt.getText();
            setVisible(false);
            new Rules(name);


        } else if (e.getSource() == back) {
            setVisible(false);
        }

    }
}
