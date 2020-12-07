package DentalLOCTestCases.CreateMarketingCensusRequest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class ValidateAndScrubCensus extends TestBase {

	@Test(dataProvider = "getData")
	public void validateAndScrubCensus(String ClientName, String processName , String vendorName, 
			String taskOneDropDownOneLOC, String Dropdown2ValueMarketCensusTask12pageLOC , String Dropdown3ValueMarketCensusTask12pageLOC ,
			String Dropdown1ValueMarketCensusTask32pageFileIncludes ) throws InterruptedException, IOException {
		 
		
		
		
                         //4th Task
 Thread.sleep(10000);
 
		click("TaskHyperLink");
		Thread.sleep(6000);
		 reset("SelectClient");; 
		  Thread.sleep(6000);
		  click("SelectClient");
		  Thread.sleep(6000); 
		  type( "SelectClient", ClientName);
			
			WebElement webElement3 = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
			Thread.sleep(2000);
			webElement3.sendKeys(Keys.TAB);
		  //click("LM");
		  Thread.sleep(6000);
		 
		 select("TaskListFilterByProcess", processName);
			Thread.sleep(5000);   
	               
	               for(int l=1; l<=20;l++) {
						
						WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+l+"]"));
						
						      System.out.println(Statusxpathvalue.getText());
						if(l==2 || l==7 ||l==10 || l==14){
								    	 // javascript executor for scroll down
							scrolldown();
								    	  }
						String INP = Statusxpathvalue.getText();

						
						String COM = "In Progress";
						
						if (INP.equalsIgnoreCase(COM)) {
							System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+l+"]")).getText());
							Thread.sleep(3000);
							driver.findElement(By.xpath("(//td[@class='link'])["+l+"]")).click();
							System.out.println("Fourth Task clicked of Marketing Census");
							
							
							Thread.sleep(10000);
							scrolldown();
							
							Thread.sleep(1000);
							click("MarketCensusTaskValinScrubDownloadTemplate");
							Thread.sleep(1000);
							scrolldown();
							Thread.sleep(5000);
							click("DragAndDrop");
							Thread.sleep(2000);
							Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
							Thread.sleep(6000);
							scrollToBotton();
							click("complete");
							Thread.sleep(7000);
							break;
						}}
	               
	               //Task 5
		Thread.sleep(5000);
	             //Logout Process Manager
	       	
	   		
	   		  
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

