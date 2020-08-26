package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.FuncionalidadControlador;
import controlador.RolControlador;
import controlador.UsuarioControlador;
import modelo.Funcionalidad;
import modelo.Rol;
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
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;

public class Funcionalidades extends JFrame {

	private JPanel contentPane;
	private JTable table_funcionalidad;

	/**
	 * Create the frame.
	 */
	public Funcionalidades() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Funcionalidades.class.getResource("/vista/assets/iconfrm.png")));
		setTitle("MateCode | Funcionalidades");
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
		
		table_funcionalidad = new JTable();
		table_funcionalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_funcionalidad.setBackground(new Color(255, 255, 255));
		table_funcionalidad.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		table_funcionalidad.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(table_funcionalidad);
		table_funcionalidad.getTableHeader().setReorderingAllowed(false);
		table_funcionalidad.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		table_funcionalidad.setModel(new DefaultTableModel(
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
		scrollPane.setViewportView(table_funcionalidad);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 0, 586, 125);
		contentPane.add(panel);
		
		JLabel lblUsaurios = new JLabel("Funcionalidades");
		lblUsaurios.setForeground(Color.BLACK);
		lblUsaurios.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblUsaurios.setBounds(22, 31, 274, 34);
		panel.add(lblUsaurios);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Funcionalidades.class.getResource("/vista/assets/cerebro.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(458, 24, 75, 67);
		panel.add(lblNewLabel_1);
		
		JButton btnEliminar_1 = new JButton("Eliminar");
		btnEliminar_1.setIcon(new ImageIcon(Funcionalidades.class.getResource("/vista/assets/delete.png")));
		btnEliminar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtiene el número de la fila seleccionada
				int row = table_funcionalidad.getSelectedRow(); 
				
				// Comprobamos que se seleccione una fila
				if(row >= 0) {
					// Obtiene el valor de la celda 0 de la fila seleccionada
					String nombre = table_funcionalidad.getModel().getValueAt(row, 0).toString(); 
					
					// Preguntamos si quiere eliminar el rol
			        int pregunta = JOptionPane.showConfirmDialog(null,"¿Seguro que quieres eliminar esta funcionalidad?", "Eliminar funcionalidad", JOptionPane.YES_NO_OPTION);
			        
			        // Si la opcion es "YES" entonces llamamos al metodo del controlador de eliminar
		            if(pregunta == JOptionPane.YES_OPTION){
		            	// Obtenemos la instancia
		            	var instancia = FuncionalidadControlador.getInstancia();
		            	// Eliminamos la rol
	                	boolean eliminar = instancia.eliminar(nombre);
	                	// Comprobamos si todo salio bien, en caso que sea true salio bien, en caso contrario salio mal
	                	if(eliminar) {
	                		JOptionPane.showMessageDialog(null,"Funcionalidad eliminada", "Eliminar funcionalidad", JOptionPane.INFORMATION_MESSAGE);
	                		listar(instancia.obtenerTodos());
	                	}else {
	                		JOptionPane.showMessageDialog(null,"Error al eliminar una funcionalidad", "Eliminar funcionalidad", JOptionPane.ERROR_MESSAGE);
	                	}
		            }
				}else {
            		JOptionPane.showMessageDialog(null,"Usted debe seleccionar la funcionalidad que desea eliminar", "Eliminar funcionalidad", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliminar_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnEliminar_1.setBounds(123, 102, 94, 23);
		panel.add(btnEliminar_1);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(Funcionalidades.class.getResource("/vista/assets/edit.png")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtenemos la fila seleccionada
				int row = table_funcionalidad.getSelectedRow();
				
				// Comprobamos que la fila este seleccionada
				if(row >= 0) {
					// Obtenemos el nombre de la tabla
					String nombre = table_funcionalidad.getModel().getValueAt(row, 0).toString();
					
					// Obtenemos el nombre, en caso que exista pasamos estos datos al frame de editar para poder mostrar los datos actuales
					// del la funcionalidad en la ventana
					Funcionalidad f = FuncionalidadControlador.getInstancia().obtenerPorNombre(nombre);
					
					EditarFuncionalidad frame = new EditarFuncionalidad(f);
					frame.setVisible(true);
					setVisible(false);
				}else {
            		JOptionPane.showMessageDialog(null,"Usted debe seleccionar el usuario que desea editar", "Editar usuario", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEditar.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnEditar.setBounds(22, 102, 94, 23);
		panel.add(btnEditar);
		
		JLabel lblNewLabel = new JLabel("Agregar nueva");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AltaFuncionalidad af = new AltaFuncionalidad();
				af.setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel.setForeground(new Color(65, 105, 225));
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel.setBounds(22, 68, 195, 23);
		panel.add(lblNewLabel);
		
		listar(FuncionalidadControlador.getInstancia().obtenerTodos());
	}
	
	/**
	 * Listado de funcionalidades con JTable
	 * @param personas
	 */
	public void listar(ArrayList<Funcionalidad> funcionalidades) {
		((DefaultTableModel) table_funcionalidad.getModel()).setRowCount(0);
		
		Object[] fila = new Object[table_funcionalidad.getModel().getColumnCount()];
		for(int i = 0; i < funcionalidades.size(); i++) {
			fila[0] = funcionalidades.get(i).getNombre();
			fila[1] = funcionalidades.get(i).getDescripcion();
			((DefaultTableModel) table_funcionalidad.getModel()).addRow(fila);
		}
	}
}
