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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import conexion.Conexion;
import interfaces.Existencias;
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

              sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 12));

              String[] cabecera = new String[]{"ID", "CODIGO ROLLO", "NOMBRE TELA", "PROVEEDOR", "KILOS","METROS", "CLASIFICACION", "ANCHO", "COMPOSICION","UBICACION", "FECHA ENTRADA", "HORA ENTRADA"};

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
                  Cell celdaEncabezado = filaEncabezados.createCell(i+1);
                  celdaEncabezado.setCellStyle(headerStyle);
                  celdaEncabezado.setCellValue(cabecera[i]);
                  sheet.autoSizeColumn(i + 1);
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
                      Cell CeldaDatos = filaDatos.createCell(a+1);
                      CeldaDatos.setCellStyle(datosEstilo);
                      CeldaDatos.setCellValue(rs.getString(a + 1));
                      sheet.autoSizeColumn(a + 1);
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

              sheet.setZoom(150);

              // Obtener la fecha y hora actual
              LocalDateTime now = LocalDateTime.now();
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
              String fechaHoraActual = now.format(formatter);

              // Crear una carpeta en el escritorio
              String home = System.getProperty("user.home");
              File carpeta = new File(home + "/Desktop/INVENTARIO_GENERAL");

              if (!carpeta.exists()) {
                  carpeta.mkdirs(); // Crear la carpeta si no existe
              }

              // Construir la ruta completa del archivo dentro de la carpeta
              String fileName = "INVENTARIO" + "_" + fechaHoraActual;
              String filePath = carpeta.getAbsolutePath() + File.separator + fileName + ".xlsx";
              File file = new File(filePath);

              FileOutputStream fileOut = new FileOutputStream(file);
              book.write(fileOut);
              fileOut.close();

              Desktop.getDesktop().open(file);
              JOptionPane.showMessageDialog(null, "INVENTARIO GENERAL CREADO CORRECTAMENTE");

          } catch (FileNotFoundException ex) {
              Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException | SQLException ex) {
              Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
          }
      }


	 public static void generarExcelDesdeTabla(Registro_de_Salidas rs) {
	        DefaultTableModel modeloTabla = (DefaultTableModel) Registro_de_Salidas.tbl_salidas.getModel();

	        if (modeloTabla.getRowCount() > 0) {
	            try (Workbook book = new XSSFWorkbook()) {
	                Sheet sheet = book.createSheet("PACKING LIST");

	                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    	        Date date = new Date();
	    	        String fechaActual = dateFormat.format(date);

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
	                sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 7));

	                String[] cabecera = new String[]{"SECUENCIA POR ROLLO","CODIGO DE ROLLO", "NOMBRE", "METROS", "ANCHO", "COMPOSICION"};

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

	                // Agregar la columna adicional "FECHA DE SALIDA" en la fila de encabezados
	                Cell celdaEncabezadoFecha = filaEncabezados.createCell(cabecera.length + 1);
	                celdaEncabezadoFecha.setCellStyle(headerStyle);
	                celdaEncabezadoFecha.setCellValue("FECHA DE SALIDA");

	                // Ajustar automáticamente el ancho de la columna "FECHA DE SALIDA"
	                sheet.autoSizeColumn(cabecera.length + 1);

	                for (int i = 0; i < cabecera.length; i++) {
	                    Cell celdaEncabezado = filaEncabezados.createCell(i + 1);
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

	                int indiceSecuencia = 1;

	                for (int i = 0; i < modeloTabla.getRowCount(); i++) {
	                    Row dataRow = sheet.createRow(i + 5);

	                 // Añadir la secuencia en la columna "SECUENCIA POR ROLLO"
	                    Cell cellSecuencia = dataRow.createCell(1);
	                    cellSecuencia.setCellValue(indiceSecuencia++);
	                    cellSecuencia.setCellStyle(datosEstilo);

	                    for (int j = 0; j < modeloTabla.getColumnCount(); j++) {
	                        Cell cell = dataRow.createCell(j + 2); // Desplazar una columna a la derecha
	                        cell.setCellValue(String.valueOf(modeloTabla.getValueAt(i, j)));
	                        cell.setCellStyle(datosEstilo);

	                        // Ajustar automáticamente el ancho de las columnas
	                        sheet.autoSizeColumn(j + 1);
	                    }

	                 // Agregar la fecha actual en la columna "FECHA DE SALIDA"
	                    Cell cellFecha = dataRow.createCell(cabecera.length + 1);
	                    cellFecha.setCellValue(fechaActual);
	                    cellFecha.setCellStyle(datosEstilo);

	                    // Ajustar automáticamente el ancho de la columna "FECHA DE SALIDA"
	                    sheet.autoSizeColumn(cabecera.length + 1);

	                }

	                // Ajustar automáticamente el ancho de las columnas después de agregar las filas y celdas de datos
	                for (int i = 0; i < cabecera.length + 2; i++) {
	                    sheet.autoSizeColumn(i);
	                }


	                double sumatoriaMetros = 0.0;

		            // Calcular la sumatoria de metros
		            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
		                 double metros = Double.parseDouble(modeloTabla.getValueAt(i, 2).toString());
		                 sumatoriaMetros += metros;
		            }

		            // Después de agregar los datos

			         // Crear una fila para la sumatoria
			         Row filaSumatoria = sheet.createRow(modeloTabla.getRowCount() + 5);

			         // Crear celda para etiqueta
			         Cell celdaEtiquetaSumatoria = filaSumatoria.createCell(1);
			         celdaEtiquetaSumatoria.setCellValue("SUMATORIA DE METROS");

			         // Crear celda para el valor de la sumatoria
			         Cell celdaSumatoria = filaSumatoria.createCell(4); // Columna de metros
			         celdaSumatoria.setCellValue(sumatoriaMetros);

			         // Estilo para la sumatoria
			         CellStyle sumatoriaEstilo = book.createCellStyle();
			         sumatoriaEstilo.setBorderBottom(BorderStyle.THIN);
			         sumatoriaEstilo.setBorderLeft(BorderStyle.THIN);
			         sumatoriaEstilo.setBorderRight(BorderStyle.THIN);
			         sumatoriaEstilo.setBorderTop(BorderStyle.THIN);
			         sumatoriaEstilo.setAlignment(HorizontalAlignment.CENTER);
			         sumatoriaEstilo.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
			         sumatoriaEstilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			         sumatoriaEstilo.setFont(font);

			         // Aplicar el estilo a las celdas de la fila de sumatoria
			         celdaEtiquetaSumatoria.setCellStyle(sumatoriaEstilo);
			         celdaSumatoria.setCellStyle(sumatoriaEstilo);

			         // Ajustar automáticamente el ancho de las columnas después de agregar la fila de sumatoria
			         sheet.autoSizeColumn(1);
			         sheet.autoSizeColumn(4);

	                // GUARDAR EL ARCHIVO EXCEL CON LA FECHA Y LA HORA EN EL NOMBRE
	                SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd_HH-mm a");
	                String fechaHora = dateFormat1.format(new Date());

	                // Construir el nombre del archivo con la fecha y la hora
	                String nombreArchivo = "PACKING_LIST_" + fechaHora + ".xlsx";

	                // Obtener la ruta del escritorio y la carpeta "Salidas"
	                String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
	                String folderPath = desktopPath + File.separator + "SALIDAS";

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
	 
	 public static void generar_existencias(Existencias ex) {
		 
		 DefaultTableModel modeloTabla = (DefaultTableModel) Existencias.tbl_existencias.getModel();
		 
		 if (modeloTabla.getRowCount() > 0) {
	            try (Workbook book = new XSSFWorkbook()) {
	                Sheet sheet = book.createSheet("EXISTENCIA DE TELAS");

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
	                celdaTitulo.setCellValue("INVENTARIO DE EXISTENCIAS");

	                // Fusionar celdas para el título
	                sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 10));

	                String[] cabecera = new String[]{"NOMBRE TELA", "CODIGO DE ROLLO", "PROVEEDOR", "PESO", "METROS", "ANCHO", "COMPOSICION", "CLASIFICACION","UBICACION", "FECHA"};

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
	                    Cell celdaEncabezado = filaEncabezados.createCell(i + 1);
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
	                int rowIndex = 5; // Comienza después de la fila de encabezados

	                for (int i = 0; i < modeloTabla.getRowCount(); i++) {
	                    Row row = sheet.createRow(rowIndex++);

	                    for (int j = 0; j < modeloTabla.getColumnCount(); j++) {
	                        Cell cell = row.createCell(j + 1);
	                        cell.setCellValue(String.valueOf(modeloTabla.getValueAt(i, j)));
	                        cell.setCellStyle(datosEstilo);
	                    }
	                }
	                
	                for (int col = 1; col <= modeloTabla.getColumnCount(); col++) {
	                    sheet.autoSizeColumn(col);
	                }
	                
	                double sumatoriaMetros = 0.0;

		            // Calcular la sumatoria de metros
		            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
		                 double metros = Double.parseDouble(modeloTabla.getValueAt(i, 5).toString());
		                 sumatoriaMetros += metros;
		            }

		            // Después de agregar los datos

			         // Crear una fila para la sumatoria
			         Row filaSumatoria = sheet.createRow(modeloTabla.getRowCount() + 5);

			         // Crear celda para etiqueta
			         Cell celdaEtiquetaSumatoria = filaSumatoria.createCell(1);
			         celdaEtiquetaSumatoria.setCellValue("SUMATORIA DE METROS");

			         // Crear celda para el valor de la sumatoria
			         Cell celdaSumatoria = filaSumatoria.createCell(5); // Columna de metros
			         celdaSumatoria.setCellValue(sumatoriaMetros);

			         // Estilo para la sumatoria
			         CellStyle sumatoriaEstilo = book.createCellStyle();
			         sumatoriaEstilo.setBorderBottom(BorderStyle.THIN);
			         sumatoriaEstilo.setBorderLeft(BorderStyle.THIN);
			         sumatoriaEstilo.setBorderRight(BorderStyle.THIN);
			         sumatoriaEstilo.setBorderTop(BorderStyle.THIN);
			         sumatoriaEstilo.setAlignment(HorizontalAlignment.CENTER);
			         sumatoriaEstilo.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
			         sumatoriaEstilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			         sumatoriaEstilo.setFont(font);

			         // Aplicar el estilo a las celdas de la fila de sumatoria
			         celdaEtiquetaSumatoria.setCellStyle(sumatoriaEstilo);
			         celdaSumatoria.setCellStyle(sumatoriaEstilo);

			         // Ajustar automáticamente el ancho de las columnas después de agregar la fila de sumatoria
			         sheet.autoSizeColumn(1);
			         sheet.autoSizeColumn(4);
	                
	                
	                // GUARDAR EL ARCHIVO EXCEL CON LA FECHA Y LA HORA EN EL NOMBRE
	                SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd_HH-mm a");
	                String fechaHora = dateFormat1.format(new Date());

	                // Obtener el nombre de la tela desde el primer elemento de la tabla (suponiendo que la columna 0 contiene el nombre de la tela)
	                String nombre_Tela = String.valueOf(modeloTabla.getValueAt(0, 0));
	                
	                // Construir el nombre del archivo con la fecha y la hora
	                String nombreArchivo = nombre_Tela+"_"+ fechaHora + ".xlsx";

	                // Obtener la ruta del escritorio y la carpeta "Salidas"
	                String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
	                String folderPath = desktopPath + File.separator + "EXISTENCIAS";

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
	                } catch (IOException e) {
	                    e.printStackTrace();
	                    JOptionPane.showMessageDialog(null, "Error al guardar o abrir el archivo Excel.");
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al crear el archivo Excel.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "La tabla no contiene datos.");
	        }	 
	 }
	 
}