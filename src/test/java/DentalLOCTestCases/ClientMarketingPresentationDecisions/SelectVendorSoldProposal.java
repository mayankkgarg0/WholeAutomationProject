package DentalLOCTestCases.ClientMarketingPresentationDecisions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class SelectVendorSoldProposal extends TestBase {
	@Test(dataProvider = "getData")
	public void documentClientMeetingNotes(String clientName, String processName , String POM , String AMDate ,
			String FMDate , String MeetingNotesValue , String TaskType , String TaskName, String TaskProcess , 
			String TaskDescription , String TaskAssignedTo,String TaskReviewBy , String TaskPriority , String TaskDueDate,
			String UpadteComments , String VendorSelect , String FundingArrangement , String Network , String EligibilityDefinition , String PlanDesignOption , String RateTiers,
			String NameofRateTiers , String VendorServices , String SelectPlan , String BudgetRateNumber , String ListOfGroups , String NumberOfContribution , String DescriptionContribution1,
			String DescriptionContribution2 , String IncentivesNameRateTiers , String EnrollmentFromDate , String EnrollmentToDate , String EnrollmentMaterialValue , String AddVendorEmailValue) throws InterruptedException, IOException {

	

		Thread.sleep(10000);
		
		
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
			
			//9th task
			
		 for(int i=1; i<=30;i++) {
			 
			 if(i==21) {
				 click("TaskNextPage");
				 scrollToTOPOfPage();
				 Thread.sleep(6000);
				 
				 i=1;
				}
			
			 System.out.println("I value :" +i); 
	
			
			
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
			
				String ActualTaskValue = "Select vendor sold proposal - Dental";
				if (INP.equalsIgnoreCase(COM) && ActualTaskValue.equalsIgnoreCase(TaskxpathValue)) {
					System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText());
					
					driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).click();
					System.out.println("Ninth Task of Marketing Meeting Followups Dental");
					Thread.sleep(30000);
					scrollToTOPOfPage();
					Thread.sleep(2000);
					click("Task9SelectSoldOutPlan");
					Thread.sleep(2000);
					click("Task8Other");
					Thread.sleep(2000);
					click("OtherNext");
					Thread.sleep(4000);
					click("ApproveButton");
					Thread.sleep(3000);
					click("complete");
					Thread.sleep(7000);
					break;
				}}
		 
		 
		 
		 
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
