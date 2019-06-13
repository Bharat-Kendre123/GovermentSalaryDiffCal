package employee.steps;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeforeJulyIncrement implements ActionListener {


    public static String firstStep = "1.ENTER B.P,G.P AND SELECT \"PAY BAND\"";
    public static String secondStep = "2.ENTER HRA,TA,WA ETC..";
    public static String thirdStep = "3.SELECT NON PROMOTIONAL DURATION";
    public static String forthStep = "4.PRESS \"PROGRESS\" BUTTON";
    public static String fifthStep = "5.SELECT \"BEFORE JULY\" FROM \"PROMOTION DROPDOWN\"";
    public static String sixthStep = "6.CHANGE THE \"PAY BAND\"";
    public static String seventhStep = "7.SELECT DURATION FROM \"PROMOTION DAY\" TO NEXT \"JUNE MONTH\"";
    public static String eightStep = "8.PRESS \"PROMOTION\" BUTTION";
    public static String nighthStep = "9.SELECT \"DOUBLE\" FROM \"INCREMENT DROPDOWN\"";
    public static String tenthStep = "10.SELECT DURATION FROM \"JULY MONTH\" TO LAST DAY";
    public static String eleventhstep = "11.PRESS \"PROMOTION\" BUTTION";
    public static String twelthStep = "12.PRESS \"DONE\" BUTTION";


    JFrame f;

    JLabel title;
    JLabel firstStepLabel;
    JLabel secondStepLabel;
    JLabel thirdStepLabel;
    JLabel forthStepLabel;
    JLabel fifthStepLabel;
    JLabel sixthStepLabel;
    JLabel seventhStepLabel;
    JLabel eighthStepLabel;
    JLabel ninethStepLabel;
    JLabel tenthStepLabel;
    JLabel eleventhStepLable;
    JLabel twelthStepLable;


    JButton closeButton;

    public static final int hieght = 40;
    public static final int xaxix = 10;
    public static final int width = 730;

    public BeforeJulyIncrement(String step) {
        f = new JFrame("Steps");
        f.setLocation(new Point(600, 0));
        f.setResizable(false);

        title = new JLabel("BEFORE JULY INCREMENT STEPS :-");
        title.setBounds(xaxix, 10, width, 30);
        title.setFont(new Font("Courier New", Font.ITALIC, 12));
        title.setFont(title.getFont().deriveFont(22.0f));
        f.add(title);

        firstStepLabel = new JLabel(firstStep);
        firstStepLabel.setBounds(xaxix, 60, width, 30);
        firstStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        firstStepLabel.setFont(firstStepLabel.getFont().deriveFont(20.0f));
        f.add(firstStepLabel);

        secondStepLabel = new JLabel(secondStep);
        secondStepLabel.setBounds(xaxix, 60 + hieght, width, 50);
        secondStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        secondStepLabel.setFont(firstStepLabel.getFont().deriveFont(20.0f));
        f.add(secondStepLabel);


        thirdStepLabel = new JLabel(thirdStep);
        thirdStepLabel.setBounds(xaxix, 100 + hieght, width, 50);
        thirdStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        thirdStepLabel.setFont(thirdStepLabel.getFont().deriveFont(20.0f));
        f.add(thirdStepLabel);

        forthStepLabel = new JLabel(forthStep);
        forthStepLabel.setBounds(xaxix, 150 + hieght, width, 50);
        forthStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        forthStepLabel.setFont(forthStepLabel.getFont().deriveFont(20.0f));
        f.add(forthStepLabel);

        fifthStepLabel = new JLabel(fifthStep);
        fifthStepLabel.setBounds(xaxix, 200 + hieght, width, 50);
        fifthStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        fifthStepLabel.setFont(fifthStepLabel.getFont().deriveFont(20.0f));
        f.add(fifthStepLabel);

        sixthStepLabel = new JLabel(sixthStep);
        sixthStepLabel.setBounds(xaxix, 250 + hieght, width, 50);
        sixthStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        sixthStepLabel.setFont(sixthStepLabel.getFont().deriveFont(20.0f));
        f.add(sixthStepLabel);

        seventhStepLabel = new JLabel(seventhStep);
        seventhStepLabel.setBounds(xaxix, 300 + hieght, width, 50);
        seventhStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        seventhStepLabel.setFont(seventhStepLabel.getFont().deriveFont(20.0f));
        f.add(seventhStepLabel);

        eighthStepLabel = new JLabel(eightStep);
        eighthStepLabel.setBounds(xaxix, 350 + hieght, width, 50);
        eighthStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        eighthStepLabel.setFont(eighthStepLabel.getFont().deriveFont(20.0f));
        f.add(eighthStepLabel);

        ninethStepLabel = new JLabel(nighthStep);
        ninethStepLabel.setBounds(xaxix, 400 + hieght, width, 50);
        ninethStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        ninethStepLabel.setFont(ninethStepLabel.getFont().deriveFont(20.0f));
        f.add(ninethStepLabel);

        tenthStepLabel = new JLabel(tenthStep);
        tenthStepLabel.setBounds(xaxix, 450 + hieght, width, 50);
        tenthStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        tenthStepLabel.setFont(tenthStepLabel.getFont().deriveFont(20.0f));
        f.add(tenthStepLabel);

        eleventhStepLable = new JLabel(eleventhstep);
        eleventhStepLable.setBounds(xaxix, 500 + hieght, width, 50);
        eleventhStepLable.setFont(new Font("Courier New", Font.ITALIC, 12));
        eleventhStepLable.setFont(eleventhStepLable.getFont().deriveFont(20.0f));
        f.add(eleventhStepLable);

        twelthStepLable = new JLabel(twelthStep);
        twelthStepLable.setBounds(xaxix, 550 + hieght, width, 50);
        twelthStepLable.setFont(new Font("Courier New", Font.ITALIC, 12));
        twelthStepLable.setFont(twelthStepLable.getFont().deriveFont(20.0f));
        f.add(twelthStepLable);


        closeButton = new JButton("CLOSE");
        closeButton.setBounds(150 - xaxix, 600 + hieght, 400, 50);
        closeButton.addActionListener(this);
        closeButton.setFont(new Font("Courier New", Font.ITALIC, 20));
        f.add(closeButton);

        f.setSize(740, 800);
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
        new BeforeJulyIncrement("swd");
    }
}





