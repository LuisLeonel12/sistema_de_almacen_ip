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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

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
		setBounds(100, 100, 906, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("TONO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(10, 11, 131, 36);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 11));
		textField.setColumns(10);
		textField.setBounds(152, 11, 292, 36);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("DELTA L");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1.setBounds(10, 58, 131, 36);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.BOLD, 11));
		textField_1.setColumns(10);
		textField_1.setBounds(152, 58, 292, 36);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("DELTA B");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2.setBounds(10, 105, 131, 36);
		contentPane.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.BOLD, 11));
		textField_2.setColumns(10);
		textField_2.setBounds(152, 105, 292, 36);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("DELTA A");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_3.setBounds(10, 152, 131, 36);
		contentPane.add(lblNewLabel_1_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.BOLD, 11));
		textField_3.setColumns(10);
		textField_3.setBounds(152, 152, 292, 36);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("DEcmc");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_4.setBounds(10, 199, 131, 36);
		contentPane.add(lblNewLabel_1_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.BOLD, 11));
		textField_4.setColumns(10);
		textField_4.setBounds(152, 199, 292, 36);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1_5 = new JLabel(" ANCHO TOTAL");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5.setBounds(10, 246, 131, 85);
		contentPane.add(lblNewLabel_1_5);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.BOLD, 11));
		textField_5.setColumns(10);
		textField_5.setBounds(227, 246, 217, 36);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("LONGITUD");
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_5_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5_1.setBounds(10, 342, 131, 85);
		contentPane.add(lblNewLabel_1_5_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.BOLD, 11));
		textField_6.setColumns(10);
		textField_6.setBounds(227, 296, 217, 35);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Arial", Font.BOLD, 11));
		textField_7.setColumns(10);
		textField_7.setBounds(227, 342, 217, 36);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Arial", Font.BOLD, 11));
		textField_8.setColumns(10);
		textField_8.setBounds(227, 392, 217, 35);
		contentPane.add(textField_8);
		
		JLabel lblNewLabel_1_5_3 = new JLabel("CMS");
		lblNewLabel_1_5_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_5_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5_3.setBounds(152, 246, 65, 35);
		contentPane.add(lblNewLabel_1_5_3);
		
		JLabel lblNewLabel_1_5_3_1 = new JLabel("INCHES");
		lblNewLabel_1_5_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_3_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_5_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5_3_1.setBounds(152, 296, 65, 35);
		contentPane.add(lblNewLabel_1_5_3_1);
		
		JLabel lblNewLabel_1_5_3_2 = new JLabel("MTS");
		lblNewLabel_1_5_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_3_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_5_3_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5_3_2.setBounds(152, 342, 65, 35);
		contentPane.add(lblNewLabel_1_5_3_2);
		
		JLabel lblNewLabel_1_5_3_1_1 = new JLabel("YDS");
		lblNewLabel_1_5_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_3_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_5_3_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5_3_1_1.setBounds(152, 392, 65, 35);
		contentPane.add(lblNewLabel_1_5_3_1_1);
		
		JLabel lblNewLabel_1_5_1_1 = new JLabel("PESO");
		lblNewLabel_1_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_5_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5_1_1.setBounds(10, 438, 131, 85);
		contentPane.add(lblNewLabel_1_5_1_1);
		
		JLabel lblNewLabel_1_5_3_2_1 = new JLabel("KGS");
		lblNewLabel_1_5_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_3_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_5_3_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5_3_2_1.setBounds(152, 438, 65, 35);
		contentPane.add(lblNewLabel_1_5_3_2_1);
		
		JLabel lblNewLabel_1_5_3_1_1_1 = new JLabel("LBS");
		lblNewLabel_1_5_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_3_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_5_3_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_5_3_1_1_1.setBounds(152, 488, 65, 35);
		contentPane.add(lblNewLabel_1_5_3_1_1_1);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Arial", Font.BOLD, 11));
		textField_9.setColumns(10);
		textField_9.setBounds(227, 438, 217, 36);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Arial", Font.BOLD, 11));
		textField_10.setColumns(10);
		textField_10.setBounds(227, 488, 217, 35);
		contentPane.add(textField_10);
		
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
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 13));
		btn_menu_principal.setBounds(469, 11, 150, 36);
		contentPane.add(btn_menu_principal);
	}
}
