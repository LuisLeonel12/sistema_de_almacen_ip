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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Menu_Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbl_fecha_actual;
	private JLabel lbl_hora_actual;
	
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu_Principal.class.getResource("/imagenes/casa.png")));
		setTitle("MENU PRINCIPAL");
		setBounds(100, 100, 861, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
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
				
				Registro_de_Entradas re = new Registro_de_Entradas();
				re.setVisible(true);
				re.setLocationRelativeTo(null);
				re.requestFocus();
				re.actualizar_hora();
				re.actualizarFecha();
				dispose();
				
			}
		});
		contentPane.add(btn_entrada);
		
		JButton btn_salida = new JButton("");
		btn_salida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro_de_Salidas rs = new Registro_de_Salidas();
				rs.setLocationRelativeTo(null);
				rs.setVisible(true);
				rs.requestFocus();
				dispose();
			}
		});
		btn_salida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_salida.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/salida.png")));
		btn_salida.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_salida.setBounds(314, 72, 198, 108);
		contentPane.add(btn_salida);
		
		JButton btn_racks = new JButton("");
		btn_racks.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_racks.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/racks.png")));
		btn_racks.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_racks.setBounds(628, 72, 192, 108);
		
		btn_racks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Racks r = new Racks();
				r.setVisible(true);
				r.setLocationRelativeTo(null);
				r.requestFocus();
				dispose();
			}
		});
		
		contentPane.add(btn_racks);
		
		JButton btn_packing_list = new JButton("");
		btn_packing_list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_packing_list.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/packing_list.png")));
		btn_packing_list.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_packing_list.setBounds(22, 267, 173, 108);
		
		btn_packing_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Packing_List pk = new Packing_List();
				pk.setVisible(true);
				pk.setLocationRelativeTo(null);
				pk.requestFocus();
				dispose();
				
			}
		});
		
		contentPane.add(btn_packing_list);
		
		lbl_hora_actual = new JLabel("");
		lbl_hora_actual.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_hora_actual.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_hora_actual.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_hora_actual.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hora_actual.setBounds(314, 356, 198, 50);
		contentPane.add(lbl_hora_actual);
		
		lbl_fecha_actual = new JLabel("");
		lbl_fecha_actual.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_fecha_actual.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_actual.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_fecha_actual.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_fecha_actual.setBounds(314, 267, 198, 50);
		contentPane.add(lbl_fecha_actual);
		
		JLabel lbl_entradas = new JLabel("ENTRADAS");
		lbl_entradas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_entradas.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_entradas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_entradas.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_entradas.setBounds(22, 181, 173, 30);
		
		lbl_entradas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registro_de_Entradas re = new Registro_de_Entradas();
				re.setVisible(true);
				re.setLocationRelativeTo(null);
				re.actualizar_hora();
				re.actualizarFecha();
				re.requestFocus();
				dispose();
			}
		});
		
		contentPane.add(lbl_entradas);
		
		JLabel lbl_salidas = new JLabel("SALIDAS");
		lbl_salidas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_salidas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_salidas.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_salidas.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lbl_salidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registro_de_Salidas rs = new Registro_de_Salidas();
				rs.setVisible(true);
				rs.setLocationRelativeTo(null);
				dispose();
				rs.requestFocus();
			}
		});
		
		lbl_salidas.setBounds(314, 181, 198, 30);

		
		contentPane.add(lbl_salidas);
		
		JLabel lbl_racks = new JLabel("RACKS");
		lbl_racks.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_racks.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_racks.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_racks.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lbl_racks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Racks r = new Racks();
				r.setVisible(true);
				r.setLocationRelativeTo(null);
				dispose();
				r.requestFocus();
			}
		});
		
		lbl_racks.setBounds(628, 181, 192, 30);
		
		lbl_racks.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Racks r = new Racks();
				r.setVisible(true);
				r.setLocationRelativeTo(null);
				r.requestFocus();
				dispose();
			}
		});
		
		contentPane.add(lbl_racks);
		
		JLabel lbl_packing_list = new JLabel("PACKING LIST");
		lbl_packing_list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_packing_list.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_packing_list.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_packing_list.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_packing_list.setBounds(22, 376, 173, 30);
		
		lbl_packing_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Packing_List pk = new Packing_List();
				pk.setVisible(true);
				pk.setLocationRelativeTo(null);
				pk.requestFocus();
				dispose();
			}
		});
		
		contentPane.add(lbl_packing_list);
		
		JButton btn_base_de_datos = new JButton("");
		btn_base_de_datos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_base_de_datos.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/base-de-datos.png")));
		btn_base_de_datos.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_base_de_datos.setBounds(628, 267, 192, 108);
		
		btn_base_de_datos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vista_Base_de_Datos vbd = new Vista_Base_de_Datos();
				vbd.setVisible(true);
				vbd.setLocationRelativeTo(null);
				vbd.requestFocus();
				dispose();
			}
		});
		
		contentPane.add(btn_base_de_datos);
		
		JLabel lbl_base_de_datos = new JLabel("BASE DE DATOS GENERAL");
		lbl_base_de_datos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_base_de_datos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vista_Base_de_Datos vbd = new Vista_Base_de_Datos();
				vbd.setVisible(true);
				vbd.setLocationRelativeTo(null);
				vbd.requestFocus();
				dispose();
			}
		});
		lbl_base_de_datos.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_base_de_datos.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_base_de_datos.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_base_de_datos.setBounds(628, 376, 192, 30);
		contentPane.add(lbl_base_de_datos);
		
		JLabel lblMenuPrincipal = new JLabel("MENU PRINCIPAL");
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPrincipal.setFont(new Font("Arial", Font.BOLD, 16));
		lblMenuPrincipal.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMenuPrincipal.setBounds(22, 11, 531, 50);
		contentPane.add(lblMenuPrincipal);
		
		JLabel lblGrupoIndigoPuro = new JLabel("GRUPO INDIGO PURO");
		lblGrupoIndigoPuro.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupoIndigoPuro.setFont(new Font("Arial", Font.BOLD, 16));
		lblGrupoIndigoPuro.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblGrupoIndigoPuro.setBounds(563, 11, 257, 50);
		contentPane.add(lblGrupoIndigoPuro);
	}
	
	
	public void actualizarFecha() {
        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Formatear la fecha como una cadena
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(fechaActual);

        // Actualizar el texto del JLabel
        lbl_fecha_actual.setText("Fecha actual: " + fechaFormateada);
    }
	
	
	public void iniciarHiloActualizacionHora() {
        Thread hilo = new Thread(() -> {
            while (true) {
                // Obtener la hora actual
                Date horaActual = new Date();

                // Formatear la hora como una cadena
                SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss a");
                String horaFormateada = formatoHora.format(horaActual);

                // Actualizar el texto del JLabel con la hora
                SwingUtilities.invokeLater(() -> {
                    lbl_hora_actual.setText("Hora actual: " + horaFormateada);
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
