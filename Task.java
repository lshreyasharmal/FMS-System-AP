import java.util.Date;

public class Task {
	private Date Deadline, StartDate;
	private String TaskStatus,TaskID,TaskDept;
	
	public void setDeadline(Date date)
	{
		Deadline=date;
	}
	public void setStartDate(Date date)
	{
		StartDate=date;
	}
	public void setTaskStatus(String t)
	{
		TaskStatus = t;
	}
	public void setTaskID(String t)
	{
		TaskID=t;
	}
	public void setTaskDept(String t)
	{
		TaskDept=t;
	}
	public Date getDeadline()
	{
		return Deadline;
	}
	public Date getStartDate()
	{
		return StartDate;
	}
	public String getTaskStatus()
	{
		return TaskStatus;
	}
	public String getTaskID()
	{
		return TaskID;
	}
	public String getTaskDept()
	{
		return TaskDept;
	}
	public void getReport()
	{
		
	}
}
