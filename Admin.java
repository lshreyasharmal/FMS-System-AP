import java.awt.Color;
import java.awt.TextField;
import java.awt.event.*;
import java.text.SimpleDateFormat;

import javax.swing.*;


public class Admin extends User{
	
	
	JFrame frame = new JFrame("FMS System : Admin");
	//Button Panel
	JButton buttons[] = new JButton[6];	
	
	JPanel panel = new JPanel();
	String name[] = {"Home","Departments","Staff","Requests","Reports","Logout"};
	JButton b1 = new JButton("Member Requests"); JButton b2 = new JButton("Leave Requests"); JButton b3 = new JButton("Logistics Requests");
   //create an object of Admin//Using Singleton Design Pattern
   private static Admin instance = new Admin();

   //constructor : private so that this class cannot be instantiated
   Admin()
	{super("Admin",0,"admin","Riddhi Jain","IIIT Delhi","Admin","Admin","31/01/1990");}

   //Get the only object available
   public static Admin getInstance(){
      return instance;
   }
   public void adminGUI()
	{
	   	String ddate = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	 	String ttime = new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());
	 	TextField date = new TextField(ddate);
	   	TextField time = new TextField(ttime);
	 
		frame.setSize(900, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		Event e = new Event();
		for(int i=0;i<6;i++){
			buttons[i] =new JButton(name[i]);
			buttons[i].setActionCommand(name[i]);
			buttons[i].addActionListener(e);
			panel.add(buttons[i]);
		}
		
		buttons[5].setBackground(Color.white);
		panel.add(date);panel.add(time);
		date.setColumns(10);time.setColumns(7);
		date.setEditable(false);time.setEditable(false);
		panel.setVisible(true);
		frame.setVisible(true);
	}
	public class Event implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand()=="Home"){
				for(int i=0;i<5;i++)
				{if(buttons[i].getText()!="Home")buttons[i].setBackground(null);
				else buttons[i].setBackground(Color.PINK);}
				buttons[5].setBackground(Color.white);
			}
			if(e.getActionCommand()=="Departments"){
				for(int i=0;i<5;i++)
				{if(buttons[i].getText().equals("Departments"))buttons[i].setBackground(Color.pink);
				else buttons[i].setBackground(null);}
				buttons[5].setBackground(Color.white);
			}	
			
			if(e.getActionCommand()=="Staff"){
				for(int i=0;i<5;i++)
				{if(buttons[i].getText()=="Staff")buttons[i].setBackground(Color.pink);
				else buttons[i].setBackground(null);}
				buttons[5].setBackground(Color.white);
			}
			if(e.getActionCommand().equals("Requests")){
				b1.setActionCommand("Member Requests");
				b2.setActionCommand("b2");
				b3.setActionCommand("b3");
				b1.addActionListener(new Event());
				b2.addActionListener(new Event());
				b3.addActionListener(new Event());
				panel.add(b1);panel.add(b2);panel.add(b3);
				for(int i=0;i<5;i++)
				{if(buttons[i].getText().equals("Requests"))buttons[i].setBackground(Color.pink);
				else buttons[i].setBackground(null);}
				buttons[5].setBackground(Color.white);
				frame.setVisible(true);
			}			
			if(e.getActionCommand()=="Reports"){
				for(int i=0;i<5;i++)
				{if(buttons[i].getText().equals("Reports"))buttons[i].setBackground(Color.pink);
				else buttons[i].setBackground(Color.PINK);}
				buttons[5].setBackground(Color.white);
			}
			if(e.getActionCommand()=="Logout"){
				panel.removeAll();
				frame.remove(panel);
				frame.dispose();
				system S = new system();
				S.noUsers=0;
				S.readFileUsers();
				S.mainGUI();
				buttons[5].setBackground(Color.white);
			}
			if(e.getActionCommand().equals("Member Requests")){
				b1.setBackground(Color.pink);
				b2.setBackground(null);
				b3.setBackground(null);
				for(int i=0;i<3;i++)
				{
					JLabel t = new JLabel("please have sex with me?");
					panel.add(t);
					panel.add(new JButton("Approve"));
					panel.add(new JButton("Reject"));
				}
				frame.setVisible(true);
			}
			if(e.getActionCommand()=="b2"){
				b2.setBackground(Color.pink);
				b1.setBackground(null);
				b3.setBackground(null);
				}
			if(e.getActionCommand()=="b3"){
				b3.setBackground(Color.pink);
				b1.setBackground(null);
				b2.setBackground(null);
			}
			
		}
		
}

}