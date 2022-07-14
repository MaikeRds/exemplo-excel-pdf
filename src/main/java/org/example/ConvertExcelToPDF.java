package org.example;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;


public class ConvertExcelToPDF {

    public static void main(String[] args) throws IOException {

        String projectPath = System.getProperty("user.dir");
        InputStream is = Main.class.getClassLoader().getResourceAsStream("Resultados da Amostra.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(is);


        XSSFSheet sheet = wb.getSheet("Sheet0");

    }
}
