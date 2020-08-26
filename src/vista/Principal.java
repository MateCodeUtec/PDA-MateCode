package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Principal(Usuario u) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/vista/assets/iconfrm.png")));
		setTitle("MateCode | Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 398);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnPersona = new JButton("");
		btnPersona.setIcon(new ImageIcon(Principal.class.getResource("/vista/assets/user.png")));
		btnPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persona p = new Persona();
				p.setVisible(true);
			}
		});
		btnPersona.setBounds(87, 178, 125, 94);
		contentPane.add(btnPersona);
		
		JButton btnRol = new JButton("");
		btnRol.setIcon(new ImageIcon(Principal.class.getResource("/vista/assets/rol.png")));
		btnRol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Roles r = new Roles();
				r.setVisible(true);
				
			}
		});
		btnRol.setBounds(412, 178, 125, 94);
		contentPane.add(btnRol);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 0, 626, 131);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inicio");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(31, 35, 249, 34);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/vista/assets/logoappsinfondo.png")));
		lblNewLabel_1.setBounds(383, 35, 194, 51);
		panel.add(lblNewLabel_1);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setForeground(new Color(105, 105, 105));
		lblBienvenido.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblBienvenido.setBounds(31, 63, 249, 34);
		panel.add(lblBienvenido);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setHorizontalAlignment(SwingConstants.CENTER);
		lblRol.setForeground(new Color(0, 0, 0));
		lblRol.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblRol.setBounds(412, 272, 125, 34);
		contentPane.add(lblRol);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblUsuario.setBounds(87, 272, 125, 34);
		contentPane.add(lblUsuario);
		
		lblBienvenido.setText("Bienvenido: " + u.getNombre() + " " + u.getApellido());
		
		JLabel lblFuncionalidad = new JLabel("Funcionalidad");
		lblFuncionalidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuncionalidad.setForeground(Color.BLACK);
		lblFuncionalidad.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblFuncionalidad.setBounds(249, 272, 125, 34);
		contentPane.add(lblFuncionalidad);
		
		JButton btnFuncionalidad = new JButton("");
		btnFuncionalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionalidades frame = new Funcionalidades();
				frame.setVisible(true);
			}
		});
		btnFuncionalidad.setIcon(new ImageIcon(Principal.class.getResource("/vista/assets/cerebro.png")));
		btnFuncionalidad.setBounds(249, 178, 125, 94);
		contentPane.add(btnFuncionalidad);
	}
}
