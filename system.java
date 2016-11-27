import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class system extends JFrame
{
	static JFrame Frame1 = new JFrame();
	//Department Department[];
	private ArrayList<User> users= new ArrayList<User>();
	private int noUsers;
	
	public int check(String string)
	{
		for(int i =0;i<users.size();i++)
		{
			User mmm = users.get(i);
			if(string.equals(mmm.getUserName()))
				{return -1;}
		}
		return 1;
	}
	
	public int checkLogin(String string)
	{
		for(int i =0;i<users.size();i++)
		{
			User mmm = users.get(i);
			if(string.equals(mmm.getUserName()))
				{mmm.login(); return 1;}
		}
		return -1;
	}
	
	public void readFileUsers()
    {
    BufferedReader br= null;
    try
    {
    br= new BufferedReader(new FileReader("users.txt"));
    String line=null; 
    while((line=br.readLine())!=null)
    {
	User mmm= new User(null,0,null,null,null,null,null,null);
	String lines[]=line.split(",");
	mmm.setUserId(Integer.parseInt(lines[0]));
	mmm.setName(lines[1]);
	mmm.setDOB(lines[2]);
	mmm.setAddress(lines[3]);
	mmm.setUserType(lines[4]);
	mmm.setDepartment(lines[5]);
	mmm.setUserName(lines[6]);
	mmm.setPassword(lines[7]);
	users.add(mmm);
    }
	noUsers=users.size();
    }catch(FileNotFoundException ex) {ex.printStackTrace();}
    catch(IOException ex) {ex.printStackTrace();}
    finally
    {
    try{if(br!=null) br.close();}
    catch(IOException ex) {ex.printStackTrace();}
    }    
    }
	
	public void Register(String s1,String s2,String s3,String s4,String s5, String s6, String s7){
		
		if(check(s1)==-1)
		{
			JOptionPane.showMessageDialog(null, "This Username is taken! ", "Error", JOptionPane.ERROR_MESSAGE);
			mainGUI();
		}
		else{
		try
		{
		FileWriter fr= new FileWriter("users.txt",true);
		BufferedWriter br= new BufferedWriter(fr);
		PrintWriter out= new PrintWriter(br);
			User mmm=users.get(noUsers-1);
			int id= mmm.getUserID()+1;
			mmm= new User(s1,id,s2,s3,s4,s5,s6,s7);
			users.add(mmm);
			out.write(id+",");
			out.write(s3 +",");
			out.write(s4 +",");
			out.write(s5 +",");
			out.write(s6 +",");
			out.write(s7 +",");
			out.write(s1 +",");
			out.write(s2);
			out.write("\n");		
		out.close();
		}
		catch(Exception e)
		{e.printStackTrace();}}
	}
	
	public void login(String s1, String s2)
	{

		//check that username and password are valid.
		if(checkLogin(s1)==1)
		{
			//simply login the user.
			//done in checkLogin() itself...
		}
		else
		{
			//User not found. Login again.
			JOptionPane.showMessageDialog(null, "Wrong credentials entered. Try logging in again.", "Error", JOptionPane.ERROR_MESSAGE);
			mainGUI();
		}
	}
	public void logout()
	{}
	
	public void mainGUI(){
		Frame1.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Object[] options = {"Register","Login"};
		int n = JOptionPane.showOptionDialog(Frame1,"FMS Syste"+ "m","FMS System",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
		if(n==JOptionPane.YES_OPTION){
			JLabel l1=new JLabel(); l1.setText("Enter Name :");
			JTextField txt1= new JTextField();txt1.setColumns(20);
			add(l1); add(txt1);
			JLabel l2=new JLabel(); l2.setText("Enter Date Of Birth(DD/MM/YYYY) :");
			JTextField txt2= new JTextField();txt2.setColumns(20);
			add(l2); add(txt2);
			JLabel l3=new JLabel(); l3.setText("Enter Address :");
			JTextField txt3= new JTextField();txt3.setColumns(20);
			add(l3); add(txt3);
			JLabel l4=new JLabel(); l4.setText("Enter User Type(supervisor/staff/admin) :");
			JTextField txt4= new JTextField();txt4.setColumns(20);
			add(l4); add(txt4);
			JLabel l5=new JLabel(); l5.setText("Enter Department :");
			JTextField txt5= new JTextField();txt5.setColumns(20);
			add(l5); add(txt5);
			JLabel l6=new JLabel(); l6.setText("Enter Username :");
			JTextField txt6= new JTextField();txt6.setColumns(20);
			add(l6); add(txt6);
			JLabel l7=new JLabel(); l7.setText("Enter Password :");
			JTextField txt7= new JTextField();txt7.setColumns(20);
			add(l7); add(txt7);
			JButton b= new JButton(); b.setText("Submit");
			add(b);
			setLayout(new FlowLayout(10)); setVisible(true); setSize(300,400);
			 b.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
			String name= txt1.getText();
			String dob= txt2.getText();
			String add= txt3.getText();
			String type= txt4.getText();
			String dept= txt5.getText();
			String username= txt6.getText();
			String password= txt7.getText();
			Register(username,password,name,dob,add,type,dept);}} );

		}
		if(n==JOptionPane.NO_OPTION){
			String username = JOptionPane.showInputDialog(Frame1,"Enter Username :");
			String password = JOptionPane.showInputDialog(Frame1,"Eneter Password :");
			login(username,password);
			}
	}
	
	public static void main(String[] args)
	{
		system s = new system();
		s.noUsers=0;
		s.readFileUsers();
		s.mainGUI();
	}

	
}
