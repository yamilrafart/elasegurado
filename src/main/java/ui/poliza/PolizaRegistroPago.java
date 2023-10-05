package ui.poliza;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import utils.DocumentFilterLimit;

@SuppressWarnings("serial")
public class PolizaRegistroPago extends JPanel {
	private JFrame ventana;
	private JPanel panelMenu;
	private GridBagConstraints gbcContenido;
	private GridBagConstraints gbcDatosPoliza;
	private GridBagConstraints gbcTitularSeguro;
	private GridBagConstraints gbcDatosVehiculo;
	private GridBagConstraints gbcCuotasPendientes;
	private JScrollPane scrollPane;
	private JPanel panelContenido;
	private JPanel panelDatosPoliza;
	private JPanel panelTitularSeguro;
	private JLabel lblNumCliente;
	private JTextField txtNumCliente;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblNumPoliza;
	private JTextField txtNumPoliza;
	private JPanel panelDatosVehiculo;
	private JLabel lblMarca;
	private JTextField txtMarca;
	private JLabel lblModelo;
	private JTextField txtModelo;
	private JLabel lblAnio;
	private JTextField txtAnio;
	private JLabel lblVigencia;
	private JTextField txtVigencia;
	private JButton btnBuscarPoliza;
	private JPanel panelCuotasPendientes;
	private JTable tablaCuotasPendientes;
	private DefaultTableModel modeloTablaCuotasPendientes;
	private JScrollPane scrollTablaCuotasPendientes;
	private JLabel lblMontoParcial;
	private JTextField txtMontoParcial;
	private JLabel lblMontoTotal;
	private JTextField txtMontoTotal;
	private JButton btnCalcularMontos;
	private JLabel lblMontoAbonado;
	private JTextField txtMontoAbonado;
	private JLabel lblVuelto;
	private JTextField txtVuelto;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	
	public PolizaRegistroPago(JFrame ventana, JPanel panelMenu) {
		this.ventana = ventana;
		this.panelMenu = panelMenu;
		this.gbcContenido = new GridBagConstraints();
		this.gbcDatosPoliza = new GridBagConstraints();
		this.gbcTitularSeguro = new GridBagConstraints();
		this.gbcDatosVehiculo = new GridBagConstraints();
		this.gbcCuotasPendientes = new GridBagConstraints();
		this.setLayout(new BorderLayout());
		this.panelContenido = new JPanel();
		this.panelDatosPoliza = new JPanel();
		this.armarPaneles();
		this.armarContenido();
	}

	private void armarPaneles() {
		panelContenido.setLayout(new GridBagLayout());
		
		panelDatosPoliza.setLayout(new GridBagLayout());
		panelDatosPoliza.setBorder(BorderFactory.createTitledBorder("Datos de la Póliza"));
		gbcContenido.gridx = 0;
		gbcContenido.gridy = 0;
		gbcContenido.gridwidth = 6;
		gbcContenido.weightx = 1;
		gbcContenido.fill = GridBagConstraints.HORIZONTAL;
		gbcContenido.insets = new Insets( 10, 10, 10, 10);
		panelContenido.add(panelDatosPoliza, gbcContenido);
		
		scrollPane = new JScrollPane(panelContenido);
		this.add(scrollPane, BorderLayout.CENTER);
	}

