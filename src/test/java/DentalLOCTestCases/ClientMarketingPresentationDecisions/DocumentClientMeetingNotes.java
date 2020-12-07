package DentalLOCTestCases.ClientMarketingPresentationDecisions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class DocumentClientMeetingNotes extends TestBase {
	@Test(dataProvider = "getData")
	public void documentClientMeetingNotes(String clientName, String processName , String POM , String AMDate ,
			String FMDate , String MeetingNotesValue , String TaskType , String TaskName, String TaskProcess , 
			String TaskDescription , String TaskAssignedTo,String TaskReviewBy , String TaskPriority , String TaskDueDate) throws InterruptedException, IOException {

		Thread.sleep(10000);
		ProcessAssociateProcessManagerLogout();
   		Thread.sleep(3000);
   		
   	 //Login to Login Test processManager
		 
		 ProcessManagerloginToLockTon() ; 
		 Thread.sleep(8000);


		
	waitUntil("TaskHyperLink");
	    click("TaskHyperLink");
		 Thread.sleep(6000);
		 reset("SelectClient"); 
		  Thread.sleep(3000);
		  click("SelectClient");
		  Thread.sleep(3000); 
		  
		  type("SelectClient", clientName);
			 
		  Thread.sleep(7000);
			
		  WebelementTab();
		 
			

		  Thread.sleep(8000);
		  click("TaskListAllTasks");
		  Thread.sleep(6000);
		 select("TaskListFilterByProcess", processName);
			Thread.sleep(6000);  
			
			//2nd task
			
		 for(int i=1; i<=20;i++) {
				
				WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+i+"]"));
				WebElement Taskxpath= driver.findElement(By.xpath("(//tr/td[3])["+i+"]"));
				System.out.println(Taskxpath.getText());
				
				      System.out.println(Statusxpathvalue.getText());
				if(i==2 || i==7 ||i==10 || i==14){
						    	 // javascript executor for scroll down
					scrolldown();
						    	  }
				String	TaskxpathValue = Taskxpath.getText();
				String INP = Statusxpathvalue.getText();

				
				String COM = "In Progress";
				String ActualTaskValue = "Document Client meeting notes/ followups - Dental";
				
				if (INP.equalsIgnoreCase(COM) && ActualTaskValue.equalsIgnoreCase(TaskxpathValue)) {
					System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText());
					
					driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).click();
					System.out.println("Second Task of client PD -DocumentClientMeetingNotes");
					Thread.sleep(30000);
					click("AddAttachment");
					Thread.sleep(2000);
					Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
					Thread.sleep(5000);
					scrolldown();
					scrolldown();
					click("MeetingNotes");
					type("MeetingNotes", MeetingNotesValue );
					Thread.sleep(3000);
					click("DocumentClientMeetingCreateTask");
					Thread.sleep(5000);
					select("CreateTaskTaskType", TaskType);
					Thread.sleep(2000);
					type("CreateTaskTaskName", TaskName);
					Thread.sleep(2000);
					//select("CreateTaskProcess", TaskProcess);
					type("CreateTaskTaskDescription", TaskDescription );
					Thread.sleep(2000);
					select("CreateTaskAssignedTo", TaskAssignedTo );
					Thread.sleep(2000);
					select("CreateTaskReviewBy", TaskReviewBy );
					Thread.sleep(2000);
					select("CreateTaskPriority", TaskPriority );
					Thread.sleep(2000);
					type("CreateTaskDueDate", TaskDueDate );
					Thread.sleep(2000);
					//Priority by default needs to be low which is not there in perf-qa environment
					//due to which create task is not happening
					scrollToParticularElementSecond("CreateTaskCreate");
					Thread.sleep(10000);
					scrolldown();
					Thread.sleep(2000);
					click("complete");
					Thread.sleep(5000);
					break;
				}}
		 Thread.sleep(5000);
		 ProcessAssociateProcessManagerLogout();
	   		Thread.sleep(3000);
	   		ProcessAssociateloginToLockTon();
	   		Thread.sleep(5000);
	}
	
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "ClientMarketingPD";
		int rows = dentalexcel.getRowCount(sheetName);
		int cols = dentalexcel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for (int rowNum=2; rowNum<=rows; rowNum++)
		{
			for (int colNum=0; colNum<cols; colNum++)
			{
				data[rowNum-2][colNum] = dentalexcel.getCellData(sheetName, colNum, rowNum);
			}
				
		}
		return data;
		
	}	
}
