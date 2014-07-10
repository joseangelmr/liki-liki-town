package ISIS.Code.Frame;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.edisoncor.gui.panel.PanelGlassGaussian;

//import tiled.mapeditor.MapEditor.ZoomInAction;
//import tiled.mapeditor.MapEditor.ZoomNormalAction;
//import tiled.mapeditor.MapEditor.ZoomOutAction;

//import Zoom.Resources;
import ISIS.Code.Class.Principal;
import ISIS.Code.Matriz.Mapa;
import ISIS.Code.Panels.*;
import ISIS.Code.Class.*;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * 
 * @author ISIS
 */

public class MainMapa extends JFrame /* implements KeyListener */{
	/**
	 * 
	 */
	private ISIS.Code.Class.Dialogo dialogo;
	private PanelPausa panelPausa;
	private static final long serialVersionUID = 1L;
	StartPanel starPanel = new StartPanel();
	MapSelectionPanel mapSelectionPanel = new MapSelectionPanel();
	public static MayorSelectionPanel mayorSelectionPanel = new MayorSelectionPanel();
	LoadGamePanel loadGamePanel = new LoadGamePanel();
	JPanel CurrentPanel = starPanel;
	Mapa gamePanel = new Mapa();
	Cargando cargando = new Cargando();
	Principal font = new Principal();
	PanelBienvenido panelbienvenido = new PanelBienvenido();
	PanelAtencion panelatencion = new PanelAtencion();
	PanelNiveles panelNiveles = new PanelNiveles();

	public TransicionPanel transicion = new TransicionPanel();

	// private Mapa currentMap;

