package ISIS.Code.Class;

import java.awt.Label;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import ISIS.Code.Frame.*;
import ISIS.Code.Panels.PanelBienvenido;

/**
 * 
 * @author ISIS
 */

public class HiloProgreso extends Thread {
	JProgressBar progreso;
	String[] str;
	JLabel[] labels;
	Cargando cargando;

	public HiloProgreso(JProgressBar progreso1) {
		super();

		this.progreso = progreso1;

	}

	public void run() {

		for (int i = 0; i <= 100; i++) {

			progreso.setValue(i);
			progreso.setStringPainted(true);
			pausa(100);
			

		}
		MainFrame.transicion.addPanel(bienvenido);
		MainFrame.transicion.derecha();

	}

	public void pausa(int mlSeg) {
		try {
			// pausa para el splash
			Thread.sleep(mlSeg);
		} catch (Exception e) {
		}
	}
	
//	private MainFrame frame;
	PanelBienvenido bienvenido= new PanelBienvenido();
}
