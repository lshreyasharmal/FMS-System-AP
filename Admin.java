import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;
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
	{super("Admin",0,"admin","AdminFMS","IIIT Delhi","Admin","Admin","31/01/1990",1);}

   //Get the only object available
   public static Admin getInstance(){
      return instance;
   }
   public void generateTask()
   {
	   JFrame Frame1 = new JFrame("Generate Task");
		JLabel jlabel[] = new JLabel[5];
		JTextField txt[] = new JTextField[5];
		
		JPanel leavepanel= new JPanel();
		Frame1.add(leavepanel);
		leavepanel.setLayout(new BoxLayout(leavepanel,BoxLayout.Y_AXIS)); leavepanel.setVisible(true); Frame1.setSize(300,500);
		String labelname[] = {"Task Name","Task Department","Task Pupose","Equipment","Deadline"};
		for(int i=0;i<5;i++)
		{
			jlabel[i] = new JLabel(labelname[i]);
			txt[i]=new JTextField(""); 
			txt[i].setColumns(25);
			leavepanel.add(jlabel[i]);
			leavepanel.add(txt[i]);
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
 //GUI For admin
   public void adminGUI()
	{
	   	mpanel.setLayout(new BoxLayout(mpanel,BoxLayout.Y_AXIS));
	   	mpanel.add(panel);
	   	//mpanel.setBackground(Color.blue);
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
		panel.setBackground(null);
		date.setColumns(10);time.setColumns(8);
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
				kpanel.removeAll();
				kpanel.revalidate();
				rpanel.removeAll();
				rpanel.revalidate();
				rpanel.setLayout(new BoxLayout(rpanel,BoxLayout.Y_AXIS));
				JLabel[] jlabel = new JLabel[6];
				for(int i=0;i<6;i++)
				{
					jlabel[i]= new JLabel();
					rpanel.add(jlabel[i]);
				}
				//rpanel.setBackground(Color.pink);
				rpanel.add(kpanel);
				
				mpanel.add(rpanel);
				jlabel[0].setText("Name : "+ getName());
				jlabel[1].setText("Username : "+ getUserName());
				jlabel[2].setText("Address : "+ getAddress());
				jlabel[3].setText("Department : "+ getDepartment());
				jlabel[4].setText("Date of Birth : "+ getDOB());
				jlabel[5].setText("User ID : "+ getUserID());
				frame.setVisible(true);
				
			}
			if(e.getActionCommand()=="Departments"){
				for(int i=0;i<5;i++)
				{if(buttons[i].getText().equals("Departments"))buttons[i].setBackground(Color.pink);
				else buttons[i].setBackground(null);}
				buttons[5].setBackground(Color.white);
				rpanel.removeAll();rpanel.revalidate();kpanel.removeAll();
				kpanel.revalidate();
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
				rpanel.removeAll();rpanel.revalidate();kpanel.removeAll();
				kpanel.revalidate();
				rpanel.setLayout(new BoxLayout(rpanel,BoxLayout.Y_AXIS));
				for(int i=0;i<5;i++)
				{
					//generateTask();
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
				rpanel.removeAll();
				rpanel.revalidate();kpanel.removeAll();
				kpanel.revalidate();
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
				rpanel.removeAll();
				rpanel.revalidate();kpanel.removeAll();
				kpanel.revalidate();
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
				kpanel.removeAll();
				kpanel.revalidate();
				mrpanel.setLayout(new BoxLayout(mrpanel,BoxLayout.Y_AXIS));
								system s=new system();
				
				//System.out.println("here" + s.getRequests().size());
				int i,f;
				ArrayList<String> arr = new ArrayList<String>(); 
				ArrayList<String> info= new ArrayList<String>();
				ArrayList<Integer> index= new ArrayList<>();
				 ArrayList<Integer> status= new ArrayList<>();
				int x=s.getRequests().size();
				for( i=0;i<x;i++)
				{
					System.out.println(i);
					if(s.getReq(i)==-1) {arr.add(s.getName(i)); info.add(s.getInfo(i)); index.add(i); status.add(-1);}
				}
				System.out.println(arr.size());
				 for( i=0;i<arr.size();i++)
				 {
					// System.out.println(s.getRequests().get(i).getApproved());
					// if(s.getRequests().get(i).getApproved()==1)
					// {
					
					JPanel lpanel = new JPanel();JButton a = new JButton("Approve");
					JButton r = new JButton("Reject");JButton v = new JButton("view");
					
					String y=arr.get(i); JLabel t = new JLabel(y);
					// v.addActionListener(new Event());
					// if(e.getActionCommand()=="view"){
					// JOptionPane.showMessageDialog(frame,info.get(i));
					// }
					String str= info.get(i);
					v.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							// JDialog d = new JDialog(frame,str, true);
							// d.setLocationRelativeTo(frame); d.setVisible(true);
							JOptionPane.showMessageDialog(null, str);
						}
					});	
					//f=0;		
					int chu= index.get(i);
					a.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							// JDialog d = new JDialog(frame,str, true);
							// d.setLocationRelativeTo(frame); d.setVisible(true);
							JOptionPane.showMessageDialog(null, "Approved");
							//mrpanel.remove(lpanel);// f=1;
							t.setText(y+ " approved.");
							System.out.println(t.getText());
							// remove(a); remove(v); remove(r);
							//a.setText(""); v.setText(""); r.setText("");
							a.setVisible(false); r.setVisible(false); v.setVisible(false);
							s.setUserStatus(chu);
							//set status to 1 in file and users array.
							//f(i,s);
						//	status.set(i,1);
						}
					});
					System.out.println("hereeee");	
					System.out.println(t.getText());
					
					// if(t.getText().equals(y+ " approved."))
					// {
						// //write 1 to file.
						// //userno=?
						// System.out.println("here");
						// s.setUserStatus(13);
					// }
					//System.out.println(t.getText(y));
					//if(! (t.getText().equals("Approved"))){
						
					lpanel.add(t);a.setBackground(Color.green);r.setBackground(Color.red);
					lpanel.add(a);a.setActionCommand("approve");v.setBackground(Color.CYAN);
					lpanel.add(r);r.setActionCommand("reject");
					lpanel.add(v);v.setActionCommand("view");
					mrpanel.add(lpanel);
					//}
					// }
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