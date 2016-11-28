import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

class Admin extends User
{
	JFrame frame = new JFrame("Admin");
	JPanel panel = new JPanel();
	JButton but2 = new JButton("Departments");JButton but1 = new JButton("Home");JButton but3 = new JButton("Staff");JButton but4 = new JButton("Requests");JButton but6= new JButton("Logout");JButton but5 = new JButton("Reports");
	
	Admin(String UserName,int UserID, String Password, String name, String address, String userType,String department, String dob)
	{
		super(UserName,UserID,Password,name,address,userType,"Admin",dob);
	}
	
	public void adminGUI()
	{
		frame.setSize(600, 400);
		but6.setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(but1);panel.add(but2);panel.add(but3);panel.add(but4);panel.add(but5);panel.add(but6);
		frame.add(panel);
		panel.setVisible(true);
		frame.setVisible(true);
		Event e = new Event();
		but1.addActionListener(e);
		but1.setActionCommand("Home");
		but2.addActionListener(e);
		but2.setActionCommand("Departments");
		but3.addActionListener(e);
		but3.setActionCommand("Staff");
		but4.addActionListener(e);
		but4.setActionCommand("Requests");
		but5.addActionListener(e);
		but5.setActionCommand("Reports");
		but5.addActionListener(e);
		but6.setActionCommand("Logout");
		but6.addActionListener(e);
		
	}
	public class Event implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand()=="Departments"){
				but2.setBackground(Color.pink);
				but1.setBackground(null);
				but3.setBackground(null);
				but4.setBackground(null);
				but5.setBackground(null);
			}	
			if(e.getActionCommand()=="Home"){
				but1.setBackground(Color.pink);	
				but2.setBackground(null);
				but3.setBackground(null);
				but4.setBackground(null);
				but5.setBackground(null);
			}
			if(e.getActionCommand()=="Staff"){
				but3.setBackground(Color.pink);
				but1.setBackground(null);
				but2.setBackground(null);
				but4.setBackground(null);
				but5.setBackground(null);
			}
			if(e.getActionCommand()=="Requests"){
				but4.setBackground(Color.pink);
				but1.setBackground(null);
				but3.setBackground(null);
				but5.setBackground(null);
				but2.setBackground(null);
		}			
			if(e.getActionCommand()=="Reports"){
				but5.setBackground(Color.pink);
				but1.setBackground(null);
				but3.setBackground(null);
				but4.setBackground(null);
				but2.setBackground(null);
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
	
}}