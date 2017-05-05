package ui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Class that creates the graphical user interface.
 */
public class GUI {
	
	private JFrame _frame;
	
	private JMenuBar _menuBar;


	//private MouseSelection _ms;
	
	private BackgroundPanel _back;
	
	private PrimePanel _prime;
	
/**
 * Default constructor which sets up the GUI
 */
	public GUI(){

		_frame = new JFrame("Minkowksi Diagram Program");
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setSize(800, 875);
		
		_back = new BackgroundPanel();
		_back.setSize(new Dimension(800, 800));
		_back.setVisible(true);
		_back.setOpaque(true);
		
		_prime = new PrimePanel();
		_prime.setSize(new Dimension(800, 800));
		_prime.setVisible(true);
		_prime.setOpaque(false);
		//_prime.setBackground
		
		_frame.add(_prime);
		_frame.add(_back);
		

		_menuBar = new JMenuBar();
		
		JMenu file = new JMenu("File");
			JMenuItem quit = new JMenuItem("Quit");
			JMenuItem reset = new JMenuItem("Reset");
			quit.setActionCommand("quit");
			//quit.addActionListener(eh);
			reset.setActionCommand("reset");
			
			
			file.add(quit);
			file.add(reset);
		
				
		_menuBar.add(file);
		
		_frame.setJMenuBar(_menuBar);
		_frame.setResizable(false);
		//_frame.pack();
		_frame.setVisible(true);
	}
}
