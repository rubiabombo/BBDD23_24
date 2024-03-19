package nivelesymaterias.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;


import nivelesymaterias.controller.ControladorCentro;
import nivelesymaterias.controller.ControladorMateria;
import nivelesymaterias.controller.ControladorNivel;
import nivelesymaterias.model.CentroEducativo;
import nivelesymaterias.model.Materia;
import nivelesymaterias.model.Nivel;

public class VentanaMateria extends JFrame {

	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfCodigo;
	private JTextField jtfUrl;
	private JTextField jtfFechaInicio;
	JComboBox<CentroEducativo> jcbCentro;
	JComboBox<Nivel> jcbNivel;
	JComboBox<Materia> jcbMateria;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	JCheckBox checkAdmiteMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMateria frame = new VentanaMateria();
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
	public VentanaMateria() {
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
		
		JLabel lblNewLabel = new JLabel("Gestión de materias");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Centro:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbCentro = new JComboBox();
		GridBagConstraints gbc_jcbCentro = new GridBagConstraints();
		gbc_jcbCentro.weightx = 1.0;
		gbc_jcbCentro.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCentro.gridx = 1;
		gbc_jcbCentro.gridy = 1;
		contentPane.add(jcbCentro, gbc_jcbCentro);
		
		JButton btnCargarNiveles = new JButton("Cargar niveles");
		btnCargarNiveles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarNivelesDeCentro();
			}
		});
		GridBagConstraints gbc_btnCargarNiveles = new GridBagConstraints();
		gbc_btnCargarNiveles.insets = new Insets(0, 0, 5, 0);
		gbc_btnCargarNiveles.gridx = 2;
		gbc_btnCargarNiveles.gridy = 1;
		contentPane.add(btnCargarNiveles, gbc_btnCargarNiveles);
		
		JLabel lblNewLabel_2 = new JLabel("Nivel:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbNivel = new JComboBox();
		GridBagConstraints gbc_jcbNivel = new GridBagConstraints();
		gbc_jcbNivel.insets = new Insets(0, 0, 5, 5);
		gbc_jcbNivel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNivel.gridx = 1;
		gbc_jcbNivel.gridy = 2;
		contentPane.add(jcbNivel, gbc_jcbNivel);
		
		JButton btnNewButton = new JButton("Cargar materias");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMateriasDeNivel();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Materias:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jcbMateria = new JComboBox();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 3;
		contentPane.add(jcbMateria, gbc_jcbMateria);
		
		JButton btnNewButton_1 = new JButton("Ver materia");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatosMateria();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 3;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
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
		
		JLabel lblNewLabel_6 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.gridwidth = 2;
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 6;
		contentPane.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Código:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfCodigo = new JTextField();
		GridBagConstraints gbc_jtfCodigo = new GridBagConstraints();
		gbc_jtfCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCodigo.gridwidth = 2;
		gbc_jtfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCodigo.gridx = 1;
		gbc_jtfCodigo.gridy = 7;
		contentPane.add(jtfCodigo, gbc_jtfCodigo);
		jtfCodigo.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Url classroom:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 8;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jtfUrl = new JTextField();
		GridBagConstraints gbc_jtfUrl = new GridBagConstraints();
		gbc_jtfUrl.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUrl.gridwidth = 2;
		gbc_jtfUrl.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUrl.gridx = 1;
		gbc_jtfUrl.gridy = 8;
		contentPane.add(jtfUrl, gbc_jtfUrl);
		jtfUrl.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Fecha inicio:");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 9;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		jtfFechaInicio = new JTextField();
		GridBagConstraints gbc_jtfFechaInicio = new GridBagConstraints();
		gbc_jtfFechaInicio.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaInicio.gridwidth = 2;
		gbc_jtfFechaInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaInicio.gridx = 1;
		gbc_jtfFechaInicio.gridy = 9;
		contentPane.add(jtfFechaInicio, gbc_jtfFechaInicio);
		jtfFechaInicio.setColumns(10);
		
		checkAdmiteMatricula = new JCheckBox("");
		GridBagConstraints gbc_checkAdmiteMatricula = new GridBagConstraints();
		gbc_checkAdmiteMatricula.anchor = GridBagConstraints.EAST;
		gbc_checkAdmiteMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_checkAdmiteMatricula.gridx = 0;
		gbc_checkAdmiteMatricula.gridy = 10;
		contentPane.add(checkAdmiteMatricula, gbc_checkAdmiteMatricula);
		
		JLabel lblNewLabel_10 = new JLabel("Admite matrícula");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 1;
		gbc_lblNewLabel_10.gridy = 10;
		contentPane.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		JButton btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarMateria();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridwidth = 3;
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 11;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 12;
		contentPane.add(panel, gbc_panel);
		
		cargarListaCentrosEducativos();
	}

	/**
	 * 
	 */
	private void cargarListaCentrosEducativos () {
		List<CentroEducativo> lista = ControladorCentro.findAll();
		
		for (CentroEducativo c : lista) {
			this.jcbCentro.addItem(c);
		}
	}
	
	/**
	 * 
	 */
	private void cargarNivelesDeCentro() {
		CentroEducativo c =	(CentroEducativo) this.jcbCentro.getSelectedItem();
		
		this.jcbNivel.removeAllItems();
		
		List<Nivel> niveles = ControladorNivel.findAllByIdCentro(c.getId());
		for (Nivel n : niveles) {
			this.jcbNivel.addItem(n);
		}
	}
	
	/**
	 * 
	 */
	private void cargarMateriasDeNivel() {
		Nivel n = (Nivel) this.jcbNivel.getSelectedItem();
		
		this.jcbMateria.removeAllItems();
		
		List<Materia> materias = ControladorMateria.findAllByIdNivel(n.getId());
		for (Materia m : materias) {
			this.jcbMateria.addItem(m);
		}
	}
	
	/**
	 * 
	 */
	private void cargarDatosMateria() {
		Materia m = (Materia) this.jcbMateria.getSelectedItem();
		
		if (m != null) {
			this.jtfId.setText("" + m.getId());
			this.jtfCodigo.setText(m.getCodigo());
			this.jtfNombre.setText(m.getNombre());
			this.jtfUrl.setText(m.getUrlClassroom());
			this.jtfFechaInicio.setText(sdf.format(m.getFechaInicio()));
			this.checkAdmiteMatricula.setSelected(m.isAdmiteMatricula());
		}
	}
	
	
	/**
	 * 
	 */
	private void guardarMateria() {
		
		if (!isCodigoValido()) {
			JOptionPane.showMessageDialog(null, "El código indicado no tiene al menos tres letras");
			return;
		}
		
		if (!isUrlValida()) {
			JOptionPane.showMessageDialog(null, "La url debe comenzar por http o https");
			return;
		}
		
		Materia m = new Materia();
		
		m.setId(Integer.parseInt(this.jtfId.getText()));
		m.setCodigo(this.jtfCodigo.getText());
		m.setNombre(this.jtfNombre.getText());
		m.setUrlClassroom(this.jtfUrl.getText());
		try {
			m.setFechaInicio(sdf.parse(this.jtfFechaInicio.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		m.setAdmiteMatricula(this.checkAdmiteMatricula.isSelected());
		
		if (ControladorMateria.modificar(m) == 1) {
			JOptionPane.showMessageDialog(null, "Modificado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "NO se ha modificado correctamente");			
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean isCodigoValido () {
		String codigo = this.jtfCodigo.getText();
		int contLetras = 0;
		
		for (int i = 0; i < codigo.length(); i++) {
			if (Character.isLetter(codigo.charAt(i))) {
				contLetras++;
			}
		}
		
		if (contLetras > 2) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean isUrlValida() {
		String url = this.jtfUrl.getText().toUpperCase();
		if (url.startsWith("HTTP") || url.startsWith("HTTPS")) {
			return true;
		}
		return false;
	}
	
}


