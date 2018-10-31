package CoverNote.CoverNote_V_I;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


	
	public class Loginpage {
		WebDriver driver;
		By username=By.name("username");
	    By password=By.name("password");
	    By LoginButton=By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[2]/button");
		
		
		
	public  Loginpage(WebDriver driver) {
			this.driver=driver;
			
		}

	public void enterUsername(String strUsername) {
		driver.findElement(username).sendKeys(strUsername);
	}

	public void enterPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}

	public void clickLoginButton() {
		driver.findElement(LoginButton).click();
	}


}
