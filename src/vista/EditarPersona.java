package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.RolControlador;
import controlador.UsuarioControlador;
import modelo.Usuario;

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

public class EditarPersona extends JFrame {

	private JPanel contentPane;
	private JTextField txtDoc;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtMail;
	private JComboBox cmbRol;
	private JPasswordField txtClave;

	/**
	 * Create the frame.
	 */
	public EditarPersona(Usuario u) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditarPersona.class.getResource("/vista/assets/iconfrm.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 411, 434);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setTitle("MateCode | Editar usuario");

		JLabel lblNewLabel = new JLabel("Documento");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(30, 118, 91, 14);
		contentPane.add(lblNewLabel);

		txtDoc = new JTextField();
		txtDoc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtDoc.setEnabled(false);
		txtDoc.setEditable(false);
		txtDoc.setBounds(30, 132, 137, 27);
		contentPane.add(txtDoc);
		txtDoc.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(228, 119, 91, 14);
		contentPane.add(lblNewLabel_1);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtNombre.setColumns(10);
		txtNombre.setBounds(228, 133, 137, 27);
		contentPane.add(txtNombre);

		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(30, 171, 91, 14);
		contentPane.add(lblNewLabel_2);

		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtApellido.setColumns(10);
		txtApellido.setBounds(30, 185, 137, 27);
		contentPane.add(txtApellido);

		JLabel lblNewLabel_3 = new JLabel("Fecha de nacimiento");
		lblNewLabel_3.setBounds(30, 225, 137, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("E-mail");
		lblNewLabel_4.setBounds(228, 172, 91, 14);
		contentPane.add(lblNewLabel_4);

		txtMail = new JTextField();
		txtMail.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtMail.setColumns(10);
		txtMail.setBounds(228, 186, 137, 27);
		contentPane.add(txtMail);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(220, 20, 60));
		btnCancelar.setForeground(new Color(220, 20, 60));
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(228, 343, 137, 27);
		contentPane.add(btnCancelar);

		cmbRol = new JComboBox();
		cmbRol.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cmbRol.setBounds(228, 239, 137, 27);
		contentPane.add(cmbRol);
		comboRoles();
		
		JLabel lblNewLabel_5 = new JLabel("Rol");
		lblNewLabel_5.setBounds(228, 226, 45, 13);
		contentPane.add(lblNewLabel_5);
	
		
		JDateChooser dcFecha = new JDateChooser();
		dcFecha.setBounds(30, 239, 137, 27);
		contentPane.add(dcFecha);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(25, 25, 112));
		btnAceptar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Obtenemos los datos
				String documento = txtDoc.getText();
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				String correo = txtMail.getText();
				Date fecha = dcFecha.getDate();
				String clave = txtClave.getText();
				modelo.Rol r = (modelo.Rol) cmbRol.getSelectedItem();
				
				String[] campos = { documento, nombre, apellido, correo, clave};

				// Validamos que los campos no esten vacios
				if (!validarCampos(campos)) {
					JOptionPane.showMessageDialog(null, "Rellene todo los campos");
				} else {
					boolean editar = UsuarioControlador.getInstancia().actualizarUsuario(documento, apellido, nombre, fecha, clave, r.getId(), correo);
					if(editar) {
						JOptionPane.showMessageDialog(null, "El usuario se modifico correctamente", "Usuario agregado", JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario", "Error al modificar usuario", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnAceptar.setBounds(30, 343, 137, 27);
		contentPane.add(btnAceptar);
		
		txtClave = new JPasswordField();
		txtClave.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtClave.setBounds(30, 290, 137, 26);
		contentPane.add(txtClave);
		
		JLabel lblNewLabel_3_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_3_1.setBounds(30, 277, 137, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 0, 395, 94);
		contentPane.add(panel);
		
		JLabel lblAltaDeUsuario = new JLabel("Editar usuario");
		lblAltaDeUsuario.setForeground(Color.BLACK);
		lblAltaDeUsuario.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblAltaDeUsuario.setBounds(22, 31, 183, 34);
		panel.add(lblAltaDeUsuario);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(EditarPersona.class.getResource("/vista/assets/user.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(304, 16, 75, 67);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(222, 102, 27, 23);
		panel.add(lblNewLabel_2_1);
	
		// Completa los datos en el formulario con los datos actuales de la persona
		txtDoc.setText(u.getDocumento());
		txtNombre.setText(u.getNombre());
		txtApellido.setText(u.getApellido());
		txtMail.setText(u.getCorreo());
		selectedInCombo(u.getRol().getNombre());
		dcFecha.setDate(u.getFechaNacimiento());
	}
	
	/*
	 * Metodo que valida si los campos estan vacios
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
	
	/**
	 * Metodo para seleccionar un valor en el combobox automatico
	 * @param value
	 */
	public void selectedInCombo(String value) {
		modelo.Rol r = null;
		for (int i = 0; i < cmbRol.getItemCount(); i++) {
			r = (modelo.Rol) cmbRol.getItemAt(i);
			if(r.getNombre().equals(value)) {
				cmbRol.setSelectedIndex(i);
				break;
			}
		}
	}
}
