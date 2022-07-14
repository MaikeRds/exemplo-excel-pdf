package org.example.itext;


import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Text;

import javax.swing.text.StyleConstants;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Example19 {

    public static final String ZAPFDINGBATS = "src/main/resources/fonts/ZapfDingbatsRegular.ttf";

    /**
     * Exemplo para alterar símbolo da lista do PDF
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {

        String projectPath = System.getProperty("user.dir");
        PdfWriter pdfWriter = new PdfWriter(projectPath + "/" + Example19.class.getName() + "-pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        PdfFont font = PdfFontFactory.createFont(ZAPFDINGBATS, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);


        List list = new List();

        Text text = new Text("A B C D E F G H I J L N M O P Q R S T U V X Z ").setFont(font);

        list.setListSymbol(text);

        list.add("Apple");
        list.add("Mango");
        list.add("Banana");
        list.add("Cherry");
        list.add("Orange");

        document.add(list);
        document.close();

    }
}
