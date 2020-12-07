package DentalLOCTestCases.ClientMarketingPresentationDecisions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularCssContainingText;
import com.paulhammant.ngwebdriver.ByAngularModel;

import Base.TestBase;

public class ScheduleClientMarketingMeeting extends TestBase {

	@Test(dataProvider = "getData")
public void scheduleClientMarketingMeeting(String clientName, String processName , String POM , String AMDate , String FMDate) throws InterruptedException {

		Thread.sleep(10000);
		ProcessAssociateProcessManagerLogout();
   		Thread.sleep(3000);
   		
   	 //Login to Login Test processManager
		 
		 ProcessManagerloginToLockTon() ; 
		 Thread.sleep(8000);

	
		waitUntil("TaskHyperLink");
    click("TaskHyperLink");
	 Thread.sleep(6000);
	 reset("SelectClient"); 
	  Thread.sleep(3000);
	  click("SelectClient");
	  Thread.sleep(3000); 
	  
	  type("SelectClient", clientName);
		 
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
			WebElement Taskxpath= driver.findElement(By.xpath("(//tr/td[3])["+i+"]"));
			System.out.println(Taskxpath.getText());
			
			      System.out.println(Statusxpathvalue.getText());
			if(i==2 || i==7 ||i==10 || i==14){
					    	 // javascript executor for scroll down
				scrolldown();
					    	  }
			String	TaskxpathValue = Taskxpath.getText();
			String INP = Statusxpathvalue.getText();

			
			String COM = "In Progress";
			String ActualTaskValue = "Schedule Client Marketing Meeting - Dental";
			
			if (INP.equalsIgnoreCase(COM) && ActualTaskValue.equalsIgnoreCase(TaskxpathValue)) {
				System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText());
				
				driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).click();
				System.out.println("First Task of client PD -Schedule client marketing meeting");
				Thread.sleep(30000);
				type("PurposeofMeeting", POM);
				Thread.sleep(3000); 
				scrolldown();
				click("Attendees");
				Thread.sleep(1000);
				Actions builder = new Actions(driver);        
				builder.sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(3000);
				scrolldown();
				for(int k=1; k<=8 ; k++) {
				WebElement TimeSelect = driver.findElement(By.xpath("(//*[@class='chevron ngb-tp-chevron'])["+k+"]"));
				TimeSelect.click();
				Thread.sleep(1000);
				if(k==3 || k==4 || k==7 || k==8) {
					WebElement TimeSelect1 = driver.findElement(By.xpath("(//*[@class='chevron ngb-tp-chevron'])["+k+"]"));
					TimeSelect1.click();
					Thread.sleep(1000);
				}
				if( k==4) {
					scrolldown();
					Thread.sleep(1000);
				}
				
				}
			scrollUP();
			Thread.sleep(1000);
			click("AvailableMeetingDateCalenderIcon");
			Thread.sleep(1000);
			click("MonthAfter");
			Thread.sleep(3000);
			datePickerTo("AvailableMeetingDateCalendernumbers" , AMDate);
			Thread.sleep(3000);
			scrolldown();
			Thread.sleep(1000);
			scrolldown();
			click("FinalMeetingDateCalenderIcon");
			Thread.sleep(1000);
			click("MonthAfter");
			click("MonthAfter");
			Thread.sleep(3000);
			datePickerTo("FinalMeetingDateDateCalendernumbers" , FMDate);
			Thread.sleep(3000);
			click("complete");
			Thread.sleep(8000);
			break;
			}}

	}
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "ClientMarketingPD";
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
