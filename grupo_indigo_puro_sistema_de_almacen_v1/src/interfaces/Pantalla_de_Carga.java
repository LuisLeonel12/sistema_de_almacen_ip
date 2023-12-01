package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;

public class Pantalla_de_Carga extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbl_proceso;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla_de_Carga frame = new Pantalla_de_Carga();
					frame.setVisible(true);
					frame.startThread();
					
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
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Pantalla_de_Carga.class.getResource("/imagenes/text.gif")));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 718, 80);
		contentPane.add(lblNewLabel);
		
		lbl_proceso = new JLabel("0");
		lbl_proceso.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lbl_proceso.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_proceso.setBounds(228, 102, 299, 80);
		contentPane.add(lbl_proceso);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 258, 718, 66);
		contentPane.add(progressBar);
		
    }
	
	
	private void startThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    final int progress = i;
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            lbl_proceso.setText(String.valueOf(progress));
                        }
                    });

                    try {
                        //SE REQUIERE UNA PAUSA PARA PODER SIMULAR EL PROCESO
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
    }
}
