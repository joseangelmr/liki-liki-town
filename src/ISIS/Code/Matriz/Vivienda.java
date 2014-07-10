package ISIS.Code.Matriz;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * 
 * @author ISIS
 */

public class Vivienda extends Construccion {

	private String ID;
	private BufferedImage imagen;
	private ArrayList<Point> posiciones = null; // Lista de posiciones por si la imagen es mas grande

	public Vivienda() {
		super();
	}

	public Vivienda(String ID) {
		super(ID);
	}

	public void fijarCoordenada(int i, int j) {
		posiciones = new ArrayList<Point>();
		Point posicion = new Point(i,j);
		posiciones.add(posicion);
	}

	public ArrayList<Point> obtenerCoordenadas() {
		return posiciones;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public BufferedImage getImagen() {
		return imagen;
	}

	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}
	
}