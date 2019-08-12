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
	private Select bookletNature;
	private Select pages;
	private WebElement bookNumber;
	private WebElement noOfBooks;
	private WebElement coverNoteLink;
	private WebElement coverNoteGRNLink;
	private WebElement poRef;
	private WebElement poRefResult;
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
	
	public void addCoverNoteDetails(String strdeptCode,String strfundType,String strbookNumPrefix,String strbookNumber,String strnoOfBooks,String strStatus,String strbookletNature,String strPages,String strfromNo) throws InterruptedException
	{
		poRef=driver.findElement(By.id("select2-chosen-2"));
		Thread.sleep(1000);
		poRef.click();
		Thread.sleep(1000);
		poRefResult=driver.findElement(By.id("select2-results-2"));
		Thread.sleep(1000);
		poRefResult.click();
		//select department code
		deptCode=new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deptCode"))));
		deptCode.selectByVisibleText(strdeptCode);
		Thread.sleep(3000);
		
		//select fund type
		fundType=new Select(driver.findElement(By.id("fundType")));
		fundType.selectByVisibleText(strfundType);
		
		//select book prefix
		bookNumPrefix=new Select(driver.findElement(By.id("bookNumPrefix")));
		bookNumPrefix.selectByVisibleText(strbookNumPrefix);
		
		//enter  book number
		bookNumber=driver.findElement(By.id("bookNumber"));
		bookNumber.sendKeys(strbookNumber);
		
		//enter no_of_books
		noOfBooks=driver.findElement(By.id("noOfBooks"));
		noOfBooks.sendKeys(strnoOfBooks);
		
		//select status
		status = new Select(driver.findElement(By.id("status")));
		status.selectByVisibleText(strStatus);
		
		//select booklet nature
		bookletNature= new Select(driver.findElement(By.id("bookletNature")));
		bookletNature.selectByVisibleText(strbookletNature);
		
		//select pages
		pages=new Select(driver.findElement(By.id("pages")));
		pages.selectByVisibleText(strPages);
		
		//enter from number
		fromNo=driver.findElement(By.id("fromNo"));
		fromNo.sendKeys(strfromNo);
		
	}
	

}
