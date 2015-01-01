// PhilosophersJList.java
// MVC architecture using JList with a DefaultListModel
package com.chapter03.mvc.list;

//Java core packages
import java.awt.*;
import java.awt.event.*;

//Java extension packages
import javax.swing.*;

public class PhilosophersJList extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private DefaultListModel<String> philosophers;
	private JList<String> list;

	// PhilosophersJList constructor
	public PhilosophersJList() {
		super("Favorite Philosophers");

		// create a DefaultListModel to store philosophers
		philosophers = new DefaultListModel<String>();
		philosophers.addElement("Socrates");
		philosophers.addElement("Plato");
		philosophers.addElement("Aristotle");
		philosophers.addElement("St. Thomas Aquinas");
		philosophers.addElement("Soren Kierkegaard");
		philosophers.addElement("Immanuel Kant");
		philosophers.addElement("Friedrich Nietzsche");
		philosophers.addElement("Hannah Arendt");
		// create a JList for philosophers DefaultListModel
		list = new JList<String>(philosophers);

		// allow user to select only one philosopher at a time
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// create JButton for adding philosophers
		JButton addButton = new JButton("Add Philosopher");
		addButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				// prompt user for new philosopher's name
				String name = JOptionPane.showInputDialog(
						PhilosophersJList.this, "Enter Name");

				// add new philosopher to model
				philosophers.addElement(name);
			}
		});

		// create JButton for removing selected philosopher
		JButton removeButton = new JButton("Remove Selected Philosopher");

		removeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				// remove selected philosopher from model
				philosophers.removeElement(list.getSelectedValue());
			}
		});

		// lay out GUI components
		JPanel inputPanel = new JPanel();
		inputPanel.add(addButton);
		inputPanel.add(removeButton);

		Container container = getContentPane();
		container.add(list, BorderLayout.CENTER);
		container.add(inputPanel, BorderLayout.NORTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	} // end PhilosophersJList constructor

	// execute application
	public static void main(String args[]) {
		new PhilosophersJList();
	}
}