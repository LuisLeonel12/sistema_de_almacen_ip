package diseño_pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class packing_list {

	
	//metodo principal
	public static void main(String[] args) {
		pdf_packing_list();
	}
	
	
	
	//metodo encargado de generar el pdf
	public static void pdf_packing_list() {
		
		String nombre_documento = "packing list" ;
		
		String url="C:/Users/User/eclipse-workspace/grupo_indigo_puro_sistema_de_almacen_v1/src/pdf/"+nombre_documento+".pdf";
		Rectangle r = new Rectangle(220,280);
		Document documento = new Document(r,9f,9f,7f,7f);
		
		try {
			
			FileOutputStream archivo = new FileOutputStream(url);
			
			PdfWriter.getInstance(documento, archivo);
			
			documento.open();
			
			
			//FUENTES PARA TITULOS Y FUENTE PARA LOS DATOS
			//TIPO DE LETRA, TAMAÑO DE LA FUENTE,DISEÑO DE LETRA,COLOR DE LA FUENTE
			Font Fuente_titulo = FontFactory.getFont(FontFactory.TIMES,6,Font.NORMAL,BaseColor.BLACK);
			Font Fuente_texto = FontFactory.getFont(FontFactory.TIMES,5,Font.NORMAL,BaseColor.BLACK);
			
			//VARIABLES UTILIZADA PARA DAR UN SALTO DE LINEA
 			Paragraph salto_linea = new Paragraph();
//			salto_linea.add(new Paragraph(Chunk.NEWLINE));
			
			
			//INICIA EL APARTADO DE TITULO PARA EL DOCUMENTO
			PdfPTable titulo = new PdfPTable(1);
			titulo.setWidthPercentage(100);
			float[] medida_de_celda_titulo = {10f};
			titulo.setWidths(medida_de_celda_titulo);
			
			PdfPCell t1 = new PdfPCell(new Phrase("INFORME DE CORTE POR MODELO",Fuente_titulo)); 
			t1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			t1.setHorizontalAlignment(Element.ALIGN_CENTER);
			t1.setBackgroundColor(new GrayColor(0.9f));
			
			titulo.addCell(t1);
                        
			documento.add(titulo);
			
			//TERMINA EL APARTADO DE TITULO PARA EL DOCUMENTO
			
			
			//INICIA EL APARTADO DE TABLA 1
			PdfPTable tabla_1 = new PdfPTable(5);
			tabla_1.setWidthPercentage(100);
			float[] medida_de_celda_tabla_1 = {2f,5f,5f,4f,4f};
			tabla_1.setWidths(medida_de_celda_tabla_1);
			
			PdfPCell celda_1 = new PdfPCell(new Phrase("TELA",Fuente_texto)); 
			celda_1.setVerticalAlignment(Element.ALIGN_CENTER);
			celda_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			
			//NOMBRE DE TELA
			PdfPCell celda_2 = new PdfPCell(new Phrase("NOMBRE DE TELA",Fuente_texto)); 
			celda_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			celda_2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell celda_3 = new PdfPCell(new Phrase("PIEZAS SOLICITADAS",Fuente_texto)); 
			celda_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			celda_3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			//CANTIDAD DE PIEZAS
			PdfPCell celda_4 = new PdfPCell(new Phrase("CANTIDAD DE PIEZAS",Fuente_texto)); 
			celda_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			celda_4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell celda_5 = new PdfPCell(new Phrase(" ",Fuente_texto)); 
			celda_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			celda_5.setHorizontalAlignment(Element.ALIGN_CENTER);
			

			tabla_1.addCell(celda_1);
			tabla_1.addCell(celda_2);
			tabla_1.addCell(celda_3);
			tabla_1.addCell(celda_4);
			tabla_1.addCell(celda_5);
                        
			documento.add(tabla_1);
			
			//TERMINA EL APARTADO DE TABLA 1
			
			
			
			//INICIA EL APARTADO DE TABLA 1 SECCION 2
			PdfPTable tabla_1_1 = new PdfPTable(5);
			tabla_1_1.setWidthPercentage(100);
			float[] medida_de_celda_tabla_1_1 = {2f,5f,5f,4f,4f};
			tabla_1_1.setWidths(medida_de_celda_tabla_1_1);
			
			PdfPCell celda_6 = new PdfPCell(new Phrase("TELA",Fuente_texto)); 
			celda_6.setVerticalAlignment(Element.ALIGN_CENTER);
			celda_6.setHorizontalAlignment(Element.ALIGN_LEFT);
			
			//NOMBRE DE TELA
			PdfPCell celda_7 = new PdfPCell(new Phrase("NOMBRE DE TELA",Fuente_texto)); 
			celda_7.setVerticalAlignment(Element.ALIGN_MIDDLE);
			celda_7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell celda_8 = new PdfPCell(new Phrase("PIEZAS SOLICITADAS",Fuente_texto)); 
			celda_8.setVerticalAlignment(Element.ALIGN_MIDDLE);
			celda_8.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			//CANTIDAD DE PIEZAS
			PdfPCell celda_9 = new PdfPCell(new Phrase("CANTIDAD DE PIEZAS",Fuente_texto)); 
			celda_9.setVerticalAlignment(Element.ALIGN_MIDDLE);
			celda_9.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell celda_10 = new PdfPCell(new Phrase(" ",Fuente_texto)); 
			celda_10.setVerticalAlignment(Element.ALIGN_MIDDLE);
			celda_10.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell celda_11 = new PdfPCell(new Phrase(" ",Fuente_texto)); 
			celda_11.setVerticalAlignment(Element.ALIGN_MIDDLE);
			celda_11.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell celda_12 = new PdfPCell(new Phrase(" ",Fuente_texto)); 
			celda_12.setVerticalAlignment(Element.ALIGN_MIDDLE);
			celda_12.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell celda_13 = new PdfPCell(new Phrase(" ",Fuente_texto)); 
			celda_13.setVerticalAlignment(Element.ALIGN_MIDDLE);
			celda_13.setHorizontalAlignment(Element.ALIGN_CENTER);
			

			tabla_1.addCell(celda_1);
			tabla_1.addCell(celda_2);
			tabla_1.addCell(celda_3);
			tabla_1.addCell(celda_4);
			tabla_1.addCell(celda_5);
                        
			documento.add(tabla_1);
			
			//TERMINA EL APARTADO DE TABLA 1 SECCION 2
			
			
			
			
			//INSTANCIA QUE SE ENCARGA DE CERRRAR EL DOCUMENTO PARA POSTERIORMENTE PODER LLAMAR LA FUNCION
			documento.close();
			
			
			JOptionPane.showMessageDialog(null,"PDF GENERADO CORRECTAMENTE");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"ERROR AL GENERAR EL PDF");
		}
		
		      
	}
	
	
}
