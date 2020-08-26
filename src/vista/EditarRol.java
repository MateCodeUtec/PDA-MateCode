package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controlador.RolControlador;
import modelo.Rol;

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

public class EditarRol extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;

	/**
	 * Create the frame.
	 */
	public EditarRol(Rol r) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditarRol.class.getResource("/vista/assets/iconfrm.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 414, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Editar rol");
		setLocationRelativeTo(null);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtNombre.setBounds(22, 132, 348, 30);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JTextArea taDescripcion = new JTextArea();
		taDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		taDescripcion.setBounds(22, 206, 348, 94);
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
					JOptionPane.showMessageDialog(null, "Complete todos los campos", "Error editar rol", JOptionPane.ERROR_MESSAGE);
				}else {
					boolean alta = RolControlador.getInstancia().actualizar(r.getId(), nombre, descripcion);
					if (alta) {
						JOptionPane.showMessageDialog(null, "El rol se modifico correctamente", "Editar rol", JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Error al editar el rol", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton.setBounds(22, 335, 154, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(22, 118, 85, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(22, 191, 136, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(220, 20, 60));
		btnCancelar.setForeground(new Color(220, 20, 60));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCancelar.setBounds(229, 335, 142, 30);
		contentPane.add(btnCancelar);
		
		// Completar los datos
		txtNombre.setText(r.getNombre());
		taDescripcion.setText(r.getDescripcion());
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 0, 398, 94);
		contentPane.add(panel);
		
		JLabel lblEditarRol = new JLabel("Editar rol");
		lblEditarRol.setForeground(Color.BLACK);
		lblEditarRol.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblEditarRol.setBounds(22, 31, 183, 34);
		panel.add(lblEditarRol);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(EditarRol.class.getResource("/vista/assets/rol.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(304, 16, 75, 67);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(222, 102, 27, 23);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblId = new JLabel("");
		lblId.setBounds(20, 311, 46, 14);
		contentPane.add(lblId);
		
		lblId.setText(String.valueOf(r.getId()));
		lblId.setVisible(false);
	}
}