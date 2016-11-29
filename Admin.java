import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.*;
import java.text.SimpleDateFormat;

import javax.swing.*;


public class Admin extends User{
	
	
	JFrame frame = new JFrame("FMS System : Admin");
	/****Button Panel************/
	JButton buttons[] = new JButton[6];	JButton depts[] = new JButton[5];
	
	JPanel mpanel = new JPanel();JPanel kpanel = new JPanel();JPanel mrpanel = new JPanel();
	JPanel rpanel = new JPanel();
	JPanel panel = new JPanel(new FlowLayout());
	String name[] = {"Home","Departments","Staff","Requests","Reports","Logout"};
	String dname[] = {"Electricity","HVAC","Audio/Video","Security","Housekeeping"};
	JButton b1 = new JButton("Member Requests"); JButton b2 = new JButton("Leave Requests"); JButton b3 = new JButton("Logistics Requests");
   //create an object of Admin//Using Singleton Design Pattern
   private static Admin instance = new Admin();

   //constructor--private so that this class cannot be instantiated
   Admin()
	{super("Admin",0,"admin","Riddhi Jain","IIIT Delhi","Admin","Admin","31/01/1990");}

   //Get the only object available
   public static Admin getInstance(){
      return instance;
   }
 //GUI For admin
   public void adminGUI()
	{
	   	mpanel.setLayout(new BoxLayout(mpanel,BoxLayout.Y_AXIS));
	   	mpanel.add(panel);
	   	String ddate = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	 	String ttime = new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());
	 	TextField date = new TextField(ddate);
	   	TextField time = new TextField(ttime);
		frame.setSize(900,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Event e = new Event();
		for(int i=0;i<6;i++){
			buttons[i] =new JButton(name[i]);
			buttons[i].setActionCommand(name[i]);
			buttons[i].addActionListener(e);
			panel.add(buttons[i]);
		}
		
		buttons[5].setBackground(Color.white);
		panel.add(date);panel.add(time);
		date.setColumns(10);time.setColumns(8
				);
		date.setEditable(false);time.setEditable(false);
		
		frame.add(mpanel);
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
				rpanel.removeAll();
				rpanel.revalidate();
				
			}
			if(e.getActionCommand()=="Departments"){
				for(int i=0;i<5;i++)
				{if(buttons[i].getText().equals("Departments"))buttons[i].setBackground(Color.pink);
				else buttons[i].setBackground(null);}
				buttons[5].setBackground(Color.white);
				mrpanel.removeAll();
				mrpanel.revalidate();
				rpanel.revalidate();
				kpanel.removeAll();
				kpanel.revalidate();
				rpanel.removeAll();rpanel.revalidate();
				rpanel.setLayout(new BoxLayout(rpanel,BoxLayout.Y_AXIS));
				for(int i=0;i<5;i++)
				{
					depts[i]=new JButton(dname[i]);
					depts[i].setActionCommand(dname[i]);
					kpanel.add(depts[i]);
				}
				rpanel.add(kpanel);
				mpanel.add(rpanel);
				frame.setVisible(true);
				
				
			}	
			
