package inspect;

import Support.BrowserName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static Support.ComonFunctions.*;
import static Support.ComonFunctions.getElements;

public class FindSmallestDue {
    // cell path
    static String cellLocator = "//table[@id = 'table1']/tbody/tr[%d]/td[%d]";

    public static void main(String[] args) throws InterruptedException {
        // open a link by chrome
        openBrowser(BrowserName.Chrome);
        navigate("https://the-internet.herokuapp.com/tables");
        // calculate number of rows
        List<WebElement> rows = getElements(How.XPATH, "//table[@id = 'table1']/tbody/tr");
        // calculate number of columns
        List<WebElement> columns = getElements(How.XPATH, "//table[@id = 'table1']/thead/tr/th");
        // index of last name
        int columnLastNameIdx = findIndexOfColumn("Last Name", columns.size());
        // index of due
        int columnDueIdx = findIndexOfColumn("Due", columns.size());

        // find and print last name of person who have smallest due
        Double minOfDue = findMinOfDue(rows.size(), columnDueIdx);

        // print last name of person who have smallest Due
        // create a Array to save list smallest Due
        List<String> smallestDueList = new ArrayList<String>();

        // search in the table
        for (int rowIdx = 1; rowIdx <= rows.size(); rowIdx++) {
            // get value of a cell in Due column in double to compare
            Double cellValue = parseCellToDouble(rowIdx, columnDueIdx);

            // compare with minOfDue and save the last name
            if (cellValue.equals(minOfDue)) {
                smallestDueList.add(getCell(rowIdx,columnLastNameIdx));
            }
        }
        //Print out the smallest list
        System.out.println("Last name of person who have SMALLEST Due are(is): " + smallestDueList);
        close();
    }

    // get value of 1 cell in table
    public static String getCell(int rowIndex, int columnIndex) {
        return getElement(How.XPATH,
                String.format(cellLocator, rowIndex, columnIndex)).getText();
    }
    // get the index of column based on column size
    public static int findIndexOfColumn(String columnName, int columnSize) {
        int indexOfColumn = -1;// -1 in case not found
        for (int columnIdx = 1; columnIdx <= columnSize; columnIdx++) {//columnIdx
            String cellValue = getElement(How.XPATH,
                    String.format("//table[@id = 'table1']/thead/tr/th[%d]", columnIdx))
                    .getText();

            if (cellValue.equalsIgnoreCase(columnName)) {
                indexOfColumn = columnIdx;
            }
        }
        return indexOfColumn;
    }
    // format a cell value to Double
    public static double parseCellToDouble(int rowIndex, int columnIndex) {
        String cellToDouble = getCell(rowIndex, columnIndex).replaceAll("\\$", "");

        return Double.parseDouble(cellToDouble);
    }
    //Find the minimum value
    public static double findMinOfDue(int rowSize, int dueIdx) {
        // min value is the first value of the DUE column
        double minOfDue = parseCellToDouble(1, dueIdx);

        // find the minimum
        for (int rowIdx = 1; rowIdx <= rowSize; rowIdx++) {
            double cellValue = parseCellToDouble(rowIdx, dueIdx);
            if (cellValue < minOfDue) {
                minOfDue = cellValue;
            }
        }
        return minOfDue;
    }
}
