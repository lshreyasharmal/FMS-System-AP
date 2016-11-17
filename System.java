import java.io.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class system extends JFrame
{
	static JFrame Frame1 = new JFrame();
	//Department Department[];
	private ArrayList<User> users= new ArrayList<User>();
	private int noUsers;
	
	public void readFileUsers()
    {
    BufferedReader br= null;
    try
    {
    br= new BufferedReader(new FileReader("users.txt"));
    String line=null; 
    while((line=br.readLine())!=null)
    {
	User mmm= new User(null,0,null);
	String lines[]=line.split(",");
	mmm.setUserId(Integer.parseInt(lines[0]));
	mmm.setUserName(lines[1]);
	mmm.setPassword(lines[2]);
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
	
	public void Register(String s1,String s2){
		
		if(check(s1)==-1)
		{
			JOptionPane.showMessageDialog(null, "This Username is taken! ", "Error", JOptionPane.ERROR_MESSAGE);
			mainGUI();
		}
		try
		{
		FileWriter fr= new FileWriter("users.txt",true);
		BufferedWriter br= new BufferedWriter(fr);
		PrintWriter out= new PrintWriter(br);
			User mmm=users.get(noUsers-1);
			int id= mmm.getUserID()+1;
			mmm= new User(s1,id,s2);
			users.add(mmm);
			out.write(id+",");
			out.write(s1 +",");
			out.write(s2);
			out.write("\n");		
		out.close();
		}
		catch(Exception e)
		{e.printStackTrace();}
	}
	
	public void login(String s1, String s2)
	{

		//check that username and password are valid.
		if(check(s1)==1)
		{
			//display the login GUI
			//GUI depeneds on the user.
			if(s1.equals("admin"))
			{
				
			}
			else if(s1.equals("hsuper"))
			{
				
			}
			else if(s1.equals("ssuper"))
			{
				
			}
			else if(s1.equals("esuper"))
			{
				
			}
			else if(s1.equals("avsuper"))
			{
				
			}
			else if(s1.equals("hvacsuper"))
			{
				
			}
			else 
			{
				
			}
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
			String username = JOptionPane.showInputDialog(Frame1,"Enter Username :");
			String password = JOptionPane.showInputDialog(Frame1,"Enter Password :");
			Register(username,password);
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
	public int check(String string){
    
		for(int i =0;i<users.size();i++)
		{
			User mmm ;
			mmm = users.get(i);
			if(string.equals(mmm.getUserName()))
				{return -1;}
		}
		return 1;
		}
	
}