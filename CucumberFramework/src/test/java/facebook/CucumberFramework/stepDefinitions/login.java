package facebook.CucumberFramework.stepDefinitions;


import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login {
	
	WebDriver driver;
	
	public Properties var_dec() throws IOException {
			Properties prop = new Properties();
			FileInputStream fi = new FileInputStream("src\\test\\java\\facebook\\CucumberFramework\\resources\\config.propeties");
			prop.load(fi);			
			return (prop);
	
	}
	@Before
	
	public void setup() throws IOException {
		
		String location = var_dec().getProperty("Location");
		System.setProperty("webdriver.chrome.driver", location);
		this.driver=new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
	
	}
	
	
	@Given("^user navigates to facebook website$")
	public void user_navigates_to_facebook_website() throws Throwable {
			String url = var_dec().getProperty("Url");
			Thread.sleep(2000);
			driver.get(url);
	}

	@And("^user clicks on the login button on homepage$")
	public void user_clicks_on_the_login_button_on_homepage() throws Throwable {
		driver.findElement(By.xpath("//input[@id='u_0_b']")).click();
	}

	@When("^user enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
		String username = var_dec().getProperty("Username");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
	}

	@And("^user enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		String password = var_dec().getProperty("Password");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
	}

	@When("^the user clicks on the login button$")
	public void the_user_clicks_on_the_login_button() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
	}

	@Then("^the user should be taken to the successful login page$")
	public void the_user_should_be_taken_to_the_successful_login_page() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//html")).click();
		WebElement homeButton = driver.findElement(By.xpath("//a[@class='_2s25']"));
		AssertJUnit.assertEquals(true, homeButton.isDisplayed());
	}
	
	@Given("^user clicks on logout button$")
	public void user_clicks_on_logout_button() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='userNavigationLabel']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@class='_54ni navSubmenu _6398 _64kz __MenuItem']")).click();
	}
	
	@Then("^user should be taken to the homepage$")
	public void user_should_be_taken_to_the_homepage() throws Throwable {
		WebElement homepage = driver.findElement(By.xpath("//input[@id='u_0_4']"));
		AssertJUnit.assertEquals(true, homepage.isDisplayed());
		this.driver.manage().deleteAllCookies();
	}
		
	
	 @After
	public void end() throws InterruptedException, IOException {
	  Thread.sleep(3000); 
	  this.driver.manage().deleteAllCookies();
	  this.driver.quit(); this.driver= null;
	  Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
	  
	  }
	 
}
