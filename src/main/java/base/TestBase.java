package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver; 
	public static Properties prop; 
	static File folder; 

	public TestBase() throws IOException {
		
		// reading for configuration from the config file
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/resources/config.properties");
		prop.load(fis);
	}

	public static void OpenBeerWulf()
	{
		String browserName = prop.getProperty("browser"); 
		if(browserName.equals("chrome"))
		{
			driver = new ChromeDriver(); 
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}
	
	public static void cleanUp()
	{
		driver.quit(); 
	}
}
