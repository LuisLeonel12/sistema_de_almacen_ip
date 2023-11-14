package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Racks extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Racks frame = new Racks();
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
	public Racks() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 897, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRacks = new JLabel("RACKS");
		lblRacks.setHorizontalAlignment(SwingConstants.CENTER);
		lblRacks.setFont(new Font("Arial", Font.BOLD, 16));
		lblRacks.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblRacks.setBounds(10, 11, 858, 36);
		contentPane.add(lblRacks);
		
		JButton btn_entrada = new JButton("");
		btn_entrada.setIcon(new ImageIcon(Racks.class.getResource("/imagenes/racks.png")));
		btn_entrada.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btn_entrada.setBounds(10, 78, 173, 108);
		
		btn_entrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rack_1 r1 = new Rack_1();
				r1.setVisible(true);
				r1.setLocationRelativeTo(null);
				dispose();
				requestFocus();
			}
		});
		
		contentPane.add(btn_entrada);
		
		JLabel lblRack = new JLabel("RACK 1");
		lblRack.setHorizontalAlignment(SwingConstants.CENTER);
		lblRack.setFont(new Font("Arial", Font.BOLD, 12));
		lblRack.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblRack.setBounds(10, 187, 173, 29);
		contentPane.add(lblRack);
		
		JButton btn_salida = new JButton("");
		btn_salida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		btn_salida.setIcon(new ImageIcon(Racks.class.getResource("/imagenes/racks.png")));
		btn_salida.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btn_salida.setBounds(230, 78, 173, 108);
		contentPane.add(btn_salida);
		
		JLabel lblRack_1 = new JLabel("RACK 2");
		lblRack_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRack_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblRack_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblRack_1.setBounds(230, 187, 173, 29);
		contentPane.add(lblRack_1);
		
		JButton btn_racks = new JButton("");
		btn_racks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		btn_racks.setIcon(new ImageIcon(Racks.class.getResource("/imagenes/racks.png")));
		btn_racks.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btn_racks.setBounds(467, 78, 173, 108);
		contentPane.add(btn_racks);
		
		JLabel lblRack_2 = new JLabel("RACK 3");
		lblRack_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRack_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblRack_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblRack_2.setBounds(467, 187, 173, 29);
		contentPane.add(lblRack_2);
		
		JButton btn_entrada_1 = new JButton("");
		btn_entrada_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		btn_entrada_1.setIcon(new ImageIcon(Racks.class.getResource("/imagenes/racks.png")));
		btn_entrada_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btn_entrada_1.setBounds(10, 251, 173, 108);
		contentPane.add(btn_entrada_1);
		
		JLabel lblRack_4 = new JLabel("RACK 5");
		lblRack_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblRack_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblRack_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblRack_4.setBounds(10, 360, 173, 29);
		contentPane.add(lblRack_4);
		
		JButton btn_packing_list = new JButton("");
		btn_packing_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		btn_packing_list.setIcon(new ImageIcon(Racks.class.getResource("/imagenes/racks.png")));
		btn_packing_list.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btn_packing_list.setBounds(695, 78, 173, 108);
		contentPane.add(btn_packing_list);
		
		JLabel lblRack_3 = new JLabel("RACK 4");
		lblRack_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblRack_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblRack_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblRack_3.setBounds(695, 187, 173, 29);
		contentPane.add(lblRack_3);
		
		JButton btn_entrada_1_1 = new JButton("");
		btn_entrada_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		btn_entrada_1_1.setIcon(new ImageIcon(Racks.class.getResource("/imagenes/racks.png")));
		btn_entrada_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btn_entrada_1_1.setBounds(230, 251, 173, 108);
		contentPane.add(btn_entrada_1_1);
		
		JLabel lblRack_4_1 = new JLabel("RACK 6");
		lblRack_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRack_4_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblRack_4_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblRack_4_1.setBounds(230, 360, 173, 29);
		contentPane.add(lblRack_4_1);
		
		JButton btn_entrada_1_2 = new JButton("");
		btn_entrada_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		btn_entrada_1_2.setIcon(new ImageIcon(Racks.class.getResource("/imagenes/racks.png")));
		btn_entrada_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_entrada_1_2.setBounds(464, 251, 173, 108);
		contentPane.add(btn_entrada_1_2);
		
		JLabel lblRack_4_2 = new JLabel("RACK 7");
		lblRack_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRack_4_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblRack_4_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblRack_4_2.setBounds(464, 360, 173, 29);
		contentPane.add(lblRack_4_2);
		
		JButton btn_entrada_1_1_1 = new JButton("");
		btn_entrada_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		btn_entrada_1_1_1.setIcon(new ImageIcon(Racks.class.getResource("/imagenes/racks.png")));
		btn_entrada_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btn_entrada_1_1_1.setBounds(695, 251, 173, 108);
		contentPane.add(btn_entrada_1_1_1);
		
		JLabel lblRack_4_1_1 = new JLabel("RACK 8");
		lblRack_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRack_4_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblRack_4_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblRack_4_1_1.setBounds(695, 360, 173, 29);
		contentPane.add(lblRack_4_1_1);
		
		JButton btn_menu_principal = new JButton("MENU PRINCIPAL");
		btn_menu_principal.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 13));
		btn_menu_principal.setBounds(365, 409, 149, 36);
		
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
