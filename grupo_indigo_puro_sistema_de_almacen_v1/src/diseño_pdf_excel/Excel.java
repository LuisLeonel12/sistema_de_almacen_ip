package diseño_pdf_excel;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import conexion.Conexion;
import interfaces.Registro_de_Salidas;

public class Excel {
	
	
	public static void reporte() {
		 
				
	      Workbook book = new XSSFWorkbook();
          Sheet sheet = book.createSheet("INVENTARIO GENERAL");
          
          try {

              CellStyle tituloEstilo = book.createCellStyle();
              tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
              tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
              tituloEstilo.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
              tituloEstilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
              
              Font fuenteTitulo = book.createFont();
              fuenteTitulo.setFontName("Arial");
              fuenteTitulo.setBold(true);
              fuenteTitulo.setFontHeightInPoints((short) 14);
              fuenteTitulo.setColor(IndexedColors.WHITE.getIndex());
              tituloEstilo.setFont(fuenteTitulo);

              Row filaTitulo = sheet.createRow(1);
              Cell celdaTitulo = filaTitulo.createCell(1);
              celdaTitulo.setCellStyle(tituloEstilo);
              celdaTitulo.setCellValue("INVENTARIO GENERAL");

              sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 11));

              String[] cabecera = new String[]{"ID", "CODIGO ROLLO", "NOMBRE TELA", "PROVEEDOR", "KILOS","METROS", "ESTILO", "ANCHO", "PIEZAS", "CARACTERISTICAS", "FECHA ENTRADA", "HORA ENTRADA"};

              CellStyle headerStyle = book.createCellStyle();
              headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
              headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
              headerStyle.setBorderBottom(BorderStyle.THIN);
              headerStyle.setBorderLeft(BorderStyle.THIN);
              headerStyle.setBorderRight(BorderStyle.THIN);
              headerStyle.setBorderTop(BorderStyle.THIN);
              headerStyle.setAlignment(HorizontalAlignment.CENTER);
              
              Font font = book.createFont();
              font.setFontName("Arial");
              font.setBold(true);
              font.setColor(IndexedColors.WHITE.getIndex());
              font.setFontHeightInPoints((short) 12);
              headerStyle.setFont(font);

              Row filaEncabezados = sheet.createRow(4);

              for (int i = 0; i < cabecera.length; i++) {
                  Cell celdaEncabezado = filaEncabezados.createCell(i);
                  celdaEncabezado.setCellStyle(headerStyle);
                  celdaEncabezado.setCellValue(cabecera[i]);
              }

              int numFilaDatos = 5;

              CellStyle datosEstilo = book.createCellStyle();
              datosEstilo.setBorderBottom(BorderStyle.THIN);
              datosEstilo.setBorderLeft(BorderStyle.THIN);
              datosEstilo.setBorderRight(BorderStyle.THIN);
              datosEstilo.setBorderTop(BorderStyle.THIN);
              datosEstilo.setAlignment(HorizontalAlignment.CENTER);

              PreparedStatement ps;
          	  Conexion con = new Conexion();
          	  Connection conexion = con.Conectar();
          	  ResultSet rs;
              
              ps = conexion.prepareStatement("select * from inventario_general;");
              rs = ps.executeQuery();

              int numCol = rs.getMetaData().getColumnCount();

              while (rs.next()) {
                  Row filaDatos = sheet.createRow(numFilaDatos);

                  for (int a = 0; a < numCol; a++) {
                      Cell CeldaDatos = filaDatos.createCell(a);
                      CeldaDatos.setCellStyle(datosEstilo);
                      CeldaDatos.setCellValue(rs.getString(a + 1));
                  }

                  numFilaDatos++;
              }

              sheet.autoSizeColumn(0);
              sheet.autoSizeColumn(1);
              sheet.autoSizeColumn(2);
              sheet.autoSizeColumn(3);
              sheet.autoSizeColumn(4);
              sheet.autoSizeColumn(5);
              sheet.autoSizeColumn(6);
              sheet.autoSizeColumn(7);
              sheet.autoSizeColumn(8);
              sheet.autoSizeColumn(9);
              sheet.autoSizeColumn(10);
              sheet.autoSizeColumn(11);

              sheet.setZoom(150);
              
           // Obtener la fecha y hora actual
              LocalDateTime now = LocalDateTime.now();
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
              String fechaHoraActual = now.format(formatter);
              
