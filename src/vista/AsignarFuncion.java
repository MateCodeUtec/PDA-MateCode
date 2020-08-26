package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controlador.AsignarControlador;
import controlador.FuncionalidadControlador;
import modelo.Funcionalidad;
import modelo.Rol;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class AsignarFuncion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JComboBox cbFuncionalidad;

	/**
	 * Create the frame.
	 */
	public AsignarFuncion(Rol r) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AsignarFuncion.class.getResource("/vista/assets/iconfrm.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 409, 347);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Asignar funcionalidad");
		setLocationRelativeTo(null);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setEditable(false);
		txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtNombre.setBounds(34, 136, 320, 30);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
        Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
		
		cbFuncionalidad = new JComboBox();
		cbFuncionalidad.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cbFuncionalidad.setBounds(34, 196, 320, 30);
		contentPane.add(cbFuncionalidad);
		comboRoles();
        
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionalidad f = (Funcionalidad) cbFuncionalidad.getSelectedItem();
				boolean asignar = AsignarControlador.getInstancia().asignarFuncion(r.getNombre(), f.getNombre());
				
				if(asignar) {
					JOptionPane.showMessageDialog(null, "Se asigno la funcionalidad", "Asignar funcionalidad", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Error al asignar", "Asignar funcionalidad", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton.setBounds(34, 264, 136, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Rol");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(34, 121, 85, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Funcionalidad");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(34, 180, 136, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(165, 42, 42));
		btnCancelar.setBackground(new Color(165, 42, 42));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCancelar.setBounds(226, 264, 128, 30);
		contentPane.add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 0, 393, 94);
		contentPane.add(panel);
		
		JLabel lblAltaDeRol = new JLabel("Asignar funcionalidad");
		lblAltaDeRol.setForeground(Color.BLACK);
		lblAltaDeRol.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblAltaDeRol.setBounds(22, 31, 227, 34);
		panel.add(lblAltaDeRol);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(AsignarFuncion.class.getResource("/vista/assets/rol.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(247, 11, 75, 67);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(222, 102, 27, 23);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(AsignarFuncion.class.getResource("/vista/assets/cerebro.png")));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(308, 11, 75, 67);
		panel.add(lblNewLabel_1_1_1);
		
		txtNombre.setText(r.getNombre());
	}
	
	/**
	 * Carga el combo de seleccionar roles
	 */
	public void comboRoles() {
		ArrayList<Funcionalidad> funcionalidades = FuncionalidadControlador.getInstancia().obtenerTodos();
		
		for (Funcionalidad f : funcionalidades) {
			cbFuncionalidad.addItem(f);
		}
	}
}