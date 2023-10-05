package ui.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import utils.DocumentFilterLimit;

@SuppressWarnings("serial")
public class InicioSesion extends JPanel {
	private JFrame ventana;
	private GridBagConstraints gbc;
	private JLabel lblTitulo;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private JButton btnIniciarSesion;
	private JButton btnSalir;
	
	private Border defaultBorder = (new JTextField()).getBorder(); //Borde por defecto para usarlo en btnIniciarSesion
	
	public InicioSesion(JFrame ventana) {
		this.ventana = ventana;
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.armarPanel();
	}
	
	private void armarPanel() {
		lblTitulo = new JLabel("El Asegurado");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 60));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.weightx = 1;
		gbc.insets = new Insets(10, 10, 30, 10);
		this.add(lblTitulo, gbc);
		
		lblUsuario = new JLabel("Nombre de usuario:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 0.5;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblUsuario, gbc);
		
		txtUsuario = new JTextField(20); //El numero indica el ancho del campo
		// Limitar la cantidad de caracteres usando un DocumentFilter
		txtUsuario.setDocument(new DocumentFilterLimit(15));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(txtUsuario, gbc);
		
		lblPassword = new JLabel("Contraseña:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.EAST;
		this.add(lblPassword, gbc);
		
		txtPassword = new JPasswordField(20); //El numero indica el ancho del campo
		// Limitar la cantidad de caracteres usando un DocumentFilter
		txtPassword.setDocument(new DocumentFilterLimit(20));
		txtPassword.setEchoChar('*'); //La contraseña se visualiza con *
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(txtPassword, gbc);
		
		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setPreferredSize(new Dimension(120,25));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.EAST;
		this.add(btnIniciarSesion, gbc);
		btnIniciarSesion.addActionListener(e -> {
			/* TODO: Recuperar de la base de datos el usuario y setear 
			 * la pantalla segun el usuario
			 */
			txtUsuario.setBorder(defaultBorder);
            txtPassword.setBorder(defaultBorder);
			if(txtUsuario.getText().isBlank() || txtPassword.getPassword().length == 0) {
				mensajeDatosObligatorios();
	            Border redBorder = BorderFactory.createLineBorder(Color.RED);
				if(txtUsuario.getText().isBlank() && txtPassword.getPassword().length == 0) {
					txtUsuario.requestFocus();
					txtUsuario.setBorder(redBorder);
					txtPassword.setBorder(redBorder);
				}else if(txtUsuario.getText().isBlank()) {
					txtUsuario.requestFocus();
					txtUsuario.setBorder(redBorder);
				}
				else {
					txtPassword.setBorder(redBorder);
					txtPassword.requestFocus();
				}
			}/*else if(Si los datos no son validos es decir que no existe usuario) {
				mensajeUsuarioOPasswordNoValidos();
				txtUsuario.requestFocus();
			}else {
				
			}*/
		});
		
		btnSalir = new JButton("Salir");
		btnSalir.setPreferredSize(new Dimension(120,25));
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(btnSalir, gbc);
		btnSalir.addActionListener(e -> {
			// TODO: Cerrar conexion con base de datos
			System.exit(0);
		});
	}
	
	private void mensajeDatosObligatorios() {
		String mensaje = "Los siguientes campos son obligatorios: 'Nombre de usuario' y 'Contraseña'";
		JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	private void mensajeUsuarioOPasswordNoValidos() {
		String mensaje = "El usuario o la contraseña no son válidos";
		JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
}