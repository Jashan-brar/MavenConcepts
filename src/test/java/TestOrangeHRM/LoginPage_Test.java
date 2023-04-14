package TestOrangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage_Test {
WebDriver driver;
	
	@Test
	public void login() throws Exception
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		String Expurl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String Acturl = driver.getCurrentUrl();
		
		Assert.assertEquals(Expurl,Acturl);
	}
	
	@BeforeTest
	public void browserOpen()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterTest
	public void closeBrowser() throws Exception
	{
		Thread.sleep(3000);
		driver.close();
	}

}
