package configuracion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import data.Datos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IF_Config_cantidadOptima extends JInternalFrame {
	private JTextField txtCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IF_Config_cantidadOptima frame = new IF_Config_cantidadOptima();
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
	public IF_Config_cantidadOptima() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Configurar cantidad \u00F3ptima");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 481, 103);
		getContentPane().setLayout(null);
		
		JLabel lblCantidad = new JLabel("Cantidad \u00F3ptima de unidades vendidas");
		lblCantidad.setBounds(10, 28, 245, 14);
		getContentPane().add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(265, 25, 89, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidad= Integer.parseInt(txtCantidad.getText());
				Datos.cantidadOptima= cantidad;
				mostrarMensaje("Se guardo la solicitud");
			}
		});
		btnGuardar.setBounds(373, 24, 89, 23);
		getContentPane().add(btnGuardar);
		obtenerCantidadOptima();
	}
	public void obtenerCantidadOptima() {
		txtCantidad.setText(Datos.cantidadOptima+"");
	}
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

}
