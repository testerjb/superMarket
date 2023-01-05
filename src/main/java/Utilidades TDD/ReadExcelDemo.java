package Guru99;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;

//working read from cell *******************

public class ReadExcelDemo {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static String projectPath;

    public static void main(String[] args) throws IOException {
        getCellData();
        //getCellString(1,"B");
    }

    //constructor declare variables and assign value
    public static void getCellData() throws IOException {
        projectPath   = System.getProperty("user.dir");
        String excelPath = projectPath + "\\src\\main\\resources\\TestData.xlsx";
        System.out.println ("excel path: " + excelPath);
        XSSFWorkbook workbook = new XSSFWorkbook(excelPath);  //warning close workbook
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        //string
        //values in worksheet: 1.1 henry 1.2 ford 1.3 40 age
        Object value = sheet.getRow(1).getCell(1);

        // sustitui por object type double value = sheet.getRow(1).getCell(2).getNumericCellValue();
        System.out.println ("value " + value);
    }

    public static void getRowCount() {
        try {
            projectPath  = projectPath + "\\src\\main\\resources\\Products.xlsx";
            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println(" row count " + rowCount);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    public static void getCellString (int rowNum, String colName) {
        try {
            String rowData = sheet.getRow(0).getCell(0).getStringCellValue();
            System.out.println("cell data " + rowData);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();

        }

    }
}
