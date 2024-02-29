package evaluacionCentroEducativo.view;

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

import evaluacionCentroEducativo.controller.ControladorCurso;
import evaluacionCentroEducativo.controller.ControladorMateria;
import evaluacionCentroEducativo.model.Curso;
import evaluacionCentroEducativo.model.Materia;

public class PanelMateria extends JPanel {
	private JTextField jtfId;
	private JTextField jtfNom;
	private JTextField jtfAcron;
	private JComboBox<Curso> jcbCurso;
	private List<Curso> cursos;

	/**
	 * Create the panel.
	 */
	public PanelMateria() {
		setBounds(100, 100, 578, 375);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0 };
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		this.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Gestión de materias");
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

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		this.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfNom = new JTextField();
		GridBagConstraints gbc_jtfNom = new GridBagConstraints();
		gbc_jtfNom.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNom.gridx = 1;
		gbc_jtfNom.gridy = 2;
		add(jtfNom, gbc_jtfNom);
		jtfNom.setColumns(10);

		JLabel acronimo = new JLabel("Acrónimo");
		GridBagConstraints gbc_acronimo = new GridBagConstraints();
		gbc_acronimo.insets = new Insets(0, 0, 5, 5);
		gbc_acronimo.anchor = GridBagConstraints.EAST;
		gbc_acronimo.gridx = 0;
		gbc_acronimo.gridy = 3;
		add(acronimo, gbc_acronimo);

		jtfAcron = new JTextField();
		GridBagConstraints gbc_jtfAcron = new GridBagConstraints();
		gbc_jtfAcron.insets = new Insets(0, 0, 5, 5);
		gbc_jtfAcron.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAcron.gridx = 1;
		gbc_jtfAcron.gridy = 3;
		add(jtfAcron, gbc_jtfAcron);
		jtfAcron.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Curso:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jcbCurso = new JComboBox<Curso>();
		GridBagConstraints gbc_jcbCurso = new GridBagConstraints();
		gbc_jcbCurso.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCurso.gridx = 1;
		gbc_jcbCurso.gridy = 4;
		add(jcbCurso, gbc_jcbCurso);

		try {
			cursos = new ArrayList<Curso>();
			cursos = ControladorCurso.allRegisters();
			for (int i = 0; i < cursos.size(); i++) {
				jcbCurso.addItem(cursos.get(i));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
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

				Materia materia = new Materia();
				if (jtfId.getText().isEmpty()) {
					try {
						cargarPrimerRegistro();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					materia.setId(Integer.parseInt(jtfId.getText()));
					try {
						cargarAnteriorRegistro(materia);
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

				Materia materia = new Materia();
				if (jtfId.getText().isEmpty()) {
					try {
						cargarPrimerRegistro();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					materia.setId(Integer.parseInt(jtfId.getText()));
					try {
						cargarSiguienteRegistro(materia);
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

				Materia materia = new Materia();
				Curso curso = new Curso ();
				curso = (Curso) jcbCurso.getSelectedItem();

				materia.setNombre(jtfNom.getText());
				materia.setAcronimo(jtfAcron.getText());
				materia.setCursoId(curso.getId());
				
				if (jtfId.getText().isEmpty() == false) {
					try {
						materia.setId(Integer.parseInt(jtfId.getText()));
						actualizarRegistro(materia);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					try {
						materia.setId(ControladorMateria.escogerPrimerIDDisponible());
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						insertarRegistro(materia);
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

				Materia materia = new Materia();
				materia.setId(Integer.parseInt(jtfId.getText()));
				try {
					confirmarDelete(materia);
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

		Materia m = ControladorMateria.firstRegister();

		jtfId.setText("" + m.getId());
		jtfNom.setText(m.getNombre());
		jtfAcron.setText(m.getAcronimo());
		for (int i = 0; i < cursos.size(); i++) {
			if (m.getCursoId() == cursos.get(i).getId()) {
				Curso cursoASeleccionar = cursos.get(i);
				jcbCurso.setSelectedItem(cursoASeleccionar);
				break;

			}
		}

	}

	/**
	 * 
	 * @throws SQLException
	 */

	public void cargarUltimoRegistro() throws SQLException {

		Materia m = ControladorMateria.lastRegister();

		jtfId.setText("" + m.getId());
		jtfNom.setText(m.getNombre());
		jtfAcron.setText(m.getAcronimo());
		for (int i = 0; i < cursos.size(); i++) {
			if (m.getCursoId() == cursos.get(i).getId()) {
				Curso cursoASeleccionar = cursos.get(i);
				jcbCurso.setSelectedItem(cursoASeleccionar);
				break;

			}
		}

	}

	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	public void cargarSiguienteRegistro(Materia materia) throws SQLException {

		Materia m = ControladorMateria.nextRegister(materia);

		jtfId.setText("" + m.getId());
		jtfNom.setText(m.getNombre());
		jtfAcron.setText(m.getAcronimo());
		for (int i = 0; i < cursos.size(); i++) {
			if (m.getCursoId() == cursos.get(i).getId()) {
				Curso cursoASeleccionar = cursos.get(i);
				jcbCurso.setSelectedItem(cursoASeleccionar);
				break;

			}
		}
	}

	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	public void cargarAnteriorRegistro(Materia materia) throws SQLException {

		Materia m = ControladorMateria.previousRegister(materia);

		jtfId.setText("" + m.getId());
		jtfNom.setText(m.getNombre());
		jtfAcron.setText(m.getAcronimo());
		for (int i = 0; i < cursos.size(); i++) {
			if (m.getCursoId() == cursos.get(i).getId()) {
				jcbCurso.setSelectedItem(cursos.get(i));

			}
		}
	}

	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	public void actualizarRegistro(Materia materia) throws SQLException {

		if (ControladorMateria.updateRegister(materia) != 1) {
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

	public void insertarRegistro(Materia materia) throws SQLException {

		if (ControladorMateria.insertRegister(materia) != 1) {
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

	public void realizarDelete(Materia materia) throws SQLException {

		if (ControladorMateria.deleteRegister(materia) != 1) {
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

	private void confirmarDelete(Materia materia) throws SQLException {
		String[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(null, "¿Desea borrar el registro?", "Salir de la aplicación",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			realizarDelete(materia);
			limpiarCampos();
		}
	}

	/**
	 * 
	 */

	private void limpiarCampos() {
		jtfNom.setText("");
		jtfId.setText("");
		jtfAcron.setText("");
	}

}