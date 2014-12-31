// AccountBarGraphView.java
// AccountBarGraphView is an AbstractAccountView subclass
// that displays an Account balance as a bar graph.
package com.chapter03.mvc.AccountManager;

//Java core packages
import java.awt.*;

public class AccountBarGraphView extends AbstractAccountView {

	private static final long serialVersionUID = 1L;


	// AccountBarGraphView constructor
	public AccountBarGraphView(Account account) {
		super(account);
	}

	// draw Account balance as a bar graph
	public void paintComponent(Graphics g) {
		// ensure proper painting sequence
		super.paintComponent(g);

		// get Account balance
		double balance = getAccount().getBalance();

		// calculate integer height for bar graph (graph
		// is 200 pixels wide and represents Account balances
		// from -$5,000.00to +$5,000.00)
		int barLength = (int) ((balance / 10000.0) * 200);

		// if balance is positive, draw graph in black
		if (balance >= 0.0) {
			g.setColor(Color.black);
			g.fillRect(105, 15, barLength, 20);
		}

		// if balance is negative, draw graph in red
		else {
			g.setColor(Color.red);
			g.fillRect(105 + barLength, 15, -barLength, 20);
		}

		// draw vertical and horizontal axes
		g.setColor(Color.black);
		g.drawLine(5, 25, 205, 25);
		g.drawLine(105, 5, 105, 45);

		// draw graph labels
		g.setFont(new Font("SansSerif", Font.PLAIN, 10));
		g.drawString("-$5,000", 5, 10);
		g.drawString("$0", 110, 10);
		g.drawString("+$5,000", 166, 10);

	} // end method paintComponent

	// repaint graph when display is updated
	public void updateDisplay() {
		repaint();
	}

	// get AccountBarGraphView's preferred size
	public Dimension getPreferredSize() {
		return new Dimension(210, 50);
	}

	// get AccountBarGraphView's minimum size
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}

	// get AccountBarGraphView's maximum size
	public Dimension getMaximumSize() {
		return getPreferredSize();
	}
}