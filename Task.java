import java.util.Date;

import javax.swing.*;
//Task Report – ID, Task ID, Task Name, Task Description, Items used, Time Taken,
//Comments.
public class Task {
	private Date Deadline, StartDate;
	private String TaskID,TaskDept,TaskName;
	public enum TaskStatus { COMPLETE,  NOT_STARTED, ONGOING } ;
	Task(Date Deadline,Date StartDate,String TaskID, String TaskDept,String TaskName){
		this.Deadline=Deadline;
		this.StartDate=StartDate;
		this.TaskID=TaskID;
		this.TaskDept=TaskDept;
		this.TaskName=TaskName;
	}
	public void setTaskName(String Name)
	{
		this.TaskName=Name;
	}
	public void setDeadline(Date date)
	{
		this.Deadline=date;
	}
	public void setStartDate(Date date)
	{
		this.StartDate=date;
	}
	public void setTaskID(String t)
	{
		this.TaskID=t;
	}
	public void setTaskDept(String t)
	{
		this.TaskDept=t;
	}
	public String getTaskName()
	{
		return TaskName;
	}
	public Date getDeadline()
	{
		return Deadline;
	}
	public Date getStartDate()
	{
		return StartDate;
	}
	public String getTaskID()
	{
		return TaskID;
	}
	public String getTaskDept()
	{
		return TaskDept;
	}
	
}//Task Report – ID, Task ID, Task Name, Task Description, Items used, Time Taken,
//Comments.
