package CoverNote.CoverNote_V_I;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


	
	public class Inventory_Login {
		private WebDriver driver;
		/*private By username=By.name("username");
	    private By password=By.name("password");
	    private By LoginButton=By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[2]/button");
		*/
		private By username=By.xpath("/html/body/div[2]/div/div/form/div[2]/input");
		private By password=By.xpath("/html/body/div[2]/div/div/form/div[3]/input");
		private By login=By.xpath("/html/body/div[2]/div/div/form/div[5]/div/button");
		
		
	public  Inventory_Login(WebDriver driver) {
			this.driver=driver;
			
		}

	public void enterUsername(String strUsername) {
		driver.findElement(username).sendKeys(strUsername);
	}

	public void enterPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}

	public void clickLoginButton() {
		driver.findElement(login).click();
	}
	
	public void invalidLogin(String username, String password)
	{
	  enterUsername(username);
	  enterPassword(password);
	  clickLoginButton();
	  WebElement actualError=driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/span[3]"));
	  String strActualerror=actualError.getText();
	  System.out.print(strActualerror);
	  String expectedError="Invalid login details";
	  assertEquals(strActualerror,expectedError);
	  System.out.print("Success");
	}
	
	
	public void forgetPassword(String strEmaill)
	{
		WebElement email=driver.findElement(By.id("inputEmail"));
		email.sendKeys(strEmaill);
		WebElement submit=driver.findElement(By.xpath("//div[@class='form-group text-center']/button[@class='btn btn-primary']"));
		submit.click();
		WebElement actualMessage=driver.findElement(By.xpath("//div[@class='alert alert-success text-center']"));
		String strActualmessage=actualMessage.getText();
		String expectedMessage="Validation Email Sent";
		assertEquals(strActualmessage,expectedMessage);
	}
	
	
	public void emailValidation(String strEmail)
	{
		WebElement email=driver.findElement(By.id("inputEmail"));
		email.sendKeys(strEmail);
		WebElement submit=driver.findElement(By.xpath("//div[@class='form-group text-center']/button[@class='btn btn-primary']"));
		submit.click();
		int index=strEmail.indexOf('.');
		if(index<=-1)
		{
			WebElement actualError=driver.findElement(By.xpath("//div[@class='alert alert-danger text-center']"));
			String strActualerror=actualError.getText();
			String expectedError="No client account was found with the email address you entered";
			assertEquals(strActualerror,expectedError);
		}
				
	}
	
	public void phonenumberValidation(String strPhone)
	{
		WebElement register=driver.findElement(By.linkText("REGISTER"));
		register.click();
		WebElement phone=driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input"));
		phone.sendKeys(strPhone);
	    char[] phoneArray=strPhone.toCharArray();
		/*if(phoneArray.length>10)
		{
			 System.out.println("Invalid phonenumber");
		}*/
		for(int i=0;i<phoneArray.length;i++)
		{
		  char numberI=phoneArray[i];
		  boolean result=Character.isDigit(numberI);
		  if(result==false)
		  {
			 System.out.println("Invalid Phone NUmber");
		  }
		  
		  
		}
		
	}
	



}
