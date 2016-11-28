import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Supervisor extends User {
	JFrame frame = new JFrame("FMS System : Supervisor");
	JPanel panel = new JPanel();
	JButton buttons[] = new JButton[6];
	String name[] = {"Home","Send LEave","Staff","Requests","Reports","Logout"};
	
	Supervisor(String UserName,int UserID, String Password, String name, String address, String userType,String department, String dob)
	{
		super(UserName,UserID,Password,name,address,userType,"Supervisor",dob);
	}
	public void supGUI()
	{
		frame.setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setVisible(true);
		frame.setVisible(true);
		Event e = new Event();
		for(int i=0;i<6;i++){
			buttons[i].addActionListener(e);
			buttons[i].setActionCommand(name[i]);
			panel.add(buttons[i]);
		}
		buttons[6].setBackground(Color.white);
	}
	public class Event implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand()=="Home"){
				for(int i=0;i<6;i++)
				{if(buttons[i].getText()!="Home")buttons[i].setBackground(null);
				else buttons[i].setBackground(Color.PINK);}
			}
			if(e.getActionCommand()=="Departments"){
				for(int i=0;i<6;i++)
				{if(buttons[i].getText()!="Departments")buttons[i].setBackground(null);
				else buttons[i].setBackground(Color.PINK);}
			}	
			
			if(e.getActionCommand()=="Staff"){
				for(int i=0;i<6;i++)
				{if(buttons[i].getText()!="Staff")buttons[i].setBackground(null);
				else buttons[i].setBackground(Color.PINK);}
			}
			if(e.getActionCommand()=="Requests"){
				for(int i=0;i<6;i++)
				{if(buttons[i].getText()!="Requests")buttons[i].setBackground(null);
				else buttons[i].setBackground(Color.PINK);}
			}			
			if(e.getActionCommand()=="Reports"){
				for(int i=0;i<6;i++)
				{if(buttons[i].getText()!="Reports")buttons[i].setBackground(null);
				else buttons[i].setBackground(Color.PINK);}
			}
			if(e.getActionCommand()=="Logout"){
				frame.remove(panel);
				frame.dispose();
				system S = new system();
				S.noUsers=0;
				S.readFileUsers();
				S.mainGUI();
			}
			
	}
}
}
