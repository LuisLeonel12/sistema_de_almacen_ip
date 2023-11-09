package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbl_fecha_actual;
	private JLabel lbl_tiempo;
	
	String hora,minutos,segundos;
    Thread hilo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Principal frame = new Menu_Principal();
					frame.setVisible(true);
					frame.actualizarFecha();
					frame.iniciarHiloActualizacionHora();
					frame.requestFocus();
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu_Principal() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu_Principal.class.getResource("/imagenes/casa.png")));
		setTitle("MENU PRINCIPAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_entrada = new JButton("");
		btn_entrada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_entrada.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/entradas.png")));
		btn_entrada.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_entrada.setBounds(22, 72, 173, 108);
		
		btn_entrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		contentPane.add(btn_entrada);
		
		JButton btn_salida = new JButton("");
		btn_salida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		btn_salida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_salida.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/salida.png")));
		btn_salida.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_salida.setBounds(261, 72, 173, 108);
		contentPane.add(btn_salida);
		
		JButton btn_racks = new JButton("");
		btn_racks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		btn_racks.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_racks.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/racks.png")));
		btn_racks.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_racks.setBounds(503, 72, 173, 108);
		contentPane.add(btn_racks);
		
		JButton btn_packing_list = new JButton("");
		btn_packing_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		btn_packing_list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_packing_list.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/packing_list.png")));
		btn_packing_list.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_packing_list.setBounds(22, 267, 173, 108);
		contentPane.add(btn_packing_list);
		
		lbl_tiempo = new JLabel("");
		lbl_tiempo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_tiempo.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_tiempo.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_tiempo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tiempo.setBounds(261, 367, 173, 30);
		contentPane.add(lbl_tiempo);
		
		lbl_fecha_actual = new JLabel("");
		lbl_fecha_actual.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_fecha_actual.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_actual.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_fecha_actual.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_fecha_actual.setBounds(261, 267, 173, 30);
		contentPane.add(lbl_fecha_actual);
		
		JLabel lblNewLabel = new JLabel("ENTRADAS");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setBounds(22, 181, 173, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblSalidas = new JLabel("SALIDAS");
		lblSalidas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSalidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidas.setFont(new Font("Arial", Font.BOLD, 12));
		lblSalidas.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSalidas.setBounds(261, 181, 173, 21);
		contentPane.add(lblSalidas);
		
		JLabel lblRacks = new JLabel("RACKS");
		lblRacks.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRacks.setHorizontalAlignment(SwingConstants.CENTER);
		lblRacks.setFont(new Font("Arial", Font.BOLD, 12));
		lblRacks.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRacks.setBounds(503, 181, 173, 21);
		contentPane.add(lblRacks);
		
		JLabel lblPackingList = new JLabel("PACKING LIST");
		lblPackingList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPackingList.setHorizontalAlignment(SwingConstants.CENTER);
		lblPackingList.setFont(new Font("Arial", Font.BOLD, 12));
		lblPackingList.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPackingList.setBounds(22, 376, 173, 21);
		contentPane.add(lblPackingList);
		
		JButton btn_entrada_1 = new JButton("");
		btn_entrada_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
			}
		});
		btn_entrada_1.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/base-de-datos.png")));
		btn_entrada_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_entrada_1.setBounds(503, 267, 173, 108);
		contentPane.add(btn_entrada_1);
		
		JLabel lblBaseDeDatos = new JLabel("BASE DE DATOS GENERAL");
		lblBaseDeDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaseDeDatos.setFont(new Font("Arial", Font.BOLD, 12));
		lblBaseDeDatos.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBaseDeDatos.setBounds(503, 376, 173, 21);
		contentPane.add(lblBaseDeDatos);
		
		JLabel lblMenuPrincipal = new JLabel("MENU PRINCIPAL");
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPrincipal.setFont(new Font("Arial", Font.BOLD, 16));
		lblMenuPrincipal.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMenuPrincipal.setBounds(22, 11, 654, 50);
		contentPane.add(lblMenuPrincipal);
	}
	
	
	private void actualizarFecha() {
        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Formatear la fecha como una cadena
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(fechaActual);

        // Actualizar el texto del JLabel
        lbl_fecha_actual.setText("Fecha actual: " + fechaFormateada);
    }
	
	
	private void iniciarHiloActualizacionHora() {
        Thread hilo = new Thread(() -> {
            while (true) {
                // Obtener la hora actual
                Date horaActual = new Date();

                // Formatear la hora como una cadena
                SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss a");
                String horaFormateada = formatoHora.format(horaActual);

                // Actualizar el texto del JLabel con la hora
                SwingUtilities.invokeLater(() -> {
                    lbl_tiempo.setText("Hora actual: " + horaFormateada);
                });

                // Dormir el hilo durante 1 segundo
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
