package configuracion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import data.Datos;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class IF_Config_descuento extends JInternalFrame {
	private JTextField txtDescuento1;
	private JTextField txtDescuento2;
	private JTextField txtDescuento3;
	private JTextField txtDescuento4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IF_Config_descuento frame = new IF_Config_descuento();
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
	public IF_Config_descuento() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Configurar Porcentaje de Descuentos");
		setBounds(100, 100, 672, 319);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Configurar Descuentos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 648, 217);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(4, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("1 a 5 unidades");
		panel.add(lblNewLabel);
		
		txtDescuento1 = new JTextField();
		panel.add(txtDescuento1);
		txtDescuento1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("%");
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("6 a 10 unidades");
		panel.add(lblNewLabel_2);
		
		txtDescuento2 = new JTextField();
		panel.add(txtDescuento2);
		txtDescuento2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("%");
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("11 a 15 unidades");
		panel.add(lblNewLabel_4);
		
		txtDescuento3 = new JTextField();
		panel.add(txtDescuento3);
		txtDescuento3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("%");
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("M\u00E1s de 15 unidades");
		panel.add(lblNewLabel_6);
		
		txtDescuento4 = new JTextField();
		panel.add(txtDescuento4);
		txtDescuento4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("%");
		panel.add(lblNewLabel_7);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double d1,d2,d3,d4;
				d1 = Double.parseDouble(txtDescuento1.getText());
				d2 = Double.parseDouble(txtDescuento2.getText());
				d3 = Double.parseDouble(txtDescuento3.getText());
				d4 = Double.parseDouble(txtDescuento4.getText());
				
				Datos.porcentaje1= d1;
				Datos.porcentaje2= d2;
				Datos.porcentaje3= d3;
				Datos.porcentaje4= d4;
				
				mostrarMensaje("Se guardo la solicitud");
				
			}
		});
		btnGuardar.setBounds(20, 239, 148, 45);
		getContentPane().add(btnGuardar);
		obtenerConfigDescuentos();
	}
	public void obtenerConfigDescuentos() {
		txtDescuento1.setText(Datos.porcentaje1+"");
		txtDescuento2.setText(Datos.porcentaje2+"");
		txtDescuento3.setText(Datos.porcentaje3+"");
		txtDescuento4.setText(Datos.porcentaje4+"");
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	
	
	
}
