// AccountTextView.java
// AccountTextView is an AbstractAccountView subclass
// that displays an Account balance in a JTextField.
package com.chapter03.mvc.AccountManager;

//Java core packages
import java.util.*;
import java.text.NumberFormat;

// Java extension packages
import javax.swing.*;

public class AccountTextView extends AbstractAccountView {

	private static final long serialVersionUID = 1L;	

	// JTextField for displaying Account balance
	private JTextField balanceTextField = new JTextField(10);

	// NumberFormat for US dollars
	private NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);

	
	// AccountTextView constructor
	public AccountTextView(Account account) {
		super(account);
		// make balanceTextField readonly
		balanceTextField.setEditable(false);

		// lay out components
		add(new JLabel("Balance: "));
		add(balanceTextField);

		updateDisplay();
	}

	// update display with Account balance
	public void updateDisplay() {
		// set text in balanceTextField to formatted balance
		balanceTextField.setText(moneyFormat.format(getAccount().getBalance()));
	}
}