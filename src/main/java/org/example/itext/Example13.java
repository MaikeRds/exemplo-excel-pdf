package org.example.itext;


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.GrooveBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;


public class Example13 {

    public static final String ROBOTO = "src/main/resources/fonts/roboto/Roboto-Regular.ttf";
    public static final String ABEL = "src/main/resources/fonts/abel/abel-regular.ttf";

    /**
     * Exemplo para creiar tabela no PDF
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {

        URL resource = Image.class.getClassLoader().getResource("logo-01.png");
        ImageData data  = ImageDataFactory.create(resource);
        Image image1 =  new Image(data);

        String projectPath = System.getProperty("user.dir");
        PdfWriter pdfWriter = new PdfWriter(projectPath + "/" + Example13.class.getName() + "-pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        PdfFont font = PdfFontFactory.createFont(ROBOTO, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);
        PdfFont boldFont = PdfFontFactory.createFont(ABEL, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);

        float columnWidh[] = { 200f, 50f, 100f };

        Table table = new Table(columnWidh);

        Cell cell11 = new Cell();
        cell11.add(new Paragraph("Item"));
        table.addCell(cell11);

        table.addCell(new Cell().add(new Paragraph("Qty")));
        table.addCell(new Cell().add(new Paragraph("Avaliable")));

        table.addCell(new Cell().add(new Paragraph("Orange")));
        table.addCell(new Cell().add(new Paragraph("2 kg")));
        table.addCell(new Cell().add(new Paragraph("Yes")));

        table.addCell(new Cell().add(new Paragraph("Mango")));
        table.addCell(new Cell().add(image1.setAutoScale(true)));
        table.addCell(new Cell().add(new Paragraph("No")));

        document.add(table);

        document.close();

    }
}
