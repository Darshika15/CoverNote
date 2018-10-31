package CoverNote.CoverNote_V_I;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.ExcelReader;




public class testRun {
	private WebDriver driver;
    private Loginpage objLp;
    private AddCoverNote objAcn;


@BeforeTest
public void setup(){
	System.setProperty("webdriver.chrome.driver", "src\\main\\java\\Resources\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://192.168.128.68:8017/admin/index.jsp");
	driver.manage().window().maximize();

}

@Test
public void coverNOteDetails() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	
      objLp=new Loginpage(driver);
	  objAcn=new AddCoverNote(driver);objLp.enterUsername("AUX_DarshikaH");
	  objLp.enterPassword("692408AzIT");
	  //Thread.sleep(1000);
	  
	  //login to the system
	  objLp.clickLoginButton();
	 // Thread.sleep(2500);
	  
	  //click on the page
	  objAcn.pageNavigation();
	  
	  ExcelReader ex=new ExcelReader("ddd");
	  
	  
	  //System.out.println("arshad_test "+ex.getData("",0));
	 // Thread.sleep(1000);
	  
	  //add cover note details
	  //deptarment code, finance code, book code
	 // objAcn.addCoverNoteDetails("dept 1","FT1","BP 1","350","Open","BN 1","50","20");
	  
	  objAcn.addCoverNoteDetails(ex.getData("A", 1),ex.getData("B", 1),ex.getData("C", 1),"350","Open","BN 1","50","20");
	  
	  driver.quit();
}
}
