package ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import code.SpecRel;


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
	
	JTextField velField;
	
/**
 * Default constructor which sets up the GUI
 */
	public GUI(){
		l = new Logic();
		l.addObserver(this);
		EventHandler eh = new EventHandler(l);
		
		_frame = new JFrame("Minkowksi Diagram Program");
		_frame.setLayout(null);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setSize(800, 1075);
		
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

			quit.setActionCommand("quit");
			quit.addActionListener(eh);
			reset.setActionCommand("reset");
			reset.addActionListener(eh);
			
			file.add(quit);
			file.add(reset);

				
		_menuBar.add(file);
		
		JPanel inputPanel = new JPanel();
			inputPanel.setSize(800, 275);
			inputPanel.setBounds(0, 800, 800, 275);
			
		JTextPane velText = new JTextPane();
			velText.setText("Velocity:");
		
		velField = new JTextField();
			velField.setText(Double.toString(SpecRel.velocity));
			velField.setPreferredSize(new Dimension(50, 20));
		
		JTextPane cText = new JTextPane();
			cText.setText("c");
		
		JButton velButton = new JButton("OK");
			velButton.addActionListener(eh);
			velButton.setActionCommand("velocity");
			
		inputPanel.add(velText);
		inputPanel.add(velField);
		inputPanel.add(cText);
		inputPanel.add(velButton);
		
		_frame.add(inputPanel);
		
		_frame.setJMenuBar(_menuBar);
		_frame.setResizable(false);
		//_frame.pack();
		_frame.setVisible(true);
	}
	
	public double getVelocityInput(){
		String s = (String) velField.getText();
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
					velField.setText(Double.toString(SpecRel.velocity));
				}
			return 0.5;
			}
		} catch (NumberFormatException e){
			System.out.println("Not a number");
			JOptionPane.showMessageDialog(null, "Velocity set to 0.5c. Try again!", "NumberFormatException: " + " Not A Number", JOptionPane.INFORMATION_MESSAGE);
			velField.setText(Double.toString(SpecRel.velocity));
			return 0.5; 
		}
	}
}
