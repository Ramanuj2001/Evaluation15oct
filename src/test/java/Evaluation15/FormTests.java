package Evaluation15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormTests {
	
	WebDriver  driver;
	
	@BeforeMethod
	public void  setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/");
	}
	
	
	@Test(priority =1 )
	
	public void textBoxSubmission() {
		driver.get("https://demoqa.com/text-box");
		
		 driver.findElement(By.id("userName")).sendKeys("Ramanuj");
		driver.findElement(By.id("userEmail")).sendKeys("ram@gmail.com");
		driver.findElement(By.id("submit")).click();
		
		String output1 = driver.findElement(By.id("userName")).getText();
		String output2 = driver.findElement(By.id("userEmail")).getText();
		
		Assert.assertTrue(output1.contains("Ramanuj"));
		Assert.assertTrue(output2.contains("ram@gmail.com"));
		}
	
	@Test(priority =2 )
		
		public void tchechBox() {
		driver.get("https://demoqa.com/checkbox");
		driver.findElement(By.className("rct-option rct-option-expand-all")).click();
		
		
	}

	@AfterMethod

	public void tearDown()
	{
		driver.quit();
	}
	
	
}
