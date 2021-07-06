import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogIn {

	static String browser;
	static WebDriver driver;
		   		
	public static void main(String[] args)  {
		setBrowser();
		configBrowser();
		try {
			runTest();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	// Set Browser
	public static void setBrowser() {
		browser = "Firefox";
	}
	// Config Browser
	public static void configBrowser() {
		String projectLocation = System.getProperty("user.dir");

		if(browser.contains("Firefox")) {

			System.setProperty("webdriver.gecko.driver",projectLocation+ "/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		if(browser.contains("Chrome")) {

			System.setProperty("webdriver.chrome.driver", projectLocation+"/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
	}
	// run The Test
	/**
	 * @throws InterruptedException
	 */
	public static void runTest() throws InterruptedException {

		driver.get("https://nmed-c.zssbd.com/auth/user/login/?next=/alerts/list/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'id_username\']")).sendKeys("testdoc");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'id_password\']")).sendKeys("Test123456");
		
		driver.findElement(By.xpath("//*[@id=\'clinicianLogin\']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/ul[1]/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\'add-btn\']")).click();
		driver.findElement(By.xpath("//*[@id=\'entity-update-form\']/div[1]/div[2]/input")).sendKeys("123412341234");
		driver.findElement(By.xpath("//*[@id=\'entity-update-form\']/div[2]/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\'entity-update-form\']/div[3]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'id_username\']")).sendKeys("tmehnaz");
		driver.findElement(By.xpath("//*[@id=\'id_first_name\']")).sendKeys("m");
		driver.findElement(By.xpath("//*[@id=\'id_surname\']")).sendKeys("t");
		driver.findElement(By.xpath("//*[@id=\'datepicker\']")).sendKeys("01051998");
		driver.findElement(By.xpath("//*[@id=\'id_email\']")).sendKeys("tmrtmr@yopmail.com");
		driver.findElement(By.xpath("//*[@id=\'id_mobile\']")).sendKeys("1771240943");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
		driver.findElement(By.xpath("//*[@id=\'confirmPatientForm\']")).click();
		driver.findElement(By.xpath("//*[@id=\'proceedCreatePatient\']")).click();
		driver.findElement(By.xpath("//*[@id=\'ok_button\']")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/ul[2]/li[6]/a/span")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/ul[2]/li[6]/ul/li[2]/a")).click();
		driver.quit();
	}

}


