package itcTest;
import Support.BrowserName;
import org.openqa.selenium.support.How;

import static Support.ComonFunctions.*;


public class ITCWeekViewTest {
    public static void main(String[] args) throws InterruptedException {
        loginITCTest("vuphan", "Adnovum123456");

        Thread.sleep(2000);
        close();

    }

    public static void loginITCTest(String usenameITC, String passwordITC){
        openBrowser(BrowserName.Chrome);
        visit("https://aww-test.adnovum.hu/itc/?login");
        fill(How.NAME,"isiwebuserid", usenameITC);
        fill(How.NAME, "isiwebpasswd", passwordITC);
        click(How.NAME, "submit");
    }

}
