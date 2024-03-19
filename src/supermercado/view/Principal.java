package supermercado.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import supermercado.controller.ControladorCategoria;
import supermercado.controller.ControladorProducto;
import supermercado.model.Categoria;
import supermercado.model.Producto;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfCodigo;
	private JTextField jtfDescripcion;
	private JTextField jtfFechaCaducidad;
	private JTextField jtfUnidadesStock;
	JComboBox<Categoria> jcbCategoria;
	JComboBox<Producto> jcbProducto;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	JCheckBox checkPerecedero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0};
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Gestión de productos de supermercado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Categoría:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbCategoria = new JComboBox<Categoria>();
		jcbCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarProductosDeCategoria();
			}
		});
		GridBagConstraints gbc_jcbCategoria = new GridBagConstraints();
		gbc_jcbCategoria.gridwidth = 2;
		gbc_jcbCategoria.weightx = 1.0;
		gbc_jcbCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCategoria.gridx = 1;
		gbc_jcbCategoria.gridy = 1;
		contentPane.add(jcbCategoria, gbc_jcbCategoria);
		
		JLabel lblNewLabel_2 = new JLabel("Producto:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbProducto = new JComboBox<Producto>();
		jcbProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("actionPerformed jcbProducto");
				cargarProductoEnPantalla();
			}
		});
		GridBagConstraints gbc_jcbProducto = new GridBagConstraints();
		gbc_jcbProducto.gridwidth = 2;
		gbc_jcbProducto.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProducto.gridx = 1;
		gbc_jcbProducto.gridy = 2;
		contentPane.add(jcbProducto, gbc_jcbProducto);
		
		JLabel lblNewLabel_4 = new JLabel("Datos de la materia:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridwidth = 3;
		gbc_lblNewLabel_4.insets = new Insets(10, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 5;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Código:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfCodigo = new JTextField();
		GridBagConstraints gbc_jtfCodigo = new GridBagConstraints();
		gbc_jtfCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCodigo.gridwidth = 2;
		gbc_jtfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCodigo.gridx = 1;
		gbc_jtfCodigo.gridy = 6;
		contentPane.add(jtfCodigo, gbc_jtfCodigo);
		jtfCodigo.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Descripción:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDescripcion.gridwidth = 2;
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 7;
		contentPane.add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		checkPerecedero = new JCheckBox("");
		checkPerecedero.setSelected(true);
		GridBagConstraints gbc_checkPerecedero = new GridBagConstraints();
		gbc_checkPerecedero.anchor = GridBagConstraints.EAST;
		gbc_checkPerecedero.insets = new Insets(0, 0, 5, 5);
		gbc_checkPerecedero.gridx = 0;
		gbc_checkPerecedero.gridy = 8;
		contentPane.add(checkPerecedero, gbc_checkPerecedero);
		
		JLabel lbl1 = new JLabel("Perecedero");
		GridBagConstraints gbc_lbl1 = new GridBagConstraints();
		gbc_lbl1.anchor = GridBagConstraints.WEST;
		gbc_lbl1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl1.gridx = 1;
		gbc_lbl1.gridy = 8;
		contentPane.add(lbl1, gbc_lbl1);
		
		JLabel lblNewLabel_8 = new JLabel("Fecha de caducidad:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jtfFechaCaducidad = new JTextField();
		GridBagConstraints gbc_jtfFechaCaducidad = new GridBagConstraints();
		gbc_jtfFechaCaducidad.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaCaducidad.gridwidth = 2;
		gbc_jtfFechaCaducidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaCaducidad.gridx = 1;
		gbc_jtfFechaCaducidad.gridy = 9;
		contentPane.add(jtfFechaCaducidad, gbc_jtfFechaCaducidad);
		jtfFechaCaducidad.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Unidades en stock:");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 10;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		jtfUnidadesStock = new JTextField();
		GridBagConstraints gbc_jtfUnidadesStock = new GridBagConstraints();
		gbc_jtfUnidadesStock.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUnidadesStock.gridwidth = 2;
		gbc_jtfUnidadesStock.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUnidadesStock.gridx = 1;
		gbc_jtfUnidadesStock.gridy = 10;
		contentPane.add(jtfUnidadesStock, gbc_jtfUnidadesStock);
		jtfUnidadesStock.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarProducto();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridwidth = 3;
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 12;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 13;
		contentPane.add(panel, gbc_panel);
		
		cargarListaCategorias();
	}

	
	
	private void cargarListaCategorias() {
		List<Categoria> l = ControladorCategoria.findAll();
		for (Categoria c : l) {
			this.jcbCategoria.addItem(c);
		}
	}
	
	/**
	 * 
	 */
	private void cargarProductosDeCategoria() {
		Categoria c = (Categoria) this.jcbCategoria.getSelectedItem();
		List<Producto> l = ControladorProducto.findAllByIdCategoria(c.getId());

		this.jcbProducto.removeAllItems();
		for (Producto o : l) {
			this.jcbProducto.addItem(o);
		}
	}
	
	/**
	 * 
	 */
	private void cargarProductoEnPantalla() {
		Producto p = (Producto) this.jcbProducto.getSelectedItem();
		if (p != null) {
			this.jtfId.setText("" + p.getId());
			this.jtfCodigo.setText(p.getCodigo());
			this.jtfDescripcion.setText(p.getDescripcion());
			this.checkPerecedero.setSelected(p.isPerecedero());
			
			String strFecha = (p.getFechaCaducidad() != null)? 
					sdf.format(p.getFechaCaducidad()) : "";
			this.jtfFechaCaducidad.setText(strFecha);
			
			this.jtfUnidadesStock.setText("" + p.getUnidadesStock());
		}
	}
	
	/**
	 * 
	 */
	private void guardarProducto() {
		
		try {
			// Comprobaciones
			if (!isCodigoValido()) {
				JOptionPane.showMessageDialog(null, "El código no es válido. "
						+ "Debe comenzar por tres caracteres en mayúscula");
				return;
			}
			
			if (!isFechaCaducidadValida()) {
				JOptionPane.showMessageDialog(null, "La fecha de caducidad no es "
						+ "posterior a hoy");
				return;
			}
			
			if (!isStockValido()) {
				JOptionPane.showMessageDialog(null, "Las unidades en stock deben "
						+ "ser un número entero");
				return;
			}

			// Guardado del producto
			Producto p  = new Producto();
			
			p.setId(Integer.parseInt(this.jtfId.getText()));
			p.setCodigo(this.jtfCodigo.getText());
			p.setDescripcion(this.jtfDescripcion.getText());
			p.setIdCategoria( ((Categoria) this.jcbCategoria.getSelectedItem()).getId() );
			p.setPerecedero(this.checkPerecedero.isSelected());
			
			Date nuevaFecha = (!this.jtfFechaCaducidad.getText().trim().equals(""))?
					sdf.parse(this.jtfFechaCaducidad.getText()) : null;
			p.setFechaCaducidad(nuevaFecha);
			p.setUnidadesStock(Integer.parseInt(this.jtfUnidadesStock.getText()));
			
			// Envío el producto a guardado
			if (ControladorProducto.save(p) == 1) {
				JOptionPane.showMessageDialog(null, "Guardado correctamente");
			}
			else {
				JOptionPane.showMessageDialog(null, "NO se ha podido guardar");
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}		
	}
	
	
	/**
	 * 
	 * @return
	 */
	private boolean isCodigoValido () {		
		return this.jtfCodigo.getText().matches("[A-Z]{3,}.*");
	}
	
	
	/**
	 * 
	 * @return
	 */
	private boolean isCodigoValido2() {
		String strCodigo = this.jtfCodigo.getText();
		
		if (strCodigo.length() > 2) {
			for (int i = 0; i < 3; i++) {
				if (!Character.isUpperCase(strCodigo.charAt(i))) {
					return false;
				}
			}
		}
		else {
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private boolean isFechaCaducidadValida() {
		String strFechaCad = this.jtfFechaCaducidad.getText();
		
		if (strFechaCad.trim().equals("")) {
			return true;
		}
		
		Date fechaCad = null;
		try {
			fechaCad = sdf.parse(strFechaCad);
		}
		catch (Exception ex) {
			return false;
		}
		
		if ((new Date()).after(fechaCad)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	/**
	 * 
	 * @return
	 */
	private boolean isStockValido () {
		try {
			Integer.parseInt(this.jtfUnidadesStock.getText());
			return true;
		}
		catch (Exception ex) {
			return false;
		}
	}
}















