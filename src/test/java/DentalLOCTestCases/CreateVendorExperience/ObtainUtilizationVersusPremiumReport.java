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

public class ObtainUtilizationVersusPremiumReport extends TestBase{

@Test(dataProvider = "getData")
	
	public void obtainUtilizationVersusPremiumReport (String clientName, String processName , String vendorName , String template , String VendorDueDate, String IntendToBidDateValue) throws InterruptedException, IOException, AWTException {
		
	
		//first task complete
		//2nd task
		
		Thread.sleep(10000); 
		click("TaskHyperLink");
		Thread.sleep(3000);
		click("SelectClient");
		reset("SelectClient");
		Thread.sleep(6000);
		click("SelectClient");
		Thread.sleep(6000);
		
		type("SelectClient", clientName);
		 Thread.sleep(4000);
		 WebelementTab();
			
			
		 Thread.sleep(5000); 
		waitUntil("TaskListAllTasks");
			click("TaskListAllTasks"); //thread.sleep not responding
		
		Thread.sleep(3000);
		select("TaskListFilterByProcess", processName);
		
		Thread.sleep(6000);
		
	
		for(int j=1; j<=20;j++) {
			
			WebElement DynamicObtainutilizationclaimVsPremiumReportInProgress =driver.findElement(By.xpath("(//tr/td[4])["+j+"]"));
			
			      System.out.println(DynamicObtainutilizationclaimVsPremiumReportInProgress.getText());
			  
			      if(j==2 || j==7 ||j==10 || j==14){
			    	 // javascript executor for scroll down
			    	 scrolldown();
			    	  }
			String INP1 = DynamicObtainutilizationclaimVsPremiumReportInProgress.getText();
			String COM = "In Progress";
			  if (INP1.equalsIgnoreCase(COM)) {
                 //1st task
				//click("Obtainutilization/claimVsPremiumReport");
				driver.findElement(By.xpath("(//td[@class='link'])["+j+"]")).click();
				System.out.println("Second Task clicked of Create vendor");
		
		


		Thread.sleep(35000);
		click("ObtainUtilizationAddAttachment");
		Thread.sleep(3000);
		//AutoIT
		
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
		
		Thread.sleep(7000); // scroll to botton to include
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(7000);
		
		click("COmplete"); 
		Thread.sleep(12000); 
		
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