			if(e.getActionCommand()=="Staff"){
				for(int i=0;i<5;i++)
				{if(buttons[i].getText()=="Staff")buttons[i].setBackground(Color.pink);
				else buttons[i].setBackground(null);}
				buttons[5].setBackground(Color.white);
				mrpanel.removeAll();
				mrpanel.revalidate();
				rpanel.revalidate();
				kpanel.removeAll();
				kpanel.revalidate();
				rpanel.removeAll();rpanel.revalidate();
				rpanel.setLayout(new BoxLayout(rpanel,BoxLayout.Y_AXIS));
				for(int i=0;i<5;i++)
				{
					depts[i]=new JButton("oop");
					//depts[i].setActionCommand(dname[i]);
					kpanel.add(depts[i]);
				}
				rpanel.add(kpanel);
				mpanel.add(rpanel);
				frame.setVisible(true);
				
			}
			if(e.getActionCommand().equals("Requests")){
				b1.setActionCommand("Member Requests");
				b2.setActionCommand("Leave Requests");
				b3.setActionCommand("Logistics Request");
				b1.addActionListener(new Event());
				b2.addActionListener(new Event());
				b3.addActionListener(new Event());
				b2.setBackground(null);
				b1.setBackground(null);
				b3.setBackground(null);
				mrpanel.removeAll();
				mrpanel.revalidate();
				kpanel.removeAll();rpanel.removeAll();
				kpanel.revalidate();rpanel.revalidate();
				rpanel.setLayout(new BoxLayout(rpanel,BoxLayout.Y_AXIS));
				kpanel.add(b1);kpanel.add(b2);kpanel.add(b3);
				for(int i=0;i<5;i++)
				{if(buttons[i].getText().equals("Requests"))buttons[i].setBackground(Color.pink);
				else buttons[i].setBackground(null);}
				buttons[5].setBackground(Color.white);
				rpanel.add(kpanel);
				mpanel.add(rpanel);
				frame.setVisible(true);
				
			}			
			if(e.getActionCommand()=="Reports"){
				for(int i=0;i<5;i++)
				{if(buttons[i].getText().equals("Reports"))buttons[i].setBackground(Color.pink);
				else buttons[i].setBackground(null);}
				buttons[5].setBackground(Color.white);
				mrpanel.removeAll();
				mrpanel.revalidate();
				rpanel.revalidate();
				kpanel.removeAll();
				kpanel.revalidate();
				rpanel.removeAll();
				rpanel.revalidate();
				rpanel.setLayout(new BoxLayout(rpanel,BoxLayout.Y_AXIS));
				for(int i=0;i<1;i++)
				{
					depts[i]=new JButton("huhu");
					//depts[i].setActionCommand(dname[i]);
					kpanel.add(depts[i]);
				}
				rpanel.add(kpanel);
				mpanel.add(rpanel);
				frame.setVisible(true);
				
				frame.setVisible(true);
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
				mrpanel.removeAll();
				mrpanel.revalidate();
				mrpanel.setLayout(new BoxLayout(mrpanel,BoxLayout.Y_AXIS));
				for(int i=0;i<6;i++)
				{
					JPanel lpanel = new JPanel();JButton a = new JButton("Approve");
					JButton r = new JButton("Reject");JButton v = new JButton("view");
					JLabel t = new JLabel("please have sex with me?");
					lpanel.add(t);a.setBackground(Color.green);r.setBackground(Color.red);
					lpanel.add(a);a.setActionCommand("approve");v.setBackground(Color.CYAN);
					lpanel.add(r);r.setActionCommand("reject");
					lpanel.add(v);v.setActionCommand("view");
					mrpanel.add(lpanel);
				}
				rpanel.add(mrpanel);
				frame.setVisible(true);
			}
			if(e.getActionCommand()=="Leave Requests"){
				b2.setBackground(Color.pink);
				b1.setBackground(null);
				b3.setBackground(null);
				mrpanel.removeAll();
				mrpanel.revalidate();
				mrpanel.setLayout(new BoxLayout(mrpanel,BoxLayout.Y_AXIS));
				for(int i=0;i<5;i++)
				{
					JPanel lpanel = new JPanel();JButton a = new JButton("Approve");
					JButton r = new JButton("Reject");JButton v = new JButton("view");
					JLabel t = new JLabel("Will you dance ?");
					lpanel.add(t);a.setBackground(Color.green);r.setBackground(Color.red);
					lpanel.add(a);a.setActionCommand("approve");v.setBackground(Color.CYAN);
					lpanel.add(r);r.setActionCommand("reject");
					lpanel.add(v);v.setActionCommand("view");
					mrpanel.add(lpanel);
				}
				rpanel.add(mrpanel);
				frame.setVisible(true);
				}
			if(e.getActionCommand()=="Logistics Request"){
				b3.setBackground(Color.pink);
				b1.setBackground(null);
				b2.setBackground(null);
				mrpanel.removeAll();
				mrpanel.revalidate();
				mrpanel.setLayout(new BoxLayout(mrpanel,BoxLayout.Y_AXIS));
				for(int i=0;i<3;i++)
				{
					JPanel lpanel = new JPanel();JButton a = new JButton("Approve");
					JButton r = new JButton("Reject");JButton v = new JButton("view");
					JLabel t = new JLabel("please lets go out?");
					lpanel.add(t);a.setBackground(Color.green);r.setBackground(Color.red);
					lpanel.add(a);a.setActionCommand("approve");v.setBackground(Color.CYAN);
					lpanel.add(r);r.setActionCommand("reject");
					lpanel.add(v);v.setActionCommand("view");
					mrpanel.add(lpanel);
				}
				rpanel.add(mrpanel);
				frame.setVisible(true);
			}
			if(e.getActionCommand()=="approve"){
				
				}
			if(e.getActionCommand()=="reject"){
				
				}
			if(e.getActionCommand()=="view"){
				
			}
			
		}
		
}

}