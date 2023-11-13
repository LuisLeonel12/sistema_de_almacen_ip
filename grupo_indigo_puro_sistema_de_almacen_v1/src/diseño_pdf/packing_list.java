package diseño_pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class packing_list {

	
	//metodo principal
	public static void main(String[] args) {
		pdf_packing_list();
	}
	
	
	
	//metodo encargado de generar el pdf
	public static void pdf_packing_list() {
		
		String nombre_documento = "packing list" ;
		
		String url="C:/Users/User/eclipse-workspace/grupo_indigo_puro_sistema_de_almacen_v1/src/pdf/"+""+".pfd";
		Rectangle r = new Rectangle(220,280);
		Document documento = new Document(r,9f,9f,7f,7f);
		
		try {
			
			FileOutputStream archivo = new FileOutputStream(url);
			
			PdfWriter.getInstance(documento, archivo);
			
			
			documento.open();
			
		} catch (Exception e) {
			
		}
		
		      
	}
	
	
}
