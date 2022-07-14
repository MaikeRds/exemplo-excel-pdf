package org.example.itext;


import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Example08 {

    public static final String ROBOTO = "src/main/resources/fonts/roboto/Roboto-Regular.ttf";
    public static final String ABEL = "src/main/resources/fonts/abel/abel-regular.ttf";

    /**
     * Exemplo para embutir Estilo em PDF
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {

        String projectPath = System.getProperty("user.dir");
        PdfWriter pdfWriter = new PdfWriter(projectPath + "/" + Example08.class.getName() + "-pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        PdfFont font = PdfFontFactory.createFont(ROBOTO, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);
        PdfFont boldFont = PdfFontFactory.createFont(ABEL, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);

        Style style = new Style();
        style.setFont(font).setFontColor(ColorConstants.BLUE).setFontSize(12f).setItalic();

        Text text1 = new Text("Exemplo texto 01 ").addStyle(style);
        Text text2 = new Text("Exemplo texto 02").setFont(boldFont);

        Paragraph paragraph = new Paragraph().add(text1).add(text2);

        document.add(paragraph);
        document.close();

    }
}
