package ui.menus;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.poliza.PolizaRegistroPago;

@SuppressWarnings("serial")
public class MenuCobrador extends JPanel {
	private JFrame ventana;
	private GridBagConstraints gbc;
	private JLabel lblUsuario;
	private JLabel lblNombreUsuario;
	private JButton btnRegistrarPago;
	private JButton btnSalir;
	
	public MenuCobrador(JFrame ventana/*,JPanel panelInicioSesion, String nombreUsuario*/) {
		this.ventana = ventana;
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.armarPanel();
	}
	
	private void armarPanel() {
		lblUsuario = new JLabel("USUARIO:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 0.5;
		gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblUsuario, gbc);
		
		lblNombreUsuario = new JLabel("PRUEBA"/*nombreUsuario*/);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		this.add(lblNombreUsuario, gbc);
		
		btnRegistrarPago = new JButton("Registrar pago Póliza");
		btnRegistrarPago.setPreferredSize(new Dimension(350,50));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(btnRegistrarPago, gbc);
		btnRegistrarPago.addActionListener(e -> {
			//TODO: Terminarlo
			ventana.setTitle("Póliza - Registro de pago");
			ventana.setContentPane(new PolizaRegistroPago(ventana, this));
			ventana.setVisible(true);
		});
		
		btnSalir = new JButton("Salir");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weighty = 0.5;
		gbc.anchor = GridBagConstraints.NORTH;
		this.add(btnSalir, gbc);
		btnSalir.addActionListener(e -> {
			//TODO: Terminar el funcionamiento del boton salir
			/*ventana.setTitle("El Asegurado - Inicio de Sesión");
			ventana.setContentPane(panelInicioSesion);*/
		});	
	}
}