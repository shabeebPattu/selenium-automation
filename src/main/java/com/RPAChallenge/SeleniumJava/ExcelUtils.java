package com.RPAChallenge.SeleniumJava;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {




    // Read entire sheet data into a List of Lists
    public static List<List<String>> getSheetData(String filePath, String sheetName) {
        List<List<String>> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("./data/challenge.xlsx");
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rows = sheet.getLastRowNum();

            for (int i = 0; i < rows; i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                int cols = row.getPhysicalNumberOfCells();
                List<String> rowData = new ArrayList<>();

                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j);
                    rowData.add((cell != null) ? cell.toString().trim() : "");
                }

                data.add(rowData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
