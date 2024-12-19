package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ayuda.IF_Ayuda_Tienda;
import configuracion.IF_Config_cantidadOptima;
import configuracion.IF_Config_cuotaDiaria;
import configuracion.IF_Config_descuento;
import configuracion.IF_Config_obsequio;
import mantenimiento.IF_Mantenimiento_consultar;
import mantenimiento.IF_Mantenimiento_listar;
import mantenimiento.IF_Mantenimiento_modificar;
import ventas.IF_Ventas_reporte;
import ventas.IF_Ventas_vender;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioPrincipal extends JFrame {

	private JPanel contentPane;
	IF_Ayuda_Tienda if_ayuda_tienda = new IF_Ayuda_Tienda();
	IF_Mantenimiento_consultar if_mantenimiento_consultar = new IF_Mantenimiento_consultar();
	IF_Mantenimiento_modificar if_mantenimiento_modificar = new IF_Mantenimiento_modificar();
	IF_Mantenimiento_listar  if_mantenimiento_listar= new IF_Mantenimiento_listar();
	IF_Ventas_vender if_ventas_vender= new IF_Ventas_vender();
	IF_Ventas_reporte if_ventas_reporte= new IF_Ventas_reporte();
	IF_Config_cantidadOptima if_config_cantidadOptima = new IF_Config_cantidadOptima();
	IF_Config_cuotaDiaria if_config_cuotaDiaria = new IF_Config_cuotaDiaria();
	IF_Config_descuento  if_config_descuento = new IF_Config_descuento();
	IF_Config_obsequio if_config_obsequio= new IF_Config_obsequio();
	
	private JDesktopPane escritorio;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioPrincipal frame = new FormularioPrincipal();
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
	public FormularioPrincipal() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Salir");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcion = JOptionPane.showConfirmDialog(null, "Deseas salir al sistema?"," Sistema de Ventas",JOptionPane.YES_NO_OPTION);
				
				if (opcion == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Mantenimiento");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mnManConsultar = new JMenuItem("Consultar cocina");
		mnManConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPosicion(escritorio, if_mantenimiento_consultar);
				if_mantenimiento_consultar.setVisible(true);
				
			}
		});
		mnNewMenu_1.add(mnManConsultar);
		
		JMenuItem mnManModificar = new JMenuItem("Modificar cocina");
		mnManModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modificarPosicion(escritorio, if_mantenimiento_modificar);
				if_mantenimiento_modificar.setVisible(true);
			}
		});
		mnNewMenu_1.add(mnManModificar);
		
		JMenuItem mnManListar = new JMenuItem("Listar cocinas");
		mnManListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modificarPosicion(escritorio, if_mantenimiento_listar);
				if_mantenimiento_listar.setVisible(true);
			}
		});
		mnNewMenu_1.add(mnManListar);
		
		JMenu mnNewMenu_2 = new JMenu("Ventas");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mnVentas = new JMenuItem("Vender");
		mnVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPosicion(escritorio, if_ventas_vender);
				if_ventas_vender.setVisible(true);
			}
		});
		mnNewMenu_2.add(mnVentas);
		
		JMenuItem mnGenerarReportes = new JMenuItem("Generar reportes");
		mnGenerarReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPosicion(escritorio, if_ventas_reporte);
				if_ventas_reporte.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mnGenerarReportes);
		
		JMenu mnNewMenu_3 = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mnConfigDescuento = new JMenuItem("Configurar descuentos");
		mnConfigDescuento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPosicion(escritorio, if_config_descuento);
				if_config_descuento.setVisible(true);
			}
		});
		mnNewMenu_3.add(mnConfigDescuento);
		
		JMenuItem mnConfigObsequio = new JMenuItem("Configurar obsequios");
		mnConfigObsequio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPosicion(escritorio, if_config_obsequio);
				if_config_obsequio.setVisible(true);
			}
		});
		mnNewMenu_3.add(mnConfigObsequio);
		
		JMenuItem mnConfigCantOptima = new JMenuItem("Configurar cantidad \u00F3ptima");
		mnConfigCantOptima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPosicion(escritorio, if_config_cantidadOptima);
				if_config_cantidadOptima.setVisible(true);
				
			}
		});
		mnNewMenu_3.add(mnConfigCantOptima);
		
		JMenuItem mnConfigCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mnConfigCuotaDiaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPosicion(escritorio, if_config_cuotaDiaria);
				if_config_cuotaDiaria.setVisible(true);
			}
		});
		mnNewMenu_3.add(mnConfigCuotaDiaria);
		
		JMenu mnNewMenu_4 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mnAyudaAcerca = new JMenuItem("Acerca de tienda");
		mnAyudaAcerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modificarPosicion(escritorio, if_ayuda_tienda);
				if_ayuda_tienda.setVisible(true);
			}
		});
		mnNewMenu_4.add(mnAyudaAcerca);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		escritorio = new JDesktopPane();
		contentPane.add(escritorio, BorderLayout.CENTER);
		escritorio.add(if_ayuda_tienda);
		escritorio.add(if_mantenimiento_consultar);
		escritorio.add(if_mantenimiento_modificar);
		escritorio.add(if_mantenimiento_listar);
		// Agregando formularios de configuracion
		escritorio.add(if_config_cantidadOptima);
		escritorio.add(if_config_cuotaDiaria);
		escritorio.add(if_config_descuento);
		escritorio.add(if_config_obsequio);
		escritorio.add(if_ventas_reporte);
		escritorio.add(if_ventas_vender);
		
		setExtendedState(MAXIMIZED_BOTH);
		
	}
	
	public void modificarPosicion(JDesktopPane escritorio, JInternalFrame internal) {
		Dimension dim_escritorio = escritorio.getSize();
		Dimension dim_internal = internal.getSize();
		internal.setLocation((dim_escritorio.width - dim_internal.width)/2, (dim_escritorio.height- dim_internal.height)/2);
	}
	
}
