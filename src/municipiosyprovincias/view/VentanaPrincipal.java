package municipiosyprovincias.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import municipiosyprovincias.controller.MunicipioController;
import municipiosyprovincias.controller.ProvinciaController;
import municipiosyprovincias.model.Municipio;
import municipiosyprovincias.model.Provincia;

public class VentanaPrincipal extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jtf1;
	private JTextField jtfmunicipio;
	private JButton btnFiltrar;
	private JButton btnSelec;
	private JButton btnGuardar;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox<Municipio> jcbMunicipio;
	private JComboBox<Provincia> jcbProvincia;
	
public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}							
			}			
		});
	}
	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		jtf1 = new JTextField();
		GridBagConstraints gbc_jtf1 = new GridBagConstraints();
		gbc_jtf1.insets = new Insets(0, 0, 5, 5);
		gbc_jtf1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf1.gridx = 0;
		gbc_jtf1.gridy = 0;
		getContentPane().add(jtf1, gbc_jtf1);
		jtf1.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMunicipios();
			}
		});
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnFiltrar.gridx = 1;
		gbc_btnFiltrar.gridy = 0;
		getContentPane().add(btnFiltrar, gbc_btnFiltrar);
		
		jcbMunicipio = new JComboBox();
		GridBagConstraints gbc_jcbSelec = new GridBagConstraints();
		gbc_jcbSelec.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSelec.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSelec.gridx = 0;
		gbc_jcbSelec.gridy = 1;
		getContentPane().add(jcbMunicipio, gbc_jcbSelec);
		
		btnSelec = new JButton("Seleccionar");
		btnSelec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMunicipio();
			}
		});
		GridBagConstraints gbc_btnSelec = new GridBagConstraints();
		gbc_btnSelec.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelec.gridx = 1;
		gbc_btnSelec.gridy = 1;
		getContentPane().add(btnSelec, gbc_btnSelec);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 0;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWeights = new double[]{0.0, 1.0};
//		gbl_panel.columnWidths = new int[]{0};
//		gbl_panel.rowHeights = new int[]{0};
//		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblNewLabel = new JLabel("Municipio Selecionado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nombre del municipio:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfmunicipio = new JTextField();
		GridBagConstraints gbc_jtfmunicipio = new GridBagConstraints();
		gbc_jtfmunicipio.insets = new Insets(0, 0, 5, 0);
		gbc_jtfmunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfmunicipio.gridx = 1;
		gbc_jtfmunicipio.gridy = 1;
		panel.add(jtfmunicipio, gbc_jtfmunicipio);
		jtfmunicipio.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Provincia del municipio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbProvincia = new JComboBox();
		GridBagConstraints gbc_jcbProvincia = new GridBagConstraints();
		gbc_jcbProvincia.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProvincia.gridx = 1;
		gbc_jcbProvincia.gridy = 2;
		panel.add(jcbProvincia, gbc_jcbProvincia);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setHorizontalAlignment(SwingConstants.RIGHT);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 3;
		panel.add(btnGuardar, gbc_btnGuardar);
		
		getProvincias();
		
	}

	/**
	 * Método para obtener las provincias
	 */
	private void getProvincias() {
		jcbProvincia.removeAllItems();
		List<Provincia> l = ProvinciaController.findAll();
		for (Provincia o : l) {
			jcbProvincia.addItem(o);
		}
	}
	
	/**
	 * Método para obtener los municipios
	 */
	private void getMunicipios() {
		jcbMunicipio.removeAllItems();
		List<Municipio> l = MunicipioController.findByLikeName(jtf1.getText());
		for (Municipio o : l) {
			jcbMunicipio.addItem(o);
		}
	}
	
	/**
	 * Método para obtener los datos de un municipio
	 */
	private void getMunicipio() {
		Municipio o = (Municipio) jcbMunicipio.getSelectedItem();
		jtfmunicipio.setText(o.getNombre());
		for (int i = 0; i < jcbProvincia.getItemCount(); i++) {
			Provincia p = jcbProvincia.getItemAt(i);
			if (o.getProvincia().getProvincia() == p.getProvincia()) {
				jcbProvincia.setSelectedIndex(i);
			}
		}
	}

	/**
	 * Método para guardar los datos
	 */
	private void guardar() {
		
		Municipio o = (Municipio) jcbMunicipio.getSelectedItem();
		o.setNombre(jtfmunicipio.getText());
		o.setProvincia((Provincia) jcbProvincia.getSelectedItem());
		MunicipioController.update(o);
		
	}
	
	
}