	private void armarContenido() {
		panelTitularSeguro = new JPanel();
		panelTitularSeguro.setLayout(new GridBagLayout());
		panelTitularSeguro.setBorder(BorderFactory.createTitledBorder("Titular del Seguro"));
		gbcDatosPoliza.gridx = 0;
		gbcDatosPoliza.gridy = 0;
		gbcDatosPoliza.gridwidth = 3;
		gbcDatosPoliza.weightx = 1;
		gbcDatosPoliza.fill = GridBagConstraints.HORIZONTAL;
		gbcDatosPoliza.insets = new Insets(10, 10, 10, 10);
		panelDatosPoliza.add(panelTitularSeguro, gbcDatosPoliza);
		
		lblNumCliente = new JLabel("Número Cliente");
		gbcTitularSeguro.gridx = 0;
		gbcTitularSeguro.gridy = 0;
		gbcTitularSeguro.anchor = GridBagConstraints.WEST;
		gbcTitularSeguro.insets = new Insets(10, 10, 10, 10);
		panelTitularSeguro.add(lblNumCliente, gbcTitularSeguro);
		
		txtNumCliente = new JTextField();
		txtNumCliente.setEditable(false);
		gbcTitularSeguro.gridx = 1;
		gbcTitularSeguro.gridy = 0;
		gbcTitularSeguro.weightx = 0.33;
		gbcTitularSeguro.anchor = GridBagConstraints.CENTER;
		gbcTitularSeguro.fill = GridBagConstraints.HORIZONTAL;
		panelTitularSeguro.add(txtNumCliente, gbcTitularSeguro);
		
		lblApellido = new JLabel("Apellido");
		gbcTitularSeguro.gridx = 2;
		gbcTitularSeguro.gridy = 0;
		gbcTitularSeguro.weightx = 0;
		gbcTitularSeguro.anchor = GridBagConstraints.WEST;
		gbcTitularSeguro.fill = GridBagConstraints.NONE;
		panelTitularSeguro.add(lblApellido, gbcTitularSeguro);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		gbcTitularSeguro.gridx = 3;
		gbcTitularSeguro.gridy = 0;
		gbcTitularSeguro.weightx = 0.33;
		gbcTitularSeguro.anchor = GridBagConstraints.CENTER;
		gbcTitularSeguro.fill = GridBagConstraints.HORIZONTAL;
		panelTitularSeguro.add(txtApellido, gbcTitularSeguro);
		
		lblNombre = new JLabel("Nombre");
		gbcTitularSeguro.gridx = 4;
		gbcTitularSeguro.gridy = 0;
		gbcTitularSeguro.weightx = 0;
		gbcTitularSeguro.anchor = GridBagConstraints.WEST;
		gbcTitularSeguro.fill = GridBagConstraints.NONE;
		panelTitularSeguro.add(lblNombre, gbcTitularSeguro);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		gbcTitularSeguro.gridx = 5;
		gbcTitularSeguro.gridy = 0;
		gbcTitularSeguro.weightx = 0.33;
		gbcTitularSeguro.anchor = GridBagConstraints.CENTER;
		gbcTitularSeguro.fill = GridBagConstraints.HORIZONTAL;
		panelTitularSeguro.add(txtNombre, gbcTitularSeguro);
		
		lblNumPoliza = new JLabel("Número de Póliza");
		gbcDatosPoliza.gridx = 0;
		gbcDatosPoliza.gridy = 1;
		gbcDatosPoliza.gridwidth = 1;
		gbcDatosPoliza.weightx = 0;
		gbcDatosPoliza.anchor = GridBagConstraints.WEST;
		gbcDatosPoliza.fill = GridBagConstraints.NONE;
		panelDatosPoliza.add(lblNumPoliza, gbcDatosPoliza);
		
		txtNumPoliza = new JTextField();
		txtNumPoliza.setEditable(false);
		gbcDatosPoliza.gridx = 1;
		gbcDatosPoliza.gridy = 1;
		gbcDatosPoliza.weightx = 0.15;
		gbcDatosPoliza.anchor = GridBagConstraints.CENTER;
		gbcDatosPoliza.fill = GridBagConstraints.HORIZONTAL;
		panelDatosPoliza.add(txtNumPoliza, gbcDatosPoliza);
		
		panelDatosVehiculo = new JPanel();
		panelDatosVehiculo.setLayout(new GridBagLayout());
		panelDatosVehiculo.setBorder(BorderFactory.createTitledBorder("Datos del Vehículo"));
		gbcDatosPoliza.gridx = 0;
		gbcDatosPoliza.gridy = 2;
		gbcDatosPoliza.gridwidth = 3;
		gbcDatosPoliza.weightx = 1;
		panelDatosPoliza.add(panelDatosVehiculo, gbcDatosPoliza);
		
		lblMarca = new JLabel("Marca");
		gbcDatosVehiculo.gridx = 0;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.anchor = GridBagConstraints.WEST;
		gbcDatosVehiculo.insets = new Insets(10, 10, 10, 10);
		panelDatosVehiculo.add(lblMarca, gbcDatosVehiculo);
		
		txtMarca = new JTextField();
		txtMarca.setEditable(false);
		gbcDatosVehiculo.gridx = 1;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.weightx = 0.33;
		gbcDatosVehiculo.anchor = GridBagConstraints.CENTER;
		gbcDatosVehiculo.fill = GridBagConstraints.HORIZONTAL;
		panelDatosVehiculo.add(txtMarca, gbcDatosVehiculo);
		
		lblModelo = new JLabel("Modelo");
		gbcDatosVehiculo.gridx = 2;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.weightx = 0;
		gbcDatosVehiculo.anchor = GridBagConstraints.WEST;
		gbcDatosVehiculo.fill = GridBagConstraints.NONE;
		panelDatosVehiculo.add(lblModelo, gbcDatosVehiculo);
		
		txtModelo = new JTextField();
		txtModelo.setEditable(false);
		gbcDatosVehiculo.gridx = 3;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.weightx = 0.33;
		gbcDatosVehiculo.anchor = GridBagConstraints.CENTER;
		gbcDatosVehiculo.fill = GridBagConstraints.HORIZONTAL;
		panelDatosVehiculo.add(txtModelo, gbcDatosVehiculo);
		
		lblAnio = new JLabel("Año");
		gbcDatosVehiculo.gridx = 4;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.weightx = 0;
		gbcDatosVehiculo.anchor = GridBagConstraints.WEST;
		gbcDatosVehiculo.fill = GridBagConstraints.NONE;
		panelDatosVehiculo.add(lblAnio, gbcDatosVehiculo);
		
		txtAnio = new JTextField();
		txtAnio.setEditable(false);
		gbcDatosVehiculo.gridx = 5;
		gbcDatosVehiculo.gridy = 0;
		gbcDatosVehiculo.weightx = 0.33;
		gbcDatosVehiculo.anchor = GridBagConstraints.CENTER;
		gbcDatosVehiculo.fill = GridBagConstraints.HORIZONTAL;
		panelDatosVehiculo.add(txtAnio, gbcDatosVehiculo);
		
		lblVigencia = new JLabel("Vigencia");
		gbcDatosPoliza.gridx = 0;
		gbcDatosPoliza.gridy = 3;
		gbcDatosPoliza.gridwidth = 1;
		gbcDatosPoliza.weightx = 0;
		gbcDatosPoliza.anchor = GridBagConstraints.WEST;
		gbcDatosPoliza.fill = GridBagConstraints.NONE;
		panelDatosPoliza.add(lblVigencia, gbcDatosPoliza);
		
		txtVigencia = new JTextField();
		txtVigencia.setEditable(false);
		gbcDatosPoliza.gridx = 1;
		gbcDatosPoliza.gridy = 3;
		gbcDatosPoliza.weightx = 0.15;
		gbcDatosPoliza.anchor = GridBagConstraints.CENTER;
		gbcDatosPoliza.fill = GridBagConstraints.HORIZONTAL;
		panelDatosPoliza.add(txtVigencia, gbcDatosPoliza);
		
		btnBuscarPoliza = new JButton("Buscar Póliza");
		gbcDatosPoliza.gridx = 2;
		gbcDatosPoliza.gridy = 4;
		gbcDatosPoliza.weightx = 0.85;
		gbcDatosPoliza.anchor = GridBagConstraints.EAST;
		gbcDatosPoliza.fill = GridBagConstraints.NONE;
		panelDatosPoliza.add(btnBuscarPoliza, gbcDatosPoliza);
		btnBuscarPoliza.addActionListener(e -> {
			//TODO: Hacer funcionamiento boton buscar poliza
		});
		
		panelCuotasPendientes = new JPanel();
		panelCuotasPendientes.setLayout(new GridBagLayout());
		panelCuotasPendientes.setBorder(BorderFactory.createTitledBorder("Cuotas pendientes"));
		gbcDatosPoliza.gridx = 0;
		gbcDatosPoliza.gridy = 5;
		gbcDatosPoliza.gridwidth = 3;
		gbcDatosPoliza.weightx = 1;
		gbcDatosPoliza.anchor = GridBagConstraints.CENTER;
		gbcDatosPoliza.fill = GridBagConstraints.HORIZONTAL;
		panelDatosPoliza.add(panelCuotasPendientes, gbcDatosPoliza);
		
        modeloTablaCuotasPendientes = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) {  // Última columna (índice 4) es un check box
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4;  // Solo permitir editar la última columna
            }
        };
		modeloTablaCuotasPendientes.addColumn("Número de cuota");
		modeloTablaCuotasPendientes.addColumn("Fecha vencimiento");
		modeloTablaCuotasPendientes.addColumn("Monto original");
		modeloTablaCuotasPendientes.addColumn("Monto actual");
		modeloTablaCuotasPendientes.addColumn("Selección");
		for (int i = 0; i < 10; i++) {
			modeloTablaCuotasPendientes.addRow(new Object[] { "" });
		}
		
		tablaCuotasPendientes = new JTable(modeloTablaCuotasPendientes);
		tablaCuotasPendientes.setRowSelectionAllowed(false);
        tablaCuotasPendientes.setAutoCreateRowSorter(true);//Habilitar ordenamiento por columna
        tablaCuotasPendientes.getTableHeader().setReorderingAllowed(false); // No permitir reordenar columnas
        int rowHeight = tablaCuotasPendientes.getRowHeight();
        int numRowsToShow = 10; //El tamaño de la tabla es de 10 filas, si tiene más se desplaza con la barra
        tablaCuotasPendientes.setPreferredScrollableViewportSize(new Dimension(tablaCuotasPendientes.getPreferredSize().width, rowHeight * numRowsToShow));
        
        scrollTablaCuotasPendientes = new JScrollPane(tablaCuotasPendientes);
        gbcCuotasPendientes.gridx = 0;
        gbcCuotasPendientes.gridy = 0;
        gbcCuotasPendientes.gridwidth = 5;
        gbcCuotasPendientes.weightx = 1;
        gbcCuotasPendientes.fill = GridBagConstraints.HORIZONTAL;
        gbcCuotasPendientes.insets = new Insets(10, 10, 10, 10);
        panelCuotasPendientes.add(scrollTablaCuotasPendientes, gbcCuotasPendientes);
        
        lblMontoParcial = new JLabel("Monto Parcial");
        gbcCuotasPendientes.gridx = 0;
        gbcCuotasPendientes.gridy = 1;
        gbcCuotasPendientes.gridwidth = 1;
        gbcCuotasPendientes.weightx = 0;
        gbcCuotasPendientes.anchor = GridBagConstraints.WEST;
        gbcCuotasPendientes.fill = GridBagConstraints.NONE;
        panelCuotasPendientes.add(lblMontoParcial, gbcCuotasPendientes);
        
        txtMontoParcial = new JTextField();
        txtMontoParcial.setEditable(false);
        gbcCuotasPendientes.gridx = 1;
        gbcCuotasPendientes.gridy = 1;
        gbcCuotasPendientes.weightx = 0.33;
        gbcCuotasPendientes.anchor = GridBagConstraints.CENTER;
        gbcCuotasPendientes.fill = GridBagConstraints.HORIZONTAL;
        panelCuotasPendientes.add(txtMontoParcial, gbcCuotasPendientes);
        
        lblMontoTotal = new JLabel("Monto Total");
        gbcCuotasPendientes.gridx = 2;
        gbcCuotasPendientes.gridy = 1;
        gbcCuotasPendientes.weightx = 0;
        gbcCuotasPendientes.anchor = GridBagConstraints.WEST;
        gbcCuotasPendientes.fill = GridBagConstraints.NONE;
        panelCuotasPendientes.add(lblMontoTotal, gbcCuotasPendientes);
        
        txtMontoTotal = new JTextField();
        txtMontoTotal.setEditable(false);
        gbcCuotasPendientes.gridx = 3;
        gbcCuotasPendientes.gridy = 1;
        gbcCuotasPendientes.weightx = 0.33;
        gbcCuotasPendientes.anchor = GridBagConstraints.CENTER;
        gbcCuotasPendientes.fill = GridBagConstraints.HORIZONTAL;
        panelCuotasPendientes.add(txtMontoTotal, gbcCuotasPendientes);
        
        btnCalcularMontos = new JButton("Calcular Montos");
        gbcCuotasPendientes.gridx = 4;
        gbcCuotasPendientes.gridy = 2;
        gbcCuotasPendientes.anchor = GridBagConstraints.EAST;
        gbcCuotasPendientes.fill = GridBagConstraints.NONE;
        panelCuotasPendientes.add(btnCalcularMontos, gbcCuotasPendientes);
        
        lblMontoAbonado = new JLabel("Monto abonado por el cliente");
        gbcContenido.gridx = 0;
		gbcContenido.gridy = 1;
		gbcContenido.gridwidth = 1;
		gbcContenido.weightx = 0;
		gbcContenido.anchor = GridBagConstraints.WEST;
		gbcContenido.fill = GridBagConstraints.NONE;
		panelContenido.add(lblMontoAbonado, gbcContenido);
		
		txtMontoAbonado = new JTextField();
		txtMontoAbonado.setDocument(new DocumentFilterLimit(10));
		gbcContenido.gridx = 1;
		gbcContenido.gridy = 1;
		gbcContenido.weightx = 0.5;
		gbcContenido.anchor = GridBagConstraints.CENTER;
		gbcContenido.fill = GridBagConstraints.HORIZONTAL;
		panelContenido.add(txtMontoAbonado, gbcContenido);
		
		lblVuelto = new JLabel("Vuelto a entregar");
        gbcContenido.gridx = 2;
		gbcContenido.gridy = 1;
		gbcContenido.weightx = 0;
		gbcContenido.anchor = GridBagConstraints.WEST;
		gbcContenido.fill = GridBagConstraints.NONE;
		panelContenido.add(lblVuelto, gbcContenido);
		
		txtVuelto = new JTextField();
		txtVuelto.setEditable(false);
		gbcContenido.gridx = 3;
		gbcContenido.gridy = 1;
		gbcContenido.weightx = 0.5;
		gbcContenido.anchor = GridBagConstraints.CENTER;
		gbcContenido.fill = GridBagConstraints.HORIZONTAL;
		panelContenido.add(txtVuelto, gbcContenido);
		
		btnConfirmar = new JButton("Confirmar");
		gbcContenido.gridx = 4;
		gbcContenido.gridy = 2;
		gbcContenido.weightx = 1;
		gbcContenido.anchor = GridBagConstraints.EAST;
		gbcContenido.fill = GridBagConstraints.NONE;
		panelContenido.add(btnConfirmar, gbcContenido);
		btnConfirmar.addActionListener(e -> {
			//TODO: Hacer funcionamiento boton confirmar
		});
		
		btnCancelar = new JButton("Cancelar");
		gbcContenido.gridx = 5;
		gbcContenido.gridy = 2;
		gbcContenido.weightx = 0;
		gbcContenido.anchor = GridBagConstraints.CENTER;
		panelContenido.add(btnCancelar, gbcContenido);
		btnCancelar.addActionListener(e -> {
			String mensaje = "¿Deseas cancelar el registro de pago?";
			int confirmado = JOptionPane.showOptionDialog(this, mensaje, "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, new Object[] { "SI", "NO" }, "SI");
			if (confirmado == 0) {
				ventana.setTitle("Menú - Cobrador");
				ventana.setContentPane(panelMenu);
				ventana.setVisible(true);
			}
		});
	}
}