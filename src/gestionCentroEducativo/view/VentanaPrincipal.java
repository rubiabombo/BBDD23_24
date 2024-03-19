package gestionCentroEducativo.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import gestionCentroEducativo.utils.Apariencia;

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
		
		tabedPane.add("Cursos", new VistaCurso());
		
		tabedPane.add("Profesor", new VistaProfesor2());
		
		tabedPane.add("Estudiante", new VistaEstudiante2());
		
		tabedPane.add("Materias", new VistaMateria());
		
		tabedPane.add("Valoración", new VistaValoracion());
		
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
