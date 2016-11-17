class User
{
	String UserName;
	int UserID;
	String Password;
	User(String UserName,int UserID, String Password){
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
	public int getUserID()
	{
		return UserID;
	}
	public void setUserId(int id)
	{
		this.UserID=id;
	}
}