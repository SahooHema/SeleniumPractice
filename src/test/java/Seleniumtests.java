
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Events;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Seleniumtests {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
//		chromeOptions.addArguments("--headless");
//		chromeOptions.addArguments("--incognito");
//		chromeOptions.addArguments("disable-infobars");
//		chromeOptions.addArguments("disable-popup-blocking");
//		chromeOptions.addArguments("disable-extennsions");
//		DesiredCapabilities ds=new DesiredCapabilities();
//		ds.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//		chromeOptions.merge(ds);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.facebook.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	String url=	driver.getCurrentUrl(); 
	System.out.println(url);
	
	driver.navigate().to("https://www.crunchbase.com/organization/fitsyn-crm");
	driver.findElement(By.xpath("")).getAttribute(" ");
	driver.findElement(By.linkText(""));
	driver.findElement(By.partialLinkText(" "));
	
	//chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
	
	TakesScreenshot ts= (TakesScreenshot)driver;
	 File src=      ts.getScreenshotAs(OutputType.FILE);
	File des= new File("D://screenshots.jpg");
	FileHandler.copy(src, des);
	
	Select slt=new Select(null);
	slt.selectByIndex(0);
	slt.selectByValue(url);
	slt.deselectByVisibleText(url);
	
	Robot rbt=new Robot();
	String text="hema is tester";
	StringSelection s= new  StringSelection(text);
	Clipboard clp=Toolkit.getDefaultToolkit().getSystemClipboard();
clp.setContents(s, s);
rbt.keyPress(KeyEvent.VK_CONTROL);
rbt.keyPress(KeyEvent.VK_V)	;
rbt.keyRelease(KeyEvent.VK_CONTROL);
rbt.keyRelease(KeyEvent.VK_V)	;
	
Actions actn=new Actions(driver);
actn.clickAndHold(null).moveToElement(null).release().build().perform();

WebElement button= driver.findElement(By.xpath("xcv"));

JavascriptExecutor js =(JavascriptExecutor)driver; 
	js.executeScript("document.getElementByID(button). click();");
	js.executeScript("document.getElementByID(button).value='xyz';");
	js.executeScript("document.getElementByID(button).textbox='false';");
	js.executeScript("return document.title;").toString();
	js.executeScript("return document.domain;").toString();
	js.executeScript("return document.URL;").toString();
	js.executeScript("window.location='dffdfddf'");
	js.executeScript("window.scrollBy(0,600)");
	js.executeScript("window.scrollBy(0,-600)");
	js.executeScript("window.scrollBy(0.document.body.scrollHeight)");
	js.executeScript("arguments[0].scrollInToView();",button);	//scroll down
	js.executeScript("history.go(0)");

	
	driver.findElement(By.xpath("")).isDisplayed();
	driver.findElement(By.xpath("")).isEnabled();
	driver.findElement(By.xpath("")).isSelected();
	
Alert alt=	driver.switchTo().alert();	
	alt.accept();
	alt.dismiss();
String t=	alt.getText();
System.out.println(t);	

String parentID=driver.getWindowHandle();
Set<String> handles=driver.getWindowHandles();
Iterator<String> it=handles.iterator();
while(it.hasNext()) {
String childID=	it.next();
if(!parentID.equalsIgnoreCase(childID)) {
	driver.switchTo().window(childID);
	driver.close();
}
}
String name="hema";
String pwd="pss";

//String URL = "https://" +username +":" +password +"@"+ "the-internet.herokuapp.com/basic_auth";
//driver.get(URL);

Dimension d=new Dimension(400, 600);
driver.manage().window().setSize(d);

SoftAssert sft=new SoftAssert();
sft.assertFalse(false);
sft.assertAll();


//xpath's
//input[@type='submit' and @text='button']
//input[@type=submit or @text=button]

WebElement buttons= driver.findElement(By.xpath(""));

WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated((By) buttons)));
buttons.click();


Wait<WebDriver> wt=new FluentWait<WebDriver>(driver)
.withTimeout(Duration.ofSeconds(5000))
.pollingEvery(Duration.ofSeconds(30))
.ignoring(NoSuchElementException.class);

WebElement forgot=wait.until(new Function<WebDriver,WebElement>(){

	public WebElement apply(WebDriver driver) {
		return  driver.findElement(By.xpath("gf"));
	}

});
forgot.click();




//get all links and text
List<WebElement> lst=driver.findElements(By.tagName("a"));
System.out.println(lst.size());
for(int i=0;i<=lst.size();i++) {
	System.out.println(lst.get(i).getText());
}
//find broken links
List<WebElement> lst1=driver.findElements(By.tagName("a"));
System.out.println(lst1.size());
for(int i=0;i<=lst1.size();i++) {
WebElement el=	lst1.get(i);
String url1=el.getAttribute("href");
verifyurl(url1);
}
}

	public static void verifyurl(String linkurl) throws Exception {
		  URL url1=new URL(linkurl);
		 HttpURLConnection connect= (HttpURLConnection) url1.openConnection();
		connect.setConnectTimeout(5000);
		connect.connect();
		if(connect.getResponseCode()>=400) {
			System.out.println("broken links:"+connect.getResponseMessage());
		}else {
			System.out.println(connect.getResponseMessage());
		}
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
	}			 
				 
				 
	

}
