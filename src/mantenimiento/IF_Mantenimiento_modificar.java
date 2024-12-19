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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IF_Mantenimiento_modificar extends JInternalFrame {
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JTextField txtQuemadores;
	private JComboBox cboModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IF_Mantenimiento_modificar frame = new IF_Mantenimiento_modificar();
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
	public IF_Mantenimiento_modificar() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Modificar Cocina");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 508, 452);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos de Cocina", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(10, 11, 480, 317);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Modelo");
		panel.add(lblNewLabel);
		
		cboModelo = new JComboBox();
		cboModelo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int opcion = cboModelo.getSelectedIndex();
				
				double precio=0, ancho=0, alto=0, fondo=0;
				int quemadores=0;
				
				switch(opcion) {
				case 0:
					 break;
				case 1:
					precio = Datos.precio0;
					ancho = Datos.ancho0;
					alto = Datos.alto0;
					fondo = Datos.fondo0;
					quemadores= Datos.quemadores0;
					break;
				case 2:
					precio = Datos.precio1;
					ancho = Datos.ancho1;
					alto = Datos.alto1;
					fondo = Datos.fondo1;
					quemadores= Datos.quemadores1;
					break;
				case 3:
					precio = Datos.precio2;
					ancho = Datos.ancho2;
					alto = Datos.alto2;
					fondo = Datos.fondo2;
					quemadores= Datos.quemadores2;
					break;
					
				case 4:
					precio = Datos.precio3;
					ancho = Datos.ancho3;
					alto = Datos.alto3;
					fondo = Datos.fondo3;
					quemadores= Datos.quemadores3;
					break;
				case 5:
					precio = Datos.precio4;
					ancho = Datos.ancho4;
					alto = Datos.alto4;
					fondo = Datos.fondo4;
					quemadores= Datos.quemadores4;
					break;
				}
				
				txtPrecio.setText(precio+"");
				txtAncho.setText(ancho+"");
				txtAlto.setText(alto+"");
				txtFondo.setText(fondo+"");
				txtQuemadores.setText(quemadores+"");
				
				
				
			}
		});
		panel.add(cboModelo);
		
		JLabel lblNewLabel_1 = new JLabel("Precio");
		panel.add(lblNewLabel_1);
		
		txtPrecio = new JTextField();
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ancho");
		panel.add(lblNewLabel_2);
		
		txtAncho = new JTextField();
		panel.add(txtAncho);
		txtAncho.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Alto");
		panel.add(lblNewLabel_3);
		
		txtAlto = new JTextField();
		panel.add(txtAlto);
		txtAlto.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fondo");
		panel.add(lblNewLabel_4);
		
		txtFondo = new JTextField();
		panel.add(txtFondo);
		txtFondo.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Quemadores");
		panel.add(lblNewLabel_5);
		
		txtQuemadores = new JTextField();
		panel.add(txtQuemadores);
		txtQuemadores.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Obtener el indice del combo
				int opcion = cboModelo.getSelectedIndex();
				
				double precio = Double.parseDouble(txtPrecio.getText());
				double ancho = Double.parseDouble(txtAncho.getText());
				double alto = Double.parseDouble(txtAlto.getText());
				double fondo = Double.parseDouble(txtFondo.getText());
				int quemador = Integer.parseInt(txtQuemadores.getText());
				
				
				switch(opcion) {
				case 0: break;
				case 1:
					Datos.precio0 = precio;
					Datos.ancho0 = ancho;
					Datos.alto0 = alto;
					Datos.fondo0 = fondo;
					Datos.quemadores0= quemador;
					break;
				case 2:
					Datos.precio1 = precio;
					Datos.ancho1 = ancho;
					Datos.alto1 = alto;
					Datos.fondo1 = fondo;
					Datos.quemadores1= quemador;
					break;
				
				case 3:
					Datos.precio2 = precio;
					Datos.ancho2 = ancho;
					Datos.alto2 = alto;
					Datos.fondo2 = fondo;
					Datos.quemadores2= quemador;
					break;
				
				}
				
			
				mostrarMensaje("Se guardo la solicitud");
				
				
				
			}
		});
		btnGuardar.setBounds(10, 339, 480, 66);
		getContentPane().add(btnGuardar);
		cargarCombo();
	}
	private void cargarCombo() {
		
		cboModelo.addItem("Seleccione");
		cboModelo.addItem(Datos.modelo0);
		cboModelo.addItem(Datos.modelo1);
		cboModelo.addItem(Datos.modelo2);
		cboModelo.addItem(Datos.modelo3);
		cboModelo.addItem(Datos.modelo4);
		
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	
	
	
	
	
	
}
