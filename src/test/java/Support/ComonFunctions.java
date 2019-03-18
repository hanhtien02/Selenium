package Support;

import inspect.LoginPageTest;
import inspect.SelectOptionTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ComonFunctions {
    // define a static variable
    private static WebDriver driver;



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
    // list element
    public  static List<WebElement> getElements(How how, String locator){
        return driver.findElements(how.buildBy(locator));
    }

    // open linkTo
    public static void visit(String linkTo) {
        driver.get(linkTo);

    }
    //Using navigate
    public static void navigate(String linkTo){
        driver.navigate().to(linkTo);
    }
    //Navigate back
    public static void back(){
        driver.navigate().back();
    }
    // close browser
    public static void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
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
    public static void selectOption(String withOption) {
        WebElement mySelectElement = getElement(How.ID, "dropdown");

        Select dropdown = new Select(mySelectElement);

        dropdown.selectByVisibleText(withOption);

    }

}
