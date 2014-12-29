// FavoritesWebBrowser.java
// FavoritesWebBrowser is an application for browsing Web sites
// using a WebToolBar and WebBrowserPane and displaying an HTML
// page containing links to favorite Web sites.
package com.swing.chapter2.gui.splitpane;

import javax.swing.JFrame;






//Java core packages
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;


//Java extension packages
import javax.swing.*;

import com.swing.chapter2.gui.*;

public class FavoritesWebBrowser extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private WebToolBar toolBar;
	private WebBrowserPane browserPane;
	private WebBrowserPane favoritesBrowserPane;

	// WebBrowser constructor
	public FavoritesWebBrowser() {
		super("Deitel Web Browser");

		// create WebBrowserPane and WebToolBar for navigation
		browserPane = new WebBrowserPane();
		toolBar = new WebToolBar(browserPane);

		// create WebBrowserPane for displaying favorite sites
		favoritesBrowserPane = new WebBrowserPane();

		// add WebToolBar as listener for HyperlinkEvents
		// in favoritesBrowserPane
		favoritesBrowserPane.addHyperlinkListener(toolBar);

		
		System.out.println(getClass().getResource("favorites.html").toString());
		favoritesBrowserPane.goToURL(getClass().getResource("favorites.html"));
		
/*
	String s = "file:/" + (System.getProperty("user.dir") + "\\resource\\favorites.html").replace('\\', '/');		
	System.out.println(s);
	// display favorites.html in favoritesBrowserPane
	try {
		favoritesBrowserPane.goToURL(new URL(s));
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
*/		
	
		

		// create JSplitPane with horizontal split (side-by-side)
		// and add WebBrowserPanes with JScrollPanes
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				new JScrollPane(favoritesBrowserPane), new JScrollPane(
						browserPane));

		// position divider between WebBrowserPanes
		splitPane.setDividerLocation(210);

		// add buttons for expanding/contracting divider
		splitPane.setOneTouchExpandable(true);

		// lay out WebBrowser components
		Container contentPane = getContentPane();
		contentPane.add(toolBar, BorderLayout.NORTH);
		contentPane.add(splitPane, BorderLayout.CENTER);

	}

	// execute application
	public static void main(String args[]) {
		FavoritesWebBrowser browser = new FavoritesWebBrowser();

		browser.setSize(640, 480);

	}

}
