package view;

import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.BankAccount;
import model.User;
import controller.ViewManager;
import data.Database;

@SuppressWarnings("serial")
public class TransferView extends JPanel implements ActionListener {
	private ViewManager manager;	
	private JButton transferButton;
	private JTextField moneyField;	
	private JTextField destinationField;	
	private JButton cancel;
	private JLabel errorMessageLabel;
	private BankAccount account;
	
	public TransferView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	private void initialize() {
		this.setLayout(null);
		
		initTransferButton();
		initMoney();
		initCancelButton();
		initDestination();
	}
	
	private void initTransferButton() {	
		transferButton = new JButton("Transfer");
		transferButton.setBounds(50, 300, 200, 35);
		transferButton.addActionListener(this);
		
		this.add(transferButton);
	}
	
	private void initMoney() {
		JLabel label = new JLabel("Amount to transfer", SwingConstants.RIGHT);
		label.setBounds(0, 105, 200, 200);
		label.setLabelFor(moneyField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		moneyField = new JTextField(20);
		moneyField.setBounds(205, 200, 200, 30);
		
		this.add(label);
		this.add(moneyField);
	}
	
	private void initDestination() {
		JLabel label = new JLabel("Where to transfer", SwingConstants.RIGHT);
		label.setBounds(0, 130, 200, 200);
		label.setLabelFor(moneyField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		destinationField = new JTextField(20);
		destinationField.setBounds(0, 128, 200, 30);
		
		this.add(label);
		this.add(destinationField);
	}
	
	private void initCancelButton() {	
		cancel = new JButton("Cancel");
		cancel.setBounds(260, 300, 200, 35);
		cancel.addActionListener(this);
		
		this.add(cancel);
	}
	
	public void updateErrorMessage(String errorMessage) {
		errorMessageLabel.setText(errorMessage);
	}
	
	private void initErrorMessageLabel() {
		errorMessageLabel.setBounds(50, 370, 500, 35);
		errorMessageLabel.setFont(new Font("DialogInput", Font.ITALIC, 14));
		errorMessageLabel.setForeground(Color.RED);
		
		this.add(errorMessageLabel);
	}
	
	public void setBankAccount(BankAccount account) {
		this.account = account;
		moneyField.setText(account.getBalance() + "");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source.equals(cancel)) {
			manager.switchTo("HOME_VIEW");
			this.removeAll();
			this.initialize();
		} else if (source.equals(transferButton)) {
			Database database = new Database();
			String money = moneyField.getText();
	
			
			if (money.equals("")) {
				updateErrorMessage("Please enter all information");
			} else {
				//User user = new User(Integer.parseInt(pin), Integer.parseInt(dob), Long.parseLong(phone), firstName, lastName, street, city, state, zip);
				//long accountnum = 1200000000;
				//BankAccount account = new BankAccount('Y', accountnum, 0, user);
				//database.updateAccount(account);
				//manager.logout();
				//this.removeAll();
				//this.initialize();
			}
		}
	}
}