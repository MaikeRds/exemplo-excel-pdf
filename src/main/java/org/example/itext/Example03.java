package org.example.itext;


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;
import java.net.URL;


public class Example03 {

    /**
     * Exemplo para adicionar imagem no PDF
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        URL resource = Image.class.getClassLoader().getResource("logo-01.png");
        ImageData data  = ImageDataFactory.create(resource);
        Image image1 =  new Image(data);

        String projectPath = System.getProperty("user.dir");
        String paraText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        Paragraph paragraph1 = new Paragraph(paraText);

        PdfWriter pdfWriter = new PdfWriter(projectPath + "/" + Example03.class.getName() + "-pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        document.add(paragraph1);
        document.add(image1);
        document.close();

    }
}
