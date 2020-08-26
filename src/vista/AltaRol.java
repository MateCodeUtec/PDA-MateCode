package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controlador.RolControlador;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class AltaRol extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;

	/**
	 * Create the frame.
	 */
	public AltaRol() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaRol.class.getResource("/vista/assets/iconfrm.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 409, 402);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Alta de roles");
		setLocationRelativeTo(null);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtNombre.setBounds(34, 136, 320, 30);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JTextArea taDescripcion = new JTextArea();
		taDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		taDescripcion.setBounds(34, 193, 320, 94);
		
        Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
        
        // set the border of this component
        taDescripcion.setBorder(border);
		contentPane.add(taDescripcion);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtenemos los datos 
				String nombre = txtNombre.getText();
				String descripcion = taDescripcion.getText();

				// Preguntamos si los campos estan vacios
				if (nombre.isEmpty() || descripcion.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Complete todos los campos", "Error alta de rol", JOptionPane.ERROR_MESSAGE);
				}else {
					boolean alta = RolControlador.getInstancia().insertar(nombre, descripcion);
					if (alta) {
						JOptionPane.showMessageDialog(null, "El rol se agrego correctamente", "Alta de rol", JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Error al insertar el rol", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton.setBounds(34, 316, 136, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(34, 121, 85, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion");
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
		btnCancelar.setBounds(226, 316, 128, 30);
		contentPane.add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 0, 393, 94);
		contentPane.add(panel);
		
		JLabel lblAltaDeRol = new JLabel("Alta de rol");
		lblAltaDeRol.setForeground(Color.BLACK);
		lblAltaDeRol.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblAltaDeRol.setBounds(22, 31, 183, 34);
		panel.add(lblAltaDeRol);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(AltaRol.class.getResource("/vista/assets/rol.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(304, 16, 75, 67);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(222, 102, 27, 23);
		panel.add(lblNewLabel_2_1);
	}
}