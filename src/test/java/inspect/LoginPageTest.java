package inspect;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.How;

public class LoginPageTest {
    // define a static variable
    public static WebDriver driver;

    // define a enum
    public enum BrowserName {
        Chrome,
        FireFox,
        Edge,
        IE
    }

    public static void main(String[] args) throws InterruptedException {
        openBrowser(BrowserName.Chrome);
        visit("https://the-internet.herokuapp.com/login");

        fill(How.NAME, "username", "tomsmith");
        fill(How.NAME, "password", "SuperSecretPassword!");

        click(How.TAG_NAME, "button");

        Thread.sleep(3000);
        driver.close();


    }

    /**
     * Method is used to get element
     *
     * @param how     String {Name/ID/XPATH/CSS/TAGNAME}
     * @param locator String
     * @return WebElement
     */

    public static WebElement getElement(How how, String locator) {
        return driver.findElement(how.buildBy(locator));
    }

    // open linkTo
    public static void visit(String linkTo) {
        driver.get(linkTo);
    }

    // fill into a field
    public static void fill(How how, String locator, String inputText) {
        getElement(how, locator).sendKeys(inputText);
    }

    // click to a button
    public static void click(How how, String locator) {
        getElement(how, locator).click();
    }

    public static void openBrowser(BrowserName browserName) {
        switch (browserName) {
            case IE: {
                System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }
            break;
            case Edge: {
                System.setProperty("webdriver.edge.driver", "Drivers/MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
            }
            break;
            case Chrome: {
                System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
                driver = new ChromeDriver();
            }
            break;
            case FireFox: {
                System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }
            break;
            default:
                System.out.println(" Unknown browser " + browserName);
        }
    }

}
