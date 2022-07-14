package org.example.itext;


import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Example11 {

    public static final String ROBOTO = "src/main/resources/fonts/roboto/Roboto-Regular.ttf";
    public static final String ABEL = "src/main/resources/fonts/abel/abel-regular.ttf";

    /**
     * Exemplo para creiar tabela no PDF
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {

        String projectPath = System.getProperty("user.dir");
        PdfWriter pdfWriter = new PdfWriter(projectPath + "/" + Example11.class.getName() + "-pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        PdfFont font = PdfFontFactory.createFont(ROBOTO, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);
        PdfFont boldFont = PdfFontFactory.createFont(ABEL, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);

        String[] tableHeader = { "Item", "Color", "Size"};
        String[][] itemArray = {
                {"Box", "Red", "Big"},
                {"Bat", "White", "Big"},
                {"Stick", "Black", "Long"},
                {"Toy Gun", "Gray", "Small"},
                {"Ball", "Red", "Small"},
        };

        float columnWidh[] = { 200f, 50f, 100f };

        Table table = new Table(columnWidh);

        for (int x = 0; x < 3; x++){
            table.addCell(new Cell().add(new Paragraph(tableHeader[x])
                    .setBackgroundColor(new DeviceRgb(187, 88, 87))
                    ).setBorder(Border.NO_BORDER).setPadding(0));
        }

        for (int i=0; i < 5; i++){
            for (int j=0; j < 3; j++){
                if((i % 2) == 0){
                    table.addCell(new Cell().add(new Paragraph(itemArray[i][j])
                            .setBackgroundColor(new DeviceRgb(253, 185, 149))
                    ).setBorder(Border.NO_BORDER).setPadding(0));
                }else{
                    table.addCell(new Cell().add(new Paragraph(itemArray[i][j])
                            .setBackgroundColor(new DeviceRgb(254, 220, 201))

                    ).setBorder(Border.NO_BORDER).setPadding(0));
                }
            }
        }

        document.add(table);

        document.close();

    }
}
