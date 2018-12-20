package view;

import java.util.ArrayList;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;

@SuppressWarnings("serial")
public class CreateView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JTextField fnameField;		
	private JTextField lnameField;
	private JTextField phoneField;	
	private JComboBox BdayField;	
	private JTextField streetField;	
	private JTextField cityField;	
	private JTextField stateField;
	private JTextField zipField;	
	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public CreateView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the CreateView components.
	 */
	
	private void initialize() {
		this.setLayout(null);
		initFirstName();
		initLastName();
		initBirthday();
		initPhone();
		initStreet();
		initCity();
		initState();
		initZip();
		
		// TODO
		//
		// this is where you should build the CreateView (i.e., all the components that
		// allow the user to enter his or her information and create a new account).
		//
		// feel free to use my layout in LoginView as an example for laying out and
		// positioning your components.
	}
	
	/*
	 * CreateView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void initFirstName() {
		JLabel label = new JLabel("First Name", SwingConstants.RIGHT);
		label.setBounds(0, 0, 95, 30);
		label.setLabelFor(fnameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		fnameField = new JTextField(20);
		fnameField.setBounds(100, 0, 200, 30);
		
		this.add(label);
		this.add(fnameField);
	}
	
	private void initLastName() {
		JLabel label = new JLabel("Last Name", SwingConstants.RIGHT);
		label.setBounds(0, 35, 95, 30);
		label.setLabelFor(lnameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		lnameField = new JTextField(20);
		lnameField.setBounds(100, 35, 200, 30);
		
		this.add(label);
		this.add(lnameField);
	}
	
	private void initBirthday() {
		JLabel label = new JLabel("Birthday", SwingConstants.RIGHT);
		label.setBounds(0, 70, 95, 30);
		label.setLabelFor(BdayField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		
		String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		final JComboBox<String> mon = new JComboBox<String>(months);
		mon.setBounds(100, 70, 95, 30);
		
		String[] day = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		final JComboBox<String> days = new JComboBox<String>(day);
		days.setBounds(200, 70, 95, 30);
		
		//int[] year = {};
		//int x = 0;
		//for (int i = 1900; i < 2019; i++) {
		//	year[x] = i;
		//	x++;
		//}
		//System.out.println(year);
		
		//final JComboBox<integer> year = new JComboBox<integer>(year);
		//years.setBounds(200, 70, 95, 30);

	    this.add(label);
	    this.add(mon);
	    this.add(days);
	}
	
	private void initPhone() {
		JLabel label = new JLabel("Phone", SwingConstants.RIGHT);
		label.setBounds(0, 105, 95, 30);
		label.setLabelFor(phoneField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		phoneField = new JTextField(20);
		phoneField.setBounds(100, 100, 200, 30);
		
		this.add(label);
		this.add(phoneField);
	}
	
	private void initStreet() {
		JLabel label = new JLabel("Street", SwingConstants.RIGHT);
		label.setBounds(0, 140, 95, 30);
		label.setLabelFor(streetField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		streetField = new JTextField(20);
		streetField.setBounds(100, 140, 200, 30);
		
		this.add(label);
		this.add(streetField);
	}
	
	private void initCity() {
		JLabel label = new JLabel("City", SwingConstants.RIGHT);
		label.setBounds(0, 185, 95, 30);
		label.setLabelFor(cityField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		cityField = new JTextField(20);
		cityField.setBounds(100, 185, 200, 30);
		
		this.add(label);
		this.add(cityField);
	}
	
	private void initState() {
		JLabel label = new JLabel("State", SwingConstants.RIGHT);
		label.setBounds(0, 220, 95, 30);
		label.setLabelFor(stateField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		stateField = new JTextField(20);
		stateField.setBounds(100, 220, 200, 30);
		
		this.add(label);
		this.add(stateField);
	}
	
	private void initZip() {
		JLabel label = new JLabel("Zip", SwingConstants.RIGHT);
		label.setBounds(0, 255, 95, 30);
		label.setLabelFor(zipField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		zipField = new JTextField(20);
		zipField.setBounds(100, 255, 200, 30);
		
		this.add(label);
		this.add(zipField);
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The CreateView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the CreateView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO
		//
		// this is where you'll setup your action listener, which is responsible for
		// responding to actions the user might take in this view (an action can be a
		// user clicking a button, typing in a textfield, etc.).
		//
		// feel free to use my action listener in LoginView.java as an example.
	}
}