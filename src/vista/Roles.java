package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.RolControlador;
import modelo.Rol;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;

public class Roles extends JFrame {

	private JPanel contentPane;
	private JTable table_roles;

	/**
	 * Create the frame.
	 */
	public Roles() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Roles.class.getResource("/vista/assets/iconfrm.png")));
		setTitle("MateCode | Roles");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 602, 382);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 125, 586, 218);
		contentPane.add(scrollPane);
		
		table_roles = new JTable();
		table_roles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_roles.setBackground(new Color(255, 255, 255));
		table_roles.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		table_roles.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(table_roles);
		table_roles.getTableHeader().setReorderingAllowed(false);
		table_roles.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		table_roles.setModel(new DefaultTableModel(
			new Object[][] {
					
			},
			new String[] {
				"Nombre", "Descripción"
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
		scrollPane.setViewportView(table_roles);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 0, 586, 125);
		contentPane.add(panel);
		
		JLabel lblUsaurios = new JLabel("Roles");
		lblUsaurios.setForeground(Color.BLACK);
		lblUsaurios.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblUsaurios.setBounds(22, 31, 94, 34);
		panel.add(lblUsaurios);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Roles.class.getResource("/vista/assets/rol.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(456, 35, 75, 67);
		panel.add(lblNewLabel_1);
		
		JButton btnEliminar_1 = new JButton("Eliminar");
		btnEliminar_1.setIcon(new ImageIcon(Roles.class.getResource("/vista/assets/delete.png")));
		btnEliminar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtiene el número de la fila seleccionada
				int row = table_roles.getSelectedRow(); 
				
				// Comprobamos que se seleccione una fila
				if(row >= 0) {
					// Obtiene el valor de la celda 0 de la fila seleccionada
					String nombre = table_roles.getModel().getValueAt(row, 0).toString(); 
					
					// Preguntamos si quiere eliminar el rol
			        int pregunta = JOptionPane.showConfirmDialog(null,"¿Seguro que quieres eliminar este rol?", "Eliminar rol", JOptionPane.YES_NO_OPTION);
			        
			        // Si la opcion es "YES" entonces llamamos al metodo del controlador de eliminar
		            if(pregunta == JOptionPane.YES_OPTION){
		            	// Obtenemos la instancia
		            	var instancia = RolControlador.getInstancia();
		            	// Eliminamos la rol
	                	boolean eliminar = instancia.eliminar(nombre);
	                	// Comprobamos si todo salio bien, en caso que sea true salio bien, en caso contrario salio mal
	                	if(eliminar) {
	                		JOptionPane.showMessageDialog(null,"Rol eliminado correctamente", "Eliminar rol", JOptionPane.INFORMATION_MESSAGE);
	                		listar(instancia.obtenerTodos());
	                	}else {
	                		JOptionPane.showMessageDialog(null,"Error al eliminar el rol", "Eliminar rol", JOptionPane.ERROR_MESSAGE);
	                	}
		            }
				}else {
            		JOptionPane.showMessageDialog(null,"Usted debe seleccionar el rol que desea eliminar", "Eliminar rol", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliminar_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnEliminar_1.setBounds(208, 102, 94, 23);
		panel.add(btnEliminar_1);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(Roles.class.getResource("/vista/assets/edit.png")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtenemos la fila seleccionada
				int row = table_roles.getSelectedRow();
				
				// Comprobamos que la fila este seleccionada
				if(row >= 0) {
					// Obtenemos el nombre de la tabla
					String nombre = table_roles.getModel().getValueAt(row, 0).toString();
					
					// Obtenemos el nombre, en caso que exista pasamos estos datos al frame de editar para poder mostrar los datos actuales
					// del rol en la ventana
					Rol r = RolControlador.getInstancia().obtenerPorNombre(nombre);
					
					EditarRol frame = new EditarRol(r);
					frame.setVisible(true);
					setVisible(false);
				}else {
            		JOptionPane.showMessageDialog(null,"Usted debe seleccionar el rol que desea editar", "Editar rol", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEditar.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnEditar.setBounds(115, 102, 94, 23);
		panel.add(btnEditar);
		
		JLabel lblNewLabel = new JLabel("Agregar nuevo");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AltaRol r = new AltaRol();
				r.setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel.setForeground(new Color(65, 105, 225));
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel.setBounds(22, 68, 145, 23);
		panel.add(lblNewLabel);
		
		JButton btnAsignar = new JButton("Funci\u00F3n");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtenemos la fila seleccionada
				int row = table_roles.getSelectedRow();
				
				// Comprobamos que la fila este seleccionada
				if(row >= 0) {
					// Obtenemos el nombre de la tabla
					String nombre = table_roles.getModel().getValueAt(row, 0).toString();
					
					// Obtenemos el nombre, en caso que exista pasamos estos datos al frame de editar para poder mostrar los datos actuales
					// del rol en la ventana
					Rol r = RolControlador.getInstancia().obtenerPorNombre(nombre);
					
					AsignarFuncion frame = new AsignarFuncion(r);
					frame.setVisible(true);
					setVisible(false);
				}else {
            		JOptionPane.showMessageDialog(null,"Usted debe seleccionar el rol que desea editar", "Editar rol", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAsignar.setIcon(new ImageIcon(Roles.class.getResource("/vista/assets/asignar.png")));
		btnAsignar.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnAsignar.setBounds(22, 102, 94, 23);
		panel.add(btnAsignar);
		
		listar(RolControlador.getInstancia().obtenerTodos());
	}
	
	/**
	 * Listado de roles con JTable
	 * @param personas
	 */
	public void listar(ArrayList<Rol> roles) {
		((DefaultTableModel) table_roles.getModel()).setRowCount(0);
		
		Object[] fila = new Object[table_roles.getModel().getColumnCount()];
		for(int i = 0; i < roles.size(); i++) {
			fila[0] = roles.get(i).getNombre();
			fila[1] = roles.get(i).getDescripcion();
			((DefaultTableModel) table_roles.getModel()).addRow(fila);
		}
	}
}
