import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Supervisor extends User {
	JFrame frame = new JFrame("FMS System : Supervisor");
	JPanel panel = new JPanel();
	JButton but2 = new JButton("Send Leave");JButton but1 = new JButton("Home");JButton but3 = new JButton("Staff");JButton but4 = new JButton("Requests");JButton but5 = new JButton("Reports");JButton but6 = new JButton("Logout");
	
	Supervisor(String UserName,int UserID, String Password, String name, String address, String userType,String department, String dob)
	{
		super(UserName,UserID,Password,name,address,userType,"Supervisor",dob);
	}
	public void supGUI()
	{
		frame.setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(but1);panel.add(but2);panel.add(but3);panel.add(but4);panel.add(but5);panel.add(but6);
		frame.add(panel);
		panel.setVisible(true);
		frame.setVisible(true);
		Event e = new Event();
		but2.addActionListener(e);
		but2.setActionCommand("sendLeave");
		but1.addActionListener(e);
		but1.setActionCommand("Home");
		but3.addActionListener(e);
		but3.setActionCommand("Staff");
		but4.addActionListener(e);
		but4.setActionCommand("Requests");
		but5.addActionListener(e);
		but5.setActionCommand("Reports");
		but6.setActionCommand("Logout");
		but6.addActionListener(e);
		but6.setBackground(Color.white);
	}
	public class Event implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand()=="sendLeave"){
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
				but5.setBackground(null);Event l = new Event();
				JButton add = new JButton("Add Staff");add.addActionListener(l);
				JButton view1 = new JButton("View All Staff Members");view1.addActionListener(l);
				JButton view2 = new JButton("View Staff Member");view2.addActionListener(l);
				JButton delete = new JButton("Delete Staff Member");delete.addActionListener(l);
				panel.add(add);panel.add(view1);panel.add(view2);panel.add(delete);
				
			}
			if(e.getActionCommand()=="Requests"){
				but4.setBackground(Color.pink);
				but1.setBackground(null);
				but3.setBackground(null);
				but2.setBackground(null);
				but5.setBackground(null);
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
	}
}
