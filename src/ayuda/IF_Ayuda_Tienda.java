package ayuda;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JFrame;

public class IF_Ayuda_Tienda extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IF_Ayuda_Tienda frame = new IF_Ayuda_Tienda();
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
	public IF_Ayuda_Tienda() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ayuda");
		setBounds(100, 100, 524, 345);
		getContentPane().setLayout(null);
		
		JLabel lblTienda = new JLabel("TIENDA 1.0");
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblTienda.setBounds(167, 27, 189, 41);
		getContentPane().add(lblTienda);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(49, 82, 432, 2);
		getContentPane().add(separator);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAutor.setBounds(215, 106, 80, 22);
		getContentPane().add(lblAutor);
		
		JLabel lblNombreAutor = new JLabel("Katerine Tatiana Guillen Huaman");
		lblNombreAutor.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNombreAutor.setBounds(20, 181, 484, 41);
		getContentPane().add(lblNombreAutor);
		
	}
}
