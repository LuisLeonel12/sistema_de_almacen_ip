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
	private JTextField txt_anchos_cortables;
	private JTextField txt_caracteristicas;
	private JLabel lbl_imagen_1;
	private JLabel lbl_imagen_2;
	private JLabel lbl_fecha;
	private JLabel lbl_hora;

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
		setBounds(100, 100, 861, 585);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEntradas = new JLabel("SALIDAS");
		lblEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntradas.setFont(new Font("Arial", Font.BOLD, 16));
		lblEntradas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblEntradas.setBounds(10, 11, 825, 36);
		contentPane.add(lblEntradas);
		
		JLabel lblNewLabel_1 = new JLabel("CODIGO TELA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1.setBounds(10, 58, 182, 43);
		contentPane.add(lblNewLabel_1);
		
		txt_codigo_tela = new JTextField();
		txt_codigo_tela.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_codigo_tela.setFont(new Font("Arial", Font.BOLD, 13));
		txt_codigo_tela.setColumns(10);
		txt_codigo_tela.setBounds(202, 58, 262, 43);
		contentPane.add(txt_codigo_tela);
		
		JLabel lblNewLabel_2_1 = new JLabel("FOTOS DE TELA");
		lblNewLabel_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_2_1.setBounds(474, 58, 361, 54);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_1.setBounds(10, 112, 182, 43);
		contentPane.add(lblNewLabel_1_1);
		
		txt_nombre = new JTextField();
		txt_nombre.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_nombre.setFont(new Font("Arial", Font.BOLD, 13));
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(202, 112, 262, 43);
		contentPane.add(txt_nombre);
		
		JLabel lblNewLabel_1_2 = new JLabel("PROVEEDOR");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2.setBounds(10, 166, 182, 43);
		contentPane.add(lblNewLabel_1_2);
		
		txt_proveedor = new JTextField();
		txt_proveedor.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_proveedor.setFont(new Font("Arial", Font.BOLD, 13));
		txt_proveedor.setColumns(10);
		txt_proveedor.setBounds(202, 166, 262, 43);
		contentPane.add(txt_proveedor);
		
		lbl_imagen_1 = new JLabel("");
		lbl_imagen_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_imagen_1.setBounds(474, 123, 171, 309);
		contentPane.add(lbl_imagen_1);
		
		lbl_imagen_2 = new JLabel("");
		lbl_imagen_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_imagen_2.setBounds(664, 123, 171, 309);
		contentPane.add(lbl_imagen_2);
		
		txt_peso = new JTextField();
		txt_peso.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_peso.setFont(new Font("Arial", Font.BOLD, 13));
		txt_peso.setColumns(10);
		txt_peso.setBounds(202, 220, 262, 43);
		contentPane.add(txt_peso);
		
		JLabel lblNewLabel_1_3 = new JLabel("PESO");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_3.setBounds(10, 220, 182, 43);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("ANCHOS CORTABLES");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_4.setBounds(10, 274, 182, 43);
		contentPane.add(lblNewLabel_1_4);
		
		txt_anchos_cortables = new JTextField();
		txt_anchos_cortables.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_anchos_cortables.setFont(new Font("Arial", Font.BOLD, 13));
		txt_anchos_cortables.setColumns(10);
		txt_anchos_cortables.setBounds(202, 274, 262, 43);
		contentPane.add(txt_anchos_cortables);
		
		JLabel lblNewLabel_1_5 = new JLabel("CARACTERISTICAS");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5.setBounds(10, 328, 182, 43);
		contentPane.add(lblNewLabel_1_5);
		
		txt_caracteristicas = new JTextField();
		txt_caracteristicas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_caracteristicas.setFont(new Font("Arial", Font.BOLD, 13));
		txt_caracteristicas.setColumns(10);
		txt_caracteristicas.setBounds(202, 328, 262, 43);
		contentPane.add(txt_caracteristicas);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("FECHA DE SALIDA");
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5_1.setBounds(10, 382, 182, 43);
		contentPane.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("HORA DE SALIDA");
		lblNewLabel_1_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5_2.setBounds(10, 436, 182, 43);
		contentPane.add(lblNewLabel_1_5_2);
		
		JButton btn_agregar_imagen1 = new JButton("AGREGAR IMAGENES");
		btn_agregar_imagen1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_agregar_imagen1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_agregar_imagen1.setFont(new Font("Arial", Font.BOLD, 12));
		btn_agregar_imagen1.setBounds(474, 445, 171, 34);
		
		btn_agregar_imagen1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				seleccionarImagen1();
				requestFocus();
				
			}
		});
		
		contentPane.add(btn_agregar_imagen1);
		
		JButton btn_agregar_imagen2 = new JButton("AGREGAR IMAGENES");
		btn_agregar_imagen2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_agregar_imagen2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_agregar_imagen2.setFont(new Font("Arial", Font.BOLD, 12));
		btn_agregar_imagen2.setBounds(664, 445, 171, 34);
		
		btn_agregar_imagen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarImagen2();
				requestFocus();
			}
		});
		
		contentPane.add(btn_agregar_imagen2);
		
		JButton btn_menu_principal = new JButton("MENU PRINCIPAL");
		btn_menu_principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 12));
		btn_menu_principal.setBounds(641, 504, 152, 31);
		
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
		
		JButton btnInventariDeEntradas_1 = new JButton("INVENTARIO DE ENTRADAS");
		btnInventariDeEntradas_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInventariDeEntradas_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnInventariDeEntradas_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnInventariDeEntradas_1.setBounds(413, 504, 191, 31);
		contentPane.add(btnInventariDeEntradas_1);
		
		JButton btnLimpiarCampos = new JButton("LIMPIAR CAMPOS");
		btnLimpiarCampos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiarCampos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnLimpiarCampos.setFont(new Font("Arial", Font.BOLD, 12));
		btnLimpiarCampos.setBounds(214, 504, 171, 31);
		
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
		btnNewButton.setBounds(49, 504, 131, 31);
		
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
		lbl_fecha.setBounds(202, 382, 262, 43);
		contentPane.add(lbl_fecha);
		
		lbl_hora = new JLabel("");
		lbl_hora.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hora.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_hora.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_hora.setBounds(202, 436, 262, 43);
		contentPane.add(lbl_hora);
	}
	
	
	private void seleccionarImagen1() {
	    JFileChooser jf = new JFileChooser();
	    FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG & PNG", "JPG", "PNG");
	    jf.setFileFilter(filtrado);

	    int respuesta = jf.showOpenDialog(this);

	    if (respuesta == JFileChooser.APPROVE_OPTION) {
	        File archivoImagen = jf.getSelectedFile();

	        try {
	            // Leer la imagen original
	            BufferedImage imagenOriginal = ImageIO.read(archivoImagen);

	            // Obtener las dimensiones del JLabel
	            int anchoLabel = lbl_imagen_1.getWidth();
	            int altoLabel = lbl_imagen_1.getHeight();

	            // Escalar la imagen para que se ajuste al JLabel
	            java.awt.Image imagenEscalada = imagenOriginal.getScaledInstance(anchoLabel, altoLabel, Image.ORIGINAL_PNG);

	            // Crear un ImageIcon con la imagen escalada
	            ImageIcon imageIcon = new ImageIcon(imagenEscalada);

	            // Establecer el ImageIcon en el JLabel
	            lbl_imagen_1.setIcon(imageIcon);

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
	
	private void seleccionarImagen2() {
	    JFileChooser jf = new JFileChooser();
	    FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG & PNG", "JPG", "PNG");
	    jf.setFileFilter(filtrado);

	    int respuesta = jf.showOpenDialog(this);

	    if (respuesta == JFileChooser.APPROVE_OPTION) {
	        File archivoImagen = jf.getSelectedFile();

	        try {
	            // Leer la imagen original
	            BufferedImage imagenOriginal = ImageIO.read(archivoImagen);

	            // Obtener las dimensiones del JLabel
	            int anchoLabel = lbl_imagen_2.getWidth();
	            int altoLabel = lbl_imagen_2.getHeight();

	            // Escalar la imagen para que se ajuste al JLabel
	            java.awt.Image imagenEscalada = imagenOriginal.getScaledInstance(anchoLabel, altoLabel, Image.ORIGINAL_PNG);

	            // Crear un ImageIcon con la imagen escalada
	            ImageIcon imageIcon = new ImageIcon(imagenEscalada);

	            // Establecer el ImageIcon en el JLabel
	            lbl_imagen_2.setIcon(imageIcon);

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }} 
	    }
	    
	    
	    public void actualizarFecha() {
	        // Obtener la fecha actual
	        Date fechaActual = new Date();

	        // Formatear la fecha como una cadena
	        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	        String fechaFormateada = formatoFecha.format(fechaActual);

	        // Actualizar el texto del JLabel
	        lbl_fecha.setText(fechaFormateada);
	    }
		
		
		public void actualizar_hora() {
	        Thread hilo = new Thread(() -> {
	            while (true) {
	                // Obtener la hora actual
	                Date horaActual = new Date();

	                // Formatear la hora como una cadena
	                SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss a");
	                String horaFormateada = formatoHora.format(horaActual);

	                // Actualizar el texto del JLabel con la hora
	                SwingUtilities.invokeLater(() -> {
	                    lbl_hora.setText(horaFormateada);
	                });

	                // Dormir el hilo durante 1 segundo
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
			txt_anchos_cortables.setText("");;
			txt_caracteristicas.setText("");;
		}
		
	}

