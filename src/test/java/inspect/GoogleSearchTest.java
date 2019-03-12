package inspect;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--lang=sl");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://google.com");
        //driver.findElement(By.name("q")).sendKeys("hello\n");
       // driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Hello\n");
        //driver.findElement(By.xpath("//input[@aria-label='Tìm kiếm']")).sendKeys("Hello\n");
        //driver.findElement(By.cssSelector("input[title='Tìm kiếm']")).sendKeys("hello tien \n");
        driver.findElement(By.cssSelector("input[aria-label='Tìm kiếm']")).sendKeys("hello tien \n");



        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
