package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
      //  driver.get("https://google.com");
        //WebDriverManager.firefoxdriver().setup();
       // FirefoxBinary firefoxBinary = new FirefoxBinary();
       // firefoxBinary.addCommandLineOptions("--headless");

       // FirefoxOptions firefoxOptions = new FirefoxOptions();
        //firefoxOptions.setBinary(firefoxBinary);

        //WebDriver driver = new FirefoxDriver(firefoxOptions);
       // driver.get("https://google.com");
        Thread.sleep(5000);

        driver.close();
     System.out.println("DO something");


    }
}
