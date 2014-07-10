package Pruebas1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.AttributedString;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.event.EventListenerList;

import org.edisoncor.gui.button.ButtonIcon;

import ISIS.Code.Class.Button;
import ISIS.Code.Class.Dialogo;
import ISIS.Code.Matriz.CargarObjetos;
import ISIS.Code.Matriz.Celda;
import ISIS.Code.Matriz.Construccion;
import ISIS.Code.Matriz.ImageCache;
import ISIS.Code.Matriz.ModeloMapa;
import ISIS.Code.Matriz.Vivienda;
import ISIS.Code.Panels.PanelPausa;
import ISIS.Code.Panels.StartPanel;
import Pruebas.MapaPersonalizado;

public class Mapa extends JPanel implements MouseListener, MouseMotionListener,
		MouseWheelListener {

	private BufferedImage nuevaImagen, grama, seleccion, colision, borde,
			tierraID, tierraD, tierraI, tierraizq, tierraizqd;
	private ArrayList<BufferedImage> listBotones = null;
	private ArrayList<BufferedImage> listLabels = null;
	private ArrayList<BufferedImage> listindicadores = null;
	private ArrayList<BufferedImage> labelsderecha = null;
	private BufferedImage test;
	private EventListenerList eventListenerList = new EventListenerList();
	private Point posicionRaton, anterior, ubicacion, seleccionado;
	private static boolean construir = false;
	private Polygon poligono;
	private boolean arrastre, esta = false;
	public static boolean click = false;
	private double scale = 1.0;
	private double atx, aty;
	private int ancho, alto, tile;
	private static long lochas = 999;
	private static int habitantes = 0;
	private static int guarda = 0;
	public ModeloMapa matriz;
	private Vivienda imagen;
	private MapaPersonalizado mapaGenerador = new MapaPersonalizado();

	private Construccion ambulatorio, aseo, companiaElectrica, escuela,
			aguaDeMerida;
	private Construccion camellon, granzon, concreto;
	private Construccion carpinteria, cafetin, fruteria, mercalito,
			almuerzoPopular;

	private static final String ROOT = "src/ISIS/Resource/HUDImages/";
	private String[] botones = { "barra.png", "edificaciones.png",
			"carreteras.png", "servicios.png", "industria.png",
			"comunitario.png" };
	private String[] labels = { "lochas.png", "felicidad.png",
			"habitantes.png", "xp.png" };
	private String[] indicadores = { "ID.png", "minimapa" };
	private String[] labelsDerecha = { "panel2.png", "malandro.png",
			"construir.png" };

	public int w = 0;
	private Dialogo dialogo;
	static JPopupMenu Pmenu;
	static JMenuItem menuItem;
	private ButtonIcon boton;
	private CargarObjetos cargarObjetos;

	public Mapa() {
		super();

		setOpaque(false);
		dibujarAcciones();
		cargarImagenes();

		tile = 30;
		matriz = new ModeloMapa(tile, tile);
		for (int i = 0; i < tile; i++) {
			for (int j = 0; j < tile; j++) {
				matriz.escribirDato(i, j, null);

			}

		}

		ancho = grama.getWidth() * tile;
		alto = grama.getHeight() * tile;

		grama = ImageCache.getInstance().getImage(
				"src/ISIS/Resource/HUDImages/grama.png");

		borde = ImageCache.getInstance().getImage(
				"src/ISIS/Resource/HUDImages/agua.png");

		tierraID = ImageCache.getInstance().getImage(
				"src/ISIS/Resource/HUDImages/tierra3.png");
		tierraD = ImageCache.getInstance().getImage(
				"src/ISIS/Resource/HUDImages/tierraD.png");
		tierraI = ImageCache.getInstance().getImage(
				"src/ISIS/Resource/HUDImages/tierraI.png");
		tierraizq = ImageCache.getInstance().getImage(
				"src/ISIS/Resource/HUDImages/tierraizq.png");
		tierraizqd = ImageCache.getInstance().getImage(
				"src/ISIS/Resource/HUDImages/tierraizqd.png");

		ubicacion = new Point(0, alto / 2);
		seleccionado = new Point(-1, -1);
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseWheelListener(this);

	}

	private void cargarImagenes() {

		listBotones = new ArrayList<BufferedImage>();
		for (int i = 0; i < botones.length; i++) {
			listBotones.add(ImageCache.getInstance()
					.getImage(ROOT + botones[i]));
		}

		listLabels = new ArrayList<BufferedImage>();
		for (int i = 0; i < labels.length; i++) {
			listLabels.add(ImageCache.getInstance().getImage(ROOT + labels[i]));
		}

		listindicadores = new ArrayList<BufferedImage>();
		for (int i = 0; i < indicadores.length; i++) {
			listindicadores.add(ImageCache.getInstance().getImage(
					ROOT + indicadores[i]));
		}

		labelsderecha = new ArrayList<BufferedImage>();
		for (int i = 0; i < labelsDerecha.length; i++) {
			labelsderecha.add(ImageCache.getInstance().getImage(
					ROOT + labelsDerecha[i]));

		}
	}

	private void dibujarAcciones() {
		cargarObjetos = new CargarObjetos();
		imagen = new Vivienda("imagen");
		imagen.setImagen(ImageCache.getInstance().getImage(
				"src/ISIS/Code/Matriz/petrocasa.png"));

		poligono = new Polygon();
		poligono.addPoint(0, 32);
		poligono.addPoint(64, 0);
		poligono.addPoint(128, 32);
		poligono.addPoint(64, 64);

		GraphicsConfiguration gc = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		grama = gc.createCompatibleImage(128, 64, Transparency.TRANSLUCENT);

		Graphics g = grama.getGraphics();
		Graphics g2 = grama.getGraphics();

		g.setColor(Color.WHITE);
		g.fillPolygon(poligono);
		g.setColor(Color.BLACK);
		g.drawPolygon(poligono);
		g.dispose();

		seleccion = gc.createCompatibleImage(128, 64, Transparency.BITMASK);
		colision = gc.createCompatibleImage(128, 64, Transparency.BITMASK);

		g = seleccion.getGraphics();
		g2 = colision.getGraphics();

		g.setColor(Color.GREEN);
		g.fillPolygon(poligono);
		g.drawPolygon(poligono);
		g.dispose();

		g2.setColor(Color.RED);
		g2.fillPolygon(poligono);
		g2.drawPolygon(poligono);
		g2.dispose();

	}

	public void paint(Graphics g) {
		super.paint(g);

		chequearNuevaImagen();
		Graphics2D g2 = (Graphics2D) g;

		Graphics bg = nuevaImagen.getGraphics();
		dibujarGrilla(bg);
		loadCasas(bg);
		try {
			autoGuardado(bg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		insertarCasa(bg, 20, 20);

		atx = (getWidth() - scale * nuevaImagen.getWidth()) / 2;
		aty = (getHeight() - scale * nuevaImagen.getHeight()) / 2;
		AffineTransform at = AffineTransform.getTranslateInstance(atx, aty);
		at.scale(scale, scale);
		g2.drawRenderableImage((RenderableImage) nuevaImagen, at);
		bg.dispose();

		crearHUD(g2);

	}

	private void autoGuardado(Graphics bg) throws IOException {
		if (PanelPausa.isGuardado() == true) {
			if (matriz != null) {
				String Ruta = "src/Pruebas/Prueba";
				File TextFile;
				FileWriter TextOut;

				File directorio = new File(Ruta);
				directorio.mkdir();
				TextFile = new File(Ruta + "/Prueba" + guarda + ".txt");

				for (int x = 0; x < tile; x++) {
					for (int y = 0; y < tile; y++) {
						if (matriz.leerDato(x, y) != null) {

							int dx = x * imagen.getImagen().getWidth() / 2 - y
									* imagen.getImagen().getWidth() / 2;
							int dy = x * imagen.getImagen().getHeight() / 2 + y
									* imagen.getImagen().getHeight() / 2;
							dx -= ubicacion.x;
							dy -= ubicacion.y;

							TextOut = new FileWriter(TextFile, true);
							TextOut.write(matriz.leerDato(x, y).getConstRef()
									.getID()
									+ "," + x + "," + y);
							TextOut.write("\n");
							TextOut.close();

							PanelPausa.setGuardado(false);

							repaint();

						}

					}

				}
				guarda++;
			}
		}

	}

	private void crearCasa(int i, int j) {
		if (dialogo.getSeleccionada() == "petrocasa") {
			matriz.escribirDato(i, j, new Celda(null, CargarObjetos.petrocasa));
			matriz.leerDato(i, j).getConstRef().setID("petrocasa");
		} else if (dialogo.getSeleccionada() == "majunche") {
			matriz.escribirDato(i, j, new Celda(null, cargarObjetos.majunche));
			matriz.leerDato(i, j).getConstRef().setID("majunche");
		} else if (dialogo.getSeleccionada() == "rancho") {
			matriz.escribirDato(i, j, new Celda(null, cargarObjetos.rancho));
			matriz.leerDato(i, j).getConstRef().setID("rancho");
		} else if (dialogo.getSeleccionada() == "cabana") {
			matriz.escribirDato(i, j, new Celda(null, cargarObjetos.cabana));
			matriz.leerDato(i, j).getConstRef().setID("cabana");
		} else if (dialogo.getSeleccionada() == "palafito") {
			matriz.escribirDato(i, j, new Celda(null, cargarObjetos.palafito));
			matriz.leerDato(i, j).getConstRef().setID("palafito");
		} else if (dialogo.getSeleccionada() == "camellon") {
			matriz.escribirDato(i, j, new Celda(null, cargarObjetos.camellon));
			matriz.leerDato(i, j).getConstRef().setID("palafito");
		} else if (dialogo.getSeleccionada() == "granzon") {
			matriz.escribirDato(i, j, new Celda(null, cargarObjetos.granzon));
			matriz.leerDato(i, j).getConstRef().setID("palafito");
		} else if (dialogo.getSeleccionada() == "concreto") {
			matriz.escribirDato(i, j, new Celda(null, cargarObjetos.concreto));
			matriz.leerDato(i, j).getConstRef().setID("palafito");
		}
	}

	private void chequearNuevaImagen() {
		if (nuevaImagen == null
				|| (nuevaImagen.getWidth() != this.getWidth() || nuevaImagen
						.getHeight() != this.getHeight())) {
			GraphicsConfiguration gc = GraphicsEnvironment
					.getLocalGraphicsEnvironment().getDefaultScreenDevice()
					.getDefaultConfiguration();
			nuevaImagen = gc.createCompatibleImage(this.getWidth(),
					this.getHeight(), Transparency.BITMASK);
		}
	}

	private void dibujarGrilla(Graphics bg) {

		int dx = 0;
		int dy = 0;

		bg.setColor(Color.GRAY);
		bg.fillRect(0, 0, nuevaImagen.getWidth(), nuevaImagen.getHeight());

		for (int x = 0; x < tile; x++) {
			for (int y = 0; y < tile; y++) {

				dx = x * grama.getWidth() / 2 - y * grama.getWidth() / 2;
				dy = x * grama.getHeight() / 2 + y * grama.getHeight() / 2;
				dx -= ubicacion.x;
				dy -= ubicacion.y;

				System.out.println(mapaGenerador.devuelveTile(x, y));

				if (mapaGenerador.devuelveTile(x, y) == 1)
					bg.drawImage(grama, dx, dy, this);
				if (mapaGenerador.devuelveTile(x, y) == 0) {
					bg.drawImage(borde, dx, dy, this);
					Image img1 = Toolkit.getDefaultToolkit().getImage(
							"src/ISIS/Resource/HUDImages/pes6.gif");
					bg.drawImage(img1, dx, dy, this);
				}
				if (mapaGenerador.devuelveTile(x, y) == 2)
					bg.drawImage(tierraID, dx, dy, this);
				if (mapaGenerador.devuelveTile(x, y) == 3)
					bg.drawImage(tierraD, dx, dy, this);
				if (mapaGenerador.devuelveTile(x, y) == 4)
					bg.drawImage(tierraI, dx, dy, this);
				if (mapaGenerador.devuelveTile(x, y) == 5)
					bg.drawImage(tierraizq, dx, dy, this);
				if (mapaGenerador.devuelveTile(x, y) == 6)
					bg.drawImage(tierraizqd, dx, dy, this);

				if ((x == seleccionado.x) && (y == seleccionado.y)) {
					bg.drawImage(seleccion, dx, dy, this);
				}
			}

		}
	}

	private void loadCasas(Graphics bg) {

		if (matriz != null) {
			for (int x = 0; x < tile; x++) {
				for (int y = 0; y < tile; y++) {
					if (matriz.leerDato(x, y) != null) {

						int dx = x * imagen.getImagen().getWidth() / 2 - y
								* imagen.getImagen().getWidth() / 2;
						int dy = x * imagen.getImagen().getHeight() / 2 + y
								* imagen.getImagen().getHeight() / 2;
						dx -= ubicacion.x;
						dy -= ubicacion.y;
						bg.drawImage(matriz.leerDato(x, y).getConstRef()
								.getImagen(), dx, dy, this);

					}

				}

			}
		}
	}

	private void insertarCasa(Graphics bg, int i, int j) {
		// TODO Auto-generated method stub

	}

	private void crearHUD(Graphics g) {
		float ANCHO = this.getWidth();
		float ALTO = this.getHeight();

		int x = (int) (Math.floor(ANCHO / 2) - 375);
		int y = 40;

		if (isConstruir() == true) {
			int i = 0;
			for (BufferedImage image : listBotones) {
				if (i == 0) {
					g.drawImage(image, x, y - 10, this);
					x += 15;

				} else {
					g.drawImage(image, x, y, this);
					x += 140;
				}
				i++;
			}
			repaint();
		}

		x = 10;
		y = (int) Math.floor(ALTO / 4);

		for (BufferedImage image : listLabels) {

			g.drawImage(image, x, y, this);
			y += 55;

		}

		x = 0;
		y = this.getHeight() - 70;
		for (BufferedImage image : listindicadores) {
			g.drawImage(image, x, y, this);
			x = this.getWidth() - 150;
			y -= 70;
		}

		x = 0;
		y = this.getHeight() - 70;
		for (BufferedImage image : listindicadores) {
			g.drawImage(image, x, y, this);
			x = this.getWidth() - 150;
			y -= 70;
		}

		x = this.getWidth() - 150;
		y = (int) Math.floor(ALTO / 4);
		int i = 0;
		for (BufferedImage image : labelsderecha) {
			if (i == 0)
				g.drawImage(image, x, y, this);
			else {
				g.drawImage(image, x, y, this);
				y += 240;
			}
			i++;

		}

		Graphics2D g2d = (Graphics2D) g;
		Font font = new Font("Calibri", Font.BOLD, 21);
		String aString = Double.toString(getLochas());
		AttributedString attributedString = new AttributedString(aString);
		attributedString.addAttribute(TextAttribute.FONT, font, 0,
				aString.length());
		attributedString.addAttribute(TextAttribute.FOREGROUND, Color.WHITE, 0,
				aString.length());
		g2d.drawString(attributedString.getIterator(), 63, 230);
		String aString2 = Integer.toString(getHabitantes());
		AttributedString attributedString2 = new AttributedString(aString2);
		attributedString2.addAttribute(TextAttribute.FONT, font, 0,
				aString2.length());
		attributedString2.addAttribute(TextAttribute.FOREGROUND, Color.white,
				0, aString2.length());
		g2d.drawString(attributedString2.getIterator(), 69, 340);

	}

	private boolean isConstruir() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() < 0) {
			scale = scale + 0.1;
			repaint();
		} else if (e.getWheelRotation() > 0) {
			scale = scale - 0.1;
			repaint();
		}

	}
	

	@Override
	public void mouseDragged(MouseEvent e) {
		if (arrastre) {
			ubicacion.x = anterior.x + posicionRaton.x - e.getX();
			ubicacion.y = anterior.y + posicionRaton.y - e.getY();
			if (ubicacion.x < -ancho / 2) {
				ubicacion.x = -ancho / 2;
			}
			if (ubicacion.y < -alto / 2 + this.getHeight()) {
				ubicacion.y = -alto / 2 + this.getHeight();
			}
			if (ubicacion.x > ancho / 2 - this.getWidth() + grama.getWidth()) {
				ubicacion.x = ancho / 2 - this.getWidth() + grama.getWidth();
			}
			if (ubicacion.y > alto / 2 + this.getHeight()) {
				ubicacion.y = alto / 2 + this.getHeight();
			}

			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		float ANCHO = this.getWidth();
		float ALTO = this.getHeight();
		if (!arrastre) {
			int pickX = e.getX() + ubicacion.x;
			int pickY = e.getY() + ubicacion.y;
			int tileW = grama.getWidth();
			int tileH = grama.getHeight();

			// Lugar en el q se calcula la posicion de la matriz
			int i = (int) (((double) pickX / (double) tileW)
					+ ((double) pickY / (double) tileH) - 0.5);
			int j = (int) (((double) pickY / (double) tileH)
					- ((double) pickX / (double) tileW) + 0.5);
			seleccionado.setLocation(i, j);
			repaint();
		}
		int pickX = e.getX() + ubicacion.x;
		int pickY = e.getY() + ubicacion.y;
		int tileW = grama.getWidth();
		int tileH = grama.getHeight();

		// Lugar en el q se calcula la posicion de la matriz
		int i = (int) (((double) pickX / (double) tileW)
				+ ((double) pickY / (double) tileH) - 0.5);
		int j = (int) (((double) pickY / (double) tileH)
				- ((double) pickX / (double) tileW) + 0.5);
		if (matriz.leerDato(i, j) != null) {
			// seleccion = colision;
			repaint();
		}
		// colision=seleccion;

		if ((e.getX() < ANCHO / 2 - 375 + 15 + 132 && e.getX() > ANCHO / 2 - 375 + 15)) {
			// StartPanel.click2.play();
		}

		System.out.println("x: " + i + "y: " + j);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int ANCHO = this.getWidth();
		int ALTO = this.getHeight();

		System.err.println("x: " + e.getX());
		System.err.println("y: " + e.getY());
		if ((e.getX() < this.getWidth() - 21 && e.getX() > this.getWidth() - 150)
				&& (e.getY() < ALTO / 4 + 300 && e.getY() > ALTO / 4 + 240)) {
			if (isConstruir() == false) {
				setConstruir(true);

				repaint();

			} else if (isConstruir() == true) {
				setConstruir(false);
				repaint();
			}

		}

		int pickX = e.getX() + ubicacion.x;
		int pickY = e.getY() + ubicacion.y;
		int tileW = grama.getWidth();
		int tileH = grama.getHeight();

		// Lugar en el q se calcula la posicion de la matriz
		final int i = (int) (((double) pickX / (double) tileW)
				+ ((double) pickY / (double) tileH) - 0.5);
		final int j = (int) (((double) pickY / (double) tileH)
				- ((double) pickX / (double) tileW) + 0.5);

		if (matriz.leerDato(i, j) != null) {
			Pmenu = new JPopupMenu();
			menuItem = new JMenuItem("Mover Edificacion");
			menuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					itemMover();

				}
			});
			Pmenu.add(menuItem);
			menuItem = new JMenuItem("Eliminar edificacion");
			menuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					matriz.escribirDato(i, j, null);
					repaint();
				}
			});

			Pmenu.add(menuItem);

			Pmenu.show(e.getComponent(), e.getX(), e.getY());
		}

		if ((e.getX() < ANCHO / 2 - 375 + 15 + 132 && e.getX() > ANCHO / 2 - 375 + 15)
				&& (e.getY() < 80 && e.getY() > 42)) {
			
			StartPanel.click.play();
			System.out.println("Edificaciones");
			fireActionEvent(new ActionEvent(this, 0, "Edificaciones"));
			
			
		}
		
		else if ((e.getX() < ANCHO / 2 - 375 + 285 && e.getX() > ANCHO / 2 - 375 + 159)
				&& (e.getY() < 80 && e.getY() > 42)) {
			StartPanel.click.play();
			System.out.println("Carretera");
			fireActionEvent(new ActionEvent(this, 0, "Carretera"));

		}

		else if ((e.getX() < ANCHO / 2 - 375 + 423 && e.getX() > ANCHO / 2 - 375 + 298)
				&& (e.getY() < 80 && e.getY() > 42)) {
			System.out.println("Servicios");
			fireActionEvent(new ActionEvent(this, 0, "Servicios"));
			StartPanel.click.play();
		}

		else if ((e.getX() < ANCHO / 2 - 375 + 563 && e.getX() > ANCHO / 2 - 375 + 438)
				&& (e.getY() < 80 && e.getY() > 42)) {
			System.out.println("Industrias");
			fireActionEvent(new ActionEvent(this, 0, "Industrias"));
			StartPanel.click.play();
		}

		else if ((e.getX() < ANCHO / 2 - 375 + 704 && e.getX() > ANCHO / 2 - 375 + 578)
				&& (e.getY() < 80 && e.getY() > 42)) {
			// System.out.println("Industrias");
			// fireActionEvent(new ActionEvent(this, 0, "Comunitarios"));
			StartPanel.click.play();
		}
		
		else if (isClick() == true ){
			
			if(matriz.leerDato(i, j) != null ){
				System.out.println("No se puede construir elemento");
				
				repaint();
				
				
			} else {
				
				crearCasa(i , j);
				
				
			}
			
			repaint();
			
		}
	}

	private boolean isClick() {
		// TODO Auto-generated method stub
		return click;
	}
	
	public void setClick(boolean click){
		this.click = click;
	}

	private void fireActionEvent(ActionEvent actionEvent) {
		ActionListener[] actionListeners = getActionListeners();
		
		for(ActionListener actionListener : actionListeners){
			actionListener.actionPerformed(actionEvent);
		}
	}

	protected void itemMover() {
		// TODO Auto-generated method stub

	}

	private static void setConstruir(boolean construir) {
		Mapa.construir = construir;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
			if((e.getButton() == MouseEvent.BUTTON1) && !arrastre){
				posicionRaton = e.getPoint();
				anterior = new Point(ubicacion);
				arrastre = true;
			}
		}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		arrastre = false;
		posicionRaton = null;
	}
	
	public void addActionListener(ActionListener listener){
		eventListenerList .add(ActionListener.class, listener);
		
	}
	
	public void removeActionListenr(ActionListener listener){
		eventListenerList.remove(ActionListener.class, listener);
	}
	
	public ActionListener[] getActionListeners(){
		return eventListenerList.getListeners(ActionListener.class);
	}

	public static long getLochas() {
		return lochas;
	}

	public static void setLochas(long lochas) {
		Mapa.lochas = lochas;
	}

	public static int getHabitantes() {
		return habitantes;
	}

	public static void setHabitantes(int habitantes) {
		Mapa.habitantes = habitantes;
	}
	
	

}
