package inspect;

import Support.BrowserName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import java.util.List;

import static Support.ComonFunctions.*;

public class WebTableTest {
    static  String cellLocator = "//table[@id = 'table1']/tbody/tr[%d]/td[%d]";
    public static void main(String[] args) throws InterruptedException {
        openBrowser(BrowserName.Chrome);
        navigate("https://the-internet.herokuapp.com/tables");
        Thread.sleep(2000);

        List<WebElement> rows = getElements(How.XPATH, "//table[@id = 'table1']/tbody/tr");
        System.out.println(rows.size());

        List<WebElement> columns = getElements(How.XPATH, "//table[@id = 'table1']/thead/tr/th");
        System.out.println(columns.size());

        // number of Due
        int dueIndex = 0;

        for (int i = 1; i<= columns.size(); i ++){
            String cellValue = getElement(How.XPATH, String.format("//table[@id = 'table1']/thead/tr/th[%d]",i)).getText();
            System.out.println(cellValue);
            if (cellValue.equalsIgnoreCase( "Due")) {
                dueIndex = i;
            }
        }
        System.out.println("due index "+ dueIndex);

//



        /*for (int i = 1; i <= rows.size(); i++) {
            for (int j = 1; j <= columns.size(); j++) {
                String value = getElement(How.XPATH,
                        String.format(cellLocator, i, j))
                        .getText();// cell value
                if


            }


        }*/
        // find  a single cell inside table
        // save the min = tr index -> match with the name and return
        // fine a cell -> select an action
        //
        //String tables[][] = new String[rows.size()][columns.size()];

        for (int i = 1; i <= rows.size(); i++) {
            String value = getCell(i,dueIndex);
            System.out.println(value);


        }


        close();
    }
    public static String getCell(int row, int column){
        return getElement(How.XPATH,
                String.format(cellLocator, row, column)).getText();
    }
}
