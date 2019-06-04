package employee.steps;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StepButtons implements ActionListener{

	JLabel heading;
	JFrame f;
	JButton regularIncrement;
	JButton noIncrement;
	JButton stopIncrement;
	JButton beforeJulyIncrement;
	JButton afterJulyIncrement;
	JButton trippleOrSixTimeIncrement;
	JButton closeButton;

	public static final int hieght=90;
	public static void main(String [] a)
	{
		new StepButtons();
	}

	public StepButtons()
	{
		f=new JFrame("Steps Window");
		f.setLocation(new Point(600,0));
		f.setResizable(false);
		heading =new JLabel("CLICK THE BUTTON TO GET STEPS");
		heading.setBounds(50,50, 500,30);
		heading.setFont(new Font("Courier New", Font.ITALIC, 12));
		heading.setFont (heading.getFont ().deriveFont (24.0f));
		heading.setForeground(Color.DARK_GRAY);
		f.add(heading);
		
		
		regularIncrement=new JButton("REGULAR INCREMENT");
		regularIncrement.setBounds(50, 50+hieght, 400, 50);
		regularIncrement.addActionListener(this);
		regularIncrement.setFont(new Font("Courier New", Font.ITALIC, 20));
		f.add(regularIncrement);
		
		noIncrement=new JButton("NO-INCREMENT");
		noIncrement.setBounds(50, 120+hieght, 400, 50);
		noIncrement.setFont(new Font("Courier New", Font.ITALIC, 20));
		noIncrement.addActionListener(this);
		f.add(noIncrement);
		
		stopIncrement=new JButton("STOP INCREMENT");
		stopIncrement.setBounds(50, 190+hieght, 400, 50);
		stopIncrement.setFont(new Font("Courier New", Font.ITALIC, 20));
		stopIncrement.addActionListener(this);
		f.add(stopIncrement);
		
		beforeJulyIncrement=new JButton("BEFORE JULY INCREMENT");
		beforeJulyIncrement.setBounds(50, 260+hieght, 400, 50);
		beforeJulyIncrement.setFont(new Font("Courier New", Font.ITALIC, 20));
		beforeJulyIncrement.addActionListener(this);
		f.add(beforeJulyIncrement);
		
		afterJulyIncrement=new JButton("AFTER JULY INCREMENT");
		afterJulyIncrement.setBounds(50, 330+hieght, 400, 50);
		afterJulyIncrement.setFont(new Font("Courier New", Font.ITALIC, 20));
		afterJulyIncrement.addActionListener(this);
		f.add(afterJulyIncrement);
		
		trippleOrSixTimeIncrement=new JButton("TRIPPLE/SIXTIME INCREMENT");
		trippleOrSixTimeIncrement.setBounds(50, 400+hieght, 400, 50);
		trippleOrSixTimeIncrement.setFont(new Font("Courier New", Font.ITALIC, 20));
		trippleOrSixTimeIncrement.addActionListener(this);
		f.add(trippleOrSixTimeIncrement);
		
		closeButton=new JButton("CLOSE");
		closeButton.setBounds(50, 500+hieght, 400, 50);
		closeButton.setFont(new Font("Courier New", Font.ITALIC, 20));
		closeButton.addActionListener(this);
		f.add(closeButton);
		
		f.setSize(530, 700);
	    f.setLayout(null);  
	    f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		f.dispose();
		if(e.getSource()==regularIncrement)
		{		
			new NormalIncrementSteps("REGULARINCREMENT");	
		}else if(e.getSource()==noIncrement)
		{
			new NoIncrementSteps("NO-INCREMENT");
		}
		else if(e.getSource()==afterJulyIncrement)
		{
			new AfterJulyIncrementSteps("AFTER JULY INCREMENT");
		}else if(e.getSource()==beforeJulyIncrement)
		{
			new BeforeJulyIncrement("BEFORE JULY INCREMENT");
		}else if(e.getSource()==stopIncrement)
		{
			new StopIncrementSteps("STOP INCREMENT");
		}
		else if(e.getSource()==trippleOrSixTimeIncrement)
		{
			new TrippleOrSixTimeIncrement("STOP INCREMENT");
		}else if(e.getSource()==closeButton)
		{
			f.dispose();
		}
		
	}

	
	
}
