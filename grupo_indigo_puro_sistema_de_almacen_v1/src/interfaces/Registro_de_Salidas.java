package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;

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
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro_de_Salidas frame = new Registro_de_Salidas();
					frame.setVisible(true);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 390);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(15, 117, 192));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SALIDAS");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(165, 11, 382, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CODIGO TELA");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 59, 131, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE");
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 97, 131, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("PROVEEDOR");
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(10, 133, 131, 25);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("PESO");
		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(10, 169, 131, 25);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("ANCHOS CORTABLES");
		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(10, 205, 131, 25);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("CARACTERISTICAS");
		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_5.setBounds(10, 241, 131, 25);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("FECHA DE SALIDA");
		lblNewLabel_1_5_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_5_1.setBounds(10, 277, 131, 25);
		contentPane.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("HORA DE SALIDA");
		lblNewLabel_1_5_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_5_2.setBounds(10, 313, 131, 25);
		contentPane.add(lblNewLabel_1_5_2);
		
		textField = new JTextField();
		textField.setBounds(152, 59, 180, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(152, 97, 180, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(152, 133, 180, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(152, 169, 180, 25);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(152, 205, 180, 25);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(152, 241, 180, 25);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(152, 277, 180, 25);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(152, 313, 180, 25);
		contentPane.add(textField_7);
		
		JLabel lblNewLabel_2 = new JLabel("NOMBRE DE USUARIO");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(342, 59, 162, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3.setBounds(342, 97, 361, 241);
		contentPane.add(lblNewLabel_3);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(514, 59, 189, 25);
		contentPane.add(textField_8);
	}
}
