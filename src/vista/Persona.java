package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.UsuarioControlador;
import modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import java.awt.Toolkit;

public class Persona extends JFrame {

	private JPanel contentPane;
	private JTable table_personas;

	/**
	 * Create the frame.
	 */
	public Persona() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Persona.class.getResource("/vista/assets/iconfrm.png")));
		setTitle("MateCode | Usuarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 122, 584, 240);
		contentPane.add(scrollPane);
		
		table_personas = new JTable();
		table_personas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_personas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrollPane.setViewportView(table_personas);
		table_personas.getTableHeader().setReorderingAllowed(false);
		table_personas.setModel(new DefaultTableModel(
			new Object[][] {
					
			},
			new String[] {
				"Documento", "Nombre", "2\u00B0 Apellido", "Correo", "2\u00B0 Nacimiento"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_personas.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));

		scrollPane.setViewportView(table_personas);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, -3, 584, 125);
		contentPane.add(panel);
		
		JLabel lblUsaurios = new JLabel("Usuarios");
		lblUsaurios.setForeground(Color.BLACK);
		lblUsaurios.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblUsaurios.setBounds(22, 31, 94, 34);
		panel.add(lblUsaurios);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Persona.class.getResource("/vista/assets/user.png")));
		lblNewLabel_1.setBounds(458, 24, 75, 67);
		panel.add(lblNewLabel_1);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(Persona.class.getResource("/vista/assets/delete.png")));
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnEliminar.setBounds(117, 102, 94, 23);
		panel.add(btnEliminar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(Persona.class.getResource("/vista/assets/edit.png")));
		btnEditar.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnEditar.setBounds(22, 102, 94, 23);
		panel.add(btnEditar);
		
		JLabel lblNewLabel = new JLabel("Agregar nuevo");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AltaPersona ap = new AltaPersona();
				ap.setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel.setForeground(new Color(65, 105, 225));
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel.setBounds(22, 68, 145, 23);
		panel.add(lblNewLabel);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Obtenemos la fila seleccionada
				int row = table_personas.getSelectedRow();
				
				// Comprobamos que la fila este seleccionada
				if(row >= 0) {
					// Obtenemos el documento de la tabla
					String documento = table_personas.getModel().getValueAt(row, 0).toString();
					
					// Obtenemos el usuario, en caso que exista pasamos estos datos al frame de editar para poder mostrar los datos actuales
					// del usuario en la ventana. 
					Usuario u = UsuarioControlador.getInstancia().obtenerUsuarioPorDoc(documento);
					
					EditarPersona frame = new EditarPersona(u);
					frame.setVisible(true);
					setVisible(false);
				}else {
            		JOptionPane.showMessageDialog(null,"Usted debe seleccionar el usuario que desea editar", "Editar usuario", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtiene el número de la fila seleccionada
				int row = table_personas.getSelectedRow(); 
				
				// Comprobamos que se seleccione una fila
				if(row >= 0) {
					// Obtiene el valor de la celda 0 de la fila seleccionada
					String documento = table_personas.getModel().getValueAt(row, 0).toString(); 
		
					// Preguntamos si quiere eliminar a la persona
			        int pregunta = JOptionPane.showConfirmDialog(null,"¿Seguro que quieres eliminar este usuario?", "Eliminar usuario", JOptionPane.YES_NO_OPTION);
			        
			        // Si la opcion es "YES" entonces llamamos al metodo del controlador de eliminar
		            if(pregunta == JOptionPane.YES_OPTION){
		            	// Obtenemos la instancia
		            	var instancia = UsuarioControlador.getInstancia();
		            	// Eliminamos la persona
	                	boolean eliminar = instancia.eliminar(documento);
	                	// Si el metodo en el controlador nos devuelve true, se elimino correctamente, en caso contrario hubo un error
	                	if(eliminar) {
	                		JOptionPane.showMessageDialog(null,"Usuario eliminado correctamente", "Eliminar usuario", JOptionPane.INFORMATION_MESSAGE);
	                		listar(instancia.todosUsuarios());
	                	}else {
	                		JOptionPane.showMessageDialog(null,"Error al eliminar el usuario", "Eliminar usuario", JOptionPane.ERROR_MESSAGE);
	                	}
		            }
				}else {
            		JOptionPane.showMessageDialog(null,"Usted debe seleccionar el usuario que desea eliminar", "Eliminar usuario", JOptionPane.ERROR_MESSAGE);
				}
		
			}
		});
		
		listar(UsuarioControlador.getInstancia().todosUsuarios());
	}
	
	/**
	 * Listado de usuarios con JTable
	 * @param personas
	 */
	public void listar(ArrayList<Usuario> personas) {
		((DefaultTableModel) table_personas.getModel()).setRowCount(0);
		Object[] fila = new Object[table_personas.getModel().getColumnCount()];

		for(int i = 0; i < personas.size(); i++) {
			fila[0] = personas.get(i).getDocumento();
			fila[1] = personas.get(i).getNombre();
			fila[2] = personas.get(i).getApellido();
			fila[3] = personas.get(i).getCorreo();
			fila[4] = personas.get(i).getFechaNacimiento();
			((DefaultTableModel) table_personas.getModel()).addRow(fila);
		}
	}
}
