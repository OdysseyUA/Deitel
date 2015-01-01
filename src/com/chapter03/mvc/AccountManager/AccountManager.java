// AccountManager.java
// AccountManager is an application that uses the MVC design
// pattern to manage bank Account information.
package com.chapter03.mvc.AccountManager;

//Java core packages
import java.awt.*;

// Java extension packages
import javax.swing.*;
import javax.swing.border.*;

public class AccountManager extends JFrame {

	private static final long serialVersionUID = 1L;


	// AccountManager no-argument constructor
	public AccountManager() {
		super("Account Manager");

		// create account1 with initial balance
		Account account1 = new Account("Account 1", 1000.00);

		// create GUI for account1
		JPanel account1Panel = createAccountPanel(account1);

		// create account2 with initial balance
		Account account2 = new Account("Account 2", 3000.00);

		// create GUI for account2
		JPanel account2Panel = createAccountPanel(account2);

		// create AccountPieChartView to show Account pie chart
		AssetPieChartView pieChartView = new AssetPieChartView();

		// add both Accounts to AccountPieChartView
		pieChartView.addAccount(account1);
		pieChartView.addAccount(account2);

		// create JPanel for AccountPieChartView
		JPanel pieChartPanel = new JPanel();

		pieChartPanel.setBorder(new TitledBorder("Assets"));
		pieChartPanel.add(pieChartView);

		// lay out account1, account2 and pie chart components
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(3, 1));
		contentPane.add(account1Panel);
		contentPane.add(account2Panel);
		contentPane.add(pieChartPanel);

		setSize(400, 550);

	} // end AccountManager constructor

	// create GUI components for given Account
	private JPanel createAccountPanel(Account account) {
		// create JPanel for Account GUI
		JPanel accountPanel = new JPanel();

		// set JPanel's border to show Account name
		accountPanel.setBorder(new TitledBorder(account.getName()));

		// create AccountTextView for Account
		AccountTextView accountTextView = new AccountTextView(account);

		// create AccountBarGraphView for Account
		AccountBarGraphView accountBarGraphView = new AccountBarGraphView(
				account);

		// create AccountController for Account
		AccountController accountController = new AccountController(account);

		// lay out Account's components
		accountPanel.add(accountController);
		accountPanel.add(accountTextView);
		accountPanel.add(accountBarGraphView);

		return accountPanel;

	} // end method getAccountPanel

	// execute application
	public static void main(String args[]) {
		AccountManager manager = new AccountManager();
		manager.setDefaultCloseOperation(EXIT_ON_CLOSE);
		manager.setVisible(true);
	}
}