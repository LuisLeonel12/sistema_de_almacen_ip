package tablas;

import static interfaces.Inventario_General.txt_ancho;
import static interfaces.Inventario_General.txt_caracteristicas;
import static interfaces.Inventario_General.txt_codigo_rollo;
import static interfaces.Inventario_General.txt_estilo;
import static interfaces.Inventario_General.txt_id;
import static interfaces.Inventario_General.txt_metros;
import static interfaces.Inventario_General.txt_nombre_tela;
import static interfaces.Inventario_General.txt_peso;
import static interfaces.Inventario_General.txt_proveedor;
import static interfaces.Inventario_General.txt_ubicacion;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import base_de_datos.Inventario;
import base_de_datos.Inventario_DAO;
import diseño_pdf_excel.Excel;
import interfaces.Inventario_General;
import java.awt.Toolkit;

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
			@Override
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tabla_Inventario_General.class.getResource("/imagenes/inventario.png")));
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1328, 670);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn_menu_principal = new JButton("OK");
		btn_menu_principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal.addActionListener(new ActionListener() {
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
		btn_menu_principal.setFont(new Font("Arial", Font.BOLD, 20));
		btn_menu_principal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal.setBounds(10, 13, 149, 53);
		contentPane.add(btn_menu_principal);

		JLabel lblRegistroDeEntradas = new JLabel("INVENTARIO GENERAL");
		lblRegistroDeEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeEntradas.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblRegistroDeEntradas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblRegistroDeEntradas.setBounds(169, 13, 974, 53);
		contentPane.add(lblRegistroDeEntradas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(Color.BLACK, 2));
		scrollPane.setSize(new Dimension(10, 10));
		scrollPane.setBounds(10, 77, 1292, 543);
		contentPane.add(scrollPane);

		tbl_inventario = new JTable();
		tbl_inventario.setRowMargin(2);
		tbl_inventario.setRowHeight(25);
		tbl_inventario.setFont(new Font("Arial", Font.BOLD, 12));
		tbl_inventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tbl_inventario.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

			Inventario_General ig = new Inventario_General();

            int seleccionar = tbl_inventario.rowAtPoint(e.getPoint());

            txt_id.setText(String.valueOf(tbl_inventario.getValueAt(seleccionar, 0)));
            txt_codigo_rollo.setText(String.valueOf(tbl_inventario.getValueAt(seleccionar, 1)));
            txt_nombre_tela.setText(String.valueOf(tbl_inventario.getValueAt(seleccionar, 2)));
            txt_proveedor.setText(String.valueOf(tbl_inventario.getValueAt(seleccionar, 3)));
            txt_peso.setText(String.valueOf(tbl_inventario.getValueAt(seleccionar, 4)));
            txt_metros.setText(String.valueOf(tbl_inventario.getValueAt(seleccionar, 5)));
            txt_estilo.setText(String.valueOf(tbl_inventario.getValueAt(seleccionar, 6)));
            txt_ancho.setText(String.valueOf(tbl_inventario.getValueAt(seleccionar, 7)));
            txt_caracteristicas.setText(String.valueOf(tbl_inventario.getValueAt(seleccionar, 8)));
            txt_ubicacion.setText(String.valueOf(tbl_inventario.getValueAt(seleccionar, 9)));
            

            ig.setVisible(true);
            ig.actualizar_hora();
            ig.setLocationRelativeTo(null);

		    dispose();
		    requestFocus();

			}
		});
		tbl_inventario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><center>ID</html></center>", "<html><center>CODIGO ROLLO</html></center>", "<html><center>NOMBRE TELA</html></center>", "<html><center>PROVEEDOR</html></center>", "<html><center>KILOS</html></center>", "<html><center>METROS</html></center>", "<html><center>CLASIFICACION</html></center>", "<html><center>ANCHO</html></center>", "<html><center>COMPOSICION</html></center>", "<html><center>UBICACION</html></center>", "<html><center>FECHA ENTRADA</html></center>", "<html><center>HORA ENTRADA</html></center>"
			}
		));
		tbl_inventario.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbl_inventario.getColumnModel().getColumn(1).setPreferredWidth(90);
		tbl_inventario.getColumnModel().getColumn(2).setPreferredWidth(120);
		tbl_inventario.getColumnModel().getColumn(3).setPreferredWidth(120);
		tbl_inventario.getColumnModel().getColumn(4).setPreferredWidth(90);
		tbl_inventario.getColumnModel().getColumn(5).setPreferredWidth(90);
		tbl_inventario.getColumnModel().getColumn(6).setPreferredWidth(90);
		tbl_inventario.getColumnModel().getColumn(7).setPreferredWidth(80);
		tbl_inventario.getColumnModel().getColumn(8).setPreferredWidth(120);
		tbl_inventario.getColumnModel().getColumn(9).setPreferredWidth(70);
		tbl_inventario.getColumnModel().getColumn(10).setPreferredWidth(125);
		tbl_inventario.getColumnModel().getColumn(11).setPreferredWidth(100);
		scrollPane.setViewportView(tbl_inventario);
		tbl_inventario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		JButton btn_menu_principal_1 = new JButton("");
		btn_menu_principal_1.setIcon(new ImageIcon(Tabla_Inventario_General.class.getResource("/imagenes/excel.png")));
		btn_menu_principal_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				requestFocus();
				//JOptionPane.showMessageDialog(null,"REPORTE DE INVENTARIO GENERAL CREADO");
				Excel.reporte();
			}
		});
		btn_menu_principal_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_menu_principal_1.setFont(new Font("Arial", Font.BOLD, 13));
		btn_menu_principal_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_menu_principal_1.setBounds(1153, 13, 149, 53);
		contentPane.add(btn_menu_principal_1);

		//CENTRAR LOS DATOS DE LA TABLA
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tbl_inventario.getColumnCount(); i++) {
            tbl_inventario.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

	}

	public void Listar_Inventario(){
	    List<Inventario> listai = indao.Listar_Inventario_General();
	    modelo = (DefaultTableModel) tbl_inventario.getModel();

	    Object[] inventario = new Object[12];
	    for (Inventario element : listai) {
	    inventario[0]=element.getId();
	    inventario[1]=element.getCodigo_Rollo();
	    inventario[2]=element.getNombre_Tela();
	    inventario[3]=element.getProveedor();
	    inventario[4]=element.getPeso_total();
	    inventario[5]=element.getMetros();
	    inventario[6]=element.getEstilo();
	    inventario[7]=element.getAncho();
	    inventario[8]=element.getCaracteristicas();
	    inventario[9]=element.getUbicacion();
	    inventario[10]=element.getFecha_Entrada();
	    inventario[11]=element.getHora_de_Entrada();
	    modelo.addRow(inventario);
	    }
	    tbl_inventario.setModel(modelo);
	    }
}
