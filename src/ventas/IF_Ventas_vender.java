package ventas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import data.Datos;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class IF_Ventas_vender extends JInternalFrame {
	private JTextArea txtS;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JComboBox cboModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IF_Ventas_vender frame = new IF_Ventas_vender();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IF_Ventas_vender() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 720, 542);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Formulario de Venta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 428, 180);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Modelo");
		panel.add(lblNewLabel);
		
		cboModelo = new JComboBox();
		cboModelo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				int codigo = leerModelo();
				txtPrecio.setText(obtenerPrecio(codigo)+"");
			}
		});
		panel.add(cboModelo);
		
		JLabel lblNewLabel_1 = new JLabel("Precio ");
		panel.add(lblNewLabel_1);
		
		txtPrecio = new JTextField();
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad");
		panel.add(lblNewLabel_2);
		
		txtCantidad = new JTextField();
		panel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(469, 11, 200, 180);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesar();
			}
		});
		panel_1.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPrecio.setText("");
				txtCantidad.setText("");
				cboModelo.setSelectedIndex(0);
			}
		});
		panel_1.add(btnCancelar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Resultado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 232, 657, 248);
		getContentPane().add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		cargarCombo();
		txtPrecio.setEditable(false);
	}
	private void cargarCombo() {
		
		cboModelo.addItem(Datos.modelo0);
		cboModelo.addItem(Datos.modelo1);
		cboModelo.addItem(Datos.modelo2);
		cboModelo.addItem(Datos.modelo3);
		cboModelo.addItem(Datos.modelo4);
	}
	
	
	public void procesar() {
		
		int modelo = leerModelo();
		int cantidad= leerCantidad();
		
		double precio = obtenerPrecio(modelo);
		double importeCompra =calcularImporteCompra(cantidad,precio);
		double descuento = calcularImporteDescuento(importeCompra, cantidad);
		double importePagar = calcularImportePagar(importeCompra, descuento);
		String regalo = obtenerObsequio(cantidad);
		
		
		int numeroVenta = obtenerNumeroVenta(modelo);
		modificarNumeroVenta(modelo, numeroVenta+1);
		modificarCantidadVenta(modelo, cantidad);
		modificarImporteVendido(modelo, importePagar);
		modificarMontoTotal(importePagar);
		
		int cantidadVentaActual = obtenerNumeroVentaTotal() + 1;
		modificarNumeroVentaTotal(cantidadVentaActual);
		
		StringBuilder sb = new StringBuilder();
		sb.append("Modelo            : " + obtenerModeloxCodigo(modelo) + "\n");
		sb.append("Precio            : " + precio + "\n");
		sb.append("Cantidad          : " + cantidad + "\n");
		sb.append("Importe Compra    : " + importeCompra + "\n");
		sb.append("Importe Descuento : " + descuento + "\n");
		sb.append("Importe Pagar     : " + importePagar + "\n");
		sb.append("Obsequio          : " + regalo + "\n");
	
		mostrar(sb.toString());
		if (cantidadVentaActual%5==0) {
			mostrarAlertaVenta(cantidadVentaActual);
		}
		
		mostrarMensaje("Se realizo la venta");
		
		
	}
	
	public void mostrar(String mensaje) {
		txtS.setText(mensaje);
	}
	
	public int leerModelo() {
		return cboModelo.getSelectedIndex();
	}
	
	public double obtenerPrecio(int codigo) {
		double precio=0;
		switch(codigo) {
			case 0: precio= Datos.precio0; break;
			case 1: precio= Datos.precio1; break;
			case 2: precio= Datos.precio2; break;
			case 3: precio= Datos.precio3; break;
			case 4: precio= Datos.precio4; break;
		}
		return precio;
	}
	
	public String obtenerModeloxCodigo(int codigo) {
		String modelo="";
		switch(codigo) {
			case 0: modelo= Datos.modelo0; break;
			case 1: modelo= Datos.modelo1; break;
			case 2: modelo= Datos.modelo2; break;
			case 3: modelo= Datos.modelo3; break;
			case 4: modelo= Datos.modelo4; break;
		}
		return modelo;
	}
	
	public int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	public double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
	
	public double calcularImporteCompra(int cantidad, double precio) {
		return cantidad*precio;
	}
	public double calcularImporteDescuento(double importeCompra, int cantidad) {
		double descuento;
		if (cantidad<=5) {
			descuento = importeCompra * (Datos.porcentaje1/100);
		}else if (cantidad <=10) {
			descuento = importeCompra * (Datos.porcentaje2/100);
		}else if(cantidad<=15) {
			descuento = importeCompra * (Datos.porcentaje3/100);
		}else {
			descuento = importeCompra * (Datos.porcentaje4/100);
		}
	
		return descuento;
	}
	public double calcularImportePagar(double ic, double descuento) {
		return ic - descuento;
	}
	public String obtenerObsequio(int cantidad) {
		String regalo;
		
		if (cantidad == 1) {
			regalo= Datos.obsequio1;
		}else if (cantidad<=5) {
			regalo = Datos.obsequio2;
		}else {
			regalo = Datos.obsequio3;
		}
		return regalo;
	}
	
	
	
	public int obtenerNumeroVenta(int modelo) {
		int numero=0;
		switch(modelo) {
			case 0: numero= Datos.cantidad_ventas_1; break;
			case 1: numero= Datos.cantidad_ventas_2; break;
			case 2: numero= Datos.cantidad_ventas_3; break;
			case 3: numero= Datos.cantidad_ventas_4; break;
			case 4: numero= Datos.cantidad_ventas_5; break;
		}
		return numero;
	}
	
	public void modificarNumeroVenta(int modelo, int cantidad) {
		switch(modelo) {
			case 0: Datos.cantidad_ventas_1=cantidad; break;
			case 1: Datos.cantidad_ventas_2=cantidad; break;
			case 2: Datos.cantidad_ventas_3=cantidad; break;
			case 3: Datos.cantidad_ventas_4=cantidad; break;
			case 4: Datos.cantidad_ventas_5=cantidad; break;
		}
	}
	
	public void modificarCantidadVenta(int modelo, int cantidad) {
		switch(modelo) {
		case 0: Datos.cantidad_unidades_1+=cantidad; break;
		case 1: Datos.cantidad_unidades_2+=cantidad; break;
		case 2: Datos.cantidad_unidades_3+=cantidad; break;
		case 3: Datos.cantidad_unidades_4+=cantidad; break;
		case 4: Datos.cantidad_unidades_5+=cantidad; break;
		}
	}
	
	public void modificarImporteVendido(int modelo, double monto) {
		switch(modelo) {
		case 0: Datos.importe_vendido_1+=monto; break;
		case 1: Datos.importe_vendido_2+=monto; break;
		case 2: Datos.importe_vendido_3+=monto; break;
		case 3: Datos.importe_vendido_4+=monto; break;
		case 4: Datos.importe_vendido_5+=monto; break;
		}
	}
	
	public void modificarMontoTotal(double monto) {
		Datos.importe_total_vendido += monto;
	}
	
	public double obtenerCuotaDiaria() {
		return Datos.cuotaDiaria;
	}
	
	public int obtenerNumeroVentaTotal() {
		return Datos.numero_ventas_total;
	}
	
	
	public void modificarNumeroVentaTotal(int cantidad) {
		Datos.numero_ventas_total=cantidad;
	}
	
	public void mostrarAlertaVenta(int cantidadVentaActual) {
		
		double importeTotal = Datos.importe_total_vendido;
		double porcentajeCuota = (importeTotal *100.0)/Datos.cuotaDiaria;
		
		StringBuilder sb= new StringBuilder();
		sb.append("Venta Nro         : "+ cantidadVentaActual  + "\n");
		sb.append("Importe Acumulado : S/."+ importeTotal  + "\n");
		sb.append("Porcentaje Cuota  : "+ porcentajeCuota  + "% \n");
		JOptionPane.showMessageDialog(null, sb.toString());
		
	}
	
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
