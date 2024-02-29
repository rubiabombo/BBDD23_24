package capitulo9.gestionCentroEducativo.views;

import javax.swing.JPanel;

import capitulo9.gestionCentroEducativo.model.Estudiante;

import java.awt.BorderLayout;

public class PanelEstudiante extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelDatosPersonales panelDatos = new PanelDatosPersonales();

	/**
	 * Create the panel.
	 */
	public PanelEstudiante() {
		setLayout(new BorderLayout(0, 0));
		this.add(panelDatos, BorderLayout.CENTER);
		
		this.panelDatos.setRunnableMostrarPrimerRegistro(
				new Runnable() {					
					@Override
					public void run() {
						mostrarPrimero();
					}
				});		
	}

	
	private void mostrarPrimero() {
		// En teoría aquí se produce una llamada a un controlador de estudiante
		// que obtiene un objeto de tipo estudiante y que lo envía para ser
		// mostrado
		Estudiante mockEstudiante = new Estudiante();
		mockEstudiante.setId(1);
		mockEstudiante.setNombre("Rafa");
		mostrarEntidad(mockEstudiante);		
	}
	
	
	private void mostrarEntidad(Estudiante e) {
		this.panelDatos.setId(e.getId());
	}
	
}






