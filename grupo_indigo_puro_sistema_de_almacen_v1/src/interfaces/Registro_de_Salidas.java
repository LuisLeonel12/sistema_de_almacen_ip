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
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Registro_de_Salidas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel lbl_imagen_1;
	private JLabel lbl_imagen_2;

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
		setBounds(100, 100, 861, 528);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEntradas = new JLabel("SALIDAS");
		lblEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntradas.setFont(new Font("Arial", Font.BOLD, 16));
		lblEntradas.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEntradas.setBounds(10, 11, 825, 36);
		contentPane.add(lblEntradas);
		
		JLabel lblNewLabel_1 = new JLabel("CODIGO TELA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(10, 58, 143, 36);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 13));
		textField.setColumns(10);
		textField.setBounds(163, 58, 301, 36);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("FOTOS DE TELA");
		lblNewLabel_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setBounds(474, 58, 361, 54);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1.setBounds(10, 105, 143, 36);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.BOLD, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(163, 105, 301, 36);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("PROVEEDOR");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setBounds(10, 152, 143, 36);
		contentPane.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.BOLD, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(163, 152, 301, 36);
		contentPane.add(textField_2);
		
		lbl_imagen_1 = new JLabel("");
		lbl_imagen_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_imagen_1.setBounds(474, 123, 171, 252);
		contentPane.add(lbl_imagen_1);
		
		lbl_imagen_2 = new JLabel("");
		lbl_imagen_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_imagen_2.setBounds(664, 123, 171, 252);
		contentPane.add(lbl_imagen_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.BOLD, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(163, 199, 301, 36);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("PESO");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setBounds(10, 199, 143, 36);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("ANCHOS CORTABLES");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_4.setBounds(10, 246, 143, 36);
		contentPane.add(lblNewLabel_1_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.BOLD, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(163, 246, 301, 36);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("CARACTERISTICAS");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5.setBounds(10, 293, 143, 36);
		contentPane.add(lblNewLabel_1_5);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.BOLD, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(163, 293, 301, 36);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("FECHA DE SALIDA");
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5_1.setBounds(10, 340, 143, 35);
		contentPane.add(lblNewLabel_1_5_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.BOLD, 13));
		textField_6.setColumns(10);
		textField_6.setBounds(163, 340, 301, 35);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("HORA DE SALIDA");
		lblNewLabel_1_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5_2.setBounds(10, 386, 143, 36);
		contentPane.add(lblNewLabel_1_5_2);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Arial", Font.BOLD, 13));
		textField_7.setColumns(10);
		textField_7.setBounds(163, 386, 301, 36);
		contentPane.add(textField_7);
		
		JButton btn_agregar_imagen1 = new JButton("AGREGAR IMAGENES");
		btn_agregar_imagen1.setFont(new Font("Arial", Font.BOLD, 12));
		btn_agregar_imagen1.setBounds(474, 388, 171, 34);
		
		btn_agregar_imagen1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				seleccionarImagen1();
				requestFocus();
				
			}
		});
		
		contentPane.add(btn_agregar_imagen1);
		
		JButton btn_agregar_imagen2 = new JButton("AGREGAR IMAGENES");
		btn_agregar_imagen2.setFont(new Font("Arial", Font.BOLD, 12));
		btn_agregar_imagen2.setBounds(664, 388, 171, 34);
		
		btn_agregar_imagen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarImagen2();
				requestFocus();
			}
		});
		
		contentPane.add(btn_agregar_imagen2);
		
		JButton btn_menu_principal = new JButton("MENU PRINCIPAL");
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 12));
		btn_menu_principal.setBounds(642, 447, 152, 31);
		
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
		btnInventariDeEntradas_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnInventariDeEntradas_1.setBounds(414, 447, 191, 31);
		contentPane.add(btnInventariDeEntradas_1);
		
		JButton btnLimpiarCampos = new JButton("LIMPIAR CAMPOS");
		btnLimpiarCampos.setFont(new Font("Arial", Font.BOLD, 12));
		btnLimpiarCampos.setBounds(215, 447, 171, 31);
		contentPane.add(btnLimpiarCampos);
		
		JButton btnNewButton = new JButton("INGRESAR TELA");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(50, 447, 131, 31);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					JOptionPane.showMessageDialog(null,"SALIDA DE MATERIAL REALIZADO...");
					
				} catch (Exception e2) {
					
				}
				
				
				
			}
		});
		
		contentPane.add(btnNewButton);
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
	        }
	    }
	}
	

}
