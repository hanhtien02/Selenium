package inspect;

import Support.BrowserName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import static Support.ComonFunctions.*;

public class CheckboxTest {
    public static void main(String[] args) throws InterruptedException {
        openBrowser(BrowserName.Chrome);
        navigate("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(2000);

        WebElement checkbox = getElement(How.XPATH,"//form[@id ='checkboxes']//input[2]");

        if(!checkbox.isSelected()){

        click(How.XPATH,"//form[@id ='checkboxes']//input[2]");}

        if(!checkbox.isSelected()){

            click(How.XPATH,"//form[@id ='checkboxes']//input[1]");}

        if(checkbox.isSelected()){

            click(How.XPATH,"//form[@id ='checkboxes']//input[2]");}
        close();
    }
}
