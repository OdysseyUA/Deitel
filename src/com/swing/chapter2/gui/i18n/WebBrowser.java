// WebBrowser.java
// WebBrowser is an application for browsing Web sites using
// a WebToolBar and WebBrowserPane.
package com.swing.chapter2.gui.i18n;

//Java core packages
import java.awt.*;
import java.util.*;

// Java extension packages
import javax.swing.*;
// Default packages
import com.swing.chapter2.gui.WebBrowserPane;

;

public class WebBrowser extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private ResourceBundle resources;
	private WebToolBar toolBar;
	private WebBrowserPane browserPane;

	// WebBrowser constructor
	public WebBrowser(Locale locale) {
		//System.out.println(locale.toString());
		//System.out.println(getClass().getResource("StringsAndLabels_fr_FR.properties"));
		try{
			resources = ResourceBundle.getBundle("StringsAndLabels", locale);
		}catch(MissingResourceException missingResourceException){
			System.out.println("No resource bundle for the specified base name can be found");
						
		}catch(NullPointerException nullPointerException){
			System.out.println("BaseName or locale is null");
		}

		setTitle(resources.getString("applicationTitle"));

		// create WebBrowserPane and WebToolBar for navigation
		browserPane = new WebBrowserPane();
		toolBar = new WebToolBar(browserPane, locale);
		// lay out WebBrowser components
		Container contentPane = getContentPane();
		contentPane.add(toolBar, BorderLayout.NORTH);
		contentPane.add(new JScrollPane(browserPane), BorderLayout.CENTER);
	}
}
