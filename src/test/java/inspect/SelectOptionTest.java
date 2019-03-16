package inspect;
import org.openqa.selenium.support.How;

import static Support.ComonFunctions.*;
public class SelectOptionTest {
    public static void main(String[] args) throws InterruptedException {
        openBrowser(BrowserName.Chrome);
        navigate("https://the-internet.herokuapp.com/dropdown");
        Thread.sleep(2000);
        click(How.ID,"dropdown");
        close();
    }
}
