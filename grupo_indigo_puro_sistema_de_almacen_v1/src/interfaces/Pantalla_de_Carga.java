package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Pantalla_de_Carga extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel txt_texto;
	
	// ARRAY QUE SE ENCARGA DE ALMACENAR LOS MENSAJES QUE APARECEN EN PANTALLA...
	private String[] palabras = {"CARGANDO...", "INICIANDO LA BASE DE DATOS...", "INICIANDO PROCESOS", "BIENVENIDO"," "};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Pantalla_de_Carga frame = new Pantalla_de_Carga();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.iniciarTarea();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pantalla_de_Carga() {
		setUndecorated(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 459);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(new Color(255, 255, 255));
		progressBar.setForeground(new Color(50, 50,50));
		progressBar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		progressBar.setBounds(10, 387, 765, 54);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Pantalla_de_Carga.class.getResource("/imagenes/logogip.png")));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 99));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 765, 245);
		contentPane.add(lblNewLabel);
		
		txt_texto = new JLabel("");
		txt_texto.setHorizontalTextPosition(SwingConstants.CENTER);
		txt_texto.setBackground(new Color(255, 255, 255));
		txt_texto.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txt_texto.setHorizontalAlignment(SwingConstants.CENTER);
		txt_texto.setFont(new Font("Arial Black", Font.BOLD, 35));
		txt_texto.setForeground(new Color(255, 255, 255));
		txt_texto.setBounds(10, 290, 765, 68);
		contentPane.add(txt_texto);

    }
	
	//METODO QUE SE ENCARGA DE INICIAR EL CONTADOR DE LA PANTALLA DE CARGA
	private void iniciarTarea() {
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(50);
                    publish(i);
                }
                return null;
            }

            //METODO QUE SE ENCARGA DE INICIAR LSO MENSAJES PARA LA PANTALLA DE CARGA
            @Override
            protected void process(List<Integer> chunks) {
                int latestValue = chunks.get(chunks.size() - 1);
                JProgressBar progressBar = (JProgressBar) contentPane.getComponent(0);
                progressBar.setValue(latestValue);
                
                // Mostrar palabras en la etiqueta txt_texto
                int indicePalabrasProgreso = (int) Math.min(Math.max(0, ((float) latestValue / 100) * (palabras.length - 1)), palabras.length - 1);
                String palabraActual = palabras[indicePalabrasProgreso];
                txt_texto.setText(palabraActual);
                
            }

            //METOO QUE SE ENCARGA DE ABRIR EL MENU PRINCIPAL
            @Override
            protected void done() {
                dispose();
                Menu_Principal mp = new Menu_Principal();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				mp.requestFocus();
				mp.actualizarFecha();
				mp.iniciarHiloActualizacionHora();
            }
        };

        worker.execute();
    }
}
