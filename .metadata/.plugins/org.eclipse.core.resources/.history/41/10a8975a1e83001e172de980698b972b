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
			
			//variable para salto de linea
			Paragraph salto_linea = new Paragraph();
			salto_linea.add(new Paragraph(Chunk.NEWLINE));
			
			
			//INICIA EL APARTADO DE ENCABEZADO
			PdfPTable encabezado = new PdfPTable(2);
			encabezado.setWidthPercentage(100);
			float[] medida_de_celda_encabezado = {10f,10f};
			encabezado.setWidths(medida_de_celda_encabezado);
			
			PdfPCell seccion1 = new PdfPCell(new Phrase("PACKING LIST",Fuente_titulo)); 
			seccion1.setVerticalAlignment(Element.ALIGN_CENTER);
			seccion1.setHorizontalAlignment(Element.ALIGN_CENTER);
			seccion1.setBorder(0);
                        
            PdfPCell seccion2 = new PdfPCell(new Phrase("GRUPO INDIGO PURO",Fuente_titulo)); 
            seccion2.setVerticalAlignment(Element.ALIGN_CENTER);
            seccion2.setHorizontalAlignment(Element.ALIGN_CENTER);
            seccion2.setBorder(0);
			
			PdfPCell seccion3 = new PdfPCell(new Phrase("",Fuente_titulo)); 
			seccion3.setVerticalAlignment(Element.ALIGN_CENTER);
			seccion3.setHorizontalAlignment(Element.ALIGN_CENTER);
			seccion3.setBorder(0);
                        
            PdfPCell s1 = new PdfPCell(new Phrase("",Fuente_titulo)); 
			s1.setVerticalAlignment(Element.ALIGN_CENTER);
			s1.setHorizontalAlignment(Element.ALIGN_CENTER);
			s1.setBorder(0);
			
			encabezado.addCell(seccion1);
			encabezado.addCell(seccion2);
			encabezado.addCell(seccion3);
			encabezado.addCell(s1);
                        
			documento.add(encabezado);
			//TERMINA EL APARTADO DE ENCABEZADO
			
			
			
			
			//INICIA EL APARTADO DE LISTADO
			PdfPTable informacion = new PdfPTable(2);
			informacion.setWidthPercentage(100);
			float[] medida_de_celda_informacion = {10f,10f};
			informacion.setWidths(medida_de_celda_informacion);
			
			PdfPCell linea1 = new PdfPCell(new Phrase("__________________________",Fuente_titulo)); 
			linea1.setVerticalAlignment(Element.ALIGN_CENTER);
			linea1.setHorizontalAlignment(Element.ALIGN_CENTER);
			linea1.setBorder(0);
                        
            PdfPCell linea2 = new PdfPCell(new Phrase("__________________________",Fuente_titulo)); 
			linea2.setVerticalAlignment(Element.ALIGN_CENTER);
			linea2.setHorizontalAlignment(Element.ALIGN_CENTER);
			linea2.setBorder(0);
			
			PdfPCell n_paciente = new PdfPCell(new Phrase("Nombre Del Paciente",Fuente_titulo)); 
			n_paciente.setVerticalAlignment(Element.ALIGN_CENTER);
			n_paciente.setHorizontalAlignment(Element.ALIGN_CENTER);
			n_paciente.setBorder(0);
                        
            PdfPCell nf = new PdfPCell(new Phrase("Nombre Del Fisioterapeuta Tratante",Fuente_titulo)); 
			nf.setVerticalAlignment(Element.ALIGN_CENTER);
			nf.setHorizontalAlignment(Element.ALIGN_CENTER);
			nf.setBorder(0);
			
			informacion.addCell(linea1);
			informacion.addCell(linea2);
			informacion.addCell(n_paciente);
            informacion.addCell(nf);
                        
			documento.add(informacion);
			//TERMINA EL APARTADO DE LISTADO
			
			
			//cerrar necesariamente el documento pdf para acceder al archivo generado
			documento.close();
			
			
			JOptionPane.showMessageDialog(null,"PDF GENERADO CORRECTAMENTE");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"ERROR AL GENERAR EL PDF");
		}
		
		      
	}
	
	
}
