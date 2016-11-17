import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

class system extends JFrame
{
	static JFrame Frame1 = new JFrame();
	Department Department[];
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
	
	public void writeFileUsers(String s1,String s2){
		try
		{
		FileWriter fr= new FileWriter("users.txt",true);
		BufferedWriter br= new BufferedWriter(fr);
		PrintWriter out= new PrintWriter(br);

			noUsers++;
			int id= noUsers+100;
			out.write(id+",");
			out.write(s1 +",");
			out.write(s2);
			out.write("\n");
		
		out.close();
		}
		catch(Exception e)
		{e.printStackTrace();}
	}
	public void Register()
	{}
	public void login()
	{}
	public void logout()
	{}
	
	public static void main(String[] args)
	{
		system s = new system();
		s.noUsers=0;
		Frame1.setVisible(true);
		Object[] options = {"Register","Login"};
		int n = JOptionPane.showOptionDialog(Frame1,"FMS Syste"+ "m","FMS System",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
		if(n==JOptionPane.YES_OPTION){
			String username = JOptionPane.showInputDialog(Frame1,"Enter Username :");
			String password = JOptionPane.showInputDialog(Frame1,"Eneter Password :");
			s.writeFileUsers(username,password);
		}
		if(n==JOptionPane.NO_OPTION){
			String username = JOptionPane.showInputDialog(Frame1,"Enter Username :");
			String password = JOptionPane.showInputDialog(Frame1,"Eneter Password :");}
		
	}
}