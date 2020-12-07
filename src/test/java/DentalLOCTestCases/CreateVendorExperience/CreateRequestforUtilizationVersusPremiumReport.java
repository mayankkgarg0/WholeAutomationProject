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

public class CreateRequestforUtilizationVersusPremiumReport extends TestBase {

@Test(dataProvider = "getData")
	
	public void createRequestforUtilizationVersusPremiumReport(String clientName, String processName , String vendorName , String template , String VendorDueDate, String IntendToBidDateValue) throws InterruptedException, IOException, AWTException {
		
	Thread.sleep(10000);
	click("TaskHyperLink");
		Thread.sleep(6000);
		click("SelectClient");
		reset("SelectClient");
		Thread.sleep(6000);
		click("SelectClient");
		Thread.sleep(6000);
		
		type( "SelectClient", clientName);
		
		WebElement webElement = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
		Thread.sleep(2000);
		webElement.sendKeys(Keys.TAB);
		//click("LM");
        Thread.sleep(7000);
        
		
		//Thread.sleep(3000);
		
	click("TaskListAllTasks");
		Thread.sleep(3000);
		select("TaskListFilterByProcess", processName);
		Thread.sleep(5000);
		//1st task
	for(int i=1; i<=20;i++) {
		
			WebElement xpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+i+"]"));
			
			      System.out.println(xpathvalue.getText());
			  
			      if(i==2 || i==7 ||i==10 || i==14){
			    	 // javascript executor for scroll down
			    	scrolldown();
			    	  }
			String INP = xpathvalue.getText();

			
			String COM = "In Progress";
			
			if (INP.equalsIgnoreCase(COM)) {
                 //1st task
				driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).click();
                    System.out.println("First Task clicked of Create vendor");
				
	
		
		//click("CreateUndefinedRequestDentalForUtilization");
		//More time to give
		Thread.sleep(30000);
		
		click("SelectVendorContact");
		Thread.sleep(3000);
		//Changed vendor name for CIGNA from Scott to Scott Scott.Talley@cigna.com

		select("SelectVendorContact" , vendorName);
		
		Thread.sleep(3000);
		//click("SelectVendorContact");
		//Thread.sleep(3000);
		
		//click("EmailTemplate");
		//type("EmailTemplate", template);
	
		scrolldown();
		scrolldown();
		click("CalendarIcon");
		

	
		//more time to give
		Thread.sleep(3000);
		click("MonthAfter");
		//Thread.sleep(3000);
		click("MonthAfter");
		datePickerGeneral("DueDateForVendor");
		
		Thread.sleep(3000);
		
		click("COmplete");
		Thread.sleep(8000); 
		break;
			
			} } 
		//first task complete
		//2nd task
		
		
		
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
