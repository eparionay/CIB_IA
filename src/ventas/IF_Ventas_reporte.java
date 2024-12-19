package ventas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import data.Datos;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;

public class IF_Ventas_reporte extends JInternalFrame {
	private JComboBox cboReporte;
	private JTextArea txtS;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IF_Ventas_reporte frame = new IF_Ventas_reporte();
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
	public IF_Ventas_reporte() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 759, 605);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REPORTE");
		lblNewLabel.setBounds(28, 27, 49, 14);
		getContentPane().add(lblNewLabel);
		
		cboReporte = new JComboBox();
		cboReporte.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int opcion = cboReporte.getSelectedIndex();	
				switch(opcion) {
					case 1: obtenerVentas(); break;
					case 2: obtenerVentaOptima(); break;
					case 3: obtenerPromedio(); break;
					case 4: obtenerPromedioMenorMayor(); break;
				}
			}
		});
		cboReporte.setBounds(110, 23, 509, 22);
		getContentPane().add(cboReporte);
		
		txtS = new JTextArea();
		txtS.setBounds(28, 72, 691, 493);
		getContentPane().add(txtS);
		cargarCombo();
	}

	private void cargarCombo() {
		cboReporte.addItem("Seleccione");
		cboReporte.addItem("Ventas por modelo");
		cboReporte.addItem("Ventas en relacion a la venta optima");
		cboReporte.addItem("Precios en relacion al precio promedio");
		cboReporte.addItem("Promedio, menores y mayores");
	}
	public void mostrarDatos(String cadena) {
		txtS.setText("");
		txtS.append(cadena);
	}
	
	private void obtenerVentas() {
		// VENTAS POR MODELO
		
		StringBuilder sb= new StringBuilder();
		sb.append("VENTAS POR MODELO\n");
		sb.append("\n");
		sb.append("Modelo                    :" + Datos.modelo0 + "\n");
		sb.append("Cantidad de Ventas        :" + Datos.cantidad_ventas_1 + "\n");
		sb.append("Cantidad Unidades Vendidas:" + Datos.cantidad_unidades_1 + "\n");
		sb.append("Importe Total vendido     :" + Datos.importe_vendido_1 + "\n");
		sb.append("Aporte a la cuota diaria  :" + porcentajeCuotaDiaria(Datos.importe_vendido_1) + "%\n");
		sb.append("\n");
		sb.append("Modelo                    :" + Datos.modelo1 + "\n");
		sb.append("Cantidad de Ventas        :" + Datos.cantidad_ventas_2 + "\n");
		sb.append("Cantidad Unidades Vendidas:" + Datos.cantidad_unidades_2 + "\n");
		sb.append("Importe Total vendido     :" + Datos.importe_vendido_2 + "\n");
		sb.append("Aporte a la cuota diaria  :" + porcentajeCuotaDiaria(Datos.importe_vendido_2) + "%\n");
		sb.append("\n");
		sb.append("Modelo                    :" + Datos.modelo2 + "\n");
		sb.append("Cantidad de Ventas        :" + Datos.cantidad_ventas_3 + "\n");
		sb.append("Cantidad Unidades Vendidas:" + Datos.cantidad_unidades_3 + "\n");
		sb.append("Importe Total vendido     :" + Datos.importe_vendido_3 + "\n");
		sb.append("Aporte a la cuota diaria  :" + porcentajeCuotaDiaria(Datos.importe_vendido_3) + "%\n");
		sb.append("\n");
		sb.append("Modelo                    :" + Datos.modelo3 + "\n");
		sb.append("Cantidad de Ventas        :" + Datos.cantidad_ventas_4 + "\n");
		sb.append("Cantidad Unidades Vendidas:" + Datos.cantidad_unidades_4 + "\n");
		sb.append("Importe Total vendido     :" + Datos.importe_vendido_4 + "\n");
		sb.append("Aporte a la cuota diaria  :" + porcentajeCuotaDiaria(Datos.importe_vendido_4) + "%\n");
		sb.append("\n");
		sb.append("Modelo                    :" + Datos.modelo4 + "\n");
		sb.append("Cantidad de Ventas        :" + Datos.cantidad_ventas_5 + "\n");
		sb.append("Cantidad Unidades Vendidas:" + Datos.cantidad_unidades_5 + "\n");
		sb.append("Importe Total vendido     :" + Datos.importe_vendido_5 + "\n");
		sb.append("Aporte a la cuota diaria  :" + porcentajeCuotaDiaria(Datos.importe_vendido_5) + "%\n");
		
		mostrarDatos(sb.toString());
		
	}
	
	private void obtenerVentaOptima() {
		StringBuilder sb= new StringBuilder();
		sb.append("VENTAS EN RELACIÓN A LA VENTA ÓPTIMA\n");
		sb.append("\n");
		
		
		sb.append("Modelo                        :" + Datos.modelo0 + "\n");
		sb.append("Cantidad de unidades vendidas :" + getTextoUnidadOptima(Datos.cantidad_unidades_1) + "\n");
		sb.append("\n");
		
		sb.append("Modelo                        :" + Datos.modelo1 + "\n");
		sb.append("Cantidad de unidades vendidas :" + getTextoUnidadOptima(Datos.cantidad_unidades_2) + "\n");
		sb.append("\n");
		
		sb.append("Modelo                        :" + Datos.modelo2 + "\n");
		sb.append("Cantidad de unidades vendidas :" + getTextoUnidadOptima(Datos.cantidad_unidades_3) + "\n");
		sb.append("\n");
		
		sb.append("Modelo                        :" + Datos.modelo3 + "\n");
		sb.append("Cantidad de unidades vendidas :" + getTextoUnidadOptima(Datos.cantidad_unidades_4) + "\n");
		sb.append("\n");
		
		sb.append("Modelo                        :" + Datos.modelo4 + "\n");
		sb.append("Cantidad de unidades vendidas :" + getTextoUnidadOptima(Datos.cantidad_unidades_5) + "\n");
		sb.append("\n");
		
		mostrarDatos(sb.toString());
	}
	
	private void obtenerPromedio() {
		
	    StringBuilder builder = new StringBuilder();
	    double promedio = obtenerPromedio(Datos.precio0, Datos.precio1, Datos.precio2, Datos.precio3, Datos.precio4);
	    
	    builder.append("Promedio :" + promedio + "\n" );
	    builder.append("**********************************\n");
	    builder.append("Modelo : " + Datos.modelo0 + "\n");
	    builder.append("Precio : " + Datos.precio0 +"-"+ obtenerPromedioSegunPrecio(Datos.precio0, promedio) + "\n");
	    builder.append("**********************************\n");
	    builder.append("Modelo : " + Datos.modelo1 + "\n");
	    builder.append("Precio : " + Datos.precio1 + "-"+ obtenerPromedioSegunPrecio(Datos.precio1, promedio) +"\n");
	    builder.append("**********************************\n");
	    builder.append("Modelo : " + Datos.modelo2 + "\n");
	    builder.append("Precio : " + Datos.precio2 + "-"+ obtenerPromedioSegunPrecio(Datos.precio2, promedio) +"\n");
	    builder.append("**********************************\n");
	    builder.append("Modelo : " + Datos.modelo3 + "\n");
	    builder.append("Precio : " + Datos.precio3 + "-"+ obtenerPromedioSegunPrecio(Datos.precio3, promedio) +"\n");
	    builder.append("**********************************\n");
	    builder.append("Modelo : " + Datos.modelo4 + "\n");
	    builder.append("Precio : " + Datos.precio4 + "-"+ obtenerPromedioSegunPrecio(Datos.precio4, promedio) +"\n");
	    builder.append("**********************************\n");
		
		String cadena = builder.toString();
		mostrarDatos(cadena);
	}
	
	
	private void obtenerPromedioMenorMayor() {
		
		StringBuilder sb= new StringBuilder();
		sb.append("PROMEDIOS, MENORES Y MAYORES\n");
		sb.append("\n");
		
		sb.append("Precio Promedio : " + obtenerPromedio(Datos.precio0, Datos.precio1, Datos.precio2, Datos.precio3, Datos.precio4)+"\n");
		sb.append("Precio Menor    : " + calcularMenor(Datos.precio0, Datos.precio1, Datos.precio2, Datos.precio3, Datos.precio4)+"\n");
		sb.append("Precio Mayor    : " + calcularMayor(Datos.precio0, Datos.precio1, Datos.precio2, Datos.precio3, Datos.precio4)+"\n");
		sb.append("\n");
		
		sb.append("Ancho Promedio : " + obtenerPromedio(Datos.ancho0, Datos.ancho1, Datos.ancho2, Datos.ancho3, Datos.ancho4)+"\n");
		sb.append("Ancho menor    : " + calcularMenor(Datos.ancho0, Datos.ancho1, Datos.ancho2, Datos.ancho3, Datos.ancho4)+"\n");
		sb.append("Ancho mayor    : " + calcularMayor(Datos.ancho0, Datos.ancho1, Datos.ancho2, Datos.ancho3, Datos.ancho4)+"\n");
	    sb.append("\n");
	    
	    sb.append("Alto Promedio : " + obtenerPromedio(Datos.alto0, Datos.alto1, Datos.alto2, Datos.alto3, Datos.alto4)+"\n");
		sb.append("Alto menor    : " + calcularMenor(Datos.alto0, Datos.alto1, Datos.alto2, Datos.alto3, Datos.alto4)+"\n");
		sb.append("Alto mayor    : " + calcularMayor(Datos.alto0, Datos.alto1, Datos.alto2, Datos.alto3, Datos.alto4)+"\n");
	    sb.append("\n");
	    
	    sb.append("Fondo Promedio : " + obtenerPromedio(Datos.fondo0, Datos.fondo1, Datos.fondo2, Datos.fondo3, Datos.fondo4)+"\n");
		sb.append("Fondo menor    : " + calcularMenor(Datos.fondo0, Datos.fondo1, Datos.fondo2, Datos.fondo3, Datos.fondo4)+"\n");
		sb.append("Fondo mayor    : " + calcularMayor(Datos.fondo0, Datos.fondo1, Datos.fondo2, Datos.fondo3, Datos.fondo4)+"\n");
	    sb.append("\n");
	    
		mostrarDatos(sb.toString());
		
	}	
	
	public String obtenerPromedioSegunPrecio(double precio, double promedio) {
		if (precio >= promedio) {
			return "(Mayor al promedio)";
		}else {
			return "(Menor al promedio)";
		}
	}
	
	
	public double obtenerPromedio(double v1, double v2, double v3, double v4, double v5) {
		return (v1+v2+v3+v4+v5)/ 5;
	}
	
	
	public double porcentajeCuotaDiaria(double monto) {
		return (monto *100.0)/Datos.cuotaDiaria;
	}
	
	public String getTextoUnidadOptima(int cantidad) {
		int cantidadOptima = Datos.cantidadOptima;
		String texto = "";
		if (cantidad== cantidadOptima) {
			texto = cantidad + " (igual a la cantidad óptima)";
		}else if(cantidad < cantidadOptima) {
			texto = cantidad + " ("+(cantidadOptima-cantidad)+"menos que la cantidad óptima)";
		}else {
			texto = cantidad + " ("+(cantidad-cantidadOptima)+"más que la cantidad óptima)";
		}
		return texto;
	}
	
	public double calcularMenor(double v1, double v2, double v3, double v4, double v5) {
		
		double []  arr_menor = new double[5];
		arr_menor[0] = v1;
		arr_menor[1] = v2;
		arr_menor[2] = v3;
		arr_menor[3] = v4;
		arr_menor[4] = v5;
		double menor= arr_menor[0];
		for(int i=0; i<arr_menor.length;i++) {
			if(menor>arr_menor[i]) {
				menor= arr_menor[i];
			}
		}
		return menor;
	}
	
	public double calcularMayor(double v1, double v2, double v3, double v4, double v5) {
		double []  arr_mayor = new double[5];
		arr_mayor[0] = v1;
		arr_mayor[1] = v2;
		arr_mayor[2] = v3;
		arr_mayor[3] = v4;
		arr_mayor[4] = v5;
		double mayor= arr_mayor[0];
		for(int i=0; i<arr_mayor.length;i++) {
			if(mayor<arr_mayor[i]) {
				mayor= arr_mayor[i];
			}
		}
		return mayor;
	}
	
}
