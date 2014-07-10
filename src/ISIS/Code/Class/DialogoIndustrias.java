package ISIS.Code.Class;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.event.EventListenerList;

import ISIS.Code.Matriz.Mapa;

/**
 * 
 * @author ISIS
 */

public class DialogoIndustrias extends JDialog {

	/**
	 * Creates new form Dialogo
	 */
	public DialogoIndustrias(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
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
		System.out.println("incia componentes dialogo");
		panelNice1 = new org.edisoncor.gui.panel.PanelNice();
		tabbedSelector21 = new org.edisoncor.gui.tabbedPane.TabbedSelector2();
		panelImage1 = new org.edisoncor.gui.panel.PanelImage();
		panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
		buttonSeven1 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		buttonSeven2 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel3 = new javax.swing.JLabel();
		buttonSeven3 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel4 = new javax.swing.JLabel();
		buttonSeven4 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel5 = new javax.swing.JLabel();
		buttonSeven5 = new org.edisoncor.gui.button.ButtonSeven();
		buttonSeven26 = new org.edisoncor.gui.button.ButtonSeven();
		panelImage2 = new org.edisoncor.gui.panel.PanelImage();
		panelCurves4 = new org.edisoncor.gui.panel.PanelCurves();
		jLabel6 = new javax.swing.JLabel();
		buttonSeven6 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel7 = new javax.swing.JLabel();
		buttonSeven7 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel8 = new javax.swing.JLabel();
		buttonSeven8 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel9 = new javax.swing.JLabel();
		buttonSeven9 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel10 = new javax.swing.JLabel();
		buttonSeven10 = new org.edisoncor.gui.button.ButtonSeven();
		buttonSeven27 = new org.edisoncor.gui.button.ButtonSeven();
		panelImage3 = new org.edisoncor.gui.panel.PanelImage();
		panelCurves5 = new org.edisoncor.gui.panel.PanelCurves();
		jLabel11 = new javax.swing.JLabel();
		buttonSeven11 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel12 = new javax.swing.JLabel();
		buttonSeven12 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel13 = new javax.swing.JLabel();
		buttonSeven13 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel14 = new javax.swing.JLabel();
		buttonSeven14 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel15 = new javax.swing.JLabel();
		buttonSeven15 = new org.edisoncor.gui.button.ButtonSeven();
		buttonSeven28 = new org.edisoncor.gui.button.ButtonSeven();
		panelImage4 = new org.edisoncor.gui.panel.PanelImage();
		panelCurves2 = new org.edisoncor.gui.panel.PanelCurves();
		jLabel16 = new javax.swing.JLabel();
		buttonSeven16 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel17 = new javax.swing.JLabel();
		buttonSeven17 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel18 = new javax.swing.JLabel();
		buttonSeven18 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel19 = new javax.swing.JLabel();
		buttonSeven19 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel20 = new javax.swing.JLabel();
		buttonSeven20 = new org.edisoncor.gui.button.ButtonSeven();
		buttonSeven29 = new org.edisoncor.gui.button.ButtonSeven();
		panelImage5 = new org.edisoncor.gui.panel.PanelImage();
		panelCurves3 = new org.edisoncor.gui.panel.PanelCurves();
		jLabel21 = new javax.swing.JLabel();
		buttonSeven21 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel22 = new javax.swing.JLabel();
		buttonSeven22 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel23 = new javax.swing.JLabel();
		buttonSeven23 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel24 = new javax.swing.JLabel();
		buttonSeven24 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel25 = new javax.swing.JLabel();
		buttonSeven25 = new org.edisoncor.gui.button.ButtonSeven();
		buttonSeven30 = new org.edisoncor.gui.button.ButtonSeven();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setUndecorated(true);

		panelNice1.setPreferredSize(new java.awt.Dimension(500, 400));

		panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/Backgrounds/BackCasas.jpg"))); // NOI18N
		panelImage1.setLayout(null);

		panelCurves1.setLayout(null);

		buttonSeven1.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven1.setText("Comprar");
		panelCurves1.add(buttonSeven1);
		buttonSeven1.setBounds(100, 100, 70, 22);
		buttonSeven1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				dispose();
				gamepanel.mouseClicked(evt);
				gamepanel.setClick(true);
				// setSeleccionada(1);

			}
		});

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/MenuCompra/Industria/Aserradero.png"))); // NOI18N
		panelCurves1.add(jLabel1);
		jLabel1.setBounds(27, 12, 189, 100);

		jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/MenuCompra/Industria/lblCafeteria.png"))); // NOI18N
		panelCurves1.add(jLabel2);
		jLabel2.setBounds(30, 130, 189, 100);

		buttonSeven2.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven2.setText("Comprar");
		panelCurves1.add(buttonSeven2);
		buttonSeven2.setBounds(110, 220, 70, 22);

		jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/MenuCompra/Industria/lblFruteria.png"))); // NOI18N
		panelCurves1.add(jLabel3);
		jLabel3.setBounds(30, 260, 189, 100);

		buttonSeven3.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven3.setText("Comprar");
		panelCurves1.add(buttonSeven3);
		buttonSeven3.setBounds(110, 350, 70, 22);

		jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/MenuCompra/Industria/lblGranja.png"))); // NOI18N
		panelCurves1.add(jLabel4);
		jLabel4.setBounds(220, 70, 189, 100);

		buttonSeven4.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven4.setText("Comprar");
		panelCurves1.add(buttonSeven4);
		buttonSeven4.setBounds(300, 160, 70, 22);

		jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/MenuCompra/Industria/lblRestaurantBarato.png"))); // NOI18N
		panelCurves1.add(jLabel5);
		jLabel5.setBounds(220, 200, 189, 100);

		buttonSeven5.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven5.setText("Comprar");
		panelCurves1.add(buttonSeven5);
		buttonSeven5.setBounds(300, 290, 70, 22);

		buttonSeven26.setBackground(new java.awt.Color(0, 0, 255));
		buttonSeven26.setText("Volver");
		buttonSeven26.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				dispose();
			}
		});
		panelCurves1.add(buttonSeven26);
		buttonSeven26.setBounds(406, 345, 80, 30);

		panelImage1.add(panelCurves1);
		panelCurves1.setBounds(-1, -1, 490, 390);

		tabbedSelector21.addTab("", new javax.swing.ImageIcon(getClass()
				.getResource("/ISIS/Resource/ButtonImages/#1 (Copiar).png")),
				panelImage1, ""); // NOI18N

		panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/Backgrounds/BackCasas2.jpg"))); // NOI18N
		panelImage2.setLayout(null);

		panelCurves4.setLayout(null);

		jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves4.add(jLabel6);
		jLabel6.setBounds(27, 12, 189, 100);

		buttonSeven6.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven6.setText("Comprar");
		panelCurves4.add(buttonSeven6);
		buttonSeven6.setBounds(100, 100, 70, 22);

		jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves4.add(jLabel7);
		jLabel7.setBounds(30, 130, 189, 100);

		buttonSeven7.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven7.setText("Comprar");
		panelCurves4.add(buttonSeven7);
		buttonSeven7.setBounds(110, 220, 70, 22);

		jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves4.add(jLabel8);
		jLabel8.setBounds(30, 260, 189, 100);

		buttonSeven8.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven8.setText("Comprar");
		panelCurves4.add(buttonSeven8);
		buttonSeven8.setBounds(110, 350, 70, 22);

		jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves4.add(jLabel9);
		jLabel9.setBounds(220, 70, 189, 100);

		buttonSeven9.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven9.setText("Comprar");
		panelCurves4.add(buttonSeven9);
		buttonSeven9.setBounds(300, 160, 70, 22);

		jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves4.add(jLabel10);
		jLabel10.setBounds(220, 200, 189, 100);

		buttonSeven10.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven10.setText("Comprar");
		panelCurves4.add(buttonSeven10);
		buttonSeven10.setBounds(300, 290, 70, 22);

		buttonSeven27.setBackground(new java.awt.Color(0, 0, 255));
		buttonSeven27.setText("Volver");
		buttonSeven27.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				dispose();
			}
		});
		panelCurves4.add(buttonSeven27);
		buttonSeven27.setBounds(406, 345, 80, 30);

		panelImage2.add(panelCurves4);
		panelCurves4.setBounds(0, 0, 490, 390);

		tabbedSelector21.addTab("", new javax.swing.ImageIcon(getClass()
				.getResource("/ISIS/Resource/ButtonImages/#2 (Copiar).png")),
				panelImage2); // NOI18N
		panelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/Backgrounds/BackCasas3.jpg"))); // NOI18N
		panelImage3.setLayout(null);

		panelCurves5.setLayout(null);

		jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves5.add(jLabel11);
		jLabel11.setBounds(27, 12, 189, 100);

		buttonSeven11.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven11.setText("Comprar");
		panelCurves5.add(buttonSeven11);
		buttonSeven11.setBounds(100, 100, 70, 22);

		jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves5.add(jLabel12);
		jLabel12.setBounds(30, 130, 189, 100);

		buttonSeven12.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven12.setText("Comprar");
		panelCurves5.add(buttonSeven12);
		buttonSeven12.setBounds(110, 220, 70, 22);

		jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves5.add(jLabel13);
		jLabel13.setBounds(30, 260, 189, 100);

		buttonSeven13.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven13.setText("Comprar");
		panelCurves5.add(buttonSeven13);
		buttonSeven13.setBounds(110, 350, 70, 22);

		jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves5.add(jLabel14);
		jLabel14.setBounds(220, 70, 189, 100);

		buttonSeven14.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven14.setText("Comprar");
		panelCurves5.add(buttonSeven14);
		buttonSeven14.setBounds(300, 160, 70, 22);

		jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves5.add(jLabel15);
		jLabel15.setBounds(220, 200, 189, 100);

		buttonSeven15.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven15.setText("Comprar");
		panelCurves5.add(buttonSeven15);
		buttonSeven15.setBounds(300, 290, 70, 22);

		buttonSeven28.setBackground(new java.awt.Color(0, 0, 255));
		buttonSeven28.setText("Volver");
		buttonSeven28.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				dispose();
			}
		});
		panelCurves5.add(buttonSeven28);
		buttonSeven28.setBounds(406, 345, 80, 30);

		panelImage3.add(panelCurves5);
		panelCurves5.setBounds(0, 0, 490, 390);

		tabbedSelector21.addTab("", new javax.swing.ImageIcon(getClass()
				.getResource("/ISIS/Resource/ButtonImages/#3 (Copiar).png")),
				panelImage3); // NOI18N

		panelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/Backgrounds/BackCasas4.jpg"))); // NOI18N
		panelImage4.setLayout(null);

		panelCurves2.setLayout(null);

		jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves2.add(jLabel16);
		jLabel16.setBounds(27, 12, 189, 100);

		buttonSeven16.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven16.setText("Comprar");
		panelCurves2.add(buttonSeven16);
		buttonSeven16.setBounds(100, 100, 70, 22);

		jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves2.add(jLabel17);
		jLabel17.setBounds(30, 130, 189, 100);

		buttonSeven17.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven17.setText("Comprar");
		panelCurves2.add(buttonSeven17);
		buttonSeven17.setBounds(110, 220, 70, 22);

		jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves2.add(jLabel18);
		jLabel18.setBounds(30, 260, 189, 100);

		buttonSeven18.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven18.setText("Comprar");
		panelCurves2.add(buttonSeven18);
		buttonSeven18.setBounds(110, 350, 70, 22);

		jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves2.add(jLabel19);
		jLabel19.setBounds(220, 70, 189, 100);

		buttonSeven19.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven19.setText("Comprar");
		panelCurves2.add(buttonSeven19);
		buttonSeven19.setBounds(300, 160, 70, 22);

		jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves2.add(jLabel20);
		jLabel20.setBounds(220, 200, 189, 100);

		buttonSeven20.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven20.setText("Comprar");
		panelCurves2.add(buttonSeven20);
		buttonSeven20.setBounds(300, 290, 70, 22);

		buttonSeven29.setBackground(new java.awt.Color(0, 0, 255));
		buttonSeven29.setText("Volver");
		buttonSeven29.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				dispose();
			}
		});
		panelCurves2.add(buttonSeven29);
		buttonSeven29.setBounds(406, 345, 80, 30);

		panelImage4.add(panelCurves2);
		panelCurves2.setBounds(0, 0, 490, 380);

		tabbedSelector21.addTab("", new javax.swing.ImageIcon(getClass()
				.getResource("/ISIS/Resource/ButtonImages/#4 (Copiar).png")),
				panelImage4, ""); // NOI18N
		panelImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/Backgrounds/BackCasas5.jpg"))); // NOI18N
		panelImage5.setLayout(null);

		panelCurves3.setLayout(null);

		jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves3.add(jLabel21);
		jLabel21.setBounds(27, 12, 189, 100);

		buttonSeven21.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven21.setText("Comprar");
		panelCurves3.add(buttonSeven21);
		buttonSeven21.setBounds(100, 100, 70, 22);

		jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves3.add(jLabel22);
		jLabel22.setBounds(30, 130, 189, 100);

		buttonSeven22.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven22.setText("Comprar");
		panelCurves3.add(buttonSeven22);
		buttonSeven22.setBounds(110, 220, 70, 22);

		jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves3.add(jLabel23);
		jLabel23.setBounds(30, 260, 189, 100);

		buttonSeven23.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven23.setText("Comprar");
		panelCurves3.add(buttonSeven23);
		buttonSeven23.setBounds(110, 350, 70, 22);

		jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves3.add(jLabel24);
		jLabel24.setBounds(220, 70, 189, 100);

		buttonSeven24.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven24.setText("Comprar");
		panelCurves3.add(buttonSeven24);
		buttonSeven24.setBounds(300, 160, 70, 22);

		jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/ButtonImages/PetroCasa.png"))); // NOI18N
		panelCurves3.add(jLabel25);
		jLabel25.setBounds(220, 200, 189, 100);

		buttonSeven25.setBackground(new java.awt.Color(255, 0, 0));
		buttonSeven25.setText("Comprar");
		panelCurves3.add(buttonSeven25);
		buttonSeven25.setBounds(300, 290, 70, 22);

		buttonSeven30.setBackground(new java.awt.Color(0, 0, 255));
		buttonSeven30.setText("Volver");
		buttonSeven30.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				dispose();
			}
		});
		panelCurves3.add(buttonSeven30);
		buttonSeven30.setBounds(406, 345, 80, 30);

		panelImage5.add(panelCurves3);
		panelCurves3.setBounds(0, 0, 490, 380);

		tabbedSelector21.addTab("", new javax.swing.ImageIcon(getClass()
				.getResource("/ISIS/Resource/ButtonImages/#5 (Copiar).png")),
				panelImage5, ""); // NOI18N

		javax.swing.GroupLayout panelNice1Layout = new javax.swing.GroupLayout(
				panelNice1);
		panelNice1.setLayout(panelNice1Layout);
		panelNice1Layout
				.setHorizontalGroup(panelNice1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelNice1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												tabbedSelector21,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												565, Short.MAX_VALUE)
										.addContainerGap()));
		panelNice1Layout.setVerticalGroup(panelNice1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				panelNice1Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(tabbedSelector21,
								javax.swing.GroupLayout.DEFAULT_SIZE, 397,
								Short.MAX_VALUE).addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 585, Short.MAX_VALUE)
				.addGroup(
						layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(panelNice1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										585, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 421, Short.MAX_VALUE)
				.addGroup(
						layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(panelNice1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										421, Short.MAX_VALUE)));

		tabbedSelector21.setEnabledAt(1, false);
		tabbedSelector21.setEnabledAt(2, false);
		tabbedSelector21.setEnabledAt(3, false);
		tabbedSelector21.setEnabledAt(4, false);
		pack();
	}// </editor-fold>//GEN-END:initComponents

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

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/*
		 * Set the Nimbus look and feel
		 */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Dialogo.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Dialogo.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Dialogo.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Dialogo.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/*
		 * Create and display the dialog
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				Dialogo dialog = new Dialogo(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {

					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

	// public static int getSeleccionada() {
	// return seleccionada;
	// }
	//
	// public static void setSeleccionada(int seleccionada) {
	// Dialogo.seleccionada = seleccionada;
	// }

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private org.edisoncor.gui.button.ButtonSeven buttonSeven1;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven10;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven11;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven12;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven13;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven14;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven15;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven16;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven17;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven18;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven19;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven2;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven20;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven21;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven22;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven23;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven24;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven25;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven26;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven27;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven28;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven29;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven3;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven30;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven4;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven5;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven6;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven7;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven8;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven9;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private org.edisoncor.gui.panel.PanelCurves panelCurves1;
	private org.edisoncor.gui.panel.PanelCurves panelCurves2;
	private org.edisoncor.gui.panel.PanelCurves panelCurves3;
	private org.edisoncor.gui.panel.PanelCurves panelCurves4;
	private org.edisoncor.gui.panel.PanelCurves panelCurves5;
	private org.edisoncor.gui.panel.PanelImage panelImage1;
	private org.edisoncor.gui.panel.PanelImage panelImage2;
	private org.edisoncor.gui.panel.PanelImage panelImage3;
	private org.edisoncor.gui.panel.PanelImage panelImage4;
	private org.edisoncor.gui.panel.PanelImage panelImage5;
	private org.edisoncor.gui.panel.PanelNice panelNice1;
	private org.edisoncor.gui.tabbedPane.TabbedSelector2 tabbedSelector21;
	private EventListenerList eventListenerList = new EventListenerList();
	private Mapa gamepanel = new Mapa();
	// static int seleccionada;

}