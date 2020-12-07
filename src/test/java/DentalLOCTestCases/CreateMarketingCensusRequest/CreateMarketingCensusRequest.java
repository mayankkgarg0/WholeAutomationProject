package DentalLOCTestCases.CreateMarketingCensusRequest;

import java.awt.Window;
import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

import Base.TestBase;

public class CreateMarketingCensusRequest   extends TestBase {

	
	@Test(dataProvider = "getData")
	public void createMarketingCensusRequest(String ClientName, String processName , String vendorName, 
			String taskOneDropDownOneLOC, String Dropdown2ValueMarketCensusTask12pageLOC , String Dropdown3ValueMarketCensusTask12pageLOC ,
			String Dropdown1ValueMarketCensusTask32pageFileIncludes ) throws InterruptedException, IOException {
		 
		
		Thread.sleep(6000);
		    click("TaskHyperLink");
		Thread.sleep(6000);
		 reset("SelectClient");; 
		  Thread.sleep(2000);
		  click("SelectClient");
		  Thread.sleep(2000);
		  type( "SelectClient", ClientName);
			
			WebElement webElement = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
			Thread.sleep(2000);
			webElement.sendKeys(Keys.TAB);
		  //click("LM");//thread increase
		  Thread.sleep(6000);
		 
		 
		 select("TaskListFilterByProcess", processName);
			Thread.sleep(6000);  
			
			//Market Census in process select is not reflecting for filtering task for market census for automation?
			//1st task
				for(int i=1; i<=20;i++) {
				
				WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+i+"]"));
				
				      System.out.println(Statusxpathvalue.getText());
				if(i==3 || i==7 ||i==10 || i==14){
						    	 // javascript executor for scroll down
					scrolldown();
						    	  }
				String INP = Statusxpathvalue.getText();

				
				String COM = "In Progress";
				System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText());
				if (INP.equalsIgnoreCase(COM)) {
					System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText());
					driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).click();
					System.out.println("First Task clicked of Marketing Census");
					
					Thread.sleep(20000);
					//to scroll to top of page
					((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
					Thread.sleep(1000);
					scrolldown(); 
					//scrollUP();
					   click("Dropdown1MarketCensusTask12pageLOC");
					   Thread.sleep(3000);
					//for Cigna scott value
					   Multiselectcheckbox(taskOneDropDownOneLOC);
					   Thread.sleep(3000);
					   
					   click("Dropdown1MarketCensusTask12pageLOC");
					   
					   //click("Dropdown2MarketCensusTask12pageLOC");
					   Thread.sleep(3000);
					   Multiselectcheckbox(Dropdown2ValueMarketCensusTask12pageLOC);
					   Thread.sleep(3000);
					   click("Dropdown2MarketCensusTask12pageLOC");
					
					   
					   //click("Dropdown3MarketCensusTask12pageLOC");
					   Thread.sleep(3000);
					   Multiselectcheckbox(Dropdown3ValueMarketCensusTask12pageLOC);
					   Thread.sleep(3000);
					   //click("Dropdown3MarketCensusTask12pageLOC");
					   
					   click("SelectCensusDataFieldsMarketCensusTask12pageLOC");
					   Thread.sleep(5000);
					   click("EmployeeFirstNameMarketCensusTask12pageLOC");
					   Thread.sleep(3000);
					   
					   //Loop needs to be included for second row data run as diff option are there
					   
					  
						
				  
					   Thread.sleep(3000);
					   scrollToParticularElementSecond("MarketCensustaskoneSelectCensusnewWindowComplete");
					   
					  
				  
					   // driver.switchTo().activeElement();
					   Thread.sleep(3000);
					   scrollToBotton();
					   Thread.sleep(3000);
					   click("CalendarIcon");
					   Thread.sleep(3000);
					   
					   datePickerGeneral("DuedateforclienttoreturnCensus");
				       
					   Thread.sleep(3000);
					   click("MarketCensustaskoneComplete");
					   Thread.sleep(10000);
					break;
					}
					
}  
	
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
