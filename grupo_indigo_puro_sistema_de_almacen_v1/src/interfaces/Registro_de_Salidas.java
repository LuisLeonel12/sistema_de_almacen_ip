package interfaces;

import java.awt.Color;
import diseño_pdf_excel.Excel;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.Image;

import base_de_datos.Inventario;
import base_de_datos.Inventario_DAO;
import base_de_datos.Salidas;
import base_de_datos.Salidas_DAO;

import java.awt.Font;
import java.awt.JobAttributes;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Registro_de_Salidas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_codigo_rollo;
	private JTextField txt_nombre;
	private JTextField txt_piezas;
	private JLabel lbl_fecha;
	private JTextField txt_metros;
    int item;
    DefaultTableModel modelo = new DefaultTableModel();

	Inventario in = new Inventario();
	Inventario_DAO indao = new Inventario_DAO();
	private JTable tbl_salidas;
	private JTextField txt_cantidad;
	
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
		setBounds(100, 100, 1284, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEntradas = new JLabel("SALIDAS");
		lblEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntradas.setFont(new Font("Arial", Font.BOLD, 16));
		lblEntradas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblEntradas.setBounds(10, 11, 1247, 43);
		contentPane.add(lblEntradas);
		
		JLabel lblNewLabel_1 = new JLabel("CODIGO ROLLO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1.setBounds(115, 65, 182, 43);
		contentPane.add(lblNewLabel_1);
		
		txt_codigo_rollo = new JTextField();
		txt_codigo_rollo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_codigo_rollo.setFont(new Font("Arial", Font.BOLD, 13));
		txt_codigo_rollo.setColumns(10);
		txt_codigo_rollo.setBounds(307, 65, 182, 43);
		contentPane.add(txt_codigo_rollo);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_1.setBounds(499, 65, 182, 43);
		contentPane.add(lblNewLabel_1_1);
		
		txt_nombre = new JTextField();
		txt_nombre.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_nombre.setFont(new Font("Arial", Font.BOLD, 13));
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(691, 65, 182, 43);
		contentPane.add(txt_nombre);
		
		JLabel lblNewLabel_1_2 = new JLabel("PIEZAS");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2.setBounds(499, 119, 182, 43);
		contentPane.add(lblNewLabel_1_2);
		
		txt_piezas = new JTextField();
		txt_piezas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_piezas.setFont(new Font("Arial", Font.BOLD, 13));
		txt_piezas.setColumns(10);
		txt_piezas.setBounds(691, 119, 182, 43);
		contentPane.add(txt_piezas);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("FECHA DE SALIDA");
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5_1.setBounds(883, 65, 182, 43);
		contentPane.add(lblNewLabel_1_5_1);
		
		JButton btn_menu_principal = new JButton("MENU PRINCIPAL");
		btn_menu_principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 12));
		btn_menu_principal.setBounds(278, 557, 163, 43);
		
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
		
		JButton btnInventariDeEntradas_1 = new JButton("INVENTARIO DE SALIDAS");
		btnInventariDeEntradas_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInventariDeEntradas_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnInventariDeEntradas_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnInventariDeEntradas_1.setBounds(545, 557, 163, 43);
		contentPane.add(btnInventariDeEntradas_1);
		
		JButton btnLimpiarCampos = new JButton("LIMPIAR CAMPOS");
		btnLimpiarCampos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiarCampos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnLimpiarCampos.setFont(new Font("Arial", Font.BOLD, 12));
		btnLimpiarCampos.setBounds(824, 557, 163, 43);
		
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				limpiar_campos();
				requestFocus();
			}
		});
		
		contentPane.add(btnLimpiarCampos);
		
		lbl_fecha = new JLabel("");
		lbl_fecha.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_fecha.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_fecha.setBounds(1075, 65, 182, 43);
		contentPane.add(lbl_fecha);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("METROS");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2_1.setBounds(883, 119, 182, 43);
		contentPane.add(lblNewLabel_1_2_1);
		
		txt_metros = new JTextField();
		txt_metros.setFont(new Font("Arial", Font.BOLD, 13));
		txt_metros.setColumns(10);
		txt_metros.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_metros.setBounds(1075, 119, 182, 43);
		contentPane.add(txt_metros);
		
		JButton btn_menu_principal_1 = new JButton("BUSCAR");
		btn_menu_principal_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
				
				if(!"".equals(txt_codigo_rollo.getText())) {
					String cod = txt_codigo_rollo.getText();
					in = indao.Buscar_Rollo(cod);
					
					if(in.getNombre_Tela() !=  null) {
						
				    txt_nombre.setText(""+in.getNombre_Tela());
				    txt_piezas.setText(""+in.getPiezas());
				    txt_metros.setText(""+in.getMetros());
				    txt_cantidad.requestFocus();
				    	
				  }else {
					txt_nombre.setText("");
					txt_piezas.setText("");
					txt_metros.setText("");
			        txt_codigo_rollo.setText("");
			        requestFocus();
				  }
					
				}else {
					JOptionPane.showMessageDialog(null,"INGRESE EL CODIGO DEL ROLLO");
					requestFocus();
				}
		     }
		});
		btn_menu_principal_1.setFont(new Font("Arial", Font.BOLD, 12));
		btn_menu_principal_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal_1.setBounds(10, 65, 95, 43);
		contentPane.add(btn_menu_principal_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 2, true));
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPane.setBounds(10, 173, 1247, 373);
		contentPane.add(scrollPane);
		
		tbl_salidas = new JTable();
		tbl_salidas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tbl_salidas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tbl_salidas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"<html><center>CODIGO ROLLO</html></center>", "<html><center>NOMBRE TELA</html></center>", "<html><center>CANTIDAD</html></center>", "<html><center>METROS</html></center><html><center>ID</html></center>", "<html><center>FECHA DE SALIDA</html></center><html><center>FECHA DE SALIDA</html></center>"
			}
		));
		scrollPane.setViewportView(tbl_salidas);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("CANTIDAD");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2_2.setBounds(115, 119, 182, 43);
		contentPane.add(lblNewLabel_1_2_2);
		
		txt_cantidad = new JTextField();
		txt_cantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					if(!"".equals(txt_cantidad.getText())) {
						
						String codigo = txt_codigo_rollo.getText();
						String nombre = txt_nombre.getText();
						String metros = txt_metros.getText();
						String fecha = lbl_fecha.getText();
						int cantidad =Integer.parseInt(txt_cantidad.getText());
						int piezas = Integer.parseInt(txt_piezas.getText());
						
						if(piezas >= cantidad) {
							
							item = item+1;
							
							modelo = (DefaultTableModel) tbl_salidas.getModel();
							
							ArrayList lista = new ArrayList();
							
							lista.add(item);
							
							lista.add(codigo);
							lista.add(nombre);
							lista.add(cantidad);
							lista.add(metros);
							lista.add(fecha);
							
							Object[] O = new Object[5];
							O[0] = lista.get(1);
							O[1] = lista.get(2);
							O[2] = lista.get(3);
							O[3] = lista.get(4);
							O[4] = lista.get(5);
						    modelo.addRow(O);	
						    tbl_salidas.setModel(modelo);
						}else {
							JOptionPane.showMessageDialog(null,"CANTIDAD DE PIEZAS NO DISPONIBLES");
						}
					}else {
						JOptionPane.showMessageDialog(null,"INGRESE CANTIDAD");
					}
					
				}
				
			}
		});
		txt_cantidad.setFont(new Font("Arial", Font.BOLD, 13));
		txt_cantidad.setColumns(10);
		txt_cantidad.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_cantidad.setBounds(307, 119, 182, 43);
		contentPane.add(txt_cantidad);
	}
	    
	    public void actualizarFecha() {

	        Date fechaActual = new Date();

	        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	        String fechaFormateada = formatoFecha.format(fechaActual);

	        lbl_fecha.setText(fechaFormateada);
	    }
		
		private void limpiar_campos() {
			txt_codigo_rollo.setText("");
			txt_nombre.setText("");
			txt_piezas.setText("");
			txt_metros.setText("");
		}
	}

