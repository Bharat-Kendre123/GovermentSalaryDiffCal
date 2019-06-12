package employee.steps;


import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AfterJulyIncrementSteps implements ActionListener{



	public static String firstStep="1. ENTER B.P,G.P, AND SELECT \"PAY BAND\"";
	public static String secondStep="2. ENTER HRA,TA,WA ETC..";
	public static String thirdStep="3. SELECT NON PROMOTIONAL DURATION";
	public static String forthStep="4. PRESS \"PROGRESS\" BUTTON";
	public static String fifthStep="5. SELECT \"AFTER JULY\" FROM \"PROMOTION DROPDOWN\"";
	public static String sixthStep="6. CHANGE THE \"G.P\" AND \"PAY BAND\"";
	public static String seventhStep="7. SELECT DURATION FROM PROMOTION DAY TO LAST DAY";
	public static String eightStep="8. PRESS \"PROGRESS\" BUTTION";
	public static String nighth="9. PRESS \"DONE\" BUTTION";
	
	

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
	
	JButton closeButton;
	
	public static final int hieght=40;
	public static final int xaxix=10;
	public static final int width=600;
	
	public AfterJulyIncrementSteps(String step)
	{
		f=new JFrame("Steps");
		f.setResizable(false);
		f.setLocation(new Point(600,0));
		title =new JLabel("AFTER JULY INCREMENT STEPS :-");
		title.setBounds(xaxix,50, width,30);
		title.setFont(new Font("Courier New", Font.ITALIC, 12));
		title.setFont (title.getFont ().deriveFont (22.0f));
		f.add(title);
		
		firstStepLabel =new JLabel(firstStep);
		firstStepLabel.setBounds(xaxix,110, width,30);
		firstStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		firstStepLabel.setFont (firstStepLabel.getFont ().deriveFont (20.0f));
		f.add(firstStepLabel);
		
		secondStepLabel =new JLabel(secondStep);
		secondStepLabel.setBounds(xaxix, 110+hieght, width, 50);
		secondStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		secondStepLabel.setFont (firstStepLabel.getFont ().deriveFont (20.0f));
		f.add(secondStepLabel);
		
		
		thirdStepLabel =new JLabel(thirdStep);
		thirdStepLabel.setBounds(xaxix, 160+hieght, width, 50);
		thirdStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		thirdStepLabel.setFont (thirdStepLabel.getFont ().deriveFont (20.0f));
		f.add(thirdStepLabel);
		
		forthStepLabel =new JLabel(forthStep);
		forthStepLabel.setBounds(xaxix, 210+hieght, width, 50);
		forthStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		forthStepLabel.setFont (forthStepLabel.getFont ().deriveFont (20.0f));
		f.add(forthStepLabel);
		
		fifthStepLabel =new JLabel(fifthStep);
		fifthStepLabel.setBounds(xaxix, 260+hieght, width, 50);
		fifthStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		fifthStepLabel.setFont (fifthStepLabel.getFont ().deriveFont (20.0f));
		f.add(fifthStepLabel);
		
		sixthStepLabel =new JLabel(sixthStep);
		sixthStepLabel.setBounds(xaxix, 310+hieght, width, 50);
		sixthStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		sixthStepLabel.setFont (sixthStepLabel.getFont ().deriveFont (20.0f));
		f.add(sixthStepLabel);
		
		seventhStepLabel =new JLabel(seventhStep);
		seventhStepLabel.setBounds(xaxix, 360+hieght, width, 50);
		seventhStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		seventhStepLabel.setFont (seventhStepLabel.getFont ().deriveFont (20.0f));
		f.add(seventhStepLabel);
		
		eighthStepLabel =new JLabel(eightStep);
		eighthStepLabel.setBounds(xaxix, 410+hieght, width, 50);
		eighthStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		eighthStepLabel.setFont (eighthStepLabel.getFont ().deriveFont (20.0f));
		f.add(eighthStepLabel);
		
		ninethStepLabel =new JLabel(nighth);
		ninethStepLabel.setBounds(xaxix, 460+hieght, width, 50);
		ninethStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		ninethStepLabel.setFont (ninethStepLabel.getFont ().deriveFont (20.0f));
		f.add(ninethStepLabel);
		
		closeButton=new JButton("CLOSE");
		closeButton.setBounds(100-xaxix, 530+hieght, 400, 60);
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
	
	public static void main(String []a)
	{
		new AfterJulyIncrementSteps("swd");
	}
}


