package capitulo8.gestionDeBaseDeDatos;

import java.sql.Connection;
import java.sql.SQLException;



public class Principal {

	public static void main(String[] args) {

try {
			
			Connection conn = Utils.UtilsBBDD.obtenerConeccion();
			do {
				switch (menu()) {
					case 0: {
						conn.close();
						System.out.println("\n\n Hasta luego  ;-)");
						System.exit(0);
						break;
					}
				
					case 1: {
						ControladorFabricante.main(conn);
						break;
					}
					case 2: {
						ControladorConcesionario.main(conn);
						break;
					}
					case 3: {
						ControladorCliente.main(conn);
						break;
					}
					case 4: {
						ControladorCoche.main(conn);
						break;
					}
					case 5: {
						ControladorVenta.main(conn);
						break;
					}
				
				}
				
			}while(true);
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}
	
	/**
	 * 
	 * @return
	 */
	private static int menu() {
		System.out.println("Tablas de la Base de Datos");
		System.out.println("-------------------------- \n");
		System.out.println("1. Tabla Fabricante");
		System.out.println("2. Tabla Concesionario");
		System.out.println("3. Tabla Cliente");
		System.out.println("4. Tabla Coche");
		System.out.println("5. Tabla Ventas");
		System.out.println("0. Salir");
		return Utils.Utils.obtenerEnteroPorJoptionPane("Elija opción: ");
		
		
	}
	
	
	

}
