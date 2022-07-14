package org.example.itext;


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;


public class Example21 {

    public static final String ZAPFDINGBATS = "src/main/resources/fonts/ZapfDingbatsRegular.ttf";

    /**
     * Exemplo para definir o tamanho da página em PDF
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {

        String projectPath = System.getProperty("user.dir");
        PdfWriter pdfWriter = new PdfWriter(projectPath + "/" + Example21.class.getName() + "-pdf");
        Rectangle myPageSize = new Rectangle(700, 1400);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        pdfDocument.addNewPage();
       // pdfDocument.addNewPage(new PageSize(myPageSize));

        Document document = new Document(pdfDocument);

        Text text = new Text("Olá mundo!");

        document.add(new Paragraph(text));
        document.close();

    }
}
