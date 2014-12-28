package com.swing.chapter2;

import java.util.*;
import java.net.*;
import java.io.*;

import javax.swing.*;

public class WebBrowserPane extends JEditorPane{	
	
	private static final long serialVersionUID = 1L;
	
	private List<URL> history = new ArrayList<URL>();
	private int historyIndex;
	
	public WebBrowserPane()
	{
		setEditable(false);
	}
	
	//	display given URL and add it to history
	public void goToURL(URL url){
		displayPage(url);
		history.add(url);
		historyIndex = history.size() - 1;
	}

	//	display next history URL in editorPane
	
	
	public URL forward(){
		historyIndex++;
		
		//	do not go past end of history
		if (historyIndex >= history.size())
			historyIndex = history.size() - 1;
		
		URL url = (URL) history.get(historyIndex);
		displayPage(url);
		
		return url;
	}
	
	
	//	display previous history URL in editorPane
	public URL back(){
		historyIndex--;
		
		//	do no go past beginning of history
		if(historyIndex < 0){
			historyIndex = 0;
		}
		
		//	display previous  URL
		URL url = (URL)history.get(historyIndex);
		displayPage(url);
		
		return url;
	}
	
	
	
	
	
	//	display given URL in JEditorPane
	private void displayPage(URL pageURL){
		//	display URL
		try{
			setPage(pageURL);
		}
		//	handle exception reading from URL
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
}
