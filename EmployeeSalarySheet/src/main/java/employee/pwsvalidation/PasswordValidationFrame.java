package employee.pwsvalidation;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import employee.mainscreen.EmplyeeSalaryTemplate;

public class PasswordValidationFrame implements ActionListener{

	JFrame f;
	JTextField passwordTextField;
	JButton passwordButton;
	JLabel heading,wrongPws,welcomeText;
	
	 public static void main(String[] args) {
	        //new EmplyeeSalaryTemplate();
	    	new PasswordValidationFrame();
	    }

	public PasswordValidationFrame()
	{
		f=new JFrame("Authentication Window");
		
		welcomeText =new JLabel("WELCOME TO");
		welcomeText.setBounds(170,180, 500,30);
		welcomeText.setFont(new Font("Courier New", Font.ITALIC, 12));
		welcomeText.setFont (welcomeText.getFont ().deriveFont (24.0f));
		welcomeText.setForeground(Color.DARK_GRAY);
		f.add(welcomeText);
		
		heading =new JLabel("SALARY DIFFERENCE CALCULATOR");
		heading.setBounds(50,230, 500,30);
		heading.setFont(new Font("Courier New", Font.ITALIC, 12));
		heading.setFont (heading.getFont ().deriveFont (24.0f));
		heading.setForeground(Color.DARK_GRAY);
		f.add(heading);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(90,300, 300,30);
		//passwordTextField.setFont(f);
		f.add(passwordTextField);
		
		passwordButton=new JButton("ENTER   PASSWORD");
		passwordButton.setBounds(150, 360, 180, 60);
		passwordButton.addActionListener(this);
        f.add(passwordButton);
        wrongPws = new JLabel("WRONG PASSWORD");
        f.add(wrongPws);
        f.setSize(580, 700);
        f.setLayout(null);  
        f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String enteredPws=passwordTextField.getText();
		
		if("Amrendra".equalsIgnoreCase(enteredPws))
		{
			f.dispose();  //Remove JFrame 1
		      f.setVisible(true) ;//Show other frame
		      f.setVisible(false);
		      wrongPws.setText("");;
		      new EmplyeeSalaryTemplate();
		          
		}else{
			
			    wrongPws.setText("WRONG PASSWORD");;
				wrongPws.setFont (wrongPws.getFont ().deriveFont (24.0f));
				wrongPws.setForeground(Color.RED);
				wrongPws.setBounds(120,500, 280,30);
				//passwordTextField.setFont(f);
				
		}
	}
	
	
}