              String fileName = "INVENTARIO"+"_"+fechaHoraActual;
              String home = System.getProperty("user.home");
              File file = new File(home + "/Downloads/" + fileName + ".xlsx");
              FileOutputStream fileOut = new FileOutputStream(file);
              book.write(fileOut);
              fileOut.close();
              Desktop.getDesktop().open(file);
              JOptionPane.showMessageDialog(null, "REPORTE GENERADO CORRECTAMENTE");

          } catch (FileNotFoundException ex) {
           Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException | SQLException ex) {
              Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
          }
		}
	
	
	 public static void generarExcelDesdeTabla(Registro_de_Salidas rs) {
	        DefaultTableModel modeloTabla = (DefaultTableModel) rs.tbl_salidas.getModel();

	        if (modeloTabla.getRowCount() > 0) {
	            try (Workbook book = new XSSFWorkbook()) {
	                Sheet sheet = book.createSheet("PACKING LIST");

	                // Estilo para el título
	                CellStyle tituloEstilo = book.createCellStyle();
	                tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
	                tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
	                tituloEstilo.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
	                tituloEstilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	                Font fuenteTitulo = book.createFont();
	                fuenteTitulo.setFontName("Arial");
	                fuenteTitulo.setBold(true);
	                fuenteTitulo.setFontHeightInPoints((short) 14);
	                fuenteTitulo.setColor(IndexedColors.WHITE.getIndex());
	                tituloEstilo.setFont(fuenteTitulo);

	                // Crear fila para el título
	                Row filaTitulo = sheet.createRow(1);
	                Cell celdaTitulo = filaTitulo.createCell(1);
	                celdaTitulo.setCellStyle(tituloEstilo);
	                celdaTitulo.setCellValue("PACKING LIST");

	                // Fusionar celdas para el título
	                sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 6));

	                String[] cabecera = new String[]{" CODIGO ", " NOMBRE ", " CANTIDAD ", " METROS ", " ANCHO ", " KILOS "};

	                // Estilo para los encabezados
	                CellStyle headerStyle = book.createCellStyle();
	                headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
	                headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	                headerStyle.setBorderBottom(BorderStyle.THIN);
	                headerStyle.setBorderLeft(BorderStyle.THIN);
	                headerStyle.setBorderRight(BorderStyle.THIN);
	                headerStyle.setBorderTop(BorderStyle.THIN);
	                headerStyle.setAlignment(HorizontalAlignment.CENTER);

	                Font font = book.createFont();
	                font.setFontName("Arial");
	                font.setBold(true);
	                font.setColor(IndexedColors.WHITE.getIndex());
	                font.setFontHeightInPoints((short) 12);
	                headerStyle.setFont(font);

	                // Crear fila para los encabezados
	                Row filaEncabezados = sheet.createRow(4);

	                for (int i = 0; i < cabecera.length; i++) {
	                    Cell celdaEncabezado = filaEncabezados.createCell(i + 1); // Desplazar una columna a la derecha
	                    celdaEncabezado.setCellStyle(headerStyle);
	                    celdaEncabezado.setCellValue(cabecera[i]);

	                    // Ajustar automáticamente el ancho de las columnas
	                    sheet.autoSizeColumn(i + 1);
	                }

	                // Estilo para los datos
	                CellStyle datosEstilo = book.createCellStyle();
	                datosEstilo.setBorderBottom(BorderStyle.THIN);
	                datosEstilo.setBorderLeft(BorderStyle.THIN);
	                datosEstilo.setBorderRight(BorderStyle.THIN);
	                datosEstilo.setBorderTop(BorderStyle.THIN);
	                datosEstilo.setAlignment(HorizontalAlignment.CENTER);

	                // AGREGAR LOS DATOS
	                for (int i = 0; i < modeloTabla.getRowCount(); i++) {
	                    Row dataRow = sheet.createRow(i + 5);
	                    for (int j = 0; j < modeloTabla.getColumnCount(); j++) {
	                        Cell cell = dataRow.createCell(j + 1); // Desplazar una columna a la derecha
	                        cell.setCellValue(String.valueOf(modeloTabla.getValueAt(i, j)));
	                        cell.setCellStyle(datosEstilo);

	                        // Ajustar automáticamente el ancho de las columnas
	                        sheet.autoSizeColumn(j + 1);
	                    }
	                }

	             // GUARDAR EL ARCHIVO EXCEL CON LA FECHA Y LA HORA EN EL NOMBRE
	                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm a");
	                String fechaHora = dateFormat.format(new Date());

	                // Construir el nombre del archivo con la fecha y la hora
	                String nombreArchivo = "datos_" + fechaHora + ".xlsx";

	                // Obtener la ruta del escritorio y la carpeta "Salidas"
	                String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
	                String folderPath = desktopPath + File.separator + "Salidas";

	                // Crear la carpeta "Salidas" si no existe
	                File folder = new File(folderPath);
	                if (!folder.exists()) {
	                    folder.mkdir();
	                }

	                // Crear el archivo Excel en la carpeta "Salidas" con el nombre personalizado
	                File excelFile = new File(folderPath, nombreArchivo);

	                try (FileOutputStream fileOut = new FileOutputStream(excelFile)) {
	                    book.write(fileOut);
	                    JOptionPane.showMessageDialog(null, "Archivo Excel creado con éxito: " + nombreArchivo);

	                    // ABRIR EL ARCHIVO CON LA APLICACIÓN PREDETERMINADA
	                    Desktop.getDesktop().open(excelFile);
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(null, "Error al guardar o abrir el archivo Excel.");
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al crear el archivo Excel.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "La tabla no contiene datos.");
	        }
	    }
}