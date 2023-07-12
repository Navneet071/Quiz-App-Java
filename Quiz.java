package QuizApplication.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

    static String[][] questions = new String[10][5];
    static String[][] answers = new String[10][2];
    static String[][] userAns = new String[10][2];

    static JLabel qno;
    static JLabel que;
    static JRadioButton opt1, opt2, opt3,opt4;
    static JButton lyfLine, next, submit;

    static int timer = 15;
    static int ans_given = 0;
    static int count=0;

    static ButtonGroup groupOptions;

    static int score = 0;
    static String name;

    Quiz(String name){
        this.name = name;
//        setSize(1240,800);
//        setLocation(50,10);
        setBounds(50,10,1240,800);
        getContentPane().setBackground(Color.white);
        setTitle("Quiz made by: NAVNEET BARANWAL");
        setLayout(null);

        ImageIcon img2 = new ImageIcon(ClassLoader.getSystemResource("QuizApplication/images/quiz1.png"));
        Image i2 = img2.getImage().getScaledInstance(1200,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1200,350);
        add(img);

//        JLabel image = new JLabel(img2);
//        image.setBounds(0,0,1240,400);
//        add(image);

        qno = new JLabel();
        qno.setBounds(100,400, 50, 100);
        qno.setFont(new Font("Arial", Font.PLAIN, 20));
        add(qno);

        que = new JLabel();
        que.setBounds(120,400,800,100);
        que.setFont(new Font("Arial", Font.PLAIN, 20));
        add(que);




        // Arrays of QUESTIONS
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        // Array of ANSWERS

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";


        opt1 = new JRadioButton();
        opt1.setBounds(120, 500, 600, 30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog", Font.PLAIN,20));
        add(opt1);



        opt2 = new JRadioButton();
        opt2.setBounds(120, 530, 600, 30);
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("Dialog", Font.PLAIN,20));
        add(opt2);


        opt3 = new JRadioButton();
        opt3.setBounds(120, 560, 600, 30);
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("Dialog", Font.PLAIN,20));
        add(opt3);


        opt4 = new JRadioButton();
        opt4.setBounds(120, 590, 600, 30);
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("Dialog", Font.PLAIN,20));
        add(opt4);

        groupOptions = new ButtonGroup();
        groupOptions.add(opt1);
        groupOptions.add(opt2);
        groupOptions.add(opt3);
        groupOptions.add(opt4);


        lyfLine = new JButton("50-50");
        lyfLine.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lyfLine.setBounds(1000, 490,130,40);
        lyfLine.setFont(new Font("Thoma", Font.ROMAN_BASELINE, 13));
        lyfLine.addActionListener(this);
        add(lyfLine);


        next = new JButton("Next");
        next.setCursor(new Cursor(Cursor.HAND_CURSOR));
        next.setBounds(1000, 570,130,40);
        next.setFont(new Font("Thoma", Font.ROMAN_BASELINE, 13));
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.setBounds(1000, 650, 130, 40);
        submit.setFont(new Font("Thoma", Font.BOLD, 15));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

//        obj1.setBounds();
        for (int i = 0; i < 10; i++) {
            start(count);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next){            // Action on "Next"  Button
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            ans_given = 1;
            if (groupOptions.getSelection() == null){
                userAns[count][0] = "";
            }else {
                userAns[count][0] = groupOptions.getSelection().getActionCommand();
            }
            if (count == 8){                // At 2nd last que we have to disable the next button ans enable the Submit Button
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);


        } else if (e.getSource() == lyfLine) {          // Action on lyfLine Button
             if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9){
                 opt2.setEnabled(false);
                 opt3.setEnabled(false);
             }else {
                 opt1.setEnabled(false);
                 opt4.setEnabled(false);
             }
             lyfLine.setEnabled(false);
        } else if (e.getSource() == submit) {                // Action on Submit Button clicked by User
            ans_given = 1;
            if (groupOptions.getSelection() == null){
                userAns[count][0] = "";

            }else {
                userAns[count][0] = groupOptions.getSelection().getActionCommand();
            }

            // SCORE CALCULATION

            for (int i = 0; i < userAns.length; i++) {
                if (userAns[i][0].equals(answers[i][1])){
                    score += 10;
                }
            }
            setVisible(false);
            // Here now display the Score Page
            new Score(name,score);


        }

    }

    public void paint(Graphics g){              // paint() is automatically called as default constructor
        super.paint(g);

        String time = "Time Left: " + timer + " Seconds--";

        g.setColor(Color.red);
        g.setFont(new Font("Tahoma", Font.BOLD,18));

        if (timer > 0){
            g.drawString(time,950,490);
        }else {
            g.drawString("Times Up !!!",950,490);

        }
        timer--;

        try{
            Thread.sleep(1000);
            repaint();
        }catch (Exception e){
            System.out.println(e);
        }

        if (ans_given == 1){
            ans_given = 0;           // For next Question
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8){                // At 2nd last que we have to disable the next button ans enable the Submit Button
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9){                 // Auto Submit Enable case

                if (groupOptions.getSelection() == null){
                    userAns[count][0] = "";

                }else {
                    userAns[count][0] = groupOptions.getSelection().getActionCommand();
                }

                // SCORE CALCULATION

                for (int i = 0; i < userAns.length; i++) {
                    if (userAns[i][0].equals(answers[i][1])){
                            score += 10;
                    }
                }
                setVisible(false);
                // Here now display the Score Page
                new Score(name,score);


            }else {                        // Next btn case

                if (groupOptions.getSelection() == null){
                    userAns[count][0] = "";

                }else {
                    userAns[count][0] = groupOptions.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }

        }


    }


    public static void start(int count){
        qno.setText(count+1 + ".");
        que.setText(questions[count][0]);

        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupOptions.clearSelection();
    }



    public static void main(String[] args) {
        new Quiz("User");
    }
}
