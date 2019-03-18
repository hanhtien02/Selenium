package inspect;

import Support.BrowserName;

import static Support.ComonFunctions.navigate;
import static Support.ComonFunctions.openBrowser;

public class BasicAuthTest {
    public static void main(String[] args) throws InterruptedException {
        openBrowser(BrowserName.Chrome);
        navigate("https://admin:admin@the-internet.herokuapp.com/basic_auth");// username:pass@URL, ssh key word basic auth

        Thread.sleep(2000);
    }
}
