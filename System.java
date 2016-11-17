import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

class system extends JFrame
{
	static JFrame Frame1 = new JFrame();
	Department Department[];

	public void Register()
	{
		System.out.println("Enter the Username: ");
		Scanner scan = new Scanner(System.in);
		String username = scan.next();
		//check whether already present 
		//set user id by incrementing by 1 in the last user id
		
		
		
		
	}
	public void login()
	{
	
	}
	public void logout()
	{
	
	}
	
	public static void main(String[] args)
	{
		Frame1.setVisible(true);
		Object[] options = {"Register","Login"};
		int n = JOptionPane.showOptionDialog(Frame1,"FMS Syste"+ "m","FMS System",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
		if(n==JOptionPane.YES_OPTION){
			String username = JOptionPane.showInputDialog(Frame1,"Enter Username :");
			String password = JOptionPane.showInputDialog(Frame1,"Eneter Password :");}
		if(n==JOptionPane.NO_OPTION){
			String username = JOptionPane.showInputDialog(Frame1,"Enter Username :");
			String password = JOptionPane.showInputDialog(Frame1,"Eneter Password :");}
		
	}
}