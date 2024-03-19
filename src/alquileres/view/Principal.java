package alquileres.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import alquileres.controller.ControladorInquilino;
import alquileres.controller.ControladorLocalidad;
import alquileres.controller.ControladorVivienda;
import alquileres.model.Inquilino;
import alquileres.model.Localidad;
import alquileres.model.Vivienda;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfDni;
	private JTextField jtfNombre;
	private JTextField jtfFInicio;
	private JTextField jtfFFin;
	private JTextField jtfCuota;
	JComboBox<Localidad> jcbLocalidad;
	JComboBox<Vivienda> jcbVivienda;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	JCheckBox chckbxNewCheckBox;
	JLabel lblNewLabel_11;

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
		setBounds(100, 100, 450, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0 };
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0};
//		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Modificación de alquileres");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.weightx = 1.0;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Localidad:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbLocalidad = new JComboBox<Localidad>();
		jcbLocalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarViviendaPorLocalidad();
			}
		});
		GridBagConstraints gbc_jcbLocalidad = new GridBagConstraints();
		gbc_jcbLocalidad.insets = new Insets(0, 0, 5, 0);
		gbc_jcbLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbLocalidad.gridx = 1;
		gbc_jcbLocalidad.gridy = 1;
		contentPane.add(jcbLocalidad, gbc_jcbLocalidad);

		JLabel lblNewLabel_2 = new JLabel("Vivienda:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcbVivienda = new JComboBox<Vivienda>();
		jcbVivienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarInquilinoPorVivienda();
			}
		});
		GridBagConstraints gbc_jcbVivienda = new GridBagConstraints();
		gbc_jcbVivienda.insets = new Insets(0, 0, 5, 0);
		gbc_jcbVivienda.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbVivienda.gridx = 1;
		gbc_jcbVivienda.gridy = 2;
		contentPane.add(jcbVivienda, gbc_jcbVivienda);

		JLabel lblNewLabel_3 = new JLabel("Datos del inquilino");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 4;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		contentPane.add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Nombre completo:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 6;
		contentPane.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Fecha inicio:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfFInicio = new JTextField();
		GridBagConstraints gbc_jtfFInicio = new GridBagConstraints();
		gbc_jtfFInicio.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFInicio.gridx = 1;
		gbc_jtfFInicio.gridy = 7;
		contentPane.add(jtfFInicio, gbc_jtfFInicio);
		jtfFInicio.setColumns(10);

		chckbxNewCheckBox = new JCheckBox("Alquiler en activo");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()==true) {
					jtfFFin.setEnabled(false);
					jtfFFin.setText("");
				}else {
					jtfFFin.setEnabled(true);
					Vivienda c = (Vivienda) jcbVivienda.getSelectedItem();
					if (c != null) {
						Inquilino m = ControladorInquilino.findAllByIdVivienda(c.getId());
						jtfFFin.setText(sdf.format(m.getFechaFinAlquiler()));
				}
			}
			}
		});
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 8;
		contentPane.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		JLabel lblNewLabel_8 = new JLabel("Fecha de fin:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);

		jtfFFin = new JTextField();
		GridBagConstraints gbc_jtfFFin = new GridBagConstraints();
		gbc_jtfFFin.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFFin.gridx = 1;
		gbc_jtfFFin.gridy = 9;
		contentPane.add(jtfFFin, gbc_jtfFFin);
		jtfFFin.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Cuota mensual (€):");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 10;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);

		jtfCuota = new JTextField();
		GridBagConstraints gbc_jtfCuota = new GridBagConstraints();
		gbc_jtfCuota.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCuota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCuota.gridx = 1;
		gbc_jtfCuota.gridy = 10;
		contentPane.add(jtfCuota, gbc_jtfCuota);
		jtfCuota.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Total mensual (IVA incluido) (€):");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 11;
		contentPane.add(lblNewLabel_10, gbc_lblNewLabel_10);

		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarDNI(jtfDni.getText());
				validarUusario();
				if((validarDNI(jtfDni.getText()) && validarUusario()) == true) {
					guardarInquilino();
				}
			}
		});
			
		lblNewLabel_11 = new JLabel();
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_11.gridx = 1;
		gbc_lblNewLabel_11.gridy = 11;
		contentPane.add(lblNewLabel_11, gbc_lblNewLabel_11);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 12;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		cargarCBLocalidad();
	}

	/**
	 * 
	 */
	private void cargarCBLocalidad() {
		List<Localidad> lista = ControladorLocalidad.findAll();

		for (Localidad c : lista) {
			this.jcbLocalidad.addItem(c);
		}
	}

	/**
	 * 
	 */
	private void cargarViviendaPorLocalidad() {
		Localidad c = (Localidad) this.jcbLocalidad.getSelectedItem();

		this.jcbVivienda.removeAllItems();

		List<Vivienda> niveles = ControladorVivienda.findAllByIdLocalidad(c.getId());
		for (Vivienda n : niveles) {
			this.jcbVivienda.addItem(n);
		}
	}

	/**
     * 
     */
    private void cargarInquilinoPorVivienda() {
        Vivienda m = (Vivienda) this.jcbVivienda.getSelectedItem();

        if (m != null) {

            Inquilino i = ControladorInquilino.findAllByIdVivienda(m.getId());

            this.jtfId.setText("" + m.getId());
            this.jtfDni.setText(i.getDni());
            this.jtfNombre.setText(i.getNombreCompleto());
            this.jtfFInicio.setText(sdf.format(i.getFechaInicioAlquiler()));

            if (i.getFechaFinAlquiler() == null) {
            	chckbxNewCheckBox.setSelected(false);
                this.jtfFFin.setText("");
            } else {
            	chckbxNewCheckBox.setSelected(true);
                this.jtfFFin.setText(sdf.format(i.getFechaFinAlquiler()));
            }
            this.jtfCuota.setText(""+i.getCuotaMensual());
        }
    }
	
	
	/**
	 * 
	 */
	private void guardarInquilino() {
		
		
		Inquilino m = new Inquilino();
		
		Vivienda n = (Vivienda) this.jcbVivienda.getSelectedItem();
		m.setIdVivienda(n.getId());
		m.setId(Integer.parseInt(this.jtfId.getText()));
		m.setDni(this.jtfDni.getText());
		m.setNombreCompleto(this.jtfNombre.getText());
		try {
			m.setFechaInicioAlquiler(sdf.parse(this.jtfFInicio.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			m.setFechaFinAlquiler(sdf.parse(this.jtfFFin.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(jtfFFin.getText().isEmpty()) {
			try {
				m.setFechaFinAlquiler(sdf.parse("null"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				m.setFechaFinAlquiler(sdf.parse(this.jtfFFin.getText()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(jtfFInicio.getText().isEmpty()) {
			try {
				m.setFechaInicioAlquiler(sdf.parse("null"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				m.setFechaInicioAlquiler(sdf.parse(this.jtfFInicio.getText()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (ControladorInquilino.modificar(m) == 1) {
			JOptionPane.showMessageDialog(null, "Modificado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "Error al modificar");
		}
	}

	/**
	 * 
	 * @param dni
	 * @return
	 */
	public static boolean validarDNI(String dni) {

		return dni != null && dni.matches("[a-zA-Z]{8}[0-9]");
	}

	
	private boolean validarUusario() {
		String usuario = jtfNombre.getText();

		if (usuario.isEmpty()) {
		    JOptionPane.showMessageDialog(null, "El campo nombre debe de contener al menos un caracter", "Error", JOptionPane.ERROR_MESSAGE);
		    return false;
		} else {
		    return true;
		}

	}
	
	

}
