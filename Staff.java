import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Staff extends User{
	JFrame frame = new JFrame("Supervisor");
	JPanel panel = new JPanel();JButton buttons[] = new JButton[6];
	String name[] = {"Home","Send LEave","Staff","Requests","Reports","Logout"};
	ArrayList<Task> task= new ArrayList<Task>();
	Staff(String UserName,int UserID, String Password, String name, String address, String userType,String department, String dob)
	{
		super(UserName,UserID,Password,name,address,userType,department,dob);
	}
	public void getTaskReport(Task t){
		JFrame ta= new JFrame(t.getTaskName());
		JPanel pa = new JPanel();
		pa.setLayout(new BoxLayout(pa,BoxLayout.Y_AXIS));
		JLabel[] la = new JLabel[5];
		System.out.println(t.getTaskName());
		for(int i=0;i<5;i++)
			la[i]= new JLabel();
		la[0].setText("Task Name : " + t.getTaskName());//
		la[1].setText("Task ID : " + t.getTaskID());
		la[2].setText("Task Department : " + t.getTaskDept());
		la[3].setText("Task Start Date : " + t.getStartDate());
		la[4].setText("Task Deadline : " + t.getDeadline());
		for(int i=0;i<5;i++)
			pa.add(la[i]);
		ta.add(pa);
		ta.setSize(400,200);
		ta.setVisible(true);
	}
	public void staffGUI()
	{
		frame.setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setVisible(true);
		frame.setVisible(true);
		Event e = new Event();
		for(int i=0;i<6;i++){
			buttons[i]= new JButton(name[i]);
			buttons[i].addActionListener(e);
			buttons[i].setActionCommand(name[i]);
			panel.add(buttons[i]);
		}
		buttons[5].setBackground(Color.white);
	}
	public class Event implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{if(e.getActionCommand()=="Home"){
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
			Task t = new Task(new Date(),new Date(),"t","t","t");
			getTaskReport(t);
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
		//Task Report – ID, Task ID, Task Name, Task Description, Items used, Time Taken,
		//Comments.
		
		
	}
	

}