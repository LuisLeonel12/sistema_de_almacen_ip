package pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class paking_list_pdf {

    private static final String FILE_NAME =  "F:/DOCUMENTOS PERSONALES/itext.pdf";
	
	public static void main(String[] args) {
		pdf_packing_list();
	}
	
	
	public static void pdf_packing_list() {
			 
		Document document = new Document();
		 
        try {
 
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
 
            //open
            document.open();
 
            Paragraph p = new Paragraph();
            p.add("PACKING LIST");
            p.setAlignment(Element.ALIGN_CENTER);
 
            document.add(p);
 
 
            //close
            document.close();
         
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

	        
	}

}
