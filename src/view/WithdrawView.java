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
public class WithdrawView extends JPanel implements ActionListener {
	private ViewManager manager;	
	private JButton withdrawButton;
	private JTextField moneyField;	
	private JButton cancel;
	private JLabel errorMessageLabel;
	private BankAccount account;
	
	public WithdrawView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	private void initialize() {
		this.setLayout(null);
		
		initWithdrawButton();
		initMoney();
		initCancelButton();
	}
	
	private void initWithdrawButton() {	
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(50, 300, 200, 35);
		withdrawButton.addActionListener(this);
		
		this.add(withdrawButton);
	}
	
	private void initMoney() {
		JLabel label = new JLabel("Amount to withdraw", SwingConstants.RIGHT);
		label.setBounds(0, 105, 200, 200);
		label.setLabelFor(moneyField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		moneyField = new JTextField(20);
		moneyField.setBounds(205, 198, 200, 30);
		
		this.add(label);
		this.add(moneyField);
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
		} else if (source.equals(withdrawButton)) {
			//Database database = new Database();
			String money = moneyField.getText();
	
			
			if (money.equals("")) {
				updateErrorMessage("Please enter all information");
			} else {
				double moneyS = Double.parseDouble(moneyField.getText());
				int result = account.withdraw(moneyS);
				if (result == 3) {
					boolean results = manager.updateAccount(account);
					if (results == true) {
						manager.switchTo("HOME_VIEW");
						this.removeAll();
						this.initialize();
					}
				}	
			}
		}
	}
}