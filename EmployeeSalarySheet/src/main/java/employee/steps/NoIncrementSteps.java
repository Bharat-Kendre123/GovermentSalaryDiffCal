package employee.steps;


import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NoIncrementSteps implements ActionListener{



	public static String firstStep="1. ENTER B.P,G.P AND SELECT \"PAY BAND\"";
	public static String secondStep="2. ENTER HRA,TA,WA ETC..";
	public static String thirdStep="3. SELECT \"FROM DATE\" AND \"TO DATE\"";
	public static String forthStep="4. PRESS \"NO-INCREMENT\" BUTTON";
	public static String fifthStep="5. PRESS \"DONE\" BUTTON";
	
	

	JFrame f;
	
	JLabel title;
	JLabel firstStepLabel;
	JLabel secondStepLabel;
	JLabel thirdStepLabel;
	JLabel forthStepLabel;
	JLabel fifthStepLabel;
	JButton closeButton;
	
	public static final int hieght=40;
	public static final int width=550;
	public static final int margin=10;
	public NoIncrementSteps(String step)
	{
		f=new JFrame("Steps");
		f.setLocation(new Point(600,0));

		title =new JLabel("NO-INCREMENT STEPS :-");
		title.setBounds(margin,100, width,30);
		title.setFont(new Font("Courier New", Font.ITALIC, 12));
		title.setFont (title.getFont ().deriveFont (22.0f));
		f.add(title);
		
		firstStepLabel =new JLabel(firstStep);
		firstStepLabel.setBounds(margin,170, width,30);
		firstStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		firstStepLabel.setFont (firstStepLabel.getFont ().deriveFont (20.0f));
		f.add(firstStepLabel);
		
		secondStepLabel =new JLabel(secondStep);
		secondStepLabel.setBounds(margin, 170+hieght, width, 50);
		secondStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		secondStepLabel.setFont (firstStepLabel.getFont ().deriveFont (20.0f));
		f.add(secondStepLabel);
		
		
		thirdStepLabel =new JLabel(thirdStep);
		thirdStepLabel.setBounds(margin, 220+hieght, width, 50);
		thirdStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		thirdStepLabel.setFont (firstStepLabel.getFont ().deriveFont (20.0f));
		f.add(thirdStepLabel);
		
		forthStepLabel =new JLabel(forthStep);
		forthStepLabel.setBounds(margin, 270+hieght, width, 50);
		forthStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		forthStepLabel.setFont (forthStepLabel.getFont ().deriveFont (20.0f));
		f.add(forthStepLabel);
		
		fifthStepLabel =new JLabel(fifthStep);
		fifthStepLabel.setBounds(margin, 320+hieght, width, 50);
		fifthStepLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
		fifthStepLabel.setFont (fifthStepLabel.getFont ().deriveFont (20.0f));
		f.add(fifthStepLabel);
		
		closeButton=new JButton("CLOSE");
		closeButton.setBounds(70, 520+hieght, 400, 60);
		closeButton.setFont(new Font("Courier New", Font.ITALIC, 20));
		closeButton.addActionListener(this);
		f.add(closeButton);
		
		f.setSize(580, 700);
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
		new NoIncrementSteps("swd");
	}
}

