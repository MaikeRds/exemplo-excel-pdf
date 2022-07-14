package org.example.itext;


import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;

import javax.swing.text.StyleConstants;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Example22 {

    public static final String ZAPFDINGBATS = "src/main/resources/fonts/ZapfDingbatsRegular.ttf";

    /**
     * Exemplo para definir o tamanho da página em PDF
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {

        String projectPath = System.getProperty("user.dir");
        PdfWriter pdfWriter = new PdfWriter(projectPath + "/" + Example22.class.getName() + "-pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);

        float col = 280f;
        float columnWidth[] = {col, col};

        Table table = new Table(columnWidth);
        table.setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(ColorConstants.WHITE);


        table.addCell(
                new Cell().add(new Paragraph(new Text("Invoce"))
                                .setTextAlignment(TextAlignment.CENTER)
                                .setMarginTop(30f)
                                .setMarginBottom(30f)
                                .setFontSize(30f)
                    ).setBorder(Border.NO_BORDER)
        );

        table.addCell(
                new Cell().add(new Paragraph(new Text("Sarthi Techenology \n#3546 Ayodhya\n9876543210"))
                                .setTextAlignment(TextAlignment.RIGHT)
                                .setMarginRight(10f)
                                .setFontSize(10f)
                        ).setBorder(Border.NO_BORDER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
        );

        float colWidth[] = { 80f, 300f, 100f, 80f };
        Table customerInfoTable = new Table(colWidth);

        customerInfoTable.addCell(
                new Cell(0, 4).add(
                        new Paragraph(new Text("Customer Information").setBold()
                        )
                ).setBorder(Border.NO_BORDER)
        );

        customerInfoTable.addCell(
                new Cell().add(
                        new Paragraph(new Text("Name:"))
                ).setBorder(Border.NO_BORDER)
        );

        customerInfoTable.addCell(
                new Cell().add(
                        new Paragraph(new Text("Raja Sharma"))
                ).setBorder(Border.NO_BORDER)
        );

        customerInfoTable.addCell(
                new Cell().add(
                        new Paragraph(new Text("Invoce No.:"))
                ).setBorder(Border.NO_BORDER)
        );

        customerInfoTable.addCell(
                new Cell().add(
                        new Paragraph(new Text("3445"))
                ).setBorder(Border.NO_BORDER)
        );

        customerInfoTable.addCell(
                new Cell().add(
                        new Paragraph(new Text("Mo. No.:"))
                ).setBorder(Border.NO_BORDER)
        );

        customerInfoTable.addCell(
                new Cell().add(
                        new Paragraph(new Text("9876543210"))
                ).setBorder(Border.NO_BORDER)
        );

        customerInfoTable.addCell(
                new Cell().add(
                        new Paragraph(new Text("Date:"))
                ).setBorder(Border.NO_BORDER)
        );

        customerInfoTable.addCell(
                new Cell().add(
                        new Paragraph(new Text("05-03-2021"))
                ).setBorder(Border.NO_BORDER)
        );

        float itemInfoColWidth[] = { 140f, 140f, 140f, 140f};
        Table itemInfoTable = new Table(itemInfoColWidth);

        itemInfoTable.addCell(
                new Cell().add(
                        new Paragraph(new Text("Service"))
                ).setBackgroundColor(new DeviceRgb(63, 168, 219))
                        .setFontColor(ColorConstants.WHITE)
        );
        itemInfoTable.addCell(
                new Cell().add(
                        new Paragraph(new Text("Hrs."))
                ).setBackgroundColor(new DeviceRgb(63, 168, 219))
                        .setFontColor(ColorConstants.WHITE)
        );
        itemInfoTable.addCell(
                new Cell().add(new Paragraph(new Text("Unit Price (INR)")))
                        .setBackgroundColor(new DeviceRgb(63, 168, 219))
                        .setFontColor(ColorConstants.WHITE)
                        .setTextAlignment(TextAlignment.RIGHT)
        );
        itemInfoTable.addCell(
                new Cell().add(new Paragraph(new Text("Amount")))
                        .setBackgroundColor(new DeviceRgb(63, 168, 219))
                        .setFontColor(ColorConstants.WHITE)
                        .setTextAlignment(TextAlignment.RIGHT)
        );

        itemInfoTable.addCell(
                new Cell().add(new Paragraph(new Text("App Creation")))
        );
        itemInfoTable.addCell(
                new Cell().add(new Paragraph(new Text("20")))
        );
        itemInfoTable.addCell(
                new Cell().add(new Paragraph(new Text("200")))
                        .setTextAlignment(TextAlignment.RIGHT)

        );
        itemInfoTable.addCell(
                new Cell().add(new Paragraph(new Text(""+20*200)))
                        .setTextAlignment(TextAlignment.RIGHT)
        );

        itemInfoTable.addCell(
                new Cell().add(new Paragraph(new Text("Website Design")))
        );
        itemInfoTable.addCell(
                new Cell().add(new Paragraph(new Text("15")))
        );
        itemInfoTable.addCell(
                new Cell().add(new Paragraph(new Text("150")))
                        .setTextAlignment(TextAlignment.RIGHT)
        );
        itemInfoTable.addCell(
                new Cell().add(new Paragraph(new Text(""+15*150)))
                        .setTextAlignment(TextAlignment.RIGHT)
        );

        itemInfoTable.addCell(
                new Cell().add(new Paragraph(new Text("")))
                        .setBackgroundColor(new DeviceRgb(63, 169, 219))
                        .setFontColor(ColorConstants.WHITE)
                        .setBorder(Border.NO_BORDER)
        );
        itemInfoTable.addCell(
                new Cell().add(new Paragraph(new Text("")))
                        .setBackgroundColor(new DeviceRgb(63, 169, 219))
                        .setFontColor(ColorConstants.WHITE)
                        .setBorder(Border.NO_BORDER)
        );
        itemInfoTable.addCell(
                new Cell().add(new Paragraph(new Text("Total Amount")))
                        .setBackgroundColor(new DeviceRgb(63, 169, 219))
                        .setFontColor(ColorConstants.WHITE)
                        .setBorder(Border.NO_BORDER)
        );
        itemInfoTable.addCell(
                new Cell().add(new Paragraph(new Text("6250")))
                        .setTextAlignment(TextAlignment.RIGHT)
                        .setBackgroundColor(new DeviceRgb(63, 169, 219))
                        .setFontColor(ColorConstants.WHITE)
                        .setBorder(Border.NO_BORDER)
        );



        pdfDocument.addNewPage();
        Document document = new Document(pdfDocument);

        document.add(table);
        document.add(new Paragraph(new Text("\n")));
        document.add(customerInfoTable);
        document.add(new Paragraph(new Text("\n")));
        document.add(itemInfoTable);
        document.add(new Paragraph(new Text("\n (Authorised Signatory)")).setTextAlignment(TextAlignment.RIGHT));
        document.close();

    }
}
