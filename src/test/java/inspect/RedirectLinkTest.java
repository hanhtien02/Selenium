package inspect;
import static Support.ComonFunctions.*;


import Support.BrowserName;
import org.openqa.selenium.support.How;

public class RedirectLinkTest {
    public static void main(String[] args) throws InterruptedException {
        openBrowser(BrowserName.Chrome);
        //Using get
        // visit("https://the-internet.herokuapp.com/redirector");

        //Using navigate
        navigate("https://the-internet.herokuapp.com/redirector");

        // Find several ways to press on Here
        //click(How.ID, "redirect");
        //click(How.XPATH, "//a[@href = 'redirect']");
        //click(How.LINK_TEXT,"here");
        click(How.XPATH,"//a[contains(text(),'here')]");

        //open 200
        //<a href="status_codes/200">200</a>
        click(How.XPATH, "//a[@href = 'status_codes/200']");
        Thread.sleep(3000); // stop 3s

        // navigate back
        back();

        //open 301
        //<a href="status_codes/301">301</a>
        click(How.XPATH, "//a[@href = 'status_codes/301']");
        Thread.sleep(3000); // stop 3s

        // navigate back
        back();

        //open 404
        //<a href="status_codes/301">301</a>
        click(How.XPATH, "//a[@href = 'status_codes/404']");
        Thread.sleep(3000); // stop 3s

        // navigate back
        back();

        //open 500
        //<a href="status_codes/301">301</a>
        click(How.XPATH, "//a[@href = 'status_codes/500']");
        Thread.sleep(3000); // stop 3s

        // navigate back
        back();
        back();


        close();



    }
}
