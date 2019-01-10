package view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.BankAccount;
import controller.ViewManager;

@SuppressWarnings("serial")
public class HomeView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JButton logout;			// button that powers off the ATM
	private JLabel nameField;
	private BankAccount account;
	private JLabel moneyField;
	private JLabel numberField;
	private JButton depositButton;
	private JLabel welcomeField;
	private JButton withdrawButton;
	private JButton transferButton;
	
	/**
	 * Constructs an instance (or objects) of the HomeView class.
	 * 
	 * @param manager
	 */
	
	public HomeView(ViewManager manager) {
		super();
		this.setLayout(null);
		
		this.manager = manager;
		initialize();
		initLogoutButton();
	}
	
	
	
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the HomeView components.
	 */

	private void initialize() {
		
		// TODO
		//
		// this is a placeholder for this view and should be removed once you start
		// building the HomeView.
		
		this.add(new javax.swing.JLabel("HomeView", javax.swing.SwingConstants.CENTER));
		initName();
		initBalance();
		initWelcome();
		initAccountNumber();
		initDepositButton();
		initWithdrawButton();
		initTransferButton();
		// TODO
		//
		// this is where you should build the HomeView (i.e., all the components that
		// allow the user to interact with the ATM - deposit, withdraw, transfer, etc.).
		//
		// feel free to use my layout in LoginView as an example for laying out and
		// positioning your components.
	}
	private void initWelcome() {
		
		welcomeField = new JLabel("Welcome to the Bank!", SwingConstants.RIGHT);
		welcomeField.setBounds(0, 0, 200, 200);
		welcomeField.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		this.add(welcomeField);
	}
	
	private void initName() {
		
		nameField = new JLabel("nameField", SwingConstants.RIGHT);
		nameField.setBounds(100, 100, 95, 35);
		nameField.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		this.add(nameField);
	}
	
	
	private void initBalance() {
		
		moneyField = new JLabel("moneyField", SwingConstants.RIGHT);
		moneyField.setBounds(100, 120, 95, 35);
		moneyField.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		this.add(moneyField);
	}

	private void initAccountNumber() {
	
		numberField = new JLabel("numberField", SwingConstants.RIGHT);
		numberField.setBounds(100, 140, 95, 35);
		numberField.setFont(new Font("DialogInput", Font.BOLD, 14));
	
		this.add(numberField);
	}
	
	private void initDepositButton() {	
		depositButton = new JButton("Deposit");
		depositButton.setBounds(250, 100, 200, 35);
		depositButton.addActionListener(this);
		
		this.add(depositButton);
	}
	
	private void initWithdrawButton() {	
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(250, 150, 200, 35);
		withdrawButton.addActionListener(this);
		
		this.add(withdrawButton);
	}
	private void initTransferButton() {	
		transferButton = new JButton("Transfer");
		transferButton.setBounds(250, 200, 200, 35);
		transferButton.addActionListener(this);
		
		this.add(transferButton);
	}

	private void initLogoutButton() {	
		logout = new JButton("Logout");
		logout.setBounds(250, 250, 200, 35);
		logout.addActionListener(this);
		
		this.add(logout);
	}
	
	/*
	 * HomeView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The HomeView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the HomeView.
	 * 
	 * @param e
	 */
	public void setBankAccount(BankAccount account) {
		this.account = account;
		nameField.setText(account.getUser().getName());
		moneyField.setText(account.getBalance() + "");
		numberField.setText(account.getAccountNumber() + "");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source.equals(logout)) {
			manager.logout();
		} if (source.equals(depositButton)) { 
			manager.sendBankAccount(account, "Deposit");
			manager.switchTo(ATM.DEPOSIT_VIEW);
		}
		if (source.equals(withdrawButton)) { 
			manager.sendBankAccount(account, "Withdraw");
			manager.switchTo(ATM.WITHDRAW_VIEW);
		}
		if (source.equals(transferButton)) { 
			manager.switchTo(ATM.TRANSFER_VIEW);
		}
		// TODO
		//
		// this is where you'll setup your action listener, which is responsible for
		// responding to actions the user might take in this view (an action can be a
		// user clicking a button, typing in a textfield, etc.).
		//
		// feel free to use my action listener in LoginView.java as an example.
	}

	
}

