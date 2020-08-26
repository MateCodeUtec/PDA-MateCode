package vista;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, UnsupportedLookAndFeelException  {
		// TODO Auto-generated method stub

		try {
	        UIManager.setLookAndFeel(
	                UIManager.getSystemLookAndFeelClassName());
		} catch (IllegalAccessException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

}
