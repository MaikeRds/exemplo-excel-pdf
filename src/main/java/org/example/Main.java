package org.example;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {

        String projectPath = System.getProperty("user.dir");

        InputStream is = Main.class.getClassLoader().getResourceAsStream("Resultados da Amostra.xlsx");


        XSSFWorkbook wb = new XSSFWorkbook(is);
        //FileOutputStream fileOut = new FileOutputStream(projectPath + "/new.xlsx");
        FileOutputStream fileOut = new FileOutputStream("/tmp/new.xlsx");
        XSSFSheet sheet1 = wb.getSheet("Sheet0");
        XSSFRow row = sheet1.getRow(15);
        XSSFCell cell = row.getCell(3);
        cell.setCellValue("Bharthan");

        wb.write(fileOut);
        fileOut.close();

        System.out.println(is);
        System.out.println(projectPath);

    }
}