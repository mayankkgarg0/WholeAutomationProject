package DentalLOCTestCases.CreateMarketingCensusRequest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class PeerReviewMarketingCensusRequest extends TestBase {

	@Test(dataProvider = "getData")
	public void peerReviewMarketingCensusRequest(String ClientName, String processName , String vendorName, 
			String taskOneDropDownOneLOC, String Dropdown2ValueMarketCensusTask12pageLOC , String Dropdown3ValueMarketCensusTask12pageLOC ,
			String Dropdown1ValueMarketCensusTask32pageFileIncludes ) throws InterruptedException, IOException {
		 
		
		
	//Logout and Login Code 
	 Thread.sleep(3000);
		 ProcessAssociateProcessManagerLogout();
		 Thread.sleep(6000);
		 //Login to Login Test processManager
		 ProcessManagerloginToLockTon() ; 
		 Thread.sleep(8000);
		
		    click("TaskHyperLink");
		Thread.sleep(6000);
		 reset("SelectClient");; 
		  Thread.sleep(6000);
		  click("SelectClient");
		  Thread.sleep(6000); 
		  type( "SelectClient", ClientName);
			
			WebElement webElement1 = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
			Thread.sleep(2000);
			webElement1.sendKeys(Keys.TAB);
		//  click("LM");
		  Thread.sleep(6000);
		 
		 select("TaskListFilterByProcess", processName);
			Thread.sleep(5000); 
	    
			//2nd Task
	
               for(int j=1; j<=20;j++) {
				
				WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+j+"]"));
				
				      System.out.println(Statusxpathvalue.getText());
				if(j==3 || j==7 ||j==10 || j==14){
						    	 // javascript executor for scroll down
					scrolldown();
						    	  }
				String INP = Statusxpathvalue.getText();

				
				String COM = "In Progress";
				
				if (INP.equalsIgnoreCase(COM)) {
					System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+j+"]")).getText());
					driver.findElement(By.xpath("(//td[@class='link'])["+j+"]")).click();
					System.out.println("Second Task clicked of Marketing Census");
					Thread.sleep(15000);
					scrollToBotton();
					Thread.sleep(3000);
					click("PeerReviewCensusRequestTask3approveButton");
					Thread.sleep(3000);
					click("MarketCensustaskTwoComplete");
					Thread.sleep(10000);
					break;
				}
				} 
			
			//Logout Process Manager
		ProcessAssociateProcessManagerLogout();
		Thread.sleep(3000);
		//Login Process Associate
		ProcessAssociateloginToLockTon(); 
		
		Thread.sleep(8000);
	
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

