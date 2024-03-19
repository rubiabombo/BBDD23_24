package gestionCentroEducativo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestionCentroEducativo.controller.ControladorCurso;
import gestionCentroEducativo.controller.ControladorValoracion;
import gestionCentroEducativo.model.Curso;
import gestionCentroEducativo.model.Materia;

import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prueba extends JFrame {
	
	private JComboBox<Materia> jcbMateria;
	private List<Materia> materia;
	private JComboBox<Curso> jcbCurso;
	private List<Curso> cursos;




	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba frame = new Prueba();
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
	public Prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0};
		contentPane.setLayout(gbl_contentPane);
		

		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 0;
		getContentPane().add(jcbMateria, gbc_comboBox_1);
		
		try {
			materia = new ArrayList<Materia>();
			materia = ControladorValoracion.allRegistersMateria();
			for (int i = 0; i < materia.size(); i++) {
				jcbMateria.addItem(materia.get(i));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		catch (NullPointerException e) {
			
		}
		
		jcbCurso = new JComboBox<Curso>();
		jcbCurso.setVisible(false);
		GridBagConstraints gbc_jcbCurso = new GridBagConstraints();
		gbc_jcbCurso.insets = new Insets(0, 0, 5, 0);
		gbc_jcbCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCurso.gridx = 0;
		gbc_jcbCurso.gridy = 1;
		contentPane.add(jcbCurso, gbc_jcbCurso);
		
		JButton jbtSelec = new JButton("Selección.");
		jbtSelec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcbCurso.removeAllItems();
				jcbCurso.setVisible(true);
				Materia m = new Materia();
				m = (Materia) jcbMateria.getSelectedItem();
				
				try {
					cursos = new ArrayList<Curso>();
					cursos = ControladorCurso.allRegistersFromACurse(m);
					for (int i = 0; i < cursos.size(); i++) {
						jcbCurso.addItem(cursos.get(i));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		GridBagConstraints gbc_jbtSelec = new GridBagConstraints();
		gbc_jbtSelec.insets = new Insets(0, 0, 5, 0);
		gbc_jbtSelec.gridx = 0;
		gbc_jbtSelec.gridy = 2;
		contentPane.add(jbtSelec, gbc_jbtSelec);
	}
	
	

}
