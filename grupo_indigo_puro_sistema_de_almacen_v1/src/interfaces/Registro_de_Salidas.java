package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import base_de_datos.Inventario;
import base_de_datos.Inventario_DAO;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Registro_de_Salidas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txt_codigo_rollo;
	private JTextField txt_nombre;
	public static JTextField txt_piezas;
	public static JTextField txt_metros;
	public static JTextField txt_cantidad;
	
    int item;
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();

	Inventario in = new Inventario();
	Inventario_DAO indao = new Inventario_DAO();
	public static JTable tbl_salidas;
	private JTextField txt_kilos;
	private JTextField txt_ancho;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro_de_Salidas frame = new Registro_de_Salidas();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registro_de_Salidas() {
		setResizable(false);
		setTitle("SALIDAS ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registro_de_Salidas.class.getResource("/imagenes/salidas.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1165, 686);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 227, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEntradas = new JLabel("SALIDAS");
		lblEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntradas.setFont(new Font("Arial", Font.BOLD, 16));
		lblEntradas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblEntradas.setBounds(10, 11, 1125, 43);
		contentPane.add(lblEntradas);
		
		JLabel lblNewLabel_1 = new JLabel("CODIGO ROLLO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1.setBounds(10, 65, 129, 43);
		contentPane.add(lblNewLabel_1);
		
		txt_codigo_rollo = new JTextField();
		txt_codigo_rollo.addKeyListener(new KeyAdapter() {
			@Override
			
			public void keyPressed(KeyEvent e) {
			    // BUSCAR AL PULSAR ENTER
			    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			        if (!"".equals(txt_codigo_rollo.getText())) {
			            String cod = txt_codigo_rollo.getText();

			            // VERIFICAR SI EL CODIGO YA ESTA EN LA TABLA
			            if (!codigoYaEnTabla(cod)) {
			                // BUSCAR EL ROLLO EN LA BASE DE DATOS
			                in = indao.Buscar_Rollo(cod);

			                if (in.getNombre_Tela() != null) {
			                    // MOSTRAR DATOS ENCONTRADOS EN LOS CAMPOS CORRESPONDIENTES
			                    txt_nombre.setText("" + in.getNombre_Tela());
			                    txt_piezas.setText("" + in.getPiezas());

			                    if (in.getPiezas() != 0) {
			                        txt_metros.setText("" + in.getMetros());
			                        txt_kilos.setText("" + in.getPeso_total());
			                        txt_ancho.setText("" + in.getAncho());

			                        txt_cantidad.setEnabled(true);
			                        txt_cantidad.requestFocusInWindow();
			                    } else {
			                        // Limpiar campos y bloquear el campo cantidad si las piezas son 0
			                        txt_metros.setText("");
			                        txt_kilos.setText("");
			                        txt_ancho.setText("");
			                        txt_nombre.setText("");
			                        txt_piezas.setText("");
			                        txt_cantidad.setEnabled(false);
			                        txt_codigo_rollo.setText("");
			                        txt_codigo_rollo.requestFocusInWindow();
			                        JOptionPane.showMessageDialog(null, "El número de piezas es 0, no se puede agregar.");
			                    }
			                } else {
			                    // LIMPIAR CAMPOS SI NO SE ENCUENTRA EL ROLLO
			                    txt_nombre.setText("");
			                    txt_piezas.setText("");
			                    txt_metros.setText("");
			                    txt_codigo_rollo.setText("");
			                    txt_kilos.setText("");
			                    txt_ancho.setText("");
			                    txt_cantidad.setEnabled(false);
			                    txt_codigo_rollo.requestFocusInWindow();
			                }
			            } else {
			                // MOSTRAR MENSAJE SI EL CÓDIGO YA ESTÁ EN LA TABLA
			                JOptionPane.showMessageDialog(null, "EL CÓDIGO YA ESTÁ EN LA TABLA");
			                txt_cantidad.setEnabled(false);
			                txt_codigo_rollo.setText("");
			                txt_codigo_rollo.requestFocusInWindow();
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "INGRESE EL CODIGO DEL ROLLO");
			            txt_codigo_rollo.requestFocusInWindow();
			        }
			    }
			}

			
//			public void keyPressed(KeyEvent e) {
//		        // BUSCAR AL PULSAR ENTER
//		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//		            if (!"".equals(txt_codigo_rollo.getText())) {
//		                String cod = txt_codigo_rollo.getText();
//
//		                // VERIFICAR SI EL CODIGO YA ESTA EN LA TABLA
//		                if (!codigoYaEnTabla(cod)) {
//		                    // BUSCAR EL ROLLO EN LA BASE DE DATOS
//		                    in = indao.Buscar_Rollo(cod);
//
//		                    if (in.getNombre_Tela() != null) {
//		                        // MOSTRAR DATOS ENCONTRADOS EN LOS CAMPOS CORRESPONDIENTES
//		                        txt_nombre.setText("" + in.getNombre_Tela());
//		                        txt_piezas.setText("" + in.getPiezas());
//		                        txt_metros.setText("" + in.getMetros());
//		                        txt_kilos.setText(""+in.getPeso_total());
//		                        txt_ancho.setText(""+in.getAncho());
//
//		                        txt_cantidad.setEnabled(true);
//		                        txt_cantidad.requestFocusInWindow();
//		                    } else {
//		                        // LIMPIAR CAMPOS SI NO SE ENCUENTRA EL ROLLO
//		                        txt_nombre.setText("");
//		                        txt_piezas.setText("");
//		                        txt_metros.setText("");
//		                        txt_codigo_rollo.setText("");
//		                        txt_kilos.setText("");
//		                        txt_ancho.setText(""+in.getAncho());
//		                        txt_cantidad.setEnabled(false);
//		                        txt_codigo_rollo.requestFocusInWindow();
//		                    }
//		                } else {
//		                    // MOSTRAR MENSAJE SI EL CÓDIGO YA ESTÁ EN LA TABLA
//		                    JOptionPane.showMessageDialog(null, "EL CÓDIGO YA ESTÁ EN LA TABLA");
//		                    txt_cantidad.setEnabled(false);
//		                    txt_codigo_rollo.setText("");
//		                    txt_codigo_rollo.requestFocusInWindow();
//		                }
//		            } else {
//		                JOptionPane.showMessageDialog(null, "INGRESE EL CODIGO DEL ROLLO");
//		                txt_codigo_rollo.requestFocusInWindow();
//		            }
//		        }
//		    }
			
		});
		txt_codigo_rollo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_codigo_rollo.setFont(new Font("Arial", Font.BOLD, 13));
		txt_codigo_rollo.setColumns(10);
		txt_codigo_rollo.setBounds(149, 65, 138, 43);
		contentPane.add(txt_codigo_rollo);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_1.setBounds(297, 65, 154, 43);
		contentPane.add(lblNewLabel_1_1);
		
		txt_nombre = new JTextField();
		txt_nombre.setEditable(false);
		txt_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		txt_nombre.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_nombre.setFont(new Font("Arial", Font.BOLD, 13));
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(461, 65, 182, 43);
		contentPane.add(txt_nombre);
		
		JLabel lblNewLabel_1_2 = new JLabel("PIEZAS");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2.setBounds(297, 119, 154, 43);
		contentPane.add(lblNewLabel_1_2);
		
		txt_piezas = new JTextField();
		txt_piezas.setEditable(false);
		txt_piezas.setHorizontalAlignment(SwingConstants.CENTER);
		txt_piezas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_piezas.setFont(new Font("Arial", Font.BOLD, 13));
		txt_piezas.setColumns(10);
		txt_piezas.setBounds(461, 119, 182, 43);
		contentPane.add(txt_piezas);
		
		JButton btn_menu_principal = new JButton("MENU PRINCIPAL");
		btn_menu_principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 12));
		btn_menu_principal.setBounds(10, 583, 163, 50);
		
		btn_menu_principal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Principal mp = new Menu_Principal();
				dispose();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				mp.requestFocus();
				mp.actualizarFecha();
				mp.iniciarHiloActualizacionHora();
			}
		});
		
		contentPane.add(btn_menu_principal);
		
		JButton btnLimpiarCampos = new JButton("LIMPIAR CAMPOS");
		btnLimpiarCampos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiarCampos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnLimpiarCampos.setFont(new Font("Arial", Font.BOLD, 12));
		btnLimpiarCampos.setBounds(241, 583, 163, 50);
		
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				limpiar_campos();
				requestFocus();
			}
		});
		
		contentPane.add(btnLimpiarCampos);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("METROS");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2_1.setBounds(653, 65, 154, 43);
		contentPane.add(lblNewLabel_1_2_1);
		
		txt_metros = new JTextField();
		txt_metros.setEditable(false);
		txt_metros.setHorizontalAlignment(SwingConstants.CENTER);
		txt_metros.setFont(new Font("Arial", Font.BOLD, 13));
		txt_metros.setColumns(10);
		txt_metros.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_metros.setBounds(653, 119, 154, 43);
		contentPane.add(txt_metros);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 2, true));
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPane.setBounds(10, 173, 1125, 399);
		contentPane.add(scrollPane);
		
		tbl_salidas = new JTable();
		tbl_salidas.setRowMargin(2);
		tbl_salidas.setRowHeight(20);
		tbl_salidas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
        DefaultTableCellRenderer centradoRenderer = new DefaultTableCellRenderer();
        centradoRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tbl_salidas.getColumnCount(); i++) {
            tbl_salidas.getColumnModel().getColumn(i).setCellRenderer(centradoRenderer);
        }
		tbl_salidas.setFont(new Font("Arial", Font.BOLD, 12));
		tbl_salidas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tbl_salidas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tbl_salidas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><center>CODIGO ROLLO</html></center>", "<html><center>NOMBRE TELA</html></center>", "<html><center>CANTIDAD</html></center>", "<html><center>METROS</html></center><html><center>ID</html></center>", "<html><center>ANCHO</html></center><html><center>ANCHO</html></center>", "<html><center>KILOS</html></center><html><center>CARACTERISTICAS</html></center>"
			}
		));
		
		//CENTRAR LOS DATOS DE LA TABLA
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		        for (int i = 0; i < tbl_salidas.getColumnCount(); i++) {
		        	tbl_salidas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		        }
		
		scrollPane.setViewportView(tbl_salidas);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("CANTIDAD");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2_2.setBounds(10, 119, 129, 43);
		contentPane.add(lblNewLabel_1_2_2);
		
		txt_cantidad = new JTextField();
		txt_cantidad.addKeyListener(new KeyAdapter() {
			@Override
			
			public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			        if (!"".equals(txt_cantidad.getText())) {
			            int cantidad = Integer.parseInt(txt_cantidad.getText());

			            // Verificar si la cantidad es mayor que 0
			            if (cantidad > 0) {
			                // Resto del código
			                String codigo = txt_codigo_rollo.getText();
			                String nombre = txt_nombre.getText();
			                String metros = txt_metros.getText();
			                String ancho = txt_ancho.getText();
			                String kilos = txt_kilos.getText();

			                int piezas = Integer.parseInt(txt_piezas.getText());

			                if (piezas >= cantidad) {
			                    // Resto del código
			                    item = item + 1;
			                    modelo = (DefaultTableModel) tbl_salidas.getModel();

			                    ArrayList lista = new ArrayList();

			                    lista.add(item);

			                    lista.add(codigo);
			                    lista.add(nombre);
			                    lista.add(cantidad);
			                    lista.add(metros);
			                    lista.add(ancho);
			                    lista.add(kilos);

			                    Object[] O = new Object[6];
			                    O[0] = lista.get(1);
			                    O[1] = lista.get(2);
			                    O[2] = lista.get(3);
			                    O[3] = lista.get(4);
			                    O[4] = lista.get(5);
			                    O[5] = lista.get(6);
			                    modelo.addRow(O);
			                    tbl_salidas.setModel(modelo);
			                    limpiar_campos();
			                    txt_cantidad.setText("");
			                    txt_cantidad.setEnabled(false);
			                    txt_codigo_rollo.requestFocus();
			                } else {
			                    JOptionPane.showMessageDialog(null, "CANTIDAD DE PIEZAS NO DISPONIBLES");
			                    txt_cantidad.setText("");  // Limpiar campo cantidad
			                    txt_cantidad.requestFocus();  // Devolver foco al campo cantidad
			                }
			            } else {
			                JOptionPane.showMessageDialog(null, "INGRESE UNA CANTIDAD VÁLIDA");
			                txt_cantidad.setText("");  // Limpiar campo cantidad
			                txt_cantidad.requestFocus();  // Devolver foco al campo cantidad
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "INGRESE CANTIDAD");
			            txt_cantidad.requestFocus();
			        }
			    }
			}
		});
		txt_cantidad.setFont(new Font("Arial", Font.BOLD, 13));
		txt_cantidad.setColumns(10);
		txt_cantidad.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_cantidad.setBounds(149, 119, 138, 43);
		contentPane.add(txt_cantidad);
		
		JButton btn_excel = new JButton("");
		btn_excel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		    // LLAMANDO EL REPORTE DE EXCEL
		    requestFocus();
				
			}
		});
		btn_excel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_excel.setIcon(new ImageIcon(Registro_de_Salidas.class.getResource("/imagenes/excel.png")));
		btn_excel.setFont(new Font("Arial", Font.BOLD, 12));
		btn_excel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_excel.setBounds(839, 583, 107, 53);
		contentPane.add(btn_excel);
		
		JButton btn_excel_1 = new JButton("");
		btn_excel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//LLAMANDO EL METODO QUE SE ENCARGA DE GENERAR EL PDF
			requestFocus();
			actualizar_piezas();
			diseño_pdf_excel.Excel.generarExcelDesdeTabla(null);
			limpiar_tabla();
				
			}
		});
		btn_excel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_excel_1.setIcon(new ImageIcon(Registro_de_Salidas.class.getResource("/imagenes/pdf.png")));
		btn_excel_1.setFont(new Font("Arial", Font.BOLD, 12));
		btn_excel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_excel_1.setBounds(1028, 583, 107, 53);
		contentPane.add(btn_excel_1);
		
		JButton btnQuitarRollo = new JButton("QUITAR ROLLO");
		btnQuitarRollo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuitarRollo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Eliminar_Fila();
				requestFocus();
			}
		});
		btnQuitarRollo.setFont(new Font("Arial", Font.BOLD, 12));
		btnQuitarRollo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnQuitarRollo.setBounds(469, 583, 163, 50);
		contentPane.add(btnQuitarRollo);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("KILOS");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2_1_1.setBounds(981, 65, 154, 43);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		txt_kilos = new JTextField();
		txt_kilos.setHorizontalAlignment(SwingConstants.CENTER);
		txt_kilos.setFont(new Font("Arial", Font.BOLD, 13));
		txt_kilos.setEditable(false);
		txt_kilos.setColumns(10);
		txt_kilos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_kilos.setBounds(981, 119, 154, 43);
		contentPane.add(txt_kilos);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("ANCHO");
		lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2_1_2.setBounds(817, 65, 154, 43);
		contentPane.add(lblNewLabel_1_2_1_2);
		
		txt_ancho = new JTextField();
		txt_ancho.setHorizontalAlignment(SwingConstants.CENTER);
		txt_ancho.setFont(new Font("Arial", Font.BOLD, 13));
		txt_ancho.setEditable(false);
		txt_ancho.setColumns(10);
		txt_ancho.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_ancho.setBounds(817, 119, 154, 43);
		contentPane.add(txt_ancho);
	}
	    

	private void limpiar_campos() {
			txt_codigo_rollo.setText("");
			txt_nombre.setText("");
			txt_piezas.setText("");
			txt_metros.setText("");
			txt_kilos.setText("");
			txt_ancho.setText("");
		}
	
	
		
		
		private void Eliminar_Fila() {
		    int filaSeleccionada = tbl_salidas.getSelectedRow();

		    if (filaSeleccionada != -1) {
		        ((DefaultTableModel) modelo).removeRow(filaSeleccionada);
		        requestFocus();
		    } else {
		        JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila antes de eliminar.");
		        requestFocus();
		    }
		}
		
		
	   public void actualizar_piezas(){
		   
		   for (int i = 0; i < tbl_salidas.getRowCount(); i++) {
		   String cod = tbl_salidas.getValueAt(i, 0).toString();
		   int can = Integer.parseInt(tbl_salidas.getValueAt(i, 2).toString());
		   in = indao.Buscar_Rollo(cod);
		   
		   int stock_actual = in.getPiezas() - can;
		   indao.Actualizar_Stock(stock_actual, cod);
		   
		}
		   
	   }
	   
	   
	   public void limpiar_tabla() {
		   tmp = (DefaultTableModel) tbl_salidas.getModel();
		   int fila = tbl_salidas.getRowCount();
		   for (int i = 0; i < fila; i++) {
			tmp.removeRow(0);
		}
	   }
	   
	   
	   
	   private boolean codigoYaEnTabla(String codigo) {
		   
	        for (int i = 0; i < modelo.getRowCount(); i++) {
	            if (modelo.getValueAt(i, 0).equals(codigo)) {
	                return true;
	            }
	        }
	        return false;
	    }
	   
	   
	   
	   
	}

