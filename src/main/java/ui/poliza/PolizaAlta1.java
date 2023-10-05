package ui.poliza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.Duration;
import java.time.Instant;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import ui.cliente.ClienteConsulta;
import utils.DocumentFilterLimit;

@SuppressWarnings("serial")
public class PolizaAlta1 extends JPanel {
	private JFrame ventana;
	private JPanel panelMenu;
	private GridBagConstraints gbcContenido;
	private GridBagConstraints gbcCliente;
	private GridBagConstraints gbcDomicilio;
	private GridBagConstraints gbcPoliza;
	private GridBagConstraints gbcDomicilioRiesgo;
	private GridBagConstraints gbcDatosVehiculo;
	private GridBagConstraints gbcMedidasSeguridad;
	private GridBagConstraints gbcDeclaracionHijos;
	private GridBagConstraints gbcDatosHijo;
	private GridBagConstraints gbcHijosCargados;
	private JScrollPane scrollPane;
	private JPanel panelContenido;
	private JPanel panelDatosCliente;
	private JPanel panelDatosPoliza;
	private JLabel lblNumCliente;
	private JTextField txtNumCliente;
	private JLabel lblTipoDocumento;
	private JTextField txtTipoDocumento;
	private JLabel lblNumDocumento;
	private JTextField txtNumDocumento;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblNombre;
	private JPanel panelDomicilio;
	private JTextField txtNombre;
	private JLabel lblPais;
	private JTextField txtPais;
	private JLabel lblProvincia;
	private JTextField txtProvincia;
	private JLabel lblLocalidad;
	private JTextField txtLocalidad;
	private JLabel lblCodigoPostal;
	private JTextField txtCodigoPostal;
	private JLabel lblCalle;
	private JTextField txtCalle;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JLabel lblDpto;
	private JTextField txtDpto;
	private JLabel lblPiso;
	private JTextField txtPiso;
	private JButton btnBuscarCliente;
	private JPanel panelDomicilioRiesgo;
	private JLabel lblProvinciaRiesgo;
	private JLabel lblObligatorioProvinciaRiesgo;
	private JComboBox<String> cbProvinciaRiesgo;//Cambiar el tipo String
	private JLabel lblLocalidadRiesgo;
	private JLabel lblObligatorioLocalidadRiesgo;
	private JComboBox<String> cbLocalidadRiesgo;//Cambiar el tipo String
	private JPanel panelDatosVehiculo;
	private JLabel lblMarcaVehiculo;
	private JLabel lblObligatorioMarcaVehiculo;
	private JComboBox<String> cbMarcaVehiculo;//Cambiar el tipo String
	private JLabel lblModeloVehiculo;
	private JLabel lblObligatorioModeloVehiculo;
	private JComboBox<String> cbModeloVehiculo;//Cambiar el tipo String
	private JLabel lblAnioVehiculo;
	private JLabel lblObligatorioAnioVehiculo;
	private JComboBox<String> cbAnioVehiculo; //Cambiar el tipo String
	private JLabel lblSumaAsegurada;
	private JTextField txtSumaAsegurada;
	private JLabel lblMotor;
	private JLabel lblObligatorioMotor;
	private JTextField txtMotor;
	private JLabel lblChasis;
	private JLabel lblObligatorioChasis;
	private JTextField txtChasis;
	private JLabel lblPatente;
	private JTextField txtPatente;
	private JLabel lblKmPorAnio;
	private JLabel lblObligatorioKmPorAnio;
	private JTextField txtKmPorAnio;
	private JPanel panelMedidasSeguridad;
	private JCheckBox chbGarage;
	private JCheckBox chbAlarma;
	private JCheckBox chbRastreo;
	private JCheckBox chbTuercasAntirrobo;
	private JLabel lblNumSiniestros;
	private JLabel lblObligatorioNumSiniestros;
	private JTextField txtNumSiniestros;
	private JPanel panelDeclaracionHijos;
	private JPanel panelDatosHijo;
	private JLabel lblFechaNacimiento;
	private JDateChooser dcFechaNacimiento;
	private JLabel lblSexo;
	private JComboBox<String> cbSexo;//Cambiar el String
	private JLabel lblEstadoCivil;
	private JComboBox<String> cbEstadoCivil; //Cambiar el String
	private JButton btnAgregar;
	private JPanel panelHijosCargados;
	private JTable tablaHijos;
	private DefaultTableModel modeloTablaHijos;
	private JScrollPane scrollTablaHijos;
	private JButton btnEliminar;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	
	private Border defaultBorderTF = (new JTextField()).getBorder(); //Borde por defecto text field
	private Border defaultBorderCB = (new JComboBox<String>()).getBorder(); //Borde por defecto combo box
	private Border defaultBorderDC = (new JDateChooser().getBorder()); //Border por defecto date chooser
	
	public PolizaAlta1(JFrame ventana, JPanel panelMenu) {
		this.ventana = ventana;
		this.panelMenu = panelMenu;
		this.gbcContenido = new GridBagConstraints();
		this.gbcCliente = new GridBagConstraints();
		this.gbcDomicilio = new GridBagConstraints();
		this.gbcPoliza = new GridBagConstraints();
		this.gbcDomicilioRiesgo = new GridBagConstraints();
		this.gbcDatosVehiculo = new GridBagConstraints();
		this.gbcMedidasSeguridad = new GridBagConstraints();
		this.gbcDeclaracionHijos = new GridBagConstraints();
		this.gbcDatosHijo = new GridBagConstraints();
		this.gbcHijosCargados = new GridBagConstraints();
		this.setLayout(new BorderLayout());
		this.panelContenido = new JPanel();
		this.panelDatosCliente = new JPanel();
		this.panelDatosPoliza = new JPanel();
		this.armarPaneles();
		this.armarContenido();
	}
	
