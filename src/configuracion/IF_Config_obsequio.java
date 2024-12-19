package configuracion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import data.Datos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IF_Config_obsequio extends JInternalFrame {
	private JTextField txtObsequio1;
	private JTextField txtObsequio2;
	private JTextField txtObsequio3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IF_Config_obsequio frame = new IF_Config_obsequio();
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
	public IF_Config_obsequio() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Configurar Obsequios");
		setBounds(100, 100, 459, 304);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Configurar Obsequios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 423, 200);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("1 unidad");
		panel.add(lblNewLabel);
		
		txtObsequio1 = new JTextField();
		panel.add(txtObsequio1);
		txtObsequio1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("2 a 5 unidades");
		panel.add(lblNewLabel_1);
		
		txtObsequio2 = new JTextField();
		panel.add(txtObsequio2);
		txtObsequio2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("6 a m\u00E1s unidades");
		panel.add(lblNewLabel_2);
		
		txtObsequio3 = new JTextField();
		panel.add(txtObsequio3);
		txtObsequio3.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ob1,ob2,ob3;
				ob1= txtObsequio1.getText();
				ob2= txtObsequio2.getText();
				ob3= txtObsequio3.getText();
				
				Datos.obsequio1=ob1;
				Datos.obsequio2=ob2;
				Datos.obsequio3=ob3;
				mostrarMensaje("Se guardo la solicitud");
				
			}
		});
		btnGuardar.setBounds(10, 222, 215, 42);
		getContentPane().add(btnGuardar);
		obtenerConfigObsequios();
		
	}
	
	public void obtenerConfigObsequios() {
		txtObsequio1.setText(Datos.obsequio1);
		txtObsequio2.setText(Datos.obsequio2);
		txtObsequio3.setText(Datos.obsequio3);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	
	
	

}
