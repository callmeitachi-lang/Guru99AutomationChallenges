package com.guru99.Utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    static Workbook workbook;
    static Sheet sheet;

   static  final String  fileName = "C:\\Users\\knwrp\\IdeaProjects\\guru99SeleniumProject\\src\\main\\java\\com\\guru99\\TestData\\Guru99LoginTestData.xlsx";

    public static Object[][] getTestData(String sheetName) {

        FileInputStream ip = null;
        Object data[][]=null;
        try {
            ip = new FileInputStream(fileName);

            workbook = WorkbookFactory.create(ip);
            sheet = workbook.getSheet(sheetName);

            data = new Object[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                for (int j = 0; j < sheet.getRow(1).getLastCellNum(); j++) {
                    data[i][j] = sheet.getRow(i + 1).getCell(j).toString().trim();
                }
            }

        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        return data;


    }
}
