package interfaces;

import java.awt.EventQueue;
import base_de_datos.Entradas;
import base_de_datos.Entradas_DAO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
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
import java.awt.Cursor;

public class Registro_de_Entradas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_codigo_rollo;
	private JTextField txt_nombre_tela;
	private JTextField txt_proveedor;
	private JTextField txt_peso;
	private JTextField txt_caracteristicas;
	private JLabel lbl_imagen1;
	private JLabel lbl_imagen2;
	private JLabel lbl_fecha;
	private JLabel lbl_hora;
	
	
	//VARIABLES
	Entradas e = new Entradas();
	Entradas_DAO edao= new Entradas_DAO();
    DefaultTableModel modelo = new DefaultTableModel();
	
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
		setBounds(100, 100, 861, 544);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CODIGO ROLLO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1.setBounds(10, 58, 174, 43);
		contentPane.add(lblNewLabel_1);
		
		txt_codigo_rollo = new JTextField();
		txt_codigo_rollo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_codigo_rollo.addKeyListener(new KeyAdapter() {
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
		txt_codigo_rollo.setFont(new Font("Arial", Font.BOLD, 12));
		txt_codigo_rollo.setColumns(10);
		txt_codigo_rollo.setBounds(194, 58, 250, 43);
		contentPane.add(txt_codigo_rollo);
		
		JLabel lblNewLabel_2_1 = new JLabel("FOTOS DE TELA");
		lblNewLabel_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_2_1.setBounds(454, 58, 381, 54);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_1.setBounds(10, 112, 174, 43);
		contentPane.add(lblNewLabel_1_1);
		
		txt_nombre_tela = new JTextField();
		txt_nombre_tela.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_nombre_tela.setFont(new Font("Arial", Font.BOLD, 12));
		txt_nombre_tela.setColumns(10);
		txt_nombre_tela.setBounds(194, 112, 250, 43);
		contentPane.add(txt_nombre_tela);
		
		JLabel lblNewLabel_1_2 = new JLabel("PROVEEDOR");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2.setBounds(10, 166, 174, 43);
		contentPane.add(lblNewLabel_1_2);
		
		txt_proveedor = new JTextField();
		txt_proveedor.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_proveedor.setFont(new Font("Arial", Font.BOLD, 12));
		txt_proveedor.setColumns(10);
		txt_proveedor.setBounds(194, 166, 250, 43);
		contentPane.add(txt_proveedor);
		
		JLabel lblNewLabel_1_3 = new JLabel("PESO");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_3.setBounds(10, 220, 174, 43);
		contentPane.add(lblNewLabel_1_3);
		
		txt_peso = new JTextField();
		txt_peso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
		});
		txt_peso.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_peso.setFont(new Font("Arial", Font.BOLD, 12));
		txt_peso.setColumns(10);
		txt_peso.setBounds(194, 220, 250, 43);
		contentPane.add(txt_peso);
		
		JLabel lblNewLabel_1_5 = new JLabel("CARACTERISTICAS");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5.setBounds(10, 274, 174, 43);
		contentPane.add(lblNewLabel_1_5);
		
		txt_caracteristicas = new JTextField();
		txt_caracteristicas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_caracteristicas.setFont(new Font("Arial", Font.BOLD, 12));
		txt_caracteristicas.setColumns(10);
		txt_caracteristicas.setBounds(194, 274, 250, 43);
		contentPane.add(txt_caracteristicas);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("FECHA DE ENTRADA");
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5_1.setBounds(10, 328, 174, 43);
		contentPane.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("HORA DE ENTRADA");
		lblNewLabel_1_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5_2.setBounds(10, 387, 174, 43);
		contentPane.add(lblNewLabel_1_5_2);
		
		JButton btn_agregar_imagen1 = new JButton("AGREGAR IMAGENES");
		btn_agregar_imagen1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_agregar_imagen1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_agregar_imagen1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				seleccionarImagen();
				requestFocus();
				
			}
				
        });
				
		btn_agregar_imagen1.setFont(new Font("Arial", Font.BOLD, 12));
		btn_agregar_imagen1.setBounds(454, 396, 182, 34);
		contentPane.add(btn_agregar_imagen1);
		
		JButton btn_agregar_imagen2 = new JButton("AGREGAR IMAGENES");
		btn_agregar_imagen2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_agregar_imagen2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_agregar_imagen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarImagen2();
				requestFocus();
			}
		});
		btn_agregar_imagen2.setFont(new Font("Arial", Font.BOLD, 12));
		btn_agregar_imagen2.setBounds(653, 396, 182, 34);
		contentPane.add(btn_agregar_imagen2);
		
		JButton btnNewButton = new JButton("INGRESAR TELA");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(54, 458, 131, 31);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//CONDICONAL PARA REVISAR SI EL MATERIAL A INGRESADO CORRECTAMENTE
				if(!"".equals(txt_codigo_rollo.getText()) && !"".equals(txt_nombre_tela.getText()) && !"".equals(txt_proveedor.getText()) && !"".equals(txt_peso.getText())
				&& !"".equals(txt_caracteristicas.getText())) {
					Registrar_Entrada();
					JOptionPane.showMessageDialog(null, "MATERIAL AGREGADO CORRECTAMENTE");
					limpiar_campos();
					requestFocus();
				}else {
					JOptionPane.showMessageDialog(null, "ERROR, VERIFIQUE QUE TODOS LOS CAMPOS SE ENCUENTREN LLENOS");
				}
				
			}
		});
		
		contentPane.add(btnNewButton);
		
		JButton btnLimpiarCampos = new JButton("LIMPIAR CAMPOS");
		btnLimpiarCampos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiarCampos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnLimpiarCampos.setFont(new Font("Arial", Font.BOLD, 12));
		btnLimpiarCampos.setBounds(222, 458, 171, 31);
		
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			limpiar_campos();
			requestFocus();
				
			}
		});
		contentPane.add(btnLimpiarCampos);
		
		JButton btnMenuPrincipal_1 = new JButton("MENU PRINCIPAL");
		btnMenuPrincipal_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMenuPrincipal_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
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
		btnMenuPrincipal_1.setBounds(646, 458, 152, 31);
		contentPane.add(btnMenuPrincipal_1);
		
		JButton btnInventariDeEntradas_1 = new JButton("INVENTARIO DE ENTRADAS");
		btnInventariDeEntradas_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInventariDeEntradas_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnInventariDeEntradas_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		btnInventariDeEntradas_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnInventariDeEntradas_1.setBounds(422, 458, 191, 31);
		contentPane.add(btnInventariDeEntradas_1);
		
		JLabel lblEntradas = new JLabel("ENTRADAS");
		lblEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntradas.setFont(new Font("Arial", Font.BOLD, 16));
		lblEntradas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblEntradas.setBounds(10, 11, 825, 36);
		contentPane.add(lblEntradas);
		
		lbl_imagen1 = new JLabel("");
		lbl_imagen1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_imagen1.setBounds(454, 123, 182, 248);
		contentPane.add(lbl_imagen1);
		
		lbl_imagen2 = new JLabel("");
		lbl_imagen2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_imagen2.setBounds(653, 123, 182, 248);
		contentPane.add(lbl_imagen2);
		
		lbl_fecha = new JLabel("");
		lbl_fecha.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_fecha.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_fecha.setBounds(194, 328, 250, 43);
		contentPane.add(lbl_fecha);
		
		lbl_hora = new JLabel("");
		lbl_hora.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hora.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_hora.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_hora.setBounds(194, 387, 250, 43);
		contentPane.add(lbl_hora);
	}
	
	
	public void limpiar_campos() {
		txt_codigo_rollo.setText("");
		txt_nombre_tela.setText("");
		txt_proveedor.setText("");
		txt_peso.setText("");
		txt_caracteristicas.setText("");
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
	
	
	//METODO QUE SE ENCARGA DE LIMPIAR LAS TABLAS
    public void Limpiar() {
    for (int i = 0; i < modelo.getRowCount(); i++) {
    modelo.removeRow(i);
    i = i - 1;
    }
    }
  
	   public void Registrar_Entrada(){
		   e.setCodigo_Rollo(txt_codigo_rollo.getText());
	       e.setNombre_Tela(txt_nombre_tela.getText());
	       e.setProveedor(txt_proveedor.getText());
	       e.setPeso(txt_peso.getText());
	       e.setCaracteristicas(txt_caracteristicas.getText());
	       e.setFecha_Entrada(lbl_fecha.getText());
	       e.setHora_de_Entrada(lbl_hora.getText());
	       edao.registro_de_entradas_de_tela(e);
       }
	
	
	}
