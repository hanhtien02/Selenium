package inspect;
import Support.BrowserName;
import org.openqa.selenium.support.How;

import static Support.ComonFunctions.*;
public class IFrameTest {
    public static void main(String[] args) throws InterruptedException {
        openBrowser(BrowserName.Chrome);
        visit("https://the-internet.herokuapp.com/iframe");
        getDriver().switchTo().frame(getElement(How.TAG_NAME,"iframe"));// switch to a frame
        //getDriver().switchTo().frame("mce_0_ifr");// switch to a frame
        //getDriver().switchTo().frame(0);// switch to a frame



        getElement(How.XPATH, "//p.[.='Your content goes here'']").clear();
        close();
    }
}
