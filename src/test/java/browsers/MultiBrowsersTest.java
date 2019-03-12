package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MultiBrowsersTest {
    public static void main(String[] args) {
        // input browser name and the link you want to open
        String myLink = "https://google.com";
        String myBrowserName = "ie";
        openMyBrowser(myBrowserName, myLink);

    }
    public static void openMyBrowser(String browserName, String link){

            if (browserName == "firefox") {
                openFirefox(link);
            }else if (browserName == "chrome") {
                openChrome(link);
            }else if (browserName == "edge") {
                openEdge(link);
            }else if (browserName == "ie") {
                openIE(link);
            }else if (browserName == "firefoxHeadless") {
                openFirefoxHeadless(link);
            }else if (browserName == "chromeHeadless") {
                openChromeHeadless(link);
            }
            /*if (browserName == "safari"){
            openSafari(link);
        */


    }

    private static void openChromeHeadless(String link) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        new ChromeDriver(chromeOptions);
        //open chrome headless
        WebDriver driver = new ChromeDriver(chromeOptions);
        // open link
        driver.get(link);
        // print the title
        System.out.println(driver.getTitle());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // close driver
        driver.close();
        // print something to now we finish
        System.out.println("finish");

    }

    private static void openFirefoxHeadless(String link) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        // open firefox headless
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        // open link
        driver.get(link);
        // print out title
        System.out.println(driver.getTitle());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //close driver
        driver.close();
        // finish then
        System.out.println("finish");


    }

    private static void openIE(String link) {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        driver.get(link);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
        System.out.println("IE opens " + link);
        System.setProperty("webdriver.safari.river", "Drivers/sa.exe");

    }

    /*private static void openSafari(String link) {
        WebDriver driver = new SafariDriver();
        driver.get(link);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
        System.out.println("Open " + link);
    }*/

    private static void openEdge(String link) {
        System.setProperty("webdriver.edge.driver", "Drivers/MicrosoftWebDriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get(link);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
        System.out.println("Edge opens " + link);
    }

    private static void openChrome(String link) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();// extend full screen
        driver.get(link);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.close();
        System.out.println("Chrome opens " + link);
    }

    public static void  openFirefox (String link){
        // set driver link
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
        // create a driver // open firefox browser
        WebDriver driver = new FirefoxDriver();
         // open link
        driver.get(link);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
        System.out.println("Firefox opens " + link);
    }
}
