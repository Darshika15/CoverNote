package CoverNote.CoverNote_V_I;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCoverNote {
	WebDriver driver;
	private  Select deptCode;
	private Select fundType;
	private Select bookNumPrefix;
	private WebElement bookNumber;
	private WebElement coverNoteLink;
	private WebElement coverNoteGRNLink;
	private Select bookletNature;
	private Select pages;
	private WebElement fromNo;
	private Select status;
	private WebDriverWait wait;

	
	
	
	
	public  AddCoverNote(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, 30);
		
	}
	
	public void pageNavigation()
	{
		
		coverNoteLink=driver.findElement(By.linkText("Cover Note"));
		coverNoteLink.click();
		coverNoteGRNLink=driver.findElement(By.xpath("/html/body/section/div/div[1]/ul/li[5]/ul/li[1]/a"));
		coverNoteGRNLink.click();
		
	}
	
	public void addCoverNoteDetails(String strdeptCode,String strfundType,String strbookNumPrefix,String strbookNumber,String strStatus,String strbookletNature,String strPages,String strfromNo) throws InterruptedException
	{
		
		 
		//deptCode = new Select(driver.findElement(By.id("deptCode")));
		deptCode=new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deptCode"))));
		//Thread.sleep(2000);
		deptCode.selectByVisibleText(strdeptCode);
		fundType=new Select(driver.findElement(By.id("fundType")));
		//Thread.sleep(2000);
		fundType.selectByVisibleText(strfundType);
		//Thread.sleep(2000);
		bookNumPrefix=new Select(driver.findElement(By.id("bookNumPrefix")));
		//Thread.sleep(2000);
		bookNumPrefix.selectByVisibleText(strbookNumPrefix);
		bookNumber=driver.findElement(By.id("bookNumber"));
		bookNumber.sendKeys(strbookNumber);
		status = new Select(driver.findElement(By.id("status")));
		//Thread.sleep(2000);
		status.selectByVisibleText(strStatus);
		bookletNature= new Select(driver.findElement(By.id("bookletNature")));
		//Thread.sleep(3000);
		fundType=new Select(driver.findElement(By.id("fundType")));
		//Thread.sleep(2000);
		fundType.selectByVisibleText(strfundType);
		bookletNature.selectByVisibleText(strbookletNature);
		//Thread.sleep(2000);
		pages=new Select(driver.findElement(By.id("pages")));
		Thread.sleep(2000);
		pages.selectByVisibleText(strPages);
		Thread.sleep(2000);
		fromNo=driver.findElement(By.id("fromNo"));
		fromNo.sendKeys(strfromNo);
		
	}
	

}
