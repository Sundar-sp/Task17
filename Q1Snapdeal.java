package task17;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1Snapdeal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.snapdeal.com");
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		driver.findElement(By.xpath("//span[@class='accountBtn btn rippleWhite']")).click();
		driver.switchTo().frame("loginIframe");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("test@guvi.com");
		driver.findElement(By.xpath("//button[@id='checkUser']")).click();
		
		//can't able to login with dummy email and password. so i skip that password and and login click
		//so i can't able to login, thats why i used exception handle
		
		String userName="";
		try {
			userName = driver.findElement(By.xpath("//span[text()='user']")).getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
		
		if (userName.contains("user")) {
			System.out.println();
			System.out.println("Logged in successfully");
		} else {
			System.out.println();
			System.out.println("user unable to login check username and password");
		}
		driver.quit();
	}

}

Output:
May 21, 2024 6:34:29 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 124, returning the closest version; found: 122; Please update to a Selenium version that supports CDP version 124
org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//span[text()='user']"}
  (Session info: chrome=124.0.6367.208)
For documentation on this error, please visit: https://www.selenium.dev/documentation/webdriver/troubleshooting/errors#no-such-element-exception
Build info: version: '4.18.1', revision: 'b1d3319b48'
System info: os.name: 'Windows 11', os.arch: 'amd64', os.version: '10.0', java.version: '11.0.21'
Driver info: org.openqa.selenium.chrome.ChromeDriver
Command: [4ef4750acb83841b40436f24dbba2a62, findElement {value=//span[text()='user'], using=xpath}]
Capabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 124.0.6367.208, chrome: {chromedriverVersion: 124.0.6367.207 (a9001a6e39f..., userDataDir: C:\Users\Sundar\AppData\Loc...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:53472}, networkConnectionEnabled: false, pageLoadStrategy: normal, platformName: windows, proxy: Proxy(), se:cdp: ws://localhost:53472/devtoo..., se:cdpVersion: 124.0.6367.208, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}
Session ID: 4ef4750acb83841b40436f24dbba2a62

user unable to login check username and password
