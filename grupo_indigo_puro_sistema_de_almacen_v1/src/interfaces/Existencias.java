package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import base_de_datos.Inventario;
import base_de_datos.Inventario_DAO;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class Existencias extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tbl_existencias;
	private JTextField txt_nombre_tela;
	
	DefaultTableModel tmp = new DefaultTableModel();
	
	Inventario in = new Inventario();
	Inventario_DAO indao = new Inventario_DAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Existencias frame = new Existencias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Existencias() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Existencias.class.getResource("/imagenes/producto.png")));
		setTitle("ROLLOS EN EXISTENCIA");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1292, 692);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_menu_principal = new JButton("MENU PRINCIPAL");
		btn_menu_principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Principal mp = new Menu_Principal();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				mp.requestFocus();
				mp.actualizarFecha();
				mp.iniciarHiloActualizacionHora();
				dispose();
			}
		});
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 15));
		btn_menu_principal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal.setBounds(1065, 584, 201, 58);
		contentPane.add(btn_menu_principal);
		
		JLabel lblNewLabel = new JLabel("ROLLOS EN EXISTENCIA");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 1256, 43);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 2, true));
		scrollPane.setBounds(10, 119, 1256, 454);
		contentPane.add(scrollPane);
		
		tbl_existencias = new JTable();
		tbl_existencias.setRowHeight(25);
		tbl_existencias.setFont(new Font("Arial", Font.BOLD, 12));
		tbl_existencias.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><center>NOMBRE TELA</html></center>", "<html><center>CODIGO ROLLO</html></center>", "<html><center>PROVEEDOR</html></center>", "<html><center>PESO</html></center>", "<html><center>METROS</html></center>", "<html><center>ANCHO</html></center>", "<html><center>COMPOSICION</html></center>", "<html><center>CLASIFICACION</html></center>", "<html><center>UBICACION</html></center>", "<html><center>FECHA</html></center>"
			}
		));
		tbl_existencias.getColumnModel().getColumn(1).setPreferredWidth(72);
		tbl_existencias.getColumnModel().getColumn(2).setPreferredWidth(93);
		tbl_existencias.getColumnModel().getColumn(3).setPreferredWidth(88);
		tbl_existencias.getColumnModel().getColumn(4).setPreferredWidth(81);
		tbl_existencias.getColumnModel().getColumn(5).setPreferredWidth(83);
		tbl_existencias.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//CENTRAR LOS DATOS DE LA TABLA
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tbl_existencias.getColumnCount(); i++) {
        	tbl_existencias.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
		
		scrollPane.setViewportView(tbl_existencias);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE DE TELA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1.setBounds(166, 65, 166, 43);
		contentPane.add(lblNewLabel_1);
		
		txt_nombre_tela = new JTextField();
		txt_nombre_tela.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(txt_nombre_tela.getText().length() >= 25)
			    {
			        e.consume();
			    }
				
			}
		});
		txt_nombre_tela.setFont(new Font("Arial", Font.BOLD, 13));
		txt_nombre_tela.setColumns(10);
		txt_nombre_tela.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_nombre_tela.setBounds(342, 65, 259, 43);
		contentPane.add(txt_nombre_tela);
		
		JButton btn_menu_principal_1 = new JButton("BUSCAR");
		btn_menu_principal_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
										
				if (!"".equals(txt_nombre_tela.getText())) {
			        String nombre = txt_nombre_tela.getText();
			        
			        List<Inventario> inventarios = indao.Buscar_Rollo_Nombre(nombre);

			        DefaultTableModel model = (DefaultTableModel) tbl_existencias.getModel();
			        model.setRowCount(0);

			        if (!inventarios.isEmpty()) {
			            for (Inventario inventario : inventarios) {
			                Object[] fila = {
			                    inventario.getNombre_Tela(),
			                    inventario.getCodigo_Rollo(),
			                    inventario.getProveedor(),
			                    inventario.getPeso_total(),
			                    inventario.getMetros(),
			                    inventario.getAncho(),
			                    inventario.getCaracteristicas(),
			                    inventario.getEstilo(),
			                    inventario.getUbicacion(),
			                    inventario.getFecha_Entrada()
			                };
			                model.addRow(fila);
			                requestFocus();
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "NO SE ENCONTRARON ROLLOS EN EL INVENTARIO CON ESE NOMBRE.");
			            txt_nombre_tela.setText("");
			            requestFocus();
			        }
			    } else {
			        JOptionPane.showMessageDialog(null, "INGRESE EL NOMBRE DE LA TELA");
			        requestFocus();
			    }
			}		
		});
		btn_menu_principal_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal_1.setFont(new Font("Arial", Font.BOLD, 15));
		btn_menu_principal_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal_1.setBounds(10, 65, 146, 43);
		contentPane.add(btn_menu_principal_1);
		
		JButton btn_menu_principal_2 = new JButton("");
		btn_menu_principal_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// LLAMANDO EL METODO QUE SE ENCARGA DE GENERAR EL PDF
			    requestFocus();

			    try {
			    	// INTENTAR GENERAR EL EXCEL
			    	diseño_pdf_excel.Excel.generar_existencias(null);
			        limpiar_tabla();
			        txt_nombre_tela.setText("");
			    } catch (Exception ex) {
			    	// SI HAY UNA EXCEPCIÓN, MUESTRA UN MENSAJE DE ERROR
			        JOptionPane.showMessageDialog(null, "Error al generar el archivo Excel: " + ex.getMessage());
			    }
				
			}
		});
		btn_menu_principal_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal_2.setIcon(new ImageIcon(Existencias.class.getResource("/imagenes/excel.png")));
		btn_menu_principal_2.setFont(new Font("Arial", Font.BOLD, 13));
		btn_menu_principal_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal_2.setBounds(955, 584, 100, 58);
		contentPane.add(btn_menu_principal_2);
		
		JButton btn_menu_principal_3 = new JButton("LIMPIAR TABLA");
		btn_menu_principal_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    if (tbl_existencias.getRowCount() == 0) {
			        JOptionPane.showMessageDialog(null, "La tabla no contiene información", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			        requestFocus();
			        return;
			    }

			    Object[] options = {"Sí", "No"};
			    int opcion = JOptionPane.showOptionDialog(null, "¿Desea realmente limpiar la tabla?", "Confirmar limpieza", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

			    if (opcion == JOptionPane.YES_OPTION) {
			        limpiar_tabla();
			        txt_nombre_tela.setText("");
			        requestFocus();
			    } else {
			        requestFocus();
			    }
				
			}
		});
		btn_menu_principal_3.setFont(new Font("Arial", Font.BOLD, 15));
		btn_menu_principal_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal_3.setBounds(10, 584, 201, 58);
		contentPane.add(btn_menu_principal_3);
	}
	
	 public void limpiar_tabla() {
		   tmp = (DefaultTableModel) tbl_existencias.getModel();
		   int fila = tbl_existencias.getRowCount();
		   for (int i = 0; i < fila; i++) {
			tmp.removeRow(0);
		}
	   }
}
