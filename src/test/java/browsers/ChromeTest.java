package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeTest {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        new ChromeDriver(chromeOptions);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
        System.out.println("finish");

    }

}
