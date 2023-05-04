import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.beust.jcommander.Parameter;

@Listeners(com.listeneres.ListenersTestNG.class)
public class LaunchChrome {
	
//	@Test(enabled=false)
//	@Test(enabled=true)
     @Test(timeOut=1000)
	@Parameters({"Browser"})
	public void launch(String Browser) {
		
		if(Browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		}
		else if(Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".//Driver//firefoxdriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.facebook.com/");
		}	
	}

//skip the exception	
	@Test
	public void run() {
		String s="skip the test";
		if(s.equals(s)) {
			throw new SkipException("skip the teset");
		}
		else {
			System.out.println("run the test");
		}		
	}
	
	@Test
	public void runFast() {
		System.out.println("do not skip the test");
	}
	
	
	
	
	
}
