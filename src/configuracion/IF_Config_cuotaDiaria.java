package configuracion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import data.Datos;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IF_Config_cuotaDiaria extends JInternalFrame {
	private JTextField txtCuotaDiaria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IF_Config_cuotaDiaria frame = new IF_Config_cuotaDiaria();
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
	public IF_Config_cuotaDiaria() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Configurar cuota diaria");
		setBounds(100, 100, 476, 106);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cuota diaria esperada (S/)");
		lblNewLabel.setBounds(10, 32, 210, 14);
		getContentPane().add(lblNewLabel);
		
		txtCuotaDiaria = new JTextField();
		txtCuotaDiaria.setBounds(235, 29, 96, 20);
		getContentPane().add(txtCuotaDiaria);
		txtCuotaDiaria.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double cuota = Double.parseDouble(txtCuotaDiaria.getText());
				Datos.cuotaDiaria= cuota;
				mostrarMensaje("Se guardo la solicitud");
			}
		});
		btnGuardar.setBounds(367, 28, 89, 23);
		getContentPane().add(btnGuardar);
		obtenerCuotaDiaria();
	}
	public void obtenerCuotaDiaria() {
		txtCuotaDiaria.setText(Datos.cuotaDiaria+"");
	}
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

}
