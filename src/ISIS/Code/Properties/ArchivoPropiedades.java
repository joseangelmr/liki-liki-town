package ISIS.Code.Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.StringTokenizer;

/**
 * Aqui se ilustra un ejemplo sobre el uso de la clase Properties para leer
 * datos desde un archivo de propiedades.
 * 
 * @author [D-m-K] https://codesandtags.org
 */

/**
 * 
 * @author ISIS
 */

public class ArchivoPropiedades {

	// Atributos de la clase
	private Properties propiedades;
	private String archivo;

	/**
	 * Constructor que inicializa el objeto properties y la ruta del archivo a
	 * trabajar
	 */
	public ArchivoPropiedades(String archivo) {
		propiedades = new Properties();
		this.archivo = archivo;

	}

	/**
	 * Carga en el objeto de propiedades los datos leidos del archivo
	 * 
	 * @return boolean
	 */
	public boolean cargarPropiedades() {
		try {
			propiedades.load(new FileInputStream(archivo));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Permite leer todas las propiedades almacenadas en el archivo mostrando su
	 * respectivo valor
	 */
	public void readPropiedades() {
		// Obtengo una enumeracion de llaves, cada llave permitira
		// obtener un valor dentro del properties
		Enumeration llaves = propiedades.keys();

		// Recorro llave por llave y obtengo su valor
		while (llaves.hasMoreElements()) {
			String llave = (String) llaves.nextElement();
			System.out.println(propiedades.getProperty(llave));
		}
	}

	/**
	 * Obtiene el valor de una propiedad determinada y que exista en el archivo
	 * de propiedades, de lo contrario retornara null
	 * 
	 * @param propiedad
	 * @return
	 */
	public String getValorPropiedad(String propiedad) {
		return propiedades.getProperty(propiedad);
	}

	/**
	 * Ejemplo del uso de la clase ArchivoPropiedades
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		/***
		 * Instancia y carga de los datos al archivo
		 */
		// Objeto para manejar las propiedades
		ArchivoPropiedades ejemplo = new ArchivoPropiedades(
				"src/ISIS/Code/Properties/config.properties");
		// Carga los datos del archivo
		ejemplo.cargarPropiedades();

		/**
		 * Leyendo las propiedades
		 */

		// Leyendo todas las propiedades del archivo
		System.out.println("Leyendo todas las propiedaes del archivo....\n");
		ejemplo.readPropiedades();

		// Leyendo una propiedad individual con varios valores
//		System.out
//				.println("\nLeyendo una propiedad individual con varios valores....\n");
//		StringTokenizer ips = new StringTokenizer(
//				ejemplo.getValorPropiedad("ips"), ",");
//
//		// Muestro los valores obtenidos en el StringTokenizer
//		while (ips.hasMoreTokens()) {
//			System.out.println(" - " + ips.nextToken());
//		}

//		System.out.println("\nAhora estoy mostrando otra propiedad...\n");
//		StringTokenizer crud = new StringTokenizer(
//				ejemplo.getValorPropiedad("crud"), ",");
//		// Muestro los valores obtenidos en el StringTokenizer
//		while (crud.hasMoreTokens()) {
//			System.out.println(" - " + crud.nextToken());
//		}
//
//		// Mostrando solo una propiedad
//		System.out.println("\nY una propiedad con un solo valor\n");
//		System.out.println("url - " + ejemplo.getValorPropiedad("url"));

	}
}