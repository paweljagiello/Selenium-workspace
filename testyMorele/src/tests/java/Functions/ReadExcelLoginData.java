package Functions;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelLoginData {
private String filePath = "C:\\Users\\Wonski\\IdeaProjects\\testyMorele\\src\\main\\java\\data\\LoginData_morele.xlsx";

    public String GetStringCellValue(int rowNumber, int cellNumber) throws IOException {

        File file = new File (filePath);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook myWorkbook = new XSSFWorkbook(inputStream);
        Sheet ms = myWorkbook.getSheet("Arkusz1");

        String cellValue = ms.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
        return cellValue;

    }
}
