package capitulo9.gestionCentroEducativo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import capitulo9.gestionCentroEducativo.views.PanelCurso;
import capitulo9.gestionCentroEducativo.views.PanelMateria;


public class Principal extends JFrame{
	private PanelCurso pc = new PanelCurso ();
	private PanelMateria pm = new PanelMateria ();
	

		private JPanel contentPane;

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
			setBounds(100, 100, 450, 300);

			JMenuBar menuBar = new JMenuBar();
			menuBar.setForeground(Color.BLACK);
			setJMenuBar(menuBar);

			JMenu mnGestion = new JMenu("Gestión");
			mnGestion.setBackground(Color.LIGHT_GRAY);
			mnGestion.setForeground(Color.BLACK);
			menuBar.add(mnGestion);

			JMenuItem mntmCurso = new JMenuItem("Cursos");
			mntmCurso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ventanaPanel(pc, "Cursos");

				}
			});
			mnGestion.add(mntmCurso);

			JMenuItem mntmMateria = new JMenuItem("Materias");
			mntmMateria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ventanaPanel(pm, "Materias");
				}
			});
			mnGestion.add(mntmMateria);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));

			JToolBar toolBar = new JToolBar();
			contentPane.add(toolBar, BorderLayout.NORTH);

			JButton btnCursos = new JButton("");
			btnCursos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ventanaPanel(pc, "Cursos");
				}
			});
			btnCursos.setIcon(new ImageIcon(Principal.class.getResource("/capitulo8/SWING/res/ruedadentada.png")));
			toolBar.add(btnCursos);

			JButton btnMaterias = new JButton("");
			btnMaterias.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ventanaPanel(pm, "Materias");
				}
			});
			btnMaterias.setIcon(new ImageIcon(Principal.class.getResource("/capitulo8/SWING/res/ruedadentada.png")));
			toolBar.add(btnMaterias);
			
			JButton btnEstudiante = new JButton("");
			btnEstudiante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel pe = null;
					ventanaPanel(pe, "Estudiantes");

				}
			});
			btnEstudiante.setIcon(new ImageIcon(Principal.class.getResource("/capitulo8/SWING/res/ruedadentada.png")));
			toolBar.add(btnEstudiante);
			
			JButton btnProfesor = new JButton("");
			btnProfesor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel pf = null;
					ventanaPanel(pf, "Profesor");

				}
			});
			btnProfesor.setIcon(new ImageIcon(Principal.class.getResource("/capitulo8/SWING/res/ruedadentada.png")));
			toolBar.add(btnProfesor);
		}

		/**
		 * 
		 */
		private void ventanaPanel(JPanel panel, String tabla) {
			JDialog dialogo = new JDialog();
			// El usuario no puede redimensionar el diálogo
			dialogo.setResizable(true);
			// título del díalogo
			dialogo.setTitle("Gestión Centro Educativo");
			// Introducimos el panel creado sobre el diálogo
			dialogo.setContentPane(panel);
			// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que
			// deben y el lugar adecuado
			dialogo.pack();
			// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
			dialogo.setModal(true);
			// Centro el di�logo en pantalla
			dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - dialogo.getWidth() / 2,
					(Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - dialogo.getHeight() / 2);
			// Muestro el di�logo en pantalla
			dialogo.setVisible(true);
		}

}
