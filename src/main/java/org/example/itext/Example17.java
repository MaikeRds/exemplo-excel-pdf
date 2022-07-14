package org.example.itext;


import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Example17 {

    public static final String ROBOTO = "src/main/resources/fonts/roboto/Roboto-Regular.ttf";
    public static final String ABEL = "src/main/resources/fonts/abel/abel-regular.ttf";

    /**
     * Exemplo para adicionar (Em detalhe) Extensão de coluna e extensão de linha na tabela do PDF
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {

        String projectPath = System.getProperty("user.dir");
        PdfWriter pdfWriter = new PdfWriter(projectPath + "/" + Example17.class.getName() + "-pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        PdfFont font = PdfFontFactory.createFont(ROBOTO, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);
        PdfFont boldFont = PdfFontFactory.createFont(ABEL, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);


        float columnWidh[] = { 100f, 100f, 100f, 100f, 100f, 100f };

        Table table = new Table(columnWidh);

        table.addCell(new Cell().add(new Paragraph("Sarthi Technology")));
        table.addCell(new Cell(2, 0).add(new Paragraph("Android Battery Manager")));
        table.addCell(new Cell(3, 0).add(new Paragraph("Android Wifi P2P")));
        table.addCell(new Cell(3, 0).add(new Paragraph("Android Bluetooh")));
        table.addCell(new Cell(0, 2).add(new Paragraph("Android Sensor Programing")));
        table.addCell(new Cell().add(new Paragraph("Picasso Libary")));
        table.addCell(new Cell().add(new Paragraph("Android PDF Document")));
        table.addCell(new Cell().add(new Paragraph("User Location")));
        table.addCell(new Cell().add(new Paragraph("MP Android Chart")));
        table.addCell(new Cell().add(new Paragraph("Graph View")));
        table.addCell(new Cell().add(new Paragraph("IText 7 Java")));
        table.addCell(new Cell().add(new Paragraph("IText 7 Android")));

        document.add(table);

        document.close();

    }
}
