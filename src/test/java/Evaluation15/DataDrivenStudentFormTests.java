package Evaluation15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenStudentFormTests {

	WebDriver  driver;
	
	@BeforeMethod
	public void  setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@DataProvider(name ="studentData")
	public Object[][] provideData(){
		return new Object[][] {
			{"ram","saini" ,"ram@gmail.com","male","887967656"},
			{"ramu","saini" ,"ramu@gmail.com","male","8222267656"},
		};
		}
	
	@Test(dataProvider = "studentData")
	
	public void fillForm(String fname , String lname , String email , String gender ,String phone ) {
		
		driver.get("https://demoqa.com/automation-practice-form");
		
		driver.findElement(By.id("firstName")).sendKeys(fname);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.xpath("//label[text()=" + gender +"]")).click();
		driver.findElement(By.id("userNumber")).sendKeys(phone);
		driver.findElement(By.id("userNumber")).sendKeys(phone);
		driver.findElement(By.id("submit")).click();
		

		
		String output1 = driver.findElement(By.id("firstName")).getText();
		String output2 = driver.findElement(By.id("lastName")).getText();
		
		Assert.assertTrue(output1.contains("Ramanuj"));
		Assert.assertTrue(output2.contains("Saini"));
		
		
		
		
	
		
		
		
	}
}
