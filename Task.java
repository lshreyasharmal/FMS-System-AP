import java.util.Date;
import java.io.*;
import java.util.*;

public class Task {
	private Date deadline,startDate;
	private int taskid;
	private String name,description,dept,supervisor,items,status;
	private ArrayList<String> staff= new ArrayList<>();
	
	Task(String name,String description,String dept,String supervisor,String items,String status, Date deadline, Date startDate, int taskid)
	{
		this.name= name;
		this.description= description;
		this.dept= dept;
		this.supervisor=supervisor;
		this.items=items;
		this.status=status;
		this.deadline=deadline;
		this.startDate=startDate;
		this.taskid=taskid;
	}
	
	public String generateReport()
	{
		//return a string and print that in the GUI.
		return "This is the task report for task named, " + this.name + " ID no. " + this.taskid + " . " + this.description + ". Items used: " + this.items + ". The time taken for the task: " + this.timeTaken();
		
	}
	
	public Date timeTaken() 
	{
		//find the time difference b/w current date and start date.
	}
	
	public Date getDeadline() {return this.deadline;}
	public void setDeadline(Date d) {this.deadline=d;}
	
	public Date getStartDate() {return this.startDate;}
	public void setStartDate(Date d) {this.startDate=d;}
	
	public int getTaskId() {return this.taskid;}
	public void setTaskId(int d) {this.taskid= d;}
	
	public String getName() {return this.name;}
	public void setName(String s) {this.name=s;}
	
	public String getDescription() {return this.description;}
	public void setDescription(String s) {this.description=s;}
	
	public String getDepartment() {return this.dept;}
	public void setDepartment(String s) {this.dept=s;}
		
	public String getSupervisor() {return this.supervisor;}
	public void setsupervisor(String s) {this.supervisor=s;}
		
	public String getItems() {return this.items;}
	public void setItems(String s) {this.items=s;}
		
	public String getStatus() {return this.status;}
	public void setStatus(String s) {this.status=s;}

	
	
}