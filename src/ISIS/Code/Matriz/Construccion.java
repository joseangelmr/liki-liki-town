package ISIS.Code.Matriz;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * 
 * @author ISIS
 */



public class Construccion {

	private String ID; // Nombre de la construccion
	private BufferedImage imagen; // Imagen de la construccion, el id deberia
	// ser el mismo nombre de la imagen en carpeta + la extension
	private ArrayList<Point> posiciones = null; // Lista de posiciones por si la imagen es mas grande
	
	
	// Parametros
	private int salud;
	private double sigmaSalud;
	private int educacion;
	private double sigmaEducacion;
	private int violencia;
	private double sigmaViolencia;
	private int delincuencia;
	private double sigmaDelicuencia;
	private int empleo;
	private double sigmaEmpleo;
	private int deporte;
	private double sigmaDeporte;
	private int seguridad;
	private double sigmaSeguridad;

	// Enumerado para facilitar el manejo de los parametros en codigo
	enum Influencias {
		SALUD, EDUCACION, VIOLENCIA, DELINCUENCIA, EMPLEO, DEPORTE, SEGURIDAD
	}

	enum Sigmas {
		SIGMA_SALUD, SIGMA_EDUCACION, SIGMA_VIOLENCIA, SIGMA_DELINCUENCIA, SIGMA_EMPLEO, SIGMA_DEPORTE, SIGMA_SEGURIDAD
	}

	/*
	 * Parametros estadisticos influencias, sigmas
	 */

	/*
	 * Calculos de la Normal calcularNormal(i,j,inf,sigma); Calculos respecto a
	 * la distancia
	 */

	/*
	 * Funciones para cargar los archivos tipo properties
	 */

	public Construccion() {
		
	}
	
	public String getID(){
		return ID;
	}
	
	public void setID(String ID){
		this.ID= ID;
	}

	public Construccion(String ID) {
		this.ID = ID;
	}

	public BufferedImage getImagen() {
		return imagen;
	}

	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}

	public void fijarCoordenada(int i, int j) {
		posiciones = new ArrayList<Point>();
		Point posicion = new Point(i,j);
		posiciones.add(posicion);
	}

	public ArrayList<Point> obtenerCoordenadas() {
		return posiciones;
	}

	
}
