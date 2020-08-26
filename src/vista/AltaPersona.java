package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.RolControlador;
import controlador.UsuarioControlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import com.toedter.calendar.JDateChooser;

public class AltaPersona extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDoc;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtMail;
	private JPasswordField txtPass;
	private JComboBox cmbRol;

	/**
	 * Create the frame.
	 */
	public AltaPersona() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaPersona.class.getResource("/vista/assets/iconfrm.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 409, 445);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setTitle("MateCode | Alta de usuario");

		JLabel lblNewLabel = new JLabel("Documento");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(27, 116, 91, 14);
		contentPane.add(lblNewLabel);

		txtDoc = new JTextField();
		txtDoc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtDoc.setBounds(27, 131, 137, 27);
		contentPane.add(txtDoc);
		txtDoc.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(225, 116, 91, 14);
		contentPane.add(lblNewLabel_1);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtNombre.setColumns(10);
		txtNombre.setBounds(225, 131, 137, 27);
		contentPane.add(txtNombre);

		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(27, 170, 91, 14);
		contentPane.add(lblNewLabel_2);

		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtApellido.setColumns(10);
		txtApellido.setBounds(27, 186, 137, 27);
		contentPane.add(txtApellido);

		JLabel lblNewLabel_3 = new JLabel("Fecha de nacimiento");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(27, 223, 137, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("E-mail");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(225, 170, 91, 14);
		contentPane.add(lblNewLabel_4);

		txtMail = new JTextField();
		txtMail.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtMail.setColumns(10);
		txtMail.setBounds(225, 185, 137, 27);
		contentPane.add(txtMail);
		
		cmbRol = new JComboBox();
		cmbRol.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cmbRol.setBounds(225, 238, 137, 27);
		contentPane.add(cmbRol);
		comboRoles();
		
		JDateChooser dcFecha = new JDateChooser();
		dcFecha.setBounds(27, 238, 137, 27);
		contentPane.add(dcFecha);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnAceptar.setBackground(new Color(25, 25, 112));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String formato = "yyyy/MM/dd";
				//String formato = "dd/MM/yyyy";
				//Date f = dcFecha.getDate();
				//SimpleDateFormat sdf = new SimpleDateFormat(formato);

				// Se obtiene los datos del formulario
				String documento = txtDoc.getText();
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				String correo = txtMail.getText();
				//String fecha = sdf.format(f);
				Date fecha = dcFecha.getDate();
				String clave = txtPass.getText();
				modelo.Rol r = (modelo.Rol) cmbRol.getSelectedItem();
				
				String[] campos = { documento, nombre, apellido, correo, clave};
				
				// Se validan si los campos estan vacios
				if (!validarCampos(campos)) {
					JOptionPane.showMessageDialog(null, "Rellene todo los campos");
				} else {
					// Se llama al metood de agregar el controlador y se envian los datos
					boolean insertar = UsuarioControlador.getInstancia().insert(documento, apellido, nombre, fecha, clave, r.getId(), correo);
					// En caso que este devuelva true, es porque se agrego correcatamente a la base de datos
					if(insertar) {
						JOptionPane.showMessageDialog(null, "Se agrego un nuevo usuario", "Usuario agregado", JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "No se pudo agregar el usuario", "Error al agregar usuario", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnAceptar.setBounds(27, 351, 137, 27);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(220, 20, 60));
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(225, 351, 137, 27);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel_5 = new JLabel("Rol");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(225, 224, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(27, 276, 137, 14);
		contentPane.add(lblNewLabel_3_1);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtPass.setBounds(27, 294, 137, 27);
		contentPane.add(txtPass);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 0, 393, 94);
		contentPane.add(panel);
		
		JLabel lblAltaDeUsuario = new JLabel("Alta de usuario");
		lblAltaDeUsuario.setForeground(Color.BLACK);
		lblAltaDeUsuario.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblAltaDeUsuario.setBounds(22, 31, 183, 34);
		panel.add(lblAltaDeUsuario);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(AltaPersona.class.getResource("/vista/assets/user.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(304, 16, 75, 67);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(222, 102, 27, 23);
		panel.add(lblNewLabel_2_1);
		
	}
	
	/*
	 * @param String[] 
	 * @return boolean 
	 */
	public boolean validarCampos(String[] campos) {

		for (String s : campos) {
			if (s.isEmpty() || s.equals("")) {
				return false;
			}
		}

		return true;
	}
	
	
	/**
	 * Carga el combo de seleccionar roles
	 */
	public void comboRoles() {
		ArrayList<modelo.Rol> roles = RolControlador.getInstancia().obtenerTodos();
		
		for (modelo.Rol r : roles) {
			cmbRol.addItem(r);
		}
	}
}
