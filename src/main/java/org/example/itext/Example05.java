package org.example.itext;



import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Example05 {

    /**
     * Exemplo para adicionar font em PDF
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {


        String projectPath = System.getProperty("user.dir");
        PdfWriter pdfWriter = new PdfWriter(projectPath + "/" + Example05.class.getName() + "-pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);

        PdfFont font = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
        PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);

        Text text1 = new Text("Exemplo texto 01 ").setFont(font);
        Text text2 = new Text("Exemplo texto 02").setFont(boldFont);

        Paragraph paragraph = new Paragraph().add(text1).add(text2);

        document.add(paragraph);
        document.close();

    }
}
