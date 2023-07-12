package QuizApplication.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start,back;

    Rules(String name){
        this.name = name;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Hello " + name + ", Welcome to Master Minds");
        heading.setBounds(150,20,700,50);
        heading.setFont(new Font("Times New Roman",Font.BOLD,28 ));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(50,90,700,400);
        rules.setFont(new Font("Thoma",Font.PLAIN,16 ));
        rules.setForeground(Color.black);
        rules.setText(
                "<html>"+
                        "                            READ ALL THE RULES CAREFULLY :-                        " + "<br><br>" +
                        "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                        "2. Make sure that you know the basics of the Java Programming before starting the Quiz" + "<br><br>" +
                        "3. Attempt all the question Carefully.  " + "<br><br>" +
                        "4. You will be given four options for every Questions." + "<br><br>" +
                        "5. For every Correct answer you will be provided 10 marks and none for incorrect" + "<br><br>" +
                        "6. You will get your Score at the END OF QUIZ. " + "<br><br>" +
                        "7. Do not get nervous where you stuck ' You will have a LIFELINE OF 50-50 ' which you can use only once " + "<br><br>" +
                        "8. May you know more than what John Snow knows 😂😂 Jokes Apart !! , Good Luck" + "<br><br>" +
                "<html>"
        );
        add(rules);


        start = new JButton("Start");
        start.setCursor(new Cursor(Cursor.HAND_CURSOR));
        start.setForeground(Color.BLACK);
        start.setBackground(new Color(186, 173, 197));
        start.setBounds(150,500,130,40);
        start.addActionListener(this);
        add(start);

        back = new JButton("Back");
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setForeground(Color.BLACK);
        back.setBackground(new Color(186, 173, 197));
        back.setBounds(450,500,130,40);
        back.addActionListener(this);
        add(back);



        setSize(800,650);
        setLocation(350,150);
        setTitle("Game Rules");
        setVisible(true);




    }

    public static void main(String[] args) {
        new Rules("User");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start){
            setVisible(false);
            new Quiz(name);

        } else if (e.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }
}
