package ui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Class that creates the graphical user interface.
 */
public class GUI {
	
	private JFrame _frame;
	
	private JMenuBar _menuBar;


	//private MouseSelection _ms;
	
	private BackgroundPanel _back;
	
	static PrimePanel _prime;
	
	private Logic l;
	
/**
 * Default constructor which sets up the GUI
 */
	public GUI(){
		l = new Logic();
		l.addObserver(this);
		EventHandler eh = new EventHandler(l);
		
		
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
		
		_frame.add(_prime);
		_frame.add(_back);
		

		_menuBar = new JMenuBar();
		
		JMenu file = new JMenu("File");
			JMenuItem quit = new JMenuItem("Quit");
			JMenuItem reset = new JMenuItem("Reset");
			JMenuItem velocity = new JMenuItem("Set Velocity");
			quit.setActionCommand("quit");
			quit.addActionListener(eh);
			reset.setActionCommand("reset");
			reset.addActionListener(eh);
			velocity.setActionCommand("velocity");
			velocity.addActionListener(eh);
			
			file.add(quit);
			file.add(reset);
			file.add(velocity);
				
		_menuBar.add(file);
		
		_frame.setJMenuBar(_menuBar);
		_frame.setResizable(false);
		//_frame.pack();
		_frame.setVisible(true);
	}
	
	public double getVelocityInput(){
		String s = (String) JOptionPane.showInputDialog("Set Velocity: \n" + "Ex. Enter 0.95 for velocity of 0.95c");
		try {
			if(Double.valueOf(s) > 0 && Double.valueOf(s) <= 1){
				return Double.valueOf(s);
			}
			else{
				if(Double.valueOf(s) > 1){
					JOptionPane.showMessageDialog(null, "Superluminal velocity detected. \n" + "You can't do that!");
				}
			
				else{
					JOptionPane.showMessageDialog(null, "Enter a number between 0 and 1. \n" + "Velocity set to 0.5c. \nTry again!", "Warning: " + " Not A Valid Number", JOptionPane.INFORMATION_MESSAGE);
				}
			return 0.5;
			}
		} catch (NumberFormatException e){
			System.out.println("Not a number");
			JOptionPane.showMessageDialog(null, "Velocity set to 0.5c. Try again!", "NumberFormatException: " + " Not A Number", JOptionPane.INFORMATION_MESSAGE);
			return 0.5; 
		}
	}
}
