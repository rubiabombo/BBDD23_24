package capitulo8.gestionFabricante;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LeerFichero {

	private static Properties propiedades = null;
	
	public LeerFichero() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	private static Properties getPropiedades() {
		if (propiedades == null) {
			propiedades = new Properties();

			try {
				File file = new File("./src/capitulo8/gestionFabricante/jdbc.properties");
				propiedades.load(new FileReader(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return propiedades;
	}

	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static String getProperty(String nombrePropiedad) {
		return getPropiedades().getProperty(nombrePropiedad);
	}

	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static int getIntProperty(String nombrePropiedad) {
		return Integer.parseInt(getPropiedades().getProperty(nombrePropiedad));
	}

	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static Float getFloatProperty(String nombrePropiedad) {
		return Float.parseFloat(getPropiedades().getProperty(nombrePropiedad));
	}

}


