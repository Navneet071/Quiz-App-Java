package QuizApplication.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {


    JLabel heading,scored;
    JButton playAgain, exit;

    Score(String name, int score){
        setBounds(600,150,750,550);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("QuizApplication/images/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(50,100,300,250);
        add(img);

        heading = new JLabel("Thank-you !!! " + name + " for playing Master Minds :)");
        heading.setBounds(140,10, 800, 50);
        heading.setFont(new Font("Arial", Font.PLAIN, 25));
        add(heading);

        scored = new JLabel("Your Score is: "+ score);
        scored.setBounds(450,200, 300, 50);
        scored.setFont(new Font("Thoma", Font.PLAIN, 25));
        add(scored);

        playAgain = new JButton("Play Again ");
        playAgain.setCursor(new Cursor(Cursor.HAND_CURSOR));
        playAgain.setBounds(400, 280, 130, 40);
        playAgain.setBackground(new Color(255,0,79));
        playAgain.setForeground(new Color(255,255,255));
        playAgain.setFont(new Font("Thoma", Font.BOLD, 15));
        playAgain.addActionListener(this);
        add(playAgain);

        exit = new JButton("Exit");
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.setBounds(580, 280, 130, 40);
        exit.setBackground(new Color(255,0,79));
        exit.setForeground(new Color(255, 255, 255));
        exit.addActionListener(this);
        add(exit);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playAgain){
            setVisible(false);
            new Login();
        } else if (e.getSource() == exit){
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
