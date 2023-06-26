package com.example.htmltopdf.document;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.font.FontProvider;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;


@Service
public class DocumentGenerator {
    public String htmlToPdf(String processHtml){
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        try{
            PdfWriter pdfWriter=new PdfWriter(byteArrayOutputStream);
            DefaultFontProvider fontProvider=new DefaultFontProvider(false,true,false);
            ConverterProperties converterProperties=new ConverterProperties();
            converterProperties.setFontProvider(fontProvider);
            HtmlConverter.convertToPdf(processHtml,pdfWriter,converterProperties);
            FileOutputStream fout=new FileOutputStream("C:/Users/PrasadSanap/IdeaProjects/htmltopdf/PDFFiles/Employee.pdf");
            byteArrayOutputStream.writeTo(fout);
            byteArrayOutputStream.close();
            byteArrayOutputStream.flush();
            fout.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
