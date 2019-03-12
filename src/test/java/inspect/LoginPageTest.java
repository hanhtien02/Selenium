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
    public enum BrowserName{
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
      //  System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
       // ChromeOptions options = new ChromeOptions();
        //options.addArguments("--lang=sl");
       // driver = new ChromeDriver(options);
       // driver.get("https://the-internet.herokuapp.com/login");
        //driver.findElement(By.name("username")).sendKeys("tomsmith\n");
        //driver.findElement(By.tagName("input")).sendKeys("tomsmith\n");// there are many element have same name, so only 1st element is chosen.
       // driver.findElement(By.id("username")).sendKeys("tomsmith\n");

       // driver.findElement(By.cssSelector("input")).sendKeys("tomsmith\n");
        //driver.findElement(By.cssSelector("input[name = 'username']")).sendKeys("tomsmith\n");
       //driver.findElement(By.cssSelector("input[name='username']")).sendKeys("tomsmith\n");

        //driver.findElement(By.xpath("//input")).sendKeys("tomsmith\n");
        //driver.findElement(By.xpath("//input[@name='password']")).sendKeys("tomsmith\n");
       // driver.findElement(By.xpath("//input[contains(@id,'username')]")).sendKeys("tomsmith\n");// dynamic data but tale long time to execute but good for maintain
        //driver.findElement(By.xpath("//*[contains(@id,'username')]")).sendKeys("tomsmith\n");
       // driver.findElement(By.xpath("//*[contains(@name,'username')]")).sendKeys("tomsmith\n");

        //driver.findElement(By.cssSelector("input#username]")).sendKeys("tomsmith\n");

        //driver.findElement(By.xpath("//*[contains(@id,'username')]")).sendKeys("tomsmith");
       // driver.findElement(By.xpath("//*[contains(@id,'password')]")).sendKeys("SuperSecretPassword!");
       // driver.findElement(By.xpath("//button[@type ='submit']")).click();
       // driver.findElement(By.xpath("//a[@href='/logout']")).click();
        // driver.findElement(By.xpath("//i[.='logout']")
     //   driver.findElement(By.xpath("//button[@type ='submit']")).click();

        /*getElement(How.NAME, "username").sendKeys("tomsmith\n");
        getElement(How.ID, "username").sendKeys("tomsmith");
        getElement(How.CSS, "input[name='username']").sendKeys("tomsmith");

        getElement(How.XPATH, "//input[@name='password']").sendKeys("SuperSecretPassword!");
        getElement(How.TAG_NAME, "button").click();*/




        Thread.sleep(3000);
        driver.close();



    }

    /**
     *
     * Method is used to get element
     * @param how String {Name/ID/XPATH/CSS/TAGNAME}
     * @param locator String
     * @return WebElement
     */

    public static WebElement getElement(How how, String locator ){
        return driver.findElement(how.buildBy(locator));
    }
    // open linkTo
    public  static void visit(String linkTo){
        driver.get(linkTo);
    }
    // fill into a field
    public static void fill(How how, String locator, String inputText){
        getElement(how,locator).sendKeys(inputText);
    }
    // click to a button
    public static void click(How how, String locator){
        getElement(how,locator).click();
    }
    // open a browser
    /*public static void openBrowser(String name){
        if (name.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
            driver = new FirefoxDriver();

        }else if (name.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            driver = new ChromeDriver();

        }else if (name.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "Drivers/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();

        }else if (name.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();

        }else {
            System.out.println(" Unknown browser " + name);
        }

    }*/
    public static void openBrowser(BrowserName browserName){
        switch (browserName){
            case IE:{
                System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }
                break;
            case Edge:{
                System.setProperty("webdriver.edge.driver", "Drivers/MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
            }
                break;
            case Chrome:{
                System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
                driver = new ChromeDriver();
            }
                break;
            case FireFox: {
                System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }
                break;
                default:  System.out.println(" Unknown browser " + browserName);
        }
    }

}
