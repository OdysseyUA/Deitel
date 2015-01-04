// Fig. 8.26: DisplayAuthors.java
// Displaying the contents of table authors in database books.
package com.chapter06.jdbc;
 
// Java core packages
import java.awt.*;
import java.sql.*;
// Java extension packages
import javax.swing.*;

public class DisplayAuthors extends JFrame {
   
	private static final long serialVersionUID = 1L;
	

// constructor connects to database, queries database,
   // processes results and displays results in window
   public DisplayAuthors() 
   {
      super( "Authors Table of Books Database" );
      
      // connect to database books and query database
      try {
         
         // load database driver class
         Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );

         // connect to database
         Connection connection = DriverManager.getConnection(
        	//"jdbc:sqlserver://MACROS\\SQLEXPRESS;user=bh;password=bh;databaseName=books;" );
            "jdbc:sqlserver://localhost:1433;user=bh;password=bh;databaseName=books;" );
         
         //"jdbc:sqlserver://localhost:1433;databaseName=books;integratedSecurity=true;";

         // create Statement to query database
         Statement statement = connection.createStatement();
         
         // query database
         ResultSet resultSet = 
            statement.executeQuery( "SELECT * FROM authors" );
         
         // process query results
         StringBuffer results = new StringBuffer();
         ResultSetMetaData metaData = resultSet.getMetaData();
         int numberOfColumns = metaData.getColumnCount();
         
         for ( int i = 1; i <= numberOfColumns; i++ ) {
            results.append( metaData.getColumnName( i )
               + "\t" );
         }
         
         results.append( "\n" );
         
         while ( resultSet.next() ) {
            
            for ( int i = 1; i <= numberOfColumns; i++ ) {
               results.append( resultSet.getObject( i ) 
                  + "\t" );
            }
            
            results.append( "\n" );
         }
         
         // close statement and connection
         statement.close();
         connection.close();            

         // set up GUI and display window
         JTextArea textArea = new JTextArea( 
            results.toString() );
         Container container = getContentPane();

         container.add( new JScrollPane( textArea ) );
         
         setSize( 300, 100 );  // set window size
         setVisible( true );   // display window
      }  // end try
      
      // detect problems interacting with the database
      catch ( SQLException sqlException ) {
         JOptionPane.showMessageDialog( null, 
            sqlException.getMessage(), "Database Error",
            JOptionPane.ERROR_MESSAGE );
         
         System.exit( 1 );
      }
      
      // detect problems loading database driver
      catch ( ClassNotFoundException classNotFound ) {
         JOptionPane.showMessageDialog( null, 
            classNotFound.getMessage(), "Driver Not Found",
            JOptionPane.ERROR_MESSAGE );

         System.exit( 1 );
      }
   }  // end DisplayAuthors constructor definition
   
   // launch the application
   public static void main( String args[] )
   {
      DisplayAuthors window = new DisplayAuthors();
      
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }
}  // end class DisplayAuthors