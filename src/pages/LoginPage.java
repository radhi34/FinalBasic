package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	/* driver will be null here so we cannot declare it like this
	 * public WebElement email = driver.findElement(By.id("login-username")); public
	 * WebElement emailNext = driver.findElement(By.id("login-signin")); public
	 * WebElement password = driver.findElement(By.id("login-passwd")); public
	 * WebElement passwordNext = driver.findElement(By.name("verifyPassword"));
	 * public WebElement passwordErr = driver.findElement(By.className("error-msg")); 
	 * public WebElement emailErr = driver.findElement(By.id("username-error"));
	 */
	
	@FindBy(id="login-username") // this is called page factory .. after defineing it downside driver can take this value
	public static WebElement email;
	
	@FindBy(id="login-signin")
	public static WebElement emailNext;
	
	@FindBy(id="login-passwd")
	public static WebElement password;
	
	@FindBy(name="verifyPassword")
	public static WebElement passwordNext;
	
	@FindBy(className="error-msg")
	public static WebElement passwordErr;
	
	@FindBy(id="username-error")
	public static WebElement emailErr;
	
	public void openBrowser() throws IOException {

		FileInputStream fs = new FileInputStream("c:\\Testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(fs);
		
		String browser = prop.getProperty("browser");
		//String browser = "Chrome"; //(Firefox, Chrome,IE)
		//RemoteWebDriver driver; // you can use any of it
		//WebDriver driver;  // or this
		
		
		if(browser.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		 driver = new FirefoxDriver(); 
		 
		}else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		PageFactory.initElements(driver, this); // to initialize the driver because it's null
	}
	
	public void openYahoo() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.yahoo.com/");
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void enterEmail(String a) throws InterruptedException {
		email.sendKeys(a);
		emailNext.click();
		Thread.sleep(3000);
	}
	
	public void enterPassword(String b) throws InterruptedException {
		password.sendKeys(b);
		passwordNext.click(); 
		Thread.sleep(3000);
	}
	
	public String readPasswordErr() {
		  String actualErrmsg =passwordErr.getText();
		  System.out.println(actualErrmsg);
		  return actualErrmsg;
	}
	
	public String readEmailErr() {
		String actualErrmsg=emailErr.getText();
		System.out.println(actualErrmsg);
		return actualErrmsg;
	}
}
