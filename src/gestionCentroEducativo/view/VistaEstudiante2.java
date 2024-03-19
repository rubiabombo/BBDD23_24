package gestionCentroEducativo.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gestionCentroEducativo.controller.ControladorEstudiante;
import gestionCentroEducativo.model.Estudiante;


public class VistaEstudiante2 extends JPanel {
	private PanelDatosPersonales datosPersonales;

	/**
	 * Create the panel.
	 */

	public VistaEstudiante2() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0 };
//		gridBagLayout.columnWidths = new int[]{0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Gestión Estudiante");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		datosPersonales = new PanelDatosPersonales();
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weighty = 1.0;
		gbc_lblNewLabel_1.weightx = 1.0;
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(datosPersonales, gbc_lblNewLabel_1);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);

		JButton btnNewButton = new JButton("<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datosPersonales.limpiarCampos();
				Estudiante es = new Estudiante();
				try {
					es = ControladorEstudiante.firstRegister();
					cargarDatos(es);
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
				Estudiante es = new Estudiante();
				if (datosPersonales.getId().isEmpty()) {
					try {
						es = ControladorEstudiante.firstRegister();
						cargarDatos(es);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					es.setId(Integer.parseInt(datosPersonales.getId()));
					try {
						es = ControladorEstudiante.previousRegister(es);
						if (es != null) {
						cargarDatos(es);
						}
						else {}
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
				Estudiante es = new Estudiante();
				if (datosPersonales.getId().isEmpty()) {
					try {
						es = ControladorEstudiante.firstRegister();
						cargarDatos(es);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					es.setId(Integer.parseInt(datosPersonales.getId()));
					try {
						es = ControladorEstudiante.nextRegister(es);
						if (es != null) {
						cargarDatos(es);
						}
						else {
							
						}
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
				datosPersonales.limpiarCampos();
				Estudiante es = new Estudiante();
				try {
					es = ControladorEstudiante.lastRegister();
					cargarDatos(es);
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

				String prueba = datosPersonales.getId();

				Estudiante estu = obtenerDatos();

				if (prueba == "0" || prueba.isBlank() == true) {

					estu.setId(0);
					try {
						insertarRegistro(estu);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				} else {

					try {
						estu.setId(Integer.parseInt(datosPersonales.getId()));
						actualizarRegistro(estu);
					} catch (SQLException e1) {
						JOptionPane.showConfirmDialog(null, "Fallo");

					}

				}

			}
		});
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Limpiar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				datosPersonales.limpiarCampos();
			}
		});
		panel.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Eliminar");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Estudiante estu = obtenerDatos();
				try {
					confirmarDelete(estu);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_6);

	}

	public void cargarDatos(Estudiante es) {
		datosPersonales.setId(es.getId());
		datosPersonales.setNombre(es.getNombre());
		datosPersonales.setApellido(es.getApellido1());
		datosPersonales.setSegundoApellido(es.getApellido2());
		datosPersonales.setDni(es.getDni());
		datosPersonales.setDireccion(es.getDireccion());
		datosPersonales.setEmail(es.getEmail());
		datosPersonales.setTelefono(es.getTelefono());
		datosPersonales.setSexo(es.getIdTipologiaSexo());
		if (es.getImagen() == null) {
			datosPersonales.limpiarScrollpane();
		} else {
			datosPersonales.setImagen(es.getImagen());

		}
		datosPersonales.setColor(es.getColorPreferido());

	}

	public Estudiante obtenerDatos() {

		Estudiante es = new Estudiante();
		if (datosPersonales.getId().isBlank() == false) {
			es.setId(Integer.parseInt(datosPersonales.getId()));
		} else {

		}

		es.setNombre(datosPersonales.getNombre());
		es.setApellido1(datosPersonales.getApellido1());
		es.setApellido2(datosPersonales.getApellido2());
		es.setDni(datosPersonales.getDni());
		es.setDireccion(datosPersonales.getDireccion());
		es.setEmail(datosPersonales.getEmail());
		es.setTelefono(datosPersonales.getTelefono());
		es.setIdTipologiaSexo(datosPersonales.getSexo().getId());
		es.setImagen(datosPersonales.getImagen());
		es.setColorPreferido(datosPersonales.getColor());

		return es;
	}

	public void insertarRegistro(Estudiante e) throws SQLException {

		if (ControladorEstudiante.insertRegister(e) != 1) {
			JOptionPane.showConfirmDialog(null, "Algo ha salido mal.");
		} else {
			JOptionPane.showConfirmDialog(null, "Guardado correctamente.");

		}

	}

	public void actualizarRegistro(Estudiante e) throws SQLException {

		if (ControladorEstudiante.updateRegister(e) != 1) {
			JOptionPane.showConfirmDialog(null, "Algo ha salido mal.");
		} else {
			JOptionPane.showConfirmDialog(null, "Guardado correctamente.");

		}

	}

	public void realizarDelete(Estudiante e) throws SQLException {

		if (ControladorEstudiante.deleteRegister(e) != 1) {
			JOptionPane.showConfirmDialog(null, "Algo ha salido mal.");
		} else {
			JOptionPane.showConfirmDialog(null, "Eliminado correctamente.");

		}
	}

	private void confirmarDelete(Estudiante e) throws SQLException {
		String[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(null, "¿Desea borrar el registro?", "Salir de la aplicación",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			realizarDelete(e);
			datosPersonales.limpiarCampos();
		}
	}

}
