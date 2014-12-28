//WebBrowser.java
//WebBrowser is an application for browsing Web sites using
//a WebToolBar and WebBrowserPane.
package com.swing.chapter2.gui;

//Java core packages
import java.awt.*;
//Java extension packages
import javax.swing.*;

public class WebBrowser extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private WebToolBar toolBar;
	private WebBrowserPane browserPane;

	// WebBrowser constructor
	public WebBrowser() {
		super("Odyssey Web Browser");

		// create WebBrowserPane and WebToolBar for navigation
		browserPane = new WebBrowserPane();
		toolBar = new WebToolBar(browserPane);

		// lay out WebBrowser components
		Container contentPane = getContentPane();
		contentPane.add(toolBar, BorderLayout.NORTH);
		contentPane.add(new JScrollPane(browserPane), BorderLayout.CENTER);
	}

	// execute application
	public static void main(String args[]) {
		WebBrowser browser = new WebBrowser();
		browser.setDefaultCloseOperation(EXIT_ON_CLOSE);
		browser.setSize(640, 480);
		browser.setVisible(true);
	}
}