package Componentes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Comp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comp frame = new Comp();
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
	public Comp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("FOTOS DE TELA");
		lblNewLabel_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_2_1.setBounds(10, 11, 381, 54);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lbl_imagen1 = new JLabel("");
		lbl_imagen1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_imagen1.setBounds(10, 76, 182, 248);
		contentPane.add(lbl_imagen1);
		
		JLabel lbl_imagen2 = new JLabel("");
		lbl_imagen2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_imagen2.setBounds(209, 76, 182, 248);
		contentPane.add(lbl_imagen2);
		
		JButton btn_agregar_imagen1 = new JButton("AGREGAR IMAGENES");
		btn_agregar_imagen1.setFont(new Font("Arial", Font.BOLD, 12));
		btn_agregar_imagen1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_agregar_imagen1.setBounds(10, 349, 182, 34);
		contentPane.add(btn_agregar_imagen1);
		
		JButton btn_agregar_imagen2 = new JButton("AGREGAR IMAGENES");
		btn_agregar_imagen2.setFont(new Font("Arial", Font.BOLD, 12));
		btn_agregar_imagen2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_agregar_imagen2.setBounds(209, 349, 182, 34);
		contentPane.add(btn_agregar_imagen2);
		
		JLabel lbl_racks = new JLabel("RACKS");
		lbl_racks.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_racks.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_racks.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_racks.setBounds(401, 120, 192, 30);
		contentPane.add(lbl_racks);
		
		JButton btn_racks = new JButton("");
		btn_racks.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_racks.setBounds(401, 11, 192, 108);
		contentPane.add(btn_racks);
		
		JButton btn_entrada = new JButton("");
		btn_entrada.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_entrada.setBounds(401, 179, 199, 139);
		contentPane.add(btn_entrada);
		
		JLabel lbl_entradas = new JLabel("ENTRADAS");
		lbl_entradas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_entradas.setForeground(Color.BLACK);
		lbl_entradas.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_entradas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_entradas.setBounds(401, 318, 199, 30);
		contentPane.add(lbl_entradas);
	}
}
