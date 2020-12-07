package DentalLOCTestCases.CreateMarketingCensusRequest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class ObtainMarketingCensusInfo extends TestBase{

	@Test(dataProvider = "getData")
	public void obtainMarketingCensusInfo(String ClientName, String processName , String vendorName, 
			String taskOneDropDownOneLOC, String Dropdown2ValueMarketCensusTask12pageLOC , String Dropdown3ValueMarketCensusTask12pageLOC ,
			String Dropdown1ValueMarketCensusTask32pageFileIncludes ) throws InterruptedException, IOException {
		 
		
		
		
		Thread.sleep(10000);
	
		  click("TaskHyperLink");
			Thread.sleep(6000);
			 reset("SelectClient");; 
			  Thread.sleep(6000);
			  click("SelectClient");
			  Thread.sleep(6000); 
			  type( "SelectClient", ClientName);
				
				WebElement webElement2 = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
				Thread.sleep(2000);
				webElement2.sendKeys(Keys.TAB);
			 // click("LM");
			  Thread.sleep(6000);
			 
			 select("TaskListFilterByProcess", processName);
				Thread.sleep(5000); 
		    
				//3rd Task
		
	               for(int k=1; k<=20;k++) {
					
					WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+k+"]"));
					
					      System.out.println(Statusxpathvalue.getText());
					if(k==2 || k==7 ||k==10 || k==14){
							    	 // javascript executor for scroll down
						scrolldown();
							    	  }
					String INP = Statusxpathvalue.getText();

					
					String COM = "In Progress";
					
					if (INP.equalsIgnoreCase(COM)) {
						System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+k+"]")).getText());
						Thread.sleep(3000);
						driver.findElement(By.xpath("(//td[@class='link'])["+k+"]")).click();
						System.out.println("Third Task clicked of Marketing Census");
						Thread.sleep(9000);
						scrollToBotton();
						scrollUP();
						Thread.sleep(3000);
						click("ObtainCensusInfoTheFileIncludes");
						Thread.sleep(3000);
						
						
						Multiselectcheckbox(Dropdown1ValueMarketCensusTask32pageFileIncludes);
						Thread.sleep(3000);
						click("CalendarIcon");
						Thread.sleep(3000);
						datePickerGeneral("DateObtaincensusInfotask2");
						Thread.sleep(3000);
						click("DragAndDrop");
						Thread.sleep(3000);
						Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
						Thread.sleep(5000);
						//break point need to check
						scrollToBotton();
						//this complete was not able to work
						click("complete");
						Thread.sleep(5000);
						break;
					}} 
	        
                        
 
	}
	


	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "CreateMarketingCensus";
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