	private void armarPaneles() {
		panelContenido.setLayout(new GridBagLayout());
		
		panelDatosCliente.setLayout(new GridBagLayout());
		panelDatosCliente.setBorder(BorderFactory.createTitledBorder("Datos de Cliente"));
		gbcContenido.gridx = 0;
		gbcContenido.gridy = 0;
		gbcContenido.gridwidth = 2;
		gbcContenido.weightx = 1;
		gbcContenido.fill = GridBagConstraints.HORIZONTAL;
		gbcContenido.insets = new Insets( 10, 10, 10, 10);
		panelContenido.add(panelDatosCliente, gbcContenido);
		
		panelDatosPoliza.setLayout(new GridBagLayout());
		panelDatosPoliza.setBorder(BorderFactory.createTitledBorder("Datos de Póliza"));
		gbcContenido.gridx = 0;
		gbcContenido.gridy = 1;
		panelContenido.add(panelDatosPoliza, gbcContenido);
		
		scrollPane = new JScrollPane(panelContenido);
		this.add(scrollPane, BorderLayout.CENTER);
	}
	
	private void armarContenido() {
		lblNumCliente = new JLabel("Número Cliente");
		gbcCliente.gridx = 0;
		gbcCliente.gridy = 0;
		gbcCliente.anchor = GridBagConstraints.WEST;
		gbcCliente.insets = new Insets(10,10,10,10);
		panelDatosCliente.add(lblNumCliente, gbcCliente);
		
		txtNumCliente = new JTextField();
		txtNumCliente.setEditable(false);
		gbcCliente.gridx = 1;
		gbcCliente.gridy = 0;
		gbcCliente.weightx = 0.33;
		gbcCliente.anchor = GridBagConstraints.CENTER;
		gbcCliente.fill = GridBagConstraints.HORIZONTAL;
		panelDatosCliente.add(txtNumCliente, gbcCliente);
		
		lblTipoDocumento = new JLabel("Tipo Documento");
		gbcCliente.gridx = 2;
		gbcCliente.gridy = 0;
		gbcCliente.weightx = 0;
		gbcCliente.anchor = GridBagConstraints.WEST;
		gbcCliente.fill = GridBagConstraints.NONE;
		panelDatosCliente.add(lblTipoDocumento, gbcCliente);
		
		txtTipoDocumento = new JTextField();
		txtTipoDocumento.setEditable(false);
		gbcCliente.gridx = 3;
		gbcCliente.gridy = 0;
		gbcCliente.weightx = 0.33;
		gbcCliente.anchor = GridBagConstraints.CENTER;
		gbcCliente.fill = GridBagConstraints.HORIZONTAL;
		panelDatosCliente.add(txtTipoDocumento, gbcCliente);
		
		lblNumDocumento = new JLabel("Número Documento");
		gbcCliente.gridx = 4;
		gbcCliente.gridy = 0;
		gbcCliente.weightx = 0;
		gbcCliente.anchor = GridBagConstraints.WEST;
		gbcCliente.fill = GridBagConstraints.NONE;
		panelDatosCliente.add(lblNumDocumento, gbcCliente);
		
		txtNumDocumento = new JTextField();
		txtNumDocumento.setEditable(false);
		gbcCliente.gridx = 5;
		gbcCliente.gridy = 0;
		gbcCliente.weightx = 0.33;
		gbcCliente.anchor = GridBagConstraints.CENTER;
		gbcCliente.fill = GridBagConstraints.HORIZONTAL;
		panelDatosCliente.add(txtNumDocumento, gbcCliente);
		
		lblApellido = new JLabel("Apellido");
		gbcCliente.gridx = 0;
		gbcCliente.gridy = 1;
		gbcCliente.weightx = 0;
		gbcCliente.anchor = GridBagConstraints.WEST;
		gbcCliente.fill = GridBagConstraints.NONE;
		panelDatosCliente.add(lblApellido, gbcCliente);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		gbcCliente.gridx = 1;
		gbcCliente.gridy = 1;
		gbcCliente.weightx = 0.33;
		gbcCliente.anchor = GridBagConstraints.CENTER;
		gbcCliente.fill = GridBagConstraints.HORIZONTAL;
		panelDatosCliente.add(txtApellido, gbcCliente);
		
		lblNombre = new JLabel("Nombre");
		gbcCliente.gridx = 2;
		gbcCliente.gridy = 1;
		gbcCliente.weightx = 0;
		gbcCliente.anchor = GridBagConstraints.WEST;
		gbcCliente.fill = GridBagConstraints.NONE;
		panelDatosCliente.add(lblNombre, gbcCliente);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		gbcCliente.gridx = 3;
		gbcCliente.gridy = 1;
		gbcCliente.weightx = 0.33;
		gbcCliente.anchor = GridBagConstraints.CENTER;
		gbcCliente.fill = GridBagConstraints.HORIZONTAL;
		panelDatosCliente.add(txtNombre, gbcCliente);
		
		panelDomicilio = new JPanel();
		panelDomicilio.setLayout(new GridBagLayout());
		panelDomicilio.setBorder(BorderFactory.createTitledBorder("Domicilio"));
		gbcCliente.gridx = 0;
		gbcCliente.gridy = 2;
		gbcCliente.gridwidth = 6;
		gbcCliente.weightx = 0;
		panelDatosCliente.add(panelDomicilio, gbcCliente);
		
		lblPais = new JLabel("País");
		gbcDomicilio.gridx = 0;
		gbcDomicilio.gridy = 0;
		gbcDomicilio.anchor = GridBagConstraints.WEST;
		gbcDomicilio.insets = new Insets(10, 10, 10, 10);
		panelDomicilio.add(lblPais, gbcDomicilio);
		
		txtPais = new JTextField();
		txtPais.setEditable(false);
		gbcDomicilio.gridx = 1;
		gbcDomicilio.gridy = 0;
		gbcDomicilio.weightx = 0.25;
		gbcDomicilio.anchor = GridBagConstraints.CENTER;
		gbcDomicilio.fill = GridBagConstraints.HORIZONTAL;
		panelDomicilio.add(txtPais, gbcDomicilio);
		
		lblProvincia = new JLabel("Provincia");
		gbcDomicilio.gridx = 2;
		gbcDomicilio.gridy = 0;
		gbcDomicilio.weightx = 0;
		gbcDomicilio.anchor = GridBagConstraints.WEST;
		gbcDomicilio.fill = GridBagConstraints.NONE;
		panelDomicilio.add(lblProvincia, gbcDomicilio);
		
		txtProvincia = new JTextField();
		txtProvincia.setEditable(false);
		gbcDomicilio.gridx = 3;
		gbcDomicilio.gridy = 0;
		gbcDomicilio.weightx = 0.25;
		gbcDomicilio.anchor = GridBagConstraints.CENTER;
		gbcDomicilio.fill = GridBagConstraints.HORIZONTAL;
		panelDomicilio.add(txtProvincia, gbcDomicilio);
		
		lblLocalidad = new JLabel("Localidad");
		gbcDomicilio.gridx = 4;
		gbcDomicilio.gridy = 0;
		gbcDomicilio.weightx = 0;
		gbcDomicilio.anchor = GridBagConstraints.WEST;
		gbcDomicilio.fill = GridBagConstraints.NONE;
		panelDomicilio.add(lblLocalidad, gbcDomicilio);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setEditable(false);
		gbcDomicilio.gridx = 5;
		gbcDomicilio.gridy = 0;
		gbcDomicilio.weightx = 0.25;
		gbcDomicilio.anchor = GridBagConstraints.CENTER;
		gbcDomicilio.fill = GridBagConstraints.HORIZONTAL;
		panelDomicilio.add(txtLocalidad, gbcDomicilio);
		
		lblCodigoPostal = new JLabel("Código Postal");
		gbcDomicilio.gridx = 6;
		gbcDomicilio.gridy = 0;
		gbcDomicilio.weightx = 0;
		gbcDomicilio.anchor = GridBagConstraints.WEST;
		gbcDomicilio.fill = GridBagConstraints.NONE;
		panelDomicilio.add(lblCodigoPostal, gbcDomicilio);
		
		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setEditable(false);
		gbcDomicilio.gridx = 7;
		gbcDomicilio.gridy = 0;
		gbcDomicilio.weightx = 0.25;
		gbcDomicilio.anchor = GridBagConstraints.CENTER;
		gbcDomicilio.fill = GridBagConstraints.HORIZONTAL;
		panelDomicilio.add(txtCodigoPostal, gbcDomicilio);
		
		lblCalle = new JLabel("Calle");
		gbcDomicilio.gridx = 0;
		gbcDomicilio.gridy = 1;
		gbcDomicilio.weightx = 0;
		gbcDomicilio.anchor = GridBagConstraints.WEST;
		gbcDomicilio.fill = GridBagConstraints.NONE;
		panelDomicilio.add(lblCalle, gbcDomicilio);
		
		txtCalle = new JTextField();
		txtCalle.setEditable(false);
		gbcDomicilio.gridx = 1;
		gbcDomicilio.gridy = 1;
		gbcDomicilio.weightx = 0.25;
		gbcDomicilio.anchor = GridBagConstraints.CENTER;
		gbcDomicilio.fill = GridBagConstraints.HORIZONTAL;
		panelDomicilio.add(txtCalle, gbcDomicilio);
		
		lblNumero = new JLabel("Número");
		gbcDomicilio.gridx = 2;
		gbcDomicilio.gridy = 1;
		gbcDomicilio.weightx = 0;
		gbcDomicilio.anchor = GridBagConstraints.WEST;
		gbcDomicilio.fill = GridBagConstraints.NONE;
		panelDomicilio.add(lblNumero, gbcDomicilio);
		
		txtNumero = new JTextField();
		txtNumero.setEditable(false);
		gbcDomicilio.gridx = 3;
		gbcDomicilio.gridy = 1;
		gbcDomicilio.weightx = 0.25;
		gbcDomicilio.anchor = GridBagConstraints.CENTER;
		gbcDomicilio.fill = GridBagConstraints.HORIZONTAL;
		panelDomicilio.add(txtNumero, gbcDomicilio);
		
		lblDpto = new JLabel("Dpto");
		gbcDomicilio.gridx = 4;
		gbcDomicilio.gridy = 1;
		gbcDomicilio.weightx = 0;
		gbcDomicilio.anchor = GridBagConstraints.WEST;
		gbcDomicilio.fill = GridBagConstraints.NONE;
		panelDomicilio.add(lblDpto, gbcDomicilio);
		
		txtDpto = new JTextField();
		txtDpto.setEditable(false);
		gbcDomicilio.gridx = 5;
		gbcDomicilio.gridy = 1;
		gbcDomicilio.weightx = 0.25;
		gbcDomicilio.anchor = GridBagConstraints.CENTER;
		gbcDomicilio.fill = GridBagConstraints.HORIZONTAL;
		panelDomicilio.add(txtDpto, gbcDomicilio);
		
		lblPiso = new JLabel("Piso");
		gbcDomicilio.gridx = 6;
		gbcDomicilio.gridy = 1;
		gbcDomicilio.weightx = 0;
		gbcDomicilio.anchor = GridBagConstraints.WEST;
		gbcDomicilio.fill = GridBagConstraints.NONE;
		panelDomicilio.add(lblPiso, gbcDomicilio);
		
		txtPiso = new JTextField();
		txtPiso.setEditable(false);
		gbcDomicilio.gridx = 7;
		gbcDomicilio.gridy = 1;
		gbcDomicilio.weightx = 0.25;
		gbcDomicilio.anchor = GridBagConstraints.CENTER;
		gbcDomicilio.fill = GridBagConstraints.HORIZONTAL;
		panelDomicilio.add(txtPiso, gbcDomicilio);
		
		btnBuscarCliente = new JButton("Buscar Cliente");
		gbcCliente.gridx = 5;
		gbcCliente.gridy = 3;
		gbcCliente.gridwidth = 1;
		gbcCliente.weightx = 0;
		gbcCliente.anchor = GridBagConstraints.EAST;
		gbcCliente.fill = GridBagConstraints.NONE;
		panelDatosCliente.add(btnBuscarCliente, gbcCliente);
		btnBuscarCliente.addActionListener(e -> {
			ventana.setTitle("Cliente - Consulta");
			ventana.setContentPane(new ClienteConsulta(ventana, this));
			ventana.setVisible(true);
		});
		
		panelDomicilioRiesgo = new JPanel();
		panelDomicilioRiesgo.setLayout(new GridBagLayout());
		panelDomicilioRiesgo.setBorder(BorderFactory.createTitledBorder("Domicilio del Riesgo"));
		gbcPoliza.gridx = 0;
		gbcPoliza.gridy = 0;
		gbcPoliza.gridwidth = 3;
		gbcPoliza.weightx = 1;
		gbcPoliza.fill = GridBagConstraints.HORIZONTAL;
		gbcPoliza.insets = new Insets(10, 10, 10, 10);
		panelDatosPoliza.add(panelDomicilioRiesgo, gbcPoliza);
		
		lblProvinciaRiesgo = new JLabel("Provincia");
		gbcDomicilioRiesgo.gridx = 0;
		gbcDomicilioRiesgo.gridy = 0;
		gbcDomicilioRiesgo.anchor = GridBagConstraints.WEST;
		gbcDomicilioRiesgo.insets = new Insets(10,10,10,0);
		panelDomicilioRiesgo.add(lblProvinciaRiesgo, gbcDomicilioRiesgo);
		
		lblObligatorioProvinciaRiesgo = new JLabel("(*)");
		lblObligatorioProvinciaRiesgo.setForeground(Color.RED);
		gbcDomicilioRiesgo.gridx = 1;
		gbcDomicilioRiesgo.gridy = 0;
		gbcDomicilioRiesgo.insets = new Insets(10, 0, 10, 10);
		panelDomicilioRiesgo.add(lblObligatorioProvinciaRiesgo, gbcDomicilioRiesgo);
		
		cbProvinciaRiesgo = new JComboBox<>();
		gbcDomicilioRiesgo.gridx = 2;
		gbcDomicilioRiesgo.gridy = 0;
		gbcDomicilioRiesgo.weightx = 0.5;
		gbcDomicilioRiesgo.anchor = GridBagConstraints.CENTER;
		gbcDomicilioRiesgo.fill = GridBagConstraints.HORIZONTAL;
		gbcDomicilioRiesgo.insets = new Insets(10, 10, 10, 10);
		panelDomicilioRiesgo.add(cbProvinciaRiesgo, gbcDomicilioRiesgo);
		//TODO: Cuando se selecciona una provincia debe habilitar cbLocalidadRiesgo
		
		lblLocalidadRiesgo = new JLabel("Localidad");
		gbcDomicilioRiesgo.gridx = 3;
		gbcDomicilioRiesgo.gridy = 0;
		gbcDomicilioRiesgo.weightx = 0;
		gbcDomicilioRiesgo.anchor = GridBagConstraints.WEST;
		gbcDomicilioRiesgo.fill = GridBagConstraints.NONE;
		gbcDomicilioRiesgo.insets = new Insets(10, 10, 10, 0);
		panelDomicilioRiesgo.add(lblLocalidadRiesgo, gbcDomicilioRiesgo);
		
		lblObligatorioLocalidadRiesgo = new JLabel("(*)");
		lblObligatorioLocalidadRiesgo.setForeground(Color.RED);
		gbcDomicilioRiesgo.gridx = 4;
		gbcDomicilioRiesgo.gridy = 0;
		gbcDomicilioRiesgo.insets = new Insets(10, 0, 10, 10);
		panelDomicilioRiesgo.add(lblObligatorioLocalidadRiesgo, gbcDomicilioRiesgo);
		
		cbLocalidadRiesgo = new JComboBox<>();
		cbLocalidadRiesgo.setEnabled(false);
		gbcDomicilioRiesgo.gridx = 5;
		gbcDomicilioRiesgo.gridy = 0;
		gbcDomicilioRiesgo.weightx = 0.5;
		gbcDomicilioRiesgo.anchor = GridBagConstraints.CENTER;
		gbcDomicilioRiesgo.fill = GridBagConstraints.HORIZONTAL;
		gbcDomicilioRiesgo.insets = new Insets(10, 10, 10, 10);
		panelDomicilioRiesgo.add(cbLocalidadRiesgo, gbcDomicilioRiesgo);
		
		panelDatosVehiculo = new JPanel();
		panelDatosVehiculo.setLayout(new GridBagLayout());
		panelDatosVehiculo.setBorder(BorderFactory.createTitledBorder("Datos del Vehículo"));
		gbcPoliza.gridx = 0;
		gbcPoliza.gridy = 1;
		panelDatosPoliza.add(panelDatosVehiculo, gbcPoliza);
		
		lblMarcaVehiculo = new JLabel("Marca del Vehículo");
		gbcDatosVehiculo.gridx = 0;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.anchor = GridBagConstraints.WEST;
		gbcDatosVehiculo.insets = new Insets(10,10,10,0);
		panelDatosVehiculo.add(lblMarcaVehiculo, gbcDatosVehiculo);
		
		lblObligatorioMarcaVehiculo = new JLabel("(*)");
		lblObligatorioMarcaVehiculo.setForeground(Color.RED);
		gbcDatosVehiculo.gridx = 1;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.insets = new Insets(10, 0, 10, 10);
		panelDatosVehiculo.add(lblObligatorioMarcaVehiculo, gbcDatosVehiculo);
		
		cbMarcaVehiculo = new JComboBox<>();
		gbcDatosVehiculo.gridx = 2;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.weightx = 0.33;
		gbcDatosVehiculo.anchor = GridBagConstraints.CENTER;
		gbcDatosVehiculo.fill = GridBagConstraints.HORIZONTAL;
		gbcDatosVehiculo.insets = new Insets(10, 10, 10, 10);
		panelDatosVehiculo.add(cbMarcaVehiculo, gbcDatosVehiculo);
		
		lblModeloVehiculo = new JLabel("Modelo del Vehículo");
		gbcDatosVehiculo.gridx = 3;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.weightx = 0;
		gbcDatosVehiculo.anchor = GridBagConstraints.WEST;
		gbcDatosVehiculo.fill = GridBagConstraints.NONE;
		gbcDatosVehiculo.insets = new Insets(10, 10, 10, 0);
		panelDatosVehiculo.add(lblModeloVehiculo, gbcDatosVehiculo);
		
		lblObligatorioModeloVehiculo = new JLabel("(*)");
		lblObligatorioModeloVehiculo.setForeground(Color.RED);
		gbcDatosVehiculo.gridx = 4;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.insets = new Insets(10, 0, 10, 10);
		panelDatosVehiculo.add(lblObligatorioModeloVehiculo, gbcDatosVehiculo);
		
		cbModeloVehiculo = new JComboBox<>();
		gbcDatosVehiculo.gridx = 5;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.weightx = 0.33;
		gbcDatosVehiculo.anchor = GridBagConstraints.CENTER;
		gbcDatosVehiculo.fill = GridBagConstraints.HORIZONTAL;
		gbcDatosVehiculo.insets = new Insets(10, 10, 10, 10);
		panelDatosVehiculo.add(cbModeloVehiculo, gbcDatosVehiculo);
		
		lblAnioVehiculo = new JLabel("Año del Vehículo");
		gbcDatosVehiculo.gridx = 6;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.weightx = 0;
		gbcDatosVehiculo.anchor = GridBagConstraints.WEST;
		gbcDatosVehiculo.fill = GridBagConstraints.NONE;
		gbcDatosVehiculo.insets = new Insets(10, 10, 10, 0);
		panelDatosVehiculo.add(lblAnioVehiculo, gbcDatosVehiculo);
		
		lblObligatorioAnioVehiculo = new JLabel("(*)");
		lblObligatorioAnioVehiculo.setForeground(Color.RED);
		gbcDatosVehiculo.gridx = 7;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.insets = new Insets(10, 0, 10, 10);
		panelDatosVehiculo.add(lblObligatorioAnioVehiculo, gbcDatosVehiculo);
		
		cbAnioVehiculo = new JComboBox<>();
		gbcDatosVehiculo.gridx = 8;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.weightx = 0.33;
		gbcDatosVehiculo.anchor = GridBagConstraints.CENTER;
		gbcDatosVehiculo.fill = GridBagConstraints.HORIZONTAL;
		gbcDatosVehiculo.insets = new Insets(10, 10, 10, 10);
		panelDatosVehiculo.add(cbAnioVehiculo, gbcDatosVehiculo);
		
		lblSumaAsegurada = new JLabel("SumaAsegurada");
		gbcDatosVehiculo.gridx = 0;
		gbcDatosVehiculo.gridy = 1;
		gbcDatosVehiculo.weightx = 0;
		gbcDatosVehiculo.anchor = GridBagConstraints.WEST;
		gbcDatosVehiculo.fill = GridBagConstraints.NONE;
		panelDatosVehiculo.add(lblSumaAsegurada, gbcDatosVehiculo);
		
		txtSumaAsegurada = new JTextField();
		txtSumaAsegurada.setEditable(false);
		txtSumaAsegurada.setText("$");
		gbcDatosVehiculo.gridx = 2;
		gbcDatosVehiculo.gridy = 1;
		gbcDatosVehiculo.weightx = 0.33;
		gbcDatosVehiculo.anchor = GridBagConstraints.CENTER;
		gbcDatosVehiculo.fill = GridBagConstraints.HORIZONTAL;
		panelDatosVehiculo.add(txtSumaAsegurada, gbcDatosVehiculo);
		
		lblMotor = new JLabel("Motor");
		gbcDatosVehiculo.gridx = 3;
		gbcDatosVehiculo.gridy = 1;
		gbcDatosVehiculo.weightx = 0;
		gbcDatosVehiculo.anchor = GridBagConstraints.WEST;
		gbcDatosVehiculo.fill = GridBagConstraints.NONE;
		gbcDatosVehiculo.insets = new Insets(10, 10, 10, 0);
		panelDatosVehiculo.add(lblMotor, gbcDatosVehiculo);
		
		lblObligatorioMotor = new JLabel("(*)");
		lblObligatorioMotor.setForeground(Color.RED);
		gbcDatosVehiculo.gridx = 4;
		gbcDatosVehiculo.gridy = 1;
		gbcDatosVehiculo.insets = new Insets(10, 0, 10, 10);
		panelDatosVehiculo.add(lblObligatorioMotor, gbcDatosVehiculo);
		
		txtMotor = new JTextField();
		// Limitar la cantidad de caracteres usando un DocumentFilter
		txtMotor.setDocument(new DocumentFilterLimit(20));
		gbcDatosVehiculo.gridx = 5;
		gbcDatosVehiculo.gridy = 1;
		gbcDatosVehiculo.weightx = 0.33;
		gbcDatosVehiculo.anchor = GridBagConstraints.CENTER;
		gbcDatosVehiculo.fill = GridBagConstraints.HORIZONTAL;
		gbcDatosVehiculo.insets = new Insets(10, 10, 10, 10);
		panelDatosVehiculo.add(txtMotor, gbcDatosVehiculo);
		
		lblChasis = new JLabel("Chasis");
		gbcDatosVehiculo.gridx = 6;
		gbcDatosVehiculo.gridy = 1;
		gbcDatosVehiculo.weightx = 0;
		gbcDatosVehiculo.anchor = GridBagConstraints.WEST;
		gbcDatosVehiculo.fill = GridBagConstraints.NONE;
		gbcDatosVehiculo.insets = new Insets(10, 10, 10, 0);
		panelDatosVehiculo.add(lblChasis, gbcDatosVehiculo);
		
		lblObligatorioChasis = new JLabel("(*)");
		lblObligatorioChasis.setForeground(Color.RED);
		gbcDatosVehiculo.gridx = 7;
		gbcDatosVehiculo.gridy = 1;
		gbcDatosVehiculo.insets = new Insets(10, 0, 10, 10);
		panelDatosVehiculo.add(lblObligatorioChasis, gbcDatosVehiculo);
		
		txtChasis = new JTextField();
		// Limitar la cantidad de caracteres usando un DocumentFilter
		txtChasis.setDocument(new DocumentFilterLimit(50));
		gbcDatosVehiculo.gridx = 8;
		gbcDatosVehiculo.gridy = 1;
		gbcDatosVehiculo.weightx = 0.33;
		gbcDatosVehiculo.anchor = GridBagConstraints.CENTER;
		gbcDatosVehiculo.fill = GridBagConstraints.HORIZONTAL;
		gbcDatosVehiculo.insets = new Insets(10, 10, 10, 10);
		panelDatosVehiculo.add(txtChasis, gbcDatosVehiculo);
		
		lblPatente = new JLabel("Patente del Vehículo");
		gbcDatosVehiculo.gridx = 0;
		gbcDatosVehiculo.gridy = 2;
		gbcDatosVehiculo.weightx = 0;
		gbcDatosVehiculo.anchor = GridBagConstraints.WEST;
		gbcDatosVehiculo.fill = GridBagConstraints.NONE;
		panelDatosVehiculo.add(lblPatente, gbcDatosVehiculo);
		
		txtPatente = new JTextField();
		// Limitar la cantidad de caracteres usando un DocumentFilter
		txtPatente.setDocument(new DocumentFilterLimit(20));
		gbcDatosVehiculo.gridx = 2;
		gbcDatosVehiculo.gridy = 2;
		gbcDatosVehiculo.weightx = 0.33;
		gbcDatosVehiculo.anchor = GridBagConstraints.CENTER;
		gbcDatosVehiculo.fill = GridBagConstraints.HORIZONTAL;
		panelDatosVehiculo.add(txtPatente, gbcDatosVehiculo);
		
		lblKmPorAnio = new JLabel("Kilómetros por año");
		gbcDatosVehiculo.gridx = 3;
		gbcDatosVehiculo.gridy = 2;
		gbcDatosVehiculo.weightx = 0;
		gbcDatosVehiculo.anchor = GridBagConstraints.WEST;
		gbcDatosVehiculo.fill = GridBagConstraints.NONE;
		gbcDatosVehiculo.insets = new Insets(10, 10, 10, 0);
		panelDatosVehiculo.add(lblKmPorAnio, gbcDatosVehiculo);
		
		lblObligatorioKmPorAnio = new JLabel("(*)");
		lblObligatorioKmPorAnio.setForeground(Color.RED);
		gbcDatosVehiculo.gridx = 4;
		gbcDatosVehiculo.gridy = 2;
		gbcDatosVehiculo.insets = new Insets(10, 0, 10, 10);
		panelDatosVehiculo.add(lblObligatorioKmPorAnio, gbcDatosVehiculo);
		
		txtKmPorAnio = new JTextField();
		// Limitar la cantidad de caracteres usando un DocumentFilter
		txtKmPorAnio.setDocument(new DocumentFilterLimit(9));
		gbcDatosVehiculo.gridx = 5;
		gbcDatosVehiculo.gridy = 2;
		gbcDatosVehiculo.weightx = 0.33;
		gbcDatosVehiculo.anchor = GridBagConstraints.CENTER;
		gbcDatosVehiculo.fill = GridBagConstraints.HORIZONTAL;
		gbcDatosVehiculo.insets = new Insets(10, 10, 10, 10);
		panelDatosVehiculo.add(txtKmPorAnio, gbcDatosVehiculo);
		
		panelMedidasSeguridad = new JPanel();
		panelMedidasSeguridad.setLayout(new GridBagLayout());
		panelMedidasSeguridad.setBorder(BorderFactory.createTitledBorder("Medidas de Seguridad"));
		gbcPoliza.gridx = 0;
		gbcPoliza.gridy = 2;
		panelDatosPoliza.add(panelMedidasSeguridad, gbcPoliza);
		
		chbGarage = new JCheckBox("¿Se guarda en garage?");
		gbcMedidasSeguridad.gridx = 0;
		gbcMedidasSeguridad.gridy = 0;
		gbcMedidasSeguridad.insets = new Insets(10, 10, 10, 10);
		panelMedidasSeguridad.add(chbGarage, gbcMedidasSeguridad);
		
		chbAlarma = new JCheckBox("¿Tiene alarma?");
		gbcMedidasSeguridad.gridx = 1;
		gbcMedidasSeguridad.gridy = 0;
		panelMedidasSeguridad.add(chbAlarma, gbcMedidasSeguridad);
		
		chbRastreo = new JCheckBox("¿Posee dispositivo de rastreo vehicular");
		gbcMedidasSeguridad.gridx = 2;
		gbcMedidasSeguridad.gridy = 0;
		panelMedidasSeguridad.add(chbRastreo, gbcMedidasSeguridad);
		
		chbTuercasAntirrobo = new JCheckBox("¿Posee tuercas antirrobo en las cuatro ruedas?");
		gbcMedidasSeguridad.gridx = 3;
		gbcMedidasSeguridad.gridy = 0;
		panelMedidasSeguridad.add(chbTuercasAntirrobo, gbcMedidasSeguridad);
		
		lblNumSiniestros = new JLabel("Número de Siniestros en el último año");
		gbcPoliza.gridx = 0;
		gbcPoliza.gridy = 3;
		gbcPoliza.gridwidth = 1;
		gbcPoliza.weightx = 0;
		gbcPoliza.anchor = GridBagConstraints.WEST;
		gbcPoliza.fill = GridBagConstraints.NONE;
		gbcPoliza.insets = new Insets(10, 10, 10, 0);
		panelDatosPoliza.add(lblNumSiniestros, gbcPoliza);
		
		lblObligatorioNumSiniestros = new JLabel("(*)");
		lblObligatorioNumSiniestros.setForeground(Color.RED);
		gbcPoliza.gridx = 1;
		gbcPoliza.gridy = 3;
		gbcPoliza.insets = new Insets(10, 0, 10, 10);
		panelDatosPoliza.add(lblObligatorioNumSiniestros, gbcPoliza);
		
		txtNumSiniestros = new JTextField();
		txtNumSiniestros.setEditable(false);
		txtNumSiniestros.setColumns(20);
		gbcPoliza.gridx = 2;
		gbcPoliza.gridy = 3;
		gbcPoliza.insets = new Insets(10, 10, 10, 10);
		panelDatosPoliza.add(txtNumSiniestros, gbcPoliza);
		
		panelDeclaracionHijos = new JPanel();
		panelDeclaracionHijos.setLayout(new GridBagLayout());
		panelDeclaracionHijos.setBorder(BorderFactory.createTitledBorder("Declaración de Hijos entre 18 y 30 años"));
		gbcPoliza.gridx = 0;
		gbcPoliza.gridy = 4;
		gbcPoliza.gridwidth = 3;
		gbcPoliza.fill = GridBagConstraints.HORIZONTAL;
		panelDatosPoliza.add(panelDeclaracionHijos, gbcPoliza);
		
		panelDatosHijo = new JPanel();
		panelDatosHijo.setLayout(new GridBagLayout());
		panelDatosHijo.setBorder(BorderFactory.createTitledBorder("Datos Hijo"));
		gbcDeclaracionHijos.gridx = 0;
		gbcDeclaracionHijos.gridy = 0;
		gbcDeclaracionHijos.weightx = 0.3;
		gbcDeclaracionHijos.weighty = 1;
		gbcDeclaracionHijos.fill = GridBagConstraints.BOTH;
		panelDeclaracionHijos.add(panelDatosHijo, gbcDeclaracionHijos);
		
		lblFechaNacimiento = new JLabel("Fecha de nacimiento");
		gbcDatosHijo.gridx = 0;
		gbcDatosHijo.gridy = 0;
		gbcDatosHijo.anchor = GridBagConstraints.WEST;
		gbcDatosHijo.insets = new Insets(10, 10, 10, 10);
		panelDatosHijo.add(lblFechaNacimiento, gbcDatosHijo);
		
		dcFechaNacimiento = new JDateChooser("dd/MM/yyyy", "##/##/####", '-');
		gbcDatosHijo.gridx = 1;
		gbcDatosHijo.gridy = 0;
		gbcDatosHijo.weightx = 1;
		gbcDatosHijo.anchor = GridBagConstraints.CENTER;
		gbcDatosHijo.fill = GridBagConstraints.HORIZONTAL;
		panelDatosHijo.add(dcFechaNacimiento, gbcDatosHijo);
		
		lblSexo = new JLabel("Sexo");
		gbcDatosHijo.gridx = 0;
		gbcDatosHijo.gridy = 1;
		gbcDatosHijo.weightx = 0;
		gbcDatosHijo.anchor = GridBagConstraints.WEST;
		gbcDatosHijo.fill = GridBagConstraints.NONE;
		panelDatosHijo.add(lblSexo, gbcDatosHijo);
		
		cbSexo = new JComboBox<>();
		gbcDatosHijo.gridx = 1;
		gbcDatosHijo.gridy = 1;
		gbcDatosHijo.weightx = 1;
		gbcDatosHijo.anchor = GridBagConstraints.CENTER;
		gbcDatosHijo.fill = GridBagConstraints.HORIZONTAL;
		panelDatosHijo.add(cbSexo, gbcDatosHijo);
		
		lblEstadoCivil = new JLabel("Estado Civil");
		gbcDatosHijo.gridx = 0;
		gbcDatosHijo.gridy = 2;
		gbcDatosHijo.weightx = 0;
		gbcDatosHijo.anchor = GridBagConstraints.WEST;
		gbcDatosHijo.fill = GridBagConstraints.NONE;
		panelDatosHijo.add(lblEstadoCivil, gbcDatosHijo);
		
		cbEstadoCivil = new JComboBox<>();
		gbcDatosHijo.gridx = 1;
		gbcDatosHijo.gridy = 2;
		gbcDatosHijo.weightx = 1;
		gbcDatosHijo.anchor = GridBagConstraints.CENTER;
		gbcDatosHijo.fill = GridBagConstraints.HORIZONTAL;
		panelDatosHijo.add(cbEstadoCivil, gbcDatosHijo);
		
		btnAgregar = new JButton("Agregar");
		gbcDatosHijo.gridx = 1;
		gbcDatosHijo.gridy = 3;
		gbcDatosHijo.anchor = GridBagConstraints.EAST;
		gbcDatosHijo.fill = GridBagConstraints.NONE;
		panelDatosHijo.add(btnAgregar, gbcDatosHijo);
		btnAgregar.addActionListener(e -> {
			dcFechaNacimiento.setBorder(defaultBorderDC);
        	cbSexo.setBorder(defaultBorderCB);
        	cbEstadoCivil.setBorder(defaultBorderCB);
			if(dcFechaNacimiento.getDate() == null) {//TODO: Falta agregar en el if sobre los combo box que no sean seleccionar
				mensajeDatosObligatoriosHijoDeclarado();
				Border redBorder = BorderFactory.createLineBorder(Color.RED);
        		if(dcFechaNacimiento.getDate() == null) dcFechaNacimiento.setBorder(redBorder);
        		//TODO: Falta lo de los combos box
			}else {
				long anios = Duration.between(dcFechaNacimiento.getDate().toInstant(), Instant.now()).toDays()/365;
				if(anios < 18 || anios > 30) {
					mensajeHijoDeclaradoNoEstaEnRango();
				}	
			}
		});
		
		panelHijosCargados = new JPanel();
		panelHijosCargados.setLayout(new GridBagLayout());
		panelHijosCargados.setBorder(BorderFactory.createTitledBorder("Hijos Cargados"));
		gbcDeclaracionHijos.gridx = 1;
		gbcDeclaracionHijos.gridy = 0;
		gbcDeclaracionHijos.weightx = 0.7;
		panelDeclaracionHijos.add(panelHijosCargados, gbcDeclaracionHijos);
		
		modeloTablaHijos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Para que las celdas no sean editables
                return false;
            }
        };
		modeloTablaHijos.addColumn("Fecha de nacimiento");
		modeloTablaHijos.addColumn("Sexo");
		modeloTablaHijos.addColumn("Estado Civil");
		for (int i = 0; i < 10; i++) {
			modeloTablaHijos.addRow(new Object[] { "" });
		}
		
		tablaHijos = new JTable(modeloTablaHijos);
		tablaHijos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaHijos.setAutoCreateRowSorter(true);//Habilitar ordenamiento por columna
        tablaHijos.getTableHeader().setReorderingAllowed(false); // No permitir reordenar columnas
        int rowHeight = tablaHijos.getRowHeight();
        int numRowsToShow = 5; //El tamaño de la tabla es de 5 filas, si tiene más se desplaza con la barra
        tablaHijos.setPreferredScrollableViewportSize(new Dimension(tablaHijos.getPreferredSize().width, rowHeight * numRowsToShow));
              
        scrollTablaHijos = new JScrollPane(tablaHijos);
        gbcHijosCargados.gridx = 0;
        gbcHijosCargados.gridy = 0;
        gbcHijosCargados.weightx = 1;
        gbcHijosCargados.fill = GridBagConstraints.HORIZONTAL;
        gbcHijosCargados.insets = new Insets(10, 10, 10, 10);
        panelHijosCargados.add(scrollTablaHijos, gbcHijosCargados);
        
        btnEliminar = new JButton("Eliminar");
        gbcHijosCargados.gridx = 0;
        gbcHijosCargados.gridy = 1;
        gbcHijosCargados.anchor = GridBagConstraints.EAST;
        gbcHijosCargados.fill = GridBagConstraints.NONE;
        panelHijosCargados.add(btnEliminar, gbcHijosCargados);
        btnEliminar.addActionListener(e -> {
        	if(tablaHijos.getSelectedRow() != -1 && tablaHijos.getValueAt(tablaHijos.getSelectedRow(), 0) != "") {
        		modeloTablaHijos.removeRow(tablaHijos.getSelectedRow());
        	}else if(tablaHijos.getSelectedRow() == -1){
        		mensajeDebeSeleccionarFila();
        	}
        });
        
        btnConfirmar = new JButton("Confirmar");
        gbcContenido.gridx = 0;
        gbcContenido.gridy = 2;
        gbcContenido.gridwidth = 1;
        gbcContenido.anchor = GridBagConstraints.EAST;
        gbcContenido.fill = GridBagConstraints.NONE;
        panelContenido.add(btnConfirmar, gbcContenido);
        btnConfirmar.addActionListener(e -> {
        	txtMotor.setBorder(defaultBorderTF);
        	txtChasis.setBorder(defaultBorderTF);
        	txtKmPorAnio.setBorder(defaultBorderTF);
        	cbProvinciaRiesgo.setBorder(defaultBorderCB);
        	cbLocalidadRiesgo.setBorder(defaultBorderCB);
        	cbMarcaVehiculo.setBorder(defaultBorderCB);
        	cbModeloVehiculo.setBorder(defaultBorderCB);
        	cbAnioVehiculo.setBorder(defaultBorderCB);
        	if(noEstanTodosDatosObligatorios()) {
        		mensajeDatosObligatorios();
        		Border redBorder = BorderFactory.createLineBorder(Color.RED);
        		if(txtMotor.getText().isBlank()) txtMotor.setBorder(redBorder);
        		if(txtChasis.getText().isBlank()) txtChasis.setBorder(redBorder);
        		if(txtKmPorAnio.getText().isBlank()) txtKmPorAnio.setBorder(redBorder);
        		//TODO: Falta lo de los combos box poner en rojo
        	}/**
        	TODO: Falta un if para ver si ya existe una póliza vigente para algunos de los 
        		siguientes valores: patente (si es distinto a nulo), motor y chasis. 
        	*/
        	else {
        		ventana.setTitle("Póliza - Alta - 2");
            	ventana.setContentPane(new PolizaAlta2(ventana,panelMenu, this));
            	ventana.setVisible(true);
        	}
        });
        
        btnCancelar = new JButton("Cancelar");
        gbcContenido.gridx = 1;
        gbcContenido.gridy = 2;
        gbcContenido.weightx = 0;
        gbcContenido.anchor = GridBagConstraints.CENTER;
        panelContenido.add(btnCancelar, gbcContenido);
        btnCancelar.addActionListener(e -> {
        	String mensaje = "¿Deseas cancelar el alta de póliza?";
			int confirmado = JOptionPane.showOptionDialog(this, mensaje, "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, new Object[] { "SI", "NO" }, "SI");
			if (confirmado == 0) {
				ventana.setTitle("Menú - Productor de seguro");
				ventana.setContentPane(panelMenu);
				ventana.setVisible(true);
			}
        });
	}
	
	private boolean noEstanTodosDatosObligatorios() {
		//TODO: Falta ver si los combos box son distintos de seleccionar
		return (txtMotor.getText().isBlank() || txtChasis.getText().isBlank() || txtKmPorAnio.getText().isBlank());
	}
	
	private void mensajeDatosObligatorios() {
		String mensaje = "Los siguientes campos son obligatorios: 'Provincia','Localidad','Marca del Vehículo','Modelo del Vehículo','Año del Vehículo','Motor','Chasis','Kilómetros por año'";
		JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	private void mensajeDatosObligatoriosHijoDeclarado() {
		String mensaje = "Los siguientes campos son obligatorios: 'Fecha de nacimiento','Sexo','Estado civil'";
		JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	private void mensajeHijoDeclaradoNoEstaEnRango() {
		String mensaje = "La edad del hijo declarado debe ser entre 18 y 30 años";
		JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	private void mensajeDebeSeleccionarFila() {
		String mensaje = "Debe seleccionar una fila para eliminar";
		JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	private void mensajeExistePolizaVigente() {
		String mensaje = "Ya existe una póliza vigente asociado a los siguiente valores:\n"
				+ "	Patente: " + txtPatente.getText() + "\n"
				+ "	Motor: " + txtMotor.getText() + "\n"
				+ "	Chasis: " + txtChasis.getText();
		JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
}