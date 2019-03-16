package inspect;

import  static Support.ComonFunctions.*;

import Support.BrowserName;
import org.openqa.selenium.support.How;

public class LoginPageTest {


    public static void main(String[] args) throws InterruptedException {
        openBrowser(BrowserName.FireFox.IE);
        visit("https://the-internet.herokuapp.com/login");

        fill(How.NAME, "username", "tomsmith");
        fill(How.NAME, "password", "SuperSecretPassword!");

        click(How.TAG_NAME, "button");

        close();


    }
}
