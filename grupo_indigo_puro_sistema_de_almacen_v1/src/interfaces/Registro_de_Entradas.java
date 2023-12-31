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
import java.util.Date;

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
import javax.swing.table.DefaultTableModel;

import base_de_datos.Entradas;
import base_de_datos.Entradas_DAO;
import tablas.Tabla_Registro_Entradas;

public class Registro_de_Entradas extends JFrame {

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

	//VARIABLES
	Entradas en = new Entradas();
	Entradas_DAO edao= new Entradas_DAO();
    DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Registro_de_Entradas frame = new Registro_de_Entradas();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.actualizarFecha();
					frame.actualizar_hora();
					frame.requestFocus();
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
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 899, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("CODIGO ROLLO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1.setBounds(10, 128, 174, 43);
		contentPane.add(lblNewLabel_1);

		txt_codigo_rollo = new JTextField();
		txt_codigo_rollo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_codigo_rollo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();
                if (!(c >= '0' && c <= '9')) {
                    e.consume(); // CONSUMIR EL EVENTO SI EL CARACTER NO ES ENTERO
                }

			}
		});
		txt_codigo_rollo.setFont(new Font("Arial", Font.BOLD, 13));
		txt_codigo_rollo.setColumns(10);
		txt_codigo_rollo.setBounds(194, 128, 288, 43);
		contentPane.add(txt_codigo_rollo);

		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_1.setBounds(10, 182, 174, 43);
		contentPane.add(lblNewLabel_1_1);

		txt_nombre_tela = new JTextField();
		txt_nombre_tela.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_nombre_tela.setFont(new Font("Arial", Font.BOLD, 13));
		txt_nombre_tela.setColumns(10);
		txt_nombre_tela.setBounds(194, 182, 288, 43);
		contentPane.add(txt_nombre_tela);

		JLabel lblNewLabel_1_2 = new JLabel("PROVEEDOR");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_2.setBounds(10, 236, 174, 43);
		contentPane.add(lblNewLabel_1_2);

		txt_proveedor = new JTextField();
		txt_proveedor.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_proveedor.setFont(new Font("Arial", Font.BOLD, 13));
		txt_proveedor.setColumns(10);
		txt_proveedor.setBounds(194, 236, 288, 43);
		contentPane.add(txt_proveedor);

		JLabel lblNewLabel_1_3 = new JLabel("PESO");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_3.setBounds(10, 290, 174, 43);
		contentPane.add(lblNewLabel_1_3);

		txt_peso = new JTextField();
		txt_peso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
                if (!(c >= '0' && c <= '9')) {
                    e.consume(); // CONSUMIR EL EVENTO SI EL CARACTER NO ES ENTERO
                }
			}
		});
		txt_peso.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_peso.setFont(new Font("Arial", Font.BOLD, 13));
		txt_peso.setColumns(10);
		txt_peso.setBounds(194, 290, 288, 43);
		contentPane.add(txt_peso);

		JLabel lblNewLabel_1_5 = new JLabel("CARACTERISTICAS");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5.setBounds(10, 344, 174, 43);
		contentPane.add(lblNewLabel_1_5);

		txt_caracteristicas = new JTextField();
		txt_caracteristicas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_caracteristicas.setFont(new Font("Arial", Font.BOLD, 13));
		txt_caracteristicas.setColumns(10);
		txt_caracteristicas.setBounds(194, 344, 288, 43);
		contentPane.add(txt_caracteristicas);

		JLabel lblNewLabel_1_5_1 = new JLabel("FECHA DE ENTRADA");
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5_1.setBounds(10, 398, 174, 43);
		contentPane.add(lblNewLabel_1_5_1);

		JLabel lblNewLabel_1_5_2 = new JLabel("HORA DE ENTRADA");
		lblNewLabel_1_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1_5_2.setBounds(10, 457, 174, 43);
		contentPane.add(lblNewLabel_1_5_2);

		JButton btn_ingresar = new JButton("INGRESAR ROLLO");
		btn_ingresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_ingresar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_ingresar.setFont(new Font("Arial", Font.BOLD, 12));
		btn_ingresar.setBounds(492, 128, 185, 43);

		btn_ingresar.addActionListener(new ActionListener() {
			@Override
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
					requestFocus();
				}

			}
		});

		contentPane.add(btn_ingresar);

		JButton btn_limpiar_campos = new JButton("LIMPIAR CAMPOS");
		btn_limpiar_campos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_limpiar_campos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_limpiar_campos.setFont(new Font("Arial", Font.BOLD, 12));
		btn_limpiar_campos.setBounds(687, 128, 186, 43);

		btn_limpiar_campos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			limpiar_campos();
			requestFocus();

			}
		});
		contentPane.add(btn_limpiar_campos);

		JButton btn_menu_principal = new JButton("MENU PRINCIPAL");
		btn_menu_principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
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
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 12));
		btn_menu_principal.setBounds(687, 457, 186, 43);
		contentPane.add(btn_menu_principal);

		JButton btn_registro_de_entradas = new JButton("VER REGISTRO DE ENTRADAS");
		btn_registro_de_entradas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_registro_de_entradas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_registro_de_entradas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Tabla_Registro_Entradas te = new Tabla_Registro_Entradas();
				te.setVisible(true);
				te.setLocationRelativeTo(null);
				te.requestFocus();
				//te.Listar_Registro_Entradas();
				requestFocus();
			}
		});
		btn_registro_de_entradas.setFont(new Font("Arial", Font.BOLD, 12));
		btn_registro_de_entradas.setBounds(492, 290, 185, 43);
		contentPane.add(btn_registro_de_entradas);

		JLabel lblEntradas = new JLabel("ENTRADAS");
		lblEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntradas.setFont(new Font("Arial", Font.BOLD, 16));
		lblEntradas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblEntradas.setBounds(10, 11, 863, 52);
		contentPane.add(lblEntradas);

		lbl_fecha = new JLabel("");
		lbl_fecha.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_fecha.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_fecha.setBounds(194, 398, 288, 43);
		contentPane.add(lbl_fecha);

		lbl_hora = new JLabel("");
		lbl_hora.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hora.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_hora.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_hora.setBounds(194, 457, 288, 43);
		contentPane.add(lbl_hora);

		JButton btn_actualizar = new JButton("ACTUALIZAR");
		btn_actualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				//CONDICONAL PARA REVISAR SI EL MATERIAL SE A ACTUALIZADO CORRECTAMENTE
				if(!"".equals(txt_id.getText())) {
					en.setId(Integer.parseInt(txt_id.getText()));
					en.setCodigo_Rollo(txt_codigo_rollo.getText());
				    en.setNombre_Tela(txt_nombre_tela.getText());
				    en.setProveedor(txt_proveedor.getText());
				    en.setPeso(txt_peso.getText());
				    en.setCaracteristicas(txt_caracteristicas.getText());
				    en.setFecha_Entrada(lbl_fecha.getText());
				    en.setHora_de_Entrada(lbl_hora.getText());
				    edao.actualizarEntradaTela(en);
				    JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO");
			    	limpiar_campos();
			    	requestFocus();
				}else {
					JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR REGISTRO");
					requestFocus();
				}
			}
		});
		btn_actualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_actualizar.setFont(new Font("Arial", Font.BOLD, 12));
		btn_actualizar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_actualizar.setBounds(687, 290, 186, 43);
		contentPane.add(btn_actualizar);

		JButton btn_eliminar = new JButton("ELIMINAR REGISTRO");
		btn_eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_eliminar.setFont(new Font("Arial", Font.BOLD, 12));
		btn_eliminar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_eliminar.setBounds(492, 457, 186, 43);

		btn_eliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(!"".equals(txt_id.getText())) {
					edao.eliminarEntradaTela(Integer.parseInt(txt_id.getText()));
					JOptionPane.showMessageDialog(null,"REGISTRO ELIMINADO CORRECTAMENTE");
					txt_id.setText("");
					limpiar_campos();
					requestFocus();
				}else {
					JOptionPane.showMessageDialog(null,"ERROR AL ELIMINAR EL REGISTRO");
					txt_id.setText("");
					requestFocus();
				}
			}
		});

		contentPane.add(btn_eliminar);

		JLabel lbl_id = new JLabel("ID");
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_id.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_id.setBounds(10, 74, 174, 43);
		contentPane.add(lbl_id);

		txt_id = new JTextField();
		txt_id.setEditable(false);
		txt_id.setHorizontalAlignment(SwingConstants.CENTER);
		txt_id.setFont(new Font("Arial", Font.BOLD, 13));
		txt_id.setColumns(10);
		txt_id.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txt_id.setBounds(194, 74, 95, 43);
		contentPane.add(txt_id);
	}


	public void limpiar_campos() {
		txt_codigo_rollo.setText("");
		txt_nombre_tela.setText("");
		txt_proveedor.setText("");
		txt_peso.setText("");
		txt_caracteristicas.setText("");
		txt_id.setText("");

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

	   public void Registrar_Entrada(){
		   en.setCodigo_Rollo(txt_codigo_rollo.getText());
	       en.setNombre_Tela(txt_nombre_tela.getText());
	       en.setProveedor(txt_proveedor.getText());
	       en.setPeso(txt_peso.getText());
	       en.setCaracteristicas(txt_caracteristicas.getText());
	       en.setFecha_Entrada(lbl_fecha.getText());
	       en.setHora_de_Entrada(lbl_hora.getText());
	       edao.registro_de_entradas_de_tela(en);
       }




	}
