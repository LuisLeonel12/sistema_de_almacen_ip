package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class Rack_2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rack_2 frame = new Rack_2();
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
	public Rack_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_menu_principal = new JButton("MENU PRINCIPAL");
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 13));
		btn_menu_principal.setBounds(10, 11, 149, 36);
		contentPane.add(btn_menu_principal);
		
		JLabel lblRack = new JLabel("RACK 1");
		lblRack.setHorizontalAlignment(SwingConstants.CENTER);
		lblRack.setFont(new Font("Arial", Font.BOLD, 16));
		lblRack.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRack.setBounds(181, 11, 532, 36);
		contentPane.add(lblRack);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(10, 58, 873, 592);
		contentPane.add(table);
	}

}
