import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage extends Seleniumtests{

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="dff")
	WebElement login;
	
	@Test(groups= {"sanity"})
	//@Test(invocationCount=4)
	//@Test(priority=1)
	public void click() {
		System.out.println();
	}
	
	@Test(groups= {"sanity"})
	//@Test(dependsOnMethods= {"click"},alwaysRun=true)
	public HomePage loginToApp() {
		login.click();
		return new HomePage(driver);
	}

}