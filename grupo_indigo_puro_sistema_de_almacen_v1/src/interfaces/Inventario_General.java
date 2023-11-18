package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import base_de_datos.Entradas;
import base_de_datos.Entradas_DAO;
import base_de_datos.Inventario;
import base_de_datos.Inventario_DAO;
import tablas.Tabla_Inventario_General;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JTextField;

public class Inventario_General extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txt_id;
	public static JTextField txt_codigo_rollo;
	public static JTextField txt_nombre_tela;
	public static JTextField txt_proveedor;
	public static JTextField txt_peso;
	public static JTextField txt_caracteristicas;
	public static JLabel lbl_fecha;
	public static JLabel lbl_hora;
	
	
	Inventario in = new Inventario();
	Inventario_DAO indao = new Inventario_DAO();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventario_General frame = new Inventario_General();
					frame.setVisible(true);
					frame.actualizar_Fecha();
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
	public Inventario_General() {
		setTitle("BASE DE DATOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inventario_General.class.getResource("/imagenes/bd.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 909, 545);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBaseDeDatos = new JLabel("INVENTARIO GENERAL");
		lblBaseDeDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaseDeDatos.setFont(new Font("Arial", Font.BOLD, 16));
		lblBaseDeDatos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblBaseDeDatos.setBounds(10, 11, 873, 44);
		contentPane.add(lblBaseDeDatos);
		
		JButton btn_menu_principal = new JButton("MENU PRINCIPAL");
		btn_menu_principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 13));
		btn_menu_principal.setBounds(698, 449, 185, 43);
		
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
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_id.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_id.setBounds(10, 66, 174, 43);
		contentPane.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.setHorizontalAlignment(SwingConstants.CENTER);
		txt_id.setFont(new Font("Arial", Font.BOLD, 13));
		txt_id.setEditable(false);
		txt_id.setColumns(10);
		txt_id.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_id.setBounds(194, 66, 95, 43);
		contentPane.add(txt_id);
		
		JLabel lblNewLabel_1 = new JLabel("CODIGO ROLLO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1.setBounds(10, 120, 174, 43);
		contentPane.add(lblNewLabel_1);
		
		txt_codigo_rollo = new JTextField();
		txt_codigo_rollo.setFont(new Font("Arial", Font.BOLD, 13));
		txt_codigo_rollo.setColumns(10);
		txt_codigo_rollo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_codigo_rollo.setBounds(194, 120, 288, 43);
		contentPane.add(txt_codigo_rollo);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_1.setBounds(10, 174, 174, 43);
		contentPane.add(lblNewLabel_1_1);
		
		txt_nombre_tela = new JTextField();
		txt_nombre_tela.setFont(new Font("Arial", Font.BOLD, 13));
		txt_nombre_tela.setColumns(10);
		txt_nombre_tela.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_nombre_tela.setBounds(194, 174, 288, 43);
		contentPane.add(txt_nombre_tela);
		
		JLabel lblNewLabel_1_2 = new JLabel("PROVEEDOR");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2.setBounds(10, 228, 174, 43);
		contentPane.add(lblNewLabel_1_2);
		
		txt_proveedor = new JTextField();
		txt_proveedor.setFont(new Font("Arial", Font.BOLD, 13));
		txt_proveedor.setColumns(10);
		txt_proveedor.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_proveedor.setBounds(194, 228, 288, 43);
		contentPane.add(txt_proveedor);
		
		JLabel lblNewLabel_1_3 = new JLabel("PESO");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_3.setBounds(10, 282, 174, 43);
		contentPane.add(lblNewLabel_1_3);
		
		txt_peso = new JTextField();
		txt_peso.setFont(new Font("Arial", Font.BOLD, 13));
		txt_peso.setColumns(10);
		txt_peso.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_peso.setBounds(194, 282, 288, 43);
		contentPane.add(txt_peso);
		
		JLabel lblNewLabel_1_5 = new JLabel("CARACTERISTICAS");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5.setBounds(10, 336, 174, 43);
		contentPane.add(lblNewLabel_1_5);
		
		txt_caracteristicas = new JTextField();
		txt_caracteristicas.setFont(new Font("Arial", Font.BOLD, 13));
		txt_caracteristicas.setColumns(10);
		txt_caracteristicas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_caracteristicas.setBounds(194, 336, 288, 43);
		contentPane.add(txt_caracteristicas);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("FECHA DE ENTRADA");
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5_1.setBounds(10, 390, 174, 43);
		contentPane.add(lblNewLabel_1_5_1);
		
		lbl_fecha = new JLabel("");
		lbl_fecha.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_fecha.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_fecha.setBounds(194, 390, 288, 43);
		contentPane.add(lbl_fecha);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("HORA DE ENTRADA");
		lblNewLabel_1_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5_2.setBounds(10, 449, 174, 43);
		contentPane.add(lblNewLabel_1_5_2);
		
		lbl_hora = new JLabel("");
		lbl_hora.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hora.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_hora.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_hora.setBounds(194, 449, 288, 43);
		contentPane.add(lbl_hora);
		
		JButton btn_ingresar = new JButton("INGRESAR MATERIAL");
		btn_ingresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//CONDICONAL PARA REVISAR SI EL MATERIAL A INGRESADO CORRECTAMENTE
				if(!"".equals(txt_codigo_rollo.getText()) && !"".equals(txt_nombre_tela.getText()) && !"".equals(txt_proveedor.getText()) && !"".equals(txt_peso.getText())
				&& !"".equals(txt_caracteristicas.getText())) {
					insertar_invetario();
					JOptionPane.showMessageDialog(null, "MATERIAL AGREGADO CORRECTAMENTE");
					limpiar_campos();
					requestFocus();
				}else {
					JOptionPane.showMessageDialog(null, "ERROR, VERIFIQUE QUE TODOS LOS CAMPOS SE ENCUENTREN LLENOS");
					requestFocus();
				}
				
			}
			
		});
		btn_ingresar.setFont(new Font("Arial", Font.BOLD, 12));
		btn_ingresar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_ingresar.setBounds(492, 120, 195, 43);
		contentPane.add(btn_ingresar);
		
		JButton btn_limpiar_campos = new JButton("LIMPIAR CAMPOS");
		btn_limpiar_campos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_limpiar_campos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar_campos();
				requestFocus();
			}
		});
		btn_limpiar_campos.setFont(new Font("Arial", Font.BOLD, 12));
		btn_limpiar_campos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_limpiar_campos.setBounds(697, 120, 186, 43);
		contentPane.add(btn_limpiar_campos);
		
		JButton btn_registro_de_entradas = new JButton("VER INVENTARIO GENERAL");
		btn_registro_de_entradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tabla_Inventario_General t = new Tabla_Inventario_General();
				t.setVisible(true);
				t.setLocationRelativeTo(null);
				t.Listar_Inventario();
				t.requestFocus();
				requestFocus();
			}
		});
		btn_registro_de_entradas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_registro_de_entradas.setFont(new Font("Arial", Font.BOLD, 12));
		btn_registro_de_entradas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_registro_de_entradas.setBounds(502, 282, 185, 43);
		contentPane.add(btn_registro_de_entradas);
		
		JButton btn_actualizar = new JButton("ACTUALIZAR");
		btn_actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		btn_actualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_actualizar.setFont(new Font("Arial", Font.BOLD, 12));
		btn_actualizar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_actualizar.setBounds(697, 282, 186, 43);
		contentPane.add(btn_actualizar);
		
		JButton btn_eliminar = new JButton("ELIMINAR REGISTRO");
		btn_eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		btn_eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_eliminar.setFont(new Font("Arial", Font.BOLD, 12));
		btn_eliminar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_eliminar.setBounds(502, 449, 186, 43);
		contentPane.add(btn_eliminar);
	}
	
	
	//METODO PARA LIMPIAR CAMPOS
	public void limpiar_campos() {
		txt_id.setText("");
		txt_codigo_rollo.setText("");
		txt_nombre_tela.setText("");
		txt_proveedor.setText("");
		txt_peso.setText("");
		txt_caracteristicas.setText("");
	}
	
	//REGISTRAR ENTRADA
	public void insertar_invetario(){
		   in.setCodigo_Rollo(txt_codigo_rollo.getText());
		   in.setNombre_Tela(txt_nombre_tela.getText());
		   in.setProveedor(txt_proveedor.getText());
		   in.setPeso_total(txt_peso.getText());
		   in.setCaracteristicas(txt_caracteristicas.getText());
		   in.setHora_de_Entrada(lbl_hora.getText());
		   in.setFecha_Entrada(lbl_fecha.getText());
	       indao.Insertar_Inventario_General(in);
    }
	
	
	//METODOS QUE SE ENCARGAN INICIAR EL RELOG Y LA FECHA EN LA QUE ENTRO EL MATERIAL
	public void actualizar_Fecha() {
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
}
