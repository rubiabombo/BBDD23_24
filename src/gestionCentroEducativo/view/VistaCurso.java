package gestionCentroEducativo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestionCentroEducativo.controller.ControladorCurso;
import gestionCentroEducativo.model.Curso;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VistaCurso extends JPanel {

	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfDesc;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VistaCurso() {
		setBounds(100, 100, 578, 375);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0 };
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		this.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Gestión de cursos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
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
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		this.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Descripción");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		this.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfDesc = new JTextField();
		GridBagConstraints gbc_jtfDesc = new GridBagConstraints();
		gbc_jtfDesc.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDesc.gridx = 1;
		gbc_jtfDesc.gridy = 2;
		this.add(jtfDesc, gbc_jtfDesc);
		jtfDesc.setColumns(10);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
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

				Curso curso = new Curso();
				if (jtfId.getText().isEmpty()) {
					try {
						cargarPrimerRegistro();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					curso.setId(Integer.parseInt(jtfId.getText()));
					try {
						cargarAnteriorRegistro(curso);
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

				Curso curso = new Curso();
				if (jtfId.getText().isEmpty()) {
					try {
						cargarPrimerRegistro();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					curso.setId(Integer.parseInt(jtfId.getText()));
					try {
						cargarSiguienteRegistro(curso);
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

				Curso curso = new Curso();

				curso.setDescripcion(jtfDesc.getText());

				if (jtfId.getText().isEmpty() == false) {
					try {
						curso.setId(Integer.parseInt(jtfId.getText()));
						actualizarRegistro(curso);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					curso.setId(0);
					try {
						insertarRegistro(curso);
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

				Curso curso = new Curso();
				curso.setId(Integer.parseInt(jtfId.getText()));
				try {
					confirmarDelete(curso);
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

		Curso c = ControladorCurso.firstRegister();

		jtfId.setText("" + c.getId());
		jtfDesc.setText(c.getDescripcion());
	}

	/**
	 * 
	 * @throws SQLException
	 */

	public void cargarUltimoRegistro() throws SQLException {

		Curso c = ControladorCurso.lastRegister();

		jtfId.setText("" + c.getId());
		jtfDesc.setText(c.getDescripcion());
	}

	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	public void cargarSiguienteRegistro(Curso curso) throws SQLException {

		Curso c = ControladorCurso.nextRegister(curso);

		jtfId.setText("" + c.getId());
		jtfDesc.setText(c.getDescripcion());
	}

	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	public void cargarAnteriorRegistro(Curso curso) throws SQLException {

		Curso c = ControladorCurso.previousRegister(curso);

		jtfId.setText("" + c.getId());
		jtfDesc.setText(c.getDescripcion());
	}

	/**
	 * 
	 * @param curso
	 * @throws SQLException
	 */

	public void actualizarRegistro(Curso curso) throws SQLException {

		if (ControladorCurso.updateRegister(curso) != 1) {
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

	public void insertarRegistro(Curso curso) throws SQLException {

		if (ControladorCurso.insertRegister(curso) != 1) {
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

	public void realizarDelete(Curso curso) throws SQLException {
		
		if (ControladorCurso.deleteRegister(curso) != 1) {
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
	
	private void confirmarDelete(Curso curso) throws SQLException {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(null,"¿Desea borrar el registro?","Salir de la aplicación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			realizarDelete(curso);
			limpiarCampos();
		}
	}
	
	/**
	 * 
	 */

	private void limpiarCampos() {
		jtfDesc.setText("");
		jtfId.setText("");
	}

}
