package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Packing_List extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_nombre_tela;
	private JTextField txt_modelo;
	private JTextField textField_2;
	private JTextField textField_11;
	private JTextField textField_14;
	private JTextField textField_17;
	private JTextField textField_21;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Packing_List frame = new Packing_List();
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
	public Packing_List() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Packing_List.class.getResource("/imagenes/lista.png")));
		setTitle("PACKING LIST");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 930, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("TELA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(10, 11, 150, 36);
		contentPane.add(lblNewLabel_1);
		
		txt_nombre_tela = new JTextField();
		txt_nombre_tela.setFont(new Font("Arial", Font.BOLD, 11));
		txt_nombre_tela.setColumns(10);
		txt_nombre_tela.setBounds(175, 11, 269, 36);
		contentPane.add(txt_nombre_tela);
		
		JLabel lblNewLabel_1_1 = new JLabel("MODELO");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1.setBounds(10, 58, 150, 36);
		contentPane.add(lblNewLabel_1_1);
		
		txt_modelo = new JTextField();
		txt_modelo.setFont(new Font("Arial", Font.BOLD, 11));
		txt_modelo.setColumns(10);
		txt_modelo.setBounds(175, 59, 269, 36);
		contentPane.add(txt_modelo);
		
		JLabel lblNewLabel_1_2 = new JLabel("PIEZAS SOLICITADAS");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setBounds(466, 12, 172, 36);
		contentPane.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.BOLD, 11));
		textField_2.setColumns(10);
		textField_2.setBounds(648, 12, 251, 36);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("CONSUMO");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setBounds(466, 58, 172, 36);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("METROS SOLICITADOS");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_4.setBounds(10, 105, 150, 36);
		contentPane.add(lblNewLabel_1_4);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Arial", Font.BOLD, 11));
		textField_11.setColumns(10);
		textField_11.setBounds(648, 58, 251, 36);
		contentPane.add(textField_11);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("POQUETIN");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3_1.setBounds(466, 105, 172, 36);
		contentPane.add(lblNewLabel_1_3_1);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Arial", Font.BOLD, 11));
		textField_14.setColumns(10);
		textField_14.setBounds(648, 105, 251, 36);
		contentPane.add(textField_14);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Arial", Font.BOLD, 11));
		textField_17.setColumns(10);
		textField_17.setBounds(175, 106, 269, 36);
		contentPane.add(textField_17);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("POQUETIN SOLICITADOS");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2_1.setBounds(10, 152, 150, 36);
		contentPane.add(lblNewLabel_1_2_1);
		
		textField_21 = new JTextField();
		textField_21.setFont(new Font("Arial", Font.BOLD, 11));
		textField_21.setColumns(10);
		textField_21.setBounds(175, 152, 269, 36);
		contentPane.add(textField_21);
		
		JButton btn_menu_principal = new JButton("MENU PRINCIPAL");
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
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 12));
		btn_menu_principal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal.setBounds(10, 323, 186, 43);
		contentPane.add(btn_menu_principal);
	}
}
