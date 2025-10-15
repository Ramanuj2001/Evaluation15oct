package Evaluation15;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractionTests {

	WebDriver driver ;
	
	@BeforeMethod
	
   public void  setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/");
	}
	
@Test
	
	public void alert() {

	driver.get("https://demoqa.com/alerts");
	driver.findElement(By.id("confirmButton")).click();
    driver.switchTo().alert().accept();
	
	String message  = driver.findElement(By.id("confirmButton")).getText();
	
	Assert.assertTrue(message.contains("You selected Ok"));
	
}

@Test

public void handleIframe() {
	
	driver.get("https://demoqa.com/frames");
	WebDriver head = driver.switchTo().frame("frame1");;
	Assert.assertEquals(head,"This is a sample page");
	
	driver.switchTo().defaultContent();
	
}

@AfterMethod

public void tearDown()
{
	driver.quit();
}
	
}
