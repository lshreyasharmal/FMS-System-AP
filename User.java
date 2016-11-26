import java.util.*;
class User
{
	private String UserName,Password,name,address,userType,department,dob;
	private int UserID;
	
	User(String UserName,int UserID, String Password, String name, String address, String userType,String department, String dob)
	{
		this.UserID=UserID;
		this.UserName=UserName;
		this.Password=Password;
		this.name=name;
		this.address=address;
		this.userType=userType;
		this.department=department;
		this.dob=dob;
	}
	
	public void login()
	{
		//depending on the type of user, we'll have the GUI.
		
	}
	public void logout(){}
	
	public String getUserName()
	{
		return this.UserName;
	}
	public void setUserName(String s)
	{
		this.UserName=s;
	}
	
	public String getPassword()
	{
		return this.Password;
	}
	public void setPassword(String p)
	{
		this.Password=p;
	}
	
	public int getUserID()
	{
		return UserID;
	}
	public void setUserId(int id)
	{
		this.UserID=id;
	}
	
	public String getName()
	{
		return this.name;
	}
	public void setName(String s)
	{
		this.name=s;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	public void setAddress(String s)
	{
		this.address=s;
	}
	
	public String getUserType()
	{
		return this.userType;
	}
	public void setUserType(String s)
	{
		this.userType=s;
	}
	
	public String getDepartment()
	{
		return this.department;
	}
	public void setDepartment(String s)
	{
		this.department=s;
	}
	
	public String getDOB()
	{
		return this.dob;
	}
	public void setDOB(String s)
	{
		this.dob=s;
	}


}