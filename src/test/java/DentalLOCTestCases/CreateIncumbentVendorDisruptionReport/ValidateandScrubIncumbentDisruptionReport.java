package DentalLOCTestCases.CreateIncumbentVendorDisruptionReport;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class ValidateandScrubIncumbentDisruptionReport  extends TestBase{

	@Test(dataProvider = "getData")
	public void validateandScrubIncumbentDisruptionReport(String ClientName, String processName , String vendorName , String IntendToBidDateValue) throws InterruptedException, IOException {
		  
			Thread.sleep(10000);
			
		  click("TaskHyperLink");
			 Thread.sleep(6000);
			 reset("SelectClient"); 
			  Thread.sleep(6000);
			  click("SelectClient");
			  Thread.sleep(6000); 
			  type( "SelectClient", ClientName);
			  Thread.sleep(6000);
				WebElement webElement2 = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
				Thread.sleep(2000);
				webElement2.sendKeys(Keys.TAB);
			 // click("LM");
			 
				Thread.sleep(8000);
			 
			 
			 select("TaskListFilterByProcess", processName);
				Thread.sleep(5000);
				
				//3rd Task
				
				for(int k=1; k<=20;k++) {
					
					WebElement  StatusxpathvalueforValidatescrubDisruption  =driver.findElement(By.xpath("(//tr/td[4])["+k+"]"));
					//AllObtainDistributionReportxpathvalue
					      System.out.println(StatusxpathvalueforValidatescrubDisruption.getText());
				
					      if(k==2 || k==7 ||k==10 || k==14){
						    	 // javascript executor for scroll down
					    	  scrolldown();
						    	  }
					String INPValidatescrubDisruption = StatusxpathvalueforValidatescrubDisruption.getText();

					
				String COM = "In Progress";
					
		   		   if (INPValidatescrubDisruption.equalsIgnoreCase(COM)) {
		   			System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+k+"]")).getText());
						driver.findElement(By.xpath("(//td[@class='link'])["+k+"]")).click();
						System.out.println("Third Task clicked of Incumbent Vendor");
						Thread.sleep(20000);
						
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0, -250)", "");
						Thread.sleep(1500);
						click("DownloadVendorExperience");
						Thread.sleep(4000);
						scrolldown();
						scrolldown();
						click("ValidateScrubDisruption3taskselectfieldstoincludeinRFP");
						Thread.sleep(3000);
						for(int n=1; n<4;n++) {
							
							
							driver.findElement(By.xpath("(//*[@class='text-center'])["+n+"]")).click();	
						}
						Thread.sleep(1000);
					click("SelectDataFieldscheckboxComplete");
					Thread.sleep(4000);
					click("IncumbentVendorDisruptionTask3Complete");
					 Thread.sleep(15000);
					
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


