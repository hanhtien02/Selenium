package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CocCocTest {
    public static void main(String[] args) {
        // Chrome drive
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        // Link to Coc Coc path
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\tien\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");

        // create a driver
        WebDriver driver = new ChromeDriver(options);
        // open google
        driver.get("https://www.google.com.vn");
        // full screen (optional)
        driver.manage().window().maximize();

    }
}
