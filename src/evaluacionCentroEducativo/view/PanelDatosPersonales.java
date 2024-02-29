package evaluacionCentroEducativo.view;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;


import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.awt.event.ActionEvent;


import evaluacionCentroEducativo.controller.ControladorSexo;
import evaluacionCentroEducativo.model.TipologiaSexo;
import evaluacionCentroEducativo.model.Profesor;
import evaluacionCentroEducativo.model.Estudiante;
import evaluacionCentroEducativo.controller.ControladorValoracion;



public class PanelDatosPersonales extends JPanel {
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfApellido;
	private JTextField jtfSegundoApellido;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private JComboBox<TipologiaSexo> jcbSexo;
	private List<TipologiaSexo> sexos;
	private final JButton btnNewButton = new JButton("Escoger imagen");
	private byte[] imagenEnArrayDeBytes;
	JScrollPane scrollPane;
	private JButton btnNewButton_1;
	JColorChooser jColorChooser;
	JPanel jpPanelParaColorear = new JPanel();
	private JTextField jtfColor;
	private JLabel lblNewLabel_9;

	/**
	 * Create the panel.
	 */
	public PanelDatosPersonales() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[] { 150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWidths = new int[] { 0, 0, 345, 296 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0 };
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("id");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 2;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 2;
		gbc_jtfNombre.gridy = 2;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Apellido");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfApellido = new JTextField();
		GridBagConstraints gbc_jtfApellido = new GridBagConstraints();
		gbc_jtfApellido.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido.gridx = 2;
		gbc_jtfApellido.gridy = 3;
		add(jtfApellido, gbc_jtfApellido);
		jtfApellido.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Segundo apellido");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfSegundoApellido = new JTextField();
		GridBagConstraints gbc_jtfSegundoApellido = new GridBagConstraints();
		gbc_jtfSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSegundoApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSegundoApellido.gridx = 2;
		gbc_jtfSegundoApellido.gridy = 4;
		add(jtfSegundoApellido, gbc_jtfSegundoApellido);
		jtfSegundoApellido.setColumns(10);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 4;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elegirImagen();
			}
		});
		add(btnNewButton, gbc_btnNewButton);

		JLabel lblNewLabel_4 = new JLabel("Sexo");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jcbSexo = new JComboBox<TipologiaSexo>();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 2;
		gbc_jcbSexo.gridy = 5;
		add(jcbSexo, gbc_jcbSexo);

		JLabel lblNewLabel_5 = new JLabel("DNI");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 2;
		gbc_jtfDni.gridy = 6;
		add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Dirección");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 7;
		add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 2;
		gbc_jtfDireccion.gridy = 7;
		add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 8;
		add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 2;
		gbc_jtfEmail.gridy = 8;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Teléfono");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 9;
		add(lblNewLabel_8, gbc_lblNewLabel_8);

		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 2;
		gbc_jtfTelefono.gridy = 9;
		add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);

		btnNewButton_1 = new JButton("Elegir color");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaColor();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 9;
		add(btnNewButton_1, gbc_btnNewButton_1);

		lblNewLabel_9 = new JLabel("Color preferido");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 10;
		add(lblNewLabel_9, gbc_lblNewLabel_9);

		jtfColor = new JTextField();
		jtfColor.setEditable(false);
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 0, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 2;
		gbc_jtfColor.gridy = 10;
		add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);

		try {
			sexos = new ArrayList<TipologiaSexo>();
			sexos = ControladorSexo.allRegisters();
			for (int i = 0; i < sexos.size(); i++) {
				jcbSexo.addItem(sexos.get(i));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	private void elegirImagen() {
		JFileChooser jfileChooser = new JFileChooser();

		// Tipo de selección que se hace en el diálogo
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Sólo selecciona ficheros

		// Filtro del tipo de ficheros que puede abrir
		jfileChooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() && (f.getAbsolutePath().toLowerCase().endsWith(".jpg")
						|| f.getAbsolutePath().toLowerCase().endsWith(".jpeg")
						|| f.getAbsolutePath().toLowerCase().endsWith(".png")
						|| f.getAbsolutePath().toLowerCase().endsWith(".gif"))))
					return true;
				return false;
			}
		});

		// Abro el diálogo para la elección del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);

		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();

			if (fichero.isFile()) {
				try {
					this.imagenEnArrayDeBytes = Files.readAllBytes(fichero.toPath());
					mostrarImagen();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

	}

	private void mostrarImagen() {
		if (imagenEnArrayDeBytes != null && imagenEnArrayDeBytes.length > 0) {
			ImageIcon icono = new ImageIcon(imagenEnArrayDeBytes);
			JLabel lblIcono = new JLabel(icono);
			scrollPane.setViewportView(lblIcono);
		} else {
			JLabel lblIcono = new JLabel("Sin imagen");
			scrollPane.setViewportView(lblIcono);
		}
	}

	private void mostrarImagen(byte[] imagen) {
		if (imagen != null && imagen.length > 0) {
			ImageIcon icono = new ImageIcon(imagen);
			JLabel lblIcono = new JLabel(icono);
			scrollPane.setViewportView(lblIcono);
		} else {
			JLabel lblIcono = new JLabel("Sin imagen");
			scrollPane.setViewportView(lblIcono);
		}
	}

	public void limpiarScrollpane() {
		JLabel lblIcono = new JLabel("Sin imagen");
		scrollPane.setViewportView(lblIcono);
	}

	private void seleccionaColor() {
		Color color = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no será nulo
		if (color != null) {
			String strColor = "#" + Integer.toHexString(color.getRGB()).substring(2);
			this.jtfColor.setText(strColor);
			this.jpPanelParaColorear.setBackground(color);
			this.setBackground(color);

		}

	}

	public String getId() {
		return jtfId.getText();

	}

	public String getColor() {
		return jtfColor.getText();

	}

	public String getNombre() {
		return jtfNombre.getText();

	}

	public String getApellido() {
		return jtfApellido.getText();

	}

	public String getSegundoApellido() {
		return jtfSegundoApellido.getText();

	}

	public TipologiaSexo getSexo() {
		return (TipologiaSexo) jcbSexo.getSelectedItem();

	}

	public String getDni() {
		return jtfDni.getText();

	}

	public String getDireccion() {
		return jtfDireccion.getText();

	}

	public String getEmail() {
		return jtfEmail.getText();

	}

	public String getTelefono() {
		return jtfTelefono.getText();

	}

	public byte[] getImagen() {
		return this.imagenEnArrayDeBytes;

	}

	public void setId(int id) {
		jtfId.setText("" + id);

	}

	public void setImagen(byte[] imagen) {
		mostrarImagen(imagen);

	}

	public void setNombre(String nombre) {
		jtfNombre.setText(nombre);
	}

	public void setColor(String color) {
		jtfColor.setText(color);
		if (color == null || color.isBlank() == true || color.isEmpty() == true) {
			this.setBackground(Color.WHITE);

		} else {
			Color colorPanel = Color.decode(color);
			this.setBackground(colorPanel);

		}

	}

	public void setApellido(String apellido) {
		jtfApellido.setText(apellido);
	}

	public void setSegundoApellido(String apellido) {

		jtfSegundoApellido.setText(apellido);

	}

	public void setDni(String dni) {

		jtfDni.setText(dni);

	}

	public void setDireccion(String direccion) {

		jtfDireccion.setText(direccion);

	}

	public void setEmail(String email) {

		jtfEmail.setText(email);

	}

	public void setTelefono(String telefono) {

		jtfTelefono.setText(telefono);

	}

	public void setSexo(int sexo) {

		for (int i = 0; i < sexos.size(); i++) {
			if (sexo == sexos.get(i).getId()) {
				TipologiaSexo sexoASeleccionar = sexos.get(i);
				jcbSexo.setSelectedItem(sexoASeleccionar);
				break;
			}

		}
	}

	public void limpiarCampos() {
		jtfNombre.setText("");
		jtfId.setText("");
		jtfEmail.setText("");
		jtfDni.setText("");
		jtfDireccion.setText("");
		jtfTelefono.setText("");
		jtfApellido.setText("");
		jtfSegundoApellido.setText("");
		setImagen(null);

	}

}
