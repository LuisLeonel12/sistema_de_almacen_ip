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
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Cursor;

public class Registro_de_Salidas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_codigo_rollo;
	private JTextField txt_nombre;
	private JTextField txt_piezas;
	private JTextField txt_peso;
	private JTextField txt_caracteristicas;
	private JLabel lbl_fecha;
	private JLabel lbl_hora;
	private JTextField txt_metros;


	Inventario in = new Inventario();
	Inventario_DAO indao = new Inventario_DAO();
	
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
		setBounds(100, 100, 950, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEntradas = new JLabel("SALIDAS");
		lblEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntradas.setFont(new Font("Arial", Font.BOLD, 16));
		lblEntradas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblEntradas.setBounds(10, 11, 863, 43);
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
		lblNewLabel_1_2.setBounds(115, 119, 182, 43);
		contentPane.add(lblNewLabel_1_2);
		
		txt_piezas = new JTextField();
		txt_piezas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_piezas.setFont(new Font("Arial", Font.BOLD, 13));
		txt_piezas.setColumns(10);
		txt_piezas.setBounds(307, 119, 182, 43);
		contentPane.add(txt_piezas);
		
		txt_peso = new JTextField();
		txt_peso.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_peso.setFont(new Font("Arial", Font.BOLD, 13));
		txt_peso.setColumns(10);
		txt_peso.setBounds(202, 227, 262, 43);
		contentPane.add(txt_peso);
		
		JLabel lblNewLabel_1_3 = new JLabel("PESO");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_3.setBounds(10, 227, 182, 43);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_5 = new JLabel("CARACTERISTICAS");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5.setBounds(10, 281, 182, 43);
		contentPane.add(lblNewLabel_1_5);
		
		txt_caracteristicas = new JTextField();
		txt_caracteristicas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_caracteristicas.setFont(new Font("Arial", Font.BOLD, 13));
		txt_caracteristicas.setColumns(10);
		txt_caracteristicas.setBounds(202, 281, 262, 43);
		contentPane.add(txt_caracteristicas);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("FECHA DE SALIDA");
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5_1.setBounds(10, 335, 182, 43);
		contentPane.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("HORA DE SALIDA");
		lblNewLabel_1_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5_2.setBounds(10, 389, 182, 43);
		contentPane.add(lblNewLabel_1_5_2);
		
		JButton btn_menu_principal = new JButton("MENU PRINCIPAL");
		btn_menu_principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 12));
		btn_menu_principal.setBounds(702, 389, 171, 43);
		
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
		btnInventariDeEntradas_1.setBounds(497, 389, 171, 43);
		contentPane.add(btnInventariDeEntradas_1);
		
		JButton btnLimpiarCampos = new JButton("LIMPIAR CAMPOS");
		btnLimpiarCampos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiarCampos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnLimpiarCampos.setFont(new Font("Arial", Font.BOLD, 12));
		btnLimpiarCampos.setBounds(702, 281, 171, 43);
		
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				limpiar_campos();
				requestFocus();
			}
		});
		
		contentPane.add(btnLimpiarCampos);
		
		JButton btnNewButton = new JButton("INGRESAR TELA");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(497, 281, 171, 43);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					JOptionPane.showMessageDialog(null,"SALIDA DE MATERIAL REALIZADO...");
					
				} catch (Exception e2) {
					
				}
			}
		});
		
		contentPane.add(btnNewButton);
		
		lbl_fecha = new JLabel("");
		lbl_fecha.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_fecha.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_fecha.setBounds(202, 335, 262, 43);
		contentPane.add(lbl_fecha);
		
		lbl_hora = new JLabel("");
		lbl_hora.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hora.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_hora.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_hora.setBounds(202, 389, 262, 43);
		contentPane.add(lbl_hora);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("METROS");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2_1.setBounds(499, 119, 182, 43);
		contentPane.add(lblNewLabel_1_2_1);
		
		txt_metros = new JTextField();
		txt_metros.setFont(new Font("Arial", Font.BOLD, 13));
		txt_metros.setColumns(10);
		txt_metros.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_metros.setBounds(691, 119, 182, 43);
		contentPane.add(txt_metros);
		
		JButton btn_menu_principal_1 = new JButton("BUSCAR");
		btn_menu_principal_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
			}
		});
		btn_menu_principal_1.setFont(new Font("Arial", Font.BOLD, 12));
		btn_menu_principal_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal_1.setBounds(10, 65, 95, 43);
		contentPane.add(btn_menu_principal_1);
	}
	    
	    public void actualizarFecha() {

	        Date fechaActual = new Date();

	        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	        String fechaFormateada = formatoFecha.format(fechaActual);

	        lbl_fecha.setText(fechaFormateada);
	    }
		
		
		public void actualizar_hora() {
	        Thread hilo = new Thread(() -> {
	            while (true) {

	                Date horaActual = new Date();

	                SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm a");
	                String horaFormateada = formatoHora.format(horaActual);

	                SwingUtilities.invokeLater(() -> {
	                    lbl_hora.setText(horaFormateada);
	                });

	                try {
	                    Thread.sleep(1000);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        });

	        hilo.start();
		}
		
		private void limpiar_campos() {
			txt_codigo_rollo.setText("");;
			txt_nombre.setText("");;
			txt_piezas.setText("");;
			txt_peso.setText("");;
			txt_caracteristicas.setText("");;
		}
	}

