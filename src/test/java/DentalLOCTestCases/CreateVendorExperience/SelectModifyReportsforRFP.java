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

public class SelectModifyReportsforRFP extends TestBase {

@Test(dataProvider = "getData")
	
	public void selectModifyReportsforRFP(String clientName, String processName , String vendorName , String template , String VendorDueDate , String IntendToBidDateValue) throws InterruptedException, IOException, AWTException {
		
	
	
		Thread.sleep(8000); 
		click("TaskHyperLink");
		Thread.sleep(3000);
		click("SelectClient");
		Thread.sleep(1000);
		reset("SelectClient");
		Thread.sleep(6000);
		click("SelectClient");
		//Thread.sleep(6000);
		Thread.sleep(3000);
		type("SelectClient", clientName);
		 Thread.sleep(4000);
			WebElement webElement4 =driver.findElement(By.xpath(OR.getProperty("SelectClient")));
			webElement4.sendKeys(Keys.TAB); 
			
			Thread.sleep(8000); 
		
			click("TaskListAllTasks");
		Thread.sleep(5000);
		
		select("TaskListFilterByProcess", processName);
		Thread.sleep(5000);
		
		//4th Task
		
	       for(int l=1; l<=20;l++) 
	       {
	   			
	   			WebElement SelectModifyReportsForRFPInProgress  =driver.findElement(By.xpath("(//tr/td[4])["+l+"]"));
	   			
	   			      System.out.println(SelectModifyReportsForRFPInProgress.getText());
	   			  //l=2  nned to do
	   			      if(l==2 || l==7 ||l==10 || l==14 ){
	   			    	 // javascript executor for scroll down
	   			    	scrolldown();
	   			    	  }
	   			String INP3 = SelectModifyReportsForRFPInProgress.getText();
	   			String COM = "In Progress";
	   			  if (INP3.equalsIgnoreCase(COM)) {
	                    
	   				//click("Obtainutilization/claimVsPremiumReport");
	   				driver.findElement(By.xpath("(//td[@class='link'])["+l+"]")).click();
	   				System.out.println("Fourth Task clicked of Create vendor");
		
		Thread.sleep(20000);
	
   		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,-250)", "");
		
		click("CreateVendor4TaskCheckbox");
		Thread.sleep(3000);
		js2.executeScript("window.scrollBy(0,250)", "");
		//One more upload attachment  is there
		Thread.sleep(3000);
		click("COmplete");
		Thread.sleep(7000); 
		scrolldown();
		Thread.sleep(4000);
		scrollUP();
		break;  } 
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
