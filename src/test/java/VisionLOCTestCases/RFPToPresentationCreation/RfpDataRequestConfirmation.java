package VisionLOCTestCases.RFPToPresentationCreation;

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

public class RfpDataRequestConfirmation extends TestBase {

	@Test(dataProvider = "getData")

	public void rfpDataRequestConfirmation(String clientName, String processName, String DisruptionDropdown, String VendorExperienceDropdown ) throws InterruptedException {

		try {
			Thread.sleep(9000);
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
			 
			Thread.sleep(5000);
			
			select("TaskListFilterByProcess", processName);
			Thread.sleep(5000);
			
			for(int i=1; i<=12;i++) {
				
			WebElement xpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+i+"]"));
			
			      System.out.println(xpathvalue.getText());
			      if(i==3 || i==9 ||i==14){
				    	 // javascript executor for scroll down
				    	  JavascriptExecutor js = (JavascriptExecutor) driver;
				  		js.executeScript("window.scrollBy(0, 250)", "");
				    	  }
			
			String INP = xpathvalue.getText();

			// String COM = "Completed";
			String COM = "In Progress";
			String XpathRFPDRC = getText("TaskRFPDataReqConfirmationVision");
			String x="RFP Data Request Confirmation - Vision";
			if (INP.equalsIgnoreCase(COM) && x.equalsIgnoreCase(XpathRFPDRC)) {

				driver.findElement(By.xpath("(//*[text()=' RFP Data Request Confirmation - Vision'])["+i+"]")).click();

				Thread.sleep(10000);
				System.out.println("checkin radio");
				scrolldown();

				
				
		        Thread.sleep(3000);
     // 1) Census
			 click("RfpDataCensusRequiredYes");
			Thread.sleep(3000);
	 
	// 2)		//Incumbent Vendor
		
			 click("RfpDataDisruptoinRequiredYes");
			 Thread.sleep(3000);
			
			 click("VendorDisruptionDropdown");
				Thread.sleep(1000);
				//Metropolitan Life Insurance Company(DEPO - New Plan) 
				Multiselectcheckbox(DisruptionDropdown);
				
				 Thread.sleep(1000);
				 click("VendorDisruptionDropdown");
				
			
				 scrolldown();
				 Thread.sleep(2000);
	  // 3)  Create Vendor Experience
				click("RfpDataVendorExpRequiredYes");
				Thread.sleep(2000);
				click("VendorExperienceDropdown");
				Thread.sleep(2000);
				//Multiselectcheckbox(VendorExperienceDropdown);
				//Cigna Corporation
				driver.findElement(By.xpath("(//li/div[text()='"+VendorExperienceDropdown+"'])[2]")).click();
				
				Thread.sleep(2000);
				click("VendorExperienceDropdown");
				
				Thread.sleep(3000);
				
				scrolldown();
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
	public Object[][] getData() {

		String sheetName = "RfpData";
		int rows = Visionexcel.getRowCount(sheetName);
		int cols = Visionexcel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = Visionexcel.getCellData(sheetName, colNum, rowNum);
			}

		}
		return data;

	}

}
