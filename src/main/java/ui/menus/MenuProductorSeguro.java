package ui.menus;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.poliza.PolizaAlta1;

@SuppressWarnings("serial")
public class MenuProductorSeguro extends JPanel {
	private JFrame ventana;
	private GridBagConstraints gbc;
	private JLabel lblUsuario;
	private JLabel lblNombreUsuario;
	private JButton btnAltaPoliza;
	private JButton btnConsultaPoliza;
	private JButton btnAltaCliente;
	private JButton btnConsultaCliente;
	private JButton btnGenerarPropuestas;
	private JButton btnActualizarFactores;
	private JButton btnSalir;
	
	public MenuProductorSeguro(JFrame ventana/*,JPanel panelInicioSesion, String nombreUsuario*/) {
		this.ventana = ventana;
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.armarPanel();
	}
	
	private void armarPanel() {
		lblUsuario = new JLabel("USUARIO:");
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblUsuario, gbc);
		
		lblNombreUsuario = new JLabel("PRUEBA"/*nombreUsuario*/);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(lblNombreUsuario, gbc);
		
		btnAltaPoliza = new JButton("Dar de Alta Póliza");
		btnAltaPoliza.setPreferredSize(new Dimension(350,50));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;
		this.add(btnAltaPoliza, gbc);
		btnAltaPoliza.addActionListener(e -> {
			ventana.setTitle("Póliza - Alta - 1");
			ventana.setContentPane(new PolizaAlta1(ventana,this));
			ventana.setVisible(true);
		});
		
		btnConsultaPoliza = new JButton("Consultar Póliza");
		btnConsultaPoliza.setPreferredSize(new Dimension(350,50));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(btnConsultaPoliza, gbc);
		
		btnAltaCliente = new JButton("Dar de Alta Cliente");
		btnAltaCliente.setPreferredSize(new Dimension(350,50));
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.EAST;
		this.add(btnAltaCliente, gbc);
		
		btnConsultaCliente = new JButton("Consultar Cliente");
		btnConsultaCliente.setPreferredSize(new Dimension(350,50));
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(btnConsultaCliente, gbc);
		
		btnGenerarPropuestas = new JButton("Generar Propuestas de Renovación");
		btnGenerarPropuestas.setPreferredSize(new Dimension(350,50));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.EAST;
		this.add(btnGenerarPropuestas, gbc);
		
		btnActualizarFactores = new JButton("Actualizar Factores de Características");
		btnActualizarFactores.setPreferredSize(new Dimension(350,50));
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(btnActualizarFactores, gbc);
		
		btnSalir = new JButton("Salir");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(btnSalir, gbc);
		btnSalir.addActionListener(e -> {
			//TODO: Terminar el funcionamiento del boton salir
			/*ventana.setTitle("El Asegurado - Inicio de Sesión");
			ventana.setContentPane(panelInicioSesion);
			ventana.setVisible(true);*/
		});
	}
}