package capitulo9.gestionFabricante;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaFabricante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfCif;
	private JTextField jtfNombre;
	private JPanel panel;
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFabricante frame = new VentanaFabricante();
					frame.setVisible(true);
					frame.cargarPrimero();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaFabricante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Gestión de fabricantes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CIF:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfCif = new JTextField();
		GridBagConstraints gbc_jtfCif = new GridBagConstraints();
		gbc_jtfCif.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCif.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCif.gridx = 1;
		gbc_jtfCif.gridy = 2;
		contentPane.add(jtfCif, gbc_jtfCif);
		jtfCif.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 3;
		contentPane.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		contentPane.add(panel, gbc_panel);
		
		btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimero();
			}
		});
		btnPrimero.setIcon(new ImageIcon("C:\\Users\\sulin\\Desktop\\DAW_23-24\\PROGRAMACION\\TutorialJava2023-24\\src\\tutorialJava\\capitulo9_AWT_SWING\\res\\gotostart.png"));
		panel.add(btnPrimero);
		
		btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAnterior();
			}
		});
		btnAnterior.setIcon(new ImageIcon("C:\\Users\\sulin\\Desktop\\DAW_23-24\\PROGRAMACION\\TutorialJava2023-24\\src\\tutorialJava\\capitulo9_AWT_SWING\\res\\previous.png"));
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarSiguiente();
			}
		});
		btnSiguiente.setIcon(new ImageIcon("C:\\Users\\sulin\\Desktop\\DAW_23-24\\PROGRAMACION\\TutorialJava2023-24\\src\\tutorialJava\\capitulo9_AWT_SWING\\res\\next.png"));
		panel.add(btnSiguiente);
		
		btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarUltimo();
			}
		});
		btnUltimo.setIcon(new ImageIcon("C:\\Users\\sulin\\Desktop\\DAW_23-24\\PROGRAMACION\\TutorialJava2023-24\\src\\tutorialJava\\capitulo9_AWT_SWING\\res\\gotoend.png"));
		panel.add(btnUltimo);
		
		btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		btnNuevo.setIcon(new ImageIcon("C:\\Users\\sulin\\Desktop\\DAW_23-24\\PROGRAMACION\\TutorialJava2023-24\\src\\tutorialJava\\capitulo9_AWT_SWING\\res\\nuevo.png"));
		panel.add(btnNuevo);
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\sulin\\Desktop\\DAW_23-24\\PROGRAMACION\\TutorialJava2023-24\\src\\tutorialJava\\capitulo9_AWT_SWING\\res\\guardar.png"));
		panel.add(btnGuardar);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\sulin\\Desktop\\DAW_23-24\\PROGRAMACION\\TutorialJava2023-24\\src\\tutorialJava\\capitulo9_AWT_SWING\\res\\eliminar.png"));
		panel.add(btnEliminar);
	}
	
	/**
	 * 
	 */
	private void cargarPrimero () {
		try {
			Connection conn = ConnectionManager.getConexion();
			Fabricante f = GestionFabricante.getPrimero(conn);
			cargaFabricanteEnPantalla(f);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 */
	private void cargarAnterior () {
		try {
			String strIdActual = jtfId.getText();
			if (!strIdActual.trim().equals("")) {
				int idActual = Integer.parseInt(strIdActual);
				Connection conn = ConnectionManager.getConexion();
				Fabricante f = GestionFabricante.getAnterior(conn, idActual);
				cargaFabricanteEnPantalla(f);
			}				
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 */
	private void cargarUltimo () {
		try {
			Connection conn = ConnectionManager.getConexion();
			Fabricante f = GestionFabricante.getUltimo(conn);
			cargaFabricanteEnPantalla(f);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	private void cargarSiguiente () {
		try {
			String strIdActual = jtfId.getText();
			if (!strIdActual.trim().equals("")) {
				int idActual = Integer.parseInt(strIdActual);
				Connection conn = ConnectionManager.getConexion();
				Fabricante f = GestionFabricante.getSiguiente(conn, idActual);
				cargaFabricanteEnPantalla(f);
			}				
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	/**
	 * 
	 * @param f
	 */
	private void cargaFabricanteEnPantalla(Fabricante f) {
		if (f != null) {
			jtfId.setText("" + f.getId());
			jtfCif.setText(f.getCif());
			jtfNombre.setText(f.getNombre());
		}
	}

	
	/**
	 * 
	 */
	private void nuevo() {
		this.jtfId.setText("");
		this.jtfCif.setText("");
		this.jtfNombre.setText("");
	}
	
	/**
	 * 
	 */
	private void guardar() {
		try {
			Fabricante f = new Fabricante();
			
			f.setId(-1);
			if (!this.jtfId.getText().trim().equals("")) { // El id tiene número
				f.setId(Integer.parseInt(this.jtfId.getText()));			
			}
			f.setCif(this.jtfCif.getText());
			f.setNombre(this.jtfNombre.getText());

			// Decido si debo insertar o modificar
			Connection conn = ConnectionManager.getConexion();
			if (f.getId() == -1) { // Inserción
				int nuevoId = GestionFabricante.insercion(f, conn);
				this.jtfId.setText("" + nuevoId);
			}
			else {
				GestionFabricante.modificacion(f, conn);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}	
	}
	
	
	/**
	 * 
	 */
	private void eliminar () {
		try {
			String respuestas[] = new String[] {"Sí", "No"};
			int opcionElegida = JOptionPane.showOptionDialog(
					null, 
					"¿Realmente desea eliminar el registro?", 
					"Eliminación de fabricante", 
			        JOptionPane.DEFAULT_OPTION, 
			        JOptionPane.WARNING_MESSAGE, 
			        null, respuestas, 
			        respuestas[1]);
		    
			if(opcionElegida == 0) {
		      if (!this.jtfId.getText().trim().equals("")) {
		    	  int idActual = Integer.parseInt(this.jtfId.getText());
		    	  Connection conn = ConnectionManager.getConexion();
		    	  GestionFabricante.eliminacion(idActual, conn);
		    	  
		    	  //Decido qué registro voy a mostrar en pantalla
		    	  //Voy a comprobar si existe un anterior, si existe lo muestro
		    	  //si no existe anterior compruebo si existe siguiente
		    	  //si existe lo muestro. En caso contrario, no quedan registros
		    	  //asi que muestri en blanco la pantalla.
		    	  Fabricante fabriAMostrar = GestionFabricante.getAnterior(conn, idActual);
		    	  if (fabriAMostrar != null){ //Existe un anterior, lo muestro
		    		  cargaFabricanteEnPantalla(fabriAMostrar);
		    	  }else {
		    		  fabriAMostrar = GestionFabricante.getSiguiente(conn, idActual);
		    		  if(fabriAMostrar !=null) { //Existe un siguiente
		    			  cargaFabricanteEnPantalla(fabriAMostrar);
		    			  }
		    		  else { //No quedan registros en la tabla
		    			  nuevo();	  
		    		  }
		    	  }
		      }
		    }			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}



}
