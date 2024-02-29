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
		
		tabedPane.add("Profesor", new PanelProfesor());
		
		tabedPane.add("Estudiante", new PanelEstudiante());
		
		tabedPane.add("Materias", new PanelMateria());
		
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


