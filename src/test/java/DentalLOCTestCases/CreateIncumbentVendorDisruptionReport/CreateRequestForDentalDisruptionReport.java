package DentalLOCTestCases.CreateIncumbentVendorDisruptionReport;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class CreateRequestForDentalDisruptionReport extends TestBase {
	
	@Test(dataProvider = "getData")
public void createRequestForDentalDisruptionReport(String ClientName, String processName , String vendorName , String IntendToBidDateValue) throws InterruptedException, IOException {
	  
		Thread.sleep(10000);
		waitUntil("TaskHyperLink");
    click("TaskHyperLink");
	 Thread.sleep(6000);
	 reset("SelectClient"); 
	  Thread.sleep(3000);
	  click("SelectClient");
	  Thread.sleep(3000); 
	  
	  type("SelectClient", ClientName);
		 
	  Thread.sleep(7000);
		
	  WebelementTab();
	 
		

	  Thread.sleep(8000);
	  click("TaskListAllTasks");
	  Thread.sleep(6000);
	 select("TaskListFilterByProcess", processName);
		Thread.sleep(6000);  
		
		//1st task
		
	 for(int i=1; i<=20;i++) {
			
			WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+i+"]"));
			
			      System.out.println(Statusxpathvalue.getText());
			if(i==2 || i==7 ||i==10 || i==14){
					    	 // javascript executor for scroll down
				scrolldown();
					    	  }
			String INP = Statusxpathvalue.getText();

			
			String COM = "In Progress";
			
			if (INP.equalsIgnoreCase(COM)) {
				System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText());
				
				driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).click();
				System.out.println("First Task clicked of Incumbent Vendor");
				Thread.sleep(30000);
				
			
				click("SelectDataFields");
				Thread.sleep(2000);
				//Multiple click on Checkbox
				for(int j=1; j<7;j++) {
					
					
					driver.findElement(By.xpath("(//*[@class='text-center'])["+j+"]")).click();	
				}
				scrollToParticularElementSecond("SelectDataFieldscheckboxComplete");
				
				//click("SelectDataFieldscheckboxComplete");
				Thread.sleep(2000);
				click("SelectEndodontistsDental");
				Thread.sleep(3000);
				 
				scrolldown();
	              click("SelectVendorContactTask1IncumbentVendor");
				Thread.sleep(3000);
				//Cigma
				selectByindex("SelectVendorContactTask1IncumbentVendor");
				//select("SelectVendorContactTask1IncumbentVendor" , vendorName);
				Thread.sleep(3000);
				scrolldown();
				
				click("CalendarIcon"); 
				//mo time to give
				Thread.sleep(1000);
				//click("MonthAfter");
				Thread.sleep(3000);
				//click("MonthAfter");
				//2 below same date picker as, now date picker is not able to click date due to application issue
				datePickerGeneral("DueDateForVendorTask1IncumbentVendor");
				
				Thread.sleep(3000);
				
				click("COmplete");
				Thread.sleep(20000); 
				
				
			break;
			}
			} 
	
	}



@DataProvider
public Object[][] getData(){
	
	String sheetName = "CreateIncumbentVendor";
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

