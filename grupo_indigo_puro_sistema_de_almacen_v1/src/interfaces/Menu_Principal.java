package interfaces;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class Menu_Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbl_fecha_actual;
	private JLabel lbl_hora_actual;

	int item;

	String hora,minutos,segundos;
    Thread hilo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Menu_Principal frame = new Menu_Principal();
					frame.requestFocus();
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
		setResizable(false);
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu_Principal.class.getResource("/imagenes/casa.png")));
		setTitle("MENU PRINCIPAL");
		setBounds(100, 100, 993, 558);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn_salida = new JButton("");
		btn_salida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Registro_de_Salidas rs = new Registro_de_Salidas();
				rs.setLocationRelativeTo(null);
				rs.setVisible(true);
				rs.requestFocus();
				Registro_de_Salidas.txt_metros_solicitados.setEditable(false);
				Registro_de_Salidas.txt_ancho.setEditable(false);
				dispose();
			}
		});
		btn_salida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_salida.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/salida.png")));
		btn_salida.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_salida.setBounds(378, 99, 221, 139);
		contentPane.add(btn_salida);

		lbl_hora_actual = new JLabel("");
		lbl_hora_actual.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_hora_actual.setFont(new Font("Arial Black", Font.BOLD, 20));
		lbl_hora_actual.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_hora_actual.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hora_actual.setBounds(746, 451, 221, 42);
		contentPane.add(lbl_hora_actual);

		lbl_fecha_actual = new JLabel("");
		lbl_fecha_actual.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_fecha_actual.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_actual.setFont(new Font("Arial Black", Font.BOLD, 20));
		lbl_fecha_actual.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_fecha_actual.setBounds(10, 451, 224, 42);
		contentPane.add(lbl_fecha_actual);

		JLabel lbl_salidas = new JLabel("SALIDAS");
		lbl_salidas.setForeground(Color.BLACK);
		lbl_salidas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_salidas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_salidas.setFont(new Font("Arial", Font.BOLD, 18));
		lbl_salidas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		lbl_salidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registro_de_Salidas rs = new Registro_de_Salidas();
				rs.setLocationRelativeTo(null);
				rs.setVisible(true);
				rs.requestFocus();
				Registro_de_Salidas.txt_metros_solicitados.setEditable(false);
				Registro_de_Salidas.txt_ancho.setEditable(false);
				dispose();
			}
		});

		lbl_salidas.setBounds(378, 238, 221, 42);


		contentPane.add(lbl_salidas);

		JButton btn_base_de_datos = new JButton("");
		btn_base_de_datos.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/inventario.png")));
		btn_base_de_datos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_base_de_datos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_base_de_datos.setBounds(10, 99, 224, 139);

		btn_base_de_datos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Inventario_General ig = new Inventario_General();
				ig.setVisible(true);
				ig.setLocationRelativeTo(null);
				ig.actualizar_hora();
				ig.requestFocus();
				dispose();
			}
		});  

		contentPane.add(btn_base_de_datos);

		JLabel lbl_base_de_datos = new JLabel("INVENTARIO GENERAL");
		lbl_base_de_datos.setForeground(Color.BLACK);
		lbl_base_de_datos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_base_de_datos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Inventario_General ig = new Inventario_General();
				ig.setVisible(true);
				ig.setLocationRelativeTo(null);
				ig.actualizar_hora();
				ig.requestFocus();
				dispose();
			}
		});
		lbl_base_de_datos.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_base_de_datos.setFont(new Font("Arial", Font.BOLD, 18));
		lbl_base_de_datos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_base_de_datos.setBounds(10, 238, 224, 42);
		contentPane.add(lbl_base_de_datos);

		JLabel lblMenuPrincipal = new JLabel("MENU PRINCIPAL");
		lblMenuPrincipal.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPrincipal.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblMenuPrincipal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblMenuPrincipal.setBounds(10, 11, 957, 62);
		contentPane.add(lblMenuPrincipal);

		JLabel lblGrupoIndigoPuro = new JLabel("");
		lblGrupoIndigoPuro.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/logogip.png")));
		lblGrupoIndigoPuro.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGrupoIndigoPuro.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupoIndigoPuro.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblGrupoIndigoPuro.setBounds(244, 312, 490, 181);
		contentPane.add(lblGrupoIndigoPuro);

		JLabel lbl_fecha_actual_1 = new JLabel("");
		lbl_fecha_actual_1.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/calendario.png")));
		lbl_fecha_actual_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_fecha_actual_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha_actual_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		lbl_fecha_actual_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_fecha_actual_1.setBounds(10, 312, 224, 139);
		contentPane.add(lbl_fecha_actual_1);

		JLabel lbl_hora_actual_1 = new JLabel("");
		lbl_hora_actual_1.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/reloj.png")));
		lbl_hora_actual_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_hora_actual_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hora_actual_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		lbl_hora_actual_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_hora_actual_1.setBounds(746, 312, 221, 139);
		contentPane.add(lbl_hora_actual_1);
		
		JButton btn_salida_1 = new JButton("");
		btn_salida_1.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/producto.png")));
		btn_salida_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_salida_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Existencias ex = new Existencias();
				ex.setVisible(true);
				ex.setLocationRelativeTo(null);
				ex.requestFocus();
				dispose();
			}
		});
		btn_salida_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_salida_1.setBounds(746, 99, 221, 139);
		contentPane.add(btn_salida_1);
		
		JLabel lbl_salidas_1 = new JLabel("EXISTENCIAS");
		lbl_salidas_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Existencias ex = new Existencias();
				ex.setVisible(true);
				ex.setLocationRelativeTo(null);
				ex.requestFocus();
				dispose();
			}
		});
		lbl_salidas_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_salidas_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_salidas_1.setForeground(Color.BLACK);
		lbl_salidas_1.setFont(new Font("Arial", Font.BOLD, 18));
		lbl_salidas_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_salidas_1.setBounds(746, 238, 221, 42);
		contentPane.add(lbl_salidas_1);
	}


	public void actualizarFecha() {

        Date fechaActual = new Date();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(fechaActual);

        lbl_fecha_actual.setText(fechaFormateada);
    }


	public void iniciarHiloActualizacionHora() {
        Thread hilo = new Thread(() -> {
            while (true) {

                Date horaActual = new Date();

                SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss a");
                String horaFormateada = formatoHora.format(horaActual);

                SwingUtilities.invokeLater(() -> {
                    lbl_hora_actual.setText(horaFormateada);
                });

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
