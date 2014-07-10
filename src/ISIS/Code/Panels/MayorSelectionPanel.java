package ISIS.Code.Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.EventListenerList;

import ISIS.Code.Class.PanelAvatarChooser;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author ISIS
 */
public class MayorSelectionPanel extends javax.swing.JPanel {

	/**
	 * Creates new form MayorSelectionPanel
	 */
	public MayorSelectionPanel() {
		initComponents();

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		buttonAeroRight1 = new org.edisoncor.gui.button.ButtonAeroRight();
		labelRound1 = new org.edisoncor.gui.label.LabelRound();
		buttonAeroLeft1 = new org.edisoncor.gui.button.ButtonAeroLeft();
		buttonSeven1 = new org.edisoncor.gui.button.ButtonSeven();
		textFieldRoundBackground1 = new org.edisoncor.gui.textField.TextFieldRoundBackground();
		panelAvatarChooser1 = new PanelAvatarChooser();

		setPreferredSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		buttonAeroRight1.setText("Pa' tras");
		buttonAeroRight1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonAeroRight1ActionPerformed(evt);
			}
		});
		add(buttonAeroRight1);
		buttonAeroRight1.setBounds(0, 540, 85, 26);

		labelRound1.setText("Selecciona un Personaje");
		labelRound1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
		add(labelRound1);
		labelRound1.setBounds(220, 10, 350, 29);

		buttonAeroLeft1.setText("Pa' Lante");
		buttonAeroLeft1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonAeroLeft1ActionPerformed(evt);
			}
		});
		add(buttonAeroLeft1);
		buttonAeroLeft1.setBounds(700, 540, 97, 26);
		buttonAeroLeft1.setEnabled(false);

		buttonSeven1.setText("Seleccionar");
		add(buttonSeven1);
		buttonSeven1.setBounds(330, 540, 116, 30);
		buttonSeven1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				buttonAeroLeft1.setEnabled(true);
				setAlcaldeSeleccionado(panelAvatarChooser1.getSelectedAvatar()
						.getTitulo());
				setNombreAlcalde(textFieldRoundBackground1.getText());
				System.out.println(textFieldRoundBackground1.getText());
				repaint();
			}
		});

		textFieldRoundBackground1
				.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		textFieldRoundBackground1.setDescripcion("Ingrese su Nombre...");
		textFieldRoundBackground1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
		add(textFieldRoundBackground1);

		textFieldRoundBackground1.setBounds(280, 520, 220, 20);

		panelAvatarChooser1.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/ISIS/Resource/Backgrounds/BackCity.jpg"))); // NOI18N

		javax.swing.GroupLayout panelAvatarChooser1Layout = new javax.swing.GroupLayout(
				panelAvatarChooser1);
		panelAvatarChooser1.setLayout(panelAvatarChooser1Layout);
		panelAvatarChooser1Layout.setHorizontalGroup(panelAvatarChooser1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 800, Short.MAX_VALUE));
		panelAvatarChooser1Layout.setVerticalGroup(panelAvatarChooser1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 600, Short.MAX_VALUE));

		add(panelAvatarChooser1);
		panelAvatarChooser1.setBounds(0, 0, 800, 600);

	}// </editor-fold>//GEN-END:initComponents

	private void buttonAeroLeft1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		fireActionEvent(new ActionEvent(this, 0, "PanelNext"));
		System.out.println(panelAvatarChooser1.getSelectedAvatar().getTitulo());
	}

	private void buttonAeroRight1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		fireActionEvent(new ActionEvent(this, 0, "PanelPrev"));
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

	public String getAlcaldeSeleccionado() {
		return alcaldeSeleccionado;
	}

	public void setAlcaldeSeleccionado(String alcaldeSeleccionado) {
		this.alcaldeSeleccionado = alcaldeSeleccionado;
	}

	public String getNombreAlcalde() {
		return nombreAlcalde;
	}

	public void setNombreAlcalde(String nombreAlcalde) {
		this.nombreAlcalde = nombreAlcalde;
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private EventListenerList eventListenerList = new EventListenerList();
	private org.edisoncor.gui.button.ButtonAeroLeft buttonAeroLeft1;
	private org.edisoncor.gui.button.ButtonAeroRight buttonAeroRight1;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven1;
	private org.edisoncor.gui.label.LabelRound labelRound1;
	private PanelAvatarChooser panelAvatarChooser1;
	private org.edisoncor.gui.textField.TextFieldRoundBackground textFieldRoundBackground1;
	public String alcaldeSeleccionado;
	private String nombreAlcalde;
	// End of variables declaration//GEN-END:variables
}
