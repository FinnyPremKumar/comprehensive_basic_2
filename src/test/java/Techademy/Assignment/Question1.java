package Techademy.Assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.*;

public class Question1 {

    private static final String FILE_NAME = "C:\\Users\\ec65f\\OneDrive\\Documents\\Assignment\\assignment.xlsx";

    public static void main(String[] args) {
        List<Map<String, String>> data = readDataFromExcel();
        List<Map<String, String>> dataList = new ArrayList<>();
        for (Map<String, String> row : data) {
            dataList.add(row);
        }
        for (Map<String, String> row : dataList) {
            System.out.println("Name: " + row.get("Name") + ", Courses: " + row.get("Courses") + ", Fee: " + row.get("Fee"));
        }
    }

    private static List<Map<String, String>> readDataFromExcel() {
        List<Map<String, String>> data = new ArrayList<>();

        try (FileInputStream excelFile = new FileInputStream(FILE_NAME);
             Workbook workbook = WorkbookFactory.create(excelFile)) {

            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row currentRow = sheet.getRow(rowIndex);
                Map<String, String> rowData = new HashMap<>();

                for (int colIndex = 0; colIndex < headerRow.getLastCellNum(); colIndex++) {
                    Cell headerCell = headerRow.getCell(colIndex);
                    Cell currentCell = currentRow.getCell(colIndex);

                    rowData.put(headerCell.getStringCellValue(), currentCell.getStringCellValue());
                }

                data.add(rowData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
