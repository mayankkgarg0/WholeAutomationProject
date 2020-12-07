package DentalLOCTestCases.ClientMarketingPresentationDecisions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class ObtainClientDecisionsDental extends TestBase {
	@Test(dataProvider = "getData")
	public void documentClientMeetingNotes(String clientName, String processName , String POM , String AMDate ,
			String FMDate , String MeetingNotesValue , String TaskType , String TaskName, String TaskProcess , 
			String TaskDescription , String TaskAssignedTo,String TaskReviewBy , String TaskPriority , String TaskDueDate,
			String UpadteComments , String VendorSelect , String FundingArrangement , String Network , String EligibilityDefinition , String PlanDesignOption , String RateTiers,
			String NameofRateTiers , String VendorServices , String SelectPlan , String BudgetRateNumber , String ListOfGroups , String NumberOfContribution , String DescriptionContribution1,
			String DescriptionContribution2 , String IncentivesNameRateTiers , String EnrollmentFromDate , String EnrollmentToDate , String EnrollmentMaterialValue) throws InterruptedException, IOException {

	

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
			
			//8th task
			
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
				String ActualTaskValue = "Obtain Client Decisions - Dental";
				
				if (INP.equalsIgnoreCase(COM) && ActualTaskValue.equalsIgnoreCase(TaskxpathValue)) {
					System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText());
					
					driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).click();
					System.out.println("Eight Task of Marketing Meeting Followups Dental");
					Thread.sleep(30000);
					scrollToTOPOfPage();
			click("EnterClientDecisions");
					Thread.sleep(7000);
					//select("VendorSelectTaskClientDecision", VendorSelect);
					
					//1st tab Marketing Decision
					
			for(int k=2; k<=7; k++) {
						
						String[] Values = {"", "", VendorSelect, FundingArrangement, Network, EligibilityDefinition ,PlanDesignOption, RateTiers};	
						
				WebElement dropdown= driver.findElement(By.xpath("(//*[@class='col-3 d-inline-block'])["+k+"]/select"));
					Select select = new Select(dropdown);
						
						select.selectByVisibleText(Values[k]);
						Thread.sleep(2000);
					}
					
				scrolldown();
				click("RateTiersDropdown");
				Thread.sleep(1000);
				Multiselectcheckbox(NameofRateTiers);
				
				Thread.sleep(1000);
				click("RateTiersDropdownUP");
				
				Thread.sleep(1000);
				click("VendorServicesDropdown");
				Thread.sleep(1000);
				
				
				Multiselectcheckbox(VendorServices);
				Thread.sleep(1000);
				click("RateTiersDropdownUP"); 
				Thread.sleep(1000);
				//2nd  tab conribution decision
				
				click("Rate/ContributionDecisions");
				Thread.sleep(2000);    
				select("WhichPlan", SelectPlan);
				Thread.sleep(2000);
				
				scrollToBotton();
				for(int n=1; n<=9; n++) {
					
					driver.findElement(By.xpath("(//*[@type='number'])["+n+"]")).sendKeys(BudgetRateNumber);	
					Thread.sleep(3000);
				} 
				scrollUP();
				 //2a tab
				
				click("Contributions");
				Thread.sleep(3000);
				click("ListOfGroups");
				type("ListOfGroups", ListOfGroups);
				Thread.sleep(1000);
				scrolldown();
				select("NumberOfContributionCategories", NumberOfContribution );
				Thread.sleep(2000);
				type("DescriptionOfContribution1", DescriptionContribution1);
				Thread.sleep(1000);
				type("DescriptionOfContribution2", DescriptionContribution2);
				Thread.sleep(2000);
				scrollToBotton(); //
				scrollUP();
				Thread.sleep(2000);
				for(int p=10; p<=17; p++) {
					if(p==13) { scrolldown();}
						
					
					driver.findElement(By.xpath("(//*[@type='number'])["+p+"]")).sendKeys(BudgetRateNumber);	
					Thread.sleep(3000);
				}
				scrollToTOPOfPage(); 
				
				//2b tab
				//Incentives
				click("Incentives/Surcharges");
				Thread.sleep(2000);
				click("IncentivesRateTiersDropdown");
				Thread.sleep(2000);
				Multiselectcheckbox(IncentivesNameRateTiers);
				Thread.sleep(1000);
				click("RateTiersDropdownUP");
				Thread.sleep(2000);
				for(int q=18; q<=19; q++) {
				
						
					
					driver.findElement(By.xpath("(//*[@type='number'])["+q+"]")).sendKeys(BudgetRateNumber);	
					Thread.sleep(3000);
				}
				Thread.sleep(2000);
				scrollToTOPOfPage();
				//3rd Tab
				click("AnnualEnrollmentDecisions");
				Thread.sleep(2000);
				click("AnnualEnrollmentCalenderIcon");
				Thread.sleep(2000);
				datePickerFrom("CalculatorBody", EnrollmentFromDate);
				Thread.sleep(1000);
				click("AnnualEnrollmentCalenderIconTwo");
				Thread.sleep(1000);
				click("MonthAfter");
				Thread.sleep(1000);
				datePickerFrom("CalculatorBody", EnrollmentToDate);
				Thread.sleep(1000);
				click("AnnualEnrollmentMaterialDeliveryDropdown");
				Thread.sleep(1000);
				Multiselectcheckbox(EnrollmentMaterialValue);
				Thread.sleep(1000);
				click("RateTiersDropdownUP");  
				Thread.sleep(1000);
				//4th Tab
				click("Task8Other");
				Thread.sleep(1000);
				click("OtherComments");
				type("OtherComments", ListOfGroups);
				Thread.sleep(1000);
				click("OtherNext");
				Thread.sleep(5000);
				click("complete");
					Thread.sleep(12000);
					Thread.sleep(3000);
					break; 
				}
				}
		 
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
