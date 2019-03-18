package inspect;

import Support.BrowserName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import java.util.List;

import static Support.ComonFunctions.*;
import static Support.ComonFunctions.getElements;

public class WebTablesHomeWorkTest {
    // cellLocator path
    static String cellLocator = "//table[@id = 'table1']/tbody/tr[%d]/td[%d]";

    public static void main(String[] args) throws InterruptedException {
        openBrowser(BrowserName.Chrome);
        navigate("https://the-internet.herokuapp.com/tables");

        // calculate number of rows
        List<WebElement> rows = getElements(How.XPATH, "//table[@id = 'table1']/tbody/tr");

        // calculate number of columns
        List<WebElement> columns = getElements(How.XPATH, "//table[@id = 'table1']/thead/tr/th");

        // index of last name
        int indexOfLastName = findIndexOfColumn("Last Name", columns.size());
        // index of due
        int indexOfDue = findIndexOfColumn("Due", columns.size());

        // find and print last name of person who have Due = $50
        // Please help to review: Should I implement this part as an method or not?

        for (int i = 1; i <= rows.size(); i++) {
            String value = getCell(i, indexOfDue);
            if (value.equalsIgnoreCase("$50.00")) {
                System.out.println(" The Last name of person who have Due = $50 is: " + getCell(i, indexOfLastName));
            }
        }

        close();
    }

    // get value of 1 cell in table
    public static String getCell(int row, int column) {
        return getElement(How.XPATH,
                String.format(cellLocator, row, column)).getText();
    }

    // get the index of column based on co;umn size
    public static int findIndexOfColumn(String columnName, int columnSize) {
        int value = 0;
        for (int i = 1; i <= columnSize; i++) {
            String cellValue = getElement(How.XPATH, String.format("//table[@id = 'table1']/thead/tr/th[%d]", i)).getText();

            if (cellValue.equalsIgnoreCase(columnName)) {
                value = i;
            }
        }
        return value;
    }
}
