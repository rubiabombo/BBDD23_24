package gestionCentroEducativo.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gestionCentroEducativo.controller.ControladorMateria;
import gestionCentroEducativo.controller.ControladorValoracion;
import gestionCentroEducativo.model.Estudiante;
import gestionCentroEducativo.model.Materia;
import gestionCentroEducativo.model.Profesor;
import gestionCentroEducativo.model.ValoracionMateria;



public class VistaValoracion extends JPanel {
	private JTextField jtfId;
	private JTextField jtfVal;
	private JComboBox<Profesor> jcbProfesor;
	private JComboBox<Estudiante> jcbEstudiante;
	private JComboBox<Materia> jcbMateria;
	private List<Profesor> profesor;
	private List<Estudiante> estudiante;
	private List<Materia> materia;

	/**
	 * Create the panel.
	 */
	public VistaValoracion() {
		setBounds(100, 100, 586, 375);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0 };
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		this.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Gestión de valoraciones");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		this.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Valoración");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		this.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfVal = new JTextField();
		GridBagConstraints gbc_jtfVal = new GridBagConstraints();
		gbc_jtfVal.insets = new Insets(0, 0, 5, 5);
		gbc_jtfVal.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfVal.gridx = 1;
		gbc_jtfVal.gridy = 2;
		add(jtfVal, gbc_jtfVal);
		jtfVal.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Profesor");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbCurso = new GridBagConstraints();
		gbc_jcbCurso.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCurso.gridx = 1;
		gbc_jcbCurso.gridy = 4;
		add(jcbProfesor, gbc_jcbCurso);

		try {
			profesor = new ArrayList<Profesor>();
			profesor = ControladorValoracion.allRegistersProfesor();
			for (int i = 0; i < profesor.size(); i++) {
				jcbProfesor.addItem(profesor.get(i));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JLabel lblNewLabel_4 = new JLabel("Estudiante");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcbEstudiante = new JComboBox<Estudiante>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		add(jcbEstudiante, gbc_comboBox);
		
		try {
			estudiante = new ArrayList<Estudiante>();
			estudiante = ControladorValoracion.allRegistersEstudiante();
			for (int i = 0; i < estudiante.size(); i++) {
				jcbEstudiante.addItem(estudiante.get(i));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JLabel lblNewLabel_5 = new JLabel("Materia");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 6;
		add(jcbMateria, gbc_comboBox_1);
		
		try {
			materia = new ArrayList<Materia>();
			materia = ControladorValoracion.allRegistersMateria();
			for (int i = 0; i < materia.size(); i++) {
				jcbMateria.addItem(materia.get(i));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
		this.add(panel, gbc_panel);

		JButton btnNewButton = new JButton("<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarPrimerRegistro();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ValoracionMateria valm = new ValoracionMateria();
				if (jtfId.getText().isEmpty()) {
					try {
						cargarPrimerRegistro();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					valm.setId(Integer.parseInt(jtfId.getText()));
					try {
						cargarAnteriorRegistro(valm);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton(">");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ValoracionMateria valm = new ValoracionMateria();
				if (jtfId.getText().isEmpty()) {
					try {
						cargarPrimerRegistro();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					valm.setId(Integer.parseInt(jtfId.getText()));
					try {
						cargarSiguienteRegistro(valm);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton(">>");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					cargarUltimoRegistro();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Guardar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ValoracionMateria valoracionMateria = new ValoracionMateria();
				Profesor p = new Profesor();
				Estudiante es = new Estudiante();
				Materia m = new Materia();
				p = (Profesor) jcbProfesor.getSelectedItem();
				es = (Estudiante) jcbEstudiante.getSelectedItem();
				m = (Materia) jcbMateria.getSelectedItem();

				valoracionMateria.setValoracion(Float.parseFloat(jtfVal.getText()));
				valoracionMateria.setIdProfesor(p.getId());
				valoracionMateria.setIdEstudiante(es.getId());
				valoracionMateria.setIdMateria(m.getId());
				
				if (jtfId.getText().isEmpty() == false) {
					try {
						valoracionMateria.setId(Integer.parseInt(jtfId.getText()));
						actualizarRegistro(valoracionMateria);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					try {
						valoracionMateria.setId(ControladorMateria.escogerPrimerIDDisponible());
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						insertarRegistro(valoracionMateria);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Nuevo");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limpiarCampos();
			}
		});
		panel.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Eliminar");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ValoracionMateria valoracionMateria = new ValoracionMateria();				
				valoracionMateria.setId(Integer.parseInt(jtfId.getText()));
				try {
					confirmarDelete(valoracionMateria);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		panel.add(btnNewButton_6);
	}

	/**
	 * 
	 * @throws SQLException
	 */
	public void cargarPrimerRegistro() throws SQLException {

		ValoracionMateria vm = ControladorValoracion.firstRegister();

		jtfId.setText("" + vm.getId());
		jtfVal.setText("" + vm.getValoracion());
		for (int i = 0; i < profesor.size(); i++) {
			if (vm.getIdProfesor() == profesor.get(i).getId()) {
				Profesor profesorASeleccionar = profesor.get(i);
				jcbProfesor.setSelectedItem(profesorASeleccionar);
				break;

			}
		}
		for (int i = 0; i < estudiante.size(); i++) {
			if (vm.getIdEstudiante() == estudiante.get(i).getId()) {
				Estudiante estudianteASeleccionar = estudiante.get(i);
				jcbEstudiante.setSelectedItem(estudianteASeleccionar);
				break;

			}
		}
		for (int i = 0; i < materia.size(); i++) {
			if (vm.getIdMateria() == materia.get(i).getId()) {
				Materia materiaASeleccionar = materia.get(i);
				jcbMateria.setSelectedItem(materiaASeleccionar);
				break;

			}
		}
		

	}

	/**
	 * 
	 * @throws SQLException
	 */

	public void cargarUltimoRegistro() throws SQLException {

		ValoracionMateria vm = ControladorValoracion.lastRegister();

		jtfId.setText("" + vm.getId());
		jtfVal.setText("" + vm.getValoracion());
		for (int i = 0; i < profesor.size(); i++) {
			if (vm.getIdProfesor() == profesor.get(i).getId()) {
				Profesor profesorASeleccionar = profesor.get(i);
				jcbProfesor.setSelectedItem(profesorASeleccionar);
				break;

			}
		}
		for (int i = 0; i < estudiante.size(); i++) {
			if (vm.getIdEstudiante() == estudiante.get(i).getId()) {
				Estudiante estudianteASeleccionar = estudiante.get(i);
				jcbEstudiante.setSelectedItem(estudianteASeleccionar);
				break;

			}
		}
		for (int i = 0; i < materia.size(); i++) {
			if (vm.getIdMateria() == materia.get(i).getId()) {
				Materia materiaASeleccionar = materia.get(i);
				jcbMateria.setSelectedItem(materiaASeleccionar);
				break;

			}
		}

	}

	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	public void cargarSiguienteRegistro(ValoracionMateria valm) throws SQLException {

		ValoracionMateria vm = ControladorValoracion.nextRegister(valm);

		jtfId.setText("" + vm.getId());
		jtfVal.setText("" + vm.getValoracion());
		for (int i = 0; i < profesor.size(); i++) {
			if (vm.getIdProfesor() == profesor.get(i).getId()) {
				Profesor profesorASeleccionar = profesor.get(i);
				jcbProfesor.setSelectedItem(profesorASeleccionar);
				break;

			}
		}
		for (int i = 0; i < estudiante.size(); i++) {
			if (vm.getIdEstudiante() == estudiante.get(i).getId()) {
				Estudiante estudianteASeleccionar = estudiante.get(i);
				jcbEstudiante.setSelectedItem(estudianteASeleccionar);
				break;

			}
		}
		for (int i = 0; i < materia.size(); i++) {
			if (vm.getIdMateria() == materia.get(i).getId()) {
				Materia materiaASeleccionar = materia.get(i);
				jcbMateria.setSelectedItem(materiaASeleccionar);
				break;

			}
		}
	}

	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	public void cargarAnteriorRegistro(ValoracionMateria valm) throws SQLException {

		ValoracionMateria vm = ControladorValoracion.previousRegister(valm);

		jtfId.setText("" + vm.getId());
		jtfVal.setText("" + vm.getValoracion());
		for (int i = 0; i < profesor.size(); i++) {
			if (vm.getIdProfesor() == profesor.get(i).getId()) {
				Profesor profesorASeleccionar = profesor.get(i);
				jcbProfesor.setSelectedItem(profesorASeleccionar);
				break;

			}
		}
		for (int i = 0; i < estudiante.size(); i++) {
			if (vm.getIdEstudiante() == estudiante.get(i).getId()) {
				Estudiante estudianteASeleccionar = estudiante.get(i);
				jcbEstudiante.setSelectedItem(estudianteASeleccionar);
				break;

			}
		}
		for (int i = 0; i < materia.size(); i++) {
			if (vm.getIdMateria() == materia.get(i).getId()) {
				Materia materiaASeleccionar = materia.get(i);
				jcbMateria.setSelectedItem(materiaASeleccionar);
				break;

			}
		}
	}

	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	public void actualizarRegistro(ValoracionMateria vmateria) throws SQLException {

		if (ControladorValoracion.updateRegister(vmateria) != 1) {
			JOptionPane.showConfirmDialog(null, "Algo ha salido mal.");
		} else {
			JOptionPane.showConfirmDialog(null, "Guardado correctamente.");

		}

	}

	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	public void insertarRegistro(ValoracionMateria vmateria) throws SQLException {

		if (ControladorValoracion.insertRegister(vmateria) != 1) {
			JOptionPane.showConfirmDialog(null, "Algo ha salido mal.");
		} else {
			JOptionPane.showConfirmDialog(null, "Guardado correctamente.");

		}

	}

	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	public void realizarDelete(ValoracionMateria vmateria) throws SQLException {

		if (ControladorValoracion.deleteRegister(vmateria) != 1) {
			JOptionPane.showConfirmDialog(null, "Algo ha salido mal.");
		} else {
			JOptionPane.showConfirmDialog(null, "Eliminado correctamente.");

		}
	}

	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	private void confirmarDelete(ValoracionMateria vmateria) throws SQLException {
		String[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(null, "¿Desea borrar el registro?", "Salir de la aplicación",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			realizarDelete(vmateria);
			limpiarCampos();
		}
	}

	/**
	 * 
	 */

	private void limpiarCampos() {
		jtfVal.setText("");
		jtfId.setText("");
	}

}