package org.example.itext;


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;


public class Example20 {

    public static final String ZAPFDINGBATS = "src/main/resources/fonts/ZapfDingbatsRegular.ttf";

    /**
     * Exemplo para usar imagem como ícone de lista em PDF
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {

        URL resource = Image.class.getClassLoader().getResource("logo-01.png");
        ImageData data  = ImageDataFactory.create(resource);
        Image image1 =  new Image(data);

        String projectPath = System.getProperty("user.dir");
        PdfWriter pdfWriter = new PdfWriter(projectPath + "/" + Example20.class.getName() + "-pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);

        List list = new List();

        image1.setHeight(15f);
        image1.setWidth(30f);
        list.setListSymbol(image1);

        list.add("Apple");
        list.add("Mango");
        list.add("Banana");
        list.add("Cherry");
        list.add("Orange");

        document.add(list);
        document.close();

    }
}
