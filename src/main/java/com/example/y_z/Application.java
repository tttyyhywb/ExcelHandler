package com.example.y_z;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application {

    //target
    static String targetLocation = "src/main/resources/result.xlsx";

    //from
    static String fileLocation = "src/main/resources/excel.xlsx";

    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream(new File(fileLocation));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        SpecificationSpliter spliter = new SpecificationSpliter(3, 12);

        for (Row row : sheet) {
            spliter.split(row);
        }

        FileOutputStream outputStream = new FileOutputStream(targetLocation);
        workbook.write(outputStream);
        workbook.close();

    }


}