	public MainMapa() {
		// TODO Auto-generated constructor stub
		GraphicsDevice grafica = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		// transicion.addPanel(panelatencion);
		// transicion.addPanel(starPanel);
		// transicion.addPanel(mayorSelectionPanel);
		// transicion.addPanel(mapSelectionPanel);
		// // transicion.addPanel(panelFinal);
		// transicion.addPanel(cargando);
		// transicion.addPanel(panelbienvenido);
		// // transicion.addPanel(font);
		transicion.addPanel(gamePanel);
		Events();
		this.add(transicion);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize()
				.getHeight());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize().getSize());
		this.setUndecorated(true);
		// grafica.setFullScreenWindow(this);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		// addKeyListener(this);
	}

	private void Events() {
		// TODO Auto-generated method stub

		gamePanel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getActionCommand().equals("Edificaciones")) {
					ISIS.Code.Class.PanelGlassGaussian glass = new ISIS.Code.Class.PanelGlassGaussian(
							MainMapa.this, 4);
					setGlassPane(glass);
					getGlassPane().setVisible(true);
					dialogo = new ISIS.Code.Class.Dialogo(MainMapa.this, true);
					dialogo.setLocationRelativeTo(null);
					dialogo.setVisible(true);
					getGlassPane().setVisible(false);

					// Panel Gaussiano Carretera
				} else if (arg0.getActionCommand().equals("Carretera")) {
					PanelGlassGaussian glassCarretera = new PanelGlassGaussian(
							MainMapa.this, 4);
					setGlassPane(glassCarretera);
					getGlassPane().setVisible(true);
					DialogoCarreteras dialogo2 = new DialogoCarreteras(
							MainMapa.this, true);
					dialogo2.setLocationRelativeTo(null);
					dialogo2.setVisible(true);
					getGlassPane().setVisible(false);

				} else if (arg0.getActionCommand().equals("Servicios")) {
					PanelGlassGaussian glassServicios = new PanelGlassGaussian(
							MainMapa.this, 4);
					setGlassPane(glassServicios);
					getGlassPane().setVisible(true);
					DialogoServiciosPublicos dialogo3 = new DialogoServiciosPublicos(
							MainMapa.this, true);
					dialogo3.setLocationRelativeTo(null);
					dialogo3.setVisible(true);
					getGlassPane().setVisible(false);

				} else if (arg0.getActionCommand().equals("Industrias")) {
					PanelGlassGaussian glassIndustria = new PanelGlassGaussian(
							MainMapa.this, 4);
					setGlassPane(glassIndustria);
					getGlassPane().setVisible(true);
					DialogoIndustrias dialogo4 = new DialogoIndustrias(
							MainMapa.this, true);
					dialogo4.setLocationRelativeTo(null);
					dialogo4.setVisible(true);
					getGlassPane().setVisible(false);
				}

				else if (arg0.getActionCommand().equals("PAUSE")) {
					PanelGlassGaussian glassPause = new PanelGlassGaussian(
							MainMapa.this, 4);
					setGlassPane(glassPause);
					getGlassPane().setVisible(true);
					panelPausa = new PanelPausa(MainMapa.this, true);
					panelPausa.setLocationRelativeTo(null);
					panelPausa.setVisible(true);
					getGlassPane().setVisible(false);

				}

			}

		});
	}

	public void ChangePanel() {
		// TODO Auto-generated method stub
		// this.remove(currentPanel);
		// this.add(newPanel);
		// this.setVisible(true);
		// this.revalidate();
		// this.repaint();
		// transicion.derecha();

		// transicion.derecha();
		// repaint();

	}

	//  Agregando el Zoom
	// ----------------------------------

	// private class ZoomInAction extends AbstractAction {
	//
	// public ZoomInAction(){
	// super(Resources.getString("action.zoom.in.name"));
	// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("control EQUALS"));
	// putValue(SHORT_DESCRIPTION,
	// Resources.getString("action.zoom.in.tooltip"));
	// putValue(SMALL_ICON, Resources.getIcon("gnome-zoom-in.png"));
	//
	// }
	// @Override
	// public void actionPerformed(ActionEvent e) {
	// if (currentMap != null) {
	// JComponent zoomOutAction;
	// zoomOutAction.setEnabled(true);
	// if (!mapView.zoomIn()) {
	// setEnabled(false);
	// }
	// zoomNormalAction.setEnabled(mapView.getZoomLevel() !=
	// MapView.ZOOM_NORMALSIZE);
	// }
	// }
	// }
	//
	// zoomInAction = new ZoomInAction();
	// zoomOutAction = new ZoomOutAction();
	// zoomNormalAction = new ZoomNormalAction();
	// }
	//
	//
	//
	// }
	//
	// private class ZoomOutAction extends AbstractAction {
	// public ZoomOutAction() {
	// super(Resources.getString("action.zoom.out.name"));
	// putValue(ACCELERATOR_KEY,
	// KeyStroke.getKeyStroke("control MINUS"));
	// putValue(SHORT_DESCRIPTION,
	// Resources.getString("action.zoom.out.tooltip"));
	// putValue(SMALL_ICON, Resources.getIcon("gnome-zoom-out.png"));
	// }
	// public void actionPerformed(ActionEvent evt) {
	// if (currentMap != null) {
	// zoomInAction.setEnabled(true);
	// if (!mapView.zoomOut()) {
	// setEnabled(false);
	// }
	// zoomNormalAction.setEnabled(mapView.getZoomLevel() !=
	// MapView.ZOOM_NORMALSIZE);
	// }
	// }
	// }
	//
	// private class ZoomNormalAction extends AbstractAction {
	// public ZoomNormalAction() {
	// super(Resources.getString("action.zoom.normal.name"));
	// putValue(ACCELERATOR_KEY,
	// KeyStroke.getKeyStroke("control 0"));
	// putValue(SHORT_DESCRIPTION,
	// Resources.getString("action.zoom.normal.tooltip"));
	// }
	// public void actionPerformed(ActionEvent evt) {
	// if (currentMap != null) {
	// zoomInAction.setEnabled(true);
	// zoomOutAction.setEnabled(true);
	// setEnabled(false);
	// mapView.setZoomLevel(MapView.ZOOM_NORMALSIZE);
	// }
	// }
	// }

	public static void main(String[] args) {

		new MainMapa();
	}

	// @Override
	// public void keyPressed(KeyEvent arg0) {
	// // TODO Auto-generated method stub
	// if(arg0.getKeyCode()==27){
	// gamePanel.setClick(false);
	// }
	//
	// if(arg0.getKeyCode()==80){
	// System.out.println("PAUSE");
	// ISIS.Code.Class.PanelGlassGaussian glass = new
	// ISIS.Code.Class.PanelGlassGaussian(
	// MainMapa.this, 4);
	// setGlassPane(glass);
	// getGlassPane().setVisible(true);
	// panelPausa = new PanelPausa(MainMapa.this, true);
	// panelPausa.setLocationRelativeTo(null);
	// panelPausa.setVisible(true);
	// panelPausa.setUndecorated(true);
	// getGlassPane().setVisible(false);
	// }
	//
	//
	//
	// }
	//
	// @Override
	// public void keyReleased(KeyEvent arg0) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void keyTyped(KeyEvent arg0) {
	// // TODO Auto-generated method stub
	//
	// }

}