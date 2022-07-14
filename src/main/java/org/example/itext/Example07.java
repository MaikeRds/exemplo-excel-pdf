package org.example.itext;


import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Example07 {

    public static final String ROBOTO = "src/main/resources/fonts/roboto/Roboto-Regular.ttf";
    public static final String OPEN_SANS = "src/main/resources/fonts/open_sans/static/OpenSans/OpenSans-Regular.ttf";

    public static final String ARIAL = "src/main/resources/fonts/arial.ttf";

    /**
     * Exemplo para adicionar Bold, italic, underline, color na font em PDF
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {

        String projectPath = System.getProperty("user.dir");
        PdfWriter pdfWriter = new PdfWriter(projectPath + "/" + Example07.class.getName() + "-pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        PdfFont font = PdfFontFactory.createFont(ROBOTO, PdfEncodings.IDENTITY_H, PdfFontFactory.EmbeddingStrategy.FORCE_EMBEDDED);
        PdfFont font2 = PdfFontFactory.createFont(OPEN_SANS, PdfEncodings.IDENTITY_H, PdfFontFactory.EmbeddingStrategy.FORCE_EMBEDDED);
        PdfFont font3 = PdfFontFactory.createFont(ARIAL, PdfEncodings.IDENTITY_H, PdfFontFactory.EmbeddingStrategy.FORCE_EMBEDDED);

        Text text1 = new Text("Exemplo texto 01 - Normal ").setFont(font);
        Text text2 = new Text("\nExemplo texto 02 - Bold ").setFont(font).setBold();
        Text text3 = new Text("\nExemplo texto 03 - Italic ").setFont(font).setItalic();
        Text text4 = new Text("\nExemplo texto 03 - Underline ").setFont(font).setUnderline();
        Text text5 = new Text("\nExemplo texto 03 - Bold Italic ").setFont(font).setBold().setItalic();
        Text text6 = new Text("\nExemplo texto 03 - Color ").setFont(font).setFontColor(ColorConstants.BLUE);
        Text text7 = new Text("\nExemplo texto 03 - Color Bold ").setFont(font).setBold().setStrokeColor(ColorConstants.BLUE);
        Text text8 = new Text("\n\u25CF  aa").setFont(font3).setBold().setFontColor(ColorConstants.BLUE);

        List list = new List();
        list.add("Java").setFont(font3);
        list.add("JavaFX").setFontColor(ColorConstants.BLUE);
        list.add("Apache Tika");
        list.add("OpenCV").setListSymbol("\u25CF ");


        Paragraph paragraph = new Paragraph()
                .add(text1)
                .add(text2)
                .add(text3)
                .add(text4)
                .add(text5)
                .add(text6)
                .add(text7)
                .add(text8);

        Paragraph paragraph1 = new Paragraph()
                .add(new Text("\u25CF ").setFont(font3).setBold().setFontColor(ColorConstants.BLUE))
                .add(new Text("Java").setFont(font));
        Paragraph paragraph2 = new Paragraph()
                .add(new Text("\u25CF ").setFont(font3).setBold().setFontColor(ColorConstants.RED))
                .add(new Text("JavaFX").setFont(font));
        Paragraph paragraph3 = new Paragraph()
                .add(new Text("\u25CF ").setFont(font3).setBold().setFontColor(ColorConstants.YELLOW))
                .add(new Text("Apache Tika").setFont(font));
        Paragraph paragraph4 = new Paragraph()
                .add(new Text("\u25CF ").setFont(font3).setBold().setFontColor(ColorConstants.GREEN))
                .add(new Text("OpenCV").setFont(font));;

        document.add(paragraph);
        document.add(paragraph1).add(paragraph2).add(paragraph3).add(paragraph4);
        document.add(list);
        document.close();

    }
}
