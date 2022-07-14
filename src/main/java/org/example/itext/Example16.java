package org.example.itext;


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;


public class Example16 {

    public static final String ROBOTO = "src/main/resources/fonts/roboto/Roboto-Regular.ttf";
    public static final String ABEL = "src/main/resources/fonts/abel/abel-regular.ttf";

    /**
     * Exemplo para adicionar Extensão de coluna e extensão de linha na tabela do PDF
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {

        String projectPath = System.getProperty("user.dir");
        PdfWriter pdfWriter = new PdfWriter(projectPath + "/" + Example16.class.getName() + "-pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        PdfFont font = PdfFontFactory.createFont(ROBOTO, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);
        PdfFont boldFont = PdfFontFactory.createFont(ABEL, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);


        float columnWidh[] = { 200f, 200f, 200f };

        Table table = new Table(columnWidh);

        table.addCell(new Cell().add(new Paragraph("One")));
        table.addCell(new Cell().add(new Paragraph("Two")));
        table.addCell(new Cell(2, 0).add(new Paragraph("Three")));
        table.addCell(new Cell().add(new Paragraph("Four")));
        table.addCell(new Cell().add(new Paragraph("Five")));
        table.addCell(new Cell(0, 2).add(new Paragraph("Six")));
        table.addCell(new Cell().add(new Paragraph("Seven")));

        document.add(table);

        document.close();

    }
}
