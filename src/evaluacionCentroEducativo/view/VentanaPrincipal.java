package evaluacionCentroEducativo.view;

import java.awt.EventQueue;
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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;


import evaluacionCentroEducativo.utils.Apariencia;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame {
	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}
	
	
	public VentanaPrincipal () {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 578, 375);

		
		JTabbedPane tabedPane = new JTabbedPane();
		
		this.setJMenuBar(new Menu(tabedPane));
		
		tabedPane.add("Cursos", new PanelCurso());
		
		tabedPane.add("Estudiante", new PanelEstudiante());
		
		tabedPane.add("Materias", new PanelMateria());
		
		PanelProfesor panelProfesor = new PanelProfesor();
		GridBagLayout gridBagLayout = (GridBagLayout) panelProfesor.getLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
		tabedPane.add("Profesor", panelProfesor);
		
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 6;
		panelProfesor.add(comboBox, gbc_comboBox);
		
		tabedPane.add("Valoración", new PanelValoracion());
		
		this.setContentPane(tabedPane);
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(true);
	}
}


