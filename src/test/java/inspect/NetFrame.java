package inspect;

import Support.BrowserName;
import org.openqa.selenium.support.How;

import static Support.ComonFunctions.*;

public class NetFrame {
    public static void main(String[] args) throws InterruptedException {
        openBrowser(BrowserName.Chrome);
        visit("https://the-internet.herokuapp.com/nested_frames");
        //getDriver().switchTo().frame("frame-bottom");
        getDriver().switchTo().frame("frame-top");//
        getDriver().switchTo().frame("frame-left");
        System.out.println(getText(How.XPATH, "/html/body"));
        close();
    }

}
