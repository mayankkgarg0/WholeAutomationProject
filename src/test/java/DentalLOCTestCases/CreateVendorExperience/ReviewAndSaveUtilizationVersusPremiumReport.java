package DentalLOCTestCases.CreateVendorExperience;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class ReviewAndSaveUtilizationVersusPremiumReport extends TestBase {

@Test(dataProvider = "getData")
	
	public void reviewAndSaveUtilizationVersusPremiumReport(String clientName, String processName , String vendorName , String template , String VendorDueDate, String IntendToBidDateValue) throws InterruptedException, IOException, AWTException {
		
	
		Thread.sleep(4000); 
		click("TaskHyperLink");
		Thread.sleep(3000);
		
		click("SelectClient");
		Thread.sleep(3000);
		reset("SelectClient");
		Thread.sleep(3000);
		click("SelectClient");
		Thread.sleep(3000);
		type("SelectClient", clientName);
		 Thread.sleep(4000);
			WebElement webElement3 =driver.findElement(By.xpath(OR.getProperty("SelectClient")));
			webElement3.sendKeys(Keys.TAB);
			
			Thread.sleep(8000); 
		
			click("TaskListAllTasks");
		Thread.sleep(5000);
		select("TaskListFilterByProcess", processName);
		Thread.sleep(3000);
		//3rd Task
		
           for(int k=1; k<=20;k++) 
    {
			
			WebElement ReviewAndSaveUtilizationClaimVersusPremiumReportInProgress  =driver.findElement(By.xpath("(//tr/td[4])["+k+"]"));
			
			      System.out.println(ReviewAndSaveUtilizationClaimVersusPremiumReportInProgress.getText());
			  //k==2 need to do
			      if(k==2 || k==7 ||k==10 || k==14){
			    	 // javascript executor for scroll down
			    	  scrolldown();
			    	  }
			String INP2 = ReviewAndSaveUtilizationClaimVersusPremiumReportInProgress.getText();
			String COM = "In Progress";
			  if (INP2.equalsIgnoreCase(COM)) {
                 //1st task
				//click("Obtainutilization/claimVsPremiumReport");
				driver.findElement(By.xpath("(//td[@class='link'])["+k+"]")).click();
		
				System.out.println("Third Task clicked of Create vendor");
				
				//click("ReviewAndSaveUtilization/ClaimVersusPremiumReport");
		
	Thread.sleep(20000);
	scrollUP();
		click("CreateVendor3TaskApproveButton");
		Thread.sleep(4000);
		
		click("COmplete"); 
		Thread.sleep(8000);
		
		 break;	  }
} 
	
}  
	
	
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "CreateVendor";
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
