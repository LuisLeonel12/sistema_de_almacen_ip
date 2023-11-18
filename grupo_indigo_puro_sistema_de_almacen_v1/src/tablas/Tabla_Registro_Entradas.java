package tablas;
import interfaces.Registro_de_Entradas;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import base_de_datos.Entradas;
import base_de_datos.Entradas_DAO;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static interfaces.Registro_de_Entradas.txt_id;
import static interfaces.Registro_de_Entradas.txt_codigo_rollo;
import static interfaces.Registro_de_Entradas.txt_nombre_tela;
import static interfaces.Registro_de_Entradas.txt_proveedor;
import static interfaces.Registro_de_Entradas.txt_peso;
import static interfaces.Registro_de_Entradas.txt_caracteristicas;

public class Tabla_Registro_Entradas extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final AbstractButton txt_nombre_rollo = null;
	private JPanel contentPane;
	private JTable tbl_registro_entradas;
	
		//VARIABLES
		Entradas e = new Entradas();
		Entradas_DAO edao= new Entradas_DAO();
	    DefaultTableModel modelo = new DefaultTableModel();
	    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabla_Registro_Entradas frame = new Tabla_Registro_Entradas();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.Listar_Registro_Entradas();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tabla_Registro_Entradas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_menu_principal = new JButton("OK");
		btn_menu_principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestFocus();
				dispose();
			}
		});
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 13));
		btn_menu_principal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal.setBounds(10, 11, 149, 36);
		contentPane.add(btn_menu_principal);
		
		JLabel lblRegistroDeEntradas = new JLabel("REGISTRO DE ENTRADAS");
		lblRegistroDeEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeEntradas.setFont(new Font("Arial", Font.BOLD, 16));
		lblRegistroDeEntradas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblRegistroDeEntradas.setBounds(202, 9, 658, 36);
		contentPane.add(lblRegistroDeEntradas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(11, 58, 1043, 592);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 1, true));
		
		tbl_registro_entradas = new JTable();
		tbl_registro_entradas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int seleccionar = tbl_registro_entradas.rowAtPoint(e.getPoint());
				
                txt_id.setText(String.valueOf(tbl_registro_entradas.getValueAt(seleccionar, 0)));
                txt_codigo_rollo.setText(String.valueOf(tbl_registro_entradas.getValueAt(seleccionar, 1)));
                txt_nombre_tela.setText(String.valueOf(tbl_registro_entradas.getValueAt(seleccionar, 2)));
                txt_proveedor.setText(String.valueOf(tbl_registro_entradas.getValueAt(seleccionar, 3)));
                txt_peso.setText(String.valueOf(tbl_registro_entradas.getValueAt(seleccionar, 4)));
                txt_caracteristicas.setText(String.valueOf(tbl_registro_entradas.getValueAt(seleccionar, 5)));
		     
		     dispose();
				
			}
		});
		scrollPane.setViewportView(tbl_registro_entradas);
		tbl_registro_entradas.setDefaultEditor(Object.class, null);
		tbl_registro_entradas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><center>ID</html></center>","<html><center>CODIGO ROLLO</html></center>", "<html><center>NOMBRE TELA</html></center>","<html><center>PROVEEDOR</html></center>","<html><center>PESO</html></center>","<html><center>CARACTERISTICAS</html></center>","<html><center>FECHA DE ENTRADA</html></center>","<html><center>HORA DE ENTRADA</html></center>"
			}
		));
		tbl_registro_entradas.getColumnModel().getColumn(0).setPreferredWidth(65);
		tbl_registro_entradas.getColumnModel().getColumn(1).setPreferredWidth(130);
		tbl_registro_entradas.getColumnModel().getColumn(2).setPreferredWidth(130);
		tbl_registro_entradas.getColumnModel().getColumn(3).setPreferredWidth(130);
		tbl_registro_entradas.getColumnModel().getColumn(4).setPreferredWidth(100);
		tbl_registro_entradas.getColumnModel().getColumn(5).setPreferredWidth(200);
		tbl_registro_entradas.getColumnModel().getColumn(6).setPreferredWidth(130);
		tbl_registro_entradas.getColumnModel().getColumn(7).setPreferredWidth(130);
		tbl_registro_entradas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
	}
	
	
	public void Listar_Registro_Entradas(){
	    List<Entradas> listae = edao.Listar_registro_entradas();
	    modelo = (DefaultTableModel) tbl_registro_entradas.getModel();
	    
	    Object[] entradas = new Object[8];
	    for (int i = 0; i < listae.size(); i++) {
	    entradas[0]=listae.get(i).getId();
	    entradas[1]=listae.get(i).getCodigo_Rollo();
	    entradas[2]=listae.get(i).getNombre_Tela();
	    entradas[3]=listae.get(i).getProveedor();
	    entradas[4]=listae.get(i).getPeso();
	    entradas[5]=listae.get(i).getCaracteristicas();
	    entradas[6]=listae.get(i).getFecha_Entrada();
	    entradas[7]=listae.get(i).getHora_de_Entrada();
	    modelo.addRow(entradas);
	    }
	    tbl_registro_entradas.setModel(modelo);
	    }
	
	 
}
