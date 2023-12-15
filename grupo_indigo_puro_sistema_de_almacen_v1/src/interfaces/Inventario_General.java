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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import base_de_datos.Inventario;
import base_de_datos.Inventario_DAO;
import tablas.Tabla_Inventario_General;
import javax.swing.ImageIcon;

public class Inventario_General extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txt_id;
	public static JTextField txt_codigo_rollo;
	public static JTextField txt_nombre_tela;
	public static JTextField txt_proveedor;
	public static JTextField txt_peso;
	public static JTextField txt_caracteristicas;
	public static JTextField txt_metros;
	public static JTextField txt_estilo;
	public static JTextField txt_ancho;
	public JDateChooser txt_fecha;
	private JLabel lbl_hora;

	Inventario in = new Inventario();
	Inventario_DAO indao = new Inventario_DAO();
	public static JTextField txt_ubicacion;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Inventario_General frame = new Inventario_General();
					frame.requestFocus();
					frame.setVisible(true);
					frame.actualizar_hora();
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
	public Inventario_General() {
		setResizable(false);
		setTitle("INVENTARIO GENERAL");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inventario_General.class.getResource("/imagenes/bd.png")));
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1029, 653);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBaseDeDatos = new JLabel("INVENTARIO GENERAL");
		lblBaseDeDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaseDeDatos.setFont(new Font("Arial", Font.BOLD, 20));
		lblBaseDeDatos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblBaseDeDatos.setBounds(10, 11, 990, 43);
		contentPane.add(lblBaseDeDatos);

		JButton btn_menu_principal = new JButton("MENU PRINCIPAL");
		btn_menu_principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 13));
		btn_menu_principal.setBounds(808, 390, 192, 43);

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

		JLabel lbl_id = new JLabel("ID");
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_id.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_id.setBounds(10, 66, 98, 43);
		contentPane.add(lbl_id);

		txt_id = new JTextField();
		txt_id.setHorizontalAlignment(SwingConstants.CENTER);
		txt_id.setFont(new Font("Arial", Font.BOLD, 13));
		txt_id.setEditable(false);
		txt_id.setColumns(10);
		txt_id.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_id.setBounds(118, 66, 174, 43);
		contentPane.add(txt_id);

		JLabel lblNewLabel_1 = new JLabel("CODIGO ROLLO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1.setBounds(10, 120, 220, 43);
		contentPane.add(lblNewLabel_1);

		txt_codigo_rollo = new JTextField();
		txt_codigo_rollo.setToolTipText("");
		txt_codigo_rollo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				// VERIFICAR SI LA LONGITUD DEL TEXTO ES MAYOR O IGUAL A 10
				if (txt_codigo_rollo.getText().length() >= 15) {
				    e.consume(); // CONSUMIR EL EVENTO SI LA LONGITUD ES 10 O MÁS
				} else {
				    // PERMITIR SOLO NÚMEROS
				    if (!(c >= '0' && c <= '9')) {
				        e.consume(); // CONSUMIR EL EVENTO SI NO ES UN NÚMERO
				    }
				}
			}
		});
		txt_codigo_rollo.setFont(new Font("Arial", Font.BOLD, 13));
		txt_codigo_rollo.setColumns(10);
		txt_codigo_rollo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_codigo_rollo.setBounds(240, 120, 307, 43);
		contentPane.add(txt_codigo_rollo);

		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE DE TELA");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_1.setBounds(10, 174, 220, 43);
		contentPane.add(lblNewLabel_1_1);

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
		txt_nombre_tela.setBounds(240, 174, 307, 43);
		contentPane.add(txt_nombre_tela);

		JLabel lblNewLabel_1_2 = new JLabel("PROVEEDOR");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2.setBounds(10, 228, 220, 43);
		contentPane.add(lblNewLabel_1_2);

		txt_proveedor = new JTextField();
		txt_proveedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt_proveedor.getText().length() >= 25)
			    {
			        e.consume();
			    }
			}
		});
		txt_proveedor.setFont(new Font("Arial", Font.BOLD, 13));
		txt_proveedor.setColumns(10);
		txt_proveedor.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_proveedor.setBounds(240, 228, 307, 43);
		contentPane.add(txt_proveedor);

		JLabel lblNewLabel_1_3 = new JLabel("KILOS");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_3.setBounds(10, 282, 220, 43);
		contentPane.add(lblNewLabel_1_3);

		txt_peso = new JTextField();
		txt_peso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if (txt_peso.getText().length() >= 15) {
				    e.consume();
				} else {
				    // VERIFICAR SI EL CARÁCTER ES UN NÚMERO O UN PUNTO
				    if ((c >= '0' && c <= '9') || c == '.') {
				        // VERIFICAR SI EL PUNTO YA ESTÁ PRESENTE EN EL TEXTO
				        if (c == '.' && txt_peso.getText().contains(".")) {
				            e.consume(); // CONSUMIR EL EVENTO SI YA HAY UN PUNTO
				        }
				    } else {
				        e.consume(); // CONSUMIR EL EVENTO SI NO ES UN NÚMERO O UN PUNTO
				    }
				}
				}
		});
		txt_peso.setFont(new Font("Arial", Font.BOLD, 13));
		txt_peso.setColumns(10);
		txt_peso.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_peso.setBounds(240, 282, 307, 43);
		contentPane.add(txt_peso);

		JLabel lblNewLabel_1_5 = new JLabel("COMPOSICION");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5.setBounds(10, 498, 220, 43);
		contentPane.add(lblNewLabel_1_5);

		txt_caracteristicas = new JTextField();
		txt_caracteristicas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt_caracteristicas.getText().length() >= 40)
			    {
			        e.consume();
			    }
			}
		});
		txt_caracteristicas.setFont(new Font("Arial", Font.BOLD, 13));
		txt_caracteristicas.setColumns(10);
		txt_caracteristicas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_caracteristicas.setBounds(240, 498, 307, 43);
		contentPane.add(txt_caracteristicas);

		JButton btn_ingresar = new JButton("INGRESAR MATERIAL");
		btn_ingresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_ingresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// CONDICIONAL PARA REVISAR SI EL MATERIAL HA SIDO INGRESADO CORRECTAMENTE
				if (!"".equals(txt_codigo_rollo.getText()) && !"".equals(txt_nombre_tela.getText())
				        && !"".equals(txt_proveedor.getText()) && !"".equals(txt_peso.getText())
				        && !"".equals(txt_caracteristicas.getText()) && !"".equals(txt_ancho.getText())
				        && !"".equals(txt_estilo.getText()) && !"".equals(txt_metros.getText())
				        && !"".equals(txt_ancho.getText()) && !"".equals(txt_ubicacion.getText()) ) {

				    // VERIFICAR SI EL CAMPO TXT_ID ESTÁ LLENO
				    if (!"".equals(txt_id.getText())) {
				        JOptionPane.showMessageDialog(null, "ERROR, YA EXISTE UN REGISTRO CON ESE ID EN LA BASE DE DATOS");
				        limpiar_campos();
				        requestFocus();
				    } else {
				        // VERIFICAR SI EL CÓDIGO DE ROLLO YA EXISTE EN LA BASE DE DATOS
				        if (indao.codigoRolloExiste(txt_codigo_rollo.getText())) {
				            JOptionPane.showMessageDialog(null, "ERROR, YA EXISTE UN REGISTRO CON ESE CÓDIGO DE ROLLO EN LA BASE DE DATOS");
				            limpiar_campos();
				            requestFocus();
				        } else {

				            insertar_inventario();
				            JOptionPane.showMessageDialog(null, "MATERIAL AGREGADO CORRECTAMENTE");
				            limpiar_campos();
				            requestFocus();
				        }
				    }
				} else {
				    JOptionPane.showMessageDialog(null, "ERROR, VERIFIQUE QUE TODOS LOS CAMPOS SE ENCUENTREN LLENOS");
				    requestFocus();
				}
			 }

		});
		btn_ingresar.setFont(new Font("Arial", Font.BOLD, 13));
		btn_ingresar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_ingresar.setBounds(575, 174, 192, 43);
		contentPane.add(btn_ingresar);

		JButton btn_limpiar_campos = new JButton("LIMPIAR CAMPOS");
		btn_limpiar_campos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_limpiar_campos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiar_campos();
				requestFocus();
			}
		});
		btn_limpiar_campos.setFont(new Font("Arial", Font.BOLD, 13));
		btn_limpiar_campos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_limpiar_campos.setBounds(808, 174, 192, 43);
		contentPane.add(btn_limpiar_campos);

		JButton btn_registro_de_entradas = new JButton("VER INVENTARIO GENERAL");
		btn_registro_de_entradas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Tabla_Inventario_General t = new Tabla_Inventario_General();
				t.setVisible(true);
				t.setLocationRelativeTo(null);
				t.Listar_Inventario();
				t.requestFocus();
				requestFocus();
				dispose();

			}
		});
		btn_registro_de_entradas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_registro_de_entradas.setFont(new Font("Arial", Font.BOLD, 13));
		btn_registro_de_entradas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_registro_de_entradas.setBounds(575, 282, 192, 43);
		contentPane.add(btn_registro_de_entradas);

		JButton btn_actualizar = new JButton("ACTUALIZAR");
		btn_actualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				//CONDICONAL PARA REVISAR SI EL MATERIAL SE A ACTUALIZADO CORRECTAMENTE
				if(!"".equals(txt_id.getText())) {
					in.setId(Integer.parseInt(txt_id.getText()));
					in.setCodigo_Rollo(txt_codigo_rollo.getText());
				    in.setNombre_Tela(txt_nombre_tela.getText());
				    in.setProveedor(txt_proveedor.getText());
				    in.setPeso_total(txt_peso.getText());
				    in.setMetros(Double.parseDouble(txt_metros.getText()));
				    in.setEstilo(txt_estilo.getText());
				    in.setAncho(txt_ancho.getText());
				    in.setCaracteristicas(txt_caracteristicas.getText());
				    in.setUbicacion(txt_ubicacion.getText());
				    indao.Actualizar_Inventario_General(in);
				    JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO");
			    	limpiar_campos();
			    	requestFocus();
				}else {
					JOptionPane.showMessageDialog(null, "ERROR, DEBE SELECCIONAR UN REGISTRO DE LA TABLA");
					requestFocus();
				}

			}
		});
		btn_actualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_actualizar.setFont(new Font("Arial", Font.BOLD, 13));
		btn_actualizar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_actualizar.setBounds(808, 282, 192, 43);
		contentPane.add(btn_actualizar);

		JButton btn_eliminar = new JButton("ELIMINAR ROLLO");
		btn_eliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				if (!"".equals(txt_id.getText())) {
				    // PREGUNTA AL USUARIO SI REALMENTE QUIERE ELIMINAR EL REGISTRO
				    Object[] options = {"Sí", "No"};
				    int confirmacion = JOptionPane.showOptionDialog(
				            null,
				            "¿Estás seguro de que deseas eliminar este registro?",
				            "Confirmar eliminación",
				            JOptionPane.YES_NO_OPTION,
				            JOptionPane.QUESTION_MESSAGE,
				            null,
				            options,
				            options[1]);  // ESTABLECE EL FOCO EN EL BOTÓN "NO"

				    if (confirmacion == JOptionPane.YES_OPTION) {
				        // SI EL USUARIO CONFIRMA, PROCEDE CON LA ELIMINACIÓN
				        indao.Eliminar_Inventario_General(Integer.parseInt(txt_id.getText()));
				        JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CORRECTAMENTE");
				        txt_id.setText("");
				        limpiar_campos();
				        requestFocus();
				    } else {
				        // SI EL USUARIO CANCELA, MUESTRA UN MENSAJE Y NO REALIZA LA ELIMINACIÓN
				        JOptionPane.showMessageDialog(null, "ELIMINACIÓN CANCELADA POR EL USUARIO");
				        txt_id.setText("");
				        limpiar_campos();
				        requestFocus();
				    }
				} else {
				    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO DE LA TABLA");
				    txt_id.setText("");
				    limpiar_campos();
				    requestFocus();
				}

			}
		});
		btn_eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_eliminar.setFont(new Font("Arial", Font.BOLD, 13));
		btn_eliminar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_eliminar.setBounds(575, 390, 192, 43);
		contentPane.add(btn_eliminar);

		JLabel lblNewLabel_1_3_1 = new JLabel("METROS");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_3_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_3_1.setBounds(10, 336, 220, 43);
		contentPane.add(lblNewLabel_1_3_1);

		txt_metros = new JTextField();
		txt_metros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (txt_metros.getText().length() >= 15) {
                    e.consume();
                } else {
                    // VERIFICAR SI EL CARÁCTER ES UN NÚMERO O UN PUNTO
                    if ((c >= '0' && c <= '9') || c == '.') {
                        // VERIFICAR SI EL PUNTO YA ESTÁ PRESENTE EN EL TEXTO
                        if (c == '.' && txt_metros.getText().contains(".")) {
                            e.consume(); // CONSUMIR EL EVENTO SI YA HAY UN PUNTO
                        }
                    } else {
                        e.consume(); // CONSUMIR EL EVENTO SI NO ES UN NÚMERO O UN PUNTO
                    }
                }
			}
		});
		txt_metros.setFont(new Font("Arial", Font.BOLD, 13));
		txt_metros.setColumns(10);
		txt_metros.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_metros.setBounds(240, 336, 307, 43);
		contentPane.add(txt_metros);

		JLabel lblNewLabel_1_3_2 = new JLabel("CLASIFICACION");
		lblNewLabel_1_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_3_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_3_2.setBounds(10, 390, 220, 43);
		contentPane.add(lblNewLabel_1_3_2);

		txt_estilo = new JTextField();
		txt_estilo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt_estilo.getText().length() >= 15)
			    {
			        e.consume();
			    }
			}
		});
		txt_estilo.setFont(new Font("Arial", Font.BOLD, 13));
		txt_estilo.setColumns(10);
		txt_estilo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_estilo.setBounds(240, 390, 307, 43);
		contentPane.add(txt_estilo);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("ANCHO");
		lblNewLabel_1_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_3_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_3_1_1.setBounds(10, 444, 220, 43);
		contentPane.add(lblNewLabel_1_3_1_1);

		txt_ancho = new JTextField();
		txt_ancho.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (txt_ancho.getText().length() >= 15) {
                    e.consume();
                } else {
                    // VERIFICAR SI EL CARÁCTER ES UN NÚMERO O UN PUNTO
                    if ((c >= '0' && c <= '9') || c == '.') {
                        // VERIFICAR SI EL PUNTO YA ESTÁ PRESENTE EN EL TEXTO
                        if (c == '.' && txt_ancho.getText().contains(".")) {
                            e.consume(); // CONSUMIR EL EVENTO SI YA HAY UN PUNTO
                        }
                    } else {
                        e.consume(); // CONSUMIR EL EVENTO SI NO ES UN NÚMERO O UN PUNTO
                    }
                }
			}
		});
		txt_ancho.setFont(new Font("Arial", Font.BOLD, 13));
		txt_ancho.setColumns(10);
		txt_ancho.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_ancho.setBounds(240, 444, 307, 43);
		contentPane.add(txt_ancho);

		JLabel lblNewLabel_1_5_1 = new JLabel("FECHA DE ENTRADA");
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_5_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5_1.setBounds(656, 65, 172, 43);
		contentPane.add(lblNewLabel_1_5_1);

		JLabel lblNewLabel_1_5_2 = new JLabel("HORA DE ENTRADA");
		lblNewLabel_1_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_5_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5_2.setBounds(302, 65, 174, 43);
		contentPane.add(lblNewLabel_1_5_2);

		lbl_hora = new JLabel("");
		lbl_hora.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hora.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_hora.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_hora.setBounds(484, 65, 162, 43);
		contentPane.add(lbl_hora);
		
		JLabel lblNewLabel_1_5_3 = new JLabel("UBICACION");
		lblNewLabel_1_5_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_5_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5_3.setBounds(10, 552, 220, 43);
		contentPane.add(lblNewLabel_1_5_3);
		
		txt_ubicacion = new JTextField();
		txt_ubicacion.setFont(new Font("Arial", Font.BOLD, 13));
		txt_ubicacion.setColumns(10);
		txt_ubicacion.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_ubicacion.setBounds(240, 552, 307, 43);
		contentPane.add(txt_ubicacion);
		
		txt_fecha = new JDateChooser();
		txt_fecha.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txt_fecha.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_fecha.setFont(new Font("Arial", Font.BOLD, 20));
		txt_fecha.setDateFormatString("dd/MM/yyyy");
		JTextField dateTextField = ((JTextField) txt_fecha.getDateEditor().getUiComponent());
		dateTextField.setHorizontalAlignment(JTextField.CENTER);
		txt_fecha.setDate(Calendar.getInstance().getTime());
		txt_fecha.setBounds(838, 65, 162, 43);
		contentPane.add(txt_fecha);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Inventario_General.class.getResource("/imagenes/logogip.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(575, 444, 425, 151);
		contentPane.add(lblNewLabel);
	}

	//METODO PARA LIMPIAR CAMPOS
	public void limpiar_campos() {
		txt_id.setText("");
		txt_codigo_rollo.setText("");
		txt_nombre_tela.setText("");
		txt_proveedor.setText("");
		txt_peso.setText("");
		txt_metros.setText("");
		txt_estilo.setText("");
		txt_ancho.setText("");
		txt_caracteristicas.setText("");
		txt_ubicacion.setText("");
	}

	//REGISTRAR ENTRADA
	public void insertar_inventario() {
	    in.setCodigo_Rollo(txt_codigo_rollo.getText());
	    in.setNombre_Tela(txt_nombre_tela.getText());
	    in.setProveedor(txt_proveedor.getText());
	    in.setPeso_total(txt_peso.getText());
	    in.setMetros(Double.parseDouble(txt_metros.getText()));
	    in.setEstilo(txt_estilo.getText());
	    in.setAncho(txt_ancho.getText());
	    in.setCaracteristicas(txt_caracteristicas.getText());
	    in.setUbicacion(txt_ubicacion.getText());
	    in.setHora_de_Entrada(lbl_hora.getText());
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    String fechaFormateada = dateFormat.format(txt_fecha.getDate());
	    in.setFecha_Entrada(fechaFormateada);

	    indao.Insertar_Inventario_General(in);
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
}
