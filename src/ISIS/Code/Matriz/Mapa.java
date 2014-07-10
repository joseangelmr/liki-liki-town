package ISIS.Code.Matriz;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Label;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

import org.edisoncor.gui.button.ButtonIcon;

import ISIS.Code.Class.Dialogo;
import ISIS.Code.Frame.MainMapa;
import ISIS.Code.Panels.GamePanel;
import ISIS.Code.Panels.PanelPausa;
import ISIS.Code.Panels.StartPanel;
import Pruebas.MapaPersonalizado;

/**
 * 
 * @author ISIS
 */

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
	private MapaPersonalizado mapaGenerator = new MapaPersonalizado();

	private PanelPausa panelPausa;

	// private BufferedImage casa=null;
	// private Construccion petrocasa,majunche,rancho,palafito,cabana;
	
	private Construccion ambulatorio, aseo, companiaElectrica, escuela,
			aguaDeMerida; // Servicios Publicos
	private Construccion camellon, granzon, concreto; // Vias
	private Construccion carpinteria, cafetin, fruteria, mercalito,
			almuerzoPopular;// Industrias
	private static final String ROOT = "src/ISIS/Resource/HUDImages/";
	private String[] botones = { "barra.png", "edificaciones.png",
			"carreteras.png", "servicios.png", "industria.png",
			"comunitario.png" /* "pes.gif" "startButton.png" */};
	private String[] labels = { "lochas.png", "felicidad.png",
			"habitantes.png", "xp.png", /* "startButton.png" */};
	private String[] indicadores = { "ID.png", /* "startButton.png" */
	"minimapa.png" };
	private String[] labelsDerecha = { "panel2.png", "malandro.png",
			"construir.png" /* , "z_in_out.png" */};

	public int w = 0;
	private Dialogo dialogo;
	static JPopupMenu Pmenu;
	static JMenuItem menuItem;
	private ButtonIcon boton;
	private CargarObjetos cargarObjetos;

	// private BufferedImage pause;

	private BufferedImage bmenu;

	public Mapa() {

		super();

		setOpaque(false);
		dibujarAcciones();
		cargarImagenes();

		tile = 30;
		matriz = new ModeloMapa(tile, tile);
		// Inicializo la matriz en null
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

	public void dibujarAcciones() {

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		insertarCasa(bg, 20, 20);

		atx = (getWidth() - scale * nuevaImagen.getWidth()) / 2;
		aty = (getHeight() - scale * nuevaImagen.getHeight()) / 2;
		AffineTransform at = AffineTransform.getTranslateInstance(atx, aty);
		at.scale(scale, scale);
		g2.drawRenderedImage(nuevaImagen, at);
		bg.dispose();

		crearHUD(g2);
		// g.drawImage(nuevaImagen, 0, 0, this);

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

	public void insertarCasa(Graphics g, int x, int y) {
		// int dx = 0;
		// int dy = 0;
		//
		// dx = x * grama.getWidth() / 2 - y
		// * grama.getWidth() / 2;
		// dy = x * grama.getHeight() / 2 + y
		// * grama.getHeight() / 2;
		// dx -= ubicacion.x;
		// dy -= ubicacion.y;

	}

	public void crearCasa(int i, int j) {
		if (dialogo.getSeleccionada() == "petrocasa") {
			matriz.escribirDato(i, j, new Celda(null, cargarObjetos.petrocasa));
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

	public void loadCasas(Graphics bg) {

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

	public void chequearNuevaImagen() {
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

	public void dibujarGrilla(Graphics g) {
		int dx = 0;
		int dy = 0;

		// Parte donde esta bloqueada el mapa
		g.setColor(Color.DARK_GRAY);
		// Rellenar con una grama sombreada
		g.fillRect(0, 0, nuevaImagen.getWidth(), nuevaImagen.getHeight());
		// Se crea el HUD
		// crearHUD(g);
		for (int x = 0; x < tile; x++) {
			for (int y = 0; y < tile; y++) {
				dx = x * grama.getWidth() / 2 - y * grama.getWidth() / 2;
				dy = x * grama.getHeight() / 2 + y * grama.getHeight() / 2;
				dx -= ubicacion.x;
				dy -= ubicacion.y;

				// Esto era lo que no me dejaba ver lo q keria hacer CSM xD
				// System.out.println(mapaGenerator.devuelveTile(x, y));

				if (mapaGenerator.devuelveTile(x, y) == 1)
					g.drawImage(grama, dx, dy, this);
				if (mapaGenerator.devuelveTile(x, y) == 0) {
					g.drawImage(borde, dx, dy, this);
					Image img1 = Toolkit.getDefaultToolkit().getImage(
							"src/ISIS/Resource/HUDImages/pes6.gif");
					g.drawImage(img1, dx, dy, this);
				}
				if (mapaGenerator.devuelveTile(x, y) == 2)
					g.drawImage(tierraID, dx, dy, this);
				if (mapaGenerator.devuelveTile(x, y) == 3)
					g.drawImage(tierraD, dx, dy, this);
				if (mapaGenerator.devuelveTile(x, y) == 4)
					g.drawImage(tierraI, dx, dy, this);
				if (mapaGenerator.devuelveTile(x, y) == 5)
					g.drawImage(tierraizq, dx, dy, this);
				if (mapaGenerator.devuelveTile(x, y) == 6)
					g.drawImage(tierraizqd, dx, dy, this);

				// if((x==1 )&& (y==1))
				// g.drawImage(borde, dx, dy, this);
				// else
				// g.drawImage(grama, dx, dy, this);
				// g.drawString("(" + x + "," + y + ")", dx,
				// dy + grama.getHeight() / 2);

				if ((x == seleccionado.x) && (y == seleccionado.y)) {
					g.drawImage(seleccion, dx, dy, this);
				}
			}
		}
	}

	public void crearHUD(Graphics g) {
		float ANCHO = this.getWidth();
		float ALTO = this.getHeight();
		int x = (int) Math.floor(ANCHO / 2) - 375;
		int y = 40;

		// AffineTransform tx = new AffineTransform();
		// tx.translate(0, 0);
		// tx.scale(1, 1);

		// Dibuja los botones
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

		// Dibuja los labels
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

		// JLabel lochas= new JLabel("200bolos");
		// add(lochas);
		// lochas.setBounds(10, 400, 60, 60);

		Graphics2D g2d = (Graphics2D) g;
		Font font = new Font("Calibri", Font.BOLD, 21);
		String aString = Double.toString(lochas);
		AttributedString attributedString = new AttributedString(aString);
		attributedString.addAttribute(TextAttribute.FONT, font, 0,
				aString.length());
		attributedString.addAttribute(TextAttribute.FOREGROUND, Color.white, 0,
				aString.length());
		g2d.drawString(attributedString.getIterator(), 63, 230);
		String aString2 = Integer.toString(habitantes);
		AttributedString attributedString2 = new AttributedString(aString2);
		attributedString2.addAttribute(TextAttribute.FONT, font, 0,
				aString2.length());
		attributedString2.addAttribute(TextAttribute.FOREGROUND, Color.white,
				0, aString2.length());
		g2d.drawString(attributedString2.getIterator(), 69, 340);

		// try {
		// pause = ImageIO.read(new File(
		// "src/ISIS/Resource/HUDImages/startButton.png"));
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		// g.drawImage(pause, 170, (int) Math.floor(ALTO / 4 + 515), this);

		// Coordenadas de X y Y

		// g.drawImage(pause, 190, 708,this);
		// 220

		try {

			bmenu = ImageIO.read(new File(
					"src/ISIS/Resource/HUDImages/barra_menu.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(bmenu, 380, 660, this);

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
		Graphics g = null;
		float ANCHO = this.getWidth();
		float ALTO = this.getHeight();

		System.err.println("x:" + e.getX());
		System.err.println("y:" + e.getY());
		if ((e.getX() < this.getWidth() - 21 && e.getX() > this.getWidth() - 150)
				&& (e.getY() < ALTO / 4 + 300 && e.getY() > ALTO / 4 + 240)) {
			if (isConstruir() == false) {
				setConstruir(true);
				// System.out.println("ent x: " + e.getX());
				// System.out.println(" ent y: " + e.getY() );
				repaint();
			} else if (isConstruir() == true) {
				setConstruir(false);
				System.out.println("ent1 x: " + e.getX());
				System.out.println(" ent1 y: " + e.getY());
				repaint();
			}

			// else if ((e.getX() < this.getWidth() - 21 && e.getX() >
			// this.getWidth() - 150) && (e.getY() < 700 && e.getY() > 600)) {
			// System.out.println("Pausar");
			// }
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
				public void actionPerformed(ActionEvent e) {
					itemMover();
				}
			});
			Pmenu.add(menuItem);
			menuItem = new JMenuItem("Eliminar Edificacion");
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
		// System.out.println("ancho: "+ANCHO);
		// System.out.println("alto: "+ALTO);
		System.out.println(e.getX());
		if ((e.getX() < ANCHO / 2 - 375 + 15 + 132 && e.getX() > ANCHO / 2 - 375 + 15)
				&& (e.getY() < 80 && e.getY() > 42)) {
			// System.out.println(e.getX());
			// System.err.println("Ancho: " + ((ANCHO / 5) + 165) + " alto: "
			// + ((ANCHO / 5) + 15));
			StartPanel.click.play();
			System.out.println("Edificaciones");
			fireActionEvent(new ActionEvent(this, 0, "Edificaciones"));
			// // if (e.getX()>ANCHO / 5 && e.getX()<(ALTO/5)+160){

			// System.out.println(ANCHO);
			// // }

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

		// && (e.getY() < 80 && e.getY() > 42)
		else if ((e.getX() < ANCHO / 2 - 375 + 909 && e.getX() > ANCHO / 2 - 375 + 718)
				&& (e.getY() < 708 && e.getY() > 150)) {
			System.out.println("PAUSE");
			fireActionEvent(new ActionEvent(this, 0, "PAUSE"));

		}

		// else if ((e.getX() < 170 && e.getX() > 120)
		// && (e.getY() < (int) Math.floor(ALTO / 4 + 515) && e.getY() > (int)
		// Math
		// .floor(ALTO / 4 + 480))) {

		// else if ((e.getX() < 170 && e.getX() > 120) && (e.getY() < 708 &&
		// e.getY() > 680)){

		// else if ((e.getX() < 170 && e.getX() > 120)
		// && (e.getY() < (int) Math.floor(ALTO / 4 + 515) && e.getY() > (int)
		// Math
		// .floor(ALTO / 4 + 480))) {

		else if ((e.getX() < this.getWidth() - 21 && e.getX() > this.getWidth() - 150)
				&& (e.getY() < ALTO / 4 + 480 && e.getY() > ALTO / 4 + 430)) {

			System.out.println("PAUSE2");
			fireActionEvent(new ActionEvent(this, 0, "PAUSE"));

		}

		else if (isClick() == true) {

			if (matriz.leerDato(i, j) != null) {

				// seleccion = colision;
				System.out.println("no se puede construir casa");

				repaint();

			} else {

				crearCasa(i, j);

			}
			repaint();
			// setClick(false);
		}

		// Ubicar los botones zoom

		// if ((e.getX() < this.getWidth() - 21 && e.getX() > this.getWidth() -
		// 150) && (e.getY() < ALTO / 4 + 100 && e.getY() > ALTO / 4 + 240)) {
		// // e.getY() < ALTO / 4 + 300 && e.getY() > ALTO / 4 + 240
		//
		// // if((e.getX() < ANCHO - 150 ) && (e.getY() < Math.floor(ALTO /
		// 4))){
		//
		// System.err.println("Me dieron click aki" + "x: " + e.getX() + "y: " +
		// e.getY());
		//
		// // panelPausa = new PanelPausa(null, click);
		//
		//
		//
		//
		// }
	}

	protected void itemMover() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if ((e.getButton() == MouseEvent.BUTTON1) && !arrastre) {
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

	@Override
	public void mouseEntered(MouseEvent e) {

		// // Set cursor for the frame component
		// Toolkit toolkit = Toolkit.getDefaultToolkit();
		// Image image = toolkit.getImage("src/ISIS/Code/Matriz/cursor.png");
		// Cursor c = toolkit.createCustomCursor(image , new
		// Point(this.getX(),this.getY()), "img");
		// setCursor (c);
	}

	@Override
	public void mouseExited(MouseEvent e) {
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

	public void addActionListener(ActionListener listener) {
		eventListenerList.add(ActionListener.class, listener);
	}

	public void removeActionListener(ActionListener listener) {
		eventListenerList.remove(ActionListener.class, listener);
	}

	public ActionListener[] getActionListeners() {
		return eventListenerList.getListeners(ActionListener.class);
	}

	private void fireActionEvent(ActionEvent evt) {
		ActionListener[] actionListeners = getActionListeners();

		for (ActionListener actionListener : actionListeners) {
			actionListener.actionPerformed(evt);
		}
	}

	public boolean isClick() {
		return click;
	}

	public void setClick(boolean click) {
		this.click = click;
	}

	// private JSlider getSlider() {
	// int min = 1, max = 36, inc = 5;
	// final JSlider slider = new JSlider(min, max, 16);
	// slider.setMajorTickSpacing(5);
	// slider.setMinorTickSpacing(1);
	// slider.setPaintTicks(true);
	// slider.setSnapToTicks(true);
	// // slider.setLabelTable(getLabelTable(min, max, inc));
	// // slider.setPaintLabels(true);
	// slider.addChangeListener(new ChangeListener() {
	// public void stateChanged(ChangeEvent e) {
	// int value = slider.getValue();
	// scale = (value + 4) / 20.0;
	// revalidate();
	// repaint();
	// }
	// });
	// return slider;
	// }

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub

		if (e.getWheelRotation() < 0) {
			scale = scale + 0.1;
			repaint();
		} else if (e.getWheelRotation() > 0) {
			scale = scale - 0.1;
			repaint();
		}

	}

	public static double getLochas() {
		return lochas;
	}

	public static void setLochas(double lochas) {
		Mapa.lochas = (long) lochas;
	}

	public static int getHabitantes() {
		return habitantes;
	}

	public static void setHabitantes(int habitantes) {
		Mapa.habitantes = habitantes;
	}

	public static boolean isConstruir() {
		return construir;
	}

	public static void setConstruir(boolean construir) {
		Mapa.construir = construir;
	}

	// public static void main(String[] args) {
	// GraphicsDevice grafica = GraphicsEnvironment
	// .getLocalGraphicsEnvironment().getDefaultScreenDevice();
	// JFrame frame = new JFrame();
	// frame.setLayout(new BorderLayout());
	// Mapa mapa = new Mapa();
	// frame.add(mapa, BorderLayout.CENTER);
	// frame.setSize(500, 400);
	// // frame.setUndecorated(true);
	// // grafica.setFullScreenWindow(frame);
	// frame.setVisible(true);
	// }

}
