package tablas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import static interfaces.Inventario_General.txt_caracteristicas;
import static interfaces.Inventario_General.txt_codigo_rollo;
import static interfaces.Inventario_General.txt_id;
import static interfaces.Inventario_General.txt_nombre_tela;
import static interfaces.Inventario_General.txt_peso;
import static interfaces.Inventario_General.txt_proveedor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import base_de_datos.Inventario;
import base_de_datos.Inventario_DAO;
import interfaces.Inventario_General;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tabla_Inventario_General extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbl_inventario;
	
	//VARIABLES
	Inventario in = new Inventario();
	Inventario_DAO indao = new Inventario_DAO();
	DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabla_Inventario_General frame = new Tabla_Inventario_General();
					frame.Listar_Inventario();
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
	public Tabla_Inventario_General() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_menu_principal = new JButton("OK");
		btn_menu_principal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 13));
		btn_menu_principal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal.setBounds(10, 13, 149, 36);
		contentPane.add(btn_menu_principal);
		
		JLabel lblRegistroDeEntradas = new JLabel("INVENTARIO GENERAL");
		lblRegistroDeEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeEntradas.setFont(new Font("Arial", Font.BOLD, 16));
		lblRegistroDeEntradas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblRegistroDeEntradas.setBounds(202, 11, 658, 36);
		contentPane.add(lblRegistroDeEntradas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 1044, 580);
		contentPane.add(scrollPane);
		
		tbl_inventario = new JTable();
		tbl_inventario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
            int seleccionar = tbl_inventario.rowAtPoint(e.getPoint());
				
            txt_id.setText(String.valueOf(tbl_inventario.getValueAt(seleccionar, 0)));
            txt_codigo_rollo.setText(String.valueOf(tbl_inventario.getValueAt(seleccionar, 1)));
            txt_nombre_tela.setText(String.valueOf(tbl_inventario.getValueAt(seleccionar, 2)));
            txt_proveedor.setText(String.valueOf(tbl_inventario.getValueAt(seleccionar, 3)));
            txt_peso.setText(String.valueOf(tbl_inventario.getValueAt(seleccionar, 4)));
            txt_caracteristicas.setText(String.valueOf(tbl_inventario.getValueAt(seleccionar, 5)));
		     
		    dispose();
		    requestFocus();
				
			}
		});
		tbl_inventario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><center>ID</html></center>", "<html><center>CODIGO ROLLO</html></center>", "<html><center>NOMBRE TELA</html></center>", "<html><center>PROVEEDOR</html></center>", "<html><center>PESO TOTAL</html></center>", "<html><center>CARACTERISTICAS</html></center>", "<html><center>FECHA ENTRADA</html></center>", "<html><center>HORA ENTRADA</html></center>"
			}
		));
		tbl_inventario.getColumnModel().getColumn(0).setPreferredWidth(80);
		tbl_inventario.getColumnModel().getColumn(1).setPreferredWidth(130);
		tbl_inventario.getColumnModel().getColumn(2).setPreferredWidth(100);
		tbl_inventario.getColumnModel().getColumn(3).setPreferredWidth(100);
		tbl_inventario.getColumnModel().getColumn(4).setPreferredWidth(100);
		tbl_inventario.getColumnModel().getColumn(5).setPreferredWidth(110);
		tbl_inventario.getColumnModel().getColumn(6).setPreferredWidth(115);
		tbl_inventario.getColumnModel().getColumn(7).setPreferredWidth(100);
		scrollPane.setViewportView(tbl_inventario);
		tbl_inventario.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
	}
	
	public void Listar_Inventario(){
	    List<Inventario> listai = indao.Listar_Inventario_General();
	    modelo = (DefaultTableModel) tbl_inventario.getModel();
	    
	    Object[] inventario = new Object[8];
	    for (int i = 0; i < listai.size(); i++) {
	    inventario[0]=listai.get(i).getId();
	    inventario[1]=listai.get(i).getCodigo_Rollo();
	    inventario[2]=listai.get(i).getNombre_Tela();
	    inventario[3]=listai.get(i).getProveedor();
	    inventario[4]=listai.get(i).getPeso_total();
	    inventario[5]=listai.get(i).getCaracteristicas();
	    inventario[6]=listai.get(i).getFecha_Entrada();
	    inventario[7]=listai.get(i).getHora_de_Entrada();
	    modelo.addRow(inventario);
	    }
	    tbl_inventario.setModel(modelo);
	    }
	
}