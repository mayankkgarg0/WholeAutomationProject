package DentalLOCTestCases.CreateIncumbentVendorDisruptionReport;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class ObtainDisruptionReport extends TestBase {
	@Test(dataProvider = "getData")
	public void obtainDisruptionReport(String ClientName, String processName , String vendorName ,String IntendToBidDateValue) throws InterruptedException, IOException {
		  
		Thread.sleep(10000);  
		
		click("TaskHyperLink");
			 Thread.sleep(3000);
			 reset("SelectClient"); 
			  Thread.sleep(3000);
			  click("SelectClient");
			  Thread.sleep(3000); 
			  type( "SelectClient", ClientName);
			 
			  Thread.sleep(7000);
			  
				WebElement webElement1 = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
				Thread.sleep(2000);
				webElement1.sendKeys(Keys.TAB);
			 // click("LM");
			  
				Thread.sleep(8000);
			  
			 select("TaskListFilterByProcess", processName);
				Thread.sleep(6000);
			
				//2nd task
		  for(int j=1; j<=20;j++) {
				
				WebElement  StatusxpathvalueforObtainDistribution  =driver.findElement(By.xpath("(//tr/td[4])["+j+"]"));
				//AllObtainDistributionReportxpathvalue
				      System.out.println(StatusxpathvalueforObtainDistribution.getText());
			
				String INPObtainDistribution = StatusxpathvalueforObtainDistribution.getText();
	          
	                          if(j==2 || j==7 ||j==10 || j==14){
						    	 // javascript executor for scroll down
	                        	  scrolldown();
						    	  }
				
			String COM = "In Progress";
				
	   		   if (INPObtainDistribution.equalsIgnoreCase(COM)) {
	   			System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+j+"]")).getText());
					driver.findElement(By.xpath("(//td[@class='link'])["+j+"]")).click();
					System.out.println("Second Task clicked of Incumbent Vendor");
					Thread.sleep(20000);
					
					
					click("ObtainDistributionAddAttachment");
					Thread.sleep(3000);
					
					//type(String locator, String value)
					//AutoIT
					
					//To check
					Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
					Thread.sleep(10000);
					scrolldown();
								
		     click("ObtainDistributionTask2Complete");
		     Thread.sleep(15000);
		     break; 
		  } } 
		  
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



