package DentalLOCTestCases.CreateMarketingCensusRequest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class InternalReviewMarketingCensusData extends TestBase {

	@Test(dataProvider = "getData")
	public void internalReviewMarketingCensusDatat(String ClientName, String processName , String vendorName, 
			String taskOneDropDownOneLOC, String Dropdown2ValueMarketCensusTask12pageLOC , String Dropdown3ValueMarketCensusTask12pageLOC ,
			String Dropdown1ValueMarketCensusTask32pageFileIncludes ) throws InterruptedException, IOException {
		 
		Thread.sleep(8000);
		ProcessAssociateProcessManagerLogout();
   		Thread.sleep(3000);
   		
   	 //Login to Login Test processManager
		 
		 ProcessManagerloginToLockTon() ; 
		 Thread.sleep(8000);
		
		//Task5///////////
	   		 Thread.sleep(10000);
	   		
	   		    click("TaskHyperLink");
	   		Thread.sleep(6000);
	   		 reset("SelectClient");; 
	   		  Thread.sleep(6000);
	   		  click("SelectClient");
	   		  Thread.sleep(6000); 
	   		type( "SelectClient", ClientName);
			
			WebElement webElement4 = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
			Thread.sleep(2000);
			webElement4.sendKeys(Keys.TAB);
	   		  //click("LM");
	   		  Thread.sleep(6000);
	   		 
	   		 select("TaskListFilterByProcess", processName);
	   			Thread.sleep(5000); 
	   	    
	   			
	   	
	                  for(int m=1; m<=20;m++) {
	   				
	   				WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+m+"]"));
	   				
	   				      System.out.println(Statusxpathvalue.getText());
	   				if(m==2 || m==7 ||m==10 || m==14){
	   						    	 // javascript executor for scroll down
	   					scrolldown();
	   						    	  }
	   				String INP = Statusxpathvalue.getText();

	   				
	   				String COM = "In Progress";
	   				
	   				if (INP.equalsIgnoreCase(COM)) {
	   					System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+m+"]")).getText());
	   					driver.findElement(By.xpath("(//td[@class='link'])["+m+"]")).click();
	   					System.out.println("Fifth Task clicked of Marketing Census");
	   					Thread.sleep(10000);
	   					scrolldown();
	   					scrolldown();
	   					
	   					Thread.sleep(3000);
	   					
						click("MarketCensusTaskValinScrubDownloadTemplate");
	   					
	   					Thread.sleep(5000);
	   					scrollToBotton();
	   					Thread.sleep(1000);
						click("DragAndDrop");
						Thread.sleep(2000);
						Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\ObtainCensusInfo.exe");
						
						Thread.sleep(8000);
						
						click("PeerReviewCensusRequestTask3approveButton");
	   					
	   					
	   					Thread.sleep(3000);
	   					click("complete");
						Thread.sleep(6000);
						scrolldown();
						Thread.sleep(4000);
	   				break;}
	   				}
	
	
	ProcessAssociateProcessManagerLogout();
	Thread.sleep(3000);
	//Login Process Associate
	ProcessAssociateloginToLockTon(); 
	Thread.sleep(6000);
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

