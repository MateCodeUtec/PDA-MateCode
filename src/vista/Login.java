package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.UsuarioControlador;
import modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtCorreo;
	private JPasswordField txtPass;

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/vista/assets/iconfrm.png")));
		setTitle("MateCode | Ingreso");
		setBounds(100, 100, 678, 385);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(0, 0, 334, 346);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnAceptar = new JButton("INGRESAR");
		btnAceptar.setBackground(new Color(102, 102, 102));
		btnAceptar.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnAceptar.setBounds(36, 241, 259, 31);
		panel.add(btnAceptar);

		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtPass.setBounds(36, 174, 259, 32);
		panel.add(txtPass);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblContrasea.setBounds(36, 154, 236, 23);
		panel.add(lblContrasea);

		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtCorreo.setBounds(36, 111, 259, 31);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);

		JLabel lblNewLabel = new JLabel("Correo electronico");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel.setBounds(36, 91, 236, 23);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Bienvenido");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 11, 314, 55);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/vista/assets/logoapp.png")));
		lblNewLabel_2.setBounds(410, 134, 194, 78);
		contentPane.add(lblNewLabel_2);
		txtPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				/*
				 * Se dispara cuando se apreta Enter en el campo de contrasena.
				 */
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}

			}
		});
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});

	}
	
	private void login() {
		String correo = txtCorreo.getText();
		String pass = txtPass.getText();

		Usuario login = UsuarioControlador.getInstancia().login(correo, pass);

		if (login != null) {
			Principal p = new Principal(login);
			p.setVisible(true);
			setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "Los datos ingresados son incorrectos.", "Login",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
