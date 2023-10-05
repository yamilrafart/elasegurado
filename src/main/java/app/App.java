package app;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import ui.login.InicioSesion;
import ui.menus.MenuCobrador;
import ui.menus.MenuProductorSeguro;

public class App {

	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
		ventana.setTitle("El Asegurado - Inicio de Sesión");
		//ventana.setContentPane(new InicioSesion(ventana));
		ventana.setContentPane(new MenuProductorSeguro(ventana));
		//ventana.setContentPane(new MenuCobrador(ventana));
		ventana.setVisible(true);
	}
}