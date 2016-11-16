class User
{
	String UserName;
	String UserID;
	String Password;
	User(String UserName,String UserID, String Password){
		this.UserID=UserID;
		this.UserName=UserName;
		this.Password=Password;}
	
	public void login(String str){}
	public void logout(){}
	public String getUserName(){
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
	public String getUserID()
	{
		return UserID;
	}
	public void setUserId(String id)
	{
		this.UserID=id;
	}
}