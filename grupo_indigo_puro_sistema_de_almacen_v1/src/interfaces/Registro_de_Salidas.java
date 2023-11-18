package interfaces;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.Image;

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
	private JTextField txt_codigo_tela;
	private JTextField txt_nombre;
	private JTextField txt_proveedor;
	private JTextField txt_peso;
	private JTextField txt_caracteristicas;
	private JLabel lbl_fecha;
	private JLabel lbl_hora;
	private JTextField textField;

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
		setBounds(100, 100, 899, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEntradas = new JLabel("SALIDAS");
		lblEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntradas.setFont(new Font("Arial", Font.BOLD, 16));
		lblEntradas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblEntradas.setBounds(10, 11, 863, 36);
		contentPane.add(lblEntradas);
		
		JLabel lblNewLabel_1 = new JLabel("CODIGO TELA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1.setBounds(10, 133, 182, 43);
		contentPane.add(lblNewLabel_1);
		
		txt_codigo_tela = new JTextField();
		txt_codigo_tela.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_codigo_tela.setFont(new Font("Arial", Font.BOLD, 13));
		txt_codigo_tela.setColumns(10);
		txt_codigo_tela.setBounds(202, 133, 262, 43);
		contentPane.add(txt_codigo_tela);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_1.setBounds(10, 187, 182, 43);
		contentPane.add(lblNewLabel_1_1);
		
		txt_nombre = new JTextField();
		txt_nombre.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_nombre.setFont(new Font("Arial", Font.BOLD, 13));
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(202, 187, 262, 43);
		contentPane.add(txt_nombre);
		
		JLabel lblNewLabel_1_2 = new JLabel("PROVEEDOR");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2.setBounds(10, 241, 182, 43);
		contentPane.add(lblNewLabel_1_2);
		
		txt_proveedor = new JTextField();
		txt_proveedor.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_proveedor.setFont(new Font("Arial", Font.BOLD, 13));
		txt_proveedor.setColumns(10);
		txt_proveedor.setBounds(202, 241, 262, 43);
		contentPane.add(txt_proveedor);
		
		txt_peso = new JTextField();
		txt_peso.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_peso.setFont(new Font("Arial", Font.BOLD, 13));
		txt_peso.setColumns(10);
		txt_peso.setBounds(202, 295, 262, 43);
		contentPane.add(txt_peso);
		
		JLabel lblNewLabel_1_3 = new JLabel("PESO");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_3.setBounds(10, 295, 182, 43);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_5 = new JLabel("CARACTERISTICAS");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5.setBounds(10, 349, 182, 43);
		contentPane.add(lblNewLabel_1_5);
		
		txt_caracteristicas = new JTextField();
		txt_caracteristicas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_caracteristicas.setFont(new Font("Arial", Font.BOLD, 13));
		txt_caracteristicas.setColumns(10);
		txt_caracteristicas.setBounds(202, 349, 262, 43);
		contentPane.add(txt_caracteristicas);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("FECHA DE SALIDA");
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5_1.setBounds(10, 403, 182, 43);
		contentPane.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("HORA DE SALIDA");
		lblNewLabel_1_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5_2.setBounds(10, 457, 182, 43);
		contentPane.add(lblNewLabel_1_5_2);
		
		JButton btn_menu_principal = new JButton("MENU PRINCIPAL");
		btn_menu_principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 12));
		btn_menu_principal.setBounds(702, 241, 171, 43);
		
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
		btnInventariDeEntradas_1.setBounds(497, 241, 171, 43);
		contentPane.add(btnInventariDeEntradas_1);
		
		JButton btnLimpiarCampos = new JButton("LIMPIAR CAMPOS");
		btnLimpiarCampos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiarCampos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnLimpiarCampos.setFont(new Font("Arial", Font.BOLD, 12));
		btnLimpiarCampos.setBounds(702, 133, 171, 43);
		
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
		btnNewButton.setBounds(497, 133, 171, 43);
		
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
		lbl_fecha.setBounds(202, 403, 262, 43);
		contentPane.add(lbl_fecha);
		
		lbl_hora = new JLabel("");
		lbl_hora.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hora.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_hora.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_hora.setBounds(202, 457, 262, 43);
		contentPane.add(lbl_hora);
		
		JLabel lblNewLabel_1_4 = new JLabel("CODIGO TELA");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_4.setBounds(10, 79, 182, 43);
		contentPane.add(lblNewLabel_1_4);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 13));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField.setBounds(202, 79, 262, 43);
		contentPane.add(textField);
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
			txt_codigo_tela.setText("");;
			txt_nombre.setText("");;
			txt_proveedor.setText("");;
			txt_peso.setText("");;
			txt_caracteristicas.setText("");;
		}
	}

