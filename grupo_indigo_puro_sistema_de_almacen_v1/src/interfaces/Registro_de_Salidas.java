package interfaces;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import base_de_datos.Inventario;
import base_de_datos.Inventario_DAO;

public class Registro_de_Salidas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txt_codigo_rollo;
	private JTextField txt_nombre;
	public static JTextField txt_metros_solicitados;

    int item;
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();

	Inventario in = new Inventario();
	Inventario_DAO indao = new Inventario_DAO();
	public static JTable tbl_salidas;
	private JTextField txt_metros;
	public static JTextField txt_ancho;
	private JTextField txt_caracteristicas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1165, 693);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEntradas = new JLabel("SALIDAS");
		lblEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntradas.setFont(new Font("Arial", Font.BOLD, 20));
		lblEntradas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblEntradas.setBounds(10, 11, 1125, 43);
		contentPane.add(lblEntradas);

		JLabel lblNewLabel_1 = new JLabel("CODIGO ROLLO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1.setBounds(10, 65, 214, 43);
		contentPane.add(lblNewLabel_1);

		txt_codigo_rollo = new JTextField();
		txt_codigo_rollo.addKeyListener(new KeyAdapter() {
			@Override

			public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			        String codigo = txt_codigo_rollo.getText();

			        if (!"".equals(txt_codigo_rollo.getText())) {

			            // VERIFICAR SI EL CODIGO YA ESTA EN LA TABLA
			            if (!codigoYaEnTabla(codigo)) {
			                // BUSCAR EL ROLLO EN LA BASE DE DATOS
			                in = indao.Buscar_Rollo(codigo);

			                if (in.getNombre_Tela() != null) {
			                    // MOSTRAR DATOS ENCONTRADOS EN LOS CAMPOS CORRESPONDIENTES
			                    txt_metros.setText("" + in.getMetros());
			                    txt_nombre.setText("" + in.getNombre_Tela());
			                    //txt_ancho.setText("" + in.getAncho());
			                    txt_caracteristicas.setText("" + in.getCaracteristicas());

			                    // Verificar si los metros son 0
			                    if (in.getMetros() == 0) {
			                        // Limpiar campos
			                    	limpiar_campos();
			                        // Mostrar alerta
			                        JOptionPane.showMessageDialog(null, "El código de rollo no cuenta con metros disponibles");
			                    } else {
			                        //txt_metros_solicitados.setEditable(true);
			                        //txt_metros_solicitados.requestFocus();
			                    	txt_ancho.setEditable(true);
			                    	txt_ancho.requestFocus();
			                    }
			                } else {
			                    // LIMPIAR CAMPOS SI NO SE ENCUENTRA EL ROLLO
			                	limpiar_campos();
			                    txt_codigo_rollo.requestFocusInWindow();
			                    txt_metros_solicitados.setEditable(false);
			                    txt_ancho.setEditable(false);
			                }
			            } else {
			                // MOSTRAR MENSAJE SI EL CÓDIGO YA ESTÁ EN LA TABLA
			                JOptionPane.showMessageDialog(null, "EL CÓDIGO YA ESTÁ EN LA TABLA");
			                limpiar_campos();
			                txt_codigo_rollo.requestFocusInWindow();
			                txt_metros_solicitados.setEditable(false);
			                txt_ancho.setEditable(false);
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "INGRESE EL CODIGO DEL ROLLO");
			            txt_codigo_rollo.requestFocusInWindow();
			            txt_metros_solicitados.setEditable(false);
			            txt_ancho.setEditable(false);
			        }
			    }
			}

			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

			    if (!((c >= '0' && c <= '9'))) {
			        e.consume();
			    }

			}
		});
		txt_codigo_rollo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_codigo_rollo.setFont(new Font("Arial", Font.BOLD, 13));
		txt_codigo_rollo.setColumns(10);
		txt_codigo_rollo.setBounds(234, 65, 174, 43);
		contentPane.add(txt_codigo_rollo);

		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_1.setBounds(418, 65, 154, 43);
		contentPane.add(lblNewLabel_1_1);

		txt_nombre = new JTextField();
		txt_nombre.setEditable(false);
		txt_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		txt_nombre.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_nombre.setFont(new Font("Arial", Font.BOLD, 13));
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(582, 65, 159, 43);
		contentPane.add(txt_nombre);

		JButton btn_menu_principal = new JButton("MENU PRINCIPAL");
		btn_menu_principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 15));
		btn_menu_principal.setBounds(10, 583, 163, 60);

		btn_menu_principal.addActionListener(new ActionListener() {
			@Override
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

		JLabel lblNewLabel_1_2_1 = new JLabel("METROS SOLICITADOS");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2_1.setBounds(10, 119, 214, 43);
		contentPane.add(lblNewLabel_1_2_1);

		txt_metros_solicitados = new JTextField();
		txt_metros_solicitados.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			        if (!"".equals(txt_metros_solicitados.getText())) {
			        	double cantidad = Double.parseDouble(txt_metros_solicitados.getText());
			            //int cantidad = Integer.parseInt(txt_metros_solicitados.getText());

			            // Verificar si la cantidad es mayor que 0
			            if (cantidad > 0) {
			                // Resto del código
			                String codigo = txt_codigo_rollo.getText();
			                String nombre = txt_nombre.getText();
			                Double.parseDouble(txt_metros.getText());
			                double metros = Double.parseDouble(txt_metros_solicitados.getText());
			                //String metros = txt_metros_solicitados.getText();
			                String ancho = txt_ancho.getText();
			                String caracteristicas = txt_caracteristicas.getText();

			                double piezas = Double.parseDouble(txt_metros.getText());

			                if (piezas >= cantidad) {
			                    // Resto del código
			                    item = item + 1;
			                    DefaultTableModel modelo = (DefaultTableModel) tbl_salidas.getModel();

			                    ArrayList<Object> lista = new ArrayList<>();

			                    lista.add(item);
			                    lista.add(codigo);
			                    lista.add(nombre);
			                    lista.add(metros);
			                    lista.add(ancho);
			                    lista.add(caracteristicas);

			                    Object[] O = new Object[5];
			                    O[0] = lista.get(1);
			                    O[1] = lista.get(2);
			                    O[2] = lista.get(3);
			                    O[3] = lista.get(4);
			                    O[4] = lista.get(5);
			                    modelo.addRow(O);
			                    tbl_salidas.setModel(modelo);
			                    limpiar_campos();
			                    txt_metros_solicitados.setText("");
			                    txt_codigo_rollo.requestFocus();
			                    txt_metros_solicitados.setEditable(false);
			                    txt_ancho.setEditable(false);
			                } else {
			                    JOptionPane.showMessageDialog(null, "CANTIDAD DE METROS NO DISPONIBLES");
			                    txt_metros_solicitados.setText("");  // Limpiar campo metros_solicitados
			                    txt_metros_solicitados.requestFocus();  // Devolver foco al campo metros_solicitados
			                }
			            } else {
			                JOptionPane.showMessageDialog(null, "INGRESE UNA CANTIDAD VÁLIDA");
			                txt_metros_solicitados.setText("");  // Limpiar campo metros_solicitados
			                txt_metros_solicitados.requestFocus();  // Devolver foco al campo metros_solicitados
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "INGRESE CANTIDAD");
			            txt_metros_solicitados.requestFocus();
			        }
			    }
			}

			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				// VERIFICAR SI EL CARÁCTER ES UN NÚMERO O UN PUNTO
				if ((c >= '0' && c <= '9') || c == '.') {
					// VERIFICAR SI EL PUNTO YA ESTÁ PRESENTE EN EL TEXTO
				    if (c == '.' && txt_metros_solicitados.getText().contains(".")) {
				        e.consume(); // CONSUMIR EL EVENTO SI YA HAY UN PUNTO
				    }
				} else {
				    e.consume(); // CONSUMIR EL EVENTO SI NO ES UN NÚMERO O UN PUNTO
				}

			}
		});
		txt_metros_solicitados.setFont(new Font("Arial", Font.BOLD, 13));
		txt_metros_solicitados.setColumns(10);
		txt_metros_solicitados.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_metros_solicitados.setBounds(234, 119, 174, 43);
		contentPane.add(txt_metros_solicitados);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPane.setBounds(10, 173, 1125, 399);
		contentPane.add(scrollPane);

		tbl_salidas = new JTable();
		tbl_salidas.setRowMargin(2);
		tbl_salidas.setRowHeight(25);
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
				"<html><center>CODIGO ROLLO</html></center>", "<html><center>NOMBRE TELA</html></center>", "<html><center>METROS</html></center><html><center>ID</html></center>", "<html><center>ANCHO</html></center><html><center>ANCHO</html></center>", "<html><center>COMPOSICION</html></center><html><center></html></center>"
			}
		));
		tbl_salidas.getColumnModel().getColumn(0).setResizable(false);
		tbl_salidas.getColumnModel().getColumn(0).setPreferredWidth(20);
		tbl_salidas.getColumnModel().getColumn(1).setResizable(false);
		tbl_salidas.getColumnModel().getColumn(1).setPreferredWidth(60);
		tbl_salidas.getColumnModel().getColumn(2).setResizable(false);
		tbl_salidas.getColumnModel().getColumn(2).setPreferredWidth(60);
		tbl_salidas.getColumnModel().getColumn(3).setResizable(false);
		tbl_salidas.getColumnModel().getColumn(3).setPreferredWidth(60);
		tbl_salidas.getColumnModel().getColumn(4).setResizable(false);
		tbl_salidas.getColumnModel().getColumn(4).setPreferredWidth(90);

		//CENTRAR LOS DATOS DE LA TABLA
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tbl_salidas.getColumnCount(); i++) {
		     tbl_salidas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		scrollPane.setViewportView(tbl_salidas);

		JButton btn_excel_1 = new JButton("");
		btn_excel_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// LLAMANDO EL METODO QUE SE ENCARGA DE GENERAR EL PDF
			    requestFocus();

			    try {
			    	// INTENTAR GENERAR EL EXCEL
			        diseño_pdf_excel.Excel.generarExcelDesdeTabla(null);

			        // SI SE LLEGA AQUÍ, LA GENERACIÓN DEL EXCEL FUE EXITOSA
			        // PROCEDER CON LAS ACCIONES SIGUIENTES
			        actualizar_metros();
			        limpiar_tabla();
			    } catch (Exception ex) {
			    	// SI HAY UNA EXCEPCIÓN, MUESTRA UN MENSAJE DE ERROR
			        JOptionPane.showMessageDialog(null, "Error al generar el archivo Excel: " + ex.getMessage());
			    }
			}
		});
		btn_excel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_excel_1.setIcon(new ImageIcon(Registro_de_Salidas.class.getResource("/imagenes/excel.png")));
		btn_excel_1.setFont(new Font("Arial", Font.BOLD, 12));
		btn_excel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_excel_1.setBounds(1020, 582, 115, 61);
		contentPane.add(btn_excel_1);

		JButton btnQuitarRollo = new JButton("QUITAR ROLLO");
		btnQuitarRollo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuitarRollo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Eliminar_Fila();
				requestFocus();
			}
		});
		btnQuitarRollo.setFont(new Font("Arial", Font.BOLD, 15));
		btnQuitarRollo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnQuitarRollo.setBounds(192, 583, 163, 60);
		contentPane.add(btnQuitarRollo);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("METROS");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2_1_1.setBounds(751, 65, 160, 43);
		contentPane.add(lblNewLabel_1_2_1_1);

		txt_metros = new JTextField();
		txt_metros.setEditable(false);
		txt_metros.setHorizontalAlignment(SwingConstants.CENTER);
		txt_metros.setFont(new Font("Arial", Font.BOLD, 13));
		txt_metros.setColumns(10);
		txt_metros.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_metros.setBounds(751, 119, 160, 43);
		contentPane.add(txt_metros);

		JLabel lblNewLabel_1_2_1_2 = new JLabel("ANCHO");
		lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_2_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2_1_2.setBounds(418, 119, 154, 43);
		contentPane.add(lblNewLabel_1_2_1_2);

		txt_ancho = new JTextField();
		txt_ancho.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				    if (!"".equals(txt_ancho.getText())) {
				        double ancho = Double.parseDouble(txt_ancho.getText());
				        if (ancho <= 0) {
				           
				            txt_ancho.setText("");
				            
				            txt_ancho.requestFocus();
				        } else {
				            
				            txt_metros_solicitados.setEditable(true);
				            txt_metros_solicitados.requestFocus();
				            txt_ancho.setEditable(false);
				        }
				    }
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				
				if (!Character.isDigit(e.getKeyChar())) {
                   
					 char c = e.getKeyChar();

					    // Permite dígitos y un único punto decimal
					    if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE) {
					        e.consume();
					    }

					    // Si ya hay un punto decimal, evita agregar otro
					    if (c == '.' && txt_ancho.getText().contains(".")) {
					        e.consume();
					    }
                }
				
			}
		});
		txt_ancho.setHorizontalAlignment(SwingConstants.CENTER);
		txt_ancho.setFont(new Font("Arial", Font.BOLD, 13));
		txt_ancho.setColumns(10);
		txt_ancho.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_ancho.setBounds(582, 119, 159, 43);
		contentPane.add(txt_ancho);

		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("GENERAR SALIDAD");
		lblNewLabel_1_2_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_2_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2_1_2_1.setBounds(817, 583, 193, 60);
		contentPane.add(lblNewLabel_1_2_1_2_1);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("COMPOSICION");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_2_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2_1_1_1.setBounds(921, 65, 214, 43);
		contentPane.add(lblNewLabel_1_2_1_1_1);

		txt_caracteristicas = new JTextField();
		txt_caracteristicas.setEditable(false);
		txt_caracteristicas.setHorizontalAlignment(SwingConstants.CENTER);
		txt_caracteristicas.setFont(new Font("Arial", Font.BOLD, 13));
		txt_caracteristicas.setColumns(10);
		txt_caracteristicas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_caracteristicas.setBounds(921, 119, 214, 43);
		contentPane.add(txt_caracteristicas);
	}


	private void limpiar_campos() {
			txt_codigo_rollo.setText("");
			txt_nombre.setText("");
			txt_metros_solicitados.setText("");
			txt_metros.setText("");
			txt_ancho.setText("");
			txt_caracteristicas.setText("");
		}




		private void Eliminar_Fila() {
			    // Obtener la fila seleccionada
			    int filaSeleccionada = tbl_salidas.getSelectedRow();

			    // Verificar si hay una fila seleccionada
			    if (filaSeleccionada != -1) {
			        // Obtener el modelo de la tabla
			        DefaultTableModel modelo = (DefaultTableModel) tbl_salidas.getModel();

			        // Verificar si el índice de fila seleccionada es válido
			        if (filaSeleccionada < modelo.getRowCount()) {
			            // Eliminar la fila seleccionada del modelo de la tabla
			            modelo.removeRow(filaSeleccionada);

			            // Enfocar la aplicación después de eliminar la fila
			            requestFocus();
			        } else {
			            JOptionPane.showMessageDialog(this, "El índice de fila seleccionada no es válido.");
			            requestFocus();
			        }
			    } else {
			        JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila antes de eliminar.");
			        requestFocus();
			    }
		}


	   public void actualizar_metros(){

		   for (int i = 0; i < tbl_salidas.getRowCount(); i++) {
		   String cod = tbl_salidas.getValueAt(i, 0).toString();
		   double can = Double.parseDouble(tbl_salidas.getValueAt(i, 2).toString());
		   //int can = Integer.parseInt(tbl_salidas.getValueAt(i, 2).toString());
		   in = indao.Buscar_Rollo(cod);

		   Double metros = in.getMetros() - can;
		   indao.Actualizar_Metros(metros, cod);

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
		    DefaultTableModel modelo = (DefaultTableModel) tbl_salidas.getModel();
		    for (int i = 0; i < modelo.getRowCount(); i++) {
		        if (modelo.getValueAt(i, 0).toString().equals(codigo)) {
		            return true;
		        }
		    }
		    return false;
		}

	}

