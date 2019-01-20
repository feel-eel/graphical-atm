package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.BankAccount;
import model.User;
import controller.ViewManager;
import data.Database;

@SuppressWarnings("serial")
public class InformationView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JLabel nameField;		
	private JLabel phoneField;	
	private JTextField phoneBox;
	private JTextField streetBox;
	private JTextField cityBox;
	private JTextField stateBox;
	private JTextField zipBox;
	private JTextField pinBox;
	private JLabel BdayField;	
	private JLabel streetField;	
	private JLabel cityField;	
	private JLabel stateField;
	private JLabel zipField;	
	private JLabel pinField;	
	private JLabel numberField;	
	private JButton cancel;
	private JButton edit;
	private JButton submit;
	private JLabel errorMessageLabel;
	private JComboBox year;
	private JComboBox mon;
	private JComboBox days;
	private BankAccount account;
	
	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public InformationView(ViewManager manager) {
		super();
		
		this.manager = manager;
		this.errorMessageLabel = new JLabel("", SwingConstants.CENTER);
		initialize();
	}
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the CreateView components.
	 */
	
	private void initialize() {
		this.setLayout(null);
		initName();
		initBirthday();
		initPhone();
		initStreet();
		initCity();
		initState();
		initZip();
		initCancelButton();
		initEdit();
		initErrorMessageLabel();
		initAccountNumber();
		initPin();
		
		
	}
	
	private void initializeEdit() {
		this.setLayout(null);
		initName();
		initBirthday();
		initPhone();
		initPhoneBox();
		initStreet();
		initCity();
		initState();
		initSubmit();
		initZip();
		initCancelButton();
		initErrorMessageLabel();
		initAccountNumber();
		initPin();
		initStreetBox();
		initPinBox();
		initZipBox();
		initCityBox();
		initStateBox();
	}
	
	/*
	 * CreateView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void initName() {
		
		nameField = new JLabel("nameField", SwingConstants.RIGHT);
		nameField.setBounds(50, 100, 150, 35);
		nameField.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		this.add(nameField);
	}
	
	private void initPhone() {
		
		phoneField = new JLabel("phoneField", SwingConstants.RIGHT);
		phoneField.setBounds(50, 120, 150, 35);
		phoneField.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		this.add(phoneField);
	}
	
	private void initPhoneBox() {
		
		phoneBox = new JTextField(20);
		phoneBox.setBounds(215, 125, 200, 20);
	
		this.add(phoneBox);
	}

	private void initStreet() {
	
		streetField = new JLabel("streetField", SwingConstants.RIGHT);
		streetField.setBounds(2, 140, 200, 35);
		streetField.setFont(new Font("DialogInput", Font.BOLD, 14));
	
		this.add(streetField);
	}
	private void initStreetBox() {
		
		streetBox = new JTextField(20);
		streetBox.setBounds(215, 145, 200, 20);
	
		this.add(streetBox);
	}
	
	private void initCity() {
		
		cityField = new JLabel("cityField", SwingConstants.RIGHT);
		cityField.setBounds(0, 160, 200, 35);
		cityField.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		this.add(cityField);
		}
	
	private void initCityBox() {
		
		cityBox = new JTextField(20);
		cityBox.setBounds(215, 165, 200, 20);
	
		this.add(cityBox);
	}
	
	private void initState() {
		
		stateField = new JLabel("stateField", SwingConstants.RIGHT);
		stateField.setBounds(50, 180, 150, 35);
		stateField.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		this.add(stateField);
		}
	
	private void initStateBox() {
		
		stateBox = new JTextField(20);
		stateBox.setBounds(215, 185, 200, 20);
	
		this.add(stateBox);
	}
	
	private void initZip() {
		
		zipField = new JLabel("zipField", SwingConstants.RIGHT);
		zipField.setBounds(50, 200, 150, 35);
		zipField.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		this.add(zipField);
		}
	
	private void initZipBox() {
		
		zipBox = new JTextField(20);
		zipBox.setBounds(215, 205, 200, 20);
	
		this.add(zipBox);
	}
	
	private void initBirthday() {
		
		BdayField = new JLabel("BdayField", SwingConstants.RIGHT);
		BdayField.setBounds(2, 220, 200, 35);
		BdayField.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		this.add(BdayField);
		}
	
	
	private void initAccountNumber() {
		numberField = new JLabel("numberField", SwingConstants.RIGHT);
		numberField.setBounds(2, 240, 200, 35);
		numberField.setFont(new Font("DialogInput", Font.BOLD, 14));
	
		this.add(numberField);
	}
	
	private void initPin() {
		pinField = new JLabel("pinField", SwingConstants.RIGHT);
		pinField.setBounds(50, 260, 150, 35);
		pinField.setFont(new Font("DialogInput", Font.BOLD, 14));
	
		this.add(pinField);
	}
	
	private void initPinBox() {
		
		pinBox = new JTextField(20);
		pinBox.setBounds(215, 265, 200, 20);
	
		this.add(pinBox);
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
	
	private void initCancelButton() {	
		cancel = new JButton("Cancel");
		cancel.setBounds(215, 325, 200, 35);
		cancel.addActionListener(this);
		
		this.add(cancel);
	}
	
	private void initEdit() {	
		edit = new JButton("Edit");
		edit.setBounds(10, 325, 200, 35);
		edit.addActionListener(this);
		
		this.add(edit);
	}
	
	private void initSubmit() {	
		submit = new JButton("Submit");
		submit.setBounds(10, 325, 200, 35);
		submit.addActionListener(this);
		
		this.add(submit);
	}
	
	public void setBankAccount(BankAccount account) {
		this.account = account;
		nameField.setText("Name: " + account.getUser().getName());
		phoneField.setText("Phone: " + account.getUser().getPhone() + "");
		streetField.setText("Street: " + account.getUser().getStreetAddress());
		cityField.setText("City: " + account.getUser().getCity());
		stateField.setText("State: " + account.getUser().getState());
		zipField.setText("Zip Code: " + account.getUser().getZip());
		BdayField.setText("Birthday: " + account.getUser().getDob() + "");
		numberField.setText("Acc Number: " + account.getAccountNumber() + "");
		pinField.setText("Pin: " + account.getUser().getPin() + "");
	}
	
	///////////////////// INSTANCE METHODS ////////////////////////////////////////////
	
	/**
	 * Updates the error message label.
	 * 
	 * @param errorMessage
	 */
	
	public void updateErrorMessage(String errorMessage) {
		errorMessageLabel.setText(errorMessage);
	}
	
	private void initErrorMessageLabel() {
		errorMessageLabel.setBounds(50, 370, 500, 35);
		errorMessageLabel.setFont(new Font("DialogInput", Font.ITALIC, 14));
		errorMessageLabel.setForeground(Color.RED);
		
		this.add(errorMessageLabel);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source.equals(cancel)) {
			manager.switchTo("HOME_VIEW");
			updateErrorMessage(" ");
			this.removeAll();
			this.initialize();
		} else if (source.equals(edit)) {
			this.removeAll();
			manager.switchTo(ATM.HOME_VIEW);
			manager.switchTo(ATM.INFORMATION_VIEW);
			this.initializeEdit();
			this.setBankAccount(account);			
		} else if (source.equals(submit)) {
			
			String phone = phoneBox.getText();
			String street = streetBox.getText();
			
			String city = cityBox.getText();
			String state = stateBox.getText();
			String zip = zipBox.getText();
			String pin = pinBox.getText();
			
				if (!phone.equals("")) {
					account.getUser().setPhone(Long.parseLong(phone));
				} if (!street.equals("")) {
					account.getUser().setStreetAddress(street);
				} if (!city.equals("")) {
					account.getUser().setCity(city);
				} if (!state.equals("")) {
					account.getUser().setState(state);
				} if (!zip.equals("")) {
					account.getUser().setZip(zip);
				} if (!pin.equals("")) {
					account.getUser().setPin(account.getUser().getPin(), Integer.parseInt(pin));
				}
				
				
				boolean results = manager.updateAccount(account);
				if (results == true) {
					manager.sendBankAccount(account, "Home");
					manager.switchTo("HOME_VIEW");
					this.removeAll();
					this.initialize();
				}
				

		}

		
	
	}
}