// PhilosophersJTable.java
// MVC architecture using JTable with a DefaultTableModel
package com.chapter03.mvc.table;

//Java core packages
import java.awt.*;
import java.awt.event.*;

//Java extension packages
import javax.swing.*;
import javax.swing.table.*;

public class PhilosophersJTable extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel philosophers;
	private JTable table;

	// PhilosophersJTable constructor
	public PhilosophersJTable() {
		super("Favorite Philosophers");

		// create a DefaultTableModel to store philosophers
		philosophers = new DefaultTableModel();

		// add Columns to DefaultTableModel
		philosophers.addColumn("First Name");
		philosophers.addColumn("Last Name");
		philosophers.addColumn("Years");

		// add philosopher names and dates to DefaultTableModel
		String[] socrates = { "Socrates", "", "469-399 B.C." };
		philosophers.addRow(socrates);

		String[] plato = { "Plato", "", "428-347 B.C." };
		philosophers.addRow(plato);

		String[] aquinas = { "Thomas", "Aquinas", "1225-1274" };
		philosophers.addRow(aquinas);

		String[] kierkegaard = { "Soren", "Kierkegaard", "1813-1855" };
		philosophers.addRow(kierkegaard);

		String[] kant = { "Immanuel", "Kant", "1724-1804" };
		philosophers.addRow(kant);

		String[] nietzsche = { "Friedrich", "Nietzsche", "1844-1900" };
		philosophers.addRow(nietzsche);

		String[] arendt = { "Hannah", "Arendt", "1906-1975" };
		philosophers.addRow(arendt);
		// create a JTable for philosophers DefaultTableModel
		table = new JTable(philosophers);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// create JButton for adding philosophers
		JButton addButton = new JButton("Add Philosopher");
		addButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				// create empty array for new philosopher row
				String[] philosopher = { "", "", "" };

				// add empty philosopher row to model
				philosophers.addRow(philosopher);
			}
		});

		// create JButton for removing selected philosopher
		JButton removeButton = new JButton("Remove Selected Philosopher");

		removeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				// remove selected philosopher from model
				philosophers.removeRow(table.getSelectedRow());
			}
		});

		// lay out GUI components
		JPanel inputPanel = new JPanel();
		inputPanel.add(addButton);
		inputPanel.add(removeButton);

		Container container = getContentPane();
		container.add(new JScrollPane(table), BorderLayout.CENTER);
		container.add(inputPanel, BorderLayout.NORTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);

	} // end PhilosophersJTable constructor
		// execute application

	public static void main(String args[]) {
		new PhilosophersJTable();
	}
}