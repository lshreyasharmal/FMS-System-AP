import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class Supervisor extends User {
	JFrame frame = new JFrame("FMS System : Supervisor "+this.getDepartment());
	JPanel mpanel = new JPanel();JPanel kpanel = new JPanel();JPanel mrpanel = new JPanel();
	JPanel rpanel = new JPanel();JPanel leavepanel = new JPanel();
	JPanel panel = new JPanel(new FlowLayout());
	JButton buttons[] = new JButton[6];
	String name[] = {"Home","Send Leave","Staff","Requests","Reports","Logout"};
	String dname[] = {"Electricity","HVAC","Audio/Video","Security","Housekeeping"};
	JButton b1 = new JButton("Member Requests"); JButton b2 = new JButton("Leave Requests"); JButton b3 = new JButton("Logistics Requests");
	Supervisor(String UserName,int UserID, String Password, String name, String address, String userType,String department, String dob)
	{
		super(UserName,UserID,Password,name,address,userType,department,dob);
	}
	public void supGUI()
	{
		mpanel.setLayout(new BoxLayout(mpanel,BoxLayout.Y_AXIS));
	   	mpanel.add(panel);
		frame.setSize(900,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		String ddate = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	 	String ttime = new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());
	 	TextField date = new TextField(ddate);
	   	TextField time = new TextField(ttime);
		panel.setVisible(true);
		frame.setVisible(true);
		Event e = new Event();
		for(int i=0;i<6;i++){
			buttons[i] =new JButton(name[i]);
			buttons[i].addActionListener(e);
			buttons[i].setActionCommand(name[i]);
			panel.add(buttons[i]);
		}
		buttons[5].setBackground(Color.white);
		panel.add(date);panel.add(time);
		date.setColumns(10);time.setColumns(8);
		date.setEditable(false);time.setEditable(false);
		
		frame.add(mpanel);
		frame.setVisible(true);
	}
	public class Event implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("Home")){
				for(int i=0;i<6;i++)
				{if(buttons[i].getText()!="Home")buttons[i].setBackground(null);
				else buttons[i].setBackground(Color.PINK);}
				buttons[5].setBackground(Color.white);
				kpanel.removeAll();
				kpanel.revalidate();
				rpanel.removeAll();
				rpanel.revalidate();
			}
			if(e.getActionCommand().equals("Send Leave")){
				for(int i=0;i<6;i++)
				{if(buttons[i].getText()!="Send Leave")buttons[i].setBackground(null);
				else buttons[i].setBackground(Color.PINK);}
				buttons[5].setBackground(Color.white);
				JFrame Frame1 = new JFrame("Leave Form");
				JLabel jlabel[] = new JLabel[4];
				JTextField txt[] = new JTextField[4];
				
				Frame1.add(leavepanel);
				leavepanel.setLayout(new FlowLayout(10)); leavepanel.setVisible(true); Frame1.setSize(300,300);
				String labelname[] = {"To Whom:","Reason","Frome (DD/MM/YYYY)","To (DD/MM/YYYY)"};
				for(int i=0;i<4;i++)
				{
					jlabel[i] = new JLabel(labelname[i]);
					txt[i]=new JTextField(""); 
					txt[i].setColumns(25);
					leavepanel.add(jlabel[i]);leavepanel.add(txt[i]);
				}
				JButton b= new JButton(); 
				b.setText("Submit");
				leavepanel.add(b);
				Frame1.add(leavepanel);
				Frame1.setVisible(true);
				frame.setVisible(false);
				
				b.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e){
						Frame1.setVisible(false);
						frame.setVisible(true);
					}});
				
				
			}	
			
			if(e.getActionCommand().equals("Staff")){
				for(int i=0;i<6;i++)
				{if(buttons[i].getText()!="Staff")buttons[i].setBackground(null);
				else buttons[i].setBackground(Color.PINK);}
				for(int i=0;i<5;i++)
				{if(buttons[i].getText()=="Staff")buttons[i].setBackground(Color.pink);
				else buttons[i].setBackground(null);}
				buttons[5].setBackground(Color.white);
				rpanel.removeAll();rpanel.revalidate();kpanel.removeAll();
				kpanel.revalidate();
				rpanel.setLayout(new BoxLayout(rpanel,BoxLayout.Y_AXIS));
				rpanel.add(kpanel);
				mpanel.add(rpanel);
				frame.setVisible(true);
			}
			if(e.getActionCommand().equals("Requests")){
				for(int i=0;i<6;i++)
				{if(buttons[i].getText()!="Requests")buttons[i].setBackground(null);
				else buttons[i].setBackground(Color.PINK);}
				b1.setActionCommand("Member Requests");
				b2.setActionCommand("Leave Requests");
				b3.setActionCommand("Logistics Request");
				b1.addActionListener(new Event());
				b2.addActionListener(new Event());
				b3.addActionListener(new Event());
				b2.setBackground(null);
				b1.setBackground(null);
				b3.setBackground(null);
				rpanel.removeAll();
				rpanel.revalidate();
				kpanel.removeAll();
				kpanel.revalidate();
				rpanel.setLayout(new BoxLayout(rpanel,BoxLayout.Y_AXIS));
				for(int i=0;i<5;i++)
				{if(buttons[i].getText().equals("Requests"))buttons[i].setBackground(Color.pink);
				else buttons[i].setBackground(null);}
				kpanel.add(b1);kpanel.add(b2);kpanel.add(b3);
				buttons[5].setBackground(Color.white);
				
				rpanel.add(kpanel);
				
				mpanel.add(rpanel);
				frame.setVisible(true);
			}			
			if(e.getActionCommand().equals("Reports")){
				for(int i=0;i<6;i++)
				{if(buttons[i].getText()!="Reports")buttons[i].setBackground(null);
				else buttons[i].setBackground(Color.PINK);}
				buttons[5].setBackground(Color.white);
				rpanel.removeAll();
				rpanel.revalidate();kpanel.removeAll();
				kpanel.revalidate();
				rpanel.setLayout(new BoxLayout(rpanel,BoxLayout.Y_AXIS));
				rpanel.add(kpanel);
				mpanel.add(rpanel);
				frame.setVisible(true);
				
				
			}
			if(e.getActionCommand().equals("Logout")){
				frame.remove(panel);
				frame.dispose();
				system S = new system();
				S.noUsers=0;
				S.readFileUsers();
				S.mainGUI();
			}
			if(e.getActionCommand().equals("Member Requests")){
				b1.setBackground(Color.pink);
				b2.setBackground(null);
				b3.setBackground(null);
				mrpanel.removeAll();
				mrpanel.revalidate();
				kpanel.removeAll();
				kpanel.revalidate();
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
			if(e.getActionCommand().equals("Leave Requests")){
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
					JLabel t = new JLabel("Will you dance ?");v.addActionListener(new Event());
					lpanel.add(t);a.setBackground(Color.green);r.setBackground(Color.red);
					lpanel.add(a);a.setActionCommand("approve");v.setBackground(Color.CYAN);
					lpanel.add(r);r.setActionCommand("reject");a.addActionListener(new Event());
					lpanel.add(v);v.setActionCommand("view");r.addActionListener(new Event());
					mrpanel.add(lpanel);
				}
				rpanel.add(mrpanel);
				frame.setVisible(true);
				}
			if(e.getActionCommand().equals("Logistics Request")){
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
