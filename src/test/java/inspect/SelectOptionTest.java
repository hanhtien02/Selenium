package inspect;
import Support.BrowserName;
import org.openqa.selenium.support.How;

import static Support.ComonFunctions.*;

public class SelectOptionTest {
    public static void main(String[] args) throws InterruptedException {
        openBrowser(BrowserName.Chrome);
        navigate("https://the-internet.herokuapp.com/dropdown");
        Thread.sleep(2000);

        /*Click dropdown

        click(How.ID,"dropdown");
        Thread.sleep(2000);

        //press a option
        click(How.XPATH,"//option[@value='1']");

        Thread.sleep(3000);*/

        // using select in selenium
        selectOption("Option 1");
        Thread.sleep(2000);

        //
        selectOption("Option 2");
        Thread.sleep(2000);



        close();
    }
}
