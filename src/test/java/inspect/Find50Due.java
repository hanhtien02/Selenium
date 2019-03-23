package inspect;
import Support.BrowserName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static Support.ComonFunctions.*;
//import static Support.ComonFunctio


public class Find50Due {
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
        int indexOfColumnLastName = findIndexOfColumn("Last Name", columns.size());
        // index of due
        int indexOfColumnDue = findIndexOfColumn("Due", columns.size());

        // find and print last name of person who have Due = $50
        // Please help to review: Should I implement this part as an method or not?
        List<String> is50DueList = new ArrayList<String>();

        for (int row = 1; row <= rows.size(); row++) {
            String cellValue = getCell(row, indexOfColumnDue);
            if (cellValue.equalsIgnoreCase("$50.00")) {
                is50DueList.add(getCell(row,indexOfColumnLastName));
            }
        }

        close();
    }

    // get value of 1 cell in table
    public static String getCell(int row, int column) {
        return getElement(How.XPATH,
                String.format(cellLocator, row, column)).getText();
    }

    // get the index of column based on coLumn size
    public static int findIndexOfColumn(String columnName, int columnSize) {
        int indexNumber = 0;
        for (int column = 1; column <= columnSize; column++) {
            String cellValue = getElement(How.XPATH, String.format("//table[@id = 'table1']/thead/tr/th[%d]", column)).getText();

            if (cellValue.equalsIgnoreCase(columnName)) {
                indexNumber = column;
            }
        }
        return indexNumber;
    }

}
