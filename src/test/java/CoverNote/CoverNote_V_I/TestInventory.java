package CoverNote.CoverNote_V_I;


import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Utilities.ExcelReader;
import static Utilities.ExcelReader.*;


public class TestInventory {
	private WebDriver driver;
    private Inventory_Login objLp;
    private AddCoverNote objAcn;
    private Purchase_Requisition_Note objPurchaserequest;
    private DispatchCoverNote objDispatchCoverNote;
    private TestRequestFirstCoverNoteBook objTestRequestFirstCoverNoteBook;
    private TestRequestCoverNote objTestRequestCoverNote;
    private TestReceivedCovernotes objTestReceivedcovernotes;
    private TestUnderwriteApprove objTestUnderwriteApprove;
    private Travels_Register objTravels_Register;


//@BeforeTest
 @Test
public void setup() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{

	System.setProperty("webdriver.chrome.driver", "src\\main\\java\\Resources\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	driver.manage().window().maximize();
    //objLp=new Inventory_Login(driver);
   /* objLp.enterUsername("t221");
    objLp.enterPassword("allianz@2018");
	objLp.clickLoginButton();*/
    //objLp.forgetPassword("test@test.com");
	//objLp.emailValidation("test@testcom");
    //objLp.phonenumberValidation("123456789a");
	objTravels_Register=new Travels_Register(driver);
	ExcelReader ex= new ExcelReader("src\\main\\java\\Resources\\CN_test_data.xlsx");
	objTravels_Register.register(getData("firstname",1),getData("lastname",1),getData("Phone",1),getData("Email",1),getData("address1",1),getData("city",1),getData("state",1),getData("postalCode", 1),getData("country", 1),getData("uname",1),getData("pword",1),getData("Confirmpword",1));
}

//@Test
public void dispatchInitialCoverNote() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{

    //objTestRequestFirstCoverNoteBook=new TestRequestFirstCoverNoteBook();
	//objTestRequestFirstCoverNoteBook.setup();
	//objTestRequestFirstCoverNoteBook.addCNDetails();
    //setup();
    objDispatchCoverNote=new DispatchCoverNote(driver);
    objDispatchCoverNote.clickIntoDashBoard();
  /*  Thread.sleep(2500);
    objDispatchCoverNote.viewApproval();
    Thread.sleep(2500);
    objDispatchCoverNote.clickInitialApproval();
    objDispatchCoverNote.closeApprovalScreen();
    Thread.sleep(2500);*/
    objDispatchCoverNote.clickViewDispatchRequest();
    objDispatchCoverNote.addToDispatchQueue();
    Thread.sleep(2500);
    objTestReceivedcovernotes=new TestReceivedCovernotes();
    objTestReceivedcovernotes.setup();
    Thread.sleep(2500);
    objTestReceivedcovernotes.covernoteAssign();
    
     
}

//@Test
public void dispatchInlieuCoverNote() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
{
	  /*objTestRequestCoverNote=new TestRequestCoverNote();
	    objTestRequestCoverNote.setup();
	    objTestRequestCoverNote.requestCoverNote();
	  	objTestUnderwriteApprove=new TestUnderwriteApprove();
	   	objTestUnderwriteApprove.setup();
	    objTestUnderwriteApprove.UnderwriteApprove();*/
	    setup();
	    Thread.sleep(2500);
	    objDispatchCoverNote=new DispatchCoverNote(driver);
	    objDispatchCoverNote.clickIntoDashBoard();
	    Thread.sleep(75000);
	    objDispatchCoverNote.clickViewDispatchRequest();
	    Thread.sleep(75000);
	    objDispatchCoverNote.addToDispatchQueue();
	  	Thread.sleep(75000);
	    objTestReceivedcovernotes=new TestReceivedCovernotes();
	    objTestReceivedcovernotes.setup();
	    Thread.sleep(2500);
	    objTestReceivedcovernotes.covernoteAssign();
	    
}


//@AfterTest
public void closebrowser()
{
  driver.quit();
}


}


