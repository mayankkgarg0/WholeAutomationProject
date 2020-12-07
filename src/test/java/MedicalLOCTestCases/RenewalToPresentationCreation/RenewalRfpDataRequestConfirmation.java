package MedicalLOCTestCases.RenewalToPresentationCreation;

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

public class RenewalRfpDataRequestConfirmation extends TestBase {

	@Test(dataProvider = "getData")
public void rfpDataRequestConfirmation(String clientName, String processName, String DisruptionDropdown) throws InterruptedException {

		try {
					Thread.sleep(15000);
			click("TaskHyperLink");
			Thread.sleep(3000);
			reset("SelectClient");
			Thread.sleep(3000);
			click("SelectClient");
			Thread.sleep(6000);
			
			
			type("SelectClient", clientName);
			Thread.sleep(4000);
			
			
			WebElement webElement =driver.findElement(By.xpath(OR.getProperty("SelectClient")));
			webElement.sendKeys(Keys.TAB);
			
			Thread.sleep(6000);
			
			select("TaskListFilterByProcess", processName);
			Thread.sleep(5000);
			
			for(int i=1; i<=12;i++) {
				
				WebElement TaskName =driver.findElement(By.xpath("(//tr/td[3])["+i+"]"));
				
				String TaskNameTestValue = TaskName.getText();
				System.out.println(TaskNameTestValue);
				
			WebElement Status =driver.findElement(By.xpath("(//tr/td[4])["+i+"]"));
			String StatusValue = Status.getText();
			      System.out.println(StatusValue);
			      
			      if(i==3 || i==9 ||i==14){
				    	  scrolldown();
				    	  }
			
			String StatusRequired = "In Progress";
			
			String TaskNameRequired="Renewal Data Request Confirmation";
			
			if (StatusValue.equalsIgnoreCase(StatusRequired) && TaskNameRequired.equalsIgnoreCase(TaskNameTestValue)) {

				driver.findElement(By.xpath("(//tr/td[3])["+i+"]")).click();
				
				Thread.sleep(10000);
				
				click("RenewalRfpDataCensusRequiredYes");
				Thread.sleep(2000);
				scrolldown();
				
				click("RenewalRfpDataDisruptoinRequiredYes");
				Thread.sleep(2000);
				click("RenewalVendorDisruptionDropdown");
				Thread.sleep(2000);
				Multiselectcheckbox(DisruptionDropdown);
				Thread.sleep(2000);
				click("RenewalVendorDisruptionDropdown");
				Thread.sleep(3000);
				scrolldown();
              
				click("RenewalSelfFunded");
				
				
				Thread.sleep(3000);
				click("RfpDataComplete"); 
				Thread.sleep(6000);
            break;
			}
			
			} 	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "RenewalRFPData";
		int rows = Medicalexcel.getRowCount(sheetName);
		int cols = Medicalexcel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for (int rowNum=2; rowNum<=rows; rowNum++)
		{
			for (int colNum=0; colNum<cols; colNum++)
			{
				data[rowNum-2][colNum] = Medicalexcel.getCellData(sheetName, colNum, rowNum);
			}
				
		}
		return data;
		
	}	

}
