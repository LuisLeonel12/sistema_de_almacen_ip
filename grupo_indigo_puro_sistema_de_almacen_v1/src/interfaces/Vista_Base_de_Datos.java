package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Vista_Base_de_Datos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbl_base_de_datos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_Base_de_Datos frame = new Vista_Base_de_Datos();
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
	public Vista_Base_de_Datos() {
		setTitle("BASE DE DATOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vista_Base_de_Datos.class.getResource("/imagenes/bd.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 909, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBaseDeDatos = new JLabel("BASE DE DATOS GENERAL");
		lblBaseDeDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaseDeDatos.setFont(new Font("Arial", Font.BOLD, 16));
		lblBaseDeDatos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblBaseDeDatos.setBounds(181, 11, 532, 36);
		contentPane.add(lblBaseDeDatos);
		
		tbl_base_de_datos = new JTable();
		tbl_base_de_datos.setFillsViewportHeight(true);
		tbl_base_de_datos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tbl_base_de_datos.setBounds(10, 58, 873, 592);
		contentPane.add(tbl_base_de_datos);
		
		JButton btn_menu_principal = new JButton("MENU PRINCIPAL");
		btn_menu_principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 13));
		btn_menu_principal.setBounds(10, 11, 149, 36);
		
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
	}
}
