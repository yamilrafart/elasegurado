package ui.poliza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class PolizaAlta2 extends JPanel {
	private JFrame ventana;
	private JPanel panelMenu;
	private JPanel panelPoliza1;
	private GridBagConstraints gbcContenido;
	private GridBagConstraints gbcCobertura;
	private GridBagConstraints gbcCoberturaBotones;
	private GridBagConstraints gbcCalculos;
	private GridBagConstraints gbcPolizaGenerar;
	private GridBagConstraints gbcTitularSeguro;
	private GridBagConstraints gbcDatosVehiculo;
	private GridBagConstraints gbcVigencia;
	private GridBagConstraints gbcSumaAseguradaYPremio;
	private GridBagConstraints gbcDescuentos;
	private GridBagConstraints gbcDiaPago;
	private GridBagConstraints gbcMontoAbonar;
	private JScrollPane scrollPane;
	private JPanel panelContenido;
	private JPanel panelCobertura;
	private JPanel panelCoberturaBotones;
	private JPanel panelCalculos;
	private JPanel panelPolizaGenerar;
	private JLabel lblTipoCobertura;
	private JLabel lblObligatorioTipoCobertura;
	private JComboBox<String> cbTipoCobertura; //Cambiar tipo String
	private JLabel lblFechaInicio;
	private JLabel lblObligatorioFechaInicio;
	private JDateChooser dcFechaInicio;
	private JLabel lblFormaPago;
	private JLabel lblObligatorioFormaPago;
	private JComboBox<String> cbFormaPago; //Cambiar tipo String
	private JButton btnConfirmar;
	private JButton btnLimpiar;
	private JLabel lblPremioCalculo;
	private JTextField txtPremioCalculo;
	private JLabel lblDerechosEmision;
	private JTextField txtDerechosEmision;
	private JLabel lblDescuento;
	private JTextField txtDescuento;
	private JPanel panelTitularSeguro;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JPanel panelDatosVehiculo;
	private JLabel lblMarcaVehiculo;
	private JTextField txtMarcaVehiculo;
	private JLabel lblModeloVehiculo;
	private JTextField txtModeloVehiculo;
	private JLabel lblMotor;
	private JTextField txtMotor;
	private JLabel lblPatente;
	private JTextField txtPatente;
	private JLabel lblChasis;
	private JTextField txtChasis;
	private JPanel panelVigencia;
	private JLabel lblFechaInicioVigencia;
	private JTextField txtFechaInicioVigencia;
	private JLabel lblFechaFinVigencia;
	private JTextField txtFechaFinVigencia;
	private JPanel panelSumaAseguradaYPremio;
	private JLabel lblSumaAsegurada;
	private JTextField txtSumaAsegurada;
	private JLabel lblPremio;
	private JTextField txtPremio;
	private JPanel panelDescuentos;
	private JTable tablaDescuentos;
	private DefaultTableModel modeloTablaDescuentos;
	private JScrollPane scrollTablaDescuentos;
	private JPanel panelDiaPago;
	private JTable tablaDiaPago;
	private DefaultTableModel modeloTablaDiaPago;
	private JScrollPane scrollTablaDiaPago;
	private JPanel panelMontoAbonar;
	private JLabel lblMontoAbonar;
	private JTextField txtMontoAbonar;
	private JButton btnGenerar;
	private JButton btnAtras;
	private JButton btnCancelar;
	
	private Border defaultBorderCB = (new JComboBox<String>()).getBorder(); //Borde por defecto combo box
	
	public PolizaAlta2(JFrame ventana, JPanel panelMenu, JPanel panelPoliza1) {
		this.ventana = ventana;
		this.panelMenu = panelMenu;
		this.panelPoliza1 = panelPoliza1;
		this.gbcContenido = new GridBagConstraints();
		this.gbcCobertura = new GridBagConstraints();
		this.gbcCoberturaBotones = new GridBagConstraints();
		this.gbcCalculos = new GridBagConstraints();
		this.gbcPolizaGenerar = new GridBagConstraints();
		this.gbcTitularSeguro = new GridBagConstraints();
		this.gbcDatosVehiculo = new GridBagConstraints();
		this.gbcVigencia = new GridBagConstraints();
		this.gbcSumaAseguradaYPremio = new GridBagConstraints();
		this.gbcDescuentos = new GridBagConstraints();
		this.gbcDiaPago = new GridBagConstraints();
		this.gbcMontoAbonar = new GridBagConstraints();
		this.setLayout(new BorderLayout());
		this.panelContenido = new JPanel();
		this.panelCobertura = new JPanel();
		this.panelCalculos = new JPanel();
		this.panelPolizaGenerar = new JPanel();
		this.armarPaneles();
		this.armarContenido();
	}
	
	private void armarPaneles() {
		panelContenido.setLayout(new GridBagLayout());
		
		panelCobertura.setLayout(new GridBagLayout());
		panelCobertura.setBorder(BorderFactory.createTitledBorder("Selección de cobertura"));
		gbcContenido.gridx = 0;
		gbcContenido.gridy = 0;
		gbcContenido.gridwidth = 3;
		gbcContenido.weightx = 1;
		gbcContenido.fill = GridBagConstraints.HORIZONTAL;
		gbcContenido.insets = new Insets( 10, 10, 10, 10);
		panelContenido.add(panelCobertura, gbcContenido);
		
		panelCalculos.setLayout(new GridBagLayout());
		panelCalculos.setBorder(BorderFactory.createTitledBorder("Cálculo de Premio, Derecho de Emisión y Descuentos"));
		gbcContenido.gridx = 0;
		gbcContenido.gridy = 1;
		panelContenido.add(panelCalculos, gbcContenido);
		
		panelPolizaGenerar.setLayout(new GridBagLayout());
		panelPolizaGenerar.setBorder(BorderFactory.createTitledBorder("Póliza a generar"));
		gbcContenido.gridx = 0;
		gbcContenido.gridy = 2;
		panelContenido.add(panelPolizaGenerar, gbcContenido);
		
		scrollPane = new JScrollPane(panelContenido);
		this.add(scrollPane, BorderLayout.CENTER);
	}
	
	private void armarContenido() {
		lblTipoCobertura = new JLabel("Tipo cobertura");
		gbcCobertura.gridx = 0;
		gbcCobertura.gridy = 0;
		gbcCobertura.insets = new Insets(10,10,10,0);
		panelCobertura.add(lblTipoCobertura, gbcCobertura);
		
		lblObligatorioTipoCobertura = new JLabel("(*)");
		lblObligatorioTipoCobertura.setForeground(Color.RED);
		gbcCobertura.gridx = 1;
		gbcCobertura.gridy = 0;
		gbcCobertura.insets = new Insets(10, 0, 10, 10);
		panelCobertura.add(lblObligatorioTipoCobertura, gbcCobertura);
		
		cbTipoCobertura = new JComboBox<>();
		gbcCobertura.gridx = 2;
		gbcCobertura.gridy = 0;
		gbcCobertura.weightx = 0.33;
		gbcCobertura.fill = GridBagConstraints.HORIZONTAL;
		gbcCobertura.insets = new Insets(10, 10, 10, 10);
		panelCobertura.add(cbTipoCobertura, gbcCobertura);
		
		lblFechaInicio = new JLabel("Fecha de inicio");
		gbcCobertura.gridx = 3;
		gbcCobertura.gridy = 0;
		gbcCobertura.weightx = 0;
		gbcCobertura.fill = GridBagConstraints.NONE;
		gbcCobertura.insets = new Insets(10, 10, 10, 0);
		panelCobertura.add(lblFechaInicio, gbcCobertura);
		
		lblObligatorioFechaInicio = new JLabel("(*)");
		lblObligatorioFechaInicio.setForeground(Color.RED);
		gbcCobertura.gridx = 4;
		gbcCobertura.gridy = 0;
		gbcCobertura.insets = new Insets(10, 0, 10, 10);
		panelCobertura.add(lblObligatorioFechaInicio, gbcCobertura);
		
		dcFechaInicio = new JDateChooser("dd/MM/yyyy", "##/##/####", '-');
		dcFechaInicio.setDate(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)));//Seteo fecha posterior a la actual
		gbcCobertura.gridx = 5;
		gbcCobertura.gridy = 0;
		gbcCobertura.weightx = 0.33;
		gbcCobertura.fill = GridBagConstraints.HORIZONTAL;
		gbcCobertura.insets = new Insets(10, 10, 10, 10);
		panelCobertura.add(dcFechaInicio, gbcCobertura);
		
		lblFormaPago = new JLabel("Forma de Pago");
		gbcCobertura.gridx = 6;
		gbcCobertura.gridy = 0;
		gbcCobertura.weightx = 0;
		gbcCobertura.fill = GridBagConstraints.NONE;
		gbcCobertura.insets = new Insets(10, 10, 10, 0);
		panelCobertura.add(lblFormaPago, gbcCobertura);
		
		lblObligatorioFormaPago = new JLabel("(*)");
		lblObligatorioFormaPago.setForeground(Color.RED);
		gbcCobertura.gridx = 7;
		gbcCobertura.gridy = 0;
		gbcCobertura.insets = new Insets(10, 0, 10, 10);
		panelCobertura.add(lblObligatorioFormaPago, gbcCobertura);
		
		cbFormaPago = new JComboBox<>();
		gbcCobertura.gridx = 8;
		gbcCobertura.gridy = 0;
		gbcCobertura.weightx = 0.33;
		gbcCobertura.fill = GridBagConstraints.HORIZONTAL;
		gbcCobertura.insets = new Insets(10, 10, 10, 10);
		panelCobertura.add(cbFormaPago, gbcCobertura);
		
		panelCoberturaBotones = new JPanel();
		panelCoberturaBotones.setLayout(new GridBagLayout());
		gbcCobertura.gridx = 0;
		gbcCobertura.gridy = 1;
		gbcCobertura.gridwidth = 9;
		gbcCobertura.weightx = 1;
		gbcCobertura.insets = new Insets(0,0,0,0);
		panelCobertura.add(panelCoberturaBotones, gbcCobertura);
		
		btnConfirmar = new JButton("Confirmar");
		gbcCoberturaBotones.gridx = 0;
		gbcCoberturaBotones.gridy = 0;
		gbcCoberturaBotones.weightx = 1;
		gbcCoberturaBotones.anchor = GridBagConstraints.EAST;
		gbcCoberturaBotones.insets = new Insets( 10, 10, 10, 10);
		panelCoberturaBotones.add(btnConfirmar, gbcCoberturaBotones);
		btnConfirmar.addActionListener(e -> {
			//TODO: Agregar funcionamiento boton confirmar
		});
		
		btnLimpiar = new JButton("Limpiar");
		gbcCoberturaBotones.gridx = 1;
		gbcCoberturaBotones.gridy = 0;
		gbcCoberturaBotones.weightx = 0;
		gbcCoberturaBotones.anchor = GridBagConstraints.CENTER;
		panelCoberturaBotones.add(btnLimpiar, gbcCoberturaBotones);
		btnLimpiar.addActionListener(e -> {
			//TODO: Limpiar los campos tipo cobertura y forma de pago
			dcFechaInicio.setDate(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)));
		});
		
		lblPremioCalculo = new JLabel("Premio");
		gbcCalculos.gridx = 0;
		gbcCalculos.gridy = 0;
		gbcCalculos.anchor = GridBagConstraints.WEST;
		gbcCalculos.insets = new Insets(10, 10, 10, 10);
		panelCalculos.add(lblPremioCalculo, gbcCalculos);
		
		txtPremioCalculo = new JTextField();
		txtPremioCalculo.setEditable(false);
		gbcCalculos.gridx = 1;
		gbcCalculos.gridy = 0;
		gbcCalculos.weightx = 0.33;
		gbcCalculos.anchor = GridBagConstraints.CENTER;
		gbcCalculos.fill = GridBagConstraints.HORIZONTAL;
		panelCalculos.add(txtPremioCalculo, gbcCalculos);
		
		lblDerechosEmision = new JLabel("Derechos de Emisión");
		gbcCalculos.gridx = 2;
		gbcCalculos.gridy = 0;
		gbcCalculos.weightx = 0;
		gbcCalculos.anchor = GridBagConstraints.WEST;
		gbcCalculos.fill = GridBagConstraints.NONE;
		panelCalculos.add(lblDerechosEmision, gbcCalculos);
		
		txtDerechosEmision = new JTextField();
		txtDerechosEmision.setEditable(false);
		gbcCalculos.gridx = 3;
		gbcCalculos.gridy = 0;
		gbcCalculos.weightx = 0.33;
		gbcCalculos.anchor = GridBagConstraints.CENTER;
		gbcCalculos.fill = GridBagConstraints.HORIZONTAL;
		panelCalculos.add(txtDerechosEmision, gbcCalculos);
		
		lblDescuento = new JLabel("Descuento");
		gbcCalculos.gridx = 4;
		gbcCalculos.gridy = 0;
		gbcCalculos.weightx = 0;
		gbcCalculos.anchor = GridBagConstraints.WEST;
		gbcCalculos.fill = GridBagConstraints.NONE;
		panelCalculos.add(lblDescuento, gbcCalculos);
		
		txtDescuento = new JTextField();
		txtDescuento.setEditable(false);
		gbcCalculos.gridx = 5;
		gbcCalculos.gridy = 0;
		gbcCalculos.weightx = 0.33;
		gbcCalculos.anchor = GridBagConstraints.CENTER;
		gbcCalculos.fill = GridBagConstraints.HORIZONTAL;
		panelCalculos.add(txtDescuento, gbcCalculos);
		
		panelTitularSeguro = new JPanel();
		panelTitularSeguro.setLayout(new GridBagLayout());
		panelTitularSeguro.setBorder(BorderFactory.createTitledBorder("Titular del Seguro"));
		gbcPolizaGenerar.gridx = 0;
		gbcPolizaGenerar.gridy = 0;
		gbcPolizaGenerar.gridwidth = 2;
		gbcPolizaGenerar.weightx = 1;
		gbcPolizaGenerar.fill = GridBagConstraints.HORIZONTAL;
		gbcPolizaGenerar.insets = new Insets(10, 10, 10, 10);
		panelPolizaGenerar.add(panelTitularSeguro, gbcPolizaGenerar);
		
		lblApellido = new JLabel("Apellido");
		gbcTitularSeguro.gridx = 0;
		gbcTitularSeguro.gridy = 0;
		gbcTitularSeguro.anchor = GridBagConstraints.WEST;
		gbcTitularSeguro.insets = new Insets(10, 10, 10, 10);
		panelTitularSeguro.add(lblApellido, gbcTitularSeguro);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		gbcTitularSeguro.gridx = 1;
		gbcTitularSeguro.gridy = 0;
		gbcTitularSeguro.weightx = 0.5;
		gbcTitularSeguro.anchor = GridBagConstraints.CENTER;
		gbcTitularSeguro.fill = GridBagConstraints.HORIZONTAL;
		panelTitularSeguro.add(txtApellido, gbcTitularSeguro);
		
		lblNombre = new JLabel("Nombre");
		gbcTitularSeguro.gridx = 2;
		gbcTitularSeguro.gridy = 0;
		gbcTitularSeguro.weightx = 0;
		gbcTitularSeguro.anchor = GridBagConstraints.WEST;
		gbcTitularSeguro.fill = GridBagConstraints.NONE;
		panelTitularSeguro.add(lblNombre, gbcTitularSeguro);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		gbcTitularSeguro.gridx = 3;
		gbcTitularSeguro.gridy = 0;
		gbcTitularSeguro.weightx = 0.5;
		gbcTitularSeguro.anchor = GridBagConstraints.CENTER;
		gbcTitularSeguro.fill = GridBagConstraints.HORIZONTAL;
		panelTitularSeguro.add(txtNombre, gbcTitularSeguro);
		
		panelDatosVehiculo = new JPanel();
		panelDatosVehiculo.setLayout(new GridBagLayout());
		panelDatosVehiculo.setBorder(BorderFactory.createTitledBorder("Datos del Vehículo"));
		gbcPolizaGenerar.gridx = 0;
		gbcPolizaGenerar.gridy = 1;
		panelPolizaGenerar.add(panelDatosVehiculo, gbcPolizaGenerar);
		
		lblMarcaVehiculo = new JLabel("Marca del Vehículo");
		gbcDatosVehiculo.gridx = 0;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.anchor = GridBagConstraints.WEST;
		gbcDatosVehiculo.insets = new Insets(10, 10, 10, 10);
		panelDatosVehiculo.add(lblMarcaVehiculo, gbcDatosVehiculo);
		
		txtMarcaVehiculo = new JTextField();
		txtMarcaVehiculo.setEditable(false);
		gbcDatosVehiculo.gridx = 1;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.weightx = 0.33;
		gbcDatosVehiculo.anchor = GridBagConstraints.CENTER;
		gbcDatosVehiculo.fill = GridBagConstraints.HORIZONTAL;
		panelDatosVehiculo.add(txtMarcaVehiculo, gbcDatosVehiculo);
		
		lblModeloVehiculo = new JLabel("Modelo del Vehículo");
		gbcDatosVehiculo.gridx = 2;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.weightx = 0;
		gbcDatosVehiculo.anchor = GridBagConstraints.WEST;
		gbcDatosVehiculo.fill = GridBagConstraints.NONE;
		panelDatosVehiculo.add(lblModeloVehiculo, gbcDatosVehiculo);
		
		txtModeloVehiculo = new JTextField();
		txtModeloVehiculo.setEditable(false);
		gbcDatosVehiculo.gridx = 3;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.weightx = 0.33;
		gbcDatosVehiculo.anchor = GridBagConstraints.CENTER;
		gbcDatosVehiculo.fill = GridBagConstraints.HORIZONTAL;
		panelDatosVehiculo.add(txtModeloVehiculo, gbcDatosVehiculo);
		
		lblMotor = new JLabel("Motor");
		gbcDatosVehiculo.gridx = 4;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.weightx = 0;
		gbcDatosVehiculo.anchor = GridBagConstraints.WEST;
		gbcDatosVehiculo.fill = GridBagConstraints.NONE;
		panelDatosVehiculo.add(lblMotor, gbcDatosVehiculo);
		
		txtMotor = new JTextField();
		txtMotor.setEditable(false);
		gbcDatosVehiculo.gridx = 5;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.weightx = 0.33;
		gbcDatosVehiculo.anchor = GridBagConstraints.CENTER;
		gbcDatosVehiculo.fill = GridBagConstraints.HORIZONTAL;
		panelDatosVehiculo.add(txtMotor, gbcDatosVehiculo);
		
		lblPatente = new JLabel("Patente del Vehículo");
		gbcDatosVehiculo.gridx = 0;
		gbcDatosVehiculo.gridy = 1;
		gbcDatosVehiculo.weightx = 0;
		gbcDatosVehiculo.anchor = GridBagConstraints.WEST;
		gbcDatosVehiculo.fill = GridBagConstraints.NONE;
		panelDatosVehiculo.add(lblPatente, gbcDatosVehiculo);
		
		txtPatente = new JTextField();
		txtPatente.setEditable(false);
		gbcDatosVehiculo.gridx = 1;
		gbcDatosVehiculo.gridy = 1;
		gbcDatosVehiculo.anchor = GridBagConstraints.CENTER;
		gbcDatosVehiculo.fill = GridBagConstraints.HORIZONTAL;
		panelDatosVehiculo.add(txtPatente, gbcDatosVehiculo);
		
		lblChasis = new JLabel("Chasis");
		gbcDatosVehiculo.gridx = 2;
		gbcDatosVehiculo.gridy = 1;
		gbcDatosVehiculo.weightx = 0;
		gbcDatosVehiculo.anchor = GridBagConstraints.WEST;
		gbcDatosVehiculo.fill = GridBagConstraints.NONE;
		panelDatosVehiculo.add(lblChasis, gbcDatosVehiculo);

		txtChasis = new JTextField();
		txtChasis.setEditable(false);
		gbcDatosVehiculo.gridx = 3;
		gbcDatosVehiculo.gridy = 1;
		gbcDatosVehiculo.anchor = GridBagConstraints.CENTER;
		gbcDatosVehiculo.fill = GridBagConstraints.HORIZONTAL;
		panelDatosVehiculo.add(txtChasis, gbcDatosVehiculo);
		
		panelVigencia = new JPanel();
		panelVigencia.setLayout(new GridBagLayout());
		panelVigencia.setBorder(BorderFactory.createTitledBorder("Vigencia"));
		gbcPolizaGenerar.gridx = 0;
		gbcPolizaGenerar.gridy = 2;
		panelPolizaGenerar.add(panelVigencia, gbcPolizaGenerar);
		
		lblFechaInicioVigencia = new JLabel("Fecha de Inicio");
		gbcVigencia.gridx = 0;
		gbcVigencia.gridy = 0;
		gbcVigencia.anchor = GridBagConstraints.WEST;
		gbcVigencia.insets = new Insets(10, 10, 10, 10);
		panelVigencia.add(lblFechaInicioVigencia, gbcVigencia);
		
		txtFechaInicioVigencia = new JTextField();
		txtFechaInicioVigencia.setEditable(false);
		gbcVigencia.gridx = 1;
		gbcVigencia.gridy = 0;
		gbcVigencia.weightx = 0.5;
		gbcVigencia.anchor = GridBagConstraints.CENTER;
		gbcVigencia.fill = GridBagConstraints.HORIZONTAL;
		panelVigencia.add(txtFechaInicioVigencia, gbcVigencia);
		
		lblFechaFinVigencia = new JLabel("Fecha de Fin");
		gbcVigencia.gridx = 2;
		gbcVigencia.gridy = 0;
		gbcVigencia.weightx = 0;
		gbcVigencia.anchor = GridBagConstraints.WEST;
		gbcVigencia.fill = GridBagConstraints.NONE;
		panelVigencia.add(lblFechaFinVigencia, gbcVigencia);
		
		txtFechaFinVigencia = new JTextField();
		txtFechaFinVigencia.setEditable(false);
		gbcVigencia.gridx = 3;
		gbcVigencia.gridy = 0;
		gbcVigencia.weightx = 0.5;
		gbcVigencia.anchor = GridBagConstraints.CENTER;
		gbcVigencia.fill = GridBagConstraints.HORIZONTAL;
		panelVigencia.add(txtFechaFinVigencia, gbcVigencia);
		
		panelSumaAseguradaYPremio = new JPanel();
		panelSumaAseguradaYPremio.setLayout(new GridBagLayout());
		gbcPolizaGenerar.gridx = 0;
		gbcPolizaGenerar.gridy = 3;
		gbcPolizaGenerar.insets = new Insets(0, 0, 0, 0);
		panelPolizaGenerar.add(panelSumaAseguradaYPremio, gbcPolizaGenerar);
		
		lblSumaAsegurada = new JLabel("Suma Asegurada");
		gbcSumaAseguradaYPremio.gridx = 0;
		gbcSumaAseguradaYPremio.gridy = 0;
		gbcSumaAseguradaYPremio.anchor = GridBagConstraints.WEST;
		gbcSumaAseguradaYPremio.insets = new Insets(10, 10, 10, 10);
		panelSumaAseguradaYPremio.add(lblSumaAsegurada, gbcSumaAseguradaYPremio);
		
		txtSumaAsegurada = new JTextField();
		txtSumaAsegurada.setEditable(false);
		gbcSumaAseguradaYPremio.gridx = 1;
		gbcSumaAseguradaYPremio.gridy = 0;
		gbcSumaAseguradaYPremio.weightx = 0.5;
		gbcSumaAseguradaYPremio.anchor = GridBagConstraints.CENTER;
		gbcSumaAseguradaYPremio.fill = GridBagConstraints.HORIZONTAL;
		panelSumaAseguradaYPremio.add(txtSumaAsegurada, gbcSumaAseguradaYPremio);
		
		lblPremio = new JLabel("Premio");
		gbcSumaAseguradaYPremio.gridx = 2;
		gbcSumaAseguradaYPremio.gridy = 0;
		gbcSumaAseguradaYPremio.weightx = 0;
		gbcSumaAseguradaYPremio.anchor = GridBagConstraints.WEST;
		gbcSumaAseguradaYPremio.fill = GridBagConstraints.NONE;
		panelSumaAseguradaYPremio.add(lblPremio, gbcSumaAseguradaYPremio);
		
		txtPremio = new JTextField();
		txtPremio.setEditable(false);
		gbcSumaAseguradaYPremio.gridx = 3;
		gbcSumaAseguradaYPremio.gridy = 0;
		gbcSumaAseguradaYPremio.weightx = 0.5;
		gbcSumaAseguradaYPremio.anchor = GridBagConstraints.CENTER;
		gbcSumaAseguradaYPremio.fill = GridBagConstraints.HORIZONTAL;
		panelSumaAseguradaYPremio.add(txtPremio, gbcSumaAseguradaYPremio);
		
		panelDescuentos = new JPanel();
		panelDescuentos.setLayout(new GridBagLayout());
		panelDescuentos.setBorder(BorderFactory.createTitledBorder("Descuentos"));
		gbcPolizaGenerar.gridx = 0;
		gbcPolizaGenerar.gridy = 4;
		gbcPolizaGenerar.gridwidth = 1;
		gbcPolizaGenerar.weightx = 0.5;
		gbcPolizaGenerar.insets = new Insets(10, 10, 10, 10);
		panelPolizaGenerar.add(panelDescuentos, gbcPolizaGenerar);
		
		modeloTablaDescuentos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Para que las celdas no sean editables
                return false;
            }
        };
		modeloTablaDescuentos.addColumn("Nombre");
		modeloTablaDescuentos.addColumn("Importe");
		for (int i = 0; i < 10; i++) {
			modeloTablaDescuentos.addRow(new Object[] { "" });
		}
		
		tablaDescuentos = new JTable(modeloTablaDescuentos);
		tablaDescuentos.setRowSelectionAllowed(false);//No se pueden seleccionar filas
        tablaDescuentos.setAutoCreateRowSorter(true);//Habilitar ordenamiento por columna
        tablaDescuentos.getTableHeader().setReorderingAllowed(false); // No permitir reordenar columnas
        int rowHeight = tablaDescuentos.getRowHeight();
        int numRowsToShow = 6; //El tamaño de las tablas es de 6 filas, si tienen más se desplazan con la barra
        tablaDescuentos.setPreferredScrollableViewportSize(new Dimension(tablaDescuentos.getPreferredSize().width, rowHeight * numRowsToShow));
              
        scrollTablaDescuentos = new JScrollPane(tablaDescuentos);
        gbcDescuentos.gridx = 0;
        gbcDescuentos.gridy = 0;
        gbcDescuentos.weightx = 1;
        gbcDescuentos.fill = GridBagConstraints.HORIZONTAL;
        gbcDescuentos.insets = new Insets(10, 10, 10, 10);
        panelDescuentos.add(scrollTablaDescuentos, gbcDescuentos);
		
		panelDiaPago = new JPanel();
		panelDiaPago.setLayout(new GridBagLayout());
		panelDiaPago.setBorder(BorderFactory.createTitledBorder("Día de pago"));
		gbcPolizaGenerar.gridx = 1;
		gbcPolizaGenerar.gridy = 4;
		panelPolizaGenerar.add(panelDiaPago, gbcPolizaGenerar);
		
		modeloTablaDiaPago = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Para que las celdas no sean editables
                return false;
            }
        };
		modeloTablaDiaPago.addColumn("Cuota");
		modeloTablaDiaPago.addColumn("Fecha Vencimiento");
		modeloTablaDiaPago.addColumn("Importe");
		for (int i = 0; i < 6; i++) {
			modeloTablaDiaPago.addRow(new Object[] { "" });
		}
		
		tablaDiaPago = new JTable(modeloTablaDiaPago);
		tablaDiaPago.setRowSelectionAllowed(false);
        tablaDiaPago.setAutoCreateRowSorter(true);//Habilitar ordenamiento por columna
        tablaDiaPago.getTableHeader().setReorderingAllowed(false); // No permitir reordenar columnas
        tablaDiaPago.setPreferredScrollableViewportSize(new Dimension(tablaDiaPago.getPreferredSize().width, rowHeight * numRowsToShow));
              
        scrollTablaDiaPago = new JScrollPane(tablaDiaPago);
        gbcDiaPago.gridx = 0;
        gbcDiaPago.gridy = 0;
        gbcDiaPago.weightx = 1;
        gbcDiaPago.fill = GridBagConstraints.HORIZONTAL;
        gbcDiaPago.insets = new Insets(10, 10, 10, 10);
        panelDiaPago.add(scrollTablaDiaPago, gbcDiaPago);
        
        panelMontoAbonar = new JPanel();
        panelMontoAbonar.setLayout(new GridBagLayout());
        gbcPolizaGenerar.gridx = 0;
        gbcPolizaGenerar.gridy = 5;
        gbcPolizaGenerar.gridwidth = 2;
		gbcPolizaGenerar.weightx = 1;
		gbcPolizaGenerar.insets = new Insets(0,0,0,0);
		panelPolizaGenerar.add(panelMontoAbonar, gbcPolizaGenerar);
        
        lblMontoAbonar = new JLabel("Monto total a abonar");
        gbcMontoAbonar.gridx = 0;
		gbcMontoAbonar.gridy = 0;
		gbcMontoAbonar.weightx = 1;
		gbcMontoAbonar.anchor = GridBagConstraints.EAST;
		gbcMontoAbonar.fill = GridBagConstraints.NONE;
		gbcMontoAbonar.insets = new Insets(10, 10, 10, 10);
		panelMontoAbonar.add(lblMontoAbonar, gbcMontoAbonar);
		
		txtMontoAbonar = new JTextField(10);
		txtMontoAbonar.setEditable(false);
		gbcMontoAbonar.gridx = 1;
		gbcMontoAbonar.gridy = 0;
		gbcMontoAbonar.weightx = 0;
		gbcMontoAbonar.anchor = GridBagConstraints.CENTER;
		gbcMontoAbonar.fill = GridBagConstraints.HORIZONTAL;
		panelMontoAbonar.add(txtMontoAbonar, gbcMontoAbonar);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.setEnabled(false);
		gbcContenido.gridx = 0;
		gbcContenido.gridy = 3;
		gbcContenido.gridwidth = 1;
		gbcContenido.anchor = GridBagConstraints.EAST;
		gbcContenido.fill = GridBagConstraints.NONE;
		panelContenido.add(btnGenerar, gbcContenido);
		btnGenerar.addActionListener(e -> {
			//TODO: Hacer funcionamiento boton generar
		});
		
		btnAtras = new JButton("Atrás");
		gbcContenido.gridx = 1;
		gbcContenido.gridy = 3;
		gbcContenido.weightx = 0;
		gbcContenido.anchor = GridBagConstraints.CENTER;
		panelContenido.add(btnAtras, gbcContenido);
		btnAtras.addActionListener(e -> {
			ventana.setTitle("Póliza - Alta - 1");
			ventana.setContentPane(panelPoliza1);
			ventana.setVisible(true);
		});
		
		btnCancelar = new JButton("Cancelar");
		gbcContenido.gridx = 2;
		gbcContenido.gridy = 3;
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
}