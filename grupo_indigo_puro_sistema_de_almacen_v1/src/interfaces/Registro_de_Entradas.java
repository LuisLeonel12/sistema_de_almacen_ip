package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(15, 117, 192));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CODIGO TELA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(10, 53, 131, 36);
		contentPane.add(lblNewLabel_1);
		
		txt_codigo_tela = new JTextField();
		txt_codigo_tela.setFont(new Font("Arial", Font.BOLD, 11));
		txt_codigo_tela.setColumns(10);
		txt_codigo_tela.setBounds(152, 53, 180, 36);
		contentPane.add(txt_codigo_tela);
		
		JLabel lblNewLabel_2_1 = new JLabel("FOTOS DE TELA");
		lblNewLabel_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setBounds(342, 53, 361, 54);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1.setBounds(10, 100, 131, 36);
		contentPane.add(lblNewLabel_1_1);
		
		txt_nombre = new JTextField();
		txt_nombre.setFont(new Font("Arial", Font.BOLD, 11));
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(152, 100, 180, 36);
		contentPane.add(txt_nombre);
		
		JLabel lblNewLabel_1_2 = new JLabel("PROVEEDOR");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setBounds(10, 147, 131, 36);
		contentPane.add(lblNewLabel_1_2);
		
		txt_proveedor = new JTextField();
		txt_proveedor.setFont(new Font("Arial", Font.BOLD, 11));
		txt_proveedor.setColumns(10);
		txt_proveedor.setBounds(152, 147, 180, 36);
		contentPane.add(txt_proveedor);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3.setBounds(342, 118, 171, 252);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3_1.setBounds(532, 118, 171, 252);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("PESO");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setBounds(10, 194, 131, 36);
		contentPane.add(lblNewLabel_1_3);
		
		txt_peso = new JTextField();
		txt_peso.setFont(new Font("Arial", Font.BOLD, 11));
		txt_peso.setColumns(10);
		txt_peso.setBounds(152, 194, 180, 36);
		contentPane.add(txt_peso);
		
		JLabel lblNewLabel_1_4 = new JLabel("ANCHOS CORTABLES");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_4.setBounds(10, 241, 131, 36);
		contentPane.add(lblNewLabel_1_4);
		
		txt_anchos_cortables = new JTextField();
		txt_anchos_cortables.setFont(new Font("Arial", Font.BOLD, 11));
		txt_anchos_cortables.setColumns(10);
		txt_anchos_cortables.setBounds(152, 241, 180, 36);
		contentPane.add(txt_anchos_cortables);
		
		JLabel lblNewLabel_1_5 = new JLabel("CARACTERISTICAS");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5.setBounds(10, 288, 131, 36);
		contentPane.add(lblNewLabel_1_5);
		
		txt_caracteristicas = new JTextField();
		txt_caracteristicas.setFont(new Font("Arial", Font.BOLD, 11));
		txt_caracteristicas.setColumns(10);
		txt_caracteristicas.setBounds(152, 288, 180, 36);
		contentPane.add(txt_caracteristicas);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("FECHA DE ENTRADA");
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_5_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5_1.setBounds(10, 335, 131, 35);
		contentPane.add(lblNewLabel_1_5_1);
		
		txt_fecha_entrada = new JTextField();
		txt_fecha_entrada.setFont(new Font("Arial", Font.BOLD, 11));
		txt_fecha_entrada.setColumns(10);
		txt_fecha_entrada.setBounds(152, 335, 180, 35);
		contentPane.add(txt_fecha_entrada);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("HORA DE ENTRADA");
		lblNewLabel_1_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_5_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5_2.setBounds(10, 381, 131, 36);
		contentPane.add(lblNewLabel_1_5_2);
		
		txt_hora_entrada = new JTextField();
		txt_hora_entrada.setFont(new Font("Arial", Font.BOLD, 11));
		txt_hora_entrada.setColumns(10);
		txt_hora_entrada.setBounds(152, 381, 180, 36);
		contentPane.add(txt_hora_entrada);
		
		JButton btnAgregarImagenes = new JButton("AGREGAR IMAGENES");
		btnAgregarImagenes.setFont(new Font("Arial", Font.BOLD, 12));
		btnAgregarImagenes.setBounds(342, 383, 171, 34);
		contentPane.add(btnAgregarImagenes);
		
		JButton btnAgragarImagenes_1 = new JButton("AGREGAR IMAGENES");
		btnAgragarImagenes_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnAgragarImagenes_1.setBounds(532, 383, 171, 34);
		contentPane.add(btnAgragarImagenes_1);
		
		JButton btnNewButton = new JButton("INGRESAR TELA");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(10, 439, 131, 31);
		contentPane.add(btnNewButton);
		
		JButton btnLimpiarCampos = new JButton("LIMPIAR CAMPOS");
		btnLimpiarCampos.setFont(new Font("Arial", Font.BOLD, 12));
		btnLimpiarCampos.setBounds(152, 439, 171, 31);
		
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnLimpiarCampos);
		
		JButton btnMenuPrincipal_1 = new JButton("MENU PRINCIPAL");
		btnMenuPrincipal_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnMenuPrincipal_1.setBounds(551, 439, 152, 31);
		contentPane.add(btnMenuPrincipal_1);
		
		JButton btnInventariDeEntradas_1 = new JButton("INVENTARIO DE ENTRADAS");
		btnInventariDeEntradas_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnInventariDeEntradas_1.setBounds(342, 439, 191, 31);
		contentPane.add(btnInventariDeEntradas_1);
		
		JLabel lblEntradas = new JLabel("ENTRADAS");
		lblEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntradas.setFont(new Font("Arial", Font.BOLD, 16));
		lblEntradas.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEntradas.setBounds(10, 6, 693, 36);
		contentPane.add(lblEntradas);
	}

}
