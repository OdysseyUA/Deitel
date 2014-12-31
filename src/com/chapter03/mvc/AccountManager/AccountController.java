// AccountController.java
// AccountController is a controller for Accounts. It provides
// a JTextField for inputting a deposit or withdrawal amount
// and JButtons for depositing or withdrawing funds.
package com.chapter03.mvc.AccountManager;

//Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class AccountController extends JPanel {

	private static final long serialVersionUID = 1L;
	

	// Account to control
	private Account account;

	// JTextField for deposit or withdrawal amount
	private JTextField amountTextField;

	// AccountController constructor
	public AccountController(Account controlledAccount) {
		super();
		// account to control
		account = controlledAccount;

		// create JTextField for entering amount
		amountTextField = new JTextField(10);

		// create JButton for deposits
		JButton depositButton = new JButton("Deposit");

		depositButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				try {

					// deposit amount entered in amountTextField
					account.deposit(Double.parseDouble(amountTextField
							.getText()));
				}

				catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(AccountController.this,
							"Please enter a valid amount", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} // end method actionPerformed
		});

		// create JButton for withdrawals
		JButton withdrawButton = new JButton("Withdraw");

		withdrawButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				try {

					// withdraw amount entered in amountTextField
					account.withdraw(Double.parseDouble(amountTextField
							.getText()));
				}

				catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(AccountController.this,
							"Please enter a valid amount", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} // end method actionPerformed
		});

		// lay out controller components
		setLayout(new FlowLayout());
		add(new JLabel("Amount: "));
		add(amountTextField);
		add(depositButton);
		add(withdrawButton);
	}
}