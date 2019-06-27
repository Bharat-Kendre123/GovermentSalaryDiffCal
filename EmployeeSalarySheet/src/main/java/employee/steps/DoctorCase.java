package employee.steps;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorCase implements ActionListener {


    public static String firstStep = "1. ENTER B.P,G.P, DOCTOR AND SELECT \"PAY BAND\"";
    public static String secondStep = "2. ENTER HRA,TA,WA ETC..";
    public static String thirdStep = "3. SELECT DURATION";
    public static String forthStep = "4. PRESS \"PROGRESS\" BUTTON";
    public static String fifthStep = "5. PRESS \"DONE\" BUTTION\"";


    JFrame f;

    JLabel title;
    JLabel firstStepLabel;
    JLabel secondStepLabel;
    JLabel thirdStepLabel;
    JLabel forthStepLabel;
    JLabel fifthStepLabel;


    JButton closeButton;

    public static final int hieght = 40;
    public static final int xaxix = 10;
    public static final int width = 600;

    public DoctorCase(String step) {
        f = new JFrame("Steps");
        f.setResizable(false);
        f.setLocation(new Point(600, 0));
        title = new JLabel("SPECIAL DOCTOR CASE :-");
        title.setBounds(xaxix, 50, width, 30);
        title.setFont(new Font("Courier New", Font.ITALIC, 12));
        title.setFont(title.getFont().deriveFont(22.0f));
        f.add(title);

        firstStepLabel = new JLabel(firstStep);
        firstStepLabel.setBounds(xaxix, 110, width, 30);
        firstStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        firstStepLabel.setFont(firstStepLabel.getFont().deriveFont(20.0f));
        f.add(firstStepLabel);

        secondStepLabel = new JLabel(secondStep);
        secondStepLabel.setBounds(xaxix, 110 + hieght, width, 50);
        secondStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        secondStepLabel.setFont(firstStepLabel.getFont().deriveFont(20.0f));
        f.add(secondStepLabel);


        thirdStepLabel = new JLabel(thirdStep);
        thirdStepLabel.setBounds(xaxix, 160 + hieght, width, 50);
        thirdStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        thirdStepLabel.setFont(thirdStepLabel.getFont().deriveFont(20.0f));
        f.add(thirdStepLabel);

        forthStepLabel = new JLabel(forthStep);
        forthStepLabel.setBounds(xaxix, 210 + hieght, width, 50);
        forthStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        forthStepLabel.setFont(forthStepLabel.getFont().deriveFont(20.0f));
        f.add(forthStepLabel);

        fifthStepLabel = new JLabel(fifthStep);
        fifthStepLabel.setBounds(xaxix, 260 + hieght, width, 50);
        fifthStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        fifthStepLabel.setFont(fifthStepLabel.getFont().deriveFont(20.0f));
        f.add(fifthStepLabel);

        closeButton = new JButton("CLOSE");
        closeButton.setBounds(100 - xaxix, 530 + hieght, 400, 60);
        closeButton.setFont(new Font("Courier New", Font.ITALIC, 20));
        closeButton.addActionListener(this);
        f.add(closeButton);

        f.setSize(650, 700);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //f.setVisible(false);
        f.dispose();
    }

    public static void main(String[] a) {
        new DoctorCase("swd");
    }
}


