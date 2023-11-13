package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.Image;

import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Registro_de_Entradas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_codigo_tela;
	private JTextField txt_nombre;
	private JTextField txt_proveedor;
	private JTextField txt_peso;
	private JTextField txt_anchos_cortables;
	private JTextField txt_caracteristicas;
	private JTextField txt_fecha_entrada;
	private JTextField txt_hora_entrada;
	private JLabel lbl_imagen1;
	private JLabel lbl_imagen2;
	private JLabel lbl_fecha;
	private JLabel lbl_hora;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro_de_Entradas frame = new Registro_de_Entradas();
					frame.setVisible(true);
					frame.requestFocus();
					frame.setLocationRelativeTo(null);
					frame.actualizarFecha();
					frame.actualizar_hora();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registro_de_Entradas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registro_de_Entradas.class.getResource("/imagenes/registro.png")));
		setResizable(false);
		setTitle("REGISTRO DE ENTRADAS");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 861, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CODIGO TELA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(10, 110, 144, 36);
		contentPane.add(lblNewLabel_1);
		
		txt_codigo_tela = new JTextField();
		txt_codigo_tela.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//este codigo hace que cada jtextfiel acepte solo numeros
				
				char validar = e.getKeyChar();
				
				if(Character.isLetter(validar)){
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txt_codigo_tela.setFont(new Font("Arial", Font.BOLD, 12));
		txt_codigo_tela.setColumns(10);
		txt_codigo_tela.setBounds(164, 110, 280, 36);
		contentPane.add(txt_codigo_tela);
		
		JLabel lblNewLabel_2_1 = new JLabel("FOTOS DE TELA");
		lblNewLabel_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setBounds(454, 110, 381, 54);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1.setBounds(10, 157, 144, 36);
		contentPane.add(lblNewLabel_1_1);
		
		txt_nombre = new JTextField();
		txt_nombre.setFont(new Font("Arial", Font.BOLD, 12));
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(164, 157, 280, 36);
		contentPane.add(txt_nombre);
		
		JLabel lblNewLabel_1_2 = new JLabel("PROVEEDOR");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setBounds(10, 204, 144, 36);
		contentPane.add(lblNewLabel_1_2);
		
		txt_proveedor = new JTextField();
		txt_proveedor.setFont(new Font("Arial", Font.BOLD, 12));
		txt_proveedor.setColumns(10);
		txt_proveedor.setBounds(164, 204, 280, 36);
		contentPane.add(txt_proveedor);
		
		JLabel lblNewLabel_1_3 = new JLabel("PESO");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setBounds(10, 251, 144, 36);
		contentPane.add(lblNewLabel_1_3);
		
		txt_peso = new JTextField();
		txt_peso.setFont(new Font("Arial", Font.BOLD, 12));
		txt_peso.setColumns(10);
		txt_peso.setBounds(164, 251, 280, 36);
		contentPane.add(txt_peso);
		
		JLabel lblNewLabel_1_4 = new JLabel("ANCHOS CORTABLES");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_4.setBounds(10, 298, 144, 36);
		contentPane.add(lblNewLabel_1_4);
		
		txt_anchos_cortables = new JTextField();
		txt_anchos_cortables.setFont(new Font("Arial", Font.BOLD, 12));
		txt_anchos_cortables.setColumns(10);
		txt_anchos_cortables.setBounds(164, 298, 280, 36);
		contentPane.add(txt_anchos_cortables);
		
		JLabel lblNewLabel_1_5 = new JLabel("CARACTERISTICAS");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5.setBounds(10, 345, 144, 36);
		contentPane.add(lblNewLabel_1_5);
		
		txt_caracteristicas = new JTextField();
		txt_caracteristicas.setFont(new Font("Arial", Font.BOLD, 12));
		txt_caracteristicas.setColumns(10);
		txt_caracteristicas.setBounds(164, 345, 280, 36);
		contentPane.add(txt_caracteristicas);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("FECHA DE ENTRADA");
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5_1.setBounds(10, 392, 144, 35);
		contentPane.add(lblNewLabel_1_5_1);
		
		txt_fecha_entrada = new JTextField();
		txt_fecha_entrada.setFont(new Font("Arial", Font.BOLD, 12));
		txt_fecha_entrada.setColumns(10);
		txt_fecha_entrada.setBounds(164, 392, 280, 35);
		contentPane.add(txt_fecha_entrada);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("HORA DE ENTRADA");
		lblNewLabel_1_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5_2.setBounds(10, 438, 144, 36);
		contentPane.add(lblNewLabel_1_5_2);
		
		txt_hora_entrada = new JTextField();
		txt_hora_entrada.setFont(new Font("Arial", Font.BOLD, 12));
		txt_hora_entrada.setColumns(10);
		txt_hora_entrada.setBounds(164, 438, 280, 36);
		contentPane.add(txt_hora_entrada);
		
		JButton btn_agregar_imagen1 = new JButton("AGREGAR IMAGENES");
		btn_agregar_imagen1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				seleccionarImagen();
				requestFocus();
				
			}
				
        });
				
		btn_agregar_imagen1.setFont(new Font("Arial", Font.BOLD, 12));
		btn_agregar_imagen1.setBounds(454, 439, 182, 34);
		contentPane.add(btn_agregar_imagen1);
		
		JButton btn_agregar_imagen2 = new JButton("AGREGAR IMAGENES");
		btn_agregar_imagen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarImagen2();
				requestFocus();
			}
		});
		btn_agregar_imagen2.setFont(new Font("Arial", Font.BOLD, 12));
		btn_agregar_imagen2.setBounds(653, 439, 182, 34);
		contentPane.add(btn_agregar_imagen2);
		
		JButton btnNewButton = new JButton("INGRESAR TELA");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(43, 499, 131, 31);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//CONDICONAL PARA REVISAR SI EL MATERIAL A INGRESADO CORRECTAMENTE
				
				JOptionPane.showMessageDialog(null, "MATERIAL AGREGADO CORRECTAMENTE");
				requestFocus();
			}
		});
		
		contentPane.add(btnNewButton);
		
		JButton btnLimpiarCampos = new JButton("LIMPIAR CAMPOS");
		btnLimpiarCampos.setFont(new Font("Arial", Font.BOLD, 12));
		btnLimpiarCampos.setBounds(211, 499, 171, 31);
		
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			limpiar_campos();
			requestFocus();
				
			}
		});
		contentPane.add(btnLimpiarCampos);
		
		JButton btnMenuPrincipal_1 = new JButton("MENU PRINCIPAL");
		btnMenuPrincipal_1.addActionListener(new ActionListener() {
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
		btnMenuPrincipal_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnMenuPrincipal_1.setBounds(635, 499, 152, 31);
		contentPane.add(btnMenuPrincipal_1);
		
		JButton btnInventariDeEntradas_1 = new JButton("INVENTARIO DE ENTRADAS");
		btnInventariDeEntradas_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		btnInventariDeEntradas_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnInventariDeEntradas_1.setBounds(411, 499, 191, 31);
		contentPane.add(btnInventariDeEntradas_1);
		
		JLabel lblEntradas = new JLabel("ENTRADAS");
		lblEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntradas.setFont(new Font("Arial", Font.BOLD, 16));
		lblEntradas.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEntradas.setBounds(10, 11, 825, 36);
		contentPane.add(lblEntradas);
		
		lbl_imagen1 = new JLabel("");
		lbl_imagen1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_imagen1.setBounds(454, 175, 182, 252);
		contentPane.add(lbl_imagen1);
		
		lbl_imagen2 = new JLabel("");
		lbl_imagen2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_imagen2.setBounds(653, 175, 182, 252);
		contentPane.add(lbl_imagen2);
		
		lbl_fecha = new JLabel("");
		lbl_fecha.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_fecha.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_fecha.setBounds(10, 58, 218, 36);
		contentPane.add(lbl_fecha);
		
		lbl_hora = new JLabel("");
		lbl_hora.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hora.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_hora.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_hora.setBounds(617, 58, 218, 36);
		contentPane.add(lbl_hora);
	}
	
	
	public void limpiar_campos() {
		txt_codigo_tela.setText("");
		txt_nombre.setText("");
		txt_proveedor.setText("");
		txt_peso.setText("");
		txt_anchos_cortables.setText("");
		txt_caracteristicas.setText("");
		txt_fecha_entrada.setText("");
		txt_hora_entrada.setText("");
		lbl_imagen1.setIcon(null);
		lbl_imagen2.setIcon(null);
	   
	}
	
	
	
	private void seleccionarImagen() {
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
	            int anchoLabel = lbl_imagen1.getWidth();
	            int altoLabel = lbl_imagen1.getHeight();

	            // Escalar la imagen para que se ajuste al JLabel
	            java.awt.Image imagenEscalada = imagenOriginal.getScaledInstance(anchoLabel, altoLabel, Image.ORIGINAL_PNG);

	            // Crear un ImageIcon con la imagen escalada
	            ImageIcon imageIcon = new ImageIcon(imagenEscalada);

	            // Establecer el ImageIcon en el JLabel
	            lbl_imagen1.setIcon(imageIcon);

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
                BufferedImage imagen = ImageIO.read(archivoImagen);
                java.awt.Image scaledImage = imagen.getScaledInstance(300, 200, Image.DEFAULT);
                ImageIcon imageIcon = new ImageIcon(scaledImage);

                lbl_imagen2.setIcon(imageIcon);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
	
	
	public void actualizarFecha() {
        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Formatear la fecha como una cadena
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(fechaActual);

        // Actualizar el texto del JLabel
        lbl_fecha.setText("Fecha actual: " + fechaFormateada);
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
                    lbl_hora.setText("Hora actual: " + horaFormateada);
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
	
	
	
	}
