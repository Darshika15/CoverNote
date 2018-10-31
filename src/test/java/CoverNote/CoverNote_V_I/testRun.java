package CoverNote.CoverNote_V_I;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




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
public void coverNOteDetails() throws InterruptedException
{
	
      objLp=new Loginpage(driver);
	  objAcn=new AddCoverNote(driver);objLp.enterUsername("AUX_DarshikaH");
	  objLp.enterPassword("692408AzIT");
	  Thread.sleep(1000);
	  
	  //login to the system
	  objLp.clickLoginButton();
	  Thread.sleep(2500);
	  
	  //click on the page
	  objAcn.pageNavigation();
	  Thread.sleep(1000);
	  
	  //add cover note details
	  objAcn.addCoverNoteDetails("dept 1","F01","BP 1","350","Open","BN 1","50","20");
}
}
