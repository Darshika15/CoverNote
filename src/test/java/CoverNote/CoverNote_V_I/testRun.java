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
	  
	  //click on the page
	  objAcn.pageNavigation();
	  
	  //pass the excel file for the excel reader
	  ExcelReader ex=new ExcelReader("src\\main\\java\\Resources\\CN_test_data.xlsx");
	  

	  //add cover note details
	  objAcn.addCoverNoteDetails(ex.getData("deptCode", 1),ex.getData("fundType", 1),ex.getData("bookPrefix", 1),ex.getData("bookNumber", 1),ex.getData("numberOfBooks", 1),ex.getData("status", 1),ex.getData("bookletNature", 1),ex.getData("numberOfPages", 1),ex.getData("fromNumber", 1));
	  //(String strdeptCode,String strfundType,String strbookNumPrefix,String strbookNumber,String strnoOfBooks,String strStatus,String strbookletNature,String strPages,String strfromNo)
	  //driver.quit();
}
}
