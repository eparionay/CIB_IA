package mantenimiento;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

import data.Datos;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class IF_Mantenimiento_listar extends JInternalFrame {
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IF_Mantenimiento_listar frame = new IF_Mantenimiento_listar();
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
	public IF_Mantenimiento_listar() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consultar Cocina");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 508, 375);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		cargarDatos();

	}
	
	public void cargarDatos() {
		
		StringBuilder sb= new StringBuilder();
		sb.append("Listado de Cocina \n");
		sb.append("\n");
		sb.append("Modelo     : " + Datos.modelo0 +"\n");
		sb.append("Precio     : " + Datos.precio0 +"\n");
		sb.append("Fondo      : " + Datos.fondo0 +"\n");
		sb.append("Ancho      : " + Datos.ancho0 +"\n");
		sb.append("Alto       : " + Datos.alto0 +"\n");
		sb.append("Quemadores : " + Datos.quemadores0 +"\n");
		sb.append("\n");
		sb.append("Modelo     : " + Datos.modelo1 +"\n");
		sb.append("Precio     : " + Datos.precio1 +"\n");
		sb.append("Fondo      : " + Datos.fondo1 +"\n");
		sb.append("Ancho      : " + Datos.ancho1 +"\n");
		sb.append("Alto       : " + Datos.alto1 +"\n");
		sb.append("Quemadores : " + Datos.quemadores1 +"\n");
		sb.append("\n");
		sb.append("Modelo     : " + Datos.modelo2 +"\n");
		sb.append("Precio     : " + Datos.precio2 +"\n");
		sb.append("Fondo      : " + Datos.fondo2 +"\n");
		sb.append("Ancho      : " + Datos.ancho2 +"\n");
		sb.append("Alto       : " + Datos.alto2 +"\n");
		sb.append("Quemadores : " + Datos.quemadores2 +"\n");
		sb.append("\n");
		sb.append("Modelo     : " + Datos.modelo3 +"\n");
		sb.append("Precio     : " + Datos.precio3 +"\n");
		sb.append("Fondo      : " + Datos.fondo3 +"\n");
		sb.append("Ancho      : " + Datos.ancho3 +"\n");
		sb.append("Alto       : " + Datos.alto3 +"\n");
		sb.append("Quemadores : " + Datos.quemadores3 +"\n");
		sb.append("\n");
		sb.append("Modelo     : " + Datos.modelo4 +"\n");
		sb.append("Precio     : " + Datos.precio4 +"\n");
		sb.append("Fondo      : " + Datos.fondo4 +"\n");
		sb.append("Ancho      : " + Datos.ancho4 +"\n");
		sb.append("Alto       : " + Datos.alto4 +"\n");
		sb.append("Quemadores : " + Datos.quemadores4 +"\n");
		
		mostrar(sb.toString());
		
	}
	
	
	public void mostrar(String mensaje) {
		txtS.setText(mensaje);
	}
	
	
	
	
	
	
	
	
}
