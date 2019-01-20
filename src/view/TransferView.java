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
		this.errorMessageLabel = new JLabel("", SwingConstants.CENTER);
		initialize();
	}
	
	private void initialize() {
		this.setLayout(null);
		
		initTransferButton();
		initMoney();
		initCancelButton();
		initDestination();
		initErrorMessageLabel();
	}
	
	private void initTransferButton() {	
		transferButton = new JButton("Transfer");
		transferButton.setBounds(50, 300, 200, 35);
		transferButton.addActionListener(this);
		
		this.add(transferButton);
	}
	
	private void initMoney() {
		JLabel label = new JLabel("Amount to transfer", SwingConstants.RIGHT);
		label.setBounds(0, 100, 200, 200);
		label.setLabelFor(moneyField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		moneyField = new JTextField(20);
		moneyField.setBounds(205, 185, 200, 30);
		
		this.add(label);
		this.add(moneyField);
	}
	
	private void initDestination() {
		JLabel label = new JLabel("Destination", SwingConstants.RIGHT);
		label.setBounds(0, 135, 200, 200);
		label.setLabelFor(moneyField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		destinationField = new JTextField(20);
		destinationField.setBounds(205, 225, 200, 30);
		
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
			updateErrorMessage(" ");
			this.removeAll();
			this.initialize();
		} else if (source.equals(transferButton)) {
			Database database = new Database();
			String money = moneyField.getText();
			String destin = destinationField.getText();
			
			
			if (money.equals("") || destin.equals("")) {
				updateErrorMessage("Please enter all information");
			} else {
				double moneyS = Double.parseDouble(moneyField.getText());
				long destination = Long.parseLong(destinationField.getText());
				BankAccount destinationA = manager.getAccountWNum(destination);
				
				int result = account.transfer(destinationA, moneyS);
				if (result == 3) {
					boolean results1 = manager.updateAccount(account);
					boolean results2 = manager.updateAccount(destinationA);
					
					if (results1 == true && results2 == true) {
						manager.sendBankAccount(account, "Home");
						manager.switchTo("HOME_VIEW");
						this.removeAll();
						this.initialize();
					}
				} else {
					updateErrorMessage("Please enter a valid amount/account number");
				}	//1200000002
					//1200000003
			}
		}
	}
}