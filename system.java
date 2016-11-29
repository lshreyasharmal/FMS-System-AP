import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class system extends JFrame
{
	JFrame Frame1 = new JFrame("Registration Form");
	JPanel panel = new JPanel();
	static Admin admin = Admin.getInstance();
	ArrayList<User> users= new ArrayList<User>();
	int noUsers;
	// static system instance = new system();
	// private system(){}
	// public static system getInstance()
	// {
		// return instance;
	// }
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
	
	public void checklogin(String string,String pass)
	{
		int ch =0,j=0;
		User mmm ;
		for(int i =0;i<users.size();i++)
		{
			mmm = users.get(i);
			if(string.equals(mmm.getUserName())&& pass.equals(mmm.getPassword())){ch=1;j=i;}
		}
		if(ch==1){mmm = users.get(j);mmm.login();}
		else {JOptionPane.showMessageDialog(null, "Wrong credentials entered. Try logging in again.", "Error", JOptionPane.ERROR_MESSAGE);
		mainGUI();}
		
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
	User mmm= new User(null,0,null,null,null,null,null,null,0);
	String lines[]=line.split(",");
	int id =Integer.parseInt(lines[0]);
	String name =lines[1];
	String dob=lines[2];
	String addr=lines[3];
	String type=lines[4];
	String dept=lines[5];
	String username=lines[6];
	String pass =lines[7];
	int x =Integer.parseInt(lines[8]);
	
	if(type.equals("supervisor"))
		mmm= new Supervisor(username,id,pass,name,addr,type,dept,dob,x);
	else if(type.equals("staff"))
		mmm= new Staff(username,id,pass,name,addr,type,dept,dob,x);
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
	
	public ArrayList<User> getRequests() {readFileUsers();return users;}
	
	public void Register(String s1,String s2,String s3,String s4,String s5, String s6, String s7){
		
		if(check(s1)==-1)
		{
			JOptionPane.showMessageDialog(null, "This Username is taken! ", "Error", JOptionPane.ERROR_MESSAGE);
			mainGUI();
		}
		else if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")||s7.equals("")){
			JOptionPane.showMessageDialog(null, "Empty Fields ", "Error", JOptionPane.ERROR_MESSAGE);
			RegisterGUI();
		}
		else{
		try
		{
		FileWriter fr= new FileWriter("users.txt",true);
		BufferedWriter br= new BufferedWriter(fr);
		PrintWriter out= new PrintWriter(br);
			User mmm=users.get(noUsers-1);
			int id= mmm.getUserID()+1;
			mmm= new User(s1,id,s2,s3,s4,s5,s6,s7,-1);
			users.add(mmm);
			out.write(id+",");
			out.write(s3 +",");
			out.write(s4 +",");
			out.write(s5 +",");
			out.write(s6 +",");
			out.write(s7 +",");
			out.write(s1 +",");
			out.write(s2+ ",-1");
			out.write("\n");
		out.close();
		Frame1.remove(panel);
		Frame1.dispose();
		
		mainGUI();
		}
		catch(Exception e)
		{e.printStackTrace();}}
	}
	
	public int getReq(int i)
	{
		return users.get(i).getApproved();
	}
	
	public String getInfo(int i)
	{
		return "Username:" + users.get(i).getUserName() + " Password: " + users.get(i).getPassword()+ " Name: " + users.get(i).getName() + " Address: " + users.get(i).getAddress() + " Type: " + users.get(i).getUserType() + " Department: " + users.get(i).getDepartment() + " DOB: " + users.get(i).getDOB();
	}
	
	public String getName(int i)
	{
		return users.get(i).getUserName();
	}
	
	public void mainGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Object[] options = {"Register","Login"};
		int n = JOptionPane.showOptionDialog(Frame1,"FMS Syste"+ "m","FMS System",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
		if(n==JOptionPane.YES_OPTION){RegisterGUI();}
		if(n==JOptionPane.NO_OPTION){
			String username = JOptionPane.showInputDialog(Frame1,"Enter Username :");
			String password = JOptionPane.showInputDialog(Frame1,"Enter Password :");
			if(username.equals(admin.getUserName())&&password.equals(admin.getPassword()))
			{admin.adminGUI();}
			else
			checklogin(username,password);
			}
	}
	public void RegisterGUI(){
		JLabel jlabel[] = new JLabel[7];
		JTextField txt[] = new JTextField[7];
		String labelname[] = {"Enter Name :","Enter Date Of Birth(DD/MM/YYYY) :","Enter Address :","Enter User Type(supervisor/staff) :","Enter Department :","Enter Username :","Enter Password :"};
		for(int i=0;i<7;i++)
		{
			jlabel[i] = new JLabel(labelname[i]);
			txt[i]=new JTextField(""); txt[i].setColumns(20);
			panel.add(jlabel[i]);panel.add(txt[i]);
		}
		JButton b= new JButton(); b.setText("Submit");
		panel.add(b);
		Frame1.add(panel);
		panel.setLayout(new FlowLayout(10)); panel.setVisible(true); Frame1.setSize(300,400);
		 b.addActionListener( new ActionListener(){
		public void actionPerformed(ActionEvent e){
		String name= txt[0].getText();
		String dob= txt[1].getText();
		String add= txt[2].getText();
		String type= txt[3].getText();
		String dept= txt[4].getText();
		String username= txt[5].getText();
		String password= txt[6].getText();
		Register(username,password,name,dob,add,type,dept);}} );
		 Frame1.setVisible(true);
	}
	public static void main(String[] args)
	{
		system s = new system();
		s.noUsers=0;
		s.readFileUsers();
		System.out.println(s.noUsers);
		s.mainGUI();
	}

	
}