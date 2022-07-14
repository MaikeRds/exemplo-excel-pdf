package org.example.itext;



import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;

import java.io.FileNotFoundException;



public class Example04 {

    /**
     * Exemplo para adicionar lista em PDF
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        List list1 = new List();
        list1.add("Java");
        list1.add("Android");
        list1.add("Kotlin");
        list1.add("C");

        String projectPath = System.getProperty("user.dir");
        PdfWriter pdfWriter = new PdfWriter(projectPath + "/" + Example04.class.getName() + "-pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);

        document.add(list1);


        document.close();

    }
}
